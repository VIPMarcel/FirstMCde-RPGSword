package vip.marcel.firstmc.utils.runnables;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import vip.marcel.firstmc.RPGSword;

public class PlayerTimeRunnable extends BukkitRunnable {

    private final RPGSword plugin;

    public PlayerTimeRunnable(RPGSword plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(players -> {

            if(WorldGuardEvents.isPlayerInAnyRegion(players.getUniqueId(), "Spawn")) {

                if(players.getPlayerTime() != 6000) {
                    players.setPlayerTime(6000, false);
                }

            } else {

                if(players.getPlayerTime() != players.getWorld().getTime()) {
                    players.setPlayerTime(players.getWorld().getTime(), false);
                }

            }

        });
    }

}
