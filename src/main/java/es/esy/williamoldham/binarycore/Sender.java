package es.esy.williamoldham.binarycore;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by william on 12/04/17.
 */
public class Sender {

    public static void sendMessage(Player p, String message){
        p.sendMessage(StringUtils.colour(message));
    }

    public static void sendMessage(CommandSender s, String message){
        s.sendMessage(StringUtils.colour(message));
    }

}
