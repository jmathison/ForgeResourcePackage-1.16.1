package com.idtech.entity;

import com.google.common.collect.Sets;
import com.idtech.Utils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class LightningArrowEntity extends AbstractArrowEntity {

    //constructor for a world and shooter
    public LightningArrowEntity(World world, LivingEntity livingEntity) {
        super(EntityType.ARROW, livingEntity, world);
    }
    public LightningArrowEntity(World world) {
        super(EntityType.ARROW, world);
    }

    //this tells minecraft what item to give a player when picking up a missed arrow
    protected ItemStack getArrowStack() {
        return new ItemStack(Items.ARROW);
    }

    // This method decides what the arrow should do on impact - anything you put
    // here will happen when the arrow lands
    @Override
    protected void onImpact(RayTraceResult p_70227_1_) {

        BlockPos pos = new BlockPos(this.getPositionVec());
        Utils.strikeLightning(this.getEntityWorld(), pos);

        super.onImpact(p_70227_1_);
    }
}
