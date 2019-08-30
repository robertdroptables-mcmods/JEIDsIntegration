# JustEnoughIDs Integration [![Build Status](https://travis-ci.org/robertdroptables-mcmods/JEIDsIntegration.svg?branch=master)](https://travis-ci.org/robertdroptables-mcmods/JEIDsIntegration) [![CurseForge](http://cf.way2muchnoise.eu/318572.svg)](https://www.curseforge.com/minecraft/mc-mods/justenoughids-integration-jeidsi)
This mod exists to improve the compatibility between JustEnoughIDs and other mods. Currently focussed on fixing issues arising as a result of biome IDs being extended.

At the present time all fixed provided by this mod have been integrated into JEID. This mod is no longer necessary and will cause crashes if not removed when updating JEID to 1.0.3.

## Mod Support Extended
* Abyssalcraft (only >1.9.6)
* Advanced Rocketry
* Bookshelf
* CyclopsCore
* Extra Utilities 2
* HammerCore
* The Betweenlands
* The Creeping Nether
* TofuCraft Reload
* Tropicraft
* Twilight Forest

## Fixes Incorporated
### AbyssalCraft
* AbyssalCraft now changes biomes as expected due to Dread Plague, Ritual of Cleansing and others

### Advanced Rocketry
* Improves on JEID's support - laser effect will still work

### Bookshelf
* Mods that rely on Bookshelf can now change the biome using WorldUtils#setBiomes when JEID is present
* This specifically addresses an issue in Hunting Dimension that prevented the Moss from working

### CyclopsCore
* Mods that depend on CyclopsCore can now change the biome using WorldHelpers#setBiome when JEID is present.
* This specifically addresses changes of biomes by EvilCraft

### Extra Utilities 2
* The Terraformer from ExU2 now functions in an environment where JEID is present

### HammerCore
* Mods that rely on HammerCore are now able to change the Biome
* This includes Biome Paint Tools

### The Betweenlands
* The Betweenlands dimension will now generate correctly when there are more then 256 biomes
* Spreading sludgy dirt will now be able to alter the biome as intended

### The Creeping Nether
* Support for newer versions (see [here](https://www.curseforge.com/minecraft/mc-mods/the-creeping-nether/issues/7) and DimensionalDevelopment/JustEnoughIDs#48 - I don't believe this is resolved even in Github version)

### TofuCraft Reload
* Tofu dimension now generates correctly when more than 256 biomes are present

### Tropicraft
* Tropicraft dimension will now generate correctly when more than 256 biomes are present

### Twilight Forest
* Transformation Trees now change the biome they're in to Enchanted Forest as expected when activated
* Twilight Stream biomes will now correctly generate between the major biomes of the Twilight Forest as expected when more than 256 biomes are present
* Support for versions beyond 3.8 (JEID alone crashes on startup as of v1.0.2)
 

Suggestions, changes and requests are welcomed.
