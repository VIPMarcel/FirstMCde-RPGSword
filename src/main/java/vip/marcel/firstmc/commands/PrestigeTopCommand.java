package vip.marcel.firstmc.commands;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vip.marcel.firstmc.RPGSword;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public record PrestigeTopCommand(RPGSword plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arguments) {

        final File rpgFolder = new File("plugins/RPGSword");
        final List<File> fileList = Lists.newArrayList();
        final Map<UUID, Integer> prestigePlayerMap = Maps.newHashMap();


        for(File file : rpgFolder.listFiles()) {
            if(!file.getName().equalsIgnoreCase("locations.yml")) {
                fileList.add(file);
            }
        }

        fileList.forEach(file -> {
            final UUID uuid = UUID.fromString(file.getName().replace(".yml", ""));

            if(Bukkit.getPlayer(uuid) != null) {
                final Player player = Bukkit.getPlayer(uuid);

                prestigePlayerMap.put(player.getUniqueId(), this.plugin.getRPGPlayerMap().get(player).getPrestigeLevel());
            } else {
                final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
                final int prestigeLevel = configuration.getInt("Prestige-Level");

                prestigePlayerMap.put(uuid, prestigeLevel);
            }
        });

        Map<UUID, Integer> topTen =
                prestigePlayerMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(10)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        final AtomicInteger i = new AtomicInteger();

        sender.sendMessage(" ");
        sender.sendMessage("§7Prestige §aTop 10 §7players:");
        topTen.forEach((key, value) -> {
            i.getAndIncrement();

            if(Bukkit.getPlayer(key) != null) {
                sender.sendMessage("§a§l#" + i.get() + "§r §7" + Bukkit.getPlayer(key).getName() + " §8» §a" + value);
            } else {
                sender.sendMessage("§a§l#" + i.get() + "§r §7" + Bukkit.getOfflinePlayer(key).getName() + " §8» §a" + value);
            }
        });
        sender.sendMessage(" ");

        fileList.clear();
        prestigePlayerMap.clear();

        return true;
    }

}
