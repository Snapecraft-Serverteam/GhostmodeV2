package dev.pepe44.ghostmodev2.listener;

import dev.pepe44.ghostmodev2.GhostV2;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class PlayerQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (GhostV2.ghosted.contains(e.getPlayer())) GhostV2.ghosted.remove(e.getPlayer());
    }
}
