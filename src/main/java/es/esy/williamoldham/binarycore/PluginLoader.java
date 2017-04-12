package es.esy.williamoldham.binarycore;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Loads all my plugins for this plugin to recognise
 *
 * @author BinaryOverload
 * @since 1.5.0
 * @version 1.0.0
 *
 */
public class PluginLoader {

    private static PluginLoader instance = new PluginLoader();

    private PluginLoader() {}

    public static PluginLoader getInstance(){
        return instance;
    }

    private BinaryCore main = BinaryCore.getInstance();
    private ConsoleCommandSender console = Bukkit.getConsoleSender();

    private List<BinaryPlugin> plugins = new ArrayList<>();

    public void registerPlugin(BinaryPlugin plugin, String version){
        if(!checkMinVersion(version)){
            throw new IllegalArgumentException("Plugin trying to be registered is incompatible with the core plugin! Please check versions!");
        } else if (plugin.getClass().getPackage().toString().startsWith("es.esy.williamoldham")) {
            throw new IllegalArgumentException("Plugin trying to be registered is not valid!");
        } else {
            plugins.add(plugin);
            Sender.sendMessage(console, "&a" + plugin.getName() + " was registered in BinaryCore!");
        }
    }

    public boolean checkVersion(String version){
        String pattern = "^([0-9]+)\\.([0-9]+)\\.([0-9]+)$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(version);
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkMinVersion(String version){
        assert checkVersion(version) : "The plugin trying to be registered has an invalid min version!";
        assert checkVersion(main.getDescription().getVersion()) : "The main plugin trying to be registered has an invalid min version!";

        String[] versionSplit = version.split(".");
        String[] mainVersionSplit = main.getDescription().getVersion().split(".");

        boolean check = false;

        int ver = Integer.parseInt(versionSplit[0]);
        int ver1 = Integer.parseInt(mainVersionSplit[0]);

        if (ver1 >= ver && ver1 <= ver + 1){
            check = true;
        }

        return check;

    }


}
