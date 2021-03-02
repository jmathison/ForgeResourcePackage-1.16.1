package com.idtech.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityMod {

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){


    }
    @SubscribeEvent
    public static void registerEntityEggs(final RegistryEvent.Register<Item> event) {

    }

    public static void entityRenderers(){


    }

}
