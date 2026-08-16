package be.winnetrie.mod.winnetriesexpansionmod.event;

import java.util.List;

import be.winnetrie.mod.winnetriesexpansionmod.WemConfig;
import be.winnetrie.mod.winnetriesexpansionmod.WemModule;
import be.winnetrie.mod.winnetriesexpansionmod.registry.ModItems;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

/** Gameplay rules for WEM drinks. */
public final class DrinkEffectsHandler {

    /**
     * When the Drinks module is enabled, milk is meant to be consumed from WEM
     * bottles instead of directly from a vanilla milk bucket. This only blocks
     * starting the drinking action; the bucket remains usable in brewing and
     * crafting recipes.
     */
    @SubscribeEvent
    public void onUseStart(LivingEntityUseItemEvent.Start event) {
        if (!WemConfig.isModuleEnabled(WemModule.DRINKS)) return;
        if (event.getItem().is(Items.MILK_BUCKET)) {
            event.setCanceled(true);
        }
    }

    /** Apply the cleansing strength of the three milk drinks after consumption. */
    @SubscribeEvent
    public void onUseFinish(LivingEntityUseItemEvent.Finish event) {
        if (!WemConfig.isModuleEnabled(WemModule.DRINKS)) return;

        LivingEntity entity = event.getEntity();
        if (entity.level().isClientSide()) return;

        ItemStack used = event.getItem();
        if (used.is(ModItems.ITEMS_BY_ID.get("milk_bottle").get())) {
            removeNegativeEffects(entity, 1);
        } else if (used.is(ModItems.ITEMS_BY_ID.get("sweetened_milk_bottle").get())) {
            removeNegativeEffects(entity, 2);
        } else if (used.is(ModItems.ITEMS_BY_ID.get("chocolate_milk_bottle").get())) {
            // Match vanilla milk: clear every removable active status effect,
            // including beneficial effects.
            entity.removeAllEffects();
        }
    }

    private static void removeNegativeEffects(LivingEntity entity, int maximum) {
        int removed = 0;
        for (MobEffectInstance instance : List.copyOf(entity.getActiveEffects())) {
            if (removed >= maximum) break;
            if (instance.getEffect().value().getCategory() != MobEffectCategory.HARMFUL) continue;
            if (entity.removeEffect(instance.getEffect())) {
                removed++;
            }
        }
    }
}
