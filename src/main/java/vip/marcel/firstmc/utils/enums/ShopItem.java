package vip.marcel.firstmc.utils.enums;

import java.text.MessageFormat;

public enum ShopItem {

    SKILLS_STRENGHT1("Strenght 1", 100000, "rpg.shop.skills.strenght1"),
    SKILLS_STRENGHT2("Strenght 2", 250000, "rpg.shop.skills.strenght2"),
    SKILLS_SPEED1("Speed 1", 75000, "rpg.shop.skills.speed1"),
    SKILLS_SPEED2("Speed 2", 150000, "rpg.shop.skills.speed2"),
    SKILLS_NIGHTVISION("NightVision", 25000, "rpg.shop.skills.nightvision"),
    SKILLS_JUMPBOOST1("JumpBoost 1", 75000, "rpg.shop.skills.jumpboost1"),
    SKILLS_JUMPBOOST2("JumpBoost 2", 175000, "rpg.shop.skills.jumpboost2"),
    SKILLS_REGENERATION1("Regeneration 1", 125000, "rpg.shop.skills.regeneration1"),
    SKILLS_REGENERATION2("Regeneration 2", 275000, "rpg.shop.skills.regeneration2"),

    RANKS_COAL("Coal", 250000, "rpg.shop.ranks.coal"),
    RANKS_GOLD("Gold", 600000, "rpg.shop.ranks.gold"),
    RANKS_EMERALD("Emerald", 1500000, "rpg.shop.ranks.emerald"),
    RANKS_DIAMOND("Diamond", 7500000, "rpg.shop.ranks.diamond"),

    ITEMS_OPHELM("OP Helmet", 300000, ""),
    ITEMS_OPCHESTPLATE("OP Chestplate", 750000, ""),
    ITEMS_OPLEGGINGS("OP Leggings", 500000, ""),
    ITEMS_OPBOOTS("OP Boots", 300000, ""),
    ITEMS_OPPICKAXE("OP Pickaxe", 350000, ""),
    ITEMS_OPAXE("OP Axe", 250000, ""),
    ITEMS_OPSHOVEL("OP Shovel", 150000, ""),
    ITEMS_OPSWORD("OP Sword", 550000, "");

    private String name, permission;
    private int price;

    ShopItem(String name, int price, String permission) {
        this.name = name;
        this.price = price;
        this.permission = permission;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public String getStringPrice() {
        return MessageFormat.format("{0}", this.price);
    }

    public String getPermission() {
        return this.permission;
    }

}
