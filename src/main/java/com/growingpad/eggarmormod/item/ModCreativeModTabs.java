package com.growingpad.eggarmormod.item;

import com.growingpad.eggarmormod.EggArmorMod;
import com.growingpad.eggarmormod.item.custom.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EggArmorMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EGGARMOR_TAB = CREATIVE_MODE_TABS.register("eggarmor_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.EGG))
                    .title(Component.translatable("creativetab.eggarmor_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(new ItemStack(Items.EGG));

                        pOutput.accept(ModItems.HARD_EGG.get());
                        pOutput.accept(ModItems.EGG_HELMET.get());
                        pOutput.accept(ModItems.EGG_CHESTPLATE.get());
                        pOutput.accept(ModItems.EGG_LEGGINGS.get());
                        pOutput.accept(ModItems.EGG_BOOTS.get());
                    }).build());
    public static  void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
