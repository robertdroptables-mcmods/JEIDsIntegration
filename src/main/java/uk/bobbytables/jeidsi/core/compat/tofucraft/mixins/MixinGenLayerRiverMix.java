package uk.bobbytables.jeidsi.core.compat.tofucraft.mixins;

import cn.mcmod.tofucraft.world.gen.layer.GenLayerRiverMix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(GenLayerRiverMix.class)
public class MixinGenLayerRiverMix {
    @ModifyConstant(method = "func_75904_a", constant = @Constant(intValue = 255), remap = false)
    private int getBitMask(int oldValue) {
        return 0xFFFFFFFF;
    }
}
