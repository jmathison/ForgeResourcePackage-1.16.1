package com.idtech.entity.projectile;

import com.idtech.BaseMod;
import com.idtech.item.FlyBombItem;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;


@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class FlyBombEntity extends ProjectileItemEntity implements IRendersAsItem {

    public static EntityType<FlyBombEntity> TYPE = (EntityType<FlyBombEntity>)
            EntityType.Builder.<FlyBombEntity>create(FlyBombEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10).build("customprojectile").setRegistryName(BaseMod.MODID, "flybomb");

    public Entity thrower;
    public World world;

    //constructors
    public FlyBombEntity(World worldIn) {
        super(TYPE, worldIn);
        this.world = worldIn;
    }

    public FlyBombEntity(EntityType<FlyBombEntity> p_i50159_1_, World worldIn) {
        super(p_i50159_1_, worldIn);
        this.world = worldIn;
    }

    public FlyBombEntity(World worldIn, LivingEntity throwerIn) {
        super(TYPE, throwerIn, worldIn);
        this.thrower = throwerIn;
        this.world = worldIn;
    }

    public FlyBombEntity(World worldIn, double x, double y, double z) {
        super(TYPE, x, y, z, worldIn);
    }

    //get the item
    protected Item getDefaultItem() {
        return FlyBombItem.INSTANCE;
    }


    //if the projectile hits an entity, launch it into the air (like rubber block)

    protected void onEntityHit(EntityRayTraceResult entityLoc) {

        if (entityLoc != null) {

            Entity entity = entityLoc.getEntity();
            if (entity instanceof LivingEntity) {
                entity.setMotion(0, 5, 0);
            }
        }

    }

    //used to render projectile
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
