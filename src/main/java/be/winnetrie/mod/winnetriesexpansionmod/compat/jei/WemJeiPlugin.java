package be.winnetrie.mod.winnetriesexpansionmod.compat.jei;

import java.util.ArrayList;
import java.util.List;

import be.winnetrie.mod.winnetriesexpansionmod.WemConfig;
import be.winnetrie.mod.winnetriesexpansionmod.WemModule;
import be.winnetrie.mod.winnetriesexpansionmod.WinnetriesExpansionMod;
import be.winnetrie.mod.winnetriesexpansionmod.registry.ModItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;

/**
 * Optional JEI integration for WEM's quantity-sensitive Brewing Stand recipes.
 *
 * <p>This class is never referenced by WEM itself. JEI discovers it through
 * {@link JeiPlugin} when JEI is installed. The build dependency is compile-only,
 * so JEI remains completely optional at runtime.</p>
 */
@JeiPlugin
public final class WemJeiPlugin implements IModPlugin {
    private static final Identifier PLUGIN_UID = id("jei");

    @Override
    public Identifier getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        if (!WemConfig.isModuleEnabled(WemModule.DRINKS)) return;

        IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
        List<IJeiBrewingRecipe> recipes = new ArrayList<>();

        // A JEI Brewing Stand recipe displays the same lower input in all three
        // bottle slots. Therefore ingredient/output stack counts below describe
        // a full three-bottle WEM batch, matching what the player sees in JEI.
        addJuice(recipes, factory, "apple", new ItemStack(Items.APPLE, 9), false);
        addJuice(recipes, factory, "orange", wemStack("orange", 9), true);
        addJuice(recipes, factory, "peach", wemStack("peach", 9), true);
        addJuice(recipes, factory, "pear", wemStack("pear", 9), true);
        addJuice(recipes, factory, "lemon", wemStack("lemon", 9), true);
        addJuice(recipes, factory, "cherry", wemStack("cherry", 9), true);
        addJuice(recipes, factory, "plum", wemStack("plum", 9), true);

        addJuice(recipes, factory, "beetroot", new ItemStack(Items.BEETROOT, 9), false);
        addJuice(recipes, factory, "cactus", new ItemStack(Items.CACTUS, 9), false);
        addJuice(recipes, factory, "carrot", new ItemStack(Items.CARROT, 9), false);
        addJuice(recipes, factory, "chorusfruit", new ItemStack(Items.CHORUS_FRUIT, 3), false);
        addJuice(recipes, factory, "melon", new ItemStack(Items.MELON_SLICE, 9), false);
        addJuice(recipes, factory, "pumpkin", new ItemStack(Items.PUMPKIN, 3), false);

        // One Milk Bucket is consumed once for a full Brewing Stand operation,
        // producing one Milk Bottle in each occupied lower bottle slot.
        recipes.add(factory.createBrewingRecipe(
                List.of(new ItemStack(Items.MILK_BUCKET)),
                new ItemStack(Items.GLASS_BOTTLE),
                wemStack("milk_bottle", 3),
                id("jei/brewing/milk_bottle")));

        // Three sugar/cocoa per bottle -> nine for the three-bottle JEI display.
        recipes.add(factory.createBrewingRecipe(
                List.of(new ItemStack(Items.SUGAR, 9)),
                wemStack("milk_bottle", 1),
                wemStack("sweetened_milk_bottle", 3),
                id("jei/brewing/sweetened_milk_bottle")));
        recipes.add(factory.createBrewingRecipe(
                List.of(new ItemStack(Items.COCOA_BEANS, 9)),
                wemStack("sweetened_milk_bottle", 1),
                wemStack("chocolate_milk_bottle", 3),
                id("jei/brewing/chocolate_milk_bottle")));

        registration.addRecipes(RecipeTypes.BREWING, recipes);
    }

    private static void addJuice(List<IJeiBrewingRecipe> recipes, IVanillaRecipeFactory factory,
                                 String fruitId, ItemStack fullBatchIngredient, boolean needsFruits) {
        if (needsFruits && !WemConfig.isModuleEnabled(WemModule.FRUITS)) return;

        String blandId = "bland_" + fruitId + "_juice_bottle";
        String finalId = fruitId + "_juice_bottle";

        recipes.add(factory.createBrewingRecipe(
                List.of(fullBatchIngredient),
                waterBottle(),
                wemStack(blandId, 3),
                id("jei/brewing/" + blandId)));

        recipes.add(factory.createBrewingRecipe(
                List.of(new ItemStack(Items.SUGAR, 3)),
                wemStack(blandId, 1),
                wemStack(finalId, 3),
                id("jei/brewing/" + finalId)));
    }

    private static ItemStack waterBottle() {
        return PotionContents.createItemStack(Items.POTION, Potions.WATER);
    }

    private static ItemStack wemStack(String itemId, int count) {
        return new ItemStack(wemItem(itemId), count);
    }

    private static Item wemItem(String itemId) {
        var holder = ModItems.ITEMS_BY_ID.get(itemId);
        if (holder == null) {
            throw new IllegalStateException("Missing WEM JEI item: " + itemId);
        }
        return holder.get();
    }

    private static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(WinnetriesExpansionMod.MOD_ID, path);
    }
}
