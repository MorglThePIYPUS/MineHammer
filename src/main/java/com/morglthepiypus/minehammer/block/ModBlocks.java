package com.morglthepiypus.minehammer.block;

import com.morglthepiypus.minehammer.MineHammer;
import com.morglthepiypus.minehammer.block.custom.ImperiumLampBlock;
import com.morglthepiypus.minehammer.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MineHammer.MOD_ID);

    /* ********** IMPERIUM ********** */
    public static final RegistryObject<Block> ADAMANTIUM_ORE = registerBlock("adamantium_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of()
                            .strength(30f, 1200f)
                            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_ADAMANTIUM_ORE = registerBlock("deepslate_adamantium_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of()
                            .strength(40f, 1200f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> RAW_ADAMANTIUM_BLOCK = registerBlock("raw_adamantium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(15f, 1200f)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ADAMANTIUM_BLOCK = registerBlock("adamantium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(50f, 1200f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final RegistryObject<StairBlock> ADAMANTIUM_STAIRS = registerBlock("adamantium_stairs",
            () -> new StairBlock(ModBlocks.ADAMANTIUM_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(50f, 1200f)
                            .requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> ADAMANTIUM_SLAB = registerBlock("adamantium_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(50f, 1200f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> ADAMANTIUM_PRESSURE_PLATE = registerBlock("adamantium_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of()
                            .strength(50f, 1200f)
                            .requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> ADAMANTIUM_BUTTON = registerBlock("adamantium_button",
            () -> new ButtonBlock(BlockSetType.IRON, 10,
                    BlockBehaviour.Properties.of()
                            .strength(50f, 1200f)
                            .requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> ADAMANTIUM_FENCE = registerBlock("adamantium_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                            .strength(50f, 1200f)
                            .requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> ADAMANTIUM_FENCE_GATE = registerBlock("adamantium_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA,
                    BlockBehaviour.Properties.of()
                            .strength(50f, 1200f)
                            .requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> ADAMANTIUM_WALL = registerBlock("adamantium_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                            .strength(50f, 1200f)
                            .requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> ADAMANTIUM_DOOR = registerBlock("adamantium_door",
            () -> new DoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of()
                            .strength(50f, 1200f)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> ADAMANTIUM_TRAPDOOR = registerBlock("adamantium_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of()
                            .strength(50f, 1200f)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()));

    // Advanced
//    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock(
//            "magic_block",
//            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).noLootTable()));
    public static final RegistryObject<Block> IMPERIUM_LAMP = registerBlock("imperium_lamp",
            () -> new ImperiumLampBlock(BlockBehaviour.Properties.of().strength(3f)
                    .lightLevel(state -> state.getValue(ImperiumLampBlock.IS_CLICKED) ? 15 : 0)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
