# Runtime texture layering (dev1.8)

Terracotta and concrete decorative variants no longer use precomposed output PNGs.
The block models render a vanilla Minecraft base texture plus one of the three user-supplied mask textures at runtime.

Masks retained as source assets only:
- `base_brick.png`
- `base_chiseled.png`
- `base_cracked.png`

NeoForge block models use `neoforge:composite`; the overlay child uses the translucent render type.
Client item definitions use Minecraft's `minecraft:composite` item model rather than using the block composite loader directly.

