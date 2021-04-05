package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.PigRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.ResourceLocation;

public class ExplodingPigRenderer extends MobRenderer<ExplodingPigEntity, ExplodingPigModel<ExplodingPigEntity>> {

    public ExplodingPigRenderer(EntityRendererManager manager) {

        super(manager, new ExplodingPigModel<ExplodingPigEntity>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(ExplodingPigEntity entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/explodingpig.png");
    }
}
