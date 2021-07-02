package com.idtech;

import com.idtech.item.GelPickaxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModTab extends ItemGroup {
    public static ItemGroup INSTANCE = new ModTab("examplemod");

    public ModTab(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(GelPickaxeItem.INSTANCE);
    }
}
