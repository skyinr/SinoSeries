package games.moegirl.sinocraft.sinocore.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public abstract class AbstractMessagePacket {
    public AbstractMessagePacket() {
    }

    public AbstractMessagePacket(FriendlyByteBuf buf) {
    }

    public abstract void serialize(FriendlyByteBuf buf);
    public abstract void handle(Supplier<NetworkEvent.Context> context);
}
