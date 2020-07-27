package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.World;
import org.apache.commons.lang3.ObjectUtils;

import java.lang.reflect.InvocationTargetException;

public class EntityUtils {

    /**
     * Under construction.
     * @return Built entitytype variable from Entity
     */
//    public static EntityType<? extends Entity> buildEntityType(EntityType.IFactory entityConstructor, EntityClassification classification, String registryName){
//        return  EntityType.Builder.create(entityConstructor, classification).build(registryName).setRegistryName(BaseMod.MODID, registryName);
//    }

    /**
     *  Returns a spawn egg item
     * @param type
     * @param primaryColor
     * @param secondaryColor
     * @return
     */
    public static Item buildEntitySpawnEgg(EntityType type, int primaryColor, int secondaryColor){
        return new SpawnEggItem(type, primaryColor, secondaryColor, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(type.getRegistryName() + "_egg");
    }

}
