package com.morglthepiypus.minehammer.datagen;

import com.morglthepiypus.minehammer.MineHammer;
import com.morglthepiypus.minehammer.block.ModBlocks;
import com.morglthepiypus.minehammer.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MineHammer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        /* ********** GENERAL *********** */
        // Food Items
        basicItem(ModItems.TYRANID_TORAX.get());
        basicItem(ModItems.COOKED_TYRANID_TORAX.get());

        /* ********** IMPERIUM ********** */
        basicItem(ModItems.ADAMANTIUM_INGOT.get());
        basicItem(ModItems.RAW_ADAMANTIUM.get());

        buttonItem(ModBlocks.ADAMANTIUM_BUTTON, ModBlocks.ADAMANTIUM_BLOCK);
        fenceItem(ModBlocks.ADAMANTIUM_FENCE, ModBlocks.ADAMANTIUM_BLOCK);
        wallItem(ModBlocks.ADAMANTIUM_WALL, ModBlocks.ADAMANTIUM_BLOCK);

        simpleBlockItem(ModBlocks.ADAMANTIUM_DOOR);


        // Fuel Items
        basicItem(ModItems.PROMETHIUM_BLOB.get());
    }

    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                        mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(MineHammer.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                        mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(MineHammer.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                        mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(MineHammer.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(), ResourceLocation.parse("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(MineHammer.MOD_ID,
                        "item/" + item.getId().getPath()));
    }
}
