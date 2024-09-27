package com.growingpad.eggarmormod.item.custom;

import com.growingpad.eggarmormod.EggArmorMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import java.util.function.Supplier;

public enum EggArmor implements ArmorMaterial {
    EGG("egg", 6,
            new int[] { 5, 7, 5, 4 },
            25,
            SoundEvents.ARMOR_EQUIP_TURTLE,1f,
            0f,
            () -> Ingredient.of((ModItems.EGGIUM_INGOT))
    );
    private final String name;
    private final int durabilityMultiplayer;
    private final int[] protectionAmount;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairMaterial;

    private static final int[] BASE_DURABILITY = new int[]{11, 16, 16, 13};

    EggArmor(String name, int durabilityMultiplayer, int[] protectionAmount, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.durabilityMultiplayer = durabilityMultiplayer;
        this.protectionAmount = protectionAmount;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = repairMaterial;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplayer;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmount[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return EggArmorMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
