package com.idtech.item;

import com.idtech.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class IncredibleNewItem extends Item{

    //static instance for registration
    private static Item.Properties properties = new Item.Properties().group(ItemGroup.MISC);
    public static Item INSTANCE = new IncredibleNewItem(properties).setRegistryName("incrediblenewitem");

    //constructor
    public IncredibleNewItem(Item.Properties properties) {
        super(properties);

    }

    //onrightclick
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //get the held item for return
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        Entity entityAtCursor = Utils.getEntityAtCursor(playerIn, 10);
        entityAtCursor.setMotion(0, 5, 0);
        return ActionResult.resultPass(itemstack);
    }
}
