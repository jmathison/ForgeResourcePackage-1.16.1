package com.idtech.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

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
        //createJSONFile(type.getName().toString());
        return new SpawnEggItem(type, primaryColor, secondaryColor, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(type.getRegistryName() + "_egg");
    }
    public static AttributeModifierMap.MutableAttribute addAttributes(boolean isZombie, double maxHealth, double followRange, double knockbackResistance, double movementSpeed, double attackDamage, int armor, int armorToughness){
        AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();

        if(maxHealth > 0){
            ammma.func_233815_a_(Attributes.field_233818_a_, maxHealth);
        }
        if(followRange > 0){
            ammma.func_233815_a_(Attributes.field_233819_b_, followRange);
        }
        if(knockbackResistance >0){
            ammma.func_233815_a_(Attributes.field_233820_c_, knockbackResistance);
        }
        if(movementSpeed > 0){
            ammma.func_233815_a_(Attributes.field_233821_d_, movementSpeed);
        }
        if(attackDamage>0){
            ammma.func_233815_a_(Attributes.field_233823_f_, attackDamage);
        }
        if(armor>0){
            ammma.func_233815_a_(Attributes.field_233826_i_, armor);
        }
        if(armorToughness>0){
            ammma.func_233815_a_(Attributes.field_233827_j_, armorToughness);
        }
        if(isZombie){
            ammma.func_233814_a_(Attributes.field_233829_l_);
        }

        return ammma;

    }

    public static AttributeModifierMap.MutableAttribute addAttributes(boolean isZombie){

        if(isZombie){
            return MobEntity.func_233666_p_().func_233814_a_(Attributes.field_233823_f_).func_233814_a_(Attributes.field_233829_l_);
        }else{
            return MobEntity.func_233666_p_().func_233814_a_(Attributes.field_233823_f_);
        }

    }

}
