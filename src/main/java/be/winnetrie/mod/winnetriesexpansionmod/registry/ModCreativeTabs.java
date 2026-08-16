package be.winnetrie.mod.winnetriesexpansionmod.registry;

import be.winnetrie.mod.winnetriesexpansionmod.WemModule;
import be.winnetrie.mod.winnetriesexpansionmod.WinnetriesExpansionMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WinnetriesExpansionMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = TABS.register("main", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.winnetriesexpansionmod"))
                    .icon(() -> Items.BRICK.getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        ModItems.BLOCK_ITEMS_BY_ID.forEach((id, item) -> {
                            // Fruit leaves need a BlockItem for shears/pick-block,
                            // but should not clutter the normal creative tab.
                            if (id.endsWith("_leaves")) return;
                            if (WemModule.isContentEnabled(id)) output.accept(item.get());
                        });
                        ModItems.ITEMS_BY_ID.forEach((id, item) -> {
                            if (WemModule.isContentEnabled(id)) output.accept(item.get());
                        });
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        TABS.register(modEventBus);
    }

    private ModCreativeTabs() {}
}
