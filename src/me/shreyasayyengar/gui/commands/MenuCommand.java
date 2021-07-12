package me.shreyasayyengar.gui.commands;

import com.earth2me.essentials.Essentials;
import com.gmail.nossr50.api.ExperienceAPI;
import com.gmail.nossr50.datatypes.skills.PrimarySkillType;
import com.gmail.nossr50.mcMMO;
import me.shreyasayyengar.gui.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class MenuCommand implements CommandExecutor {

    Essentials EssentialsPlugin = (Essentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");
    mcMMO mcmmo = (mcMMO) Bukkit.getServer().getPluginManager().getPlugin("mcMMO");

    private final Main main;

    public MenuCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            main.applyMainGui(player);
        } else {
            System.out.println("[GalloGUI] You cannot execute this command in the console!");
        }

        return false;
    }
}
