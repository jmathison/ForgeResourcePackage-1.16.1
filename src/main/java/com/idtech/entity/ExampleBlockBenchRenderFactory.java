package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class ExampleBlockBenchRenderFactory implements IRenderFactory<ExampleBlockBenchEntity> {

    public static ExampleBlockBenchRenderFactory INSTANCE = new ExampleBlockBenchRenderFactory();

    @Override
    public EntityRenderer<ExampleBlockBenchEntity> createRenderFor(EntityRendererManager manager) {
        return new ExampleBlockBenchRenderer(manager);
    }
}
