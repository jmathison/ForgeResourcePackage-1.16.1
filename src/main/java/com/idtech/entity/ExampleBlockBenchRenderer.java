package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ExampleBlockBenchRenderer extends MobRenderer<ExampleBlockBenchEntity, ExampleBlockBenchModel<ExampleBlockBenchEntity>> {

    public ExampleBlockBenchRenderer(EntityRendererManager manager) {

        super(manager, new ExampleBlockBenchModel<ExampleBlockBenchEntity>(), 0.7F);
    }

    /**
     * Returns the location of an entity's texture.
     *
     * @param entity
     */
    @Override
    public ResourceLocation getEntityTexture(ExampleBlockBenchEntity entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/exampleblockbenchentitymodel.png");
    }
}