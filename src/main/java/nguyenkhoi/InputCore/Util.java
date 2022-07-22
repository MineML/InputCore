package nguyenkhoi.InputCore;
import me.clip.placeholderapi.PlaceholderAPI;
import nguyenkhoi.InputCore.InputCatcher.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static nguyenkhoi.InputCore.InputCore.papistatus;


public class Util {
    private final static char COLOR_CHAR = ChatColor.COLOR_CHAR;

    public static void  sendPlayerMessage(Player p, String message) {
        p.sendMessage(colorize(message));
    }

    public static String colorize(String input) {
        input = ChatColor.translateAlternateColorCodes('&', input);
        if (input.startsWith("&#")) {
            input = translateHexColorCodes(input);
        }
        return input;
    }

    private static String translateHexColorCodes(String message) {
        final Pattern hexPattern = Pattern.compile("&#" + "([A-Fa-f0-9]{6})" + "");
        Matcher matcher = hexPattern.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 4 * 8);
        while (matcher.find()) {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x" + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1) + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3) + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5));
        }

        return matcher.appendTail(buffer).toString();
    }

    public static String papi(Player p, String input) {
        if (papistatus) {
            String output = PlaceholderAPI.setPlaceholders(p, input);
            output = colorize(output);
            return output;
        } else {
            return input;
        }
    }

    public static List<String> lowerStrings (List<String> input) {
        List<String> output = new ArrayList<>();
        for (String s : input) {
            output.add(s.toLowerCase());
        }
        return output;
    }

    public static void callInputEvent(Player p, String rawInput, InputType_All inputType) {
        InputEvent inputEvent = new InputEvent(p, rawInput);
        inputType.run(inputEvent);
    }

    public static void callInputEvent(Player p, String rawInput, InputType_Number inputType) {
        InputEvent inputEvent = new InputEvent(p, rawInput);
        inputType.run(inputEvent);
    }

    public static void callInputEvent(Player p, String rawInput, InputType_Text inputType) {
        InputEvent inputEvent = new InputEvent(p, rawInput);
        inputType.run(inputEvent);
    }

    public static boolean isText(String s) {
        if (s == null) {
            return false;
        } else {
            return s.matches("\\D");
        }
    }

    public static boolean isNumber(String s) {
        if (s == null) {
            return false;
        } else {
            return s.matches("([+\\-])?(\\d+)((\\.)(\\d+))?");
        }
    }

    public static boolean isByte(String s) {
        if(s == null) {
            return false;
        }
        try {
            Byte.parseByte(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isShort(String s) {
        if(s == null) {
            return false;
        }
        try {
            Short.parseShort(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isInteger(String s) {
        if(s == null) {
            return false;
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isLong(String s) {
        if(s == null) {
            return false;
        }
        try {
            Long.parseLong(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFloat(String s) {
        if(s == null) {
            return false;
        }
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDouble(String s) {
        if(s == null) {
            return false;
        }
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
