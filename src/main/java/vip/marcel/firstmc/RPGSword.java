package vip.marcel.firstmc;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import vip.marcel.firstmc.commands.*;
import vip.marcel.firstmc.listeners.*;
import vip.marcel.firstmc.utils.entities.PrestigeLevel;
import vip.marcel.firstmc.utils.entities.SwordLevel;
import vip.marcel.firstmc.utils.enums.ShopItem;
import vip.marcel.firstmc.utils.managers.*;
import vip.marcel.firstmc.utils.player.RPGPlayer;
import vip.marcel.firstmc.utils.runnables.*;
import vip.marcel.pluginapi.PluginAPI;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class RPGSword extends JavaPlugin {

    private PluginAPI api;

    private Map<Player, File> playerFileMap;
    private Map<Player, RPGPlayer> rpgPlayerMap;
    private Map<Integer, ItemStack> swordItems;
    private Map<Integer, SwordLevel> swordLevelMap;
    private Map<Integer, PrestigeLevel> prestigeLevelMap;
    private Map<Player, ShopItem> shopConfirmItem;

    private List<Player> editModePlayerList;

    private int maxSwordLevel;

    private ConfigManager configManager;
    private SwordManager swordManager;
    private PrestigeLevelManager prestigeLevelManager;
    private InventoryManager inventoryManager;

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
        this.shopConfirmItem = Maps.newConcurrentMap();

        this.editModePlayerList = Lists.newArrayList();

        this.maxSwordLevel = 20;

        this.configManager = new ConfigManager(this);
        this.swordManager = new SwordManager(this);
        this.prestigeLevelManager = new PrestigeLevelManager(this);
        this.inventoryManager = new InventoryManager(this);

        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerLoginListener(this), this);
        pluginManager.registerEvents(new PlayerQuitListener(this), this);
        pluginManager.registerEvents(new PlayerRegionEnterListener(this), this);
        pluginManager.registerEvents(new PlayerRegionLeftListener(this), this);
        pluginManager.registerEvents(new PlayerDropItemListener(this), this);
        pluginManager.registerEvents(new EntityDeathListener(this), this);
        pluginManager.registerEvents(new EntityDamageByEntityListener(this), this);
        pluginManager.registerEvents(new InventoryMoveItemListener(this), this);
        pluginManager.registerEvents(new FoodLevelChangeListener(this), this);
        //pluginManager.registerEvents(new AsyncPlayerChatListener(this), this);
        pluginManager.registerEvents(new EntityDamageListener(this), this);
        pluginManager.registerEvents(new InventoryClickListener(this), this);
        pluginManager.registerEvents(new PlayerInteractListener(this), this);
        pluginManager.registerEvents(new BlockBreakListener(this), this);
        pluginManager.registerEvents(new BlockPlaceListener(this), this);
        pluginManager.registerEvents(new PlayerArmorStandManipulateListener(this), this);

        getCommand("fixsword").setExecutor(new FixSwordCommand(this));
        getCommand("prestige").setExecutor(new PrestigeCommand(this));
        getCommand("rpg").setExecutor(new RPGCommand(this));
        getCommand("coinshop").setExecutor(new CoinShopCommand(this));
        getCommand("skills").setExecutor(new SkillsCommand(this));
        getCommand("coins").setExecutor(new CoinsCommand(this));
        getCommand("levelbox").setExecutor(new LevelBoxCommand(this));
        getCommand("setposition").setExecutor(new SetPositionCommand(this));
        getCommand("editmode").setExecutor(new EditModeCommand(this));
        getCommand("prestigetop").setExecutor(new PrestigeTopCommand(this));
        getCommand("discord").setExecutor(new DiscordCommand(this));
        getCommand("adress").setExecutor(new ServerAdressCommand(this));
        getCommand("afk").setExecutor(new AFKCommand(this));
        getCommand("coinstop").setExecutor(new CoinsTopCommand(this));

        new AFKAreaRunnable(this).runTaskTimerAsynchronously(this, 20 * 60, 20 * 60);
        new ActionbarRunnable(this).runTaskTimerAsynchronously(this, 10, 10);
        new UpdateScoreboardRunnable(this).runTaskTimer(this, 10, 10);
        new PlayerTimeRunnable(this).runTaskTimerAsynchronously(this, 20, 20);
        new SkillsEffectRunnable(this).runTaskTimer(this, 20, 20);
    }

    public PluginAPI getApi() {
        return this.api;
    }

    public ConfigManager getConfigManager() {
        return this.configManager;
    }

    public InventoryManager getInventoryManager() {
        return this.inventoryManager;
    }

    public ShopManager getShopManager(Player player) {
        return new ShopManager(this, player);
    }

    public SkillsManager getSkillsManager(Player player) {
        return new SkillsManager(this, player);
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

    public Map<Player, ShopItem> getShopConfirmItem() {
        return this.shopConfirmItem;
    }

    public List<Player> getEditModePlayerList() {
        return this.editModePlayerList;
    }

    public int getMaxSwordLevel() {
        return this.maxSwordLevel;
    }

}
