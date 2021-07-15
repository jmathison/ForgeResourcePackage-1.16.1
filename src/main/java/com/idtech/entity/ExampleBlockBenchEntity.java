package com.idtech.entity;

import com.idtech.BaseMod;
import com.idtech.SoundHandler;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.HandSide;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ExampleBlockBenchEntity extends CreatureEntity {

    public static EntityType<ExampleBlockBenchEntity> TYPE = (EntityType<ExampleBlockBenchEntity>)EntityType.Builder.create(ExampleBlockBenchEntity::new, EntityClassification.CREATURE).build("blockbench").setRegistryName(BaseMod.MODID, "blockbench");
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0x6542ac, 0x156312);


    protected ExampleBlockBenchEntity(EntityType type, World worldIn) {
        super(type, worldIn);
    }

    protected ExampleBlockBenchEntity(World worldIn) {
        super(TYPE, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setupAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 8.0D).func_233815_a_(Attributes.field_233821_d_, 0.5D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_TURTLE_AMBIENT_LAND;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_TURTLE_HURT_BABY;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_TURTLE_DEATH_BABY;
    }
}
