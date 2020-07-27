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

    public static Item INSTANCE = new LightningHammerItem(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("lightning_hammer");

    public LightningHammerItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        BlockPos location = Utils.getBlockAtCursor(playerIn, 20.0d, true);

        if(location != null){
            worldIn.createExplosion(playerIn, location.getX(), location.getY(), location.getZ(), 5f, Explosion.Mode.BREAK);
            Utils.strikeLightning(worldIn, location);
            return ActionResult.resultSuccess(itemstack);
        }
        return ActionResult.resultFail(itemstack);
    }
}
