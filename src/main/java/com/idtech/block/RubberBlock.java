package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.SoundHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class RubberBlock extends Block{
    private static Properties properties = Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 0.9f).harvestTool(ToolType.PICKAXE);

    //static instances for registration
    public static Block INSTANCE = new RubberBlock(properties).setRegistryName(BaseMod.MODID,"rubber_block");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);

    //constructor

    public RubberBlock(Properties properties){super(properties);}

    //method for when an entity walks on block
    @Override
    public void onEntityWalk(World worldIn, BlockPos posIn, Entity entityIn) {
        super.onEntityWalk(worldIn, posIn, entityIn);

        //entity add velocity and then the numbers are x y and z respectively
        entityIn.addVelocity(0,5,0);
        if (worldIn.isRemote){ //Sounds should only play on the server's version of the world
            entityIn.playSound(SoundHandler.boing, 10f, 1f);//play the boing sound to the player, making the volume higher than normal so it can still be heard while the player is flying in the air
        }
    }
}
