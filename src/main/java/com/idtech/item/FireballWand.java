//package com.idtech.item;
//
//import com.idtech.BaseMod;
//import com.idtech.Utils;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.projectile.FireballEntity;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.ActionResult;
//import net.minecraft.util.Hand;
//import net.minecraft.util.math.vector.Vector3d;
//import net.minecraft.world.World;
//
//public class FireballWand extends Item {
//
//    //properties object
//    public static Item.Properties properties = new Item.Properties().group(ItemGroup.MISC);
//    //static instance for registration
//    public static Item INSTANCE = new FireballWand(properties).setRegistryName(BaseMod.MODID, "fireballwand");
//
//    public FireballWand(Properties p){
//        super(p);
//    }
//
//
//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//
//        // need a better way to get living entity than casting lol
//
//        LivingEntity livingentity = Utils.getEntityAtCursor(playerIn, 100);
//        if(livingentity != null) {
//            double d0 = 64.0D;
//            double d1 = 4.0D;
//            Vector3d vector3d = playerIn.getLook(1.0F);
//            double d2 = livingentity.getPosX() - (playerIn.getPosX() + vector3d.x * 4.0D);
//            double d3 = livingentity.getPosYHeight(0.5D) - (0.5D + playerIn.getPosYHeight(0.5D));
//            double d4 = livingentity.getPosZ() - (playerIn.getPosZ() + vector3d.z * 4.0D);
//            if (!playerIn.isSilent()) {
//                worldIn.playEvent((PlayerEntity) null, 1016, playerIn.func_233580_cy_(), 0);
//            }
//
//            FireballEntity fireballentity = new FireballEntity(worldIn, playerIn, d2, d3, d4);
//            fireballentity.explosionPower = 100;
//            fireballentity.setPosition(playerIn.getPosX() + vector3d.x * 4.0D, playerIn.getPosYHeight(0.5D) + 0.5D, fireballentity.getPosZ() + vector3d.z * 4.0D);
//            worldIn.addEntity(fireballentity);
//        }
//        return super.onItemRightClick(worldIn, playerIn, handIn);
//    }
//}
