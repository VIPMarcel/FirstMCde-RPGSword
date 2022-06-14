package vip.marcel.firstmc.listeners;

import net.raidstone.wgevents.events.RegionEnteredEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record PlayerRegionEnterListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onRegionEnteredEvent(RegionEnteredEvent event) {
        final Player player = event.getPlayer();
        final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

        if(event.getRegionName().equalsIgnoreCase("Spawn")) {
            rpgPlayer.updateRPGSword();

            this.plugin.getApi().creteScoreboard(player)
                    .setDisplaySlot(DisplaySlot.SIDEBAR)
                    .setDisplayName("§8§m----§r §7RPG Stats §8§m----")

                    .addClearRow(12)
                    .addFixRow(11, "§7Multiplier")
                    .addUpdateableRow(10, "§8» ", "§8x§b" + rpgPlayer.getMultiplikator())
                    .addClearRow(9)
                    .addFixRow(8, "§7Prestige-Level")
                    .addUpdateableRow(7, "§8» ", "§c" + rpgPlayer.getPrestigeLevel())
                    .addClearRow(6)
                    .addFixRow(5, "§7Level")
                    .addUpdateableRow(4, "§8» ", "§e" + rpgPlayer.getLevel())
                    .addClearRow(3)
                    .addFixRow(2, "§7RPG-Coins")
                    .addUpdateableRow(1, "§8» ", "§a" + rpgPlayer.getRPGCoins())
                    .addClearRow(0)

                    .build();
        }

    }

}
