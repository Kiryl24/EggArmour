package com.growingpad.eggarmormod.event;

import com.growingpad.eggarmormod.item.custom.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber
public class ArmorEffectHandler {

    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();  // This retrieves the current level (world)

        // Check if we're on the server side and the entity is a player
        if (!level.isClientSide() && entity instanceof Player) {

            // Check if the player is wearing any piece of Egg Armor
            if (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.EGG_HELMET.get() ||
                    entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.EGG_CHESTPLATE.get() ||
                    entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.EGG_LEGGINGS.get() ||
                    entity.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.EGG_BOOTS.get()) {

                // Ensure the level is a ServerLevel (only do this on the server)
                if (level instanceof ServerLevel serverLevel) {
                    // 10% chance to spawn a chicken
                    if (RANDOM.nextFloat() < 0.1) {
                        // Create a new chicken entity
                        EntityType<?> chickenType = EntityType.CHICKEN;
                        var chicken = chickenType.create(serverLevel);

                        if (chicken != null) {
                            // Set the chicken's position slightly above the entity to avoid it getting stuck
                            chicken.moveTo(entity.getX(), entity.getY() + 1, entity.getZ(), entity.getYRot(), entity.getXRot());

                            // Spawn the chicken in the world
                            serverLevel.addFreshEntity(chicken);
                        }
                    }
                }
            }
        }
    }
}