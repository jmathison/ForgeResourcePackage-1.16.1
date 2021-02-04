package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TeleportRodItem extends Item {

    private static Properties properties = new Properties().group(ItemGroup.MISC);
    public static Item INSTANCE = new TeleportRodItem(properties).setRegistryName("teleportrod");;

    //constructor
    public TeleportRodItem(Properties properties){
        super(properties);
    }
    //on right click method
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        //get held item for return status
        ItemStack itemstack = player.getHeldItem(hand);

        //get the block at cursor
        BlockPos pos = Utils.getBlockAtCursor(player, 1000,true);

        //if the position at cursor isn't null
        if(pos != null) {

            //set the players position to that position
            player.setPosition(pos.getX(), pos.getY(), pos.getZ());

            //return success
            return ActionResult.resultSuccess(itemstack);

        } else {

            //return fail
            return ActionResult.resultFail(itemstack);
        }

    }

}
