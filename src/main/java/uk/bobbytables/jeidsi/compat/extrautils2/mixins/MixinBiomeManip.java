package uk.bobbytables.jeidsi.compat.extrautils2.mixins;

import com.rwtema.extrautils2.biome.BiomeManip;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.dimdev.jeid.INewChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import uk.bobbytables.jeidsi.network.JEIDsIPacketHandler;
import uk.bobbytables.jeidsi.network.client.BiomeChangeMessage;

@Mixin(BiomeManip.class)
public class MixinBiomeManip {
    /**
     * Use JEID's Biome change packet as no need to reinvent the wheel
     * @author sk2048
     */
    @Overwrite
    public static void setBiome(World world, Biome biome, BlockPos pos) {
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
