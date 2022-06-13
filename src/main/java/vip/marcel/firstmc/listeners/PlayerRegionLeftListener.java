package vip.marcel.firstmc.listeners;

import net.raidstone.wgevents.events.RegionLeftEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record PlayerRegionLeftListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onRegionLeftEvent(RegionLeftEvent event) {
        final Player player = event.getPlayer();
        final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

        if(event.getRegionName().equalsIgnoreCase("Spawn")) {
            rpgPlayer.removeRPGSword();

            player.setPlayerTime(player.getWorld().getTime(), false);

            player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        }

    }

}
