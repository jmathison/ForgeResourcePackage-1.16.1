package com.idtech.item;


import com.idtech.BaseMod;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

public class GelSwordItem extends SwordItem {

    //Tier is the equivalent of a tool material for 1.16 the only addition is the repair ingredient!
    private static IItemTier tier = ItemUtils.buildItemTier(3, 1561, 8.0F, 3.0F, 10, "examplemod:basic_ore");
    //static instance for the registry
    public static Item INSTANCE = new GelSwordItem(tier,50, 100, new Properties().group(ItemGroup.COMBAT)).setRegistryName(BaseMod.MODID,"gelsword");

    //constructor
    public GelSwordItem(IItemTier tier, int speed, float damage, Properties properties) {
        super(tier, speed, damage, properties);

    }


}
