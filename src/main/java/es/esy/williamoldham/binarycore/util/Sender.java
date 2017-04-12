package es.esy.williamoldham.binarycore.util;

import es.esy.williamoldham.binarycore.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by william on 12/04/17.
 */
public class Sender {

    public static void sendMessage(CommandSender s, String message){
        s.sendMessage(StringUtils.colour(message));
    }

    public static void sendCenteredMessage(CommandSender s, String message){
        StringBuilder sb = new StringBuilder();
        String[] messages = message.split("\n");
        for(int i = 0; i < messages.length; i++){
            String string = messages[i];
            if(!(i == messages.length - 1)) {
                sb.append(StringUtils.getCenteredMessage(string) + "\n");
            } else {
                sb.append(StringUtils.getCenteredMessage(string));
            }
        }
        s.sendMessage(sb.toString());
    }

}
