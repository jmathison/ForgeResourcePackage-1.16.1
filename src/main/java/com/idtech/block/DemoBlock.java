package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class DemoBlock extends Block {

    //properties object
    private static Properties properties = Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).tickRandomly();
    //block instance for registration with name used for texture/name stuff
    public static Block INSTANCE = new DemoBlock(properties).setRegistryName(BaseMod.MODID, "demoblock");
    //item instance for registration
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);

    //constructor
    public DemoBlock(Properties properties){
        super(properties);

    }
    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

        Utils.spawnEntity(worldIn, EntityType.CHICKEN, pos);


    }

}
