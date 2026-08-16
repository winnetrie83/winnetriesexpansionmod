# Port status — 5.0.0-dev1.15

Target: Minecraft 26.2 / NeoForge 26.2.0.59 / Java 25.

## Completed
- Solid block/item registry and modern resources are active and tested in-game.
- Limestone and marblestone world generation is active and tested.
- Dread Stone generates only in Warped Forests and replaces netherrack.
- Blood Stone generates only in Crimson Forests and replaces netherrack.
- Bricked Terracotta / Terracotta Bricks use standalone full PNG textures.
- Wool and glass/stained-glass slabs, stairs and walls are implemented.
- Glass stairs use seam-free custom JSON geometry and corrected item orientation.
- Compatibility-only gears, plates, molds, nuggets, ingots, metal storage blocks, grits, old metal parts, terracotta/clay buckets, tin ore and Brimstone are removed.
- The obsolete wooden/stone-tool disabling feature is removed.
- dev1.14 resource cleanup removed redundant item-model layers and proven orphan resources.

## Modular content — dev1.15
- Ten real module switches are active and default to enabled.
- Registry entries remain stable even when a module is disabled.
- Disabled modules are hidden from WEM's creative tab.
- 482 module recipes use `winnetriesexpansionmod:module_enabled` data-load conditions.
- All 407 module block loot tables use the same condition and become empty when disabled.
- Limestone, Marble, Dread Stone and Blood Stone configured features, placed features and biome modifiers are conditionally loaded with their owning module.
- Terracotta Bricks is intentionally one all-or-nothing chain for stained clayballs, stained clay, coloured bricks, Terracotta Bricks and Bricked Terracotta.

## Pending design work
1. Fluids: decide what still belongs in WEM before porting any fluid registration/rendering/container system.
