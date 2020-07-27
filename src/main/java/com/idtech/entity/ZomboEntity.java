package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.World;

public class ZomboEntity extends ZombieEntity {

    public static EntityType<ZomboEntity> TYPE = (EntityType<ZomboEntity>) EntityType.Builder.create(ZomboEntity::new, EntityClassification.MONSTER).build("zombo").setRegistryName(BaseMod.MODID, "zombo");
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xFFFFFF, 0x0000FF);

    // Setting up entity attributes. Hopefully these functions will be named in the mappings soon.
    public static AttributeModifierMap.MutableAttribute setupAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233819_b_, 35.0D).func_233815_a_(Attributes.field_233821_d_, (double)0.23F).func_233815_a_(Attributes.field_233823_f_, 3.0D).func_233815_a_(Attributes.field_233826_i_, 2.0D).func_233814_a_(Attributes.field_233829_l_);
    }
    public ZomboEntity(EntityType<? extends ZombieEntity> type, World worldIn) {
        super(type, worldIn);
    }
}
