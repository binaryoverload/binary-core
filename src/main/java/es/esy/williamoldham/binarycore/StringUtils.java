package es.esy.williamoldham.binarycore;

import org.bukkit.ChatColor;

/**
 * Created by william on 12/04/17.
 */
public class StringUtils {

    public static String colour(String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String colour(String string, char colourChar){
        return ChatColor.translateAlternateColorCodes(colourChar, string);
    }

}
