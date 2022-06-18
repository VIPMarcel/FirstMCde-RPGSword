package vip.marcel.firstmc.listeners;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import vip.marcel.firstmc.RPGSword;

public record BlockBreakListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        final Player player = event.getPlayer();

        if(WorldGuardEvents.isPlayerInAnyRegion(player.getUniqueId(), "Spawn")) {

            if(!this.plugin.getEditModePlayerList().contains(player)) {

                // z.B. Pickaxe Kohleblöcke

                event.setCancelled(true);
            }

        }

    }

}
