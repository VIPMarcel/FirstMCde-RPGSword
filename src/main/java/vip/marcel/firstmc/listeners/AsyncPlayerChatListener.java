package vip.marcel.firstmc.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record AsyncPlayerChatListener(RPGSword plugin) implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

        String message = event.getMessage().replaceAll("%", "%%");

        if(player.hasPermission("firstmc.chatcolors")) {
            message = ChatColor.translateAlternateColorCodes('&', message);
        }

        event.setFormat("§7[§a" + rpgPlayer.getPrestigeLevel() + "§7] " + player.getDisplayName() + " §8» §r" + message);

    }

}
