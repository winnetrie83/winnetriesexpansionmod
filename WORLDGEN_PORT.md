# World generation — 5.0.0-dev1.15

World generation affects newly generated chunks only. Limestone, Marble, Dread Stone and Blood Stone generation are each controlled by their matching WEM content module; disabling a module conditionally omits all of its configured features, placed features and biome modifiers on the next full game/server start.

## Limestone
- Water-focused deposits in river/ocean terrain.
- Replaces only `minecraft:stone`.
- Does not replace granite, diorite, andesite, deepslate, dirt, sand or gravel.

## Marblestone
- Underground stone-replacement veins plus exposed cave-floor/cave-ceiling deposits.
- Replaces only `minecraft:stone`.

## Dread Stone
- Generates only in `minecraft:warped_forest`.
- Replaces only `minecraft:netherrack`.
- Current placed feature: 25 attempts/chunk, vein size 49, Y 1..126.

## Blood Stone
- Generates only in `minecraft:crimson_forest`.
- Replaces only `minecraft:netherrack`.
- Current placed feature: 25 attempts/chunk, vein size 49, Y 1..126.

Tin ore and Brimstone world generation are permanently removed.
