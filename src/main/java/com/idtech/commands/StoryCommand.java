package com.idtech.commands;

import com.idtech.BaseMod;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Mod.EventBusSubscriber
public class StoryCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher){
        LiteralArgumentBuilder<CommandSource> storyCommand = Commands.literal("story").requires((source) -> source.hasPermissionLevel(1))
                .then(Commands.literal("bee").executes(context -> tellStory(context, Stories.BEE_MOVIE.stories))
                ).then(Commands.literal("fitness").executes(context -> tellStory(context, Stories.FITNESSGRAM_PACER_TEST.stories)))
                .then(Commands.literal("stop").executes(context -> stopStory()));
        dispatcher.register(storyCommand);
        //I know the above syntax looks terrible. Don't worry, it feels terrible too. But this is how you build commands, with a nest of
        //.then and .execute functions
    }

    static int stopStory(){
        partOfStory = statStory.length;
        counter = -1;
        return 1;
    }
    //Turns out most people don't want to have the ENTIRE bee movie play in chat forever, so this stops whichever story is being told.

    static int tellStory(CommandContext<CommandSource> context, String[] storyChoice) {
        if (counter != -1){
            TranslationTextComponent text = new TranslationTextComponent("chat.type.announcement", statContext.getSource().getDisplayName(), new StringTextComponent("WAIT UNTIL I'M FINISHED WITH THIS ONE FIRST!"));
            statContext.getSource().getServer().getPlayerList().func_232641_a_(text, ChatType.CHAT, statContext.getSource().getEntity().getUniqueID());
            counter = 200;
            return 1;
        }
        statStory = storyChoice;
        partOfStory = 0;
        counter = 1;
        statContext = context;
        return 1;
    }
    //This tellStory function sets some of the class variables so that we can use them later when the TickEvent fires
    //I wanted to put a delay between each section of the story that was being told and Thread.sleep does terrible things

    static void storyHelper(String storyFragment){
        TranslationTextComponent text = new TranslationTextComponent("chat.type.announcement", statContext.getSource().getDisplayName(), new StringTextComponent(storyFragment));
        statContext.getSource().getServer().getPlayerList().func_232641_a_(text, ChatType.CHAT, statContext.getSource().getEntity().getUniqueID());
    }
    //This function is what actually puts the story in chat, using func_232641_a_ which is just the "send message in chat" function.

    static int counter = -1;
    static String[] statStory = {};
    static int partOfStory = 0;
    static CommandContext<CommandSource> statContext;
    //Class variables to keep track of where we are in our current story

    @SubscribeEvent
    public static void onTickEvent(TickEvent.ClientTickEvent event){
        if (counter > 0){
            //BaseMod.LOGGER.info("Counter = "+counter);
            counter--;
            if (counter==0){
                storyHelper(statStory[partOfStory]);
                partOfStory++;
                if (partOfStory != statStory.length){
                    counter = 70;
                }
                else{
                    counter = -1;
                }
            }
        }
    }
    //This function triggers every tick and makes sure there is adequate delay between story fragments.
    enum Stories{
        BEE_MOVIE(scriptMaker("../src/main/resources/data/examplemod/stories/bee.txt")),

        FITNESSGRAM_PACER_TEST(scriptMaker("../src/main/resources/data/examplemod/stories/fitness.txt"));
        //Find the .txt files so we can read from them.
        Stories(String [] stories){
            this.stories = stories;
        }
        private String [] stories;
    }

    public static String[] scriptMaker(String path){
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            String bigString = "";
            while ((st = br.readLine()) != null) {
                bigString += st + "-";
            }
            String[] script = bigString.split("-");
            return script;
        }
        //Read in the file and separate its lines into an array.
        catch (Exception e){
            return new String[] {"Story machine broke"};
            //If we fail to do any of that for any reason, then story machine breaks.
        }
    }
}
