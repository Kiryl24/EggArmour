package com.growingpad.eggarmormod.item.custom;

import com.growingpad.eggarmormod.EggArmorMod;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EggArmorMod.MOD_ID);
    public static final RegistryObject<Item> EGGIUM_INGOT = ITEMS.register("eggium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EGG_HELMET = ITEMS.register("egg_helmet",
            () -> new ArmorItem(EggArmor.EGG, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EGG_CHESTPLATE = ITEMS.register("egg_chestplate",
            () -> new ArmorItem(EggArmor.EGG, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EGG_LEGGINGS = ITEMS.register("egg_leggings",
            () -> new ArmorItem(EggArmor.EGG, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EGG_BOOTS = ITEMS.register("egg_boots",
            () -> new ArmorItem(EggArmor.EGG, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    }
}
