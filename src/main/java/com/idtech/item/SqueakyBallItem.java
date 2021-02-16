package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class SqueakyBallItem extends Item {

    //properties object
    public static Properties properties = new Item.Properties().group(ItemGroup.MISC);
    //static instance for registration
    public static Item INSTANCE = new SqueakyBallItem(properties).setRegistryName(BaseMod.MODID, "squeakyball");

    //constructor
    public SqueakyBallItem(Properties properties){
        super(properties);

    }

    //on item right click
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        //get held item for return status
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        //play sound
        Utils.playSound(worldIn, playerIn, SoundEvents.ENTITY_BAT_AMBIENT);


        return ActionResult.resultSuccess(itemstack);
    }
}
