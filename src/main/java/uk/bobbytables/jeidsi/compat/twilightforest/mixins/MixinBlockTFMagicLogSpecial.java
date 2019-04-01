package uk.bobbytables.jeidsi.compat.twilightforest.mixins;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import org.dimdev.jeid.INewChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import twilightforest.biomes.TFBiomes;
import twilightforest.block.BlockTFMagicLogSpecial;
import uk.bobbytables.jeidsi.JEIDsILoadingPlugin;

import java.util.Random;

@Mixin(BlockTFMagicLogSpecial.class)
public class MixinBlockTFMagicLogSpecial {
    // For versions upto and including 3.8
    @Inject(method = "doTreeOfTransformationEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/Chunk;getBiomeArray()[B"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void onChangeBiome(World world, BlockPos pos, Random rand, CallbackInfo ci, int i, BlockPos dPos, Biome biomeAt, Chunk chunkAt) {
        ((INewChunk) chunkAt).getIntBiomeArray()[(dPos.getZ() & 15) << 4 | (dPos.getX() & 15)] = Biome.getIdForBiome(TFBiomes.enchantedForest);
    }
    
    // For versions 3.9 and later
    @Inject(method = "doTreeOfTransformationEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/Chunk;getBiomeArray()[B"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void onChangeBiome(World world, BlockPos pos, Random rand, CallbackInfo ci, Biome targetBiome, int i, BlockPos dPos, Biome biomeAt, Chunk chunkAt) {
        ((INewChunk) chunkAt).getIntBiomeArray()[(dPos.getZ() & 15) << 4 | (dPos.getX() & 15)] = Biome.getIdForBiome(targetBiome);
    }
}
