package be.winnetrie.mod.winnetriesexpansionmod.registry;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import be.winnetrie.mod.winnetriesexpansionmod.WinnetriesExpansionMod;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Registers item forms and standalone items. */
public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WinnetriesExpansionMod.MOD_ID);
    public static final Map<String, DeferredItem<BlockItem>> BLOCK_ITEMS_BY_ID = new LinkedHashMap<>();
    public static final Map<String, DeferredItem<? extends Item>> ITEMS_BY_ID = new LinkedHashMap<>();

    private static final List<String> STANDALONE_ITEMS = List.of(
            "apple_cider_bottle",
            "apple_juice_bottle",
            "beetroot_juice_bottle",
            "black_brick",
            "black_stained_clayball",
            "blue_brick",
            "blue_stained_clayball",
            "brown_brick",
            "brown_stained_clayball",
            "cactus_juice_bottle",
            "calcium_carbonate",
            "carrot_juice_bottle",
            "cherry_juice_bottle",
            "chocolate_milk_bottle",
            "chorusfruit_juice_bottle",
            "cyan_brick",
            "cyan_stained_clayball",
            "gray_brick",
            "gray_stained_clayball",
            "green_brick",
            "green_stained_clayball",
            "lemon_juice_bottle",
            "lightblue_brick",
            "lightblue_stained_clayball",
            "lime_brick",
            "lime_stained_clayball",
            "magenta_brick",
            "magenta_stained_clayball",
            "melon_juice_bottle",
            "natrium_carbonate",
            "orange",
            "peach",
            "pear",
            "plum",
            "orange_brick",
            "orange_stained_clayball",
            "pink_brick",
            "pink_stained_clayball",
            "plum_juice_bottle",
            "plum_wine_bottle",
            "cherry",
            "lemon",
            "pumpkin_juice_bottle",
            "purple_brick",
            "purple_stained_clayball",
            "red_brick",
            "red_stained_clayball",
            "silica",
            "silica_blend",
            "silver_brick",
            "silver_stained_clayball",
            "steel_shears",
            "tropical_juice_bottle",
            "white_brick",
            "white_stained_clayball",
            "yellow_brick",
            "yellow_stained_clayball"
    );

    static {
        // Blocks are classloaded first; then their inventory forms are registered here.
        // Hanging fruit blocks remain internal-only. Fruit leaves do have a
        // hidden BlockItem so shears and Creative pick-block can return leaves,
        // but the creative tab filters them out below.
        ModBlocks.BLOCKS_BY_ID.forEach((id, block) -> {
            if (id.endsWith("_hanging_fruit")) return;
            BLOCK_ITEMS_BY_ID.put(id, ITEMS.registerSimpleBlockItem(id, block));
        });

        STANDALONE_ITEMS.forEach(ModItems::registerStandaloneItem);
    }

    private static void registerStandaloneItem(String id) {
        if (id.endsWith("_bottle")) {
            ITEMS_BY_ID.put(id, ITEMS.registerSimpleItem(id, props -> props
                    .stacksTo(1)
                    .component(DataComponents.CONSUMABLE, Consumable.builder()
                            .consumeSeconds(1.6F)
                            .animation(ItemUseAnimation.DRINK)
                            .sound(SoundEvents.GENERIC_DRINK)
                            .hasConsumeParticles(false)
                            .build())
                    .usingConvertsTo(Items.GLASS_BOTTLE)));
        } else {
            ITEMS_BY_ID.put(id, ITEMS.registerSimpleItem(id));
        }
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    private ModItems() {}
}
