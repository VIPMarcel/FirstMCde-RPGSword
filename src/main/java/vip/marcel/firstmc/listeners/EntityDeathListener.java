package vip.marcel.firstmc.listeners;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record EntityDeathListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent event) {
        final LivingEntity entity = event.getEntity();

        final Player killer = entity.getKiller();
        final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(killer);

        if(WorldGuardEvents.isPlayerInAnyRegion(killer.getUniqueId(), "Spawn")) {
            if(killer.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(this.plugin.getSwordItems().get(rpgPlayer.getLevel()).getItemMeta().getDisplayName())) {
                event.getDrops().clear();
                event.setDroppedExp(0);

                rpgPlayer.grandRPGCoins(this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getCoinsPerKill());

                if(rpgPlayer.getLevel() == 20) {
                    if(rpgPlayer.getExperience() >= this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getMaxExperience()) {
                        return;
                    }
                }

                rpgPlayer.grandExperience(this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getGrandExperience() * rpgPlayer.getMultiplikator());

                if(rpgPlayer.getExperience() >= this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getMaxExperience()) {
                    // Player levels up

                    rpgPlayer.grandLevel();
                    rpgPlayer.resetExperience();
                    killer.playSound(killer.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_SHOOT, 0.5F, 5F);
                    rpgPlayer.updateRPGSword();
                }

            }
        }

    }

}
