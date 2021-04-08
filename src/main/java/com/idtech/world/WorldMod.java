package com.idtech.world;

import net.minecraft.world.biome.Biome;
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
}
