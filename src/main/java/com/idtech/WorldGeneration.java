package com.idtech;
import com.google.common.collect.Lists;
import com.idtech.block.BlockMod;
import com.idtech.entity.ExplodingPigEntity;
import com.idtech.entity.ZomboBearEntity;
import com.idtech.entity.ZomboEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * World generation
 * @author afroraydude (Ray "Stitch" Thomas)
 */
public class WorldGeneration {

    private static Stream<Biome> biomes;

    public static void applyBiomeFeatures() {
        biomes = getDifferentBiomes();


        // only in certain biomes

        // this commented out example uses emerald ore as its template
        // generateFeatures(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), BlockMod.GEL_ORE_BLOCK.getDefaultState())).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)), Biomes.BADLANDS);

        // in all biomes

        // this commented out example uses emerald ore as its template
        //generateFeaturesInAllBiomes(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), BlockMod.GEL_ORE_BLOCK.getDefaultState())).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

        // this example does not
        // vein size 10, count per generation 20, max y level 64
        // modify above numbers to suit your needs
        // this will only work on newly generated chunks, so best way to test is to make a new world or to teleport FAR FAR AWAY in your current world
        generateFeaturesInAllBiomes(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockMod.GEL_ORE_BLOCK.getDefaultState(), 10)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
    }

    public static void spawnEntities() {
        spawnMobsInAllBiomes(ZomboEntity.TYPE, EntityClassification.MONSTER, 10, 1, 4);
        spawnMobsInAllBiomes(ZomboBearEntity.TYPE, EntityClassification.MONSTER, 8, 1, 1);
        spawnMobsInAllBiomes(ExplodingPigEntity.TYPE, EntityClassification.CREATURE, 10, 1, 4);
    }

    protected static void generateFeatures(GenerationStage.Decoration stageIn, ConfiguredFeature<?, ?> featureIn, Biome... biomesIn) {
        for(Biome biome : biomesIn) biome.addFeature(stageIn, featureIn);
    }

    protected static void generateFeaturesExcept(GenerationStage.Decoration stageIn, ConfiguredFeature<?, ?> featureIn, Biome... biomesIn) {
        List<Biome> list = Lists.newArrayList(biomesIn);
        biomes.filter(biome -> !list.contains(biome)).forEach(biome -> biome.addFeature(stageIn, featureIn));
    }

    /**
     * Generates features in all biomes, we use this for ore generation
     * @param stageIn
     * @param featureIn
     */
    protected static void generateFeaturesInAllBiomes(GenerationStage.Decoration stageIn, ConfiguredFeature<?, ?> featureIn) {
        biomes.forEach(biome -> biome.addFeature(stageIn, featureIn));
    }

    private static Stream<Biome> getDifferentBiomes() {
        return ForgeRegistries.BIOMES.getValues().stream().filter(biome -> !biome.getRegistryName().getNamespace().equals(BaseMod.MODID));
    }

    /**
     * Spawns Mobs/Creatures into all biomes
     * @param entityType Entity
     * @param classification Entity type (Creature/Monster/etc)
     * @param weight The randomness weight
     * @param min minimum entity count per group
     * @param max maximum entity count per group
     */
    protected static void spawnMobsInAllBiomes(EntityType<?> entityType, EntityClassification classification, int weight, int min, int max) {
        ForgeRegistries.BIOMES.getValues().stream().forEach(biome -> {
            biome.getSpawns(classification).add(new Biome.SpawnListEntry(entityType, weight, min, max));
        });
    }

    /**
     * Spawns Mobs/Creatures into specific biomes
     * @param entityType Entity
     * @param classification Entity type (Creature/Monster/etc)
     * @param weight The randomness weight
     * @param min minimum entity count per group
     * @param max maximum entity count per group
     * @param biomesIn List of biomes
     */
    protected static void spawnMobs(EntityType<?> entityType, EntityClassification classification, int weight, int min, int max, List<Biome> biomesIn) {
        ForgeRegistries.BIOMES.getValues().stream().filter(biome -> biomesIn.contains(biome)).forEach(biome -> {
            biome.getSpawns(classification).add(new Biome.SpawnListEntry(entityType, weight, min, max));
        });
    }
}