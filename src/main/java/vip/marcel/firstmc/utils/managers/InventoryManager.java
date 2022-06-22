package vip.marcel.firstmc.utils.managers;

import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.enums.InventoryType;
import vip.marcel.firstmc.utils.enums.ShopItem;

import java.util.Map;

public class InventoryManager {

    private final RPGSword plugin;

    private final Map<InventoryType, Inventory> inventoryMap;

    public InventoryManager(RPGSword plugin) {
        this.plugin = plugin;
        this.inventoryMap = Maps.newConcurrentMap();

        this.initInventories();
    }

    private void initInventories() {

        /* SKILLS-MENU */
        {
            final Inventory inventory = Bukkit.createInventory(null, 54, "§a§lYour bought skills");

            for(int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.GRAY_STAINED_GLASS_PANE).setNoName().build());
            }

            for(int i = 45; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.RED_STAINED_GLASS_PANE).setNoName().build());
            }

            this.inventoryMap.put(InventoryType.SKILLS_MENU, inventory);
        }

        /* SHOP CONFIRM-BUY-MENU */
        {
            final Inventory inventory = Bukkit.createInventory(null, 27, "§a§lCoin Shop §8» §7Confirm?");

            for(int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.GRAY_STAINED_GLASS_PANE).setNoName().build());
            }

            for(int i = 18; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.RED_STAINED_GLASS_PANE).setNoName().build());
            }

            inventory.setItem(10, this.plugin.getApi().item(Material.GREEN_TERRACOTTA).setDisplayname("§a§lConfirm buy").build());
            inventory.setItem(16, this.plugin.getApi().item(Material.RED_TERRACOTTA).setDisplayname("§c§lCancel buy").build());

            this.inventoryMap.put(InventoryType.SHOP_CONFIRM_BUY, inventory);
        }

        /* SHOP START-MENU */
        {
            final Inventory inventory = Bukkit.createInventory(null, 54, "§a§lCoin Shop");

            for(int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.GRAY_STAINED_GLASS_PANE).setNoName().build());
            }

            for(int i = 45; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.RED_STAINED_GLASS_PANE).setNoName().build());
            }

            inventory.setItem(13, this.plugin.getApi().item(Material.TRIPWIRE_HOOK).setDisplayname("§f§lCrates").build());
            inventory.setItem(19, this.plugin.getApi().item(Material.DIAMOND_PICKAXE).setDisplayname("§d§lOP Tools").build());
            inventory.setItem(25, this.plugin.getApi().item(Material.BEACON).setDisplayname("§5§lRanks").build());
            inventory.setItem(31, this.plugin.getApi().item(Material.BLAZE_POWDER).setDisplayname("§c§lSkills").build());

            this.inventoryMap.put(InventoryType.SHOP_MENU, inventory);
        }

        /* SHOP SKILLS-MENU */
        {
            final Inventory inventory = Bukkit.createInventory(null, 54, "§a§lCoin Shop§r §8» §7Skills");

            for(int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.GRAY_STAINED_GLASS_PANE).setNoName().build());
            }

            for(int i = 45; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.RED_STAINED_GLASS_PANE).setNoName().build());
            }

            this.inventoryMap.put(InventoryType.SHOP_SKILLS, inventory);
        }

        /* SHOP CRATES-MENU */
        {
            final Inventory inventory = Bukkit.createInventory(null, 54, "§a§lCoin Shop§r §8» §7Crates");

            for(int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.GRAY_STAINED_GLASS_PANE).setNoName().build());
            }

            for(int i = 45; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.RED_STAINED_GLASS_PANE).setNoName().build());
            }

            inventory.setItem(19, this.plugin.getApi().item(Material.TRIPWIRE_HOOK)
                    .setDisplayname("§f§l" + ShopItem.CRATES_COMMON.getName() + "§r §7Key (§6" + ShopItem.CRATES_COMMON.getStringPrice() + " §7Coins)")
                    .build());

            inventory.setItem(30, this.plugin.getApi().item(Material.TRIPWIRE_HOOK)
                    .setDisplayname("§b§l" + ShopItem.CRATES_UNCOMMON.getName() + "§r §7Key (§6" + ShopItem.CRATES_UNCOMMON.getStringPrice() + " §7Coins)")
                    .build());

            inventory.setItem(32, this.plugin.getApi().item(Material.TRIPWIRE_HOOK)
                    .setDisplayname("§c§l" + ShopItem.CRATES_RARE.getName() + "§r §7Key (§6" + ShopItem.CRATES_RARE.getStringPrice() + " §7Coins)")
                    .build());

            inventory.setItem(25, this.plugin.getApi().item(Material.TRIPWIRE_HOOK)
                    .setDisplayname("§6§l" + ShopItem.CRATES_LEGENDARY.getName() + "§r §7Key (§6" + ShopItem.CRATES_LEGENDARY.getStringPrice() + " §7Coins)")
                    .build());

            this.inventoryMap.put(InventoryType.SHOP_CRATES, inventory);
        }

        /* SHOP RANKS-MENU */
        {
            final Inventory inventory = Bukkit.createInventory(null, 54, "§a§lCoin Shop§r §8» §7Ranks");

            for(int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.GRAY_STAINED_GLASS_PANE).setNoName().build());
            }

            for(int i = 45; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.RED_STAINED_GLASS_PANE).setNoName().build());
            }

            this.inventoryMap.put(InventoryType.SHOP_RANKS, inventory);
        }

        /* SHOP TOOLS-MENU */
        {
            final Inventory inventory = Bukkit.createInventory(null, 54, "§a§lCoin Shop§r §8» §7Tools");

            for(int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.GRAY_STAINED_GLASS_PANE).setNoName().build());
            }

            for(int i = 45; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.plugin.getApi().item(Material.RED_STAINED_GLASS_PANE).setNoName().build());
            }

            inventory.setItem(10, this.plugin.getApi().item(Material.DIAMOND_HELMET)
                    .setDisplayname("§c§l" + ShopItem.ITEMS_OPHELM.getName() + "§r §7(§6" + ShopItem.ITEMS_OPHELM.getStringPrice() + " §7Coins)")
                            .addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8)
                            .addEnchantment(Enchantment.THORNS, 5)
                            .addEnchantment(Enchantment.DURABILITY, 5)
                    .build());

            inventory.setItem(12, this.plugin.getApi().item(Material.DIAMOND_CHESTPLATE)
                    .setDisplayname("§c§l" + ShopItem.ITEMS_OPCHESTPLATE.getName() + "§r §7(§6" + ShopItem.ITEMS_OPCHESTPLATE.getStringPrice() + " §7Coins)")
                    .addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8)
                    .addEnchantment(Enchantment.THORNS, 5)
                    .addEnchantment(Enchantment.DURABILITY, 5)
                    .build());

            inventory.setItem(14, this.plugin.getApi().item(Material.DIAMOND_LEGGINGS)
                    .setDisplayname("§c§l" + ShopItem.ITEMS_OPLEGGINGS.getName() + "§r §7(§6" + ShopItem.ITEMS_OPLEGGINGS.getStringPrice() + " §7Coins)")
                    .addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8)
                    .addEnchantment(Enchantment.THORNS, 5)
                    .addEnchantment(Enchantment.DURABILITY, 5)
                    .build());

            inventory.setItem(16, this.plugin.getApi().item(Material.DIAMOND_BOOTS)
                    .setDisplayname("§c§l" + ShopItem.ITEMS_OPBOOTS.getName() + "§r §7(§6" + ShopItem.ITEMS_OPBOOTS.getStringPrice() + " §7Coins)")
                    .addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8)
                    .addEnchantment(Enchantment.THORNS, 5)
                    .addEnchantment(Enchantment.DURABILITY, 5)
                    .build());

            inventory.setItem(19, this.plugin.getApi().item(Material.DIAMOND_PICKAXE)
                    .setDisplayname("§c§l" + ShopItem.ITEMS_OPPICKAXE.getName() + "§r §7(§6" + ShopItem.ITEMS_OPPICKAXE.getStringPrice() + " §7Coins)")
                    .addEnchantment(Enchantment.DIG_SPEED, 8)
                    .addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 4)
                    .addEnchantment(Enchantment.DURABILITY, 5)
                    .build());

            inventory.setItem(30, this.plugin.getApi().item(Material.DIAMOND_AXE)
                    .setDisplayname("§c§l" + ShopItem.ITEMS_OPAXE.getName() + "§r §7(§6" + ShopItem.ITEMS_OPAXE.getStringPrice() + " §7Coins)")
                    .addEnchantment(Enchantment.DIG_SPEED, 8)
                    .addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 4)
                    .addEnchantment(Enchantment.DURABILITY, 5)
                    .build());

            inventory.setItem(32, this.plugin.getApi().item(Material.DIAMOND_SHOVEL)
                    .setDisplayname("§c§l" + ShopItem.ITEMS_OPSHOVEL.getName() + "§r §7(§6" + ShopItem.ITEMS_OPSHOVEL.getStringPrice() + " §7Coins)")
                    .addEnchantment(Enchantment.DIG_SPEED, 8)
                    .addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 4)
                    .addEnchantment(Enchantment.DURABILITY, 5)
                    .build());

            inventory.setItem(25, this.plugin.getApi().item(Material.DIAMOND_SWORD)
                    .setDisplayname("§c§l" + ShopItem.ITEMS_OPSWORD.getName() + "§r §7(§6" + ShopItem.ITEMS_OPSWORD.getStringPrice() + " §7Coins)")
                    .addEnchantment(Enchantment.DAMAGE_ALL, 8)
                    .addEnchantment(Enchantment.LOOT_BONUS_MOBS, 4)
                    .addEnchantment(Enchantment.DURABILITY, 5)
                    .build());

            this.inventoryMap.put(InventoryType.SHOP_TOOLS, inventory);
        }

    }

    public Inventory getInventory(InventoryType inventoryType, Player player) {
        final Inventory inventory = this.inventoryMap.get(inventoryType);
        final ShopManager shopManager = this.plugin.getShopManager(player);

        switch(inventoryType) {

            case SHOP_MENU:
                return inventory;

            case SHOP_SKILLS:

                if(shopManager.hasBought(ShopItem.SKILLS_STRENGHT1)) {
                    inventory.setItem(10, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 0), true)
                            .setBasePotionData(PotionType.STRENGTH)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT1.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_STRENGHT1.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT1.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(10, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 0), true)
                            .setBasePotionData(PotionType.STRENGTH)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT1.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_STRENGHT1.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT1.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                if(shopManager.hasBought(ShopItem.SKILLS_STRENGHT2)) {
                    inventory.setItem(11, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 1), true)
                            .setBasePotionData(PotionType.STRENGTH)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT2.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_STRENGHT2.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT2.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(11, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 1), true)
                            .setBasePotionData(PotionType.STRENGTH)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT2.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_STRENGHT2.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT2.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                if(shopManager.hasBought(ShopItem.SKILLS_SPEED1)) {
                    inventory.setItem(15, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 0), true)
                            .setBasePotionData(PotionType.SPEED)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED1.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_SPEED1.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED1.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(15, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 0), true)
                            .setBasePotionData(PotionType.SPEED)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED1.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_SPEED1.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED1.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                if(shopManager.hasBought(ShopItem.SKILLS_SPEED2)) {
                    inventory.setItem(16, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 1), true)
                            .setBasePotionData(PotionType.SPEED)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED2.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_SPEED2.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED2.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(16, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 1), true)
                            .setBasePotionData(PotionType.SPEED)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED2.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_SPEED2.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED2.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                if(shopManager.hasBought(ShopItem.SKILLS_NIGHTVISION)) {
                    inventory.setItem(22, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 0, 0), true)
                            .setBasePotionData(PotionType.NIGHT_VISION)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_NIGHTVISION.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_NIGHTVISION.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_NIGHTVISION.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(22, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 0, 0), true)
                            .setBasePotionData(PotionType.NIGHT_VISION)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_NIGHTVISION.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_NIGHTVISION.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_NIGHTVISION.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                if(shopManager.hasBought(ShopItem.SKILLS_JUMPBOOST1)) {
                    inventory.setItem(28, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 0), true)
                            .setBasePotionData(PotionType.JUMP)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST1.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_JUMPBOOST1.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST1.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(28, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 0), true)
                            .setBasePotionData(PotionType.JUMP)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST1.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_JUMPBOOST1.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST1.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                if(shopManager.hasBought(ShopItem.SKILLS_JUMPBOOST2)) {
                    inventory.setItem(29, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 1), true)
                            .setBasePotionData(PotionType.JUMP)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST2.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_JUMPBOOST2.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST2.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(29, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 1), true)
                            .setBasePotionData(PotionType.JUMP)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST2.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_JUMPBOOST2.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST2.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                if(shopManager.hasBought(ShopItem.SKILLS_REGENERATION1)) {
                    inventory.setItem(33, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 0), true)
                            .setBasePotionData(PotionType.REGEN)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION1.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_REGENERATION1.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION1.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(33, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 0), true)
                            .setBasePotionData(PotionType.REGEN)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION1.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_REGENERATION1.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION1.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                if(shopManager.hasBought(ShopItem.SKILLS_REGENERATION2)) {
                    inventory.setItem(34, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 1), true)
                            .setBasePotionData(PotionType.REGEN)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION2.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_REGENERATION2.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION2.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(34, this.plugin.getApi().item(Material.POTION)
                            //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 1), true)
                            .setBasePotionData(PotionType.REGEN)
                            .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION2.getName() + " §7§lSkill§r §7(§6" + ShopItem.SKILLS_REGENERATION2.getStringPrice() + " §7Coins)")
                            .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION2.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                return inventory;

            case SHOP_CRATES:
                return inventory;

            case SHOP_RANKS:

                if(shopManager.hasBought(ShopItem.RANKS_COAL) |
                        shopManager.hasBought(ShopItem.RANKS_GOLD) |
                        shopManager.hasBought(ShopItem.RANKS_EMERALD) |
                        shopManager.hasBought(ShopItem.RANKS_DIAMOND)) {
                    inventory.setItem(19, this.plugin.getApi().item(Material.PAPER)
                            .setDisplayname("§8§l" + ShopItem.RANKS_COAL.getName() + " §7§lRank§r §7(§6" + ShopItem.RANKS_COAL.getStringPrice() + " §7Coins)")
                            .setLore("§7You get the rank §8§l" + ShopItem.RANKS_COAL.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(19, this.plugin.getApi().item(Material.PAPER)
                            .setDisplayname("§8§l" + ShopItem.RANKS_COAL.getName() + " §7§lRank§r §7(§6" + ShopItem.RANKS_COAL.getStringPrice() + " §7Coins)")
                            .setLore("§7You get the rank §8§l" + ShopItem.RANKS_COAL.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                if(shopManager.hasBought(ShopItem.RANKS_GOLD) |
                        shopManager.hasBought(ShopItem.RANKS_EMERALD) |
                        shopManager.hasBought(ShopItem.RANKS_DIAMOND)) {
                    inventory.setItem(30, this.plugin.getApi().item(Material.PAPER)
                            .setDisplayname("§6§l" + ShopItem.RANKS_GOLD.getName() + " §7§lRank§r §7(§6" + ShopItem.RANKS_GOLD.getStringPrice() + " §7Coins)")
                            .setLore("§7You get the rank §6§l" + ShopItem.RANKS_GOLD.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(30, this.plugin.getApi().item(Material.PAPER)
                            .setDisplayname("§6§l" + ShopItem.RANKS_GOLD.getName() + " §7§lRank§r §7(§6" + ShopItem.RANKS_GOLD.getStringPrice() + " §7Coins)")
                            .setLore("§7You get the rank §6§l" + ShopItem.RANKS_GOLD.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                if(shopManager.hasBought(ShopItem.RANKS_EMERALD) |
                        shopManager.hasBought(ShopItem.RANKS_DIAMOND)) {
                    inventory.setItem(32, this.plugin.getApi().item(Material.PAPER)
                            .setDisplayname("§a§l" + ShopItem.RANKS_EMERALD.getName() + " §7§lRank§r §7(§6" + ShopItem.RANKS_EMERALD.getStringPrice() + " §7Coins)")
                            .setLore("§7You get the rank §a§l" + ShopItem.RANKS_EMERALD.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(32, this.plugin.getApi().item(Material.PAPER)
                            .setDisplayname("§a§l" + ShopItem.RANKS_EMERALD.getName() + " §7§lRank§r §7(§6" + ShopItem.RANKS_EMERALD.getStringPrice() + " §7Coins)")
                            .setLore("§7You get the rank §a§l" + ShopItem.RANKS_EMERALD.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                if(shopManager.hasBought(ShopItem.RANKS_DIAMOND)) {
                    inventory.setItem(25, this.plugin.getApi().item(Material.PAPER)
                            .setDisplayname("§b§l" + ShopItem.RANKS_DIAMOND.getName() + " §7§lRank§r §7(§6" + ShopItem.RANKS_DIAMOND.getStringPrice() + " §7Coins)")
                            .setLore("§7You get the rank §b§l" + ShopItem.RANKS_DIAMOND.getName() + "§7.",
                                    "",
                                    "§a§lAlready purchased")
                            .build());
                } else {
                    inventory.setItem(25, this.plugin.getApi().item(Material.PAPER)
                            .setDisplayname("§b§l" + ShopItem.RANKS_DIAMOND.getName() + " §7§lRank§r §7(§6" + ShopItem.RANKS_DIAMOND.getStringPrice() + " §7Coins)")
                            .setLore("§7You get the rank §b§l" + ShopItem.RANKS_DIAMOND.getName() + "§7.",
                                    "",
                                    "§c§lNot purchased yet")
                            .build());
                }

                return inventory;

            case SHOP_TOOLS:
                return inventory;

            case SKILLS_MENU:
                final SkillsManager skillsManager = this.plugin.getSkillsManager(player);

                if(shopManager.hasBought(ShopItem.SKILLS_STRENGHT1)) {
                    if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_STRENGHT1)) {
                        inventory.setItem(10, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 0), true)
                                .setBasePotionData(PotionType.STRENGTH)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT1.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT1.getName() + "§7.",
                                        "",
                                        "§a§lActivated")
                                .build());
                    } else {
                        inventory.setItem(10, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 0), true)
                                .setBasePotionData(PotionType.STRENGTH)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT1.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT1.getName() + "§7.",
                                        "",
                                        "§c§lNot active")
                                .build());
                    }

                }

                if(shopManager.hasBought(ShopItem.SKILLS_STRENGHT2)) {
                    if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_STRENGHT2)) {
                        inventory.setItem(11, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 1), true)
                                .setBasePotionData(PotionType.STRENGTH)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT2.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT2.getName() + "§7.",
                                        "",
                                        "§a§lActivated")
                                .build());
                    } else {
                        inventory.setItem(11, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 1), true)
                                .setBasePotionData(PotionType.STRENGTH)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT2.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT2.getName() + "§7.",
                                        "",
                                        "§c§lNot active")
                                .build());
                    }

                }

                if(shopManager.hasBought(ShopItem.SKILLS_SPEED1)) {
                    if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_SPEED1)) {
                        inventory.setItem(15, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 0), true)
                                .setBasePotionData(PotionType.SPEED)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED1.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED1.getName() + "§7.",
                                        "",
                                        "§a§lActivated")
                                .build());
                    } else {
                        inventory.setItem(15, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 0), true)
                                .setBasePotionData(PotionType.SPEED)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED1.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED1.getName() + "§7.",
                                        "",
                                        "§c§lNot active")
                                .build());
                    }

                }

                if(shopManager.hasBought(ShopItem.SKILLS_SPEED2)) {
                    if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_SPEED2)) {
                        inventory.setItem(16, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 1), true)
                                .setBasePotionData(PotionType.SPEED)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED2.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED2.getName() + "§7.",
                                        "",
                                        "§a§lActivated")
                                .build());
                    } else {
                        inventory.setItem(16, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 1), true)
                                .setBasePotionData(PotionType.SPEED)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED2.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED2.getName() + "§7.",
                                        "",
                                        "§c§lNot active")
                                .build());
                    }

                }

                if(shopManager.hasBought(ShopItem.SKILLS_NIGHTVISION)) {
                    if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_NIGHTVISION)) {
                        inventory.setItem(22, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 0, 0), true)
                                .setBasePotionData(PotionType.NIGHT_VISION)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_NIGHTVISION.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_NIGHTVISION.getName() + "§7.",
                                        "",
                                        "§a§lActivated")
                                .build());
                    } else {
                        inventory.setItem(22, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 0, 0), true)
                                .setBasePotionData(PotionType.NIGHT_VISION)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_NIGHTVISION.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_NIGHTVISION.getName() + "§7.",
                                        "",
                                        "§c§lNot active")
                                .build());
                    }

                }

                if(shopManager.hasBought(ShopItem.SKILLS_JUMPBOOST1)) {
                    if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_JUMPBOOST1)) {
                        inventory.setItem(28, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 0), true)
                                .setBasePotionData(PotionType.JUMP)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST1.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST1.getName() + "§7.",
                                        "",
                                        "§a§lActivated")
                                .build());
                    } else {
                        inventory.setItem(28, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 0), true)
                                .setBasePotionData(PotionType.JUMP)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST1.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST1.getName() + "§7.",
                                        "",
                                        "§c§lNot active")
                                .build());
                    }

                }

                if(shopManager.hasBought(ShopItem.SKILLS_JUMPBOOST2)) {
                    if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_JUMPBOOST2)) {
                        inventory.setItem(29, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 1), true)
                                .setBasePotionData(PotionType.JUMP)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST2.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST2.getName() + "§7.",
                                        "",
                                        "§a§lActivated")
                                .build());
                    } else {
                        inventory.setItem(29, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 1), true)
                                .setBasePotionData(PotionType.JUMP)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST2.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST2.getName() + "§7.",
                                        "",
                                        "§c§lNot active")
                                .build());
                    }

                }

                if(shopManager.hasBought(ShopItem.SKILLS_REGENERATION1)) {
                    if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_REGENERATION1)) {
                        inventory.setItem(33, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 0), true)
                                .setBasePotionData(PotionType.REGEN)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION1.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION1.getName() + "§7.",
                                        "",
                                        "§a§lActivated")
                                .build());
                    } else {
                        inventory.setItem(33, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 0), true)
                                .setBasePotionData(PotionType.REGEN)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION1.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION1.getName() + "§7.",
                                        "",
                                        "§c§lNot active")
                                .build());
                    }

                }

                if(shopManager.hasBought(ShopItem.SKILLS_REGENERATION2)) {
                    if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_REGENERATION2)) {
                        inventory.setItem(34, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 1), true)
                                .setBasePotionData(PotionType.REGEN)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION2.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION2.getName() + "§7.",
                                        "",
                                        "§a§lActivated")
                                .build());
                    } else {
                        inventory.setItem(34, this.plugin.getApi().item(Material.POTION)
                                //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 1), true)
                                .setBasePotionData(PotionType.REGEN)
                                .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION2.getName() + " §7§lSkill")
                                .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION2.getName() + "§7.",
                                        "",
                                        "§c§lNot active")
                                .build());
                    }

                }

                return inventory;

            default:
                break;

        }

        return null;
    }

    public void openConfirmBuyInventory(Player player, ItemStack itemStack, ShopItem shopItem) {
        final Inventory inventory = this.inventoryMap.get(InventoryType.SHOP_CONFIRM_BUY);

        inventory.setItem(13, itemStack);

        this.plugin.getShopConfirmItem().put(player, shopItem);
        player.openInventory(inventory);
    }

}
