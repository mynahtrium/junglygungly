package com.jungleexpansion.client.model;

import com.jungleexpansion.content.entity.MonkeyEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class MonkeyModel extends HierarchicalModel<MonkeyEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath("jungleexpansion", "monkey"), "main");
    private final ModelPart root;

    public MonkeyModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // PLACEHOLDER MODEL
        // To import a real model:
        // 1. Build in Blockbench.
        // 2. Export as 'Java Class' (Modded Entity).
        // 3. Copy the 'meshdefinition' logic from the exported file and paste it here.
        // 4. Ensure your texture offsets match the dimensions.

        // Current: Simple placeholder box
        partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(MonkeyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
            float netHeadYaw, float headPitch) {
        // Basic animation logic would go here
        this.root().getAllParts().forEach(ModelPart::resetPose);
    }
}
