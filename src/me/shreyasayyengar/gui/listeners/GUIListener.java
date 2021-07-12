package me.shreyasayyengar.gui.listeners;

import com.earth2me.essentials.Essentials;
import me.shreyasayyengar.gui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.math.BigDecimal;

public class GUIListener implements Listener {
    private final Main main;
    final Essentials EssentialsPlugin = (Essentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");

    public GUIListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) throws Exception {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().contains("Menu Guide GUI")) {

            if (e.getCurrentItem() != null) {
                e.setCancelled(true);

                switch (e.getCurrentItem().getType()) {
                    case DIAMOND_SWORD:
                        main.applySkillsGUI(player);
                        break;

                    case OAK_DOOR:
                        main.applyHomesGUI(player);
                        break;

                    case EMERALD:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " reward");
                        player.closeInventory();
                        break;

                    case CAULDRON:
                        main.applyDisposalGUI(player);
                        break;

                    case BEACON:
                        main.applyWarpsGUI(player);
                        break;

                    case ENDER_CHEST:
                        main.applyEnderChest(player);
                        break;

                    case CRAFTING_TABLE:
                        main.applyCraftingTable(player);
                        break;

                    case FLETCHING_TABLE:
                        main.applyWorkBenches(player);
                        break;

                    case GRASS_BLOCK:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " server creative");
                        player.closeInventory();
                        break;

                    case COMPASS:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " server hub");
                        player.closeInventory();
                        break;

                    case BARRIER:
                        player.closeInventory();
                        break;

                    case LIGHT:
                        main.applyHelpGUI(player);
                        break;

                    default:
                        return;
                }

            }
        }

        if (e.getView().getTitle().contains("Warps")) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);

                switch (e.getCurrentItem().getType()) {

                    case BARRIER:
                        player.closeInventory();
                        break;

                    case ARROW:
                        main.applyMainGui(player);
                        break;

                    case FILLED_MAP:
                        if (EssentialsPlugin.getUser(player).canAfford(BigDecimal.valueOf(100))) {
                            EssentialsPlugin.getUser(player).takeMoney(BigDecimal.valueOf(100));
                            player.teleport(EssentialsPlugin.getWarps().getWarp(e.getCurrentItem().getItemMeta().getDisplayName().substring(2)));
                        } else {
                            player.sendMessage(ChatColor.DARK_RED + "You do not have enough money in your account to do this!");
                            player.closeInventory();
                        }
                        break;
                    default:
                        return;
                }
            }
        }

        if (e.getView().getTitle().contains("Homes")) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);

                switch (e.getCurrentItem().getType()) {

                    case BARRIER:
                        player.closeInventory();
                        break;

                    case ARROW:
                        main.applyMainGui(player);
                        break;

                    case OAK_DOOR:
                        if (EssentialsPlugin.getUser(player).canAfford(BigDecimal.valueOf(100))) {
                            EssentialsPlugin.getUser(player).takeMoney(BigDecimal.valueOf(100));
//                            EssentialsPlugin.getUser(player).setHome();
                            player.teleport(EssentialsPlugin.getUser(player).getHome(e.getCurrentItem().getItemMeta().getDisplayName().substring(2)));
                        } else {
                            player.sendMessage(ChatColor.DARK_RED + "You do not have enough money in your account to do this!");
                            player.closeInventory();
                        }
                        break;
                    case STRUCTURE_VOID:
                        EssentialsPlugin.getUser(player).setHome("My Home", player.getLocation());
                        player.closeInventory();
                        player.sendMessage(ChatColor.GOLD + "Home set to current location.");
                    default:
                        return;
                }
            }
        }

        if (e.getView().getTitle().contains("Help Menu")) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);

                switch (e.getCurrentItem().getType()) {

                    case BARRIER:
                        player.closeInventory();
                        break;

                    case ARROW:
                        main.applyMainGui(player);
                        break;

                    case KNOWLEDGE_BOOK:

                        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Grief Prevention Guide")) {
                            player.sendMessage(ChatColor.GREEN + "Click this link to read the Grief Prevention Guide! ----> " + ChatColor.BOLD + "https://www.youtube.com/watch?v=isf78aCZsqI");
                        }

                        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("mcMMO Guide")) {
                            player.sendMessage(ChatColor.GREEN + "Click this link to read the mcMMO Guide! ----> " + ChatColor.BOLD + "https://mcmmo.fandom.com/wiki/McMMO_Wiki");
                        }

                        player.closeInventory(); // may produce bug, check if item is in switch

                        break;

                    default:
                        return;
                }
            }
        }

        if (e.getView().getTitle().contains("Other Workbenches")) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);

                switch (e.getCurrentItem().getType()) {

                    case BARRIER:
                        player.closeInventory();
                        break;

                    case ARROW:
                        main.applyMainGui(player);
                        break;

                    case ANVIL:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " anvil");
                        break;

                    case LOOM:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " loom");
                        break;

                    case CARTOGRAPHY_TABLE:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " cartographytable");
                        break;

                    case SMITHING_TABLE:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " smithingtable");
                        break;

                    case GRINDSTONE:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " grindstone");
                        break;

                    case STONECUTTER:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " stonecutter");
                        break;

                    default:
                        return;

                }
            }
        }

        if (e.getView().getTitle().contains("Your Skills")) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);

                switch (e.getCurrentItem().getType()) {

                    case BARRIER:
                        player.closeInventory();
                        break;

                    case ARROW:
                        main.applyMainGui(player);
                        break;
                    default:
                }
            }
        }
    }
}