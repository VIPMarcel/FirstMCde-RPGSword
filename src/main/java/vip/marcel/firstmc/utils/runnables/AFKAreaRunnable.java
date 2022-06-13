package vip.marcel.firstmc.utils.runnables;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public class AFKAreaRunnable extends BukkitRunnable {

    private final RPGSword plugin;

    public AFKAreaRunnable(RPGSword plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        Bukkit.getOnlinePlayers().forEach(players -> {

            if(WorldGuardEvents.isPlayerInAnyRegion(players.getUniqueId(), "AFKArea") |
                    WorldGuardEvents.isPlayerInAnyRegion(players.getUniqueId(), "Spawn")) {
                players.setPlayerTime(6000, true);
            }

            if(WorldGuardEvents.isPlayerInAnyRegion(players.getUniqueId(), "AFKArea")) {

                final RPGPlayer rpgPlayers = this.plugin.getRPGPlayerMap().get(players);

                rpgPlayers.grandRPGCoins(25);

            }
        });

    }

}
