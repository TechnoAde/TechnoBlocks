package it.techoade.technoblocks.listener;

import it.techoade.technoblocks.TechnoBlocks;
import it.techoade.technoblocks.utils.StackItem;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static it.techoade.technoblocks.TechnoBlocks.guititle;

public class Listeners implements Listener {

    //Join Listener

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        FileConfiguration config = TechnoBlocks.getInstance().getConfig();
        Inventory inv = p.getInventory();

        inv.setItem(config.getInt("slotgive"), new ItemStack(Material.getMaterial(config.getString("gui.item1.type")), config.getInt("gui.item1.quantitygive")));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoinGiveItem(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        if(config.getBoolean("selector.enable")) {
            p.getInventory().setItem(config.getInt("selector.slotonjoin"), StackItem.getSelector());
        }


    }

    //Drop Listener

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

    //Place Listener

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {

        FileConfiguration config = TechnoBlocks.getInstance().getConfig();
        Player p = e.getPlayer();
        ItemStack block1 = new ItemStack(Material.getMaterial(config.getString("gui.item1.type")), config.getInt("gui.item1.quantitygive"));
        ItemStack block2 = new ItemStack(Material.getMaterial(config.getString("gui.item2.type")), config.getInt("gui.item2.quantitygive"));
        ItemStack block3 = new ItemStack(Material.getMaterial(config.getString("gui.item3.type")), config.getInt("gui.item3.quantitygive"));

        if(p.hasPermission("technoblocks.use") || p.hasPermission("technoblocks.*")) {

            if(e.getBlockPlaced().getType().equals(Material.getMaterial(config.getString("gui.item1.type")))) {
                if(p.getGameMode() == GameMode.SURVIVAL) {
                    p.getInventory().setItem(config.getInt("slotgive"), block1);
                } else {
                    p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("nocreative").replaceAll("&", "§"));
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(TechnoBlocks.plugin, () -> e.getBlock().setType(Material.AIR), config.getLong("timerforblock"));
            }

            if(e.getBlockPlaced().getType().equals(Material.getMaterial(config.getString("gui.item2.type")))) {
                if(p.getGameMode() == GameMode.SURVIVAL) {
                    p.getInventory().setItem(config.getInt("slotgive"), block2);
                } else {
                    p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("nocreative").replaceAll("&", "§"));
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(TechnoBlocks.plugin, () -> e.getBlock().setType(Material.AIR), config.getLong("timerforblock"));
            }

            if(e.getBlockPlaced().getType().equals(Material.getMaterial(config.getString("gui.item3.type")))) {
                if(p.getGameMode() == GameMode.SURVIVAL) {
                    p.getInventory().setItem(config.getInt("slotgive"), block3);
                } else {
                    p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("nocreative").replaceAll("&", "§"));
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(TechnoBlocks.plugin, () -> e.getBlock().setType(Material.AIR), config.getLong("timerforblock"));
            }
        }

    }

    //Respawn Listener

    @EventHandler
    public static void onRespawn(PlayerRespawnEvent e) {

        Player p = e.getPlayer();
        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        p.getInventory().setItem(config.getInt("slotgive"), new ItemStack(Material.getMaterial(config.getString("gui.item1.type")), config.getInt("gui.item1.quantitygive")));

        if(config.getBoolean("selector.enable")) {
            p.getInventory().setItem(config.getInt("selector.slotonjoin"), StackItem.getSelector());
        }
    }

    //ClickEventInv Listener

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        Location loc = p.getLocation();
        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        if (e.getView().getTitle().equals(guititle)) {

            if (e.getCurrentItem().getType().equals(Material.getMaterial(config.getString("gui.item1.type")))) {
                p.closeInventory();
                p.getInventory().setItem(config.getInt("slotgive"), new ItemStack(Material.getMaterial(config.getString("gui.item1.type")), config.getInt("gui.item1.quantitygive")));
                p.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 2F, 1F);
            } else if (e.getCurrentItem().getType().equals(Material.getMaterial(config.getString("gui.item2.type")))) {
                if (p.hasPermission("technoblocks.gui.use.item2")) {
                    p.closeInventory();
                    p.getInventory().setItem(config.getInt("slotgive"), new ItemStack(Material.getMaterial(config.getString("gui.item2.type")), config.getInt("gui.item2.quantitygive")));
                    p.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 2F, 1F);
                } else {
                    p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("gui.item2.missingpermission").replaceAll("&", "§"));
                }
            } else if (e.getCurrentItem().getType().equals(Material.getMaterial(config.getString("gui.item3.type")))) {
                if (p.hasPermission("technoblocks.gui.use.item3")) {
                    p.closeInventory();
                    p.getInventory().setItem(config.getInt("slotgive"), new ItemStack(Material.getMaterial(config.getString("gui.item3.type")), config.getInt("gui.item3.quantitygive")));
                    p.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 2F, 1F);
                } else {
                    p.sendMessage(TechnoBlocks.getInstance().getConfig().getString("gui.item3.missingpermission").replaceAll("&", "§"));
                }
            }

            e.setCancelled(true);

        }

        if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(config.getString("selector.name").replaceAll("&", "§"))) {
                if(p.hasPermission("technoblocks.antimoveinv.bypass")) {
                    e.setCancelled(true);
                }
            }
        }


    }

    //Interact Listener

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {

        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player p = e.getPlayer();
            ItemStack iteminhand = p.getItemInHand();
            if(iteminhand.hasItemMeta() && iteminhand.getItemMeta().hasDisplayName()) {
                if(iteminhand.getItemMeta().getDisplayName().equals(config.getString("selector.name").replaceAll("&", "§"))) {
                    p.performCommand("blockselector");
                    e.setCancelled(true);
                }
            }
        }
    }

}
