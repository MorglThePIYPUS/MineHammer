package com.morglthepiypus.minehammer.item;

import com.morglthepiypus.minehammer.MineHammer;
import com.morglthepiypus.minehammer.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MineHammer.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MINEHAMMER_ITEMS_TAB = CREATIVE_MODE_TABS.register("minehammer_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ADAMANTIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.minehammer.minehammer_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_ADAMANTIUM.get());
                        output.accept(ModItems.ADAMANTIUM_INGOT.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> MINEHAMMER_BLOCKS_TAB = CREATIVE_MODE_TABS.register("minehammer_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ADAMANTIUM_ORE.get()))
                    .withTabsBefore(MINEHAMMER_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.minehammer.minehammer_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ADAMANTIUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get());
                        output.accept(ModBlocks.RAW_ADAMANTIUM_BLOCK.get());
                        output.accept(ModBlocks.ADAMANTIUM_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
