package vip.marcel.firstmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

import java.util.UUID;

public record RPGCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if(sender instanceof Player player) {
            final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

            if(!player.hasPermission("rpg.admin")) {
                player.sendMessage(" ");
                player.sendMessage("§7Plugin wrote by VIPMarcel §7for RaceRPG.");
                player.sendMessage("§7In the RPG World you can farm §acoins §7and");
                player.sendMessage("§aXP §7to reach next levels. The mobs and weapons");
                player.sendMessage("§7are gettings §astronger §7and §abetter§7.");
                player.sendMessage("§7If you completed all §a" + this.plugin.getMaxSwordLevel() + " levels §7you can");
                player.sendMessage("§7prestige with §8'§a/prestige§8'§7. Now you start again from §alevel 1");
                player.sendMessage("§7with a higher §amultiplier§7.");
                player.sendMessage("§7Do §8'§a/levelbox§8' §7to teleport to your §alevel area§7.");
                player.sendMessage("§7Do §8'§a/fixsword§8' §7to grand your sword back.");
                player.sendMessage("§7Do §8'§a/coins withdraw§8' §7to create §acoin coupons§7.");
                player.sendMessage("§7Do §8'§a/skills§8' §7to activate your §abought skills§7.");
                player.sendMessage("§7Do §8'§a/prestigetop§8' §7to see the §atop 10 §7players§7.");
                player.sendMessage("§7Do §8'§a/coinshop§8' §7to buy cool new stuff§7.");
                player.sendMessage("§7Do §8'§a/afk§8' §7to teleport to the §aafk area§7.");
                player.sendMessage("§7Do §8'§a/ip§8' §7to look up the §aserver adress§7.");
                player.sendMessage("§7Do §8'§a/discord§8' §7to look up the §adiscord url§7.");
                player.sendMessage(" ");
                return true;
            }

            if(arguments.length == 0) {
                player.sendMessage(" ");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetXP §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetLevel §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetCoinsMultiplikator §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §aaddCoinsMultiplikator §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetPrestige §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetCoins §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §agetCoinsMultiplikatorItem §7<Amount>");
                player.sendMessage(" ");
                return true;
            }

            else if(arguments.length == 1) {

                if(arguments[0].equalsIgnoreCase("setXP") && player.hasPermission("rpg.admin")) {
                    player.sendMessage("§7§l(§a!§7§l)§r §7Enter a §aplayername §7to change his §aexperience§7.");
                    return true;
                }

                if(arguments[0].equalsIgnoreCase("setLevel") && player.hasPermission("rpg.admin")) {
                    player.sendMessage("§7§l(§a!§7§l)§r §7Enter a §aplayername §7to change his §alevel§7.");
                    return true;
                }

                if(arguments[0].equalsIgnoreCase("setCoinsMultiplikator") && player.hasPermission("rpg.admin")) {
                    player.sendMessage("§7§l(§a!§7§l)§r §7Enter a §aplayername §7to change his §acoins multiplikator§7.");
                    return true;
                }

                if(arguments[0].equalsIgnoreCase("addCoinsMultiplikator") && player.hasPermission("rpg.admin")) {
                    player.sendMessage("§7§l(§a!§7§l)§r §7Enter a §aplayername §7to change his §acoins multiplikator§7.");
                    return true;
                }

                if(arguments[0].equalsIgnoreCase("setPrestige") && player.hasPermission("rpg.admin")) {
                    player.sendMessage("§7§l(§a!§7§l)§r §7Enter a §aplayername §7to change his §aprestige level§7.");
                    return true;
                }

                if(arguments[0].equalsIgnoreCase("setCoins") && player.hasPermission("rpg.admin")) {
                    player.sendMessage("§7§l(§a!§7§l)§r §7Enter a §aplayername §7to change his §acoins§7.");
                    return true;
                }

                if(arguments[0].equalsIgnoreCase("getCoinsMultiplikatorItem") && player.hasPermission("rpg.admin")) {
                    player.sendMessage("§7§l(§a!§7§l)§r §7Enter a §avalue §7to create a §acoins multiplier item§7.");
                    return true;
                }

                else {
                    player.sendMessage(" ");
                    player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetXP §7<Player> <Amount>");
                    player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetLevel §7<Player> <Amount>");
                    player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetCoinsMultiplikator §7<Player> <Amount>");
                    player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §aaddCoinsMultiplikator §7<Player> <Amount>");
                    player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetPrestige §7<Player> <Amount>");
                    player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetCoins §7<Player> <Amount>");
                    player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §agetCoinsMultiplikatorItem §7<Amount>");
                    player.sendMessage(" ");
                }

            }

