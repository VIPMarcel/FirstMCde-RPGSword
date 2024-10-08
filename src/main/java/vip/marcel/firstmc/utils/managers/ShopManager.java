package vip.marcel.firstmc.utils.managers;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.events.AchievmentGrandEvent;
import vip.marcel.firstmc.utils.enums.Achievment;
import vip.marcel.firstmc.utils.enums.ShopItem;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record ShopManager(RPGSword plugin, Player player) {

    public boolean hasBought(ShopItem shopItem) {

        if(player.hasPermission(shopItem.getPermission())) {
            return true;
        }

        return false;
    }

    public boolean grandItem(ShopItem shopItem) {
        final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

        if(rpgPlayer.getRPGCoins() < shopItem.getPrice()) {
            if(player.getOpenInventory() != null) {
                player.closeInventory();
            }
            player.sendMessage("§7§l(§c§l!§7§l)§r §7You dont have enought coins to do this.");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
            return false;
        }

        /* Filters Rank from RANKS-MENU */
        if(shopItem.getName().equalsIgnoreCase("Coal")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent set coal");
        } else if(shopItem.getName().equalsIgnoreCase("Gold")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent set gold");
        } else if(shopItem.getName().equalsIgnoreCase("Emerald")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent set emerald");
        } else if(shopItem.getName().equalsIgnoreCase("Diamond")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent set diamond");
        }

        /* Filters OP-Items from TOOL-SHOP-MENU */
        else if(shopItem.getName().startsWith("OP")) {
            // Handled in InventoryClickListener.class
        }

        /* Filters CRATES-Key from CRATES-SHOP-MENU */
        else if(shopItem.getName().startsWith("Common")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "excellentcrates key give " + player.getName() + " common 1");
        }
        else if(shopItem.getName().startsWith("Uncommon")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "excellentcrates key give " + player.getName() + " uncommon 1");
        }
        else if(shopItem.getName().startsWith("Rare")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "excellentcrates key give " + player.getName() + " rare 1");
        }
        else if(shopItem.getName().startsWith("Legendary")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "excellentcrates key give " + player.getName() + " legendary 1");
        }

        else {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set " + shopItem.getPermission() + " true");
        }

        rpgPlayer.removeRPGCoins(shopItem.getPrice());
        Bukkit.getPluginManager().callEvent(new AchievmentGrandEvent(player, Achievment.FIRST_SHOP_CONFIRM));
        return true;
    }

    public void removeItem(ShopItem shopItem) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set " + shopItem.getPermission() + " false");
    }



}
