package com.morglthepiypus.minehammer.item;

import com.morglthepiypus.minehammer.MineHammer;
import com.morglthepiypus.minehammer.item.custom.FuelItem;
import com.morglthepiypus.minehammer.item.custom.ImperiumChiselItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MineHammer.MOD_ID);

    /* ********** GENERAL *********** */
    // Food Items
    public static final RegistryObject<Item> TYRANID_TORAX =
            ITEMS.register(
                    "tyranid_torax",
                    () -> new Item( new Item.Properties().food(ModFoodProperties.TYRANID_TORAX)));
    public static final RegistryObject<Item> COOKED_TYRANID_TORAX =
            ITEMS.register(
                    "cooked_tyranid_torax",
                    () -> new Item( new Item.Properties().food(ModFoodProperties.COOKED_TYRANID_TORAX)) {
                        @Override
                        public void appendHoverText(
                                ItemStack pStack,
                                TooltipContext pContext,
                                List<Component> pTooltipComponents,
                                TooltipFlag pTooltipFlag) {
                            pTooltipComponents.add(Component.translatable("tooltip.minehammer.cooked_tyranid_torax"));
                            super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                        }
                    });

    /* ********** IMPERIUM ********** */
    public static final RegistryObject<Item> ADAMANTIUM_INGOT =
            ITEMS.register("adamantium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ADAMANTIUM =
            ITEMS.register("raw_adamantium", () -> new Item(new Item.Properties()));

    // Fuel Items
    public static final RegistryObject<Item> PROMETHIUM_BLOB =
            ITEMS.register("promethium_blob", () -> new FuelItem(new Item.Properties(), 20000));

    // Advanced Items
    public static final RegistryObject<Item> IMPERIUM_CHISEL =
            ITEMS.register(
                    "imperium_chisel",
                    () -> new ImperiumChiselItem(new Item.Properties().durability(32)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
