package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FunNewItem extends Item{
    //properties object
    public static Properties properties = new Properties().group(ItemGroup.MISC);
    //static instance for registration
    public static Item INSTANCE = new FunNewItem(properties).setRegistryName(BaseMod.MODID, "testitem");

    //constructor
    public FunNewItem(Properties properties){
        super(properties);

    }

    //on item right click
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        //get held item for return status
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        worldIn.setRainStrength(1);

        return ActionResult.resultSuccess(itemstack);
    }
}
