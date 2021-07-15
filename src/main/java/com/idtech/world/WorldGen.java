package com.idtech.world;

import com.idtech.BaseMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber(modid = BaseMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldGen {


    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {    //for all biomes, including modded biomes

            CountRangeConfig rangeCfg = new CountRangeConfig(5,16,0,32);
            //see genOre doc, this would make 6 veins in a chunk from y=16 to y=48
            int veinSize = 4;
            //number of blocks generated in each of your block's veins
            BlockState blockToGenerate = Blocks.EMERALD_BLOCK.getDefaultState(); // <-- Replace this value with your own custom block or ore!
            BlockState blockToGenerate2 = Blocks.COAL_BLOCK.getDefaultState();
            BlockState blockToGenerate3 = Blocks.IRON_BLOCK.getDefaultState();

            // to generate in all biomes:
            genOreInAllBiomes(blockToGenerate, rangeCfg, veinSize);

            // to generate in only select biomes
            genOreInBiomes(blockToGenerate2, rangeCfg, veinSize, Biomes.BADLANDS, Biomes.JUNGLE);

            // to generate except in select biomes
            genOreInBiomesExcept(blockToGenerate3, rangeCfg, veinSize, Biomes.BEACH, Biomes.BIRCH_FOREST);
        }
    }

    /**
     * Generates ore in all biomes
     * @param block     The ore
     * @param rangeCfg  CountRangeConfig object that has: number of veins, offset from bottom of biome (y=0), offset from top of biome, and max height above bottomOffset
     * @param veinSize  Size of vein
     */
    private static void genOreInAllBiomes(BlockState block, CountRangeConfig rangeCfg, int veinSize) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            // No end/nether generation
            if (biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NETHER) {     //conditional only permits overworld spawning
                genOre(biome, rangeCfg, OreFeatureConfig.FillerBlockType.NATURAL_STONE, block, veinSize);
            }
        }
    }

    /**
     * Generates ore in select biomes
     * @param block        The ore
     * @param rangeConfig  CountRangeConfig object that has: number of veins, offset from bottom of biome (y=0), offset from top of biome, and max height above bottomOffset
     * @param veinSize     Size of vein
     * @param biomes       List of biomes to generate ore in. This is a parameter list, each biome is a seperate parameter (ex: genOreInBiomes(..., Biomes.HILLS, Biomes.GRASSLANDS))
     */
    private static void genOreInBiomes(BlockState block, CountRangeConfig rangeConfig, int veinSize, Biome... biomes) {
        List<Biome> biomeList = Arrays.asList(biomes);
        genOreInBiomes(block, rangeConfig, veinSize, biomeList);
    }

    /**
     * Generates ore in select biomes
     * @param block        The ore
     * @param rangeConfig  CountRangeConfig object that has: number of veins, offset from bottom of biome (y=0), offset from top of biome, and max height above bottomOffset
     * @param veinSize     Size of vein
     * @param biomes       List of biomes to generate ore in.
     */
    private static void genOreInBiomes(BlockState block, CountRangeConfig rangeConfig, int veinSize, List<Biome> biomes) {
        biomes.forEach(biome -> {
            genOre(biome, rangeConfig, OreFeatureConfig.FillerBlockType.NATURAL_STONE, block, veinSize);
        });
    }

    /**
     * Generates ore except in select biomes
     * @param block        The ore
     * @param rangeConfig  CountRangeConfig object that has: number of veins, offset from bottom of biome (y=0), offset from top of biome, and max height above bottomOffset
     * @param veinSize     Size of vein
     * @param biomes       List of biomes to generate ore in. This is a parameter list, each biome is a seperate parameter (ex: genOreInBiomes(..., Biomes.HILLS, Biomes.GRASSLANDS))
     */
    private static void genOreInBiomesExcept(BlockState block, CountRangeConfig rangeConfig, int veinSize, Biome... biomes) {
        List<Biome> biomeList = Arrays.asList(biomes);
        genOreInBiomesExcept(block, rangeConfig, veinSize, biomeList);
    }

    /**
     * Generates ore except in select biomes
     * @param block        The ore
     * @param rangeConfig  CountRangeConfig object that has: number of veins, offset from bottom of biome (y=0), offset from top of biome, and max height above bottomOffset
     * @param veinSize     Size of vein
     * @param biomes       List of biomes to generate ore in.
     */
    private static void genOreInBiomesExcept(BlockState block, CountRangeConfig rangeConfig, int veinSize, List<Biome> biomes) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            // No end/nether generation
            if (!biomes.contains(biome)) {     //conditional only permits overworld spawning
                genOre(biome, rangeConfig, OreFeatureConfig.FillerBlockType.NATURAL_STONE, block, veinSize);
            }
        }
    }

    /** genOre Method creates ore chunks that are added to a biome
     * @param biome                 The biome to add ore to
     * @param cfg                   CountRangeConfig object that has: number of veins, offset from bottom of biome (y=0), offset from top of biome, and max height above bottomOffset
     * @param filler                Block type for all blocks surrounding vein
     * @param defaultBlockstate     Block that is being generated
     * @param size                  Size of vein
     */
    private static void genOre(Biome biome, CountRangeConfig cfg, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);   //sets vein as a feature to add
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(cfg);                  //configures feature placement using CountRangeConfig values
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));    // adds configured feature to biome
    }
}