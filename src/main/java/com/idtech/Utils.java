package com.idtech;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Utilities to use with block, item and entities to simplify some functionality
 */
public class Utils {
    //protected static Random random;

    /**
     * Strikes a location with lightning
     * @param world The world to strike lightning in
     * @param location The block position to strike with lightning
     */
    public static void strikeLightning(World world, BlockPos location){
        if (world instanceof ServerWorld){
            ServerWorld serverWorld = (ServerWorld) world;
            LightningBoltEntity lightningBolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
            lightningBolt.setPosition(location.getX(), location.getY(), location.getZ());
            serverWorld.addEntity(lightningBolt);
        }

    }

    /**
     * Creates an explosion at location with radius of explosionRadius
     * @param world The world to create explosion in
     * @param location the block position to create explosion
     * @param explosionRadius the radius of the explosion
     */
    public static void createExplosion(World world, BlockPos location, float explosionRadius){
        world.createExplosion(null, location.getX(), location.getY(), location.getZ(), 5f, Explosion.Mode.BREAK);

    }

    /**
     * Spawn an entity in the world
     * @param world world to spawn the entity in
     * @param type entity type to spawn. Access vanilla entities with 'EntityType.' constants
     * @param location block position to spawn at
     */
    public static Entity spawnEntity(World world, EntityType type, BlockPos location){
        return type.spawn(world, null, null, location, SpawnReason.COMMAND, true, false);
    }

    /**
     * Get the block that the player is looking at.
     * @param player The player whose look we're checking
     * @param distance range to check in block
     * @param ignoreFluids True or False. If True, block underwater will be detected. If False, the first water block
     *                     hit will be detected.
     * @return Block position if one is found within range, null if no block in range.
     */
    public static BlockPos getBlockAtCursor(PlayerEntity player, double distance, boolean ignoreFluids){
        RayTraceContext.FluidMode fluidMode = ignoreFluids ? RayTraceContext.FluidMode.NONE : RayTraceContext.FluidMode.ANY;

        RayTraceContext rayTraceContext = new RayTraceContext(player.getEyePosition(1), player.getEyePosition(1).add(player.getLookVec().scale(distance)), RayTraceContext.BlockMode.COLLIDER, fluidMode, player);
        BlockRayTraceResult blockHit = player.getEntityWorld().rayTraceBlocks(rayTraceContext);
        if(blockHit.getType() == RayTraceResult.Type.MISS){
            return null;
        }
        else {
            return blockHit.getPos();
        }
    }

    /**
     * Get the entity that the player is looking at.
     * @param player The player whose look we're checking
     * @param distance range to check in block
     * @return The entity hit, null if none is found.
     */
    public static Entity getEntityAtCursor(PlayerEntity player, double distance){
        distance *= 10; // Scale from block units - for some reason entity raytracing units are different.
        Predicate<Entity> filter = e ->  !e.isSpectator() && e.canBeCollidedWith();
        EntityRayTraceResult entityTrace = ProjectileHelper.rayTraceEntities(player, player.getEyePosition(1), player.getEyePosition(1).add(player.getLookVec().scale(distance)), player.getBoundingBox().expand(player.getLookVec().scale(distance)).grow(1.0d), filter, distance);
        if(entityTrace == null){
          return null;
        }
        return entityTrace.getEntity();
    }


    /**
     * Set a block location on fire.
     * @param world world to set the fire in.
     * @param location The block location to set on fire.
     * @param face The side of the block to set on fire. Use Direction.UP, DOWN, NORTH, SOUTH, EAST, WEST
     */

    public static void setFireBlock(World world, BlockPos location, Direction face){
        BlockState blockState = world.getBlockState(location);

        if (CampfireBlock.func_241470_h_(blockState)) {
            world.playSound(null, location, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            world.setBlockState(location, blockState.with(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
        } else {
            BlockPos blockpos1 = location.offset(face);
            if (AbstractFireBlock.func_241465_a_(world, blockpos1)) {
                world.playSound(null, blockpos1, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
                BlockState blockstate1 = AbstractFireBlock.func_235326_a_(world, blockpos1);
                world.setBlockState(blockpos1, blockstate1, 11);

            }
        }
    }

    /**
     * Find a random block pos based on a block pos.
     * @param pos position of the block from which to spread
     * @return a random position near that block.
     */
    public static BlockPos findNeightborBlock(BlockPos pos){

        int spreadX = (int)Math.floor(Math.random()*3) - 1;
        int spreadY = spreadX == 0 ? (int)Math.floor(Math.random()*3) - 1 : 0 ;
        int spreadZ = spreadX == 0  && spreadY == 0 ? (int)Math.floor(Math.random()*3) - 1 : 0;
        BlockPos spreadPos = pos.add(spreadX, spreadY, spreadZ);

        return spreadPos;
    }


    public static void playSound(World world, PlayerEntity player, SoundEvent sound){
       // world.playSound(player.getPosX(), player.getPosY(), player.getPosZ(), sound, SoundCategory.AMBIENT, 1.0f, 1.0f);
        world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), sound, SoundCategory.NEUTRAL, 0.5f, 0.4f);
    }

}
