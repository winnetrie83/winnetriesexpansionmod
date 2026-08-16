package be.winnetrie.mod.winnetriesexpansionmod.condition;

import be.winnetrie.mod.winnetriesexpansionmod.WemConfig;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.neoforged.neoforge.common.conditions.ICondition;

/** Data-load condition backed by WEM's central module configuration. */
public record ModuleEnabledCondition(String module) implements ICondition {
    public static final MapCodec<ModuleEnabledCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.STRING.fieldOf("module").forGetter(ModuleEnabledCondition::module)
    ).apply(instance, ModuleEnabledCondition::new));

    @Override
    public boolean test(IContext context) {
        return WemConfig.isModuleEnabled(this.module);
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}
