package com.idtech.item;

        import com.idtech.BaseMod;
        import net.minecraft.item.*;

public class GelPickaxeItem extends PickaxeItem {

    public static IItemTier tier = ItemUtils.buildItemTier(3, 1561, 8.0F, 3.0F, 10, "examplemod:gelore");
    public static Item INSTANCE = new GelPickaxeItem(tier,50, 100, new Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelpickaxe");

    public GelPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}
