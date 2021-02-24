package com.idtech.item;

import com.idtech.BaseMod;
        import net.minecraft.item.*;

public class GelPickaxeItem extends PickaxeItem {

    public static IItemTier tier = ItemUtils.buildItemTier(4, 10, 8.0F, 10.0F, 10, "examplemod:gelore");
    public static Item INSTANCE = new GelPickaxeItem(tier,100, 100, new Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelpickaxe");

    public GelPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}
