package vip.marcel.firstmc;

import com.google.common.collect.Maps;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import vip.marcel.firstmc.commands.FixSwordCommand;
import vip.marcel.firstmc.commands.PrestigeCommand;
import vip.marcel.firstmc.listeners.*;
import vip.marcel.firstmc.utils.entities.PrestigeLevel;
import vip.marcel.firstmc.utils.entities.SwordLevel;
import vip.marcel.firstmc.utils.managers.ConfigManager;
import vip.marcel.firstmc.utils.managers.PrestigeLevelManager;
import vip.marcel.firstmc.utils.managers.SwordManager;
import vip.marcel.firstmc.utils.player.RPGPlayer;
import vip.marcel.firstmc.utils.runnables.AFKAreaRunnable;
import vip.marcel.firstmc.utils.runnables.ActionbarRunnable;
import vip.marcel.firstmc.utils.runnables.UpdateScoreboardRunnable;
import vip.marcel.pluginapi.PluginAPI;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

public class RPGSword extends JavaPlugin {

    private PluginAPI api;

    private Map<Player, File> playerFileMap;
    private Map<Player, RPGPlayer> rpgPlayerMap;
    private Map<Integer, ItemStack> swordItems;
    private Map<Integer, SwordLevel> swordLevelMap;
    private Map<Integer, PrestigeLevel> prestigeLevelMap;

    private int maxSwordLevel;

    private ConfigManager configManager;
    private SwordManager swordManager;
    private PrestigeLevelManager prestigeLevelManager;

    @Override
    public void onEnable() {
        this.init();
    }

    @Override
    public void onDisable() {

    }

    private void init() {
        this.api = new PluginAPI(this);

        this.playerFileMap = Maps.newConcurrentMap();
        this.rpgPlayerMap = new WeakHashMap<>();
        this.swordItems = Maps.newConcurrentMap();
        this.swordLevelMap = Maps.newConcurrentMap();
        this.prestigeLevelMap = Maps.newConcurrentMap();

        this.maxSwordLevel = 20;

        this.configManager = new ConfigManager(this);
        this.swordManager = new SwordManager(this);
        this.prestigeLevelManager = new PrestigeLevelManager(this);

        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerLoginListener(this), this);
        pluginManager.registerEvents(new PlayerQuitListener(this), this);
        pluginManager.registerEvents(new PlayerRegionEnterListener(this), this);
        pluginManager.registerEvents(new PlayerRegionLeftListener(this), this);
        pluginManager.registerEvents(new PlayerDropItemListener(this), this);
        pluginManager.registerEvents(new EntityDeathListener(this), this);
        pluginManager.registerEvents(new EntityDamageByEntityListener(this), this);
        pluginManager.registerEvents(new InventoryClickListener(this), this);

        getCommand("fixsword").setExecutor(new FixSwordCommand(this));
        getCommand("prestige").setExecutor(new PrestigeCommand(this));

        new AFKAreaRunnable(this).runTaskTimerAsynchronously(this, 20 * 60, 20 * 60);
        new ActionbarRunnable(this).runTaskTimerAsynchronously(this, 10, 10);
        new UpdateScoreboardRunnable(this).runTaskTimerAsynchronously(this, 10, 10);
    }

    public PluginAPI getApi() {
        return this.api;
    }

    public ConfigManager getConfigManager() {
        return this.configManager;
    }

    public Map<Player, File> getPlayerFileMap() {
        return this.playerFileMap;
    }

    public Map<Player, RPGPlayer> getRPGPlayerMap() {
        return this.rpgPlayerMap;
    }

    public Map<Integer, ItemStack> getSwordItems() {
        return this.swordItems;
    }

    public Map<Integer, SwordLevel> getSwordLevelMap() {
        return this.swordLevelMap;
    }

    public Map<Integer, PrestigeLevel> getPrestigeLevelMap() {
        return this.prestigeLevelMap;
    }

    public int getMaxSwordLevel() {
        return this.maxSwordLevel;
    }

}
