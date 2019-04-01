package uk.bobbytables.jeidsi.compat.bookshelf.mixins;

import net.darkhax.bookshelf.lib.Constants;
import net.darkhax.bookshelf.util.WorldUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import org.dimdev.jeid.INewChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Arrays;

@Mixin(WorldUtils.class)
public abstract class MixinWorldUtils {
    
    /**
     * @author Darkhax, modified by sk2048
     */
    @Overwrite(remap = false)
    public static void setBiomes(World world, BlockPos pos, Biome biome) {
        try {
            final Chunk chunk = world.getChunk(pos);
            final int[] biomes = ((INewChunk) chunk).getIntBiomeArray();
            Arrays.fill(biomes, Biome.getIdForBiome(biome));
    
            WorldUtils.updateNearbyChunks(world, chunk, true, true);
        } catch (Exception e) {
            Constants.LOG.warn(e, "Unable to set biome for Pos: {}, Biome: {}", pos.toString(), biome.getRegistryName());
        }
    }
}
