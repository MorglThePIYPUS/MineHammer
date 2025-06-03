package com.morglthepiypus.minehammer.datagen;

import com.morglthepiypus.minehammer.MineHammer;
import com.morglthepiypus.minehammer.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        stairsBlock(ModBlocks.ADAMANTIUM_STAIRS.get(), blockTexture(ModBlocks.ADAMANTIUM_BLOCK.get()));
        slabBlock(ModBlocks.ADAMANTIUM_SLAB.get(), blockTexture(ModBlocks.ADAMANTIUM_BLOCK.get()),
                blockTexture(ModBlocks.ADAMANTIUM_BLOCK.get()));


        buttonBlock(ModBlocks.ADAMANTIUM_BUTTON.get(), blockTexture(ModBlocks.ADAMANTIUM_BLOCK.get()));
        pressurePlateBlock(ModBlocks.ADAMANTIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ADAMANTIUM_BLOCK.get()));

        fenceBlock(ModBlocks.ADAMANTIUM_FENCE.get(), blockTexture(ModBlocks.ADAMANTIUM_BLOCK.get()));
        fenceGateBlock(ModBlocks.ADAMANTIUM_FENCE_GATE.get(), blockTexture(ModBlocks.ADAMANTIUM_BLOCK.get()));
        wallBlock(ModBlocks.ADAMANTIUM_WALL.get(), blockTexture(ModBlocks.ADAMANTIUM_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.ADAMANTIUM_DOOR.get(), modLoc("block/adamantium_door_bottom"),
                modLoc("block/adamantium_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.ADAMANTIUM_TRAPDOOR.get(), modLoc("block/adamantium_trapdoor"),
                true, "cutout");

        blockItem(ModBlocks.ADAMANTIUM_STAIRS);
        blockItem(ModBlocks.ADAMANTIUM_SLAB);
        blockItem(ModBlocks.ADAMANTIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.ADAMANTIUM_FENCE_GATE);
        blockItem(ModBlocks.ADAMANTIUM_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(
                "minehammer:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(
                "minehammer:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() +
                        appendix
        ));
    }
    
}
