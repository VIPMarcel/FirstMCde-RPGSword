package vip.marcel.firstmc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;

public record DiscordCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if(sender instanceof Player player) {

            player.sendMessage("            §9§lDiscord");
            player.sendMessage("§7§lDiscord-Link:§r §bhttps://discord.gg/Cf6ZyUXv4T ");

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
