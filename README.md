# Winnetrie's Expansion Mod

**Winnetrie's Expansion Mod (WEM)** is a configurable content expansion for **Minecraft 26.2** on **NeoForge**. It expands vanilla-style building options, adds new natural stone families, fruit trees, drinks and related survival content while keeping the major content groups independently configurable.

> **Current source version:** `5.0.0-dev1.17.6.1`  
> **Minecraft:** `26.2`  
> **NeoForge:** `26.2.0.59+`  
> **Java:** `25`  
> **Mod ID:** `winnetriesexpansionmod`

## Features

### Building variants

WEM adds matching building shapes to several vanilla block families:

- Glass slabs, stairs and walls
- Stained Glass slabs, stairs and walls for all 16 colours
- Wool slabs, stairs and walls for all 16 colours
- Concrete slabs, stairs and walls for all 16 colours
- Terracotta slabs, stairs and walls for all 16 colours
- Terracotta Bricks and Bricked Terracotta families
- Slabs, stairs and walls for the supported WEM stone families

All decorative blocks use complete standalone textures. WEM does not rely on runtime texture overlays or texture compositing.

## Terracotta Bricks

The `terracotta_bricks` module contains a complete coloured clay and brick production chain.

For each supported colour:

1. **8 Clay Balls + 1 Dye** → 8 Stained Clayballs
2. **4 Stained Clayballs** → 1 Stained Clay
3. Stained Clay can also be converted back into 4 Stained Clayballs
4. Smelting a **Stained Clayball** produces a coloured Brick
5. **4 coloured Bricks** → 1 Terracotta Bricks block
6. Smelting **Stained Clay** produces the matching vanilla Terracotta
7. **4 matching Terracotta** → 4 Bricked Terracotta

Terracotta Bricks and Bricked Terracotta both have matching slabs, stairs and walls.

## Natural stone families

WEM currently contains four major natural stone families.

### Limestone

The Limestone family includes regular Limestone, cobble, bricks, cracked bricks, mossy variants, carved variants and matching building shapes.

**World generation:**

- Generates only in **River** and **Ocean** biomes
- Replaces only `minecraft:stone`
- Uses the river/ocean floor instead of a fixed Y level
- River deposits: **4 attempts per chunk**, radius **2–4**, approximately 3 blocks thick
- Ocean deposits: **3 attempts per chunk**, radius **2–3**, approximately 3 blocks thick
- Placement requires water at the generated position

Limestone is intended to be discoverable near and below natural bodies of water rather than as a generic underground ore.

### Marblestone

The Marblestone family includes regular Marblestone, cobble, bricks, cracked bricks, mossy variants, carved variants and matching building shapes.

Marblestone generates only in biomes classified as **hills or mountains**.

Examples include:

- Meadow
- Cherry Grove
- Grove
- Snowy Slopes
- Jagged Peaks
- Frozen Peaks
- Stony Peaks
- Windswept Hills
- Windswept Gravelly Hills
- Windswept Forest

**Underground veins:**

- Y **65–255**
- **2 attempts per chunk**
- Vein size **32**
- Replaces only `minecraft:stone`

**Exposed cave deposits:**

- Y **48–220**
- Searches both cave floors and cave ceilings
- **32 candidate placements per chunk** for each direction
- Searches up to 12 blocks through air for a stone surface
- Small deposits with radius **1–2**
- Replaces only `minecraft:stone`

### Dread Stone

Dread Stone is a dark green Nether stone family with regular, smooth and brick variants plus matching slabs, stairs and walls.

**World generation:**

- **Warped Forest only**
- Y **1–126**
- **25 attempts per chunk**
- Vein size **49**
- Replaces only `minecraft:netherrack`

### Blood Stone

Blood Stone is the Crimson Forest counterpart to Dread Stone and also includes regular, smooth and brick variants plus matching slabs, stairs and walls.

**World generation:**

- **Crimson Forest only**
- Y **1–126**
- **25 attempts per chunk**
- Vein size **49**
- Replaces only `minecraft:netherrack`

## Fruit system

The Fruits module adds six custom fruit-tree types:

- Apple
- Orange
- Peach
- Pear
- Plum
- Lemon

Cherry fruit uses **vanilla Cherry Trees** rather than adding a second cherry-tree type.

### Fruit mechanics

