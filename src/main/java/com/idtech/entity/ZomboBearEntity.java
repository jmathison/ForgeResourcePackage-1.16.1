package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ZomboBearEntity extends PolarBearEntity {

    public static EntityType<ZomboBearEntity> TYPE = (EntityType<ZomboBearEntity>)
            EntityType.Builder.<ZomboBearEntity>create(ZomboBearEntity::new, EntityClassification.CREATURE).build("zombo_bear").setRegistryName(BaseMod.MODID, "zombo_bear");
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xFFFFFF, 0xacbf1f);

    public ZomboBearEntity(World world) {
        super(TYPE, world);
    }
    public ZomboBearEntity(EntityType<? extends PolarBearEntity> type, World world) {
        super(type, world);
    }


    /*
    field_233819_LETTER values from the Attributes class
    a - max_health
    b - follow_range
    c - knockback_resistance
    d - movement_speed
    e - flying_speed
    f - attack_damage
    g - attack_knockback
    h - attack_speed
    i - armor
    j - armor_toughness
    k - luck
    */
    public static AttributeModifierMap.MutableAttribute setupAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 50.0D).//max health
                func_233815_a_(Attributes.field_233819_b_, 20.0D). //follow range
                func_233815_a_(Attributes.field_233821_d_, 0.35D). //movement speed
                func_233815_a_(Attributes.field_233823_f_, 8.0D); //attack damage
    }

    protected void registerGoals() {
        //borrow most of the polar bear code.
        super.registerGoals();

        //decide who it attacks
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, 10, true, true, null));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, true, null));

        //have it use the zombo and itself as help
     //   this.targetSelector.addGoal(5, (new HurtByTargetGoal(this)).setCallsForHelp(ZomboEntityO.class));
        this.targetSelector.addGoal(5, (new HurtByTargetGoal(this)).setCallsForHelp(ZomboBearEntity.class));

    }

    @Override
    public boolean canBeSteered() {
        return true;
    }
}
