package com.idtech.world;

import com.idtech.block.BlockMod;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;

public class WorldMod {

    public static void registerBiomes(final RegistryEvent.Register<Biome> event){
        event.getRegistry().register(ObsidianHillsBiome.INSTANCE);

    }
    public static void setupBiomes(){
        BiomeDictionary.addTypes(ObsidianHillsBiome.INSTANCE, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(ObsidianHillsBiome.INSTANCE, 500));
        BiomeManager.addSpawnBiome(ObsidianHillsBiome.INSTANCE);

    }

    public static void registerBiomeFeatures() {
        // vein size 10, count per generation 20, max y level 64
        // modify above numbers to suit your needs
        // this will only work on newly generated chunks, so best way to test is to make a new world or to teleport FAR FAR AWAY in your current world
        // Does not spawn in Nether or end
        WorldUtils.generateBiomeFeatures(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockMod.GEL_ORE_BLOCK.getDefaultState(), 10))
                        .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))),
                true, false, false);
    }
}
