package vip.marcel.firstmc.utils.runnables;

import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import vip.marcel.firstmc.RPGSword;
import vip.marcel.firstmc.utils.enums.ShopItem;
import vip.marcel.firstmc.utils.managers.SkillsManager;

public class SkillsEffectRunnable extends BukkitRunnable {

    private final RPGSword plugin;

    public SkillsEffectRunnable(RPGSword plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(players -> {
            final SkillsManager skillsManager = this.plugin.getSkillsManager(players);

            if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_STRENGHT1)) {
                players.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 0, false, false));
            }

            if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_STRENGHT2)) {
                players.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 1, false, false));
            }

            if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_SPEED1)) {
                players.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 0, false, false));
            }

            if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_SPEED2)) {
                players.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 1, false, false));
            }

            if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_NIGHTVISION)) {
                players.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 40, 0, false, false));
            }

            if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_JUMPBOOST1)) {
                players.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 0, false, false));
            }

            if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_JUMPBOOST2)) {
                players.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 1, false, false));
            }

            if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_REGENERATION1)) {
                players.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 0, false, false));
            }

            if(skillsManager.hasSkillEnabled(ShopItem.SKILLS_REGENERATION2)) {
                players.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 1, false, false));
            }

        });
    }

}
