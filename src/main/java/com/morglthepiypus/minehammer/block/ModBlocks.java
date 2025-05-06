package com.morglthepiypus.minehammer.block;

import com.morglthepiypus.minehammer.MineHammer;
import com.morglthepiypus.minehammer.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MineHammer.MOD_ID);

    public static final RegistryObject<Block> ADAMANTIUM_ORE = registerBlock("adamantium_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_ADAMANTIUM_BLOCK = registerBlock("raw_adamantium_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
