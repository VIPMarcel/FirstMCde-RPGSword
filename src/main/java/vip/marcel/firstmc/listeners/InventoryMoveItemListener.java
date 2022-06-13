package vip.marcel.firstmc.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import vip.marcel.firstmc.RPGSword;

public record InventoryMoveItemListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onInventoryMoveItemEvent(InventoryMoveItemEvent event) {

        if(event.getItem() == null) {
            return;
        }
        if(event.getItem().getItemMeta() == null) {
            return;
        }
        if(event.getItem().getItemMeta().getDisplayName() == null) {
            return;
        }

        if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7(§4§l!§7) RPG (§4§l!§7)")) {

            if(event.getSource().getContents() != event.getDestination().getContents()) {
                event.setCancelled(true);
            }

        }

    }

}
