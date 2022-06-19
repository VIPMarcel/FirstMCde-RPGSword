package vip.marcel.firstmc.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.pluginapi.managers.LocationManager;

public record AFKCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if(sender instanceof Player player) {

            final LocationManager locationManager = this.plugin.getApi().getLocationManager();

            if(locationManager.doesLocationExists("AFKArea")) {

                player.teleport(locationManager.getLocation("AFKArea"));
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.5F, 0.5F);
                player.sendMessage("§7§l(§a§l!§7§l)§r §7Teleporting to §aafk §7area.");

            } else {
                player.sendMessage("§7§l(§c§l!§7§l)§r §7The position was not found.");
            }

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
