package it.techoade.technoblocks.utils;

import it.techoade.technoblocks.TechnoBlocks;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class StackItem implements Listener {

    public static ItemStack getSelector() {

        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        ItemStack selector = new ItemStack(Material.getMaterial(config.getString("selector.type")), config.getInt("selector.amount"));

        ItemMeta selector_meta = selector.getItemMeta();
        selector_meta.setDisplayName(config.getString("selector.name").replaceAll("&", "§"));
        List<String> lore = config.getStringList("selector.lore");
        for(int i = 0; i < lore.size(); i++) {
            lore.set(i, lore.get(i).replace("&", "§"));
        }
        selector_meta.setLore(lore);
        selector.setItemMeta(selector_meta);

        return selector;
    }

    public static ItemStack getFirstItem() {

        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        ItemStack firstitem = new ItemStack(Material.getMaterial(config.getString("gui.item1.type")));

        ItemMeta firstitem_meta = firstitem.getItemMeta();
        firstitem_meta.setDisplayName(config.getString("gui.item1.name").replaceAll("&", "§"));
        List<String> lore = config.getStringList("gui.item1.lore");
        for(int i = 0; i < lore.size(); i++) {
            lore.set(i, lore.get(i).replace("&", "§"));
        }
        firstitem_meta.setLore(lore);
        firstitem.setItemMeta(firstitem_meta);

        return firstitem;
    }

    public static ItemStack getSecondItem() {

        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        ItemStack seconditem = new ItemStack(Material.getMaterial(config.getString("gui.item2.type")));

        ItemMeta seconditem_meta = seconditem.getItemMeta();
        seconditem_meta.setDisplayName(config.getString("gui.item2.name").replaceAll("&", "§"));
        List<String> lore = config.getStringList("gui.item2.lore");
        for(int i = 0; i < lore.size(); i++) {
            lore.set(i, lore.get(i).replace("&", "§"));
        }
        seconditem_meta.setLore(lore);
        seconditem.setItemMeta(seconditem_meta);

        return seconditem;
    }

    public static ItemStack getThirdItem() {

        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        ItemStack thirditem = new ItemStack(Material.getMaterial(config.getString("gui.item3.type")));

        ItemMeta thirditem_meta = thirditem.getItemMeta();
        thirditem_meta.setDisplayName(config.getString("gui.item3.name").replaceAll("&", "§"));
        List<String> lore = config.getStringList("gui.item3.lore");
        for(int i = 0; i < lore.size(); i++) {
            lore.set(i, lore.get(i).replace("&", "§"));
        }
        thirditem_meta.setLore(lore);
        thirditem.setItemMeta(thirditem_meta);

        return thirditem;
    }

}