            else if(arguments.length == 2) {

                if(arguments[0].equalsIgnoreCase("getCoinsMultiplikatorItem") && player.hasPermission("rpg.admin")) {

                    int newValue;
                    try {
                        newValue = Integer.parseInt(arguments[1]);
                    } catch (NumberFormatException e) {
                        player.sendMessage("§7§l(§c!§7§l)§r §7The §aamount §7" + arguments[1] + " §7is not valid.");
                        return true;
                    }

                    player.getInventory().addItem(this.plugin.getApi().item(Material.BLAZE_ROD)
                            .setDisplayname("§6§lCoins §6§lMultiplier")
                            .setUnbreakable(true)
                            .addEnchantment(Enchantment.VANISHING_CURSE, 10)
                            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                            .addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .setLore("§6x" + newValue + "§7 Multiplier")
                            .build());

                    player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 0.5F, 0.25F);
                    player.sendMessage("§7§l(§a!§7§l)§r §7Added §acoin multiplier §7with value §ax" + newValue + " §7to your inventory.");
                    return true;
                }

            }

            else if(arguments.length == 3) {

                final UUID uuid = Bukkit.getOfflinePlayer(arguments[1]).getUniqueId();

                if(uuid == null) {
                    player.sendMessage("§7§l(§c!§7§l)§r §7The player §a" + arguments[1] + " §7was not found.");
                    return true;
                }

                if(Bukkit.getPlayer(uuid) == null) {
                    player.sendMessage("§7§l(§c!§7§l)§r §7The player §a" + arguments[1] + " §7is not online");
                    return true;
                }
                final Player targetPlayer = Bukkit.getPlayer(uuid);
                final RPGPlayer rpgTarget = this.plugin.getRPGPlayerMap().get(targetPlayer);


                if(arguments[0].equalsIgnoreCase("setXP") && player.hasPermission("rpg.admin")) {

                    double newValue;
                    try {
                        newValue = Double.parseDouble(arguments[2]);
                    } catch (NumberFormatException e) {
                        player.sendMessage("§7§l(§c!§7§l)§r §7The §aamount §7" + arguments[2] + " §7is not valid.");
                        return true;
                    }

                    rpgTarget.setExperience(newValue);
                    player.sendMessage("§7§l(§a§l!§7§l)§r §7New value set to player §a" + targetPlayer.getName() + "§7.");

                    return true;
                }

                if(arguments[0].equalsIgnoreCase("setLevel") && player.hasPermission("rpg.admin")) {

                    int newValue;
                    try {
                        newValue = Integer.parseInt(arguments[2]);
                    } catch (NumberFormatException e) {
                        player.sendMessage("§7§l(§c!§7§l)§r §7The §aamount §7" + arguments[2] + " §7is not valid.");
                        return true;
                    }

                    rpgTarget.setLevel(newValue);
                    player.sendMessage("§7§l(§a§l!§7§l)§r §7New value set to player §a" + targetPlayer.getName() + "§7.");

                    return true;
                }

                if(arguments[0].equalsIgnoreCase("setCoinsMultiplikator") && player.hasPermission("rpg.admin")) {

                    int newValue;
                    try {
                        newValue = Integer.parseInt(arguments[2]);
                    } catch (NumberFormatException e) {
                        player.sendMessage("§7§l(§c!§7§l)§r §7The §aamount §7" + arguments[2] + " §7is not valid.");
                        return true;
                    }

                    rpgTarget.setPlayerMultiplikator(newValue);
                    player.sendMessage("§7§l(§a§l!§7§l)§r §7New value set to player §a" + targetPlayer.getName() + "§7.");

                    return true;
                }

                if(arguments[0].equalsIgnoreCase("addCoinsMultiplikator") && player.hasPermission("rpg.admin")) {

                    int newValue;
                    try {
                        newValue = Integer.parseInt(arguments[2]);
                    } catch (NumberFormatException e) {
                        player.sendMessage("§7§l(§c!§7§l)§r §7The §aamount §7" + arguments[2] + " §7is not valid.");
                        return true;
                    }

                    rpgTarget.grandPlayerMultiplikator(newValue);
                    player.sendMessage("§7§l(§a§l!§7§l)§r §7New value set to player §a" + targetPlayer.getName() + "§7.");

                    return true;
                }

                if(arguments[0].equalsIgnoreCase("setPrestige") && player.hasPermission("rpg.admin")) {

                    int newValue;
                    try {
                        newValue = Integer.parseInt(arguments[2]);
                    } catch (NumberFormatException e) {
                        player.sendMessage("§7§l(§c!§7§l)§r §7The §aamount §7" + arguments[2] + " §7is not valid.");
                        return true;
                    }

                    rpgTarget.setPrestigeLevel(newValue);
                    player.sendMessage("§7§l(§a§l!§7§l)§r §7New value set to player §a" + targetPlayer.getName() + "§7.");

                    return true;
                }

                if(arguments[0].equalsIgnoreCase("setCoins") && player.hasPermission("rpg.admin")) {

                    int newValue;
                    try {
                        newValue = Integer.parseInt(arguments[2]);
                    } catch (NumberFormatException e) {
                        player.sendMessage("§7§l(§c!§7§l)§r §7The §aamount §7" + arguments[2] + " §7is not valid.");
                        return true;
                    }

                    rpgTarget.setRPGCoins(newValue);
                    player.sendMessage("§7§l(§a§l!§7§l)§r §7New value set to player §a" + targetPlayer.getName() + "§7.");

                    return true;
                }

            }

            else {
                player.sendMessage(" ");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetXP §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetLevel §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetCoinsMultiplikator §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §aaddCoinsMultiplikator §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetPrestige §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §asetCoins §7<Player> <Amount>");
                player.sendMessage("§7§l(§a?§7§l)§r §7Usages: §8/§7rpg §agetCoinsMultiplikatorItem §7<Amount>");
                player.sendMessage(" ");
            }

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
