package uk.bobbytables.jeidsi.core.compat.cyclopscore.mixins;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.cyclops.cyclopscore.helper.WorldHelpers;
import org.dimdev.jeid.INewChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import uk.bobbytables.jeidsi.network.JEIDsIPacketHandler;
import uk.bobbytables.jeidsi.network.client.BiomeChangeMessage;

@Mixin(WorldHelpers.class)
public class MixinWorldHelpers {
    @Overwrite
    public static void setBiome(World world, BlockPos pos, Biome biome) {
        Chunk chunk = world.getChunk(pos);
        ((INewChunk) chunk).getIntBiomeArray()[(pos.getZ() & 0xF) << 4 | pos.getX() & 0xF] = Biome.getIdForBiome(biome);
        chunk.markDirty();
        if (!world.isRemote) {
            JEIDsIPacketHandler.INSTANCE.sendToAllAround(
                    new BiomeChangeMessage(pos.getX(), pos.getZ(), Biome.getIdForBiome(biome)),
                    new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), 128.0D, pos.getZ(), 128.0D)
            );
        }
    }
}
