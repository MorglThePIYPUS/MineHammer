package com.morglthepiypus.minehammer.datagen;

import com.morglthepiypus.minehammer.MineHammer;
import com.morglthepiypus.minehammer.block.ModBlocks;
import com.morglthepiypus.minehammer.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        oreSmelting(
                pRecipeOutput,
                List.of(ModItems.TYRANID_TORAX.get()),
                RecipeCategory.MISC,
                ModItems.COOKED_TYRANID_TORAX.get(),
                0.5f,
                300,
                "cooked_tyranid_torax");
        oreSmoking(
                pRecipeOutput,
                List.of(ModItems.TYRANID_TORAX.get()),
                RecipeCategory.MISC,
                ModItems.COOKED_TYRANID_TORAX.get(),
                0.5f,
                150,
                "cooked_tyranid_torax");
        oreCampfireCooking(
                pRecipeOutput,
                List.of(ModItems.TYRANID_TORAX.get()),
                RecipeCategory.MISC,
                ModItems.COOKED_TYRANID_TORAX.get(),
                0.5f,
                900,
                "cooked_tyranid_torax");

        /* ********** IMPERIUM ********** */
        nineBlockStorageRecipes(
                pRecipeOutput,
                RecipeCategory.MISC,
                ModItems.ADAMANTIUM_INGOT.get(),
                RecipeCategory.MISC,
                ModBlocks.ADAMANTIUM_BLOCK.get());

        nineBlockStorageRecipes(
                pRecipeOutput,
                RecipeCategory.MISC,
                ModItems.RAW_ADAMANTIUM.get(),
                RecipeCategory.MISC,
                ModBlocks.RAW_ADAMANTIUM_BLOCK.get());

        List<ItemLike> ADAMANTIUM_SMELTABLES = List.of(
                ModItems.RAW_ADAMANTIUM.get(),
                ModBlocks.ADAMANTIUM_ORE.get(),
                ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get());
        oreSmelting(
                pRecipeOutput,
                ADAMANTIUM_SMELTABLES,
                RecipeCategory.MISC,
                ModItems.ADAMANTIUM_INGOT.get(),
                0.5f,
                400,
                "adamantium");
        oreBlasting(
                pRecipeOutput,
                ADAMANTIUM_SMELTABLES,
                RecipeCategory.MISC,
                ModItems.ADAMANTIUM_INGOT.get(),
                0.5f,
                150,
                "adamantium");

        stairBuilder(ModBlocks.ADAMANTIUM_STAIRS.get(), Ingredient.of(ModItems.ADAMANTIUM_INGOT.get()))
                .group("adamantium").unlockedBy(getHasName(ModItems.ADAMANTIUM_INGOT.get()),
                        has(ModItems.ADAMANTIUM_INGOT.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ADAMANTIUM_SLAB.get(),
                ModItems.ADAMANTIUM_INGOT.get());

        buttonBuilder(ModBlocks.ADAMANTIUM_BUTTON.get(), Ingredient.of(ModItems.ADAMANTIUM_INGOT.get()))
                .group("adamantium").unlockedBy(getHasName(ModItems.ADAMANTIUM_INGOT.get()),
                        has(ModItems.ADAMANTIUM_INGOT.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.ADAMANTIUM_PRESSURE_PLATE.get(), ModItems.ADAMANTIUM_INGOT.get());

        fenceBuilder(ModBlocks.ADAMANTIUM_FENCE.get(), Ingredient.of(ModItems.ADAMANTIUM_INGOT.get()))
                .group("adamantium").unlockedBy(getHasName(ModItems.ADAMANTIUM_INGOT.get()),
                        has(ModItems.ADAMANTIUM_INGOT.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.ADAMANTIUM_FENCE_GATE.get(), Ingredient.of(ModItems.ADAMANTIUM_INGOT.get()))
                .group("adamantium").unlockedBy(getHasName(ModItems.ADAMANTIUM_INGOT.get()),
                        has(ModItems.ADAMANTIUM_INGOT.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ADAMANTIUM_WALL.get(),
                ModItems.ADAMANTIUM_INGOT.get());

        doorBuilder(ModBlocks.ADAMANTIUM_DOOR.get(), Ingredient.of(ModItems.ADAMANTIUM_INGOT.get()))
                .group("adamantium").unlockedBy(getHasName(ModItems.ADAMANTIUM_INGOT.get()),
                        has(ModItems.ADAMANTIUM_INGOT.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.ADAMANTIUM_TRAPDOOR.get(), Ingredient.of(ModItems.ADAMANTIUM_INGOT.get()))
                .group("adamantium").unlockedBy(getHasName(ModItems.ADAMANTIUM_INGOT.get()),
                        has(ModItems.ADAMANTIUM_INGOT.get())).save(pRecipeOutput);
    }

    protected static void nineBlockStorageRecipes(
            RecipeOutput pRecipeOutput,
            RecipeCategory pUnpackedCategory,
            ItemLike pUnpacked,
            RecipeCategory pPackedCategory,
            ItemLike pPacked) {
        ShapedRecipeBuilder.shaped(pUnpackedCategory, pPacked)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', pUnpacked)
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked))
                .save(pRecipeOutput, MineHammer.MOD_ID + ":" + getItemName(pPacked)  + "_from_" + getItemName(pUnpacked));
        ShapelessRecipeBuilder.shapeless(pPackedCategory, pUnpacked, 9)
                .requires(pPacked)
                .unlockedBy(getHasName(pPacked), has(pUnpacked))
                .save(pRecipeOutput, MineHammer.MOD_ID + ":" + getItemName(pUnpacked)  + "_from_" + getItemName(pPacked));
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected static void oreCampfireCooking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_campfire_cooking");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, MineHammer.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
