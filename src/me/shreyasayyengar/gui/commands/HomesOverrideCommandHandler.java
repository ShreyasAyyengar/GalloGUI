package me.shreyasayyengar.gui.commands;

import me.shreyasayyengar.gui.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.eclipse.sisu.Nullable;
import org.bukkit.entity.Player;

public class HomesOverrideCommandHandler implements CommandExecutor {

    private final Main main;

    public HomesOverrideCommandHandler(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            main.applyHomesGUI(player);
        }

        return false;
    }
}
