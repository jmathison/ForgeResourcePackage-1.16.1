package com.idtech.world;

import com.idtech.BaseMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
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

@Mod.EventBusSubscriber(modid = BaseMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldGen {

    private static final CountRangeConfig rangeCfg = new CountRangeConfig(5,16,0,32);
        //see genOre doc, this would make 6 veins in a chunk from y=16 to y=48
    private static final int veinSize = 4;
        //number of blocks generated in each of your block's veins
    private static BlockState blockToGenerate = Blocks.EMERALD_BLOCK.getDefaultState(); // <-- Replace this value with your own custom block or ore!

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {    //for all biomes, including modded biomes

            //Nether Generation
            if (biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NETHER) {     //conditional only permits overworld spawning
                genOre(biome, rangeCfg, OreFeatureConfig.FillerBlockType.NATURAL_STONE, blockToGenerate, veinSize);
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