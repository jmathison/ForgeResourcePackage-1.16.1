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
}
