package com.morglthepiypus.minehammer.datagen;

import com.morglthepiypus.minehammer.MineHammer;
import com.morglthepiypus.minehammer.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MineHammer.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        /* ********** IMPERIUM ********** */
        blockWithItem(ModBlocks.ADAMANTIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
        blockWithItem(ModBlocks.RAW_ADAMANTIUM_BLOCK);
        blockWithItem(ModBlocks.ADAMANTIUM_BLOCK);
        //blockWithItem(ModBlocks.MAGIC_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
