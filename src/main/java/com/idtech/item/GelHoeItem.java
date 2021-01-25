package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.item.*;

public class GelHoeItem extends HoeItem {

    //Tier is the equivalent of a tool material for 1.16 the only addition is the repair ingredient!
    public static IItemTier tier = ItemUtils.buildItemTier(3, 1561, 8.0F, 3.0F, 10, "examplemod:gelore");
    //static instance for registration
    public static Item INSTANCE = new GelHoeItem(tier,50, 100, new Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelhoe");

    //constructor
    public GelHoeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
            super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}
