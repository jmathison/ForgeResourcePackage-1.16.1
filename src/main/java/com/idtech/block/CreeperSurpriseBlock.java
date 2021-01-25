package com.idtech.block;


import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class CreeperSurpriseBlock extends Block {

    //static instances for registration
    private static Properties properties = Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE);
    public static Block INSTANCE = new CreeperSurpriseBlock(properties).setRegistryName(BaseMod.MODID, "creeper_surprise_block");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);

    //constructor
    public CreeperSurpriseBlock(Properties properties) {
        super(properties);

    }

    //when the block is broken and harvested
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState p_176208_3_, PlayerEntity p_176208_4_) {
        super.onBlockHarvested(worldIn, pos, p_176208_3_, p_176208_4_);

        //spawn an entity at the block position using the utils method
        Utils.spawnEntity(worldIn, EntityType.CREEPER, pos);

    }
}
