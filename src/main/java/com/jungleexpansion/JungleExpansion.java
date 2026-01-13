package com.jungleexpansion;

import com.jungleexpansion.setup.ModRegistry;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.label.NameTagValues.SortRule;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.slf4j.Logger;

@Mod(JungleExpansion.MOD_ID)
public class JungleExpansion {
    public static final String MOD_ID = "jungleexpansion";
    public static final Logger LOGGER = LogUtils.getLogger();

    public JungleExpansion(IEventBus modEventBus, ModContainer modContainer) {
        // Register the CommonSetup method
        modEventBus.addListener(this::commonSetup);

        // Register all deferred mappings
        ModRegistry.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Jungle Expansion Setup Complete");
    }
}
