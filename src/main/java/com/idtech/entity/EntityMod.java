package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class EntityMod {

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){
        event.getRegistry().register(ZomboEntity.TYPE);
        GlobalEntityTypeAttributes.put(ZomboEntity.TYPE, ZomboEntity.setupAttributes().func_233813_a_());
        event.getRegistry().register(ZomboBearEntity.TYPE);
        GlobalEntityTypeAttributes.put(ZomboBearEntity.TYPE, ZomboBearEntity.setupAttributes().func_233813_a_());
    }

    public static void entityRenderers(){

        RenderingRegistry.registerEntityRenderingHandler(ZomboBearEntity.TYPE, ZomboBearRenderFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(ZomboEntity.TYPE, ZomboRenderFactory.INSTANCE);

    }

}
