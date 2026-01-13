package com.jungleexpansion.content.worldgen;

import com.jungleexpansion.JungleExpansion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes {
    public static final ResourceKey<Biome> DENSE_RAINFOREST = ResourceKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(JungleExpansion.MOD_ID, "dense_rainforest"));

    public static Biome denseRainforest(
            net.minecraft.core.HolderGetter<net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver<?>> carvers,
            net.minecraft.core.HolderGetter<net.minecraft.world.level.levelgen.placement.PlacedFeature> placedFeatures) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        // Add Monkey spawn here (need entity type accessible or via tag)

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, carvers);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSprings(biomeBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeBuilder);

        // Add Jungle vegetation
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_JUNGLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_MELON);

        // TODO: Add Custom trees

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.9F)
                .temperature(0.95F)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects(new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder()
                        .waterColor(0x2CB03C)
                        .waterFogColor(0x23822B)
                        .fogColor(0x114411) // Foggy ambience
                        .skyColor(0x78A7FF)
                        .foliageColorOverride(0x1B6B1B)
                        .grassColorOverride(0x1B6B1B)
                        .build())
                .build();
    }
}
