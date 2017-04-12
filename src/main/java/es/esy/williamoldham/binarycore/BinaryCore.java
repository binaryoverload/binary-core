package es.esy.williamoldham.binarycore;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by william on 12/04/17.
 */
public class BinaryCore extends BinaryPlugin {

    @Override
    public void init() {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(StringUtils.colour("&aBinaryOverload's Core Plugin Enabled!"));
    }

    @Override
    public void load() {

    }

    @Override
    public void postload() {

    }

    @Override
    public void preload() {

    }

    @Override
    public void register() {

    }

    @Override
    public void save() {

    }

    @Override
    public void schedule() {

    }

    public static BinaryCore getInstance() {
        return BinaryCore.getPlugin(BinaryCore.class);
    }
}
