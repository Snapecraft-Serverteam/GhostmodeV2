package dev.pepe44.ghostmodev2.listener;


import dev.pepe44.ghostmodev2.GhostV2;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {



    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        for (Player ghost : GhostV2.ghosted)

            if (!e.getPlayer().hasPermission("system.ghost.see")){
                e.getPlayer().hidePlayer(ghost);
            }
    }
}
