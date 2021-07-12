package me.shreyasayyengar.gui;

import com.earth2me.essentials.Essentials;
import com.gmail.nossr50.api.ExperienceAPI;
import com.gmail.nossr50.datatypes.skills.PrimarySkillType;
import me.shreyasayyengar.gui.commands.HomesOverrideCommandHandler;
import me.shreyasayyengar.gui.commands.MenuCommand;
import me.shreyasayyengar.gui.commands.WarpsOverrideCommandHandler;
import me.shreyasayyengar.gui.listeners.GUIListener;
import me.shreyasayyengar.gui.listeners.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getLogger().info(ChatColor.GOLD + "This plugin was made and developed by " + ChatColor.BOLD + ChatColor.AQUA + "Shreyas#0001 " + ChatColor.GOLD + "for a private server. Any redistribution should be done only AFTER consent is given from the developer.");
        getLogger().info(ChatColor.GOLD + "If any problems occur or changes that need to be made, please contact the developer.");
        getLogger().warning(ChatColor.RED + "Now Starting [GalloGUI]...");

        getCommand("menu").setExecutor(new MenuCommand(this));
        getCommand("warps").setExecutor(new WarpsOverrideCommandHandler(this));
        getCommand("homes").setExecutor(new HomesOverrideCommandHandler(this));
        Bukkit.getServer().getPluginManager().registerEvents(new GUIListener(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().warning(ChatColor.RED + "Shutting Down...");
        getLogger().info(ChatColor.GOLD + "Locking Threads and Closing Instances...");
        getLogger().info(ChatColor.YELLOW + "Shut Down");

    }

    public void applyMainGui(Player player) {

        Inventory mainGUI = Bukkit.createInventory(null, 54, ChatColor.BLACK + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "~ " + ChatColor.RESET + "" + ChatColor.BLACK + "" + ChatColor.BOLD + "Menu Guide GUI" + ChatColor.MAGIC + " ~");

        // Item 1 Close
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.YELLOW + "Close Menu");
        close.setItemMeta(closeMeta);

        // Item 2 Help
        ItemStack help = new ItemStack(Material.LIGHT);
        ItemMeta helpMeta = help.getItemMeta();
        helpMeta.setDisplayName(ChatColor.YELLOW + "View Guides");
        ArrayList<String> helpLore = new ArrayList<>();
        helpLore.add(ChatColor.GRAY + "Click to view guides!");
        helpMeta.setLore(helpLore);
        help.setItemMeta(helpMeta);

        // Item 3 To Hub
        ItemStack hub = new ItemStack(Material.COMPASS);
        ItemMeta hubMeta = help.getItemMeta();
        hubMeta.setDisplayName(ChatColor.YELLOW + "Go to Hub");
        ArrayList<String> hubLore = new ArrayList<>();
        hubLore.add(ChatColor.GRAY + "Click to move to the Hub Server");
        hubMeta.setLore(hubLore);
        hub.setItemMeta(hubMeta);

        // Item 4 To Creative
        ItemStack creative = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta creativeMeta = creative.getItemMeta();
        creativeMeta.setDisplayName(ChatColor.YELLOW + "Go to Creative");
        ArrayList<String> creativeLore = new ArrayList<>();
        creativeLore.add(ChatColor.GRAY + "Click to move to the Creative Server");
        creativeMeta.setLore(creativeLore);
        creative.setItemMeta(creativeMeta);

        // Item 5 Opens a mcMMO GUI about skill progress
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.YELLOW + "My mcMMO Skills");
        ArrayList<String> swordLore = new ArrayList<>();
        swordLore.add(ChatColor.GRAY + "Click to view mcMMO skills and progress");
        swordMeta.setLore(swordLore);
        sword.setItemMeta(swordMeta);

        // Item 6 Homes
        ItemStack door = new ItemStack(Material.OAK_DOOR);
        ItemMeta doorMeta = door.getItemMeta();
        doorMeta.setDisplayName(ChatColor.YELLOW + "Homes");
        ArrayList<String> doorLore = new ArrayList<>();
        doorLore.add(ChatColor.GRAY + "Click here to view a list of your homes");
        doorMeta.setLore(doorLore);
        door.setItemMeta(doorMeta);

        // Item 7 Disposal
        ItemStack book = new ItemStack(Material.CAULDRON);
        ItemMeta bookMeta = book.getItemMeta();
        bookMeta.setDisplayName(ChatColor.YELLOW + "Disposal");
        ArrayList<String> bookLore = new ArrayList<>();
        bookLore.add(ChatColor.GRAY + "Click here to throw away your spare items");
        bookMeta.setLore(bookLore);
        book.setItemMeta(bookMeta);

        // Item 8 Rewards
        ItemStack reward = new ItemStack(Material.EMERALD);
        ItemMeta rewardMeta = reward.getItemMeta();
        rewardMeta.setDisplayName(ChatColor.YELLOW + "Daily Reward");
        ArrayList<String> rewardLore = new ArrayList<>();
        rewardLore.add(ChatColor.AQUA + "Click Here to get Your Daily Reward!");
        /*
        heck with api with timings
        */
        rewardMeta.setLore(rewardLore);
        reward.setItemMeta(rewardMeta);

        // Item 9 Warps
        ItemStack warps = new ItemStack(Material.BEACON);
        ItemMeta warpsMeta = warps.getItemMeta();
        warpsMeta.setDisplayName(ChatColor.YELLOW + "Warps Menu");
        ArrayList<String> warpsLore = new ArrayList<>();
        warpsLore.add(ChatColor.GRAY + "Click to show all warps");
        warpsMeta.setLore(warpsLore);
        warps.setItemMeta(warpsMeta);

        // Item 10 Time
        ItemStack time = new ItemStack(Material.CLOCK);
        ItemMeta timeMeta = time.getItemMeta();
        timeMeta.setDisplayName(ChatColor.YELLOW + "World Time");
        ArrayList<String> timeLore = new ArrayList<>();
        timeLore.add(ChatColor.AQUA + "" + parseTime(Bukkit.getServer().getWorld("world").getTime()));
        timeMeta.setLore(timeLore);
        time.setItemMeta(timeMeta);

        // Item 11 Enderchest
        ItemStack enderchest = new ItemStack(Material.ENDER_CHEST);
        ItemMeta enderMeta = enderchest.getItemMeta();
        enderMeta.setDisplayName(ChatColor.YELLOW + "Ender Chest");
        ArrayList<String> enderLore = new ArrayList<>();
        enderLore.add(ChatColor.GRAY + "Click here to open your enderchest!");
        enderMeta.setLore(enderLore);
        enderchest.setItemMeta(enderMeta);

        // Item 12 Crafting Menu
        ItemStack crafting = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta craftingMeta = crafting.getItemMeta();
        craftingMeta.setDisplayName(ChatColor.YELLOW + "Crafting Table");
        ArrayList<String> craftingLore = new ArrayList<>();
        craftingLore.add(ChatColor.GRAY + "Click to open a crafting table");
        craftingMeta.setLore(craftingLore);
        crafting.setItemMeta(craftingMeta);

        // Item 13 Other Crafting
        ItemStack workbenches = new ItemStack(Material.FLETCHING_TABLE);
        ItemMeta workbenchMeta = workbenches.getItemMeta();
        workbenchMeta.setDisplayName(ChatColor.YELLOW + "Other Workbenches!");
        ArrayList<String> workLore = new ArrayList<>();
        workLore.add(ChatColor.GRAY + "Click here to open other types of workbenches!");
        workbenchMeta.setLore(workLore);
        workbenches.setItemMeta(workbenchMeta);

        // Item 14 Quick Stats
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.YELLOW + player.getName() + "'s McMMO Stats!");
        ArrayList<String> itemLore = new ArrayList<>();

        try {
            itemLore.add(ChatColor.AQUA + "Your Power Level: " + ChatColor.MAGIC + "~ " + ChatColor.GOLD + ExperienceAPI.getPowerLevel(player) + ChatColor.AQUA + "" + ChatColor.MAGIC + " ~");
            itemLore.add(ChatColor.AQUA + "Your Power Rank: " + ChatColor.MAGIC + "~ " + ChatColor.GOLD + ExperienceAPI.getPlayerRankOverall(player.getName()) + ChatColor.AQUA + "" + ChatColor.MAGIC + " ~");
        } catch (NullPointerException e) {
            itemLore.add(ChatColor.RED + "You don't have a Overall Level Yet!");
            itemLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        meta.setLore(itemLore);
        meta.setOwner(player.getName());
        item.setItemMeta(meta);

        mainGUI.setItem(19, sword);
        mainGUI.setItem(20, door);
        mainGUI.setItem(21, book);
        mainGUI.setItem(22, reward);
        mainGUI.setItem(23, warps);
        mainGUI.setItem(24, time);
        mainGUI.setItem(25, enderchest);
        mainGUI.setItem(31, crafting);
        mainGUI.setItem(32, workbenches);
        mainGUI.setItem(45, hub);
        mainGUI.setItem(36, creative);
        mainGUI.setItem(53, help);
        mainGUI.setItem(49, close);
        mainGUI.setItem(13, item);

        player.openInventory(mainGUI);
    }

    public void applyHomesGUI(Player player) {

        Inventory homesGUI = Bukkit.createInventory(null, 27, ChatColor.YELLOW + "Homes");

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.YELLOW + "Close Menu");
        close.setItemMeta(closeMeta);

        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW + "Go Back");
        back.setItemMeta(backMeta);

        homesGUI.setItem(18, back);
        homesGUI.setItem(22, close);

        Essentials EssentialsPlugin = (Essentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");

        if (EssentialsPlugin.getUser(player).getHomes().toArray().length == 0) {

            ItemStack nohome = new ItemStack(Material.STRUCTURE_VOID);
            ItemMeta nohomeMeta = nohome.getItemMeta();
            nohomeMeta.setDisplayName(ChatColor.DARK_RED + "No Homes!");
            ArrayList<String> nohomeLore = new ArrayList<>();
            nohomeLore.add(ChatColor.RED + "You don't have any homes setup!");
            nohomeLore.add(ChatColor.GRAY + "To make a home, do /sethome <name>");
            nohomeLore.add(ChatColor.GREEN + "Or you can click here to set a home at your current location");
            nohomeMeta.setLore(nohomeLore);
            nohome.setItemMeta(nohomeMeta);

            homesGUI.setItem(0, nohome);
            player.openInventory(homesGUI);

        }

        for (int i = 0; i < EssentialsPlugin.getUser(player).getHomes().toArray().length; i++) {

            ItemStack homes = new ItemStack(Material.OAK_DOOR);
            ItemMeta homesMeta = homes.getItemMeta();
            homesMeta.setDisplayName(ChatColor.YELLOW + "" + EssentialsPlugin.getUser(player).getHomes().toArray()[i]);

            ArrayList<String> homeLore = new ArrayList<>();

            homeLore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "" + ChatColor.MAGIC + "~ " + ChatColor.GRAY + "Click here to teleport to " + ChatColor.YELLOW + EssentialsPlugin.getUser(player).getHomes().toArray()[i] + ChatColor.MAGIC + " ~");
            homesMeta.setLore(homeLore);
            homes.setItemMeta(homesMeta);

            homesGUI.setItem(i, homes);

            player.openInventory(homesGUI);

        }
    }

    public void applyWarpsGUI(Player player) {
        Inventory warpsGUI = Bukkit.createInventory(null, 27, ChatColor.YELLOW + "Warps");

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.YELLOW + "Close Menu");
        close.setItemMeta(closeMeta);

        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW + "Go Back");
        back.setItemMeta(backMeta);

        warpsGUI.setItem(18, back);
        warpsGUI.setItem(22, close);


        Essentials EssentialsPlugin = (Essentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");


        for (int i = 0; i < EssentialsPlugin.getWarps().getList().size(); i++) {
            ItemStack warp = new ItemStack(Material.FILLED_MAP);
            ItemMeta warpMeta = warp.getItemMeta();
            warpMeta.setDisplayName(ChatColor.LIGHT_PURPLE + String.valueOf(EssentialsPlugin.getWarps().getList().toArray()[i]));
            ArrayList<String> warpLore = new ArrayList<>();

            warpLore.add(ChatColor.RESET + "" + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "~ " + ChatColor.GRAY + "Click here to teleport to " + ChatColor.LIGHT_PURPLE + (EssentialsPlugin.getWarps().getList().toArray()[i]) + ChatColor.MAGIC + " ~");
            warpMeta.setLore(warpLore);
            warp.setItemMeta(warpMeta);


            warpsGUI.setItem(i, warp);

            player.openInventory(warpsGUI);

        }

    }

    public void applySkillsGUI(Player player) {

        Inventory skillsGUI = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "Your Skills");

        ItemStack acro = new ItemStack(Material.IRON_BOOTS);
        ItemMeta acroMeta = acro.getItemMeta();
        acroMeta.setDisplayName(ChatColor.AQUA + "Acrobatics:");
        ArrayList<String> acroLore = new ArrayList<>();
        try {
            acroLore.add(ChatColor.GOLD + "Current Acrobatics Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.ACROBATICS));
            acroLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf((PrimarySkillType.ACROBATICS))));
            acroLore.add(ChatColor.GOLD + "Your Acrobatics Rank #" + ChatColor.AQUA + "" + ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.ACROBATICS)));
        } catch (NullPointerException e) {
            acroLore.add(ChatColor.RED + "You don't have Acrobatics XP/Levels Yet!");
            acroLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        acroMeta.setLore(acroLore);
        acro.setItemMeta(acroMeta);


        ItemStack alch = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta alchMeta = acro.getItemMeta();
        ArrayList<String> alchLore = new ArrayList<>();
        alchMeta.setDisplayName(ChatColor.AQUA + "Alchemy:");
        try {
            alchLore.add(ChatColor.GOLD + "Current Alchemy Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.ALCHEMY));
            alchLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.ALCHEMY)));
            alchLore.add(ChatColor.GOLD + "Your Alchemy Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.ALCHEMY)));
        } catch (NullPointerException e) {
            alchLore.add(ChatColor.RED + "You don't have Alchemy XP/Levels Yet!");
            alchLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        alchMeta.setLore(alchLore);
        alch.setItemMeta(alchMeta);

        ItemStack arch = new ItemStack(Material.BOW);
        ItemMeta archMeta = acro.getItemMeta();
        ArrayList<String> archLore = new ArrayList<>();
        archMeta.setDisplayName(ChatColor.AQUA + "Archery:");
        try {
            archLore.add(ChatColor.GOLD + "Current Archery Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.ARCHERY));
            archLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.ARCHERY)));
            archLore.add(ChatColor.GOLD + "Your Archery Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.ARCHERY)));
        } catch (NullPointerException e) {
            archLore.add(ChatColor.RED + "You don't have Archery XP/Levels Yet!");
            archLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        archMeta.setLore(archLore);
        arch.setItemMeta(archMeta);

        ItemStack axe = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta axeMeta = acro.getItemMeta();
        ArrayList<String> axeLore = new ArrayList<>();
        axeMeta.setDisplayName(ChatColor.AQUA + "Axes:");
        try {
            axeLore.add(ChatColor.GOLD + "Current Axes Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.AXES));
            axeLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.AXES)));
            axeLore.add(ChatColor.GOLD + "Your Axes Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.AXES)));
        } catch (NullPointerException e) {
            axeLore.add(ChatColor.RED + "You don't have Axes XP/Levels Yet!");
            axeLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        axeMeta.setLore(axeLore);
        axe.setItemMeta(axeMeta);

        ItemStack ex = new ItemStack(Material.IRON_SHOVEL);
        ItemMeta exMeta = acro.getItemMeta();
        ArrayList<String> exLore = new ArrayList<>();
        exMeta.setDisplayName(ChatColor.AQUA + "Excavation:");
        try {
            exLore.add(ChatColor.GOLD + "Current Excavation Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.EXCAVATION));
            exLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.EXCAVATION)));
            exLore.add(ChatColor.GOLD + "Your Excavation Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.EXCAVATION)));
        } catch (NullPointerException e) {
            exLore.add(ChatColor.RED + "You don't have Excavation XP/Levels Yet!");
            exLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        exMeta.setLore(exLore);
        ex.setItemMeta(exMeta);

        ItemStack fish = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishMeta = acro.getItemMeta();
        ArrayList<String> fishLore = new ArrayList<>();
        fishMeta.setDisplayName(ChatColor.AQUA + "Fishing:");
        try {
            fishLore.add(ChatColor.GOLD + "Current Fishing Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.FISHING));
            fishLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.FISHING)));
            fishLore.add(ChatColor.GOLD + "Your Fishing Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.FISHING)));
        } catch (NullPointerException e) {
            fishLore.add(ChatColor.RED + "You don't have Fishing XP/Levels Yet!");
            fishLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        fishMeta.setLore(fishLore);
        fish.setItemMeta(fishMeta);

        ItemStack herb = new ItemStack(Material.BAMBOO);
        ItemMeta herbMeta = acro.getItemMeta();
        ArrayList<String> herbLore = new ArrayList<>();
        herbMeta.setDisplayName(ChatColor.AQUA + "Herbalism:");
        try {
            herbLore.add(ChatColor.GOLD + "Current Herbalism Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.HERBALISM));
            herbLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.HERBALISM)));
            herbLore.add(ChatColor.GOLD + "Your Herbalism Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.HERBALISM)));
        } catch (NullPointerException e) {
            herbLore.add(ChatColor.RED + "You don't have Herbalism XP/Levels Yet!");
            herbLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        herbMeta.setLore(herbLore);
        herb.setItemMeta(herbMeta);

        ItemStack pick = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta pickMeta = acro.getItemMeta();
        ArrayList<String> pickLore = new ArrayList<>();
        pickMeta.setDisplayName(ChatColor.AQUA + "Mining:");
        try {
            pickLore.add(ChatColor.GOLD + "Current Mining Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.MINING));
            pickLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.MINING)));
            pickLore.add(ChatColor.GOLD + "Your Mining Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.MINING)));
        } catch (NullPointerException e) {
            pickLore.add(ChatColor.RED + "You don't have Mining XP/Levels Yet!");
            pickLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        pickMeta.setLore(pickLore);
        pick.setItemMeta(pickMeta);


        ItemStack rep = new ItemStack(Material.ANVIL);
        ItemMeta repMeta = acro.getItemMeta();
        ArrayList<String> repLore = new ArrayList<>();
        repMeta.setDisplayName(ChatColor.AQUA + "Repair:");
        try {
            repLore.add(ChatColor.GOLD + "Current Repair Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.REPAIR));
            repLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.REPAIR)));
            repLore.add(ChatColor.GOLD + "Your Repair Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.REPAIR)));
        } catch (NullPointerException e) {
            repLore.add(ChatColor.RED + "You don't have Repair XP/Levels Yet!");
            repLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        repMeta.setLore(repLore);
        rep.setItemMeta(repMeta);

        ItemStack sw = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta swMeta = acro.getItemMeta();
        ArrayList<String> swLore = new ArrayList<>();
        swMeta.setDisplayName(ChatColor.AQUA + "Swords:");
        try {
            swLore.add(ChatColor.GOLD + "Current Swords Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.SWORDS));
            swLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.SWORDS)));
            swLore.add(ChatColor.GOLD + "Your Swords Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.SWORDS)));
        } catch (NullPointerException e) {
            swLore.add(ChatColor.RED + "You don't have Sword XP/Levels Yet!");
            swLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        swMeta.setLore(swLore);
        sw.setItemMeta(swMeta);

        ItemStack tame = new ItemStack(Material.BONE);
        ItemMeta tameMeta = acro.getItemMeta();
        ArrayList<String> tameLore = new ArrayList<>();
        tameMeta.setDisplayName(ChatColor.AQUA + "Taming:");
        try {
            tameLore.add(ChatColor.GOLD + "Current Taming Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.TAMING));
            tameLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.TAMING)));
            tameLore.add(ChatColor.GOLD + "Your Taming Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.TAMING)));
        } catch (NullPointerException e) {
            tameLore.add(ChatColor.RED + "You don't have Taming XP/Levels Yet!");
            tameLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        tameMeta.setLore(tameLore);
        tame.setItemMeta(tameMeta);

        ItemStack arm = new ItemStack(Material.STRUCTURE_VOID);
        ItemMeta armMeta = acro.getItemMeta();
        ArrayList<String> armLore = new ArrayList<>();
        armMeta.setDisplayName(ChatColor.AQUA + "Un-Armed:");
        try {
            armLore.add(ChatColor.GOLD + "Current Un-Armed Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.UNARMED));
            armLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.UNARMED)));
            armLore.add(ChatColor.GOLD + "Your Un-Armed Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.UNARMED)));
        } catch (NullPointerException e) {
            armLore.add(ChatColor.RED + "You don't have Un-Armed XP/Levels Yet!");
            armLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        armMeta.setLore(armLore);
        arm.setItemMeta(armMeta);

        ItemStack wood = new ItemStack(Material.IRON_AXE);
        ItemMeta woodMeta = acro.getItemMeta();
        ArrayList<String> woodLore = new ArrayList<>();
        woodMeta.setDisplayName(ChatColor.AQUA + "Wood Cutting:");
        try {
            woodLore.add(ChatColor.GOLD + "Current Woodcutting Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.WOODCUTTING));
            woodLore.add(ChatColor.GOLD + "XP Needed to Level Up: " + ExperienceAPI.getXPRemaining(player, String.valueOf(PrimarySkillType.WOODCUTTING)));
            woodLore.add(ChatColor.GOLD + "Your Woodcutting Rank #" + ChatColor.AQUA + "" +
                    ExperienceAPI.getPlayerRankSkill(player.getName(), String.valueOf(PrimarySkillType.WOODCUTTING)));
        } catch (NullPointerException e) {
            woodLore.add(ChatColor.RED + "You don't have Woodcutting XP/Levels Yet!");
            woodLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        woodMeta.setLore(woodLore);
        wood.setItemMeta(woodMeta);

        ItemStack sa = new ItemStack(Material.IRON_INGOT);
        ItemMeta saMeta = acro.getItemMeta();
        ArrayList<String> saLore = new ArrayList<>();
        saMeta.setDisplayName(ChatColor.AQUA + "Salvage:");
        try {
            saLore.add(ChatColor.GOLD + "Current Salvage Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.SALVAGE));
        } catch (NullPointerException e) {
            saLore.add(ChatColor.RED + "You don't have Salvage XP/Levels Yet!");
            saLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        saMeta.setLore(saLore);
        sa.setItemMeta(saMeta);

        ItemStack cook = new ItemStack(Material.FURNACE);
        ItemMeta cookMeta = acro.getItemMeta();
        ArrayList<String> cookLore = new ArrayList<>();
        cookMeta.setDisplayName(ChatColor.AQUA + "Smelting:");
        try {
            cookLore.add(ChatColor.GOLD + "Current Smelting Level: " + ExperienceAPI.getLevel(player, PrimarySkillType.SMELTING));
        } catch (NullPointerException e) {
            cookLore.add(ChatColor.RED + "You don't have Smelting XP/Levels Yet!");
            cookLore.add(ChatColor.RED + "Play the game to increase your levels!");
        }
        cookMeta.setLore(cookLore);
        cook.setItemMeta(cookMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.YELLOW + "Close Menu");
        close.setItemMeta(closeMeta);

        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW + "Go Back");
        back.setItemMeta(backMeta);

        skillsGUI.setItem(10, acro);
        skillsGUI.setItem(11, alch);
        skillsGUI.setItem(12, arch);
        skillsGUI.setItem(13, axe);
        skillsGUI.setItem(14, ex);
        skillsGUI.setItem(15, fish);
        skillsGUI.setItem(16, herb);
        skillsGUI.setItem(19, pick);
        skillsGUI.setItem(20, rep);
        skillsGUI.setItem(21, sw);
        skillsGUI.setItem(23, tame);
        skillsGUI.setItem(24, arm);
        skillsGUI.setItem(25, wood);
        skillsGUI.setItem(36, sa);
        skillsGUI.setItem(37, cook);
        skillsGUI.setItem(45, back);
        skillsGUI.setItem(49, close);

        player.openInventory(skillsGUI);
    }

    public void applyCraftingTable(Player player) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " workbench");
    }

    public void applyEnderChest(Player player) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " enderchest");
    }

    public void applyWorkBenches(Player player) {

        Inventory workBenchGUI = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "Other Workbenches");

        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemStack loom = new ItemStack(Material.LOOM);
        ItemStack carto = new ItemStack(Material.CARTOGRAPHY_TABLE);
        ItemStack smithing = new ItemStack(Material.SMITHING_TABLE);
        ItemStack grindstone = new ItemStack(Material.GRINDSTONE);
        ItemStack stonecut = new ItemStack(Material.STONECUTTER);

        ItemMeta anvilMeta = anvil.getItemMeta();
        anvilMeta.setDisplayName(ChatColor.YELLOW + "Anvil");
        anvil.setItemMeta(anvilMeta);

        ItemMeta loomMeta = loom.getItemMeta();
        loomMeta.setDisplayName(ChatColor.YELLOW + "Loom");
        loom.setItemMeta(loomMeta);

        ItemMeta cartMeta = carto.getItemMeta();
        cartMeta.setDisplayName(ChatColor.YELLOW + "Cartography Table");
        carto.setItemMeta(cartMeta);

        ItemMeta smithingMeta = smithing.getItemMeta();
        smithingMeta.setDisplayName(ChatColor.YELLOW + "Smithing Table");
        smithing.setItemMeta(smithingMeta);

        ItemMeta grindstoneMeta = grindstone.getItemMeta();
        grindstoneMeta.setDisplayName(ChatColor.YELLOW + "Grindstone");
        grindstone.setItemMeta(grindstoneMeta);

        ItemMeta stoneMeta = stonecut.getItemMeta();
        stoneMeta.setDisplayName(ChatColor.YELLOW + "Stonecutter");
        stonecut.setItemMeta(stoneMeta);


        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.YELLOW + "Close Menu");
        close.setItemMeta(closeMeta);

        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW + "Go Back");
        back.setItemMeta(backMeta);

        workBenchGUI.setItem(45, back);
        workBenchGUI.setItem(49, close);

        workBenchGUI.setItem(11, anvil);
        workBenchGUI.setItem(13, loom);
        workBenchGUI.setItem(15, carto);
        workBenchGUI.setItem(29, smithing);
        workBenchGUI.setItem(31, grindstone);
        workBenchGUI.setItem(33, stonecut);

        player.openInventory(workBenchGUI);

    }

    public void applyDisposalGUI(Player player) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " disposal");
    }

    public void applyHelpGUI(Player player) {
        Inventory helpGUI = Bukkit.createInventory(null, 27, ChatColor.YELLOW + "Help Menu");

        ItemStack grief = new ItemStack(Material.KNOWLEDGE_BOOK);
        ItemMeta griefMeta = grief.getItemMeta();
        griefMeta.setDisplayName("Grief Prevention Guide");
        grief.setItemMeta(griefMeta);

        ItemStack book1 = new ItemStack(Material.KNOWLEDGE_BOOK);
        ItemMeta bookMeta1 = book1.getItemMeta();
        bookMeta1.setDisplayName("mcMMO Guide");
        book1.setItemMeta(bookMeta1);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.YELLOW + "Close Menu");
        close.setItemMeta(closeMeta);

        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW + "Go Back");
        back.setItemMeta(backMeta);

        helpGUI.setItem(18, back);
        helpGUI.setItem(22, close);
        helpGUI.setItem(0, grief);
        helpGUI.setItem(1, book1);

        player.openInventory(helpGUI);
    }

    public static String parseTime(long time) {
        long hours = time / 1000 + 6;
        long minutes = (time % 1000) * 60 / 1000;
        String ampm = "AM";
        if (hours >= 12) {
            hours -= 12;
            ampm = "PM";
        }
        if (hours >= 12) {
            hours -= 12;
            ampm = "AM";
        }
        if (hours == 0) hours = 12;
        String mm = "0" + minutes;
        mm = mm.substring(mm.length() - 2);
        return hours + ":" + mm + " " + ampm;
    }
}