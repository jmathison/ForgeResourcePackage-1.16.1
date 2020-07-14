package com.idtech;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The BaseMod class holds any static variables your mod needs and runs all registry events. You'll add registry lines
 * in this file for all of your blocks, items, entities, etc. that you add to Minecraft
 */
@Mod(BaseMod.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BaseMod {

    // Change your modid here. Whenever modid is needed, use BaseMod.MODID
    public static final String MODID = "testmod";
    public static final Logger LOGGER = LogManager.getLogger(BaseMod.MODID);

    /**
     * Registers blocks during mod setup
     * @param event RegistryEvent to access the block registry
     */
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        LOGGER.info("Registering Blocks");
        // Add block registry calls here.
        // event.getRegistry().register(<block variable>)

    }

    /**
     * Registers items during mod setup
     * @param event RegistryEvent to access the item registry
     */
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        LOGGER.info("Registering Items");
        // Add item registry calls here.
        // event.getRegistry.register(<item variable>)

        // Add block registry item calls here

    }

    /**
     * Registers entities during mod setup
     * @param event RegistryEvent to access the entity registry
     */
    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){
        BaseMod.LOGGER.info("Registering Entities");
        // Add item registry calls here.
        // event.getRegistry.register(<entity type>)

    }

    /**
     * Client-side setup - register renderers here.
     * @param event event variable with client setup info
     */
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        BaseMod.LOGGER.info("Client Setup Step");
        // Add rendering registry entries here.
        // RenderingRegistry.registerEntityRenderingHandler(<entity type>, <render factory>);

    }


    /**
     * Setup step after all other registry events - if you need to do anything after everything else has loaded, put it here.
     * @param event event info
     */
    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent event){
        // Do any mod setup steps here. Not clear yet what should actually be here. Occurs after all registry events.
        BaseMod.LOGGER.info("Mod Setup Step");
    }



}
