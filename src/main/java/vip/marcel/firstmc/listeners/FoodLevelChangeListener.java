package vip.marcel.firstmc.listeners;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import vip.marcel.firstmc.RPGSword;

public record FoodLevelChangeListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {

        if(event.getEntity() instanceof Player player) {

            if(WorldGuardEvents.isPlayerInAnyRegion(player.getUniqueId(), "Spawn")) {
                event.setFoodLevel(20);
            }

        }

    }

}
