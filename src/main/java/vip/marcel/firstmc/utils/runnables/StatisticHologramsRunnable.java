package vip.marcel.firstmc.utils.runnables;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.pluginapi.managers.LocationManager;

import java.io.File;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatisticHologramsRunnable extends BukkitRunnable {

    private final RPGSword plugin;

    public StatisticHologramsRunnable(RPGSword plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        final LocationManager locationManager = this.plugin.getApi().getLocationManager();

        if(locationManager.doesLocationExists("Hologram-TopCoins")) {

            {
                final File rpgFolder = new File("plugins/RPGSword");
                final List<File> fileList = Lists.newArrayList();
                final Map<UUID, Integer> coinsPlayerMap = Maps.newHashMap();


                for(File file : rpgFolder.listFiles()) {
                    if(!file.getName().equalsIgnoreCase("locations.yml")) {
                        fileList.add(file);
                    }
                }

                fileList.forEach(file -> {
                    final UUID uuid = UUID.fromString(file.getName().replace(".yml", ""));

                    if(Bukkit.getPlayer(uuid) != null) {
                        final Player player = Bukkit.getPlayer(uuid);

                        coinsPlayerMap.put(player.getUniqueId(), this.plugin.getRPGPlayerMap().get(player).getRPGCoins());
                    } else {
                        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
                        final int coins = configuration.getInt("RPGCoins");

                        coinsPlayerMap.put(uuid, coins);
                    }
                });

                Map<UUID, Integer> topTen =
                        coinsPlayerMap.entrySet().stream()
                                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                .limit(10)
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

                final AtomicInteger i = new AtomicInteger();
                final List<String> lines = Lists.newLinkedList();

                lines.add(0, "§7-/-");
                lines.add(1, "§7-/-");
                lines.add(2, "§7-/-");
                lines.add(3, "§7-/-");
                lines.add(4, "§7-/-");
                lines.add(5, "§7-/-");
                lines.add(6, "§7-/-");
                lines.add(7, "§7-/-");
                lines.add(8, "§7-/-");
                lines.add(9, "§7-/-");

                topTen.forEach((key, value) -> {
                    i.getAndIncrement();

                    if(Bukkit.getPlayer(key) != null) {
                        lines.add((i.get() - 1), "§a§l#" + i.get() + "§r §7" + Bukkit.getPlayer(key).getName() + " §8» §a" + MessageFormat.format("{0}", value));
                    } else {
                        lines.add((i.get() - 1), "§a§l#" + i.get() + "§r §7" + Bukkit.getOfflinePlayer(key).getName() + " §8» §a" + MessageFormat.format("{0}", value));
                    }
                });

                this.plugin.getApi().hologram(locationManager.getLocation("Hologram-TopCoins"),
                                "§aTop 10 §7Coins",
                                " ",
                                lines.get(0),
                                lines.get(1),
                                lines.get(2),
                                lines.get(3),
                                lines.get(4),
                                lines.get(5),
                                lines.get(6),
                                lines.get(7),
                                lines.get(8),
                                lines.get(9))
                        .showHologramForAllTemporary(20);

            }

        }

        if(locationManager.doesLocationExists("Hologram-TopPrestige")) {

            {
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

                final List<String> lines = Lists.newLinkedList();
                final AtomicInteger i = new AtomicInteger();

                lines.add(0, "§7-/-");
                lines.add(1, "§7-/-");
                lines.add(2, "§7-/-");
                lines.add(3, "§7-/-");
                lines.add(4, "§7-/-");
                lines.add(5, "§7-/-");
                lines.add(6, "§7-/-");
                lines.add(7, "§7-/-");
                lines.add(8, "§7-/-");
                lines.add(9, "§7-/-");

                topTen.forEach((key, value) -> {
                    i.getAndIncrement();

                    if(Bukkit.getPlayer(key) != null) {
                        lines.add((i.get() - 1), "§a§l#" + i.get() + "§r §7" + Bukkit.getPlayer(key).getName() + " §8» §a" + value);
                    } else {
                        lines.add((i.get() - 1), "§a§l#" + i.get() + "§r §7" + Bukkit.getOfflinePlayer(key).getName() + " §8» §a" + value);
                    }
                });

                this.plugin.getApi().hologram(locationManager.getLocation("Hologram-TopPrestige"),
                                "§aTop 10 §7Prestige",
                                " ",
                                lines.get(0),
                                lines.get(1),
                                lines.get(2),
                                lines.get(3),
                                lines.get(4),
                                lines.get(5),
                                lines.get(6),
                                lines.get(7),
                                lines.get(8),
                                lines.get(9))
                        .showHologramForAllTemporary(20);

            }

        }


    }

}
