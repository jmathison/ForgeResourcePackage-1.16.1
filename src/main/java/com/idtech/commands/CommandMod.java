package com.idtech.commands;

import com.idtech.BaseMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(BaseMod.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class CommandMod {
    //All this class does is let us register the RegisterCommandEvent so that we can register the actual commands later.
    @SubscribeEvent
    public static void setupCommandRegister(FMLCommonSetupEvent event){
        BaseMod.LOGGER.info("Command registration here hopefully.");
        MinecraftForge.EVENT_BUS.register(RegisterCommandEvent.class);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, (RegisterCommandsEvent events) -> RegisterCommandEvent.registerCommands(events));
        //Need to add the RegisterCommandEvent to the bus and add a listener for it.
    }
}
