package uk.bobbytables.jeidsi.compat.twilightforest.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import twilightforest.world.layer.GenLayerTFRiverMix;

@Mixin(GenLayerTFRiverMix.class)
public class MixinGenLayerTFRiverMix {
    @ModifyConstant(method = "func_75904_a", constant = @Constant(intValue = 255), remap = false)
    private int getBitMask(int oldValue) {
        return 0xFFFFFFFF;
    }
}
