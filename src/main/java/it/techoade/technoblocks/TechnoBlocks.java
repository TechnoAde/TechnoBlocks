package it.techoade.technoblocks;

import it.techoade.technoblocks.commands.commands;
import it.techoade.technoblocks.listener.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class TechnoBlocks extends JavaPlugin {

    public static Logger logger = Logger.getLogger("Minecraft");
    public static TechnoBlocks plugin;
    String version;

    public static String guititle;

    @Override
    public void onEnable() {

        switch (Bukkit.getVersion()) {
            case "1.7":
                version = "1.7";
                break;
            case "1.8":
                version = "1.8";
                break;
            case "1.9":
                version = "1.9";
                break;
            case "1.10":
                version = "1.10";
                break;
            case "1.11":
                version = "1.11";
                break;
            case "1.12":
                version = "1.12";
                break;
            case "1.13":
                version = "1.13";
                break;
            case "1.14":
                version = "1.14";
                break;
            case "1.15":
                version = "1.15";
                break;
            case "1.16":
                version = "1.16";
                break;
            case "1.17":
                version = "1.17";
                break;
            case "1.18":
                version = "1.18";
                break;
            case "1.19":
                version = "1.19";
                break;
        }

        plugin = this;

        //Commands

        getCommand("technoblocks").setExecutor(new commands());
        getCommand("blockselector").setExecutor(new commands());

        //Listeners

        this.getServer().getPluginManager().registerEvents(new Listeners(), this);

        //Logger Section

        logger.info(ChatColor.GRAY + "<----------------------------------------------->");
        logger.info(ChatColor.GRAY + "");
        logger.info(ChatColor.BLUE + "STARTUP PROCESS");
        logger.info(ChatColor.GRAY + "");
        logger.info(ChatColor.BLUE + "TechnoBlocks, Hub blocks plugin made by" + ChatColor.BLUE + "TechnoAde#1350");
        logger.info(ChatColor.GRAY + "");
        logger.info(ChatColor.GRAY + "The plugin has been loaded");
        logger.info(ChatColor.GRAY + "Have fun! For support join my support server");
        logger.info(ChatColor.BLUE + "https://discord.gg/QbRDTvWEuf");
        logger.info(ChatColor.GRAY + "");
        logger.info(ChatColor.BLUE + "Running Version: " + version);
        logger.info(ChatColor.GRAY + "");
        logger.info(ChatColor.GRAY + "<----------------------------------------------->");

        //Config save

        getConfig().options().copyDefaults(true);
        getConfig().options().copyHeader(true);
        saveDefaultConfig();

        guititle = TechnoBlocks.getInstance().getConfig().getString("gui.guititle").replaceAll("&", "§");
    }

    @Override
    public void onDisable() {

        logger.info(ChatColor.GRAY + "<----------------------------------------------->");
        logger.info(ChatColor.GRAY + "");
        logger.info(ChatColor.BLUE + "SHUTDOWN PROCESS");
        logger.info(ChatColor.GRAY + "");
        logger.info(ChatColor.BLUE + "TechnoBlocks, Hub blocks plugin made by" + ChatColor.BLUE + "TechnoAde#1350");
        logger.info(ChatColor.GRAY + "");
        logger.info(ChatColor.GRAY + "The plugin has been unloaded");
        logger.info(ChatColor.GRAY + "Good bye! For support join my support server");
        logger.info(ChatColor.BLUE + "https://discord.gg/QbRDTvWEuf");
        logger.info(ChatColor.GRAY + "");
        logger.info(ChatColor.GRAY + "<----------------------------------------------->");

        saveDefaultConfig();

    }

    public static TechnoBlocks getInstance() {
        return plugin;
    }

}
