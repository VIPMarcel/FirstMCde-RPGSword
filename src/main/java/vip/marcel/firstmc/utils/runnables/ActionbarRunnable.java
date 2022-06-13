package vip.marcel.firstmc.utils.runnables;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public class ActionbarRunnable extends BukkitRunnable {

    private final RPGSword plugin;

    public ActionbarRunnable(RPGSword plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(players -> {
            final RPGPlayer rpgPlayers = this.plugin.getRPGPlayerMap().get(players);

            if(players.getItemInHand() == null) {
                return;
            }
            if(players.getItemInHand().getItemMeta() == null) {
                return;
            }
            if(players.getItemInHand().getItemMeta().getDisplayName() == null) {
                return;
            }

            if(players.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(this.plugin.getSwordItems().get(rpgPlayers.getLevel()).getItemMeta().getDisplayName())) {

                players.sendActionBar("§7XP §8» §6" + rpgPlayers.getExperience() + "§8/§7" + this.plugin.getSwordLevelMap().get(rpgPlayers.getLevel()).getMaxExperience());

            }

        });
    }

}