- Fruit grows as a hanging block underneath leaves
- Ripe fruit can be harvested with **right click**
- A hoe enchanted with **Fortune** can increase the harvest amount
- Fortune yield is `1 + random(0..Fortune level)`
- Harvested fruit locally regrows after approximately **30–60 seconds**
- Regrowth is handled by scheduled block ticks; WEM does not continuously scan the world
- Fruit remains dependent on its supporting leaf block
- Custom fruit saplings use **two growth stages**
- Bonemeal is supported with a **45% success chance per use**

### Fruit-tree world generation

Custom fruit trees generate rarely in selected vanilla biomes:

| Tree | Biomes | Approximate placement rate |
|---|---|---:|
| Apple | Plains, Forest, Birch Forest | 1 attempt / 18 eligible chunks |
| Pear | Forest, Birch Forest | 1 / 24 |
| Peach | Plains, Flower Forest | 1 / 28 |
| Plum | Forest, Taiga | 1 / 24 |
| Orange | Savanna, Jungle | 1 / 28 |
| Lemon | Savanna, Plains | 1 / 24 |

The custom fruit-tree biome lists deliberately avoid ocean, river, snowy and frozen biomes. Tree placement also requires a dry surface and a location where the corresponding sapling could survive.

When `fruits=false`, custom fruit-tree world generation is disabled.

### Cherry Trees

Cherry uses vanilla Cherry Trees and vanilla Cherry Saplings.

- Player-grown Cherry Trees receive WEM hanging cherries after the vanilla tree finishes growing
- Naturally generated trees in **Cherry Grove** receive cherries through a one-time world-generation pass
- Up to **5 initial cherries per tree** are placed
- Each suitable leaf position has a **25% placement chance** until that maximum is reached
- There is no recurring Cherry Grove scan after world generation

### Apples

When `fruits=true`, apples are supplied by WEM Apple Trees and vanilla Apple drops from Oak and Dark Oak Leaves are suppressed.

When `fruits=false`, WEM Apple Trees are unavailable and vanilla Apple drops remain unchanged.

## Drinks and Brewing

The Drinks module uses the vanilla **Brewing Stand** with custom quantity-aware brewing rules.

### Juice production

Most juices use two stages:

1. Water Bottle + fruit/ingredient → **Bland Juice**
2. Bland Juice + Sugar → finished Juice

Bland Juice is an intermediate item and cannot be consumed. Bland and finished drink bottles stack to **16**.

| Juice | Ingredient cost per bottle |
|---|---:|
| Apple Juice | 3 Apples |
| Orange Juice | 3 Oranges |
| Peach Juice | 3 Peaches |
| Pear Juice | 3 Pears |
| Lemon Juice | 3 Lemons |
| Cherry Juice | 3 Cherries |
| Plum Juice | 3 Plums |
| Beetroot Juice | 3 Beetroots |
| Cactus Juice | 3 Cactus |
| Carrot Juice | 3 Carrots |
| Melon Juice | 3 Melon Slices |
| Pumpkin Juice | 1 Pumpkin |
| Chorus Fruit Juice | 1 Chorus Fruit |

Finishing a Bland Juice costs **1 Sugar per bottle**.

For a full three-bottle Brewing Stand batch this means, for example:

- 3 Water Bottles + 9 Apples → 3 Bland Apple Juice
- 3 Bland Apple Juice + 3 Sugar → 3 Apple Juice
- 3 Water Bottles + 3 Pumpkins → 3 Bland Pumpkin Juice
- 3 Water Bottles + 3 Chorus Fruit → 3 Bland Chorus Fruit Juice

Finished juices:

- Restore **2 hunger points**
- Grant **Speed I for 5 seconds**
- Can be consumed even with a full hunger bar
- Return a Glass Bottle after drinking

**Chorus Fruit Juice** additionally performs the random teleport effect of vanilla Chorus Fruit.

### Milk drinks

The milk chain is:

1. **Milk Bucket + Glass Bottles** → Milk Bottles
2. Milk Bottle + **3 Sugar per bottle** → Sweetened Milk
3. Sweetened Milk + **3 Cocoa Beans per bottle** → Chocolate Milk

One Milk Bucket can fill all occupied Glass Bottle slots in one Brewing Stand operation and returns the empty Bucket remainder.

| Drink | Hunger | Cleansing effect |
|---|---:|---|
| Milk Bottle | 1 | Removes up to 1 harmful status effect |
| Sweetened Milk | 2 | Removes up to 2 harmful status effects |
| Chocolate Milk | 3 | Removes all removable active status effects, like vanilla milk |

All three milk drinks:

