package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FireWandItem extends Item {

    //static instance for registry
    public static Item INSTANCE = new FireWandItem(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BaseMod.MODID, "firewand");

    //constructor
    public FireWandItem(Properties properties) {
        super(properties);
    }


    //on right click method!
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //get the entity at the cursor
        Entity e = Utils.getEntityAtCursor(playerIn, 100.0d);
        //get the item that is being held
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        //print out message when fire happens
        BaseMod.LOGGER.info("Fire");
        //if theres an entity at the cursor
        if (e != null){
            //set the entity on fire
            e.setFire(2);
            //return success
            return ActionResult.resultSuccess(itemstack);
        }
        //return fail
        return ActionResult.resultFail(itemstack);
    }

}
