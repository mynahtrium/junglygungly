package com.jungleexpansion.client.renderer;

import com.jungleexpansion.JungleExpansion;
import com.jungleexpansion.client.model.MonkeyModel;
import com.jungleexpansion.content.entity.MonkeyEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MonkeyRenderer extends MobRenderer<MonkeyEntity, MonkeyModel> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(JungleExpansion.MOD_ID,
            "textures/entity/monkey.png");

    public MonkeyRenderer(EntityRendererProvider.Context context) {
        super(context, new MonkeyModel(context.bakeLayer(MonkeyModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(MonkeyEntity entity) {
        return TEXTURE;
    }
}
