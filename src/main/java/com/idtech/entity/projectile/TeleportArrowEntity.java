package com.idtech.entity.projectile;

import com.idtech.BaseMod;
import com.idtech.item.TeleportArrowItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class TeleportArrowEntity extends AbstractArrowEntity {

    //constructor for a world and shooter
    public TeleportArrowEntity(World world, LivingEntity livingEntity) {
        super(EntityType.ARROW, livingEntity, world);
    }
    public TeleportArrowEntity(World world) {
        super(EntityType.ARROW, world);
    }


    //this code is stolen from the ender pearl :)
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        Entity entity = this.func_234616_v_();

        for(int i = 0; i < 32; ++i) {
            this.world.addParticle(ParticleTypes.PORTAL, this.getPosX(), this.getPosY() + this.rand.nextDouble() * 2.0D, this.getPosZ(), this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        }

        if (!this.world.isRemote && !this.removed) {
            if (entity instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)entity;
                if (serverplayerentity.connection.getNetworkManager().isChannelOpen() && serverplayerentity.world == this.world && !serverplayerentity.isSleeping()) {
                    net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(serverplayerentity, this.getPosX(), this.getPosY(), this.getPosZ(), 5.0F);
                    if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) { // Don't indent to lower patch size

                        if (entity.isPassenger()) {
                            entity.stopRiding();
                        }

                        entity.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        entity.fallDistance = 0.0F;
                        entity.attackEntityFrom(DamageSource.FALL, event.getAttackDamage());
                    } //Forge: End
                }
            } else if (entity != null) {
                entity.setPositionAndUpdate(this.getPosX(), this.getPosY(), this.getPosZ());
                entity.fallDistance = 0.0F;
            }

            this.remove();
        }

    }

    protected ItemStack getArrowStack() {
        return new ItemStack(TeleportArrowItem.INSTANCE);

    }

}
