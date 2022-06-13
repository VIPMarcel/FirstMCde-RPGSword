package vip.marcel.firstmc.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import vip.marcel.firstmc.RPGSword;

public record EntityDamageListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        final Entity entity = event.getEntity();

        if(entity.getLocation().getWorld().getName().equalsIgnoreCase("Spawn")) {

            if(event.getCause() == EntityDamageEvent.DamageCause.FIRE) {
                event.setCancelled(true);
            }
            if(event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                event.setCancelled(true);
            }
            if(event.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
                event.setCancelled(true);
            }

        }

    }

}
