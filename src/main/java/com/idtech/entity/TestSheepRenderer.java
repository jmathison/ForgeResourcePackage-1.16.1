package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TestSheepRenderer extends MobRenderer<TestSheepEntity, TestSheepModel<TestSheepEntity>> {

    public TestSheepRenderer(EntityRendererManager manager) {

        super(manager, new TestSheepModel<TestSheepEntity>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(TestSheepEntity entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/sheepo.png");
    }
}
