package vip.marcel.firstmc.utils.managers;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.entities.SwordLevel;

public class SwordManager {

    private final RPGSword plugin;

    public SwordManager(RPGSword plugin) {
        this.plugin = plugin;

        this.initSwords();
    }

    private void initSwords() {

        /* LEVEL 1 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.WOODEN_SHOVEL)
                    .setUnbreakable(true)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(1, itemStack);

            SwordLevel swordLevel = new SwordLevel();
                swordLevel.setLevel(1);
                swordLevel.setMaxExperience(100);
                swordLevel.setGrandExperience(1);
                swordLevel.setCoinsPerKill(1);
                swordLevel.setKillableEntityType(EntityType.CHICKEN);

            this.plugin.getSwordLevelMap().put(1, swordLevel);
        }

        /* LEVEL 2 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.STONE_SHOVEL)
                    .setUnbreakable(true)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(2, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(2);
            swordLevel.setMaxExperience(100);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(2);
            swordLevel.setKillableEntityType(EntityType.PIG);

            this.plugin.getSwordLevelMap().put(2, swordLevel);
        }

        /* LEVEL 3 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.WOODEN_SWORD)
                    .setUnbreakable(true)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(3, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(3);
            swordLevel.setMaxExperience(100);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(3);
            swordLevel.setKillableEntityType(EntityType.SHEEP);

            this.plugin.getSwordLevelMap().put(3, swordLevel);
        }

        /* LEVEL 4 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.WOODEN_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 1)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(4, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(4);
            swordLevel.setMaxExperience(100);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(4);
            swordLevel.setKillableEntityType(EntityType.COW);

            this.plugin.getSwordLevelMap().put(4, swordLevel);
        }

        /* LEVEL 5 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.STONE_SWORD)
                    .setUnbreakable(true)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(5, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(5);
            swordLevel.setMaxExperience(100);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(5);
            swordLevel.setKillableEntityType(EntityType.CAT);

            this.plugin.getSwordLevelMap().put(5, swordLevel);
        }

        /* LEVEL 6 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.STONE_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 1)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(6, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(6);
            swordLevel.setMaxExperience(300);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(6);
            swordLevel.setKillableEntityType(EntityType.PANDA);

            this.plugin.getSwordLevelMap().put(6, swordLevel);
        }

        /* LEVEL 7 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.GOLDEN_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 3)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(7, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(7);
            swordLevel.setMaxExperience(300);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(7);
            swordLevel.setKillableEntityType(EntityType.FOX);

            this.plugin.getSwordLevelMap().put(7, swordLevel);
        }

        /* LEVEL 8 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.GOLDEN_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 4)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(8, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(8);
            swordLevel.setMaxExperience(300);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(8);
            swordLevel.setKillableEntityType(EntityType.WOLF);

            this.plugin.getSwordLevelMap().put(8, swordLevel);
        }

        /* LEVEL 9 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.IRON_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 1)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(9, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(9);
            swordLevel.setMaxExperience(300);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(9);
            swordLevel.setKillableEntityType(EntityType.ZOMBIE);

            this.plugin.getSwordLevelMap().put(9, swordLevel);
        }

        /* LEVEL 10 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.IRON_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 2)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(10, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(10);
            swordLevel.setMaxExperience(300);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(10);
            swordLevel.setKillableEntityType(EntityType.SKELETON);

            this.plugin.getSwordLevelMap().put(10, swordLevel);
        }

        /* LEVEL 11 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.IRON_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 3)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(11, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(11);
            swordLevel.setMaxExperience(500);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(11);
            swordLevel.setKillableEntityType(EntityType.HUSK);

            this.plugin.getSwordLevelMap().put(11, swordLevel);
        }

        /* LEVEL 12 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.IRON_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 4)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(12, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(12);
            swordLevel.setMaxExperience(500);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(12);
            swordLevel.setKillableEntityType(EntityType.SLIME);

            this.plugin.getSwordLevelMap().put(12, swordLevel);
        }

        /* LEVEL 13 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.DIAMOND_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 1)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(13, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(13);
            swordLevel.setMaxExperience(500);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(13);
            swordLevel.setKillableEntityType(EntityType.ZOGLIN);

            this.plugin.getSwordLevelMap().put(13, swordLevel);
        }

        /* LEVEL 14 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.DIAMOND_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 2)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(14, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(14);
            swordLevel.setMaxExperience(500);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(14);
            swordLevel.setKillableEntityType(EntityType.SILVERFISH);

            this.plugin.getSwordLevelMap().put(14, swordLevel);
        }

        /* LEVEL 15 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.DIAMOND_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 3)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(15, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(15);
            swordLevel.setMaxExperience(500);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(15);
            swordLevel.setKillableEntityType(EntityType.SPIDER);

            this.plugin.getSwordLevelMap().put(15, swordLevel);
        }

        /* LEVEL 16 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.DIAMOND_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 4)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(16, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(16);
            swordLevel.setMaxExperience(700);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(16);
            swordLevel.setKillableEntityType(EntityType.WITCH);

            this.plugin.getSwordLevelMap().put(16, swordLevel);
        }

        /* LEVEL 17 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.DIAMOND_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 5)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(17, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(17);
            swordLevel.setMaxExperience(700);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(17);
            swordLevel.setKillableEntityType(EntityType.RAVAGER);

            this.plugin.getSwordLevelMap().put(17, swordLevel);
        }

        /* LEVEL 18 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.NETHERITE_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 3)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(18, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(18);
            swordLevel.setMaxExperience(700);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(18);
            swordLevel.setKillableEntityType(EntityType.STRAY);

            this.plugin.getSwordLevelMap().put(18, swordLevel);
        }

        /* LEVEL 19 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.NETHERITE_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 4)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(19, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(19);
            swordLevel.setMaxExperience(700);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(19);
            swordLevel.setKillableEntityType(EntityType.ZOMBIFIED_PIGLIN);

            this.plugin.getSwordLevelMap().put(19, swordLevel);
        }

        /* LEVEL 20 */
        {
            ItemStack itemStack = this.plugin.getApi().item(Material.NETHERITE_SWORD)
                    .setUnbreakable(true)
                    .addEnchantment(Enchantment.DAMAGE_ALL, 5)
                    .setDisplayname("§7(§4§l!§7) RPG (§4§l!§7)")
                    .build();
            this.plugin.getSwordItems().put(20, itemStack);

            SwordLevel swordLevel = new SwordLevel();
            swordLevel.setLevel(20);
            swordLevel.setMaxExperience(800);
            swordLevel.setGrandExperience(1);
            swordLevel.setCoinsPerKill(20);
            swordLevel.setKillableEntityType(EntityType.IRON_GOLEM);

            this.plugin.getSwordLevelMap().put(20, swordLevel);
        }

    }

}
