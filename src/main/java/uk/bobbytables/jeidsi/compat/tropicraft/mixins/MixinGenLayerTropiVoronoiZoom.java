package uk.bobbytables.jeidsi.compat.tropicraft.mixins;

import net.tropicraft.core.common.worldgen.genlayer.GenLayerTropiVoronoiZoom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(GenLayerTropiVoronoiZoom.class)
public class MixinGenLayerTropiVoronoiZoom {
    @ModifyConstant(method = "func_75904_a", constant = @Constant(intValue = 255), remap = false)
    private int getBitMask(int oldValue) {
        return 0xFFFFFFFF;
    }
}
