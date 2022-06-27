package vip.marcel.firstmc.utils.enums;

public enum Achievment {

    FIRST_KILL("First Kill", 5000, "Kill your first mob."),
    FIRST_DEATH("First Death", 5000, "Get first time killed by a mob."),
    FIRST_PRESTIGE("First Prestige", 5000, "Prestige for the first time."),
    XP_1000("XP 1000", 5000, "Kill mobs until you're grand 1000 experiences."),
    FIRST_SHOP_CONFIRM("First Buy", 5000, "Buy your first item in the coin shop.");

    private String name, description;
    private int reward;

    Achievment(String name, int reward, String description) {
        this.name = name;
        this.reward = reward;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public int getReward() {
        return this.reward;
    }

    public String getDescription() {
        return this.description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
