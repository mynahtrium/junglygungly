package com.jungleexpansion.setup;

import com.jungleexpansion.JungleExpansion;
import com.jungleexpansion.content.entity.MonkeyEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = JungleExpansion.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(ModRegistry.MONKEY.get(), MonkeyEntity.createAttributes().build());
    }
}
