package vip.marcel.firstmc.listeners;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record BlockBreakListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        final Player player = event.getPlayer();

        if(WorldGuardEvents.isPlayerInAnyRegion(player.getUniqueId(), "Spawn")) {

            if(!this.plugin.getEditModePlayerList().contains(player)) {

                final Block block = event.getBlock();
                final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

                event.setCancelled(true);

                if(block.getType().equals(Material.COAL_ORE)) {
                    if(rpgPlayer.getLevel() >= 1) {

                        int grandCoins;
                        if(rpgPlayer.getPlayerMultiplikator() == 1) {
                            grandCoins = 1 * rpgPlayer.getPlayerMultiplikator();
                        } else {
                            grandCoins = 1 * (rpgPlayer.getPlayerMultiplikator() - 1);
                        }

                        rpgPlayer.grandRPGCoins(grandCoins);
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.8F);
                        this.plugin.getApi().hologram(block.getLocation(), "§a§l+ §7" + grandCoins + " Coins").showHologramForPlayerTemporary(player, 15);

                        final Material oldType = block.getType();
                        Bukkit.getWorld(block.getWorld().getName()).setType(block.getLocation(), Material.BEDROCK);
                        this.plugin.getApi().runTaskLater(() -> {
                            Bukkit.getWorld(block.getWorld().getName()).setType(block.getLocation(), oldType);
                            Bukkit.getOnlinePlayers().forEach(players -> {
                                players.playEffect(block.getLocation(), Effect.SMOKE, 1);
                            });
                        }, 20 * 60);

                    } else {
                        player.sendMessage("§7§l(§c§l!§7§l)§r §7You need level §a" + 1 + " §7to break this ore.");
                    }
                }

                if(block.getType().equals(Material.IRON_ORE) | block.getType().equals(Material.GOLD_ORE)) {
                    if(rpgPlayer.getLevel() >= 3) {

                        int grandCoins;
                        if(rpgPlayer.getPlayerMultiplikator() == 1) {
                            grandCoins = 2 * rpgPlayer.getPlayerMultiplikator();
                        } else {
                            grandCoins = 2 * (rpgPlayer.getPlayerMultiplikator() - 1);
                        }

                        rpgPlayer.grandRPGCoins(grandCoins);
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.8F);
                        this.plugin.getApi().hologram(block.getLocation(), "§a§l+ §7" + grandCoins + " Coins").showHologramForPlayerTemporary(player, 15);

                        final Material oldType = block.getType();
                        Bukkit.getWorld(block.getWorld().getName()).setType(block.getLocation(), Material.BEDROCK);
                        this.plugin.getApi().runTaskLater(() -> {
                            Bukkit.getWorld(block.getWorld().getName()).setType(block.getLocation(), oldType);
                            Bukkit.getOnlinePlayers().forEach(players -> {
                                players.playEffect(block.getLocation(), Effect.SMOKE, 1);
                            });
                        }, 20 * 60);

                    } else {
                        player.sendMessage("§7§l(§c§l!§7§l)§r §7You need level §a" + 3 + " §7to break this ore.");
                    }
                }

                if(block.getType().equals(Material.REDSTONE_ORE)) {
                    if(rpgPlayer.getLevel() >= 5) {

                        int grandCoins;
                        if(rpgPlayer.getPlayerMultiplikator() == 1) {
                            grandCoins = 3 * rpgPlayer.getPlayerMultiplikator();
                        } else {
                            grandCoins = 3 * (rpgPlayer.getPlayerMultiplikator() - 1);
                        }

                        rpgPlayer.grandRPGCoins(grandCoins);
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.8F);
                        this.plugin.getApi().hologram(block.getLocation(), "§a§l+ §7" + grandCoins + " Coins").showHologramForPlayerTemporary(player, 15);

                        final Material oldType = block.getType();
                        Bukkit.getWorld(block.getWorld().getName()).setType(block.getLocation(), Material.BEDROCK);
                        this.plugin.getApi().runTaskLater(() -> {
                            Bukkit.getWorld(block.getWorld().getName()).setType(block.getLocation(), oldType);
                            Bukkit.getOnlinePlayers().forEach(players -> {
                                players.playEffect(block.getLocation(), Effect.SMOKE, 1);
                            });
                        }, 20 * 60);

                    } else {
                        player.sendMessage("§7§l(§c§l!§7§l)§r §7You need level §a" + 5 + " §7to break this ore.");
                    }
                }

                if(block.getType().equals(Material.EMERALD_ORE) | block.getType().equals(Material.DIAMOND_ORE)) {
                    if(rpgPlayer.getLevel() >= 10) {

                        int grandCoins;
                        if(rpgPlayer.getPlayerMultiplikator() == 1) {
                            grandCoins = 5 * rpgPlayer.getPlayerMultiplikator();
                        } else {
                            grandCoins = 5 * (rpgPlayer.getPlayerMultiplikator() - 1);
                        }

                        rpgPlayer.grandRPGCoins(grandCoins);
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.8F);
                        this.plugin.getApi().hologram(block.getLocation(), "§a§l+ §7" + grandCoins + " Coins").showHologramForPlayerTemporary(player, 15);

                        final Material oldType = block.getType();
                        Bukkit.getWorld(block.getWorld().getName()).setType(block.getLocation(), Material.BEDROCK);
                        this.plugin.getApi().runTaskLater(() -> {
                            Bukkit.getWorld(block.getWorld().getName()).setType(block.getLocation(), oldType);
                            Bukkit.getOnlinePlayers().forEach(players -> {
                                players.playEffect(block.getLocation(), Effect.SMOKE, 1);
                            });
                        }, 20 * 60);

                    } else {
                        player.sendMessage("§7§l(§c§l!§7§l)§r §7You need level §a" + 10 + " §7to break this ore.");
                    }
                }

                if(block.getType().equals(Material.EMERALD_BLOCK) | block.getType().equals(Material.DIAMOND_BLOCK)) {
                    if(rpgPlayer.getLevel() >= 20) {

                        int grandCoins;
                        if(rpgPlayer.getPlayerMultiplikator() == 1) {
                            grandCoins = 12 * rpgPlayer.getPlayerMultiplikator();
                        } else {
                            grandCoins = 12 * (rpgPlayer.getPlayerMultiplikator() - 1);
                        }

                        rpgPlayer.grandRPGCoins(grandCoins);
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.8F);
                        this.plugin.getApi().hologram(block.getLocation(), "§a§l+ §7" + grandCoins + " Coins").showHologramForPlayerTemporary(player, 15);

                        final Material oldType = block.getType();
                        Bukkit.getWorld(block.getWorld().getName()).setType(block.getLocation(), Material.BEDROCK);
                        this.plugin.getApi().runTaskLater(() -> {
                            Bukkit.getWorld(block.getWorld().getName()).setType(block.getLocation(), oldType);
                            Bukkit.getOnlinePlayers().forEach(players -> {
                                players.playEffect(block.getLocation(), Effect.SMOKE, 1);
                            });
                        }, 20 * 60);

                    } else {
                        player.sendMessage("§7§l(§c§l!§7§l)§r §7You need level §a" + 20 + " §7to break this ore.");
                    }
                }

            }

        }

    }

}
