package vip.marcel.firstmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

import java.io.File;
import java.util.UUID;

public record CoinsCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if(sender instanceof Player player) {
            final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

            if(arguments.length == 0) {

                int multiplier;
                if(rpgPlayer.getPlayerMultiplikator() == 1) {
                    multiplier = rpgPlayer.getPlayerMultiplikator();
                } else {
                    multiplier = (rpgPlayer.getPlayerMultiplikator() - 1);
                }

                player.sendMessage("§7§l(§a!§7§l)§r §7You have §a" + rpgPlayer.getRPGCoins() + " §7Coins.");
                player.sendMessage("§7§l(§a!§7§l)§r §7And a coins multiplier of §a" + multiplier + "§7.");

            } else if(arguments.length == 2) {

                if(arguments[0].equalsIgnoreCase("show")) {

                    UUID uuid = Bukkit.getOfflinePlayer(arguments[1]).getUniqueId();
                    String playerName = Bukkit.getOfflinePlayer(arguments[1]).getName();

                    if(uuid == null) {
                        player.sendMessage("§7§l(§c!§7§l)§r §7The player §a" + arguments[1] + " §7was not found.");
                        return true;
                    }

                    final File playerFile = this.plugin.getConfigManager().getPlayerFile(uuid);

                    if(playerFile == null) {
                        player.sendMessage("§7§l(§c!§7§l)§r §7The player §a" + playerName + " §7was not found.");
                        return true;
                    }

                    final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(playerFile);

                    int playerCoins = configuration.getInt("RPGCoins");

                    int multiplier;
                    if(configuration.getInt("Player-Multiplikator") == 1) {
                        multiplier = configuration.getInt("Player-Multiplikator");
                    } else {
                        multiplier = (configuration.getInt("Player-Multiplikator") - 1);
                    }

                    player.sendMessage("§7§l(§a!§7§l)§r §a" + playerName + "§7 has §a" + playerCoins + " §7Coins.");
                    player.sendMessage("§7§l(§a!§7§l)§r §7And a coins multiplier of §a" + multiplier + "§7.");

                } else if(arguments[0].equalsIgnoreCase("withdraw")) {

                    int coinsAmount;

                    try {
                        coinsAmount = Integer.parseInt(arguments[1]);
                    } catch (NumberFormatException e) {
                        player.sendMessage("§7§l(§c!§7§l)§r §7The §aamount §7" + arguments[1] + " §7is not valid.");
                        return true;
                    }

                    if(rpgPlayer.getRPGCoins() < coinsAmount) {
                        player.sendMessage("§7§l(§c!§7§l)§r §7You don't have enought coins.");
                        return true;
                    }

                    rpgPlayer.removeRPGCoins(coinsAmount);

                    player.getInventory().addItem(this.plugin.getApi().item(Material.PAPER)
                            .setDisplayname("§b§lCoins §b§lCoupon")
                            .setUnbreakable(true)
                            .addEnchantment(Enchantment.VANISHING_CURSE, 10)
                            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                            .addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .setLore("§6" + coinsAmount + "§7 Coins")
                            .build());

                    player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 0.5F, 0.25F);
                    player.sendMessage("§7§l(§a!§7§l)§r §7Added §acoin coupon §7with value §a" + coinsAmount + "$ §7to your inventory.");

                } else {
                    player.sendMessage("§7§l(§a!§7§l)§r §7/coins show §a[player]");
                    player.sendMessage("§7§l(§a!§7§l)§r §7/coins withdraw §a[amount]");
                }

            } else {
                player.sendMessage("§7§l(§a!§7§l)§r §7/coins show §a[player]");
                player.sendMessage("§7§l(§a!§7§l)§r §7/coins withdraw §a[amount]");
            }

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
