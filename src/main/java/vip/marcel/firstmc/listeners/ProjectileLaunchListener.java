package vip.marcel.firstmc.listeners;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.projectiles.ProjectileSource;
import vip.marcel.firstmc.RPGSword;

public record ProjectileLaunchListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void on (ProjectileLaunchEvent event) {
        final ProjectileSource shooter = event.getEntity().getShooter();

        if(shooter instanceof Player player) {

            if(WorldGuardEvents.isPlayerInAnyRegion(player.getUniqueId(), "Spawn")) {

                if(!player.getInventory().getItemInMainHand().getType().equals(Material.ENDER_PEARL) &&
                !player.getInventory().getItemInOffHand().getType().equals(Material.ENDER_PEARL)) {


                    event.setCancelled(true);
                    player.sendMessage("§7§l(§c§l!§7§l)§r §7You can't launch projectiles in this area.");
                }

            }

        }

    }

}
