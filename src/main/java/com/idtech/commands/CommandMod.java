package com.idtech.commands;

import com.idtech.BaseMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(BaseMod.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class CommandMod {

    @SubscribeEvent
    public static void setupCommandRegister(FMLCommonSetupEvent event){
        BaseMod.LOGGER.info("Command registration here hopefully.");
        MinecraftForge.EVENT_BUS.register(RegisterCommandEvent.class);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, (RegisterCommandsEvent events) -> RegisterCommandEvent.registerCommands(events));
    }//Adds the RegisterCommandEvent as an event and sets a listener for it during FMLCommonSetup
}
