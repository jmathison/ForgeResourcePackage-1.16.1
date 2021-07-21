package com.idtech.entity.projectile;

import com.idtech.BaseMod;
import com.idtech.item.CustomProjectileItem;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;


@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class CustomProjectileEntity extends ProjectileItemEntity implements IRendersAsItem{

    public static EntityType<CustomProjectileEntity> TYPE = (EntityType<CustomProjectileEntity>)
            EntityType.Builder.<CustomProjectileEntity>create(CustomProjectileEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10).build("customprojectile").setRegistryName(BaseMod.MODID, "customprojectile");

    public Entity thrower;
    public World world;

    //constructors
    public CustomProjectileEntity(World worldIn) {
        super(TYPE, worldIn);
        this.world = worldIn;
    }

    public CustomProjectileEntity(EntityType<CustomProjectileEntity> p_i50159_1_, World worldIn) {
        super(p_i50159_1_, worldIn);
        this.world = worldIn;
    }

    public CustomProjectileEntity(World worldIn, LivingEntity throwerIn) {
        super(TYPE, throwerIn, worldIn);
        this.thrower = throwerIn;
        this.world = worldIn;
    }

    public CustomProjectileEntity(World worldIn, double x, double y, double z) {
        super(TYPE, x, y, z, worldIn);
    }

    protected Item getDefaultItem() {
        return CustomProjectileItem.INSTANCE;
    }


    //create an explosion on impact
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);

        System.out.println("impacted");
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);


            Vector3d pos = result.getHitVec();
            world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 10, Explosion.Mode.DESTROY);
        }
        this.remove();
    }


    //used for rendering
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
