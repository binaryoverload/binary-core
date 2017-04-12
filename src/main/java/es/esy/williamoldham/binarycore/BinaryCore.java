package es.esy.williamoldham.binarycore;

import es.esy.williamoldham.binarycore.cmd.BinaryInfoCommand;
import es.esy.williamoldham.binarycore.cmd.UpdateCommand;
import es.esy.williamoldham.binarycore.util.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

/**
 * Created by william on 12/04/17.
 */
public class BinaryCore extends BinaryPlugin {

    @Override
    public void init() {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(StringUtils.colour("&aBinaryOverload's Core Plugin Enabled!"));
        PluginLoader.getInstance().registerPlugin(this, this.getDescription().getVersion());
        setRepoName("binary-core");
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
        getCommand("binary-info").setExecutor(new BinaryInfoCommand());
        getCommand("update").setExecutor(new UpdateCommand());
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
