package vip.marcel.firstmc.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;

public record EditModeCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if(sender instanceof Player player) {

            if(player.hasPermission("rpg.command.editmode")) {

                if(this.plugin.getEditModePlayerList().contains(player)) {
                    this.plugin.getEditModePlayerList().remove(player);
                    player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 0.5F, 0.5F);
                    player.sendMessage("§7§l(§a§l!§7§l)§r §7You can no longer §aedit §7the map.");

                } else {
                    this.plugin.getEditModePlayerList().add(player);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5F, 0.5F);
                    player.sendMessage("§7§l(§a§l!§7§l)§r §7You can now §aedit §7the map.");
                }

            } else {
                player.sendMessage("§7§l(§c§l!§7§l)§r §7You need to be a server administrator.");
            }

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
