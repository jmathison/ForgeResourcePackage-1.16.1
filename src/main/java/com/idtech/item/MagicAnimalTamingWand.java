package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MagicAnimalTamingWand extends Item{

    //properties object
    public static Properties properties = new Properties().group(ItemGroup.MISC);
    //static instance for registration
    public static Item INSTANCE = new MagicAnimalTamingWand(properties).setRegistryName(BaseMod.MODID, "magicanimal");

    //constructor
    public MagicAnimalTamingWand(Properties properties){
        super(properties);

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        Entity entity = Utils.getEntityAtCursor(playerIn, 100);


        playerIn.startRiding(entity);

        return super.onItemRightClick(worldIn, playerIn, handIn);


    }
}
