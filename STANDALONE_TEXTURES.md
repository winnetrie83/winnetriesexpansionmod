# Standalone block textures

WEM does not compose decorative textures at runtime.

Rules:
- Every finished decorative block uses one complete PNG.
- Slab, stair and wall models reference the complete texture for their family.
- No shared runtime masks, texture overlays or composite model system.
- Bricked Terracotta uses the `*_bricked_terracotta` family.
- Terracotta Bricks uses the `*_terracotta_bricks` family.
- Removed concrete-brick and terracotta cracked/chiseled families remain removed.
- New Dread Stone and Blood Stone regular/smooth/brick families likewise use standalone textures.
