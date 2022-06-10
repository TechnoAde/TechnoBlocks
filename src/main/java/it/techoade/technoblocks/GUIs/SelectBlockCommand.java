package it.techoade.technoblocks.GUIs;

import it.techoade.technoblocks.TechnoBlocks;
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

public class SelectBlockCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            FileConfiguration config = TechnoBlocks.getInstance().getConfig();
            if(sender.hasPermission("technoblocks.gui.use") || sender.hasPermission("technoblocks.*")) {
                Player p = (Player) sender;

                Inventory gui = Bukkit.createInventory(p, 27, guititle);

                ItemStack item1 = new ItemStack(Material.getMaterial(config.getString("gui.item1.type")));
                ItemStack item2 = new ItemStack(Material.getMaterial(config.getString("gui.item2.type")));
                ItemStack item3 = new ItemStack(Material.getMaterial(config.getString("gui.item3.type")));

                //Item 1 section

                ItemMeta item1_meta = item1.getItemMeta();
                item1_meta.setDisplayName(config.getString("gui.item1.name").replaceAll("&", "§"));
                ArrayList<String> item1_lore = new ArrayList<>();
                item1_lore.add(config.getString("gui.item1.lore").replaceAll("&", "§"));
                item1_meta.setLore(item1_lore);
                item1.setItemMeta(item1_meta);


                //Item 2 section

                ItemMeta item2_meta = item2.getItemMeta();
                item2_meta.setDisplayName(config.getString("gui.item2.name").replaceAll("&", "§"));
                ArrayList<String> item2_lore = new ArrayList<>();
                item2_lore.add(config.getString("gui.item2.lore").replaceAll("&", "§"));
                item2_meta.setLore(item2_lore);
                item2.setItemMeta(item2_meta);

                //Item 3 section

                ItemMeta item3_meta = item3.getItemMeta();
                item3_meta.setDisplayName(config.getString("gui.item3.name").replaceAll("&", "§"));
                ArrayList<String> item3_lore = new ArrayList<>();
                item3_lore.add(config.getString("gui.item3.lore").replaceAll("&", "§"));
                item3_meta.setLore(item3_lore);
                item3.setItemMeta(item3_meta);

                gui.setItem(11, item1);
                gui.setItem(13, item2);
                gui.setItem(15, item3);

                p.openInventory(gui);

            } else {
                sender.sendMessage(TechnoBlocks.getInstance().getConfig().getString("gui.noperms").replaceAll("&", "§"));
            }
        }

        return true;
    }
}
