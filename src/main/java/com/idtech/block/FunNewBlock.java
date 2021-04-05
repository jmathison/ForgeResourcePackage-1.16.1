package com.idtech.block;

import com.idtech.BaseMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class FunNewBlock extends Block {

    //static instances for registration
    private static Properties properties = Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE);
    public static Block INSTANCE = new FunNewBlock(properties).setRegistryName(BaseMod.MODID, "funnewblock");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);

    public FunNewBlock(Properties properties){
        super(properties);

    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityWalk(worldIn, pos, entityIn);

        if (entityIn instanceof LivingEntity) {

            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.NAUSEA, 200));
        }
    }
}
