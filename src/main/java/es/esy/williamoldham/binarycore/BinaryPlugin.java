package es.esy.williamoldham.binarycore;

import es.esy.williamoldham.binarycore.design.SimpleDesign;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Abstract plugin class used by all my plugins
 *
 * @author BinaryOverload
 * @version 1.0.0
 * @since 1.5.0
 *
 */
public abstract class BinaryPlugin extends JavaPlugin implements SimpleDesign {

    @Override
    public void onDisable() {
        save();
        unregister();
    }

    @Override
    public void onEnable() {
        init();
        if(isEnabled()){
            preload();
            load();
            postload();
            register();
            schedule();
        }
    }

    @Override
    public void unregister() {
        HandlerList.unregisterAll(this);
        Bukkit.getScheduler().cancelTasks(this);
    }
}
