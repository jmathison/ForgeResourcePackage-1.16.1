package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class ZomboRenderFactory implements IRenderFactory<ZombieEntity> {

    public static ZomboRenderFactory INSTANCE = new ZomboRenderFactory();

    @Override
    public EntityRenderer<? super ZombieEntity> createRenderFor(EntityRendererManager manager) {
        return new ZomboRenderer(manager);
    }
}
