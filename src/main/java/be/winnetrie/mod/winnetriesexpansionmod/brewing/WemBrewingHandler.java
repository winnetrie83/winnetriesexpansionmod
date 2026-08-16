package be.winnetrie.mod.winnetriesexpansionmod.brewing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

import be.winnetrie.mod.winnetriesexpansionmod.WemConfig;
import be.winnetrie.mod.winnetriesexpansionmod.WemModule;
import be.winnetrie.mod.winnetriesexpansionmod.registry.ModItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.brewing.PotionBrewEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

/**
 * Brewing Stand integration for WEM drinks.
 *
 * Juice stage: normally 3 ingredients per bottle -> Bland Juice.
 * Pumpkin and Chorus Fruit use 1 ingredient per bottle.
 * Finishing stage: 1 sugar per Bland Juice -> finished drink.
 * Sweetening stage: 3 sugar per Milk Bottle -> Sweetened Milk.
 * Chocolate stage: 3 cocoa beans per Sweetened Milk -> Chocolate Milk.
 *
 * Milk Bucket uses normal BrewingRecipe consumption so vanilla handles its
 * Bucket crafting remainder correctly.
 */
public final class WemBrewingHandler {
    private static final int[] BOTTLE_SLOTS = {0, 1, 2};
    private static final int INGREDIENT_SLOT = 3;

    private final List<BatchRule> batchRules = new ArrayList<>();

    public WemBrewingHandler() {
        // Tree-fruit juices. Apple stays available with Drinks even when Fruits is disabled.
        addJuiceRule(stack -> stack.is(Items.APPLE), "bland_apple_juice_bottle", 3, false);
        addJuiceRule(stack -> stack.is(item("orange")), "bland_orange_juice_bottle", 3, true);
        addJuiceRule(stack -> stack.is(item("peach")), "bland_peach_juice_bottle", 3, true);
        addJuiceRule(stack -> stack.is(item("pear")), "bland_pear_juice_bottle", 3, true);
        addJuiceRule(stack -> stack.is(item("lemon")), "bland_lemon_juice_bottle", 3, true);
        addJuiceRule(stack -> stack.is(item("cherry")), "bland_cherry_juice_bottle", 3, true);
        addJuiceRule(stack -> stack.is(item("plum")), "bland_plum_juice_bottle", 3, true);

        // Vanilla-ingredient juices. Pumpkin and Chorus Fruit deliberately use
        // one ingredient per bottle; the remaining juices use three.
        addJuiceRule(stack -> stack.is(Items.BEETROOT), "bland_beetroot_juice_bottle", 3, false);
        addJuiceRule(stack -> stack.is(Items.CACTUS), "bland_cactus_juice_bottle", 3, false);
        addJuiceRule(stack -> stack.is(Items.CARROT), "bland_carrot_juice_bottle", 3, false);
        addJuiceRule(stack -> stack.is(Items.CHORUS_FRUIT), "bland_chorusfruit_juice_bottle", 1, false);
        addJuiceRule(stack -> stack.is(Items.MELON_SLICE), "bland_melon_juice_bottle", 3, false);
        addJuiceRule(stack -> stack.is(Items.PUMPKIN), "bland_pumpkin_juice_bottle", 1, false);

        addFinishRule("bland_apple_juice_bottle", "apple_juice_bottle", false);
        addFinishRule("bland_orange_juice_bottle", "orange_juice_bottle", true);
        addFinishRule("bland_peach_juice_bottle", "peach_juice_bottle", true);
        addFinishRule("bland_pear_juice_bottle", "pear_juice_bottle", true);
        addFinishRule("bland_lemon_juice_bottle", "lemon_juice_bottle", true);
        addFinishRule("bland_cherry_juice_bottle", "cherry_juice_bottle", true);
        addFinishRule("bland_plum_juice_bottle", "plum_juice_bottle", true);
        addFinishRule("bland_beetroot_juice_bottle", "beetroot_juice_bottle", false);
        addFinishRule("bland_cactus_juice_bottle", "cactus_juice_bottle", false);
        addFinishRule("bland_carrot_juice_bottle", "carrot_juice_bottle", false);
        addFinishRule("bland_chorusfruit_juice_bottle", "chorusfruit_juice_bottle", false);
        addFinishRule("bland_melon_juice_bottle", "melon_juice_bottle", false);
        addFinishRule("bland_pumpkin_juice_bottle", "pumpkin_juice_bottle", false);

        // Milk Bottle + 3 Sugar per bottle -> Sweetened Milk.
        batchRules.add(new BatchRule(
                stack -> stack.is(item("milk_bottle")),
                stack -> stack.is(Items.SUGAR),
                () -> new ItemStack(item("sweetened_milk_bottle")),
                3,
                this::drinksEnabled));

        batchRules.add(new BatchRule(
                stack -> stack.is(item("sweetened_milk_bottle")),
                stack -> stack.is(Items.COCOA_BEANS),
                () -> new ItemStack(item("chocolate_milk_bottle")),
                3,
                this::drinksEnabled));
    }

