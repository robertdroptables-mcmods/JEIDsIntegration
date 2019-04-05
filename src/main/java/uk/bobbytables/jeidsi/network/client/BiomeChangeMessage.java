package uk.bobbytables.jeidsi.network.client;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.dimdev.jeid.INewChunk;

public class BiomeChangeMessage implements IMessage {
    private int x;
    private int z;
    private int biomeId;

    public BiomeChangeMessage() {}

    public BiomeChangeMessage(int x, int z, int biomeId) {
        this.x = x;
        this.z = z;
        this.biomeId = biomeId;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.x = buf.readInt();
        this.z = buf.readInt();
        this.biomeId = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(z);
        buf.writeInt(biomeId);
    }

    public static class Handler implements IMessageHandler<BiomeChangeMessage, IMessage> {
        @Override
        public IMessage onMessage(BiomeChangeMessage message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                WorldClient world = Minecraft.getMinecraft().world;
                Chunk chunk = world.getChunk(new BlockPos(message.x, 0, message.z));
                ((INewChunk) chunk).getIntBiomeArray()[(message.z & 15) << 4 | message.x & 15] = message.biomeId;
                world.markBlockRangeForRenderUpdate(new BlockPos(message.x, 0, message.z), new BlockPos(message.x, 0, message.z));
            });
            return null;
        }
    }
}
