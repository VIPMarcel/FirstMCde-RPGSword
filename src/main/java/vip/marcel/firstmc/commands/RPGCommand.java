package vip.marcel.firstmc.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record RPGCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if(sender instanceof Player player) {
            final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

            if(arguments.length == 0) {
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages:");
            }

            if(arguments.length == 1) {

                if(arguments[0].equalsIgnoreCase("admin") && player.hasPermission("rpg.admin")) {
                    rpgPlayer.grandExperience(100);
                    player.sendMessage("§7§l(§4!§7§l)§r §7Generation §a100 experience §7points...");
                    player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 0.1F, 0.1F);
                }

                //TODO: Create commands

                else {
                    player.sendMessage("§7§l(§a?§7§l)§r §7Usages:");
                }

            }

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
