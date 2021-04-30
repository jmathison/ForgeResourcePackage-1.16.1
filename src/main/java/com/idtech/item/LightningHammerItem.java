package com.idtech.item;

import com.idtech.Utils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LightningHammerItem extends Item {


    //static instance for registration
    private static Properties properties = new Properties().group(ItemGroup.MISC);
    public static Item INSTANCE = new LightningHammerItem(properties).setRegistryName("lightninghammer");

    //constructor
    public LightningHammerItem(Properties properties) {
        super(properties);

    }

    //onrightclick
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //get the held item for return
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        //find the location at the cursor
        BlockPos location = Utils.getBlockAtCursor(playerIn, 20.0d, true);

        //decide the size of the explosion
        float explosionRadius = 0.5f;

        //as long as the location exists
        if(location != null){

            //create an explosion
            Utils.createExplosion(worldIn, location, explosionRadius);

            //strike lightning
            Utils.strikeLightning(worldIn, location);

            //return success
            return ActionResult.resultSuccess(itemstack);

        } else {

            //return a fail
            return ActionResult.resultFail(itemstack);
        }
    }
}