    @SubscribeEvent
    public void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        // Quantity-sensitive recipes. The recipe advertises Brewing Stand
        // compatibility; PotionBrewEvent.Pre performs exact batch consumption.
        for (BatchRule rule : batchRules) {
            event.getBuilder().addRecipe(new WemBrewingRecipe(
                    rule.input(),
                    stack -> rule.ingredient().test(stack) && stack.getCount() >= rule.costPerBottle(),
                    rule.output(),
                    rule.enabled()));
        }

        // Milk Bucket + bottles -> Milk Bottles. Vanilla consumes one bucket per
        // brewing operation and places/drops the Bucket crafting remainder.
        event.getBuilder().addRecipe(new WemBrewingRecipe(
                stack -> stack.is(Items.GLASS_BOTTLE),
                stack -> stack.is(Items.MILK_BUCKET),
                () -> new ItemStack(item("milk_bottle")),
                this::drinksEnabled));

    }

    @SubscribeEvent
    public void beforeBrew(PotionBrewEvent.Pre event) {
        if (!drinksEnabled()) return;

        ItemStack ingredient = event.getItem(INGREDIENT_SLOT);
        if (ingredient.isEmpty()) return;

        // One Brewing Stand batch may contain different Bland Juices while using
        // sugar. Process each matching bottom slot and charge the exact per-bottle cost.
        int remaining = ingredient.getCount();
        int used = 0;
        boolean matchedWemBatch = false;

        for (int slot : BOTTLE_SLOTS) {
            ItemStack input = event.getItem(slot);
            if (input.isEmpty()) continue;

            BatchRule matched = null;
            for (BatchRule rule : batchRules) {
                if (!rule.enabled().getAsBoolean()) continue;
                if (rule.input().test(input) && rule.ingredient().test(ingredient)) {
                    matched = rule;
                    break;
                }
            }
            if (matched == null) continue;

            matchedWemBatch = true;
            if (remaining < matched.costPerBottle()) continue;

            event.setItem(slot, matched.output().get().copy());
            remaining -= matched.costPerBottle();
            used += matched.costPerBottle();
        }

        if (!matchedWemBatch) return;

        // Always cancel our quantity-sensitive recipe. This prevents vanilla
        // from additionally consuming one ingredient after our custom batch.
        if (used > 0) {
            ItemStack remainder = ingredient.copy();
            remainder.shrink(used);
            event.setItem(INGREDIENT_SLOT, remainder);
        }
        event.setCanceled(true);
    }

    private void addJuiceRule(Predicate<ItemStack> ingredient, String blandOutput, int costPerBottle, boolean needsFruits) {
        BooleanSupplier enabled = needsFruits ? this::fruitDrinksEnabled : this::drinksEnabled;
        batchRules.add(new BatchRule(
                WemBrewingHandler::isWaterBottle,
                ingredient,
                () -> new ItemStack(item(blandOutput)),
                costPerBottle,
                enabled));
    }

    private void addFinishRule(String blandInput, String finishedOutput, boolean needsFruits) {
        BooleanSupplier enabled = needsFruits ? this::fruitDrinksEnabled : this::drinksEnabled;
        batchRules.add(new BatchRule(
                stack -> stack.is(item(blandInput)),
                stack -> stack.is(Items.SUGAR),
                () -> new ItemStack(item(finishedOutput)),
                1,
                enabled));
    }

    private boolean drinksEnabled() {
        return WemConfig.isModuleEnabled(WemModule.DRINKS);
    }

    private boolean fruitDrinksEnabled() {
        return drinksEnabled() && WemConfig.isModuleEnabled(WemModule.FRUITS);
    }

    private static boolean isWaterBottle(ItemStack stack) {
        if (!stack.is(Items.POTION)) return false;
        PotionContents contents = stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        return contents.potion().map(holder -> holder.is(Potions.WATER)).orElse(false);
    }

    private static Item item(String id) {
        var holder = ModItems.ITEMS_BY_ID.get(id);
        if (holder == null) {
            throw new IllegalStateException("Missing WEM brewing item: " + id);
        }
        return holder.get();
    }

    private record BatchRule(
            Predicate<ItemStack> input,
            Predicate<ItemStack> ingredient,
            Supplier<ItemStack> output,
            int costPerBottle,
            BooleanSupplier enabled) {}
}
