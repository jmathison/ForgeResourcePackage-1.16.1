package com.idtech;

import com.idtech.block.*;
import com.idtech.entity.ZomboBearEntity;
import com.idtech.entity.ZomboEntity;
import com.idtech.entity.ZomboRenderFactory;
import com.idtech.item.*;
import com.idtech.world.ObsidianHillsBiome;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
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

    //BASIC BLOCKS
    public static final Block basicBlock = BlockUtils.createBasicBlock("basic_block", Material.ROCK, 0.5f, 0.9f, ToolType.PICKAXE);
    public static final Item basicBlockItem = BlockUtils.createBlockItem(basicBlock, ItemGroup.MISC);

    public static final Block basicOreBlock = BlockUtils.createBasicBlock("basic_ore_block", Material.ROCK, 0.5f, 0.6f, ToolType.PICKAXE);
    public static final Item basicOreBlockItem = BlockUtils.createBlockItem(basicOreBlock, ItemGroup.MISC);

    //BASIC ITEMS
//    public static final Item structureGel = ItemUtils.buildBasicItem("structuregel", ItemGroup.MISC);
//    public static final Item basicOre = ItemUtils.buildBasicItem("basicore", ItemGroup.MISC);




    /**
     * Registers block during mod setup
     * @param event RegistryEvent to access the block registry
     */
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        LOGGER.info("Registering Blocks");
        // Add block registry calls here.
        // event.getRegistry().register(<block variable>)

        event.getRegistry().register(basicBlock);
        event.getRegistry().register(basicOreBlock);
        event.getRegistry().register(CoolStoneBlock.INSTANCE);
        event.getRegistry().register(RubberBlock.INSTANCE);
        event.getRegistry().register(CreeperSupriseBlock.INSTANCE);
        event.getRegistry().register(CreepingMoldBlock.INSTANCE);



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

        //Basic Items
//        event.getRegistry().register(structureGel);
//        event.getRegistry().register(basicOre);
        BasicItems.registerItems(event);

        //Items
        event.getRegistry().register(FireWandItem.INSTANCE);
        event.getRegistry().register(LightningHammerItem.INSTANCE);
        event.getRegistry().register(TeleportRodItem.INSTANCE);
        event.getRegistry().register(CoolSwordItem.INSTANCE);
        event.getRegistry().register(ZooSwordItem.INSTANCE);
        event.getRegistry().register(SheepMagicWand.INSTANCE);
        event.getRegistry().register(SqueakyBallItem.INSTANCE);

        //Armor
        event.getRegistry().register(CustomArmorItem.HELM);
//        event.getRegistry().register(CustomArmorItem.CHEST);
//        event.getRegistry().register(CustomArmorItem.LEGS);
//        event.getRegistry().register(CustomArmorItem.BOOTS);


        //eggs
        event.getRegistry().register(ZomboEntity.EGG);
        event.getRegistry().register(ZomboBearEntity.EGG);


        // Add block registry item calls here
        event.getRegistry().register(basicBlockItem);
        event.getRegistry().register(basicOreBlockItem);

        event.getRegistry().register(CoolStoneBlock.ITEM);
        event.getRegistry().register(RubberBlock.ITEM);
        event.getRegistry().register(CreeperSupriseBlock.ITEM);
        event.getRegistry().register(CreepingMoldBlock.ITEM);
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
        event.getRegistry().register(ZomboEntity.TYPE);
        GlobalEntityTypeAttributes.put(ZomboEntity.TYPE, ZomboEntity.setupAttributes().func_233813_a_());
        event.getRegistry().register(ZomboBearEntity.TYPE);
        GlobalEntityTypeAttributes.put(ZomboBearEntity.TYPE, ZomboBearEntity.setupAttributes().func_233813_a_());
    }

    @SubscribeEvent
    public static void registerBiomes(final RegistryEvent.Register<Biome> event){
        BaseMod.LOGGER.info("Registering Biomes");
        // Add biome registry calls here
        // event.getRegistry.register(<biome variable>)

        event.getRegistry().register(ObsidianHillsBiome.INSTANCE);
        BiomeDictionary.addTypes(ObsidianHillsBiome.INSTANCE, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(ObsidianHillsBiome.INSTANCE, 900));
        BiomeManager.addSpawnBiome(ObsidianHillsBiome.INSTANCE);

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
        RenderingRegistry.registerEntityRenderingHandler(ZomboEntity.TYPE, ZomboRenderFactory.INSTANCE);

    }


    /**
     * Setup step after all other registry events - if you need to do anything after everything else has loaded, put it here.
     * @param event event info
     */
    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent event){
        // Do any mod setup steps here. Occurs after all registry events.
        // Put biome manager registry stuff here.
        BaseMod.LOGGER.info("Mod Setup Step");

    }

    /**
     * adds an entity to the spawn list for a biome
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
