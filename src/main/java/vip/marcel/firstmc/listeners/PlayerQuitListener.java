package vip.marcel.firstmc.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import vip.marcel.firstmc.RPGSword;

public record PlayerQuitListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        final Player player = event.getPlayer();

        this.plugin.getConfigManager().setPlayerFile(player.getUniqueId(), this.plugin.getPlayerFileMap().get(player));
        this.plugin.getPlayerFileMap().remove(player);
        this.plugin.getRPGPlayerMap().remove(player);
        this.plugin.getEditModePlayerList().remove(player);
    }

}
