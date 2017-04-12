package es.esy.williamoldham.binarycore.cmd;

import es.esy.williamoldham.binarycore.util.Sender;
import es.esy.williamoldham.binarycore.util.Updater;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by william on 12/04/17.
 */
public class UpdateCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender.isOp()){
            Sender.sendMessage(sender, "&bUpdating plugins...");
            boolean success = Updater.updateAll();
            if (success) {
                Sender.sendMessage(sender, "&aPlugins updated!");
            } else {
                Sender.sendMessage(sender, "&cPlugins failed to update!");
            }

        }
        return true;
    }
}
