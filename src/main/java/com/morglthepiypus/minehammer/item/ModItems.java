package com.morglthepiypus.minehammer.item;

import com.morglthepiypus.minehammer.MineHammer;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MineHammer.MOD_ID);

    public static final RegistryObject<Item> ADAMANTIUM_INGOT =
            ITEMS.register("adamantium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ADAMANTIUM =
            ITEMS.register("raw_adamantium", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
