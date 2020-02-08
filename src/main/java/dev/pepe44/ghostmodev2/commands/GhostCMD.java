package dev.pepe44.ghostmodev2.commands;

import dev.pepe44.ghostmodev2.GhostV2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GhostCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender cs, Command arg1, String arg2, String[] args) {
        if (!(cs instanceof Player))
            return true;

        Player p = (Player) cs;

        if (!p.hasPermission("system.ghost")) return true;


        if (args.length == 0) {
            if (GhostV2.ghosted.contains(p)) {
                GhostV2.ghosted.remove(p);
                p.sendMessage(GhostV2.Prefix + "Du bist nun Sichtbar!");
                p.setAllowFlight(false);
                p.setPlayerListName(p.getPlayerListName().replace("§8[§6Ghost§8]", ""));
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.showPlayer(p);
                }
            } else {
                GhostV2.ghosted.add(p);
                p.sendMessage(GhostV2.Prefix + "Du bist nun Unsichtbar");
                p.setAllowFlight(true);
                p.setPlayerListName(p.getPlayerListName() + "§8[§6Ghost§8]");
                for (Player all : Bukkit.getOnlinePlayers()) {


                    if (!all.hasPermission("system.ghost.see")) {
                        all.hidePlayer(p);
                    }
                }
            }

        }
        return false;
    }

}
