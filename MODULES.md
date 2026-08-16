# WEM content modules — 5.0.0-dev1.16.9

WEM keeps all block/item registry IDs registered for save compatibility. Module switches control normal availability instead:

- disabled module content is omitted from WEM's creative tab;
- module recipes are skipped by NeoForge data-load conditions;
- module block loot tables become empty while disabled;
- Limestone, Marble, Dread Stone and Blood Stone also skip all corresponding configured features, placed features and biome modifiers.

A full game/server restart is recommended after changing module settings. The module config is a NeoForge COMMON config, so multiplayer installations should use matching module settings on client and server for identical creative-tab visibility.

## Modules

- `glass_variants`: regular glass + all stained-glass slabs/stairs/walls.
- `wool_variants`: all 16 wool slabs/stairs/walls.
- `concrete_variants`: all 16 concrete slabs/stairs/walls.
- `terracotta_variants`: normal coloured terracotta slabs/stairs/walls.
- `terracotta_bricks`: one all-or-nothing chain containing stained clayballs, stained clay blocks, coloured brick items, Terracotta Bricks and Bricked Terracotta (including slabs/stairs/walls).
- `limestone`: all Limestone blocks/variants and Limestone world generation.
- `marble`: all Marblestone blocks/variants and Marblestone world generation.
- `dread_stone`: all Dread Stone regular/smooth/brick forms and Warped Forest generation.
- `blood_stone`: all Blood Stone regular/smooth/brick forms and Crimson Forest generation.
- `fruits`: Apple/Orange/Peach/Pear/Plum/Lemon trees, their saplings/leaves/hanging fruit, plus Cherry hanging fruit. When enabled, vanilla apples are removed from Oak and Dark Oak leaf drops so apples come from Apple Trees. When disabled, WEM fruit-tree content is unavailable and vanilla apple drops are untouched.
- `drinks`: all bottled juices, chocolate milk, cider and plum wine. Drinks based on optional WEM fruit (Cherry/Lemon/Plum and future Orange/Peach/Pear drinks) require both `drinks=true` and `fruits=true`. Apple Juice/Cider only require `drinks=true`, because apples are vanilla content.

All switches default to `true`.

## Intentionally outside the module list for now

`silica`, `silica_blend`, `calcium_carbonate`, `natrium_carbonate`, `steel_shears`, and the currently unported fluid assets remain outside the module system until their future role is decided.
