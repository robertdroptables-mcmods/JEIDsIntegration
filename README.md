# JustEnoughIDs Integration [![Build Status](https://travis-ci.org/robertdroptables-mcmods/JEIDsIntegration.svg?branch=master)](https://travis-ci.org/robertdroptables-mcmods/JEIDsIntegration) [![CurseForge](http://cf.way2muchnoise.eu/318572.svg)](https://minecraft.curseforge.com/projects/justenoughids-integration-jeidsi)
This mod exists to improve the compatibility between JustEnoughIDs and other mods. Currently focussed on fixing issues arising as a result of biome IDs being extended.

## Mod Support Extended
* Abyssalcraft (only >1.9.6)
* Bookshelf
* CyclopsCore
* Extra Utilities 2
* The Betweenlands
* TofuCraft Reload
* Tropicraft
* Twilight Forest

## Fixes Incorporated
### AbyssalCraft
* AbyssalCraft now changes biomes as expected due to Dread Plague, Ritual of Cleansing and others

### Bookshelf
* Mods that rely on Bookshelf can now change the biome using WorldUtils#setBiomes when JEID is present
* This specifically addresses an issue in Hunting Dimension that prevented the Moss from working

### CyclopsCore
* Mods that depend on CyclopsCore can now change the biome using WorldHelpers#setBiome when JEID is present.
* This specifically addresses changes of biomes by EvilCraft

### Extra Utilities 2
* The Terraformer from ExU2 now functions in an environment where JEID is present

### The Betweenlands
* The Betweenlands dimension will now generate correctly when there are more then 256 biomes
* Spreading sludgy dirt will now be able to alter the biome as intended

### TofuCraft Reload
* Tofu dimension now generates correctly when more than 256 biomes are present

### Tropicraft
* Tropicraft dimension will now generate correctly when more than 256 biomes are present

### Twilight Forest
* Transformation Trees now change the biome they're in to Enchanted Forest as expected when activated
* Twilight Stream biomes will now correctly generate between the major biomes of the Twilight Forest as expected when more than 256 biomes are present
* Support for versions beyond 3.8 (JEID alone crashes on startup as of v1.0.2)
 

Suggestions, changes and requests are welcomed.
