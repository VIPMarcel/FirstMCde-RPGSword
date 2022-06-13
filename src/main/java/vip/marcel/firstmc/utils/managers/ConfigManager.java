package vip.marcel.firstmc.utils.managers;

import org.bukkit.configuration.file.YamlConfiguration;
import vip.marcel.firstmc.RPGSword;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ConfigManager {

    private final RPGSword plugin;

    private final File folder;

    public ConfigManager(RPGSword plugin) {
        this.plugin = plugin;

        this.folder = new File("plugins/RPGSword/");

        if(!this.folder.exists()) {
            this.folder.mkdir();
        }

    }

    public void createConfig(UUID uuid) {

        if(this.getPlayerFile(uuid) == null) {

            final File file = new File(this.folder, uuid.toString() + ".yml");
            final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

            try {
                file.createNewFile();
                configuration.set("RPGCoins", 0);
                configuration.set("Prestige-Level", 0);
                configuration.set("Level", 1);
                configuration.set("XP", 0.0);
                configuration.set("Multiplikator", 1.0);
                configuration.save(file);
            } catch(IOException e) {
                e.printStackTrace();
            }

        }

    }

    public File getPlayerFile(UUID uuid) {
        final File file = new File(this.folder, uuid.toString() + ".yml");

        if(!file.exists() | file == null) {
            return null;
        }

        return file;
    }

    public void setPlayerFile(UUID uuid, File file) {
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

}
