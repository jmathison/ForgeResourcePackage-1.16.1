package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FireRodItem extends Item {
    public static Item INSTANCE = new FireRodItem(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BaseMod.MODID, "fire_rod");

    public FireRodItem(Properties properties) {
        super(properties);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        Entity e = Utils.getEntityAtCursor(playerIn, 100.0d);
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        BaseMod.LOGGER.info("Fire");
        if (e != null){
            e.setFire(2);
            return ActionResult.resultSuccess(itemstack);
        }
        return ActionResult.resultFail(itemstack);
    }

}
