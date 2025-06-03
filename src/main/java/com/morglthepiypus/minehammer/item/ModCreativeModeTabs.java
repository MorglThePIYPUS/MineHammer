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
                    .icon(() -> new ItemStack(ModItems.TYRANID_TORAX.get()))
                    .title(Component.translatable("creativetab.minehammer.minehammer_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TYRANID_TORAX.get());
                        output.accept(ModItems.COOKED_TYRANID_TORAX.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> MINEHAMMER_IMPERIUM_ITEMS_TAB =
            CREATIVE_MODE_TABS.register(
                    "imperium_items_tab",
                    () -> CreativeModeTab.builder()
                        .icon(() -> new ItemStack(ModItems.ADAMANTIUM_INGOT.get()))
                            .withTabsBefore(MINEHAMMER_ITEMS_TAB.getId())
                        .title(Component.translatable("creativetab.minehammer.minehammer_imperium_items"))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(ModItems.RAW_ADAMANTIUM.get());
                            output.accept(ModItems.ADAMANTIUM_INGOT.get());

                            //output.accept(ModItems.IMPERIUM_CHISEL.get());

                            output.accept(ModItems.PROMETHIUM_BLOB.get());
                        })
                    .build());
    public static final RegistryObject<CreativeModeTab> MINEHAMMER_BLOCKS_TAB = CREATIVE_MODE_TABS.register(
            "imperium_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ADAMANTIUM_ORE.get()))
                    .withTabsBefore(MINEHAMMER_IMPERIUM_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.minehammer.imperium_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ADAMANTIUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get());
                        output.accept(ModBlocks.RAW_ADAMANTIUM_BLOCK.get());
                        output.accept(ModBlocks.ADAMANTIUM_BLOCK.get());

                        output.accept(ModBlocks.ADAMANTIUM_STAIRS.get());
                        output.accept(ModBlocks.ADAMANTIUM_SLAB.get());

                        output.accept(ModBlocks.ADAMANTIUM_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ADAMANTIUM_BUTTON.get());

                        output.accept(ModBlocks.ADAMANTIUM_FENCE.get());
                        output.accept(ModBlocks.ADAMANTIUM_FENCE_GATE.get());
                        output.accept(ModBlocks.ADAMANTIUM_WALL.get());

                        output.accept(ModBlocks.ADAMANTIUM_DOOR.get());
                        output.accept(ModBlocks.ADAMANTIUM_TRAPDOOR.get());
                        //output.accept(ModBlocks.MAGIC_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
