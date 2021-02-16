package com.idtech;

import com.idtech.block.*;
import com.idtech.entity.*;
import com.idtech.item.*;
import com.idtech.world.ObsidianHillsBiome;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.loading.FMLConfig;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The BaseMod class holds any static variables your mod needs and runs all registry events. You'll add registry lines
 * in this file for all of your block, item, entities, etc. that you add to Minecraft
 */
@Mod(BaseMod.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BaseMod {

    // Change your modid here. Whenever modid is needed, use BaseMod.MODID
    public static final String MODID = "examplemod";
    public static final Logger LOGGER = LogManager.getLogger(BaseMod.MODID);


    /**
     * Registers block during mod setup
     * @param event RegistryEvent to access the block registry
     */
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        LOGGER.info("Registering Blocks");
        // Add block registry calls here.
        // event.getRegistry().register(<block variable>)

        BlockMod.registerBlocks(event);

    }

    /**
     * Registers item during mod setup
     * @param event RegistryEvent to access the item registry
     */
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        LOGGER.info("Registering Items");
        // Add item registry calls here.
        // event.getRegistry.register(<item variable>)

        ItemMod.registerItems(event);
        BlockMod.registerBlockItems(event);
        EntityMod.registerEntityEggs(event);

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
        // also register the entity attributes with:
        // GlobalEntityTypeAttributes.put(<entity type>, <entity attribute method>.func_233813_a_());
        EntityMod.registerEntities(event);
    }

    @SubscribeEvent
    public static void registerBiomes(final RegistryEvent.Register<Biome> event){
        BaseMod.LOGGER.info("Registering Biomes");
        // Add biome registry calls here
        // event.getRegistry.register(<biome variable>)

      //  event.getRegistry().register(ObsidianHillsBiome.INSTANCE);

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
        EntityMod.entityRenderers();
//        RenderingRegistry.registerEntityRenderingHandler(ZomboEntityO.TYPE, ZomboRenderFactory.INSTANCE);
//        RenderingRegistry.registerEntityRenderingHandler(ZomboBearEntity.TYPE, ZomboBearRenderFactory.INSTANCE);


    }



    /**
     * Setup step after all other registry events - if you need to do anything after everything else has loaded, put it here.
     * @param event event info
     */
    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent event){
        // Do any mod setup steps here. Occurs after all registry events.
        // Put biome manager registry blocks here.
        BaseMod.LOGGER.info("Mod Setup Step");
//        BiomeDictionary.addTypes(ObsidianHillsBiome.INSTANCE, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
//        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(ObsidianHillsBiome.INSTANCE, 9000));
//        BiomeManager.addSpawnBiome(ObsidianHillsBiome.INSTANCE);

    }

    /**
     * Adds an entity to the spawn list for a biome
     * @param type the type of entity to add to the list
     */
    public static void addSpawn (EntityType type) {
        for(Biome b : ForgeRegistries.BIOMES){
            if( b != null){
                b.func_235058_a_(type);
            }
        }
    }

}
