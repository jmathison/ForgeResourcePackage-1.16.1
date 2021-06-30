package com.idtech.entity;

import com.google.common.collect.Lists;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

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

    /**
     * Spawns Mobs/Creatures into all biomes
     * @param entityType Entity
     * @param classification Entity type (Creature/Monster/etc)
     * @param weight The randomness weight
     * @param min minimum entity count per group
     * @param max maximum entity count per group
     */
    protected static void spawnMobs(EntityType<?> entityType, EntityClassification classification, int weight, int min, int max) {
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
    protected static void spawnMobsIn(EntityType<?> entityType, EntityClassification classification, int weight, int min, int max, Biome... biomesIn) {
        List<Biome> list = Lists.newArrayList(biomesIn);
        ForgeRegistries.BIOMES.getValues().stream().filter(biome -> list.contains(biome)).forEach(biome -> {
            biome.getSpawns(classification).add(new Biome.SpawnListEntry(entityType, weight, min, max));
        });
    }

}
