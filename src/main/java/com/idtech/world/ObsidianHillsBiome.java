package com.idtech.world;

import com.idtech.entity.ZomboEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ObsidianHillsBiome extends Biome {
    public static Biome INSTANCE = new ObsidianHillsBiome(new Builder()
            .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.OBSIDIAN.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.STONE.getDefaultState()))
            .precipitation(RainType.RAIN)
            .category(Biome.Category.DESERT)
            .depth(0.6f)
            .scale(0.9F)
            .temperature(2.0F)
            .downfall(0.2F)
            .func_235097_a_((new BiomeAmbience.Builder()).func_235246_b_(4159204).func_235248_c_(329011).func_235239_a_(12638463).func_235243_a_(MoodSoundAmbience.field_235027_b_).func_235238_a_()).parent((String) null)
    ).setRegistryName("obsidian_hills");

    protected ObsidianHillsBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addDesertLakes(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addDeadBushes(this);
        DefaultBiomeFeatures.addMushrooms(this);
        DefaultBiomeFeatures.addExtraReedsPumpkinsCactus(this);
        DefaultBiomeFeatures.addSprings(this);
        DefaultBiomeFeatures.addDesertFeatures(this);
        DefaultBiomeFeatures.addFreezeTopLayer(this);
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(ZomboEntity.TYPE, 25, 1, 3));

    }
}
