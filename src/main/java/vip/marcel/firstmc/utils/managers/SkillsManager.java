package vip.marcel.firstmc.utils.managers;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.enums.ShopItem;

public record SkillsManager(RPGSword plugin, Player player) {

    public boolean hasSkillEnabled(ShopItem shopItem) {

        if(player.hasPermission(shopItem.getPermission() + ".on")) {
            return true;
        }

        return false;
    }

    public void enableSkill(ShopItem shopItem) {
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.5F);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set " + shopItem.getPermission() + ".on true");
    }

    public void disableSkill(ShopItem shopItem) {
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 0.5F, 0.5F);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set " + shopItem.getPermission() + ".on false");
    }

}
