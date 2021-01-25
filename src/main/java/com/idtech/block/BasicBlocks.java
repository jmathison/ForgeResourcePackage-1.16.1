package com.idtech.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;


public class BasicBlocks {

    public static final Block BASIC_BLOCK = BlockUtils.createBasicBlock("basic_block", Material.ROCK, 0.5f, 0.9f, ToolType.PICKAXE);
    public static final Item BASIC_BLOCK_ITEM = BlockUtils.createBlockItem(BASIC_BLOCK, ItemGroup.MISC);

    public static final Block BASIC_ORE_BLOCK = BlockUtils.createBasicBlock("geloreblock", Material.ROCK, 0.5f, 0.6f, ToolType.PICKAXE);
    public static final Item BASIC_ORE_BLOCK_ITEM = BlockUtils.createBlockItem(BASIC_ORE_BLOCK, ItemGroup.MISC);

}
