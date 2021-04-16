package com.idtech.entity;

        import com.idtech.BaseMod;
        import net.minecraft.entity.Entity;
        import net.minecraft.entity.EntityClassification;
        import net.minecraft.entity.EntityType;
        import net.minecraft.entity.LivingEntity;
        import net.minecraft.entity.projectile.AbstractFireballEntity;
        import net.minecraft.util.DamageSource;
        import net.minecraft.util.math.EntityRayTraceResult;
        import net.minecraft.util.math.RayTraceResult;
        import net.minecraft.world.Explosion;
        import net.minecraft.world.World;
        import net.minecraftforge.api.distmarker.Dist;
        import net.minecraftforge.api.distmarker.OnlyIn;

public class CustomFireball extends AbstractFireballEntity {

    public int explosionPower = 100;
    public static EntityType<CustomFireball> TYPE = (EntityType<CustomFireball>)
            EntityType.Builder.<CustomFireball>create(CustomFireball::new, EntityClassification.MISC).build("customprojectile").setRegistryName(BaseMod.MODID, "customprojectile");


    public CustomFireball(EntityType<CustomFireball> p_i50163_1_, World p_i50163_2_) {
        super(p_i50163_1_, p_i50163_2_);
    }
    public CustomFireball(World p_i50163_2_) {
        super(TYPE, p_i50163_2_);
    }
    @OnlyIn(Dist.CLIENT)
    public CustomFireball(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(TYPE, x, y, z, accelX, accelY, accelZ, worldIn);
    }

    public CustomFireball(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(TYPE, shooter, accelX, accelY, accelZ, worldIn);
    }


    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.func_234616_v_());
            this.world.createExplosion((Entity)null, this.getPosX(), this.getPosY(), this.getPosZ(), (float)this.explosionPower, flag, flag ? Explosion.Mode.DESTROY : Explosion.Mode.NONE);
            this.remove();
        }

    }


    /**
     * Called when the arrow hits an entity
     */
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        if (!this.world.isRemote) {
            Entity entity = p_213868_1_.getEntity();
            Entity entity1 = this.func_234616_v_();
            entity.attackEntityFrom(DamageSource.func_233547_a_(this, entity1), 6.0F);
            if (entity1 instanceof LivingEntity) {
                this.applyEnchantments((LivingEntity)entity1, entity);
            }

        }
    }

}
