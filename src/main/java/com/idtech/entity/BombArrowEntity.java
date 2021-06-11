package com.idtech.entity;

import com.idtech.Utils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BombArrowEntity extends AbstractArrowEntity {

    public BombArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public BombArrowEntity(World world, LivingEntity livingEntity) {
        super(EntityType.ARROW, livingEntity, world);
    }


    protected ItemStack getArrowStack() {
        return new ItemStack(Items.ARROW);
    }

    @Override
    protected void onImpact(RayTraceResult p_70227_1_) {
        BlockPos pos = new BlockPos(this.getPositionVec());
        Utils.createExplosion(this.getEntityWorld(), pos, 5);
        super.onImpact(p_70227_1_);
    }
}
