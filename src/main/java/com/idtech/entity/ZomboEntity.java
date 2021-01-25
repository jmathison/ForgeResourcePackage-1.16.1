package com.idtech.entity;



import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ZomboEntity extends ZombieEntity {

    //TYPE
    public static EntityType<ZomboEntity> TYPE = (EntityType<ZomboEntity>)
            EntityType.Builder.create(ZomboEntity::new, EntityClassification.MONSTER).build("zombo").setRegistryName(BaseMod.MODID, "zombo");
    //EGG
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xb00101, 0xacbf1f);

    //Attributes.
    // Hopefully these functions will be named in the mappings soon.
    //for now this should help:
    /*
    field_233819_LETTER values from the Attributes class
    a - max_health
    b - follow range
    c - knockback_resistance
    d - movement_speed
    e - flying_speed
    f - attack_damage
    g - attack_knockback
    h - attack_speed
    i - armor
    j - armor_toughness
    k - luck
     */

    public static AttributeModifierMap.MutableAttribute setupAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233819_b_, 35.0D) //follow range
                .func_233815_a_(Attributes.field_233821_d_, (double) 0.4F) //movement_speed
                .func_233815_a_(Attributes.field_233823_f_, 5.0D) //attack_damage
                .func_233815_a_(Attributes.field_233826_i_, 2.0D) //armor
                .func_233814_a_(Attributes.field_233829_l_); //zombie.spawnreinforcements (this is required because of the super class )
    }

    //constructor
    public ZomboEntity(World worldIn){ super(TYPE, worldIn); }
    public ZomboEntity(EntityType type, World worldIn) { super(type, worldIn); }

    //AI
    @Override
    public void registerGoals() {
        this.targetSelector.addGoal(0, new SwimGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SheepEntity.class, false));
        this.targetSelector.addGoal(3, new MeleeAttackGoal(this, 0.8f, false));
        this.targetSelector.addGoal(4, (new HurtByTargetGoal(this)).setCallsForHelp(ZomboEntity.class));
        this.targetSelector.addGoal(5, (new HurtByTargetGoal(this)).setCallsForHelp(ZomboBearEntity.class));
        this.targetSelector.addGoal(8, new LookRandomlyGoal(this));

    }

    //turn off the burn in day thing. to turn it back on either remove this, or return true.
    protected boolean shouldBurnInDay() {
        return false;
    }

    //make it ride a polar bear!
    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        //necessary idk why but it throws an error
        spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, null);

        int random = this.world.rand.nextInt(100);

        if(random<10){

            //spawn in the polar bear and start to ride it.
            PolarBearEntity polarbear = (PolarBearEntity) Utils.spawnEntity(world, EntityType.POLAR_BEAR, this.getPositionUnderneath());
            this.startRiding(polarbear);

        }



        //OR make it ride the zombo bear:
//            ZomboBearEntity zombobear = (ZomboBearEntity) Utils.spawnEntity(world, ZomboBearEntity.TYPE, this.getPositionUnderneath());
//            this.startRiding(zombobear);


        if(random<30&&random>15) {
            //set the held item to golden axe. and give it a helmet
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_AXE));
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.GOLDEN_HELMET));
        }

        //necessary idk why but it throws an error
        return spawnDataIn;
    }


    //inventory drop method
    @Override
    protected void dropInventory() {
        super.dropInventory();

        //check every slot in the entity
        for(EquipmentSlotType slot : EquipmentSlotType.values()){
            //if there is something in that slot
            if(this.hasItemInSlot(slot)){
                //drop it
                this.entityDropItem(this.getItemStackFromSlot(slot));
            }

        }
    }

    @Override
    public boolean canEquipItem(ItemStack stack) {
        return super.canEquipItem(stack);
    }


}
