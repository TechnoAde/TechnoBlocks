package it.techoade.technoblocks.Commands;

import it.techoade.technoblocks.TechnoBlocks;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player) sender;

            if(args.length == 0) {
                p.sendMessage("&7Running &bTechnoBlocks &7by &bTechnoAde#1350".replaceAll("&", "§"));
                p.sendMessage("&b/technoblocks list &7for list of command".replaceAll("&", "§"));
            } else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("list")) {
                    if(p.hasPermission("technoblocks.listcommand") || p.hasPermission("technoblocks.*")) {
                        p.sendMessage("&7List of commands".replaceAll("&", "§"));
                        p.sendMessage("&b/fakeblocks reload".replaceAll("&", "§"));
                        p.sendMessage("&b/blockselector".replaceAll("&", "§"));
                    } else {
                        p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("nopermsmsg").replaceAll("&", "§"));
                    }
                } else if(args[0].equalsIgnoreCase("reload")) {
                    if(p.hasPermission("technoblocks.reload") || p.hasPermission("technoblocks.*")) {
                        TechnoBlocks.getInstance().reloadConfig();
                        TechnoBlocks.getInstance().saveConfig();
                        p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("configurationreloaded").replaceAll("&", "§"));
                    } else {
                        p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("nopermsmsg").replaceAll("&", "§"));
                    }
                }
            } else {
                p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("noargsselected").replaceAll("&", "§"));
            }
        }

        return true;
    }
}
