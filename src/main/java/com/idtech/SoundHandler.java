package com.idtech;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SoundHandler {

    public static SoundEvent oof;
    public static SoundEvent boing;

    static{
        oof = addSoundInfo("oof");
        boing = addSoundInfo("boing");
    }
    //This method lets us easily add new sounds and correctly set their registry name and location.
    private static SoundEvent addSoundInfo(String soundPath){
        ResourceLocation location = new ResourceLocation(BaseMod.MODID, soundPath);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(location);
        return event;
    }

    @SubscribeEvent
    public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(oof,boing);
    }
    //This method registers the sounds correctly

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        Entity theEntity = event.getEntity(); //Get the entity from the event
        if ((theEntity instanceof PlayerEntity || event.getEntityLiving() instanceof PlayerEntity) //Check to see if the entity that died was a player
                && event.getSource() == DamageSource.ANVIL) { //And that the player died specifically from an anvil falling on their head
            if (theEntity.world instanceof ServerWorld){ //Sounds should only play on the server version of the world

                ServerWorld serverWorld = (ServerWorld) event.getEntity().world;
                serverWorld.playSound(null, theEntity.getPosX(), theEntity.getPosY(), theEntity.getPosZ(), SoundHandler.oof, SoundCategory.MASTER, 1f, 1f);
                //Play the "oof" sound at the player's location of death.
            }
        }
    }
    /*.json files can't have comments so this will serve as the notes for sounds.json
    We simply have to connect each sound to the correct sound file. By custom, all sound file names are the same as
    the variable names in the SoundHandler class to avoid confusion. The sound category can be changed as desired, master is just the simplest
     */
}
