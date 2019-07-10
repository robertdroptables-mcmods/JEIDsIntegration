package uk.bobbytables.jeidsi.core.init;

import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static uk.bobbytables.jeidsi.core.JEIDsILoadingPlugin.LOGGER;

public class InitPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {
    }
    
    @Override
    public String getRefMapperConfig() {
        return null;
    }
    
    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }
    
    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }
    
    @Override
    public List<String> getMixins() {
        return null;
    }
    
    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
    
    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        for (MethodNode methodNode : targetClass.methods) {
            Iterator<AbstractInsnNode> insnNodeIterator = methodNode.instructions.iterator();
            while (insnNodeIterator.hasNext()) {
                AbstractInsnNode abstractInsnNode = insnNodeIterator.next();
                
                if (abstractInsnNode.getOpcode() != Opcodes.LDC) continue;
                
                LdcInsnNode ldcInsnNode = (LdcInsnNode) abstractInsnNode;
                if (ldcInsnNode.cst.equals("mixins.jeid.modsupport.json")) {
                    LOGGER.info("JEID modsupport init method found: {}", methodNode.name);
                    LOGGER.info("Substituting our config at instruction {}", methodNode.instructions.indexOf(ldcInsnNode));
                    ldcInsnNode.cst = "mixins.jeidsi.jeidmodsupport.json";
                    return;
                }
            }
        }
        LOGGER.error("JEIDsI has not got a veto over JEID's mod support, report to JEIDsI");
    }
}
