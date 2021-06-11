package com.idtech.commands;

import com.idtech.BaseMod;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Collection;

@Mod.EventBusSubscriber
public class JailCommand {

    public static class JailStruct{
        Entity e;
        int counter = 100;
        double origX;
        double origY;
        double origZ;
        BlockPos[] blocksToChangeBack;
    }//A struct to hold data about each entity being jailed

    static ArrayList<JailStruct> jailArray = new ArrayList<JailStruct>();

    public static void register(CommandDispatcher<CommandSource> dispatcher){
        LiteralArgumentBuilder<CommandSource> storyCommand = Commands.literal("jail").requires((source) -> source.hasPermissionLevel(1))
                .then(Commands.argument("targets", EntityArgument.entities()).then(Commands.argument("time", DoubleArgumentType.doubleArg()).executes((context) -> {return doJailing(context.getSource(), EntityArgument.getEntities(context, "targets"), DoubleArgumentType.getDouble(context, "time"));})));
        dispatcher.register(storyCommand);
        //This command takes in any number of entities as well as the time in seconds to jail them for.
    }
    public static int doJailing(CommandSource source, Collection<? extends Entity> targets, double timeTobeJailed){
        for (Entity e : targets){
            JailStruct newStruct = new JailStruct();
            newStruct.origY = e.getPosY();
            newStruct.origZ = e.getPosZ();
            newStruct.origX = e.getPosX();
            newStruct.counter = (int)(timeTobeJailed*20);
            newStruct.e = e;
            //For each entity in the command, create and hold data about it which we'll store in the array.

            BlockPos[] blocksToChange = {
                    new BlockPos(e.getPosX(), 99, e.getPosZ()),
                    new BlockPos(e.getPosX(), 102, e.getPosZ()),
                    new BlockPos(e.getPosX()+1, 100, e.getPosZ()),
                    new BlockPos(e.getPosX()+1, 101, e.getPosZ()),
                    new BlockPos(e.getPosX()-1, 100, e.getPosZ()),
                    new BlockPos(e.getPosX()-1, 101, e.getPosZ()),
                    new BlockPos(e.getPosX(), 100, e.getPosZ()+1),
                    new BlockPos(e.getPosX(), 101, e.getPosZ()+1),
                    new BlockPos(e.getPosX(), 100, e.getPosZ()-1),
                    new BlockPos(e.getPosX(), 101, e.getPosZ()-1)
            };
            newStruct.blocksToChangeBack = blocksToChange;
            jailArray.add(newStruct);

            for (BlockPos pos : blocksToChange){
                e.getEntityWorld().setBlockState(pos, Blocks.BEDROCK.getDefaultState());//Change the blocks to make a bedrock jail at y=100
            }
            double quickMafX;
            double quickMafZ;

            if (e.getPosX() < 0){
                quickMafX = ((int)e.getPosX())-0.5;
            }
            else{
                quickMafX = ((int)e.getPosX())+0.5;
            }

            if (e.getPosZ() < 0){
                quickMafZ = ((int)e.getPosZ())-0.5;
            }
            else{
                quickMafZ = ((int)e.getPosZ())+0.5;
            }
            //We have to find the middle of the block the player is currently on, which is not an integer coordinate position

            if (e instanceof PlayerEntity){
                Minecraft.getInstance().player.setPosition(quickMafX, 100.0d, quickMafZ);
            }//Sorry, this is ugly, but I swear the player wouldn't teleport any other way I tried it.
            e.setPosition(quickMafX, 100.0d, quickMafZ);


        }
        return 1;
    }


    @SubscribeEvent
    public static void onTickEvent(TickEvent.ClientTickEvent event){
        for (int i = 0; i < jailArray.size(); i++){//Every tick loop through the array and see if someone needs to be unjailed.
            JailStruct j = jailArray.get(i);
            Entity e = j.e;
            j.counter--;
            if (j.counter == 0){//If their time is up, we should unjail them, teleporting them back to their original position and deleting the jail.
                BaseMod.LOGGER.info("Should be changing things back.");
                for (BlockPos pos : j.blocksToChangeBack){
                    e.getEntityWorld().setBlockState(pos, Blocks.AIR.getDefaultState());
                }
                if (e instanceof PlayerEntity){
                    Minecraft.getInstance().player.setPosition(j.origX, j.origY, j.origZ);
                }
                e.setPosition(j.origX, j.origY, j.origZ);

                jailArray.remove(i);
                i--;
            }
        }
    }
}
