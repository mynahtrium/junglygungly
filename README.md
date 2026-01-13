# Jungle Expansion Mod - Developer Guide

## Overview
This mod adds new jungle content including Monkeys, Bananas, new Trees (Palm, Banana, Mahogany), and the Dense Rainforest biome.

## Project Structure
- **Main Class**: `com.jungleexpansion.JungleExpansion`
- **Registry**: `com.jungleexpansion.setup.ModRegistry`
- **Entities**: `com.jungleexpansion.content.entity`
- **WorldGen**: `com.jungleexpansion.content.worldgen`

## Adding Assets

### Textures
Place textures in `src/main/resources/assets/jungleexpansion/textures`:
- **Items**: `/item/banana.png`
- **Blocks**: `/block/palm_log.png`, `/block/banana_bunch.png`, etc.
- **Entities**: `/entity/monkey.png`

### Models
- **Block Models**: `src/main/resources/assets/jungleexpansion/models/block`
- **Item Models**: `src/main/resources/assets/jungleexpansion/models/item`
- **Entity Animations**: Use standard GeckoLib or Vanilla EntityModel formats.

### Sounds
1. Add sound files to `src/main/resources/assets/jungleexpansion/sounds/`.
2. Edit `src/main/resources/assets/jungleexpansion/sounds.json` to register them.

## Data Generation
To regenerate blockstates, loot tables, and tags:
1. Run `./gradlew runData`
2. Check `src/generated/resources/` for output.

## Adding New Content
1. **New Blocks/Items**: Add entry to `ModRegistry.java`.
2. **New Entity**: 
   - Create Entity class in `content/entity`.
   - Register in `ModRegistry`.
   - Create Renderer/Model in `client`.
   - Register Renderer in `ClientSetup`.
   - Add Attributes in `ModEvents`.

## Extending WorldGen
Modify `ModBiomes.java` to adjust biome parameters.
Modify `ModSurfaceRules.java` to change ground composition.
Trees are defined via `ModTreeGrowers` and require corresponding `ConfiguredFeature` and `PlacedFeature` JSONs in `src/main/resources/data/jungleexpansion/worldgen/`.

## Running
- **Client**: `./gradlew runClient`
- **Server**: `./gradlew runServer`
