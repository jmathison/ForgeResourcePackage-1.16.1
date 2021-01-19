package com.idtech.item;

import com.idtech.Utils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class LightningHammerItem extends Item {

    //static instance for registration
    public static Item INSTANCE = new LightningHammerItem(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("lightninghammer");

    //constructor
    public LightningHammerItem(Properties properties) {
        super(properties);
    }

    //on right click method
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //get the held item for return
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        //find the location at the cursor
        BlockPos location = Utils.getBlockAtCursor(playerIn, 20.0d, true);

        //as long as the location exists
        if(location != null){

            //create an explosion
            //i added a createExplosion to Utils, but you can also do this:
            //world.createExplosion(null (or playerIn), location.getX(), location.getY(), location.getZ(), 5f, Explosion.Mode.BREAK);
            Utils.createExplosion(worldIn, location, 0.5f);

            //strike lightning
            Utils.strikeLightning(worldIn, location);

            //return success
            return ActionResult.resultSuccess(itemstack);
        }
        //return a fail
        return ActionResult.resultFail(itemstack);
    }
}
