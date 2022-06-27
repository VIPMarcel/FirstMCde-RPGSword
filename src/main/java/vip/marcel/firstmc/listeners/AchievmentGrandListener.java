package vip.marcel.firstmc.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.events.AchievmentGrandEvent;
import vip.marcel.firstmc.utils.enums.Achievment;
import vip.marcel.firstmc.utils.managers.AchievmentManager;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record AchievmentGrandListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onAchievmentGrandEvent(AchievmentGrandEvent event) {
        final Player player = event.getPlayer();
        final Achievment achievment = event.getAchievment();

        final AchievmentManager achievmentManager = this.plugin.getAchievmentManager(player);

        if(achievmentManager.hasAchievment(achievment)) {
            event.setCancelled(true);
        }

        if(!event.isCancelled()) {

            final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

            achievmentManager.grandAchievment(achievment);
            rpgPlayer.grandRPGCoins(achievment.getReward());

            player.sendMessage("");
            player.sendMessage("§7§l§k============================================");
            player.sendMessage("");
            player.sendMessage("§7You grand the §a§lachievment§r§7: §e" + achievment.getName());
            player.sendMessage("    §7" + achievment.getDescription());
            player.sendMessage("");
            player.sendMessage("§7You earned §a" + achievment.getReward() + " coins§7.");
            player.sendMessage("");
            player.sendMessage("§7§l§k============================================");
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10F, 10F);

        }

    }

}
