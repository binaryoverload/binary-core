package es.esy.williamoldham.binarycore;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by william on 12/04/17.
 */
public class BinaryCore extends JavaPlugin {

    @Override
    public void onEnable() {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(StringUtils.colour("&aBinaryOverload's Core Plugin Enabled!"));
    }



}