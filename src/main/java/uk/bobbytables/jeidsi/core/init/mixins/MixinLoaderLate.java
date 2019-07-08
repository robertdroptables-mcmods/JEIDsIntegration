package uk.bobbytables.jeidsi.core.init.mixins;

import net.minecraftforge.fml.common.Loader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = Loader.class, priority = 1500)
public class MixinLoaderLate {
    @ModifyConstant(method = "handler$beforeConstructingMods$zza000", constant = @Constant(stringValue = "mixins.jeid.modsupport.json"), require = 1, remap = false)
    private String getConfig(String oldConfig) {
        return "mixins.jeidsi.jeidmodsupport.json";
    }
}
