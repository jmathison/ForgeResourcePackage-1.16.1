package com.idtech.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BlockMod {

    //Basic Block
//    public static final Block basicBlock = BlockUtils.createBasicBlock("basic_block", Material.ROCK, 0.5f, 0.9f, ToolType.PICKAXE);
//    public static final Item basicBlockItem = BlockUtils.createBlockItem(basicBlock, ItemGroup.MISC);
//
//    public static final Block basicOreBlock = BlockUtils.createBasicBlock("basic_ore_block", Material.ROCK, 0.5f, 0.6f, ToolType.PICKAXE);
//    public static final Item basicOreBlockItem = BlockUtils.createBlockItem(basicOreBlock, ItemGroup.MISC);


    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {

        event.getRegistry().register(BasicBlocks.BASIC_BLOCK_ITEM);
        event.getRegistry().register(BasicBlocks.BASIC_ORE_BLOCK_ITEM);

        event.getRegistry().register(CoolStoneBlock.ITEM);
        event.getRegistry().register(RubberBlock.ITEM);
        event.getRegistry().register(CreeperSurpriseBlock.ITEM);
        event.getRegistry().register(CreepingMoldBlock.ITEM);

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        event.getRegistry().register(BasicBlocks.BASIC_BLOCK);
        event.getRegistry().register(BasicBlocks.BASIC_ORE_BLOCK);

        event.getRegistry().register(CoolStoneBlock.INSTANCE);
        event.getRegistry().register(RubberBlock.INSTANCE);
        event.getRegistry().register(CreeperSurpriseBlock.INSTANCE);
        event.getRegistry().register(CreepingMoldBlock.INSTANCE);

    }
}