- Stack to **16**
- Can be consumed with a full hunger bar
- Return a Glass Bottle after drinking

While `drinks=true`, players cannot drink directly from a vanilla Milk Bucket. The Milk Bucket remains usable as a brewing/crafting ingredient. When `drinks=false`, vanilla Milk Bucket drinking remains unchanged.

## Fruits and Drinks module interaction

The Drinks module can remain enabled while Fruits is disabled.

With:

```text
fruits=false
drinks=true
```

these drinks remain normally available because they use vanilla ingredients:

- Apple Juice
- Beetroot Juice
- Cactus Juice
- Carrot Juice
- Melon Juice
- Pumpkin Juice
- Chorus Fruit Juice
- Milk Bottle
- Sweetened Milk
- Chocolate Milk

The following juices require WEM fruit and are unavailable when the Fruits module is disabled:

- Orange Juice
- Peach Juice
- Pear Juice
- Lemon Juice
- Cherry Juice
- Plum Juice

Apple Juice remains available because vanilla Apples still exist when Fruits is disabled.

## JEI support

**Just Enough Items (JEI) is optional.** WEM does not require JEI to run.

When JEI is installed, WEM registers its quantity-aware Brewing Stand recipes directly in JEI's standard Brewing category. JEI therefore shows the complete WEM juice and milk brewing chains, including Bland Juice intermediates and full three-bottle batch quantities.

JEI is only an optional compile-time integration and is not a required runtime dependency.

## Configuration

WEM uses a NeoForge **COMMON** configuration. All modules default to `true`.

| Config key | Controls |
|---|---|
| `glass_variants` | Glass and Stained Glass slabs, stairs and walls |
| `wool_variants` | Wool slabs, stairs and walls |
| `concrete_variants` | Concrete slabs, stairs and walls |
| `terracotta_variants` | Coloured Terracotta slabs, stairs and walls |
| `terracotta_bricks` | Stained Clayballs, Stained Clay, coloured Bricks, Terracotta Bricks, Bricked Terracotta and their building shapes |
| `limestone` | All Limestone content and Limestone world generation |
| `marble` | All Marblestone content and Marblestone world generation |
| `dread_stone` | All Dread Stone content and Warped Forest world generation |
| `blood_stone` | All Blood Stone content and Crimson Forest world generation |
| `fruits` | Fruit items, saplings, leaves, hanging fruit, fruit-tree world generation and Cherry integration |
| `drinks` | WEM juices, Bland Juice intermediates and milk drinks |

Registry IDs remain registered internally when a module is disabled. This is intentional for save compatibility. Disabled modules are instead removed from normal availability through creative-tab filtering, recipe/data conditions, loot conditions and world-generation conditions where applicable.

A restart is recommended after changing module settings.

## Installation

1. Install **Minecraft 26.2** with a compatible **NeoForge 26.2.0.59+** installation.
2. Place the WEM `.jar` in the Minecraft instance's `mods` directory.
3. Start the game once to allow NeoForge to create the configuration files.
4. Optionally install JEI for in-game recipe viewing.

WEM has no required third-party mod dependency beyond NeoForge.

## Building from source

Requirements:

- JDK **25**
- A compatible Gradle installation or working Gradle wrapper
- Internet access when dependencies need to be resolved

Common development commands:

```bash
./gradlew build
./gradlew runClient
./gradlew runServer
./gradlew runData
```

On Windows, use `gradlew.bat` instead of `./gradlew` when a wrapper is present.

The current project target is:

```text
Minecraft 26.2
NeoForge 26.2.0.59
Java 25
```

## World compatibility

WEM deliberately keeps registered block and item IDs stable when modules are switched off. This helps avoid missing registry entries when an existing world is loaded with a module disabled.

World-generation changes only affect **newly generated chunks**. Existing chunks are not retroactively populated with:

- Limestone
- Marblestone
- Dread Stone
- Blood Stone
- New fruit trees
- Cherry Grove fruit seeding

When testing newly added or changed world generation, use a new world or travel into terrain that has never previously been generated.

As with any development build, back up important worlds before updating between development versions.

## Project status

The current WEM scope is largely implemented and has been deliberately cleaned of obsolete legacy content. Old duplicate tool parts, metal-processing leftovers, Tin world generation and other abandoned systems have been removed from the active mod.

Some legacy fluid texture assets may still remain in the project for possible future use, but they are **not part of an active fluid gameplay system** in the current WEM release scope.

## Author

**Winnetrie**
