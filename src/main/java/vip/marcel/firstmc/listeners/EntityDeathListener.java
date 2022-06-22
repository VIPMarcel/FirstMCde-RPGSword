package vip.marcel.firstmc.listeners;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.Bukkit;
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

        if(entity.getKiller() == null) {
            return;
        }

        final Player killer = entity.getKiller();
        final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(killer);

        if(WorldGuardEvents.isPlayerInAnyRegion(killer.getUniqueId(), "Spawn")) {
            if(killer.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(this.plugin.getSwordItems().get(rpgPlayer.getLevel()).getItemMeta().getDisplayName())) {
                event.getDrops().clear();
                event.setDroppedExp(0);
                killer.playSound(killer.getLocation(), Sound.BLOCK_LEVER_CLICK, 0.1F, 0.1F);

                int grandCoins;
                if(rpgPlayer.getPlayerMultiplikator() == 1) {
                    grandCoins = this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getCoinsPerKill() * rpgPlayer.getPlayerMultiplikator();
                } else {
                    grandCoins = this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getCoinsPerKill() * (rpgPlayer.getPlayerMultiplikator() - 1);
                }

                this.plugin.getApi().hologram(entity.getLocation().subtract(0, 1, 0), "§a§l+ §7" + grandCoins + " Coins").showHologramForPlayerTemporary(killer, 15);

                rpgPlayer.grandRPGCoins(grandCoins);

                rpgPlayer.grandExperience(this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getGrandExperience() * rpgPlayer.getMultiplikator());

                if(rpgPlayer.getLevel() == 20 && rpgPlayer.getExperience() >= this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getMaxExperience()) {
                    return;
                } else {

                    if(rpgPlayer.getExperience() >= this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getMaxExperience()) {
                        // Player levels up

                        rpgPlayer.grandLevel();
                        rpgPlayer.resetExperience();
                        killer.sendTitle("§7✳ §a§lLEVEL UP§7! ✳", "§a" + (rpgPlayer.getLevel() - 1) + " §7⇒ §a" + rpgPlayer.getLevel());
                        Bukkit.getWorld(killer.getWorld().getName()).strikeLightningEffect(killer.getLocation());
                        killer.playSound(killer.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_SHOOT, 0.5F, 5F);
                        rpgPlayer.updateRPGSword();
                    }

                }

            } else {
                event.setCancelled(true);
            }
        }

    }

}
