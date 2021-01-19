package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import javax.annotation.Nullable;


public class CustomArmorItem extends ArmorItem {

    //armor material creation!
    private static IArmorMaterial customMaterial = ItemUtils.buildArmorMaterial("basicore", 5,new int[]{10,10,10,10} ,5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 4.0f, 0.3f,"examplemod:basicore");

    //static instances for registering
    public static Item HELM = new CustomArmorItem(customMaterial, EquipmentSlotType.HEAD, new Properties().group(ItemGroup.MISC)).setRegistryName(BaseMod.MODID,"customhelm");
    public static Item CHEST = new CustomArmorItem(customMaterial, EquipmentSlotType.CHEST, new Properties().group(ItemGroup.MISC)).setRegistryName(BaseMod.MODID,"customchest");
    public static Item LEGS = new CustomArmorItem(customMaterial, EquipmentSlotType.LEGS, new Properties().group(ItemGroup.MISC)).setRegistryName(BaseMod.MODID,"customlegs");
    public static Item BOOTS = new CustomArmorItem(customMaterial, EquipmentSlotType.FEET, new Properties().group(ItemGroup.MISC)).setRegistryName(BaseMod.MODID,"customboots");

    //constructor
    public CustomArmorItem(IArmorMaterial material, EquipmentSlotType type, Properties properties) {
        super(material, type, properties);

    }

    //texture management!
    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        if(slot == EquipmentSlotType.LEGS){
            return "examplemod:textures/models/armor/custom_armor_layer_2.png";
        }else{
            return "examplemod:textures/models/armor/custom_armor_layer_1.png";
        }
    }
}
