package uk.bobbytables.jeidsi;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.bobbytables.jeidsi.network.JEIDsIPacketHandler;

import java.lang.reflect.Method;

@Mod(modid = JEIDsI.MODID, name = JEIDsI.NAME, version = JEIDsI.VERSION, dependencies = "required-after:jeid")
public class JEIDsI {
    public static final String MODID = "jeidsi";
    public static final String NAME = "JustEnoughIDs Integration";
    public static final String VERSION = "@VERSION@";
    
    public static final Logger LOGGER = LogManager.getLogger("JEIDsI");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        JEIDsIPacketHandler.init();
    }

    @Mod.EventHandler
    public void serverStarted(FMLServerStartedEvent event) {
    }
}