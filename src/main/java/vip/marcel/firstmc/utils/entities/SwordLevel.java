package vip.marcel.firstmc.utils.entities;

import org.bukkit.entity.EntityType;

public class SwordLevel {

    int level, maxExperience, grandExperience, coinsPerKill;
    private EntityType killableEntityType;

    public SwordLevel() {
    }

    public int getLevel() {
        return this.level;
    }

    public int getMaxExperience() {
        return this.maxExperience;
    }

    public int getGrandExperience() {
        return this.grandExperience;
    }

    public int getCoinsPerKill() {
        return this.coinsPerKill;
    }

    public EntityType getKillableEntityType() {
        return this.killableEntityType;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMaxExperience(int maxExperience) {
        this.maxExperience = maxExperience;
    }

    public void setGrandExperience(int grandExperience) {
        this.grandExperience = grandExperience;
    }

    public void setCoinsPerKill(int coinsPerKill) {
        this.coinsPerKill = coinsPerKill;
    }

    public void setKillableEntityType(EntityType killableEntityType) {
        this.killableEntityType = killableEntityType;
    }

}
