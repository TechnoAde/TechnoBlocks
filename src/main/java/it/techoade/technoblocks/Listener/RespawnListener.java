package it.techoade.technoblocks.Listener;

import it.techoade.technoblocks.TechnoBlocks;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class RespawnListener implements Listener {

    @EventHandler
    public static void onRespawn(PlayerRespawnEvent e) {

        Player p = e.getPlayer();
        FileConfiguration config = TechnoBlocks.getInstance().getConfig();

        p.getInventory().setItem(config.getInt("block1.slotonjoin"), new ItemStack(Material.getMaterial(config.getString("block1.blocktype")), config.getInt("gui.item1.quantitygive")));
    }

}
