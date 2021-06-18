package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class TNTCannonBlock extends Block {

    //I make the resistance higher because it has the opportunity to blow itself up quite easily
    private static Properties properties = Properties.create(Material.ANVIL).hardnessAndResistance(
            0.5f,100f).sound(SoundType.ANVIL).tickRandomly();

    public static Block INSTANCE = new TNTCannonBlock(properties).setRegistryName(BaseMod.MODID,"tntcannon");

    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.COMBAT);

    public TNTCannonBlock(Properties properties){
        super(properties);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn){
        super.onEntityWalk(worldIn,pos,entityIn);

        //The setFire is used here to make sure the tnt gets lit
        entityIn.setFire(10);

        //I use the Math.random() here as an additional bit to keep the code interesting, it makes it so the tnt can be launched
        //in any direction, however it still works well with manually set x and z values.
        int max = 10;
        int min = -10;
        int X = (int)Math.floor(Math.random()*(max-min+1)+min);
        int Z = (int)Math.floor(Math.random()*(max-min+1)+min);

        //This is what launches the TNT, not sure why the TNT is considered to "Walk" on the block but it is.
        entityIn.setVelocity(X,3,Z);

    }
    @Override
    public void randomTick(BlockState block, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(block, worldIn, pos, rand);

        //I make sure to spawn the TNT above the block so I add 1 to the y value of the BlockPos
        Utils.spawnEntity(worldIn, EntityType.TNT, pos.add(0,1,0));
    }
}
