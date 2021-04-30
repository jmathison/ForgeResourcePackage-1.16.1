package com.idtech.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class CoolStoneBlock extends Block {

    //static instances for the registry
    public static Block INSTANCE = new CoolStoneBlock(Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 0.9f).harvestTool(ToolType.SHOVEL).tickRandomly()).setRegistryName("coolstoneblock");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);

    //construuctor
    public CoolStoneBlock(Properties properties) {
        super(properties);
    }

    //This method runs on a random tick.
    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

        //create an explosion based on the position of size 1
        worldIn.createExplosion(null, pos.getX(), pos.up().getY(), pos.getZ(), 1, Explosion.Mode.NONE);
    }
}
