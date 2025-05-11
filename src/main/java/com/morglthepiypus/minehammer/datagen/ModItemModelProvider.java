package com.morglthepiypus.minehammer.datagen;

import com.morglthepiypus.minehammer.MineHammer;
import com.morglthepiypus.minehammer.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

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

        // Fuel Items
        basicItem(ModItems.PROMETHIUM_BLOB.get());
    }
}
