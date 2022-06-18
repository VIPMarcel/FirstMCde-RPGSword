package vip.marcel.firstmc.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.player.RPGPlayer;

public record PlayerInteractListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final RPGPlayer rpgPlayer = this.plugin.getRPGPlayerMap().get(player);

        if(event.getItem() == null) {
            return;
        }

        if(event.getItem().getItemMeta() == null) {
            return;
        }

        if(event.getItem().getType() == null) {
            return;
        }

        if(event.getAction() == Action.RIGHT_CLICK_AIR | event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            if(event.getItem().getType() == Material.PAPER) {

                if(event.getItem().getItemMeta().isUnbreakable()) {

                    if(event.getItem().getItemMeta().hasItemFlag(ItemFlag.HIDE_ENCHANTS)) {

                        if(event.getItem().getItemMeta().hasEnchant(Enchantment.VANISHING_CURSE)) {

                            if(!event.getHand().equals(EquipmentSlot.HAND)) {
                                return;
                            }

                            if(event.getItem().getItemMeta().getLore().get(0) == null) {
                                return;
                            }

                            if(!event.getItem().getItemMeta().getDisplayName().equals("§b§lCoins §b§lCoupon")) {
                                return;
                            }

                            String lore = event.getItem().getItemMeta().getLore().get(0).trim();
                            lore = lore.replaceAll("§6", "")
                                    .replaceAll("§7", "")
                                    .replaceAll(" ", "")
                                    .replaceAll("Coins", "");

                            int coinsAmount = Integer.parseInt(lore);

                            event.setCancelled(true);

                            player.getInventory().setItemInMainHand(null);

                            rpgPlayer.grandRPGCoins(coinsAmount);

                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.25F);
                            player.sendMessage("§7§l(§a!§7§l)§r §7Used §acoin coupon §7with value §a" + coinsAmount + "$§7");

                        }

                    }

                }

            }

        }

    }

}
