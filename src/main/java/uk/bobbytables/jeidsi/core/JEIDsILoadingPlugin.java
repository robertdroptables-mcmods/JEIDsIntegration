package uk.bobbytables.jeidsi.core;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
@IFMLLoadingPlugin.SortingIndex(-8000)
public class JEIDsILoadingPlugin implements IFMLLoadingPlugin {
    public static final Logger LOGGER = LogManager.getLogger("jeidsi_core");
    
    public JEIDsILoadingPlugin() {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.jeid.server.init.json"); // We NEED JEID's Loader plugin on the server too
        Mixins.addConfiguration("mixins.jeidsi.init.json");
    }
    
    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }
    
    @Override
    public String getModContainerClass() {
        return null;
    }
    
    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }
    
    @Override
    public void injectData(Map<String, Object> data) {
    
    }
    
    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
