package vip.marcel.firstmc.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record PlayerLoginListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onLoginEvent(PlayerLoginEvent event) {
        final Player player = event.getPlayer();
        final RPGPlayer rpgPlayer = new RPGPlayer(this.plugin, player);

        this.plugin.getConfigManager().createConfig(player.getUniqueId());
        this.plugin.getPlayerFileMap().put(player, this.plugin.getConfigManager().getPlayerFile(player.getUniqueId()));

        this.plugin.getRPGPlayerMap().put(player, rpgPlayer);
    }

}
