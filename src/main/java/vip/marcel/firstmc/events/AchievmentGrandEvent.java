package vip.marcel.firstmc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import vip.marcel.firstmc.utils.enums.Achievment;

public class AchievmentGrandEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private Player player;
    private Achievment achievment;
    private boolean cancelled = false;

    public AchievmentGrandEvent(final Player player, final Achievment achievment) {
        this.player = player;
        this.achievment = achievment;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Achievment getAchievment() {
        return this.achievment;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
