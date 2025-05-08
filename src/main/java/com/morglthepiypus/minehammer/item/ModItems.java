package com.morglthepiypus.minehammer.item;

import com.morglthepiypus.minehammer.MineHammer;
import com.morglthepiypus.minehammer.item.custom.ImperiumChiselItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MineHammer.MOD_ID);

    /* ********** IMPERIUM ********** */
    public static final RegistryObject<Item> ADAMANTIUM_INGOT =
            ITEMS.register("adamantium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ADAMANTIUM =
            ITEMS.register("raw_adamantium", () -> new Item(new Item.Properties()));

    // Advanced Items
    public static final RegistryObject<Item> IMPERIUM_CHISEL =
            ITEMS.register(
                    "imperium_chisel",
                    () -> new ImperiumChiselItem(new Item.Properties().durability(32)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
