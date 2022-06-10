package it.techoade.technoblocks.GUIs;

import it.techoade.technoblocks.TechnoBlocks;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static it.techoade.technoblocks.TechnoBlocks.guititle;

public class SelectBlock implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        Location loc = p.getLocation();
        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        if (e.getView().getTitle().equals(guititle)) {

            if (e.getCurrentItem().getType().equals(Material.getMaterial(config.getString("gui.item1.type")))) {
                p.closeInventory();
                p.getInventory().setItem(config.getInt("gui.item1.slotgive"), new ItemStack(Material.getMaterial(config.getString("gui.item1.type")), config.getInt("gui.item1.quantitygive")));
                p.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 2F, 1F);
            } else if (e.getCurrentItem().getType().equals(Material.getMaterial(config.getString("gui.item2.type")))) {
                if (p.hasPermission("technoblocks.gui.use.item2")) {
                    p.closeInventory();
                    p.getInventory().setItem(config.getInt("gui.item2.slotgive"), new ItemStack(Material.getMaterial(config.getString("gui.item2.type")), config.getInt("gui.item2.quantitygive")));
                    p.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 2F, 1F);
                } else {
                    p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("gui.item2.missingpermission").replaceAll("&", "§"));
                }
            } else if (e.getCurrentItem().getType().equals(Material.getMaterial(config.getString("gui.item3.type")))) {
                if (p.hasPermission("technoblocks.gui.use.item3")) {
                    p.closeInventory();
                    p.getInventory().setItem(config.getInt("gui.item3.slotgive"), new ItemStack(Material.getMaterial(config.getString("gui.item3.type")), config.getInt("gui.item3.quantitygive")));
                    p.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 2F, 1F);
                } else {
                    p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("gui.item3.missingpermission").replaceAll("&", "§"));
                }
            }

            e.setCancelled(true);

        }
    }
}