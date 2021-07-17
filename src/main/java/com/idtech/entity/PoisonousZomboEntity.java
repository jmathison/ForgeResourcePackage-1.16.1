package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class PoisonousZomboEntity extends ZomboEntity {
    //TYPE
    public static EntityType<PoisonousZomboEntity> TYPE = (EntityType<PoisonousZomboEntity>)
            EntityType.Builder.create(PoisonousZomboEntity::new, EntityClassification.MONSTER).build("poison_zombo").setRegistryName(BaseMod.MODID, "poison_zombo");
    //EGG
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xb00101, 0xacb00f);


    public PoisonousZomboEntity(World worldIn) {
        super(worldIn);
    }

    public PoisonousZomboEntity(EntityType type, World worldIn) {
        super(type, worldIn);
    }


    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (entityIn instanceof LivingEntity) { // if entity is alive
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.POISON, 20, 1)); // give poison effect
        }

        return super.attackEntityAsMob(entityIn);
    }
}
