package vip.marcel.firstmc.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;

public record SetPositionCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if(sender instanceof Player player) {

            if(player.hasPermission("rpg.command.setposition")) {

                if(arguments.length == 0) {
                    player.sendMessage("§7§l(§c§l!§7§l)§r §7Enter a location name.");
                    return true;
                }
                final String locationName = arguments[0];

                this.plugin.getApi().getLocationManager().saveLocation(locationName, player.getLocation());
                player.playSound(player.getLocation(), Sound.BLOCK_BLASTFURNACE_FIRE_CRACKLE, 0.5F, 0.5F);
                player.sendMessage("§7§l(§a§l!§7§l)§r §7Saved location §a" + locationName + "§7.");

            } else {
                player.sendMessage("§7§l(§c§l!§7§l)§r §7You need to be a server administrator.");
            }

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
