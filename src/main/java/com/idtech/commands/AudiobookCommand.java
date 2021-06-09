package com.idtech.commands;

import com.idtech.BaseMod;
import com.idtech.SoundHandler;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;

public class AudiobookCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher){
        LiteralArgumentBuilder<CommandSource> audioCommand = Commands.literal("audiobook").requires((source) -> source.hasPermissionLevel(1))
                .then(Commands.literal("fitness").executes(context -> listenStory(context, SoundHandler.fitness)))
                .then(Commands.literal("bee").executes(context -> listenStory(context, SoundHandler.bee)));
        dispatcher.register(audioCommand);
        //Similar command structure, but this one looks a bit simpler.
    }
    public static int listenStory(CommandContext<CommandSource> context, SoundEvent event){

        Entity entity = context.getSource().getEntity();
        Minecraft.getInstance().world.playSound(entity.getPosX(),entity.getPosY(),entity.getPosZ(),event, SoundCategory.MASTER,10f,1,false);
        //For whatever reason, playing the sound to the world from the entity didn't work so well, so we're just getting one from getInstance
        return 1;
    }
}
