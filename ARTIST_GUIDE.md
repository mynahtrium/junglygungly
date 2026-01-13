# Jungle Expansion - Ultimate Artist Guide

**Welcome to the team!** This guide will take you through every single click required to make assets for the Jungle Expansion mod (NeoForge 1.21).

---

## 🛠️ Phase 1: Setting Up Blockbench
*If you haven't installed Blockbench, get it at [blockbench.net](https://www.blockbench.net).*

### 1. Verification
1.  Open Blockbench.
2.  We **DO NOT** use the "Entity Wizard" (that is for Bedrock).
3.  We use the **Modded Entity** format.

---

## 🐒 Phase 2: Making a Mob (The Monkey)
*Use this process for any animated creature.*

### Step 1: Creating the Project
1.  Open Blockbench.
2.  Under "New Project", click **Modded Entity** (The icon looks like a Grass Block with a `Java` tag).
3.  **Model Settings Window** appears:
    *   **File Name**: `MonkeyModel` (PascalCase, must end in 'Model').
    *   **Model Identifier**: `monkey` (lowercase, everything else).
    *   **Texture Size**: `64` x `64` (or `64` x `32`).
        *   *CRITICAL: Width and Height must be Powers of 2 (16, 32, 64, 128).*
4.  Click **Confirm**.

### Step 2: The "Root" Rule (CRITICAL)
*Minecraft Java requires a specific hierarchy.*
1.  Look at the "Outliner" panel on the right (where groups/bones are).
2.  There is usually nothing there.
3.  Click the **"Add Group"** button (Folder icon with a +).
4.  **Rename this group** to `root`.
    *   *Right-click group -> Rename -> type "root"*
5.  **EVERYTHING YOU MAKE MUST BE INSIDE THIS "ROOT" GROUP.**
    *   *Technical Reason: Minecraft's `HierarchicalModel` system requires a single root bone to handle animations correctly. If you don't do this, the game may crash or animations won't play.*
    *   If you make a new bone for the head, drag it *into* `root`.

### Step 3: Skeleton Setup
1.  Select the `root` group.
2.  Click **Add Group** again. Rename it `body`.
3.  Select `body`. Click **Add Group**. Rename it `head`.
    *   *Now `head` is inside `body`. If you want the head to move independently (recommended), drag `head` out of `body` so it is inside `root`, just like `body`.*
4.  **Recommended Hierarchy**:
    ```text
    root
    ├── head
    ├── body
    ├── left_arm
    ├── right_arm
    ├── left_leg
    ├── right_leg
    └── tail
    ```

### Step 4: Modeling (The Fun Part)
1.  Select a group (e.g., `head`).
2.  Click **Add Cube** (Cube icon).
3.  **Edit Panel** (Top right, "Element"):
    *   **Pivot Point (CRITICAL)**:
        *   Press `P` (or use the Pivot tool).
        *   Move the **Blue Pivot Point** to where you want the joint to rotate.
        *   *Example: For an arm, put the pivot at the shoulder, not the center of the arm.*

### Step 5: Texturing
1.  **Texture Panel** (Bottom Left).
2.  Click **Create Texture** (Paper icon with +).
3.  **Settings**:
    *   **Name**: `monkey`
    *   **Template**: Checked (This autogenerates a texture based on your cubes!).
    *   **Color**: Pick a base monkey brown color.
    *   Click **Confirm**.
4.  **Save the Texture**:
    *   In the Texture Panel, right-click your texture -> **Save As**.
    *   Name: `monkey.png`
    *   Location: `src/main/resources/assets/jungleexpansion/textures/entity/`

### Step 6: Exporting the Code
1.  Go to `File` > `Export` > **Export Java Class**.
2.  **Popup Settings**:
    *   **Class Name**: `MonkeyModel`
    *   **Package**: `com.jungleexpansion.client.model`
3.  Click **Confirm**.
4.  Save the `.java` file.
5.  **Send this file to the Developer.**

---

## 🍌 Phase 3: Making Blocks (Banana Bunch)
*Use this for static blocks.*

### Step 1: Create Project
1.  File > New > **Java Block/Item**.
2.  Click **Confirm**.

### Step 2: Modeling
1.  Add Cubes. Shape them into a banana bunch.
2.  **Display Settings** (CRITICAL):
    *   Click the **Display** tab (Top Right).
    *   Click on the slots (Thirdperson Right, Firstperson Right, GUI, Ground, Fixed).
    *   Adjust scale/rotation so it looks good in the hand/inventory.

### Step 3: Texturing
1.  Create Texture (same as entity).
2.  Paint it.
3.  **Save Texture**: `banana_bunch.png` -> `src/main/resources/assets/jungleexpansion/textures/block/`

### Step 4: Exporting
1.  File > Export > **Export Block/Item Model**.
2.  Save as `banana_bunch.json` (snake_case!).
3.  Location: `src/main/resources/assets/jungleexpansion/models/block/`

---

## 📂 Cheat Sheet: Where do files go?

### Textures (`.png`)
*   **Blocks**: `src/main/resources/assets/jungleexpansion/textures/block/`
*   **Items**: `src/main/resources/assets/jungleexpansion/textures/item/`
*   **Mobs**: `src/main/resources/assets/jungleexpansion/textures/entity/`

### Models (`.json` or `.java`)
*   **Blocks**: `src/main/resources/assets/jungleexpansion/models/block/`
*   **Items**: `src/main/resources/assets/jungleexpansion/models/item/`
*   **Mobs**: Send `.java` file to Dev OR put in `src/main/java/com/jungleexpansion/client/model/`
