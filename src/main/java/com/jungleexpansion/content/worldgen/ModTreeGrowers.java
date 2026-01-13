package com.jungleexpansion.content.worldgen;

import com.jungleexpansion.JungleExpansion;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower PALM = new TreeGrower(
            JungleExpansion.MOD_ID + ":palm",
            Optional.empty(), // Mega tree (optional)
            Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(JungleExpansion.MOD_ID, "palm"))),
            Optional.empty() // Bees (optional)
    );

    public static final TreeGrower BANANA = new TreeGrower(
            JungleExpansion.MOD_ID + ":banana",
            Optional.empty(),
            Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(JungleExpansion.MOD_ID, "banana"))),
            Optional.empty());

    public static final TreeGrower MAHOGANY = new TreeGrower(
            JungleExpansion.MOD_ID + ":mahogany",
            Optional.empty(),
            Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(JungleExpansion.MOD_ID, "mahogany"))),
            Optional.empty());
}
