package vip.marcel.firstmc.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.enums.InventoryType;

public record SkillsCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        if(sender instanceof Player player) {

            player.openInventory(this.plugin.getInventoryManager().getInventory(InventoryType.SKILLS_MENU, player));
            player.playSound(player.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 0.5F, 0.5F);

        } else {
            sender.sendMessage("§cThis command is only for real players.");
        }

        return true;
    }

}
