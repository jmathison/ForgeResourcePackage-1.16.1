package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class CreepingMoldBlock extends Block {

    //static variables for registration
    private static Properties properties = Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).tickRandomly();

    public static Block INSTANCE = new CreepingMoldBlock(properties).setRegistryName(BaseMod.MODID,"creepingmold");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);

    //constructor
    public CreepingMoldBlock(Properties properties){
        super(properties);

    }

    //method to do something on game tick
    @Override
    public void randomTick(BlockState block, ServerWorld world, BlockPos pos, Random p_225534_4_) {
        super.randomTick(block, world, pos, p_225534_4_);

        //find a random neighboring block position
        BlockPos blockPos = Utils.findNeightborBlock(pos);

        //if the block pos is not null
        if (blockPos != null) {
            //set the block at that position to this block
            world.setBlockState(blockPos, this.getDefaultState());

        }

    }
}
