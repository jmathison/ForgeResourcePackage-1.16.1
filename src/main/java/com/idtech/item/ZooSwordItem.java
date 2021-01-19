package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class ZooSwordItem extends SwordItem {

    private static Properties properties = new Properties().group(ItemGroup.MISC);
    public static Item INSTANCE = new ZooSwordItem(ItemTier.WOOD,2, 1, properties).setRegistryName(BaseMod.MODID,"zoosword");


    public ZooSwordItem(ItemTier tier, int speed, float damage, Properties properties) {
        super(tier, speed, damage, properties);

    }

    //method for when the sword hits an entity stack is this
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        //i am guessing that func_233580_cy_() gets the position of the entity
        BlockPos block = target.func_233580_cy_();

        //size of the array
        int size = 10;

        //create an array to hold animals
        EntityType animals[] = new EntityType[size];

        //fill the array with entities
        animals[0] = EntityType.BAT;
        animals[1] = EntityType.COW;
        animals[2] = EntityType.CHICKEN;
        animals[3] = EntityType.LLAMA;
        animals[4] = EntityType.POLAR_BEAR;
        animals[5] = EntityType.RABBIT;
        animals[6] = EntityType.PARROT;
        animals[7] = EntityType.PIG;
        animals[8] = EntityType.HORSE;
        animals[9] = EntityType.BEE;

        //select a random number from 0-10
        int rand = attacker.world.rand.nextInt(10);

        //decide what entity to spawn using the random number
        EntityType animalToSpawn = animals[rand];

        if(block != null) {
            //use the utils method to spawn entity.
            Utils.spawnEntity(attacker.world, animalToSpawn, block);
        }
        return super.hitEntity(stack, target, attacker);
    }

//    @Override
//    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
//
//        //i am guessing that func_233580_cy_() is something like getPosition because it returns a BlockPos
//        //(i'm right)
//        BlockPos block = entity.func_233580_cy_();
//
//        int size = 10;
//
//        EntityType animals[] = new EntityType[size];
//
//        animals[0] = EntityType.BAT;
//        animals[1] = EntityType.COW;
//        animals[2] = EntityType.CHICKEN;
//        animals[3] = EntityType.LLAMA;
//        animals[4] = EntityType.POLAR_BEAR;
//        animals[5] = EntityType.RABBIT;
//        animals[6] = EntityType.PARROT;
//        animals[7] = EntityType.PIG;
//        animals[8] = EntityType.HORSE;
//        animals[9] = EntityType.BEE;
//
//        int rand = entity.world.rand.nextInt(10);
//
//        EntityType animalToSpawn = animals[rand];
//
//        Utils.spawnEntity(entity.world, animalToSpawn,block);
//
//        return false;
//    }
}
