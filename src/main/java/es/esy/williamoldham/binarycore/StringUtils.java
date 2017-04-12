package es.esy.williamoldham.binarycore;

import es.esy.williamoldham.binarycore.util.DefaultFontInfo;
import org.bukkit.ChatColor;

/**
 * Created by william on 12/04/17.
 */
public class StringUtils {

    private final static int CENTER_PX = 154;
    private final static int MAX_PX = 250;

    public static String colour(String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String colour(String string, char colourChar){
        return ChatColor.translateAlternateColorCodes(colourChar, string);
    }

    public static String getCenteredMessage(String message){
        String messageColoured = colour(message);
        int messagePxSize = 0;
        boolean previousCode = false;
        boolean isBold = false;
        int charIndex = 0;
        int lastSpaceIndex = 0;
        String toSendAfter = null;
        String recentColorCode = "";
        for(char c : messageColoured.toCharArray()){
            if(c == '§'){
                previousCode = true;
                continue;
            }else if(previousCode){
                previousCode = false;
                recentColorCode = "§" + c;
                if(c == 'l' || c == 'L'){
                    isBold = true;
                    continue;
                }else isBold = false;
            }else if(c == ' ') lastSpaceIndex = charIndex;
            else{
                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
                messagePxSize++;
            }
            if(messagePxSize >= MAX_PX){
                toSendAfter = recentColorCode + messageColoured.substring(lastSpaceIndex + 1, messageColoured.length());
                messageColoured = messageColoured.substring(0, lastSpaceIndex + 1);
                break;
            }
            charIndex++;
        }
        int halvedMessageSize = messagePxSize / 2;
        int toCompensate = CENTER_PX - halvedMessageSize;
        int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
        int compensated = 0;
        StringBuilder sb = new StringBuilder();
        while(compensated < toCompensate){
            sb.append(" ");
            compensated += spaceLength;
        }
        if(toSendAfter != null) {
            return sb.toString() + messageColoured + "\n" + getCenteredMessage(toSendAfter);
        } else {
            return sb.toString() + messageColoured;
        }
    }

}
