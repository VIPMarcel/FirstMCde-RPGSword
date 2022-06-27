package vip.marcel.firstmc.utils.managers;

import com.google.common.collect.Lists;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.enums.Achievment;

import java.io.File;
import java.io.IOException;
import java.util.List;

public record AchievmentManager(RPGSword plugin, Player player) {

    public boolean hasAchievment(Achievment achievment) {
        final File file = plugin.getConfigManager().getPlayerFile(player.getUniqueId());
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        if(configuration.get("Achievments") == null) {
            configuration.set("Achievments", Lists.newArrayList());

            try {
                configuration.save(file);
            } catch(IOException e) {
                e.printStackTrace();
            }

        } else {
            if(configuration.getStringList("Achievments").contains(achievment.getName().trim())) {
                return true;
            }
        }

        return false;
    }

    public void grandAchievment(Achievment achievment) {
        final File file = plugin.getConfigManager().getPlayerFile(player.getUniqueId());
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        if(configuration.get("Achievments") == null) {
            configuration.set("Achievments", Lists.newArrayList(achievment.getName().trim()));
        } else {
            final List<String> achievments = configuration.getStringList("Achievments");

            achievments.add(achievment.getName().trim());

            configuration.set("Achievments", achievments);
        }

        try {
            configuration.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

}
