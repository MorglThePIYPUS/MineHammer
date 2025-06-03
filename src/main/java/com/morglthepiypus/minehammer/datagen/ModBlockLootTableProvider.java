package com.morglthepiypus.minehammer.datagen;

import com.morglthepiypus.minehammer.block.ModBlocks;
import com.morglthepiypus.minehammer.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        /* ********** IMPERIUM ********** */
        this.add(
                ModBlocks.ADAMANTIUM_ORE.get(),
                block ->
                        createOreDrop(ModBlocks.ADAMANTIUM_ORE.get(), ModItems.RAW_ADAMANTIUM.get()));
        this.add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get(),
                block ->
                        createMultipleDrops(
                                ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get(),
                                ModItems.RAW_ADAMANTIUM.get(),
                                1,
                                3));

        dropSelf(ModBlocks.RAW_ADAMANTIUM_BLOCK.get());
        dropSelf(ModBlocks.ADAMANTIUM_BLOCK.get());

        dropSelf(ModBlocks.ADAMANTIUM_STAIRS.get());
        this.add(ModBlocks.ADAMANTIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ADAMANTIUM_SLAB.get()));

        dropSelf(ModBlocks.ADAMANTIUM_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.ADAMANTIUM_BUTTON.get());

        dropSelf(ModBlocks.ADAMANTIUM_FENCE.get());
        dropSelf(ModBlocks.ADAMANTIUM_FENCE_GATE.get());
        dropSelf(ModBlocks.ADAMANTIUM_WALL.get());

        this.add(ModBlocks.ADAMANTIUM_DOOR.get(),
                block -> createDoorTable(ModBlocks.ADAMANTIUM_DOOR.get()));
        dropSelf(ModBlocks.ADAMANTIUM_TRAPDOOR.get());

        dropSelf(ModBlocks.IMPERIUM_LAMP.get());
    }

    protected LootTable.Builder createMultipleDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
