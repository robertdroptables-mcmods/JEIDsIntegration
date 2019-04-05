package uk.bobbytables.jeidsi.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import uk.bobbytables.jeidsi.JEIDsI;
import uk.bobbytables.jeidsi.network.client.BiomeChangeMessage;

public class JEIDsIPacketHandler {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(JEIDsI.MODID);

    public static void init() {
        INSTANCE.registerMessage(BiomeChangeMessage.Handler.class, BiomeChangeMessage.class, 0, Side.CLIENT);
    }
}
