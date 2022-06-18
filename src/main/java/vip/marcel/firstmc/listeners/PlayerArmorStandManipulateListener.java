package vip.marcel.firstmc.listeners;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import vip.marcel.firstmc.RPGSword;

public record PlayerArmorStandManipulateListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent event) {
        final Player player = event.getPlayer();

        if(WorldGuardEvents.isPlayerInAnyRegion(player.getUniqueId(), "Spawn")) {

            if(!this.plugin.getEditModePlayerList().contains(player)) {
                event.setCancelled(true);
            }

        }

    }

}
