package dev.pepe44.ghostmodev2;

import dev.pepe44.ghostmodev2.commands.GhostCMD;
import dev.pepe44.ghostmodev2.listener.PlayerJoin;
import dev.pepe44.ghostmodev2.listener.PlayerQuit;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GhostV2 extends JavaPlugin {


    public static List<Player> ghosted = new ArrayList<>();

    public static String Prefix = "§7§b[§6§bSystem§7§b]§e> ";
    public static GhostV2 instance;

    public void onEnable() {
        ConsoleCommandSender console = Bukkit.getConsoleSender();

        console.sendMessage("§6GhostModeV2");
        console.sendMessage("§eVersion:3.0");
        console.sendMessage("§2Plugin: Ghostmode wird Geladen..");



        //Events
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);

        //Commands
        getCommand("ghost").setExecutor(new GhostCMD());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        console.sendMessage("§aGhostmode Geladen!");

    }

}
