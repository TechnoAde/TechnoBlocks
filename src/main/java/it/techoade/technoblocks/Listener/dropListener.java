package it.techoade.technoblocks.Listener;

import it.techoade.technoblocks.TechnoBlocks;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class dropListener implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {

        ItemStack itemdropped = e.getItemDrop().getItemStack();
        Player p = e.getPlayer();
        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        if(itemdropped.equals(new ItemStack(Material.getMaterial(config.getString("gui.item1.type"))))) {
            if(p.hasPermission("technoblocks.antidrop.bypass")) {
                e.setCancelled(true);
            }
        } else if(itemdropped.equals(new ItemStack(Material.getMaterial(config.getString("gui.item2.type"))))) {
            if(p.hasPermission("technoblocks.antidrop.bypass")) {
                e.setCancelled(true);
            }
        } else if(itemdropped.equals(new ItemStack(Material.getMaterial(config.getString("gui.item3.type"))))) {
            if(p.hasPermission("technoblocks.antidrop.bypass")) {
                e.setCancelled(true);
            }
        }
    }

}
