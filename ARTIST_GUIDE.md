# Jungle Expansion - Artist & Modeler Guide

This guide is for 3D modelers (Blockbench) and Texture artists working on the Jungle Expansion mod.

## 🛠️ Blockbench Settings
When starting a new model in Blockbench, use the following settings:

### For Entities (Monkeys, Mobs)
*   **Project Type**: `Modded Entity`
*   **Model Identifier**: `monkey` (or entity name)
*   **File Name**: `MonkeyModel` (PascalCase ending in Model)
*   **Mappings/Version**: **MojMap** (Mojang Mappings).
    *   *Note: Do NOT use Yarn/Fabric mappings. This is a NeoForge mod.*
    *   Target Version: **1.21+**

### For Blocks & Items
*   **Project Type**: `Java Block/Item`
*   **Export Format**: `.json` model.

## 🐒 Modeling Entities (The Monkey)
We use standard Vanilla Minecraft rendering (no GeckoLib yet).

1.  **Root Group**: All cubes/bones must be inside a single root group named `root`.
    *   *Why?* The code expects `root.getChild("root")`.
2.  **Bones/Pivots**: Ensure pivot points are set correctly for animation.
    *   `head`: For looking around.
    *   `body`, `left_arm`, `right_arm`, `left_leg`, `right_leg`, `tail`: Standard names help with animation.
3.  **Texture Size**: Must be a power of 2 (e.g., 64x32, 64x64).
4.  **Exporting**:
    *   Go to `File` -> `Export` -> `Export Java Class`.
    *   **Class Name**: `MonkeyModel`
    *   **Package**: `com.jungleexpansion.client.model`
    *   **Open the file** and copy the code inside `createBodyLayer()` to send to the developer.

## 📦 Modeling Blocks & Items (Bananas, Trees)
### Blocks
*   **Texturing**: Keep textures in standard 16x16 resolution unless we decide on "HD".
*   **Parents**: Use `block/cube_all` for simple blocks.
*   **Display Settings**: IMPORTANT! Check the "Display" tab in Blockbench.
    *   Make sure it looks right in "Third Person", "First Person", and "GUI".
*   **Export**: Save as `blockname.json` (snake_case, e.g., `banana_bunch.json`).

### Items (3D)
*   If making a 3D item (like a handheld spear or complex fruit), use `Java Block/Item` mode.
*   If just a flat sprite, you don't need Blockbench (use Photoshop/Aseprite).

## 🎨 Texturing Guide
*   **Format**: `.png` only.
*   **Transparency**: Supported.
*   **Naming**: strictly `snake_case` (lowercase, underscores).
    *   ✅ `palm_log.png`
    *   ❌ `PalmLog.png`
    *   ❌ `palm log.png`

## 📂 Where to put files?
If you have access to the project folder:

### Textures
*   **Blocks**: `src/main/resources/assets/jungleexpansion/textures/block/`
*   **Items**: `src/main/resources/assets/jungleexpansion/textures/item/`
*   **Entities**: `src/main/resources/assets/jungleexpansion/textures/entity/`

### Models (JSON)
*   **Block Models**: `src/main/resources/assets/jungleexpansion/models/block/`
*   **Item Models**: `src/main/resources/assets/jungleexpansion/models/item/`

For **Java Models (Entities)**, send the `.java` file to the developer to integrate.
