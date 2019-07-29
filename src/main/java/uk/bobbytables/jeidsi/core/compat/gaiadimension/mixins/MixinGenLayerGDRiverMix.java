package uk.bobbytables.jeidsi.core.compat.gaiadimension.mixins;

import androsa.gaiadimension.world.layer.GenLayerGDRiverMix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(GenLayerGDRiverMix.class)
public class MixinGenLayerGDRiverMix {
    @ModifyConstant(method = "func_75904_a", constant = @Constant(intValue = 255), remap = false)
    private int getBitMask(int oldValue) {
        return 0xFFFFFFFF;
    }
}
