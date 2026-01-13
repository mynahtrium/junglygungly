package com.jungleexpansion.content.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class ModFoods {
    public static final FoodProperties BANANA = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.4f)
            .build();
}
