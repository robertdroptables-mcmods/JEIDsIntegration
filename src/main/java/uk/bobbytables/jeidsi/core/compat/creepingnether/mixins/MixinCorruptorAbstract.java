package uk.bobbytables.jeidsi.core.compat.creepingnether.mixins;

import com.cutievirus.creepingnether.Ref;
import com.cutievirus.creepingnether.entity.CorruptorAbstract;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.dimdev.jeid.INewChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import uk.bobbytables.jeidsi.network.JEIDsIPacketHandler;
import uk.bobbytables.jeidsi.network.client.BiomeChangeMessage;

@Mixin(CorruptorAbstract.class)
public abstract class MixinCorruptorAbstract {
    @Shadow public abstract Biome getBiome();
    
    /***
     * @author sk2048
     */
    @Overwrite(remap = false)
    public void corruptBiome(World world, BlockPos pos) {
        if (!world.isBlockLoaded(pos)) return;
        Biome oldBiome = world.getBiome(pos);
        if (oldBiome == this.getBiome() || oldBiome != Biomes.HELL && this.getBiome() != Ref.biomeCreepingNether) return;
        Chunk chunk = world.getChunk(pos);
        ((INewChunk) chunk).getIntBiomeArray()[(pos.getZ() & 15) << 4 | pos.getX() & 15] = Biome.getIdForBiome(this.getBiome());
        if (!world.isRemote) {
            JEIDsIPacketHandler.INSTANCE.sendToAllAround(
                    new BiomeChangeMessage(pos.getX(), pos.getZ(), Biome.getIdForBiome(this.getBiome())),
                    new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), 128.0D, pos.getZ(), 128.0D)
            );
        }
    }
}
