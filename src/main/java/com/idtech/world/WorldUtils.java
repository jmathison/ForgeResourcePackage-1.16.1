package com.idtech.world;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;

public class WorldUtils {

    private static Collection<Biome> biomes;

    private static void loadAllBiomes() {
        biomes = ForgeRegistries.BIOMES.getValues();
    }

    /**
     * Generates features in all biomes, we use this for ore generation
     * @param generationStage
     * @param feature
     * @param inWorld True if you want to spawn in world, false otherwise
     * @param inNether True if you want to spawn in Nether, false otherwise
     * @param inEnd True if you want to spawn in the End, false otherwise
     */
    public static void generateBiomeFeatures(GenerationStage.Decoration generationStage, ConfiguredFeature<?, ?> feature,
    boolean inWorld, boolean inNether, boolean inEnd) {
        loadAllBiomes();
        biomes.forEach(biome -> {
            // spawn in nether if told
            if (biome.getCategory().equals(Biome.Category.NETHER) && inNether)
                biome.addFeature(generationStage, feature);
            // spawn in the end if told
            if (biome.getCategory().equals(Biome.Category.THEEND) && inEnd)
                biome.addFeature(generationStage, feature);
            // spawn in world if told
            if (!biome.getCategory().equals(Biome.Category.THEEND) &&
                    !biome.getCategory().equals(Biome.Category.NETHER) &&
                    inWorld)
                biome.addFeature(generationStage, feature);
        });
    }


}
