package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class TestSheepRenderFactory implements IRenderFactory<TestSheepEntity> {

    public static TestSheepRenderFactory INSTANCE = new TestSheepRenderFactory();

    @Override
    public EntityRenderer<TestSheepEntity> createRenderFor(EntityRendererManager manager) {
        return new TestSheepRenderer(manager);
    }
}
