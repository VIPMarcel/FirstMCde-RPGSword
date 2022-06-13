package vip.marcel.firstmc.commands;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record FixSwordCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if (sender instanceof Player player) {
            final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

            if(WorldGuardEvents.isPlayerInAnyRegion(player.getUniqueId(), "Spawn")) {

                rpgPlayer.updateRPGSword();
                player.sendMessage("§7You have successfully returned your sword.");

            } else {
                player.sendMessage("§7§l(§c§l!§7§l)§r §7You are not in the permitted area.");
            }

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
