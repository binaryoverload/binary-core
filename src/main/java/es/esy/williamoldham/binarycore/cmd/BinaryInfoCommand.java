package es.esy.williamoldham.binarycore.cmd;

import com.google.common.base.Strings;
import es.esy.williamoldham.binarycore.BinaryPlugin;
import es.esy.williamoldham.binarycore.PluginLoader;
import es.esy.williamoldham.binarycore.util.Sender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

/**
 * Created by william on 12/04/17.
 */
public class BinaryInfoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n&a----------------------------------------\n");
        builder.append("&bBinaryOverload's Plugins\n");
        builder.append("&a----------------------------------------\n");
        for (BinaryPlugin plugin : PluginLoader.getInstance().getPlugins()){
            PluginDescriptionFile desc = plugin.getDescription();
            String name = desc.getName();
            String version = desc.getVersion();
            builder.append("&6" + name + " ");
            builder.append("(v" + version + ")\n");
        }
        builder.append("&a----------------------------------------");
        Sender.sendCenteredMessage(commandSender, builder.toString());
        return true;
    }
}
