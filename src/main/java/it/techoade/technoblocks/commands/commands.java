package it.techoade.technoblocks.commands;

import it.techoade.technoblocks.TechnoBlocks;
import it.techoade.technoblocks.utils.StackItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static it.techoade.technoblocks.TechnoBlocks.guititle;
import static it.techoade.technoblocks.TechnoBlocks.plugin;

public class commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        if(sender instanceof Player) {
            Player p = (Player) sender;
            switch(command.getName()) {
                case "technoblocks":
                    switch(args.length) {
                        case 0:
                            if(p.hasPermission("technoblocks.help")) {
                                p.sendMessage("&b&lTechnoBlocks &aHelp!".replaceAll("&", "§"));
                                p.sendMessage("&7".replaceAll("&", "§"));
                                p.sendMessage("&bType &a/technoblocks reload &bto reload config".replaceAll("&", "§"));
                            }
                            break;
                        case 1:
                            if(args[0].equalsIgnoreCase("reload")) {
                                if(p.hasPermission("technoblocks.reload")) {
                                    plugin.reloadConfig();
                                    plugin.getConfig().options().copyDefaults(true);
                                    plugin.getConfig().options().copyHeader(true);
                                    plugin.saveConfig();
                                    p.sendMessage(config.getString("configurationreloaded").replaceAll("&", "§"));
                                }
                            }

                    }
                    break;
                case "blockselector":
                    if(sender.hasPermission("technoblocks.gui.use") || sender.hasPermission("technoblocks.*")) {

                        Inventory gui = Bukkit.createInventory(p, config.getInt("gui.guisize"), guititle);

                        gui.setItem(config.getInt("gui.firstitempos"), StackItem.getFirstItem());
                        gui.setItem(config.getInt("gui.seconditempos"), StackItem.getSecondItem());
                        gui.setItem(config.getInt("gui.thirditempos"), StackItem.getThirdItem());

                        p.openInventory(gui);

                    } else {
                        sender.sendMessage(TechnoBlocks.getInstance().getConfig().getString("gui.noperms").replaceAll("&", "§"));
                    }
            }
        }
        return true;
    }
}

