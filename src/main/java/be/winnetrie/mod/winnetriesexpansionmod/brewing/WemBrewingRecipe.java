package be.winnetrie.mod.winnetriesexpansionmod.brewing;

import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;

/**
 * Small runtime brewing recipe used to make WEM items valid Brewing Stand
 * inputs/ingredients. Quantity-sensitive consumption is finalized by
 * {@link WemBrewingHandler} in PotionBrewEvent.Pre.
 */
public final class WemBrewingRecipe implements IBrewingRecipe {
    private final Predicate<ItemStack> input;
    private final Predicate<ItemStack> ingredient;
    private final Supplier<ItemStack> output;
    private final BooleanSupplier enabled;

    public WemBrewingRecipe(Predicate<ItemStack> input, Predicate<ItemStack> ingredient,
                            Supplier<ItemStack> output, BooleanSupplier enabled) {
        this.input = input;
        this.ingredient = ingredient;
        this.output = output;
        this.enabled = enabled;
    }

    @Override
    public boolean isInput(ItemStack stack) {
        return enabled.getAsBoolean() && input.test(stack);
    }

    @Override
    public boolean isIngredient(ItemStack stack) {
        return enabled.getAsBoolean() && ingredient.test(stack);
    }

    @Override
    public ItemStack getOutput(ItemStack inputStack, ItemStack ingredientStack) {
        return isInput(inputStack) && isIngredient(ingredientStack) ? output.get().copy() : ItemStack.EMPTY;
    }
}
