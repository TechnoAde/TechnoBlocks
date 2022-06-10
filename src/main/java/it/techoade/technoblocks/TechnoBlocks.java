package it.techoade.technoblocks;

import it.techoade.technoblocks.Commands.MainCommand;
import it.techoade.technoblocks.GUIs.SelectBlock;
import it.techoade.technoblocks.GUIs.SelectBlockCommand;
import it.techoade.technoblocks.Listener.AddBlockOnJoin;
import it.techoade.technoblocks.Listener.PlaceEvent;
import it.techoade.technoblocks.Listener.RespawnListener;
import it.techoade.technoblocks.Listener.dropListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class TechnoBlocks extends JavaPlugin {

    public static Logger logger = Logger.getLogger("Minecraft");
    public static TechnoBlocks plugin;

    public static String guititle;

    @Override
    public void onEnable() {

        plugin = this;

        //Commands

        getCommand("technoblocks").setExecutor(new MainCommand());
        getCommand("blockselector").setExecutor(new SelectBlockCommand());

        //Listeners

        getServer().getPluginManager().registerEvents(new AddBlockOnJoin(), this);
        getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
        getServer().getPluginManager().registerEvents(new SelectBlock(), this);
        getServer().getPluginManager().registerEvents(new RespawnListener(), this);
        getServer().getPluginManager().registerEvents(new dropListener(), this);

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
        logger.info(ChatColor.GRAY + "<----------------------------------------------->");

        //Config save

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
