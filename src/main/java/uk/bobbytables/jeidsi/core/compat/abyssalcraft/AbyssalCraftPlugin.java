package uk.bobbytables.jeidsi.core.compat.abyssalcraft;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

// Not strictly necessary anymore, not referenced from config but leaving present for time being
public class AbyssalCraftPlugin implements IMixinConfigPlugin {
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
            if (mod.getModId().equals("abyssalcraft")) {
                return true;
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
