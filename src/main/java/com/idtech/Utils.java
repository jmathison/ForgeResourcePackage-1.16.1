package com.idtech;

import com.sun.media.jfxmedia.logging.Logger;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
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
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.function.Predicate;

/**
 * Utilities to use with blocks, items and entities to simplify some functionality
 */
public class Utils {

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
     * Spawn an entity in the world
     * @param world world to spawn the entity in
     * @param type entity type to spawn. Access vanilla entities with 'EntityType.' constants
     * @param location block position to spawn at
     */
    public static void spawnEntity(World world, EntityType type, BlockPos location){
        type.spawn(world, null, null, location, SpawnReason.COMMAND, true, false);
    }

    /**
     * Get the block that the player is looking at.
     * @param player The player whose look we're checking
     * @param distance range to check in blocks
     * @param ignoreFluids True or False. If True, blocks underwater will be detected. If False, the first water block
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
     * @param distance range to check in blocks
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


}
