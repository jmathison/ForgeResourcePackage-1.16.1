package com.idtech;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

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
            //LightningBoltEntity lightningBolt = new LightningBoltEntity(world, location.getX(), location.getY(), location.getZ(), false);
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

        RayTraceContext rayTraceContext = new RayTraceContext(player.getPositionVec(), player.getPositionVec().add(player.getLookVec().scale(distance)), RayTraceContext.BlockMode.COLLIDER, fluidMode, player);
        BlockRayTraceResult blockHit = player.getEntityWorld().rayTraceBlocks(rayTraceContext);
        if(blockHit.getType() == RayTraceResult.Type.MISS){
            return null;
        }
        else {
            return blockHit.getPos();
        }
    }



}
