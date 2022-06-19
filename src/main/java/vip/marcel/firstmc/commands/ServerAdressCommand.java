package vip.marcel.firstmc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;

public record ServerAdressCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if(sender instanceof Player player) {

            player.sendMessage("§7§l(§a§l!§7§l)§r §7The server adress is: §f§lRaceRPG.minehut.gg");

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
