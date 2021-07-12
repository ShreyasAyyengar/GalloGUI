package me.shreyasayyengar.gui.listeners;

import me.shreyasayyengar.gui.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    public PlayerJoin(Main main) {
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        player.sendTitle(ChatColor.GOLD + "Welcome to gallo.apexmc.co!", ChatColor.RED + "To get help / started do /menu", 20, 100, 20);

    }
}