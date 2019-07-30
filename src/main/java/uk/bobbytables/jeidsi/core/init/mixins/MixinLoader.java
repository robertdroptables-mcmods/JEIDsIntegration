package uk.bobbytables.jeidsi.core.init.mixins;

import net.minecraftforge.fml.common.Loader;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

/**
 * Inject into loadMods BEFORE JEID does, adding our configs to the mixin environment it uses
 */
@Mixin(value = Loader.class, priority = 500)
public class MixinLoader {
    @Inject(
            method = "loadMods",
            at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/common/LoadController;transition(Lnet/minecraftforge/fml/common/LoaderState;Z)V", ordinal = 1),
            remap = false
    )
    private void beforeModSupportMixins(List<String> injectedModContainers, CallbackInfo ci) {
        Mixins.addConfigurations(
                "mixins.jeidsi.abyssalcraft.json",
                "mixins.jeidsi.advancedrocketry.json",
                "mixins.jeidsi.bookshelf.json",
                "mixins.jeidsi.creepingnether.json",
                "mixins.jeidsi.cyclopscore.json",
                "mixins.jeidsi.extrautils2.json",
                "mixins.jeidsi.gaiadimension.json",
                "mixins.jeidsi.hammercore.json",
                "mixins.jeidsi.journeymap.json",
                "mixins.jeidsi.tofucraft.json",
                "mixins.jeidsi.thebetweenlands.json",
                "mixins.jeidsi.tropicraft.json",
                "mixins.jeidsi.twilightforest.json"
        );
    }
}
