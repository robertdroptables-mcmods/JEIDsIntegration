package uk.bobbytables.jeidsi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.bobbytables.jeidsi.network.JEIDsIPacketHandler;

@Mod(modid = JEIDsI.MODID, name = JEIDsI.NAME, version = JEIDsI.VERSION, dependencies = "required-after:jeid")
public class JEIDsI {
    public static final String MODID = "jeidsi";
    public static final String NAME = "JustEnoughIDs Integration";
    public static final String VERSION = "1.0.0";
    
    public static final Logger LOGGER = LogManager.getLogger("JEIDsI");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        JEIDsIPacketHandler.init();
    }
}