package me.shreyasayyengar.gui.commands;

import me.shreyasayyengar.gui.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpsOverrideCommandHandler implements CommandExecutor {

    private final Main main;

    public WarpsOverrideCommandHandler(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;

            main.applyWarpsGUI(player);

        } else {
            System.out.println(ChatColor.RED + "You cannot execute this command in the console!");
        }

        return false;
    }
}