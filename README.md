# Winnetrie's Expansion Mod

Development source for Minecraft 26.2 / NeoForge 26.2.0.59 / Java 25.

WEM is a configurable expansion/content mod. Current solid content includes decorative building families, limestone and marblestone, Dread Stone in Warped Forests, Blood Stone in Crimson Forests, coloured wool shapes, glass/stained-glass shapes, drinks and remaining standalone utility ingredients.

## Modular content

Since 5.0.0-dev1.15, WEM has ten real content switches: Glass Variants, Wool Variants, Concrete Variants, Terracotta Variants, Terracotta Bricks, Limestone, Marble, Dread Stone, Blood Stone and Drinks. All default to enabled.

Registry IDs stay registered for save compatibility. A disabled module is removed from WEM's creative tab, its recipes do not load, and its block loot tables are disabled. Natural-stone modules also disable all of their world generation. See `MODULES.md` for exact ownership rules.

Legacy compatibility-only metal parts, molds, terracotta buckets, tin ore, Brimstone and the old vanilla wooden/stone-tool disabling feature have been permanently removed.

Current design work still pending:
- decide which legacy fluids belong in modern WEM and how they should work.
