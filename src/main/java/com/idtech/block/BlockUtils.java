package com.idtech.block;

import com.idtech.BaseMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;


/**
 * Utilities specific to creating block and doing things with block.
 */
public class BlockUtils {

    /**
     * If you need a basic block with no extra functionality, you can use this function to create one.
     * @param name The registry name of the block. All lowercase, underscores instead of spaces. e.g. "gel_block"
     * @param material The block's material
     * @param hardness How difficult the block is to break.
     * @param resistance The block's resistance to explosions
     * @param tool The tool required to harvest
     * @return The constructed block with the specified parameters
     */
    public static Block createBasicBlock(String name, Material material, float hardness, float resistance, ToolType tool){
        return new Block(Block.Properties.create(material).hardnessAndResistance(hardness, resistance).harvestTool(tool)).setRegistryName(BaseMod.MODID, name);
    }

    /**
     * Create a block item so that players can hold the block in their inventory.
     * @param block The block to create an item of
     * @param group The item group (creative tab) the block should go into.
     * @return The constructed block item
     */
    public static Item createBlockItem(Block block, ItemGroup group){
        return new BlockItem(block, new Item.Properties().group(group)).setRegistryName(block.getRegistryName());
    }

}
