package vip.marcel.firstmc.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record InventoryClickListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {

        if(event.getWhoClicked() instanceof Player player) {
            final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

            if(event.getCurrentItem() == null) {
                return;
            }
            if(event.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName() == null) {
                return;
            }

            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(this.plugin.getSwordItems().get(rpgPlayer.getLevel()).getItemMeta().getDisplayName())) {

                //TODO: Fix, item kann in andere kisten gelegt werden

            }
        }

    }

}
