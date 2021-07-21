package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.entity.projectile.FlyBombEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FlyBombItem extends Item{
    public static Item INSTANCE = new FlyBombItem(new Properties().group(ItemGroup.COMBAT)).setRegistryName(BaseMod.MODID,"flybombitem");

    public FlyBombItem(Properties builder) {
        super(builder);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);


        if (!worldIn.isRemote) {
            FlyBombEntity projectile = new FlyBombEntity(worldIn, playerIn);
            projectile.setItem(itemstack);
            projectile.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.addEntity(projectile);

        }

        playerIn.addStat(Stats.ITEM_USED.get(this));
        if (!playerIn.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
    }

}
