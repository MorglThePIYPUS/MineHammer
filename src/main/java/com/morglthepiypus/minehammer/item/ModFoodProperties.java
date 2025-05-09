package com.morglthepiypus.minehammer.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties COOKED_TYRANID_TORAX = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(12.8f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 400), 0.25f)
            .build();
}
