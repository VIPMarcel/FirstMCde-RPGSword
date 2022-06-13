package vip.marcel.firstmc.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record PlayerDropItemListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
        final Player player = event.getPlayer();
        final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

        if(event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(this.plugin.getSwordItems().get(rpgPlayer.getLevel()).getItemMeta().getDisplayName())) {
            event.setCancelled(true);
            player.sendMessage("§7§l(§c§l!§7§l)§r §7You can't drop your §aRPG§7.");
            player.updateInventory();
        }

    }

}
