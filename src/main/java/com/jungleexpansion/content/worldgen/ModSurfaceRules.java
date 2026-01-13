package com.jungleexpansion.content.worldgen;

import com.jungleexpansion.JungleExpansion;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceRules.RuleSource;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = SurfaceRules.state(Blocks.DIRT.defaultBlockState());
    private static final SurfaceRules.RuleSource GRASS_BLOCK = SurfaceRules
            .state(Blocks.GRASS_BLOCK.defaultBlockState());
    private static final SurfaceRules.RuleSource PODZOL = SurfaceRules.state(Blocks.PODZOL.defaultBlockState());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource isDenseRainforest = SurfaceRules.isBiome(ModBiomes.DENSE_RAINFOREST);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK),
                DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(isDenseRainforest,
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(net.minecraft.resources.ResourceLocation
                                                .fromNamespaceAndPath(JungleExpansion.MOD_ID, "podzol_noise"), 0.0),
                                        PODZOL),
                                grassSurface)));
    }
}
