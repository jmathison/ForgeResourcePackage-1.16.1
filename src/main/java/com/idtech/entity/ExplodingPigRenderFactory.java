package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class ExplodingPigRenderFactory implements IRenderFactory<ExplodingPigEntity> {

    public static ExplodingPigRenderFactory INSTANCE = new ExplodingPigRenderFactory();

    @Override
    public EntityRenderer<ExplodingPigEntity> createRenderFor(EntityRendererManager manager) {
        return new ExplodingPigRenderer(manager);
    }
}
