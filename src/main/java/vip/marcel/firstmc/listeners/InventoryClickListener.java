package vip.marcel.firstmc.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionType;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.enums.InventoryType;
import vip.marcel.firstmc.utils.enums.ShopItem;
import vip.marcel.firstmc.utils.managers.ShopManager;
import vip.marcel.firstmc.utils.managers.SkillsManager;

public record InventoryClickListener(RPGSword plugin) implements Listener {

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {

        if(event.getWhoClicked() instanceof Player player) {

            if(event.getInventory() == null) {
                event.setCancelled(true);
                return;
            }

            if(event.getCurrentItem() == null) {
                event.setCancelled(true);
                return;
            }

            /* SHOP START-MENU */
            if(event.getView().getTitle().equalsIgnoreCase("§a§lCoin Shop")) {

                event.setCancelled(true);

                if(event.getCurrentItem().getType().equals(Material.TRIPWIRE_HOOK)) {
                    player.openInventory(this.plugin.getInventoryManager().getInventory(InventoryType.SHOP_CRATES, player));
                    player.playSound(player.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 0.5F, 0.5F);
                }

                if(event.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
                    player.openInventory(this.plugin.getInventoryManager().getInventory(InventoryType.SHOP_TOOLS, player));
                    player.playSound(player.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 0.5F, 0.5F);
                }

                if(event.getCurrentItem().getType().equals(Material.BEACON)) {
                    player.openInventory(this.plugin.getInventoryManager().getInventory(InventoryType.SHOP_RANKS, player));
                    player.playSound(player.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 0.5F, 0.5F);
                }

                if(event.getCurrentItem().getType().equals(Material.BLAZE_POWDER)) {
                    player.openInventory(this.plugin.getInventoryManager().getInventory(InventoryType.SHOP_SKILLS, player));
                    player.playSound(player.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 0.5F, 0.5F);
                }

            }

            /* SHOP SKILLS-MENU */
            if(event.getView().getTitle().equalsIgnoreCase("§a§lCoin Shop§r §8» §7Skills")) {
                final ShopManager shopManager = this.plugin.getShopManager(player);

                event.setCancelled(true);

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.SKILLS_STRENGHT1.getName())) {
                    if(!shopManager.hasBought(ShopItem.SKILLS_STRENGHT1)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.SKILLS_STRENGHT1);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.SKILLS_STRENGHT2.getName())) {
                    if(!shopManager.hasBought(ShopItem.SKILLS_STRENGHT2)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.SKILLS_STRENGHT2);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.SKILLS_SPEED1.getName())) {
                    if(!shopManager.hasBought(ShopItem.SKILLS_SPEED1)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.SKILLS_SPEED1);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.SKILLS_SPEED2.getName())) {
                    if(!shopManager.hasBought(ShopItem.SKILLS_SPEED2)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.SKILLS_SPEED2);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.SKILLS_NIGHTVISION.getName())) {
                    if(!shopManager.hasBought(ShopItem.SKILLS_NIGHTVISION)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.SKILLS_NIGHTVISION);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.SKILLS_JUMPBOOST1.getName())) {
                    if(!shopManager.hasBought(ShopItem.SKILLS_JUMPBOOST1)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.SKILLS_JUMPBOOST1);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.SKILLS_JUMPBOOST2.getName())) {
                    if(!shopManager.hasBought(ShopItem.SKILLS_JUMPBOOST2)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.SKILLS_JUMPBOOST2);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.SKILLS_REGENERATION1.getName())) {
                    if(!shopManager.hasBought(ShopItem.SKILLS_REGENERATION1)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.SKILLS_REGENERATION1);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.SKILLS_REGENERATION2.getName())) {
                    if(!shopManager.hasBought(ShopItem.SKILLS_REGENERATION2)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.SKILLS_REGENERATION2);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

            }

            /* SHOP CRATES-MENU */
            if(event.getView().getTitle().equalsIgnoreCase("§a§lCoin Shop§r §8» §7Crates")) {

                event.setCancelled(true);

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.CRATES_COMMON.getName())) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.CRATES_COMMON);
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.CRATES_UNCOMMON.getName())) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.CRATES_UNCOMMON);
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.CRATES_RARE.getName())) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.CRATES_RARE);
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.CRATES_LEGENDARY.getName())) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.CRATES_LEGENDARY);
                }

            }

            /* SHOP RANKS-MENU */
            if(event.getView().getTitle().equalsIgnoreCase("§a§lCoin Shop§r §8» §7Ranks")) {
                final ShopManager shopManager = this.plugin.getShopManager(player);

                event.setCancelled(true);

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.RANKS_COAL.getName())) {
                    if(!shopManager.hasBought(ShopItem.RANKS_COAL) &&
                            !shopManager.hasBought(ShopItem.RANKS_GOLD) &&
                            !shopManager.hasBought(ShopItem.RANKS_EMERALD) &&
                            !shopManager.hasBought(ShopItem.RANKS_DIAMOND)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.RANKS_COAL);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.RANKS_GOLD.getName())) {
                    if(!shopManager.hasBought(ShopItem.RANKS_GOLD) &&
                            !shopManager.hasBought(ShopItem.RANKS_EMERALD) &&
                            !shopManager.hasBought(ShopItem.RANKS_DIAMOND)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.RANKS_GOLD);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.RANKS_EMERALD.getName())) {
                    if(!shopManager.hasBought(ShopItem.RANKS_EMERALD) &&
                            !shopManager.hasBought(ShopItem.RANKS_DIAMOND)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.RANKS_EMERALD);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ShopItem.RANKS_DIAMOND.getName())) {
                    if(!shopManager.hasBought(ShopItem.RANKS_DIAMOND)) {
                        this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.RANKS_DIAMOND);
                    } else {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5F, 0.5F);
                    }
                }

            }

            /* SHOP TOOLS-MENU */
            if(event.getView().getTitle().equalsIgnoreCase("§a§lCoin Shop§r §8» §7Tools")) {
                final ShopManager shopManager = this.plugin.getShopManager(player);

                event.setCancelled(true);

                if(event.getCurrentItem().getType().equals(Material.DIAMOND_HELMET)) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.ITEMS_OPHELM);
                }

                if(event.getCurrentItem().getType().equals(Material.DIAMOND_CHESTPLATE)) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.ITEMS_OPCHESTPLATE);
                }

                if(event.getCurrentItem().getType().equals(Material.DIAMOND_LEGGINGS)) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.ITEMS_OPLEGGINGS);
                }

                if(event.getCurrentItem().getType().equals(Material.DIAMOND_BOOTS)) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.ITEMS_OPBOOTS);
                }

                if(event.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.ITEMS_OPPICKAXE);
                }

                if(event.getCurrentItem().getType().equals(Material.DIAMOND_AXE)) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.ITEMS_OPAXE);
                }

                if(event.getCurrentItem().getType().equals(Material.DIAMOND_SHOVEL)) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.ITEMS_OPSHOVEL);
                }

                if(event.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {
                    this.plugin.getInventoryManager().openConfirmBuyInventory(player, event.getCurrentItem(), ShopItem.ITEMS_OPSWORD);
                }

            }

            /* SHOP BUY-CONFIRM-MENU */
            if(event.getView().getTitle().equalsIgnoreCase("§a§lCoin Shop §8» §7Confirm?")) {
                final ShopManager shopManager = this.plugin.getShopManager(player);

                event.setCancelled(true);

                if(event.getCurrentItem().getType().equals(Material.GREEN_TERRACOTTA)) {
                    final ShopItem shopItem = this.plugin.getShopConfirmItem().get(player);


                    /* Filters Rank from RANKS-MENU */
                    if(shopItem.getName().equalsIgnoreCase("Coal")) {

                        if(shopManager.grandItem(shopItem)) {
                            player.sendTitle("§aSuccessfully bought", "§8§l" + shopItem.getName());
                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.5F);
                        }

                    } else if(shopItem.getName().equalsIgnoreCase("Gold")) {

                        if(shopManager.grandItem(shopItem)) {
                            player.sendTitle("§aSuccessfully bought", "§6§l" + shopItem.getName());
                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.5F);
                        }

                    } else if(shopItem.getName().equalsIgnoreCase("Emerald")) {

                        if(shopManager.grandItem(shopItem)) {
                            player.sendTitle("§aSuccessfully bought", "§a§l" + shopItem.getName());
                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.5F);
                        }

                    } else if(shopItem.getName().equalsIgnoreCase("Diamond")) {

                        if(shopManager.grandItem(shopItem)) {
                            player.sendTitle("§aSuccessfully bought", "§b§l" + shopItem.getName());
                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.5F);
                        }

                    }

                    /* Filters CRATES-Keys from CRATES-MENU */
                    else if(shopItem.getName().startsWith("Common") |
                            shopItem.getName().startsWith("Uncommon") |
                            shopItem.getName().startsWith("Rare") |
                            shopItem.getName().startsWith("Legendary")) {

                        if(shopManager.grandItem(shopItem)) {
                            player.sendTitle("§aSuccessfully bought", "§7" + shopItem.getName() + " Key");
                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.5F);
                        }

                    }

                    /* Filters OP-ITEM from TOOLS-MENU */
                    else if(shopItem.getName().startsWith("OP")) {

                        if(shopManager.grandItem(shopItem)) {

                            ItemStack item = event.getInventory().getItem(13);
                            ItemMeta itemMeta = item.getItemMeta();
                            itemMeta.setDisplayName("§c§l" + itemMeta.getDisplayName().split(" ")[0] + " " + itemMeta.getDisplayName().split(" ")[1]);
                            item.setItemMeta(itemMeta);

                            player.getInventory().addItem(item);
                            player.sendTitle("§aSuccessfully bought", "§7" + shopItem.getName());
                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.5F);
                        }

                    } else {

                        if(shopManager.grandItem(shopItem)) {
                            player.closeInventory();
                            player.sendTitle("§aSuccessfully bought", "§7" + shopItem.getName());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 0.5F);
                        }

                    }

                }

                if(event.getCurrentItem().getType().equals(Material.RED_TERRACOTTA)) {
                    player.sendTitle("§7Buy", "§ccancelled");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 0.5F, 0.5F);
                    player.closeInventory();
                }

            }

            /* SKILLS-MENU */
            if(event.getView().getTitle().equalsIgnoreCase("§a§lYour bought skills")) {
                final SkillsManager skillsManager = this.plugin.getSkillsManager(player);
                final ShopManager shopManager = this.plugin.getShopManager(player);

                event.setCancelled(true);

                if(event.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase("§c§l" + ShopItem.SKILLS_STRENGHT1.getName() + " §7§lSkill")) {

                    if(shopManager.hasBought(ShopItem.SKILLS_STRENGHT1)) {
                        if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_STRENGHT1)) {
                            skillsManager.disableSkill(ShopItem.SKILLS_STRENGHT1);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 0), true)
                                    .setBasePotionData(PotionType.STRENGTH)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT1.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT1.getName() + "§7.",
                                            "",
                                            "§c§lNot active")
                                    .build());
                        } else {
                            skillsManager.enableSkill(ShopItem.SKILLS_STRENGHT1);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 0), true)
                                    .setBasePotionData(PotionType.STRENGTH)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT1.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT1.getName() + "§7.",
                                            "",
                                            "§a§lActivated")
                                    .build());
                        }
                    }

                }

                if(event.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase("§c§l" + ShopItem.SKILLS_STRENGHT2.getName() + " §7§lSkill")) {

                    if(shopManager.hasBought(ShopItem.SKILLS_STRENGHT2)) {
                        if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_STRENGHT2)) {
                            skillsManager.disableSkill(ShopItem.SKILLS_STRENGHT2);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 1), true)
                                    .setBasePotionData(PotionType.STRENGTH)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT2.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT2.getName() + "§7.",
                                            "",
                                            "§c§lNot active")
                                    .build());
                        } else {
                            skillsManager.enableSkill(ShopItem.SKILLS_STRENGHT2);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 1), true)
                                    .setBasePotionData(PotionType.STRENGTH)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_STRENGHT2.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_STRENGHT2.getName() + "§7.",
                                            "",
                                            "§a§lActivated")
                                    .build());
                        }
                    }

                }

                if(event.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase("§c§l" + ShopItem.SKILLS_SPEED1.getName() + " §7§lSkill")) {

                    if(shopManager.hasBought(ShopItem.SKILLS_SPEED1)) {
                        if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_SPEED1)) {
                            skillsManager.disableSkill(ShopItem.SKILLS_SPEED1);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 0), true)
                                    .setBasePotionData(PotionType.SPEED)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED1.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED1.getName() + "§7.",
                                            "",
                                            "§c§lNot active")
                                    .build());
                        } else {
                            skillsManager.enableSkill(ShopItem.SKILLS_SPEED1);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 0), true)
                                    .setBasePotionData(PotionType.SPEED)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED1.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED1.getName() + "§7.",
                                            "",
                                            "§a§lActivated")
                                    .build());
                        }
                    }

                }

                if(event.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase("§c§l" + ShopItem.SKILLS_SPEED2.getName() + " §7§lSkill")) {

                    if(shopManager.hasBought(ShopItem.SKILLS_SPEED2)) {
                        if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_SPEED2)) {
                            skillsManager.disableSkill(ShopItem.SKILLS_SPEED2);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 1), true)
                                    .setBasePotionData(PotionType.SPEED)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED2.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED2.getName() + "§7.",
                                            "",
                                            "§c§lNot active")
                                    .build());
                        } else {
                            skillsManager.enableSkill(ShopItem.SKILLS_SPEED2);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.SPEED, 0, 1), true)
                                    .setBasePotionData(PotionType.SPEED)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_SPEED2.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_SPEED2.getName() + "§7.",
                                            "",
                                            "§a§lActivated")
                                    .build());
                        }
                    }

                }

                if(event.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase("§c§l" + ShopItem.SKILLS_NIGHTVISION.getName() + " §7§lSkill")) {

                    if(shopManager.hasBought(ShopItem.SKILLS_NIGHTVISION)) {
                        if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_NIGHTVISION)) {
                            skillsManager.disableSkill(ShopItem.SKILLS_NIGHTVISION);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 0, 0), true)
                                    .setBasePotionData(PotionType.NIGHT_VISION)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_NIGHTVISION.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_NIGHTVISION.getName() + "§7.",
                                            "",
                                            "§c§lNot active")
                                    .build());
                        } else {
                            skillsManager.enableSkill(ShopItem.SKILLS_NIGHTVISION);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 0, 0), true)
                                    .setBasePotionData(PotionType.NIGHT_VISION)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_NIGHTVISION.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_NIGHTVISION.getName() + "§7.",
                                            "",
                                            "§a§lActivated")
                                    .build());
                        }
                    }

                }

                if(event.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase("§c§l" + ShopItem.SKILLS_JUMPBOOST1.getName() + " §7§lSkill")) {

                    if(shopManager.hasBought(ShopItem.SKILLS_JUMPBOOST1)) {
                        if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_JUMPBOOST1)) {
                            skillsManager.disableSkill(ShopItem.SKILLS_JUMPBOOST1);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 0), true)
                                    .setBasePotionData(PotionType.JUMP)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST1.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST1.getName() + "§7.",
                                            "",
                                            "§c§lNot active")
                                    .build());
                        } else {
                            skillsManager.enableSkill(ShopItem.SKILLS_JUMPBOOST1);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 0), true)
                                    .setBasePotionData(PotionType.JUMP)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST1.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST1.getName() + "§7.",
                                            "",
                                            "§a§lActivated")
                                    .build());
                        }
                    }

                }

                if(event.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase("§c§l" + ShopItem.SKILLS_JUMPBOOST2.getName() + " §7§lSkill")) {

                    if(shopManager.hasBought(ShopItem.SKILLS_JUMPBOOST2)) {
                        if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_JUMPBOOST2)) {
                            skillsManager.disableSkill(ShopItem.SKILLS_JUMPBOOST2);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 1), true)
                                    .setBasePotionData(PotionType.JUMP)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST2.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST2.getName() + "§7.",
                                            "",
                                            "§c§lNot active")
                                    .build());
                        } else {
                            skillsManager.enableSkill(ShopItem.SKILLS_JUMPBOOST2);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.JUMP, 0, 1), true)
                                    .setBasePotionData(PotionType.JUMP)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_JUMPBOOST2.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_JUMPBOOST2.getName() + "§7.",
                                            "",
                                            "§a§lActivated")
                                    .build());
                        }
                    }

                }

                if(event.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase("§c§l" + ShopItem.SKILLS_REGENERATION1.getName() + " §7§lSkill")) {

                    if(shopManager.hasBought(ShopItem.SKILLS_REGENERATION1)) {
                        if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_REGENERATION1)) {
                            skillsManager.disableSkill(ShopItem.SKILLS_REGENERATION1);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 0), true)
                                    .setBasePotionData(PotionType.REGEN)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION1.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION1.getName() + "§7.",
                                            "",
                                            "§c§lNot active")
                                    .build());
                        } else {
                            skillsManager.enableSkill(ShopItem.SKILLS_REGENERATION1);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 0), true)
                                    .setBasePotionData(PotionType.REGEN)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION1.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION1.getName() + "§7.",
                                            "",
                                            "§a§lActivated")
                                    .build());
                        }
                    }

                }

                if(event.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase("§c§l" + ShopItem.SKILLS_REGENERATION2.getName() + " §7§lSkill")) {

                    if(shopManager.hasBought(ShopItem.SKILLS_REGENERATION2)) {
                        if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_REGENERATION2)) {
                            skillsManager.disableSkill(ShopItem.SKILLS_REGENERATION2);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 1), true)
                                    .setBasePotionData(PotionType.REGEN)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION2.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION2.getName() + "§7.",
                                            "",
                                            "§c§lNot active")
                                    .build());
                        } else {
                            skillsManager.enableSkill(ShopItem.SKILLS_REGENERATION2);
                            event.setCurrentItem(this.plugin.getApi().item(Material.POTION)
                                    //.addPotionCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 0, 1), true)
                                    .setBasePotionData(PotionType.REGEN)
                                    .setDisplayname("§c§l" + ShopItem.SKILLS_REGENERATION2.getName() + " §7§lSkill")
                                    .setLore("§7You get a permanent effect of §c" + ShopItem.SKILLS_REGENERATION2.getName() + "§7.",
                                            "",
                                            "§a§lActivated")
                                    .build());
                        }
                    }

                }

            }

        }

    }

}
