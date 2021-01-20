package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SheepMagicWand extends Item {

    //static instance for registration
    public static Item INSTANCE = new SheepMagicWand(new Properties().group(ItemGroup.MISC)).setRegistryName(BaseMod.MODID, "sheepwand");

    //constructor
    public SheepMagicWand(Properties properties) {
        super(properties);
    }

    //on right click method called when the player clicks with it in the right hand
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        //get held item for return status
        ItemStack itemstack = player.getHeldItem(hand);

        //get the entity at cursor
        Entity entity = Utils.getEntityAtCursor(player, 100);

        //if the entity is a sheep
        if(entity instanceof SheepEntity){
            //set the fleece color to pink!
            ((SheepEntity) entity).setFleeceColor(DyeColor.PINK);
            //return success
            return ActionResult.resultSuccess(itemstack);
        }
        //return fail
        return ActionResult.resultFail(itemstack);
    }
}
