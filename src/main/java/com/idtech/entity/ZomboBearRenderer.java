package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PolarBearRenderer;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.util.ResourceLocation;

public class ZomboBearRenderer extends PolarBearRenderer {

    public ZomboBearRenderer(EntityRendererManager manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getEntityTexture(PolarBearEntity entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/zombobear.png");
    }
}
