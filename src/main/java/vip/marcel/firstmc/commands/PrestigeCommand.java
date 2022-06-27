package vip.marcel.firstmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.events.AchievmentGrandEvent;
import vip.marcel.firstmc.utils.enums.Achievment;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record PrestigeCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if (sender instanceof Player player) {
            final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

            if((rpgPlayer.getLevel() >= this.plugin.getMaxSwordLevel()) && rpgPlayer.getExperience() >= this.plugin.getSwordLevelMap().get(rpgPlayer.getLevel()).getMaxExperience()) {
                // Player reaches max level, prestige +1

                rpgPlayer.grandPrestigeLevel();
                rpgPlayer.resetLevel();
                rpgPlayer.resetExperience();

                this.plugin.getApi().runTaskLater(() -> {
                    {
                        Firework firework = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
                        FireworkMeta fireworkMeta = firework.getFireworkMeta();
                        FireworkEffect.Builder fBuilder = FireworkEffect.builder();
                        fBuilder.withTrail();
                        fBuilder.withFlicker();
                        fBuilder.withFade(Color.ORANGE);
                        fBuilder.withColor(Color.YELLOW);
                        fBuilder.withColor(Color.RED);
                        fBuilder.with(FireworkEffect.Type.STAR);
                        fireworkMeta.addEffects(fBuilder.build());
                        fireworkMeta.setPower(1);
                        firework.setFireworkMeta(fireworkMeta);
                    }
                }, 5);
                this.plugin.getApi().runTaskLater(() -> {
                    {
                        Firework firework = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
                        FireworkMeta fireworkMeta = firework.getFireworkMeta();
                        FireworkEffect.Builder fBuilder = FireworkEffect.builder();
                        fBuilder.withTrail();
                        fBuilder.withFlicker();
                        fBuilder.withFade(Color.ORANGE);
                        fBuilder.withColor(Color.YELLOW);
                        fBuilder.withColor(Color.RED);
                        fBuilder.with(FireworkEffect.Type.STAR);
                        fireworkMeta.addEffects(fBuilder.build());
                        fireworkMeta.setPower(1);
                        firework.setFireworkMeta(fireworkMeta);
                    }
                }, 10);
                this.plugin.getApi().runTaskLater(() -> {
                    {
                        Firework firework = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
                        FireworkMeta fireworkMeta = firework.getFireworkMeta();
                        FireworkEffect.Builder fBuilder = FireworkEffect.builder();
                        fBuilder.withTrail();
                        fBuilder.withFlicker();
                        fBuilder.withFade(Color.ORANGE);
                        fBuilder.withColor(Color.YELLOW);
                        fBuilder.withColor(Color.RED);
                        fBuilder.with(FireworkEffect.Type.STAR);
                        fireworkMeta.addEffects(fBuilder.build());
                        fireworkMeta.setPower(1);
                        firework.setFireworkMeta(fireworkMeta);
                    }
                }, 15);
                this.plugin.getApi().runTaskLater(() -> {
                    {
                        Firework firework = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
                        FireworkMeta fireworkMeta = firework.getFireworkMeta();
                        FireworkEffect.Builder fBuilder = FireworkEffect.builder();
                        fBuilder.withTrail();
                        fBuilder.withFlicker();
                        fBuilder.withFade(Color.ORANGE);
                        fBuilder.withColor(Color.YELLOW);
                        fBuilder.withColor(Color.RED);
                        fBuilder.with(FireworkEffect.Type.STAR);
                        fireworkMeta.addEffects(fBuilder.build());
                        fireworkMeta.setPower(1);
                        firework.setFireworkMeta(fireworkMeta);
                    }
                }, 20);

                rpgPlayer.updateRPGSword();

                rpgPlayer.setMultiplikator(this.plugin.getPrestigeLevelMap().get(rpgPlayer.getPrestigeLevel()).getMultiplikator());

                Bukkit.getPluginManager().callEvent(new AchievmentGrandEvent(player, Achievment.FIRST_PRESTIGE));

                player.sendTitle("§7You have reached", "§7prestige §a" + rpgPlayer.getPrestigeLevel());
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 10F);
                Bukkit.broadcastMessage("§a§l" + player.getName() + "§7 has achieved prestige §a§l" + rpgPlayer.getPrestigeLevel());
            } else {
                player.sendMessage("§7§l(§c§l!§7§l)§r §7Your level is too low, you can't prestige.");
            }

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
