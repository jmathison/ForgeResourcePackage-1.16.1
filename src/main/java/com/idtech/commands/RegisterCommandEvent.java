package com.idtech.commands;

import com.idtech.BaseMod;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(BaseMod.MODID)
@Mod.EventBusSubscriber(modid = BaseMod.MODID)
public class RegisterCommandEvent {
    static int register = 0;
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event){
        if (register==0) {
            BaseMod.LOGGER.info("Registering Commands");
            CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
            JailCommand.register(dispatcher);
            register=1;
        }//Registers the JailCommand during the RegisterCommandsEvent
    }
}
