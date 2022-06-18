package vip.marcel.firstmc.utils.player;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import vip.marcel.firstmc.RPGSword;

import java.io.File;
import java.io.IOException;

public record RPGPlayer(RPGSword plugin, Player player) {

    public int getRPGCoins() {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        return configuration.getInt("RPGCoins");

    }

    public void setRPGCoins(int amount) {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("RPGCoins", amount);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public void grandRPGCoins(int amount) {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("RPGCoins", configuration.getInt("RPGCoins") + amount);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public void removeRPGCoins(int amount) {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("RPGCoins", configuration.getInt("RPGCoins") - amount);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public int getPrestigeLevel() {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        return configuration.getInt("Prestige-Level");

    }

    public void setPrestigeLevel(int amount) {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("Prestige-Level", amount);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public void grandPrestigeLevel() {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("Prestige-Level", configuration.getInt("Prestige-Level") +1);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public int getLevel() {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        return configuration.getInt("Level");

    }

    public void setLevel(int amount) {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("Level", amount);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public void grandLevel() {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("Level", configuration.getInt("Level") +1);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public void resetLevel() {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("Level", 1);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public double getExperience() {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        return configuration.getDouble("XP");

    }

    public void setExperience(double amount) {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("XP", amount);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public void grandExperience(double amount) {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("XP", configuration.getDouble("XP") + amount);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public void resetExperience() {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("XP", 0);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public double getMultiplikator() {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        return configuration.getDouble("Multiplikator");

    }

    public void setMultiplikator(double amount) {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("Multiplikator", amount);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public int getPlayerMultiplikator() {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        return configuration.getInt("Player-Multiplikator");

    }

    public void setPlayerMultiplikator(int amount) {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("Player-Multiplikator", amount);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public void grandPlayerMultiplikator(int amount) {

        if(player == null) {
            new NullPointerException("The player ist null (not online).");
        }

        final File file = this.plugin.getPlayerFileMap().get(player);
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("Player-Multiplikator", configuration.getInt("Player-Multiplikator") + amount);
        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.plugin.getPlayerFileMap().put(player, file);

    }

    public void grandRPGSword() {
        final ItemStack itemStack = this.plugin.getSwordItems().get(this.getLevel());

        if(player.getInventory().firstEmpty() == -1) {
            // Inventory is full

            player.sendMessage("§cFailed! Your inventory is full and you can't get the rpg-sword.");

            this.plugin.getApi().runTaskLater(() -> {
                player.performCommand("spawn");
            }, 20);

        } else {
            player.getInventory().addItem(itemStack);
        }
    }

    public void updateRPGSword() {
        this.removeRPGSword();
        this.grandRPGSword();
    }

    public void removeRPGSword() {
        final RPGPlayer rpgPlayer = new RPGPlayer(this.plugin, player);

        for(int i = 0; i <= this.plugin.getSwordLevelMap().size() + 1; i++) {
            player.getInventory().remove(this.plugin.getSwordItems().get(i));
        }
        player.updateInventory();
    }

}
