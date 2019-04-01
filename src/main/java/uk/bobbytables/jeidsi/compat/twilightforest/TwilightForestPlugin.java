package uk.bobbytables.jeidsi.compat.twilightforest;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import uk.bobbytables.jeidsi.JEIDsILoadingPlugin;

import java.util.List;
import java.util.Set;

public class TwilightForestPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String s) {
    
    }
    
    @Override
    public String getRefMapperConfig() {
        return null;
    }
    
    @Override
    public boolean shouldApplyMixin(String s, String s1) {
        for (ModContainer mod : Loader.instance().getModList()) {
            if (mod.getModId().equals("twilightforest")) {
                if (s1.equals("MixinBlockTFMagicLogSpecialUpdate")) {
                    if (Integer.parseInt(mod.getVersion().split("[.]")[2]) > 689) {
                        JEIDsILoadingPlugin.LOGGER.info("Applying TF Network Mixin");
                        return true;
                    } else {
                        JEIDsILoadingPlugin.LOGGER.info("Not applying our TF Network Mixin, relying on JEID's");
                        return false;
                    }
                } else {
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
