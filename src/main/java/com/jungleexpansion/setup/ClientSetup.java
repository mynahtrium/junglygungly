package com.jungleexpansion.setup;

import com.jungleexpansion.JungleExpansion;
import com.jungleexpansion.client.model.MonkeyModel;
import com.jungleexpansion.client.renderer.MonkeyRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = JungleExpansion.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModRegistry.MONKEY.get(), MonkeyRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MonkeyModel.LAYER_LOCATION, MonkeyModel::createBodyLayer);
    }
}
