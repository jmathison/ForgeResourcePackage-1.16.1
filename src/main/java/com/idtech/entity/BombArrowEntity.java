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

    //constructor for a world and shooter
    public BombArrowEntity(World world, LivingEntity livingEntity) {
        super(EntityType.ARROW, livingEntity, world);
    }
    public BombArrowEntity(World world) {
        super(EntityType.ARROW, world);
    }

    //this tells minecraft what item to give a player when picking up a missed arrow
    protected ItemStack getArrowStack() {
        return new ItemStack(Items.ARROW);
    }

    //this function is called when the arrow impacts an entity or surface
    //this is where a custom effect can be added
    //onEntityHit can also be used but will only trigger on mobs
    @Override
    protected void onImpact(RayTraceResult p_70227_1_) {

        BlockPos pos = new BlockPos(this.getPositionVec());
        Utils.createExplosion(this.getEntityWorld(), pos, 5);
        super.onImpact(p_70227_1_);

    }
}
