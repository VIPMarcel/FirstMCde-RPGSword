package vip.marcel.firstmc.utils.managers;

import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.entities.PrestigeLevel;

public class PrestigeLevelManager {

    private final RPGSword plugin;

    public PrestigeLevelManager(RPGSword plugin) {
        this.plugin = plugin;

        this.initPrestigeLevels();
    }

    private void initPrestigeLevels() {
        double multiplikator = 1.0;

        for(int i = 0; i < 251; i++) {
            multiplikator = multiplikator + 0.25D;

            PrestigeLevel prestigeLevel = new PrestigeLevel();
                prestigeLevel.setMultiplikator(multiplikator);

            this.plugin.getPrestigeLevelMap().put(i, prestigeLevel);
        }

    }

}
