package com.idtech.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityMod {

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){

        event.getRegistry().register(ZomboEntity.TYPE);
        GlobalEntityTypeAttributes.put(ZomboEntity.TYPE, ZomboEntity.setupAttributes().func_233813_a_());

        event.getRegistry().register(ZomboBearEntity.TYPE);
        GlobalEntityTypeAttributes.put(ZomboBearEntity.TYPE, ZomboBearEntity.setupAttributes().func_233813_a_());

        event.getRegistry().register(ExplodingPigEntity.TYPE);
        GlobalEntityTypeAttributes.put(ExplodingPigEntity.TYPE, ExplodingPigEntity.setupAttributes().func_233813_a_());

        event.getRegistry().register(TestSheepEntity.TYPE);
        GlobalEntityTypeAttributes.put(TestSheepEntity.TYPE, TestSheepEntity.func_234225_eI_().func_233813_a_());

        event.getRegistry().register(ExampleBlockBenchEntity.TYPE);
        GlobalEntityTypeAttributes.put(ExampleBlockBenchEntity.TYPE, ExampleBlockBenchEntity.setupAttributes().func_233813_a_());

        EntityUtils.spawnMobs(ZomboEntity.TYPE, EntityClassification.MONSTER, 10, 1, 4);
        EntityUtils.spawnMobsIn(ZomboBearEntity.TYPE, EntityClassification.MONSTER, 10, 1, 1, Biomes.FROZEN_OCEAN, Biomes.SNOWY_TUNDRA, Biomes.SNOWY_MOUNTAINS, Biomes.ICE_SPIKES);
        EntityUtils.spawnMobs(ExplodingPigEntity.TYPE, EntityClassification.CREATURE, 10, 1, 4);
        EntityUtils.spawnMobs(ExampleBlockBenchEntity.TYPE, EntityClassification.CREATURE, 10, 1, 4);
        EntityUtils.spawnMobs(TestSheepEntity.TYPE, EntityClassification.CREATURE, 10, 1, 4);
    }

    @SubscribeEvent
    public static void registerEntityEggs(final RegistryEvent.Register<Item> event){

        event.getRegistry().register(ZomboEntity.EGG);
        event.getRegistry().register(ZomboBearEntity.EGG);
        event.getRegistry().register(ExplodingPigEntity.EGG);
        event.getRegistry().register(TestSheepEntity.EGG);
        event.getRegistry().register(ExampleBlockBenchEntity.EGG);
    }

    public static void entityRenderers(){

        RenderingRegistry.registerEntityRenderingHandler(ZomboEntity.TYPE, ZomboRenderFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(ZomboBearEntity.TYPE, ZomboBearRenderFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(ExplodingPigEntity.TYPE, ExplodingPigRenderFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(TestSheepEntity.TYPE, TestSheepRenderFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(ExampleBlockBenchEntity.TYPE, ExampleBlockBenchRenderFactory.INSTANCE);
    }

}
