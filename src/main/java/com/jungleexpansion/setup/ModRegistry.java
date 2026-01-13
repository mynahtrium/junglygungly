package com.jungleexpansion.setup;

import com.jungleexpansion.JungleExpansion;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRegistry {
        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(JungleExpansion.MOD_ID);
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(JungleExpansion.MOD_ID);
        public static final net.neoforged.neoforge.registries.DeferredHolder<EntityType<?>, EntityType<com.jungleexpansion.content.entity.MonkeyEntity>> MONKEY = ENTITIES
                        .register("monkey",
                                        () -> EntityType.Builder
                                                        .of(com.jungleexpansion.content.entity.MonkeyEntity::new,
                                                                        net.minecraft.world.entity.MobCategory.CREATURE)
                                                        .sized(0.6F, 0.8F)
                                                        .build("monkey"));
        public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT,
                        JungleExpansion.MOD_ID);
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, JungleExpansion.MOD_ID);

        // Content Registration
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> BANANA_BUNCH = BLOCKS
                        .register("banana_bunch", com.jungleexpansion.content.block.BananaBunchBlock::new);
        public static final net.neoforged.neoforge.registries.DeferredHolder<Item, net.minecraft.world.item.BlockItem> BANANA_BUNCH_ITEM = ITEMS
                        .registerSimpleBlockItem("banana_bunch", BANANA_BUNCH);

        public static final net.neoforged.neoforge.registries.DeferredHolder<Item, Item> BANANA = ITEMS
                        .registerSimpleItem("banana",
                                        new Item.Properties().food(com.jungleexpansion.content.item.ModFoods.BANANA));

        // TREES - PALM
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> PALM_LOG = BLOCKS.register(
                        "palm_log",
                        () -> new net.minecraft.world.level.block.RotatedPillarBlock(
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties
                                                        .ofFullCopy(net.minecraft.world.level.block.Blocks.OAK_LOG)));
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> PALM_LEAVES = BLOCKS
                        .register("palm_leaves", () -> new net.minecraft.world.level.block.LeavesBlock(
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(
                                                        net.minecraft.world.level.block.Blocks.OAK_LEAVES)));
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> PALM_PLANKS = BLOCKS
                        .register("palm_planks", () -> new Block(
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(
                                                        net.minecraft.world.level.block.Blocks.OAK_PLANKS)));
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> PALM_SAPLING = BLOCKS
                        .register("palm_sapling", () -> new net.minecraft.world.level.block.SaplingBlock(
                                        com.jungleexpansion.content.worldgen.ModTreeGrowers.PALM,
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(
                                                        net.minecraft.world.level.block.Blocks.OAK_SAPLING)));

        // TREES - BANANA
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> BANANA_LOG = BLOCKS.register(
                        "banana_log",
                        () -> new net.minecraft.world.level.block.RotatedPillarBlock(
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(
                                                        net.minecraft.world.level.block.Blocks.JUNGLE_LOG)));
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> BANANA_LEAVES = BLOCKS
                        .register("banana_leaves", () -> new net.minecraft.world.level.block.LeavesBlock(
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(
                                                        net.minecraft.world.level.block.Blocks.JUNGLE_LEAVES)));
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> BANANA_PLANKS = BLOCKS
                        .register("banana_planks", () -> new Block(
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(
                                                        net.minecraft.world.level.block.Blocks.JUNGLE_PLANKS)));
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> BANANA_SAPLING = BLOCKS
                        .register("banana_sapling", () -> new net.minecraft.world.level.block.SaplingBlock(
                                        com.jungleexpansion.content.worldgen.ModTreeGrowers.BANANA,
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(
                                                        net.minecraft.world.level.block.Blocks.JUNGLE_SAPLING)));

        // TREES - MAHOGANY (Unique)
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> MAHOGANY_LOG = BLOCKS
                        .register("mahogany_log", () -> new net.minecraft.world.level.block.RotatedPillarBlock(
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(
                                                        net.minecraft.world.level.block.Blocks.DARK_OAK_LOG)));
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> MAHOGANY_LEAVES = BLOCKS
                        .register("mahogany_leaves", () -> new net.minecraft.world.level.block.LeavesBlock(
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(
                                                        net.minecraft.world.level.block.Blocks.DARK_OAK_LEAVES)));
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> MAHOGANY_PLANKS = BLOCKS
                        .register("mahogany_planks", () -> new Block(
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(
                                                        net.minecraft.world.level.block.Blocks.DARK_OAK_PLANKS)));
        public static final net.neoforged.neoforge.registries.DeferredHolder<Block, Block> MAHOGANY_SAPLING = BLOCKS
                        .register("mahogany_sapling", () -> new net.minecraft.world.level.block.SaplingBlock(
                                        com.jungleexpansion.content.worldgen.ModTreeGrowers.MAHOGANY,
                                        net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(
                                                        net.minecraft.world.level.block.Blocks.DARK_OAK_SAPLING)));

        // ITEM BLOCKS
        static {
                ITEMS.registerSimpleBlockItem("palm_log", PALM_LOG);
                ITEMS.registerSimpleBlockItem("palm_leaves", PALM_LEAVES);
                ITEMS.registerSimpleBlockItem("palm_planks", PALM_PLANKS);
                ITEMS.registerSimpleBlockItem("palm_sapling", PALM_SAPLING);

                ITEMS.registerSimpleBlockItem("banana_log", BANANA_LOG);
                ITEMS.registerSimpleBlockItem("banana_leaves", BANANA_LEAVES);
                ITEMS.registerSimpleBlockItem("banana_planks", BANANA_PLANKS);
                ITEMS.registerSimpleBlockItem("banana_sapling", BANANA_SAPLING);

                ITEMS.registerSimpleBlockItem("mahogany_log", MAHOGANY_LOG);
                ITEMS.registerSimpleBlockItem("mahogany_leaves", MAHOGANY_LEAVES);
                ITEMS.registerSimpleBlockItem("mahogany_planks", MAHOGANY_PLANKS);
                ITEMS.registerSimpleBlockItem("mahogany_sapling", MAHOGANY_SAPLING);
        }

        public static final net.neoforged.neoforge.registries.DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS
                        .register("jungle_expansion_tab", () -> CreativeModeTab.builder()
                                        .title(net.minecraft.network.chat.Component
                                                        .translatable("itemGroup.jungleexpansion"))
                                        .icon(() -> BANANA.get().getDefaultInstance())
                                        .displayItems((parameters, output) -> {
                                                output.accept(BANANA.get());
                                                output.accept(BANANA_BUNCH.get());
                                        }).build());

        public static void register(IEventBus modEventBus) {
                BLOCKS.register(modEventBus);
                ITEMS.register(modEventBus);
                ENTITIES.register(modEventBus);
                SOUNDS.register(modEventBus);
                CREATIVE_MODE_TABS.register(modEventBus);
                FEATURES.register(modEventBus);
        }
}
