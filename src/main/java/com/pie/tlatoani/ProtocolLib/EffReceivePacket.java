package com.pie.tlatoani.ProtocolLib;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

/**
 * Created by Tlatoani on 7/13/16.
 */
public class EffReceivePacket extends Effect{
    private Expression<PacketContainer> packetContainerExpression;
    private Expression<Player> playerExpression;

    @Override
    protected void execute(Event event) {
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        for (PacketContainer packet : packetContainerExpression.getArray(event)) {
            for (Player player : playerExpression.getArray(event)) {
                protocolManager.receiveClientPacket(player, packet);
            }
        }
    }

    @Override
    public String toString(Event event, boolean b) {
        return "receive packet " + packetContainerExpression + " from " + playerExpression;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        packetContainerExpression = (Expression<PacketContainer>) expressions[0];
        playerExpression = (Expression<Player>) expressions[1];
        return true;
    }
}
