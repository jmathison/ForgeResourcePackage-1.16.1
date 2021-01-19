package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class ZomboBearRenderFactory implements IRenderFactory<PolarBearEntity> {

    public static ZomboBearRenderFactory INSTANCE = new ZomboBearRenderFactory();

    @Override
    public EntityRenderer<? super PolarBearEntity> createRenderFor(EntityRendererManager manager) {
        return new ZomboBearRenderer(manager);
    }
}




