package com.morglthepiypus.minehammer.datagen;

import com.morglthepiypus.minehammer.MineHammer;
import com.morglthepiypus.minehammer.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MineHammer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                /* ********** IMPERIUM ********** */
                .add(ModBlocks.ADAMANTIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get())
                .add(ModBlocks.RAW_ADAMANTIUM_BLOCK.get())
                .add(ModBlocks.ADAMANTIUM_BLOCK.get());

       tag(BlockTags.NEEDS_DIAMOND_TOOL)
               /* ********** IMPERIUM ********** */
               .add(ModBlocks.ADAMANTIUM_ORE.get())
               .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get())
               .add(ModBlocks.RAW_ADAMANTIUM_BLOCK.get())
               .add(ModBlocks.ADAMANTIUM_BLOCK.get());

       tag(BlockTags.FENCES).add(ModBlocks.ADAMANTIUM_FENCE.get());

       tag(BlockTags.FENCE_GATES).add(ModBlocks.ADAMANTIUM_FENCE_GATE.get());

       tag(BlockTags.WALLS).add(ModBlocks.ADAMANTIUM_WALL.get());
    }
}
