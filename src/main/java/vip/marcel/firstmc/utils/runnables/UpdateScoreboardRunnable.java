package vip.marcel.firstmc.utils.runnables;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

import java.text.MessageFormat;

public class UpdateScoreboardRunnable extends BukkitRunnable {

    private final RPGSword plugin;

    public UpdateScoreboardRunnable(RPGSword plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        Bukkit.getOnlinePlayers().forEach(players -> {
            final RPGPlayer rpgPlayers = this.plugin.getRPGPlayerMap().get(players);

            if(WorldGuardEvents.isPlayerInAnyRegion(players.getUniqueId(), "Spawn") |
                    WorldGuardEvents.isPlayerInAnyRegion(players.getUniqueId(), "AFKArea")) {
                if(players.getScoreboard().getObjective(DisplaySlot.SIDEBAR) == null) {
                    this.plugin.getApi().creteScoreboard(players)
                            .setDisplaySlot(DisplaySlot.SIDEBAR)
                            .setDisplayName("§8§m----§r §7RPG Stats §8§m----")

                            .addClearRow(12)
                            .addFixRow(11, "§7Multiplier")
                            .addUpdateableRow(10, "§8» ", "§8x§b" + rpgPlayers.getMultiplikator())
                            .addClearRow(9)
                            .addFixRow(8, "§7Prestige-Level")
                            .addUpdateableRow(7, "§8» ", "§c" + rpgPlayers.getPrestigeLevel())
                            .addClearRow(6)
                            .addFixRow(5, "§7Level")
                            .addUpdateableRow(4, "§8» ", "§e" + rpgPlayers.getLevel())
                            .addClearRow(3)
                            .addFixRow(2, "§7RPG-Coins")
                            .addUpdateableRow(1, "§8» ", "§a" + MessageFormat.format("{0}", rpgPlayers.getRPGCoins()))
                            .addClearRow(0)

                            .build();
                } else {
                    this.plugin.getApi().getScoreboardBuilder().updateRow(players, 10, "§8x§b" + rpgPlayers.getMultiplikator());
                    this.plugin.getApi().getScoreboardBuilder().updateRow(players, 7, "§c" + rpgPlayers.getPrestigeLevel());
                    this.plugin.getApi().getScoreboardBuilder().updateRow(players, 4, "§e" + rpgPlayers.getLevel());
                    this.plugin.getApi().getScoreboardBuilder().updateRow(players, 1, "§a" + MessageFormat.format("{0}", rpgPlayers.getRPGCoins()));
                }
            }

        });

    }

}
