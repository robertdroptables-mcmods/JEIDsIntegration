package uk.bobbytables.jeidsi.init.mixins;

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
        Mixins.addConfiguration("mixins.jeidsi.abyssalcraft.json");
        Mixins.addConfiguration("mixins.jeidsi.bookshelf.json");
        Mixins.addConfiguration("mixins.jeidsi.thebetweenlands.json");
        Mixins.addConfiguration("mixins.jeidsi.tropicraft.json");
        Mixins.addConfiguration("mixins.jeidsi.twilightforest.json");
    }
}
