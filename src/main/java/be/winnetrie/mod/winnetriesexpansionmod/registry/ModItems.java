package be.winnetrie.mod.winnetriesexpansionmod.registry;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import be.winnetrie.mod.winnetriesexpansionmod.WinnetriesExpansionMod;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Registers item forms and standalone items. */
public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WinnetriesExpansionMod.MOD_ID);
    public static final Map<String, DeferredItem<BlockItem>> BLOCK_ITEMS_BY_ID = new LinkedHashMap<>();
    public static final Map<String, DeferredItem<? extends Item>> ITEMS_BY_ID = new LinkedHashMap<>();

    private static final List<String> STANDALONE_ITEMS = List.of(
            "apple_juice_bottle",
            "bland_apple_juice_bottle",
            "beetroot_juice_bottle",
            "bland_beetroot_juice_bottle",
            "black_brick",
            "black_stained_clayball",
            "blue_brick",
            "blue_stained_clayball",
            "brown_brick",
            "brown_stained_clayball",
            "cactus_juice_bottle",
            "bland_cactus_juice_bottle",
            "carrot_juice_bottle",
            "bland_carrot_juice_bottle",
            "cherry_juice_bottle",
            "bland_cherry_juice_bottle",
            "chocolate_milk_bottle",
            "chorusfruit_juice_bottle",
            "bland_chorusfruit_juice_bottle",
            "cyan_brick",
            "cyan_stained_clayball",
            "gray_brick",
            "gray_stained_clayball",
            "green_brick",
            "green_stained_clayball",
            "lemon_juice_bottle",
            "bland_lemon_juice_bottle",
            "bland_orange_juice_bottle",
            "bland_peach_juice_bottle",
            "bland_pear_juice_bottle",
            "lightblue_brick",
            "lightblue_stained_clayball",
            "lime_brick",
            "lime_stained_clayball",
            "magenta_brick",
            "magenta_stained_clayball",
            "melon_juice_bottle",
            "bland_melon_juice_bottle",
            "orange_juice_bottle",
            "peach_juice_bottle",
            "pear_juice_bottle",
            "milk_bottle",
            "orange",
            "peach",
            "pear",
            "plum",
            "orange_brick",
            "orange_stained_clayball",
            "pink_brick",
            "pink_stained_clayball",
            "plum_juice_bottle",
            "bland_plum_juice_bottle",
            "sweetened_milk_bottle",
            "cherry",
            "lemon",
            "pumpkin_juice_bottle",
            "bland_pumpkin_juice_bottle",
            "purple_brick",
            "purple_stained_clayball",
            "red_brick",
            "red_stained_clayball",
            "silver_brick",
            "silver_stained_clayball",
            "white_brick",
            "white_stained_clayball",
            "yellow_brick",
            "yellow_stained_clayball"
    );

    private static final Set<String> FINAL_JUICES = Set.of(
            "apple_juice_bottle",
            "orange_juice_bottle",
            "peach_juice_bottle",
            "pear_juice_bottle",
            "lemon_juice_bottle",
            "cherry_juice_bottle",
            "plum_juice_bottle",
            "beetroot_juice_bottle",
            "cactus_juice_bottle",
            "carrot_juice_bottle",
            "chorusfruit_juice_bottle",
            "melon_juice_bottle",
            "pumpkin_juice_bottle"
    );

    private static final Set<String> STACKS_TO_SIXTEEN_BOTTLES = Set.of(
            "apple_juice_bottle",
            "orange_juice_bottle",
            "peach_juice_bottle",
            "pear_juice_bottle",
            "lemon_juice_bottle",
            "cherry_juice_bottle",
            "plum_juice_bottle",
            "beetroot_juice_bottle",
            "cactus_juice_bottle",
            "carrot_juice_bottle",
            "chorusfruit_juice_bottle",
            "melon_juice_bottle",
            "pumpkin_juice_bottle",
            "bland_apple_juice_bottle",
            "bland_orange_juice_bottle",
            "bland_peach_juice_bottle",
            "bland_pear_juice_bottle",
            "bland_lemon_juice_bottle",
            "bland_cherry_juice_bottle",
            "bland_plum_juice_bottle",
            "bland_beetroot_juice_bottle",
            "bland_cactus_juice_bottle",
            "bland_carrot_juice_bottle",
            "bland_chorusfruit_juice_bottle",
            "bland_melon_juice_bottle",
            "bland_pumpkin_juice_bottle",
            "milk_bottle",
            "sweetened_milk_bottle",
            "chocolate_milk_bottle"
    );

    private static final FoodProperties FRUIT_JUICE_FOOD = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .alwaysEdible()
            .build();

    private static final FoodProperties MILK_BOTTLE_FOOD = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0.1F)
            .alwaysEdible()
            .build();

    private static final FoodProperties SWEETENED_MILK_FOOD = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .alwaysEdible()
            .build();

    private static final FoodProperties CHOCOLATE_MILK_FOOD = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3F)
            .alwaysEdible()
            .build();

    private static final Consumable FRUIT_JUICE_CONSUMABLE = Consumable.builder()
            .consumeSeconds(1.6F)
            .animation(ItemUseAnimation.DRINK)
            .sound(SoundEvents.GENERIC_DRINK)
            .hasConsumeParticles(false)
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.SPEED, 5 * 20, 0), 1.0F))
            .build();

    private static final Consumable CHORUS_JUICE_CONSUMABLE = Consumable.builder()
            .consumeSeconds(1.6F)
            .animation(ItemUseAnimation.DRINK)
            .sound(SoundEvents.GENERIC_DRINK)
            .hasConsumeParticles(false)
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.SPEED, 5 * 20, 0), 1.0F))
            .onConsume(new TeleportRandomlyConsumeEffect(16.0F))
            .build();

    private static final Consumable MILK_DRINK_CONSUMABLE = Consumable.builder()
            .consumeSeconds(1.6F)
            .animation(ItemUseAnimation.DRINK)
            .sound(SoundEvents.GENERIC_DRINK)
            .hasConsumeParticles(false)
            .build();

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
        // Bland juices deliberately behave like unfinished potion intermediates:
        // they are inventory items, but cannot be drunk until finished with sugar.
        if (id.startsWith("bland_") && id.endsWith("_bottle")) {
            ITEMS_BY_ID.put(id, ITEMS.registerSimpleItem(id,
                    props -> props.stacksTo(STACKS_TO_SIXTEEN_BOTTLES.contains(id) ? 16 : 1)));
        } else if (id.equals("milk_bottle")) {
            ITEMS_BY_ID.put(id, ITEMS.registerSimpleItem(id, props -> props
                    .stacksTo(16)
                    .food(MILK_BOTTLE_FOOD, MILK_DRINK_CONSUMABLE)
                    .usingConvertsTo(Items.GLASS_BOTTLE)));
        } else if (id.equals("sweetened_milk_bottle")) {
            ITEMS_BY_ID.put(id, ITEMS.registerSimpleItem(id, props -> props
                    .stacksTo(16)
                    .food(SWEETENED_MILK_FOOD, MILK_DRINK_CONSUMABLE)
                    .usingConvertsTo(Items.GLASS_BOTTLE)));
        } else if (id.equals("chocolate_milk_bottle")) {
            ITEMS_BY_ID.put(id, ITEMS.registerSimpleItem(id, props -> props
                    .stacksTo(16)
                    .food(CHOCOLATE_MILK_FOOD, MILK_DRINK_CONSUMABLE)
                    .usingConvertsTo(Items.GLASS_BOTTLE)));
        } else if (FINAL_JUICES.contains(id)) {
            Consumable juiceConsumable = id.equals("chorusfruit_juice_bottle")
                    ? CHORUS_JUICE_CONSUMABLE
                    : FRUIT_JUICE_CONSUMABLE;
            ITEMS_BY_ID.put(id, ITEMS.registerSimpleItem(id, props -> props
                    .stacksTo(16)
                    .food(FRUIT_JUICE_FOOD, juiceConsumable)
                    .usingConvertsTo(Items.GLASS_BOTTLE)));
        } else if (id.endsWith("_bottle")) {
            ITEMS_BY_ID.put(id, ITEMS.registerSimpleItem(id, props -> props
                    .stacksTo(STACKS_TO_SIXTEEN_BOTTLES.contains(id) ? 16 : 1)
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
