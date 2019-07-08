package uk.bobbytables.jeidsi.core.compat.twilightforest.mixins;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import twilightforest.block.BlockTFMagicLogSpecial;
import uk.bobbytables.jeidsi.network.JEIDsIPacketHandler;
import uk.bobbytables.jeidsi.network.client.BiomeChangeMessage;

@Mixin(value = BlockTFMagicLogSpecial.class, priority = 500)
public class MixinBlockTFMagicLogSpecialUpdate {
    // Put this in so JEID has something to overwrite - prevents crash
    private void sendChangedBiome(World world, BlockPos pos) {
        // Nothing here
    }
    
    /**
     * @author Dimensional Development team, sk2048
     */
    @Overwrite(remap = false)
    private void sendChangedBiome(World world, BlockPos pos, Biome biome) {
        IMessage message = new BiomeChangeMessage(pos.getX(), pos.getZ(), Biome.getIdForBiome(biome));
        JEIDsIPacketHandler.INSTANCE.sendToAllAround(
                message,
                new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), 128.0D, pos.getZ(), 128.0D)
        );
    }
}