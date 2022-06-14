package vip.marcel.firstmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

import java.io.File;
import java.util.UUID;

public record CoinsCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if(sender instanceof Player player) {

            if(arguments.length == 0) {
                final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

                player.sendMessage("§7§l(§a!§7§l)§r §7You have §a" + rpgPlayer.getRPGCoins() + " §7Coins.");

            } else {

                UUID uuid = Bukkit.getOfflinePlayer(arguments[0]).getUniqueId();
                String playerName = Bukkit.getOfflinePlayer(arguments[0]).getName();

                if(uuid == null) {
                    player.sendMessage("§7§l(§c!§7§l)§r §7The player §a" + arguments[0] + " §7was not found.");
                    return true;
                }

                final File playerFile = this.plugin.getConfigManager().getPlayerFile(uuid);

                if(playerFile == null) {
                    player.sendMessage("§7§l(§c!§7§l)§r §7The player §a" + playerName + " §7was not found.");
                    return true;
                }

                final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(playerFile);

                int playerCoins = configuration.getInt("RPGCoins");
                player.sendMessage("§7§l(§a!§7§l)§r §a" + playerName + "§7 has §a" + playerCoins + " §7Coins.");

            }

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
