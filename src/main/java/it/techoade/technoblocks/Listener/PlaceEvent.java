package it.techoade.technoblocks.Listener;

import it.techoade.technoblocks.TechnoBlocks;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class PlaceEvent implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {

        FileConfiguration config = TechnoBlocks.getInstance().getConfig();
        Player p = e.getPlayer();
        ItemStack block1 = new ItemStack(Material.getMaterial(config.getString("block1.blocktype")), config.getInt("gui.item1.quantitygive"));
        ItemStack block2 = new ItemStack(Material.getMaterial(config.getString("block2.blocktype")), config.getInt("gui.item2.quantitygive"));
        ItemStack block3 = new ItemStack(Material.getMaterial(config.getString("block3.blocktype")), config.getInt("gui.item3.quantitygive"));

        if(p.hasPermission("fakeblocks.use") || p.hasPermission("fakeblocks.*")) {
            if(e.getBlockPlaced().getType().equals(Material.getMaterial(config.getString("block1.blocktype")))) {
                if(p.getGameMode() == GameMode.SURVIVAL) {
                    p.getInventory().setItem(config.getInt("gui.item1.slotgive"), block1);
                } else {
                    p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("nocreative").replaceAll("&", "§"));
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(TechnoBlocks.plugin, () -> e.getBlock().setType(Material.AIR), config.getLong("timerforblock"));
            } else if(e.getBlockPlaced().getType().equals(Material.getMaterial(config.getString("block2.blocktype")))) {
                if(p.getGameMode() == GameMode.SURVIVAL) {
                    p.getInventory().setItem(config.getInt("gui.item2.slotgive"), block2);
                } else {
                    p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("nocreative").replaceAll("&", "§"));
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(TechnoBlocks.plugin, () -> e.getBlock().setType(Material.AIR), config.getLong("timerforblock"));
            } else if(e.getBlockPlaced().getType().equals(Material.getMaterial(config.getString("block3.blocktype")))) {
                if(p.getGameMode() == GameMode.SURVIVAL) {
                    p.getInventory().setItem(config.getInt("gui.item3.slotgive"), block3);
                } else {
                    p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("nocreative").replaceAll("&", "§"));
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(TechnoBlocks.plugin, () -> e.getBlock().setType(Material.AIR), config.getLong("timerforblock"));
            }
        }

    }

}
