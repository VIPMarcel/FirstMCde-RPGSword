package vip.marcel.firstmc.listeners;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record EntityDamageByEntityListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        final Entity entity = event.getEntity();
        final Entity damager = event.getDamager();

        if(damager instanceof Player player) {
            final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

            if(WorldGuardEvents.isPlayerInAnyRegion(player.getUniqueId(), "Spawn")) {
                if(!this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getKillableEntityType().equals(entity.getType())) {
                    event.setCancelled(true);
                    //player.sendMessage("§7§l(§c§l!§7§l)§r §7You cannot kill this Mob, your §4§lSword-level§r §7is too low.");
                    player.sendMessage("§cYou can only kill " + this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getKillableEntityType().getName() + " §cwith level " + rpgPlayer.getLevel() + "!");
                }
            }

        }

    }

}
