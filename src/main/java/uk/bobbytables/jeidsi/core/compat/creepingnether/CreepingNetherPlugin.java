package uk.bobbytables.jeidsi.core.compat.creepingnether;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import uk.bobbytables.jeidsi.core.JEIDsILoadingPlugin;

import java.util.List;
import java.util.Set;

public class CreepingNetherPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String s) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String s, String s1) {
        JEIDsILoadingPlugin.LOGGER.info("Testing " + s1);
        for (ModContainer mod : Loader.instance().getModList()) {
            if (mod.getModId().equals("creepingnether")) {
                String[] modVersion = mod.getVersion().split("[.]");
                if (Integer.parseInt(modVersion[0]) >= 2 && Integer.parseInt(modVersion[1]) >= 2) {
                    JEIDsILoadingPlugin.LOGGER.info("Creeping Nether at v2.2.x, applying mixins");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }
}
