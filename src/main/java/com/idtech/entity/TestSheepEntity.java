package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TestSheepEntity extends SheepEntity {
    public static EntityType<TestSheepEntity> TYPE = (EntityType<TestSheepEntity>)
            EntityType.Builder.create(TestSheepEntity::new, EntityClassification.CREATURE).build("sheepo").setRegistryName(BaseMod.MODID, "sheepo");
    //EGG
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xb00101, 0xacbf1f);


    public TestSheepEntity(World worldIn){ super(TYPE, worldIn); }
    public TestSheepEntity(EntityType type, World worldIn) { super(type, worldIn); }

    public static AttributeModifierMap.MutableAttribute func_234225_eI_() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 8.0D).func_233815_a_(Attributes.field_233821_d_, (double)0.5F);
    }

}
