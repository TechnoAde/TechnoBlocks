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
                p.sendMessage("&7Running &bFakeBlocks &7by &bFakeSwape#1804".replaceAll("&", "§"));
                p.sendMessage("&b/fakeblocks list &7for list of command".replaceAll("&", "§"));
            } else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("list")) {
                    if(p.hasPermission("fakeblocks.listcommand") || p.hasPermission("fakeblocks.*")) {
                        p.sendMessage("&7List of commands".replaceAll("&", "§"));
                        p.sendMessage("&b/fakeblocks reload".replaceAll("&", "§"));
                        p.sendMessage("&b/blockselector".replaceAll("&", "§"));
                    } else {
                        p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("nopermsmsg").replaceAll("&", "§"));
                    }
                } else if(args[0].equalsIgnoreCase("reload")) {
                    if(p.hasPermission("fakeblocks.reload") || p.hasPermission("fakeblocks.*")) {
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
