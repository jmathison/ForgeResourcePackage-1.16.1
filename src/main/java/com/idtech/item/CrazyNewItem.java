package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class CrazyNewItem extends HoeItem {

    //Tier is the equivalent of a tool material for 1.16 the only addition is the repair ingredient!
    public static IItemTier tier = ItemUtils.buildItemTier(3, 1561, 8.0F, 3.0F, 10, "examplemod:gelore");
    //static instance for registration
    public static Item INSTANCE = new CrazyNewItem(tier,50, 100, new Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelhoe");

    //constructor
    public CrazyNewItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }

    //on item right click
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        //get held item for return status
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        //play sound
        Utils.playSound(worldIn, playerIn, SoundEvents.BLOCK_NOTE_BLOCK_COW_BELL);


        return ActionResult.resultSuccess(itemstack);
    }
}
