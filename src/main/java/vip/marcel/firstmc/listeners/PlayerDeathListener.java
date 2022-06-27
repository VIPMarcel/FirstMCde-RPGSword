package vip.marcel.firstmc.listeners;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.events.AchievmentGrandEvent;
import vip.marcel.firstmc.utils.enums.Achievment;

public record PlayerDeathListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        final Player player = event.getPlayer();

        if(WorldGuardEvents.isPlayerInAnyRegion(player.getUniqueId(), "Spawn")) {
            Bukkit.getPluginManager().callEvent(new AchievmentGrandEvent(player, Achievment.FIRST_DEATH));
        }

    }

}
