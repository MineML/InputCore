package nguyenkhoi.InputCore.InputCatcher;

import nguyenkhoi.InputCore.InputCore;
import org.bukkit.entity.Player;

import java.util.HashMap;

import static nguyenkhoi.InputCore.InputCore.registered;
import static nguyenkhoi.InputCore.Util.sendPlayerMessage;

public class Main {
    public static HashMap<Player, InputType_All> input_all = new HashMap<>();
    public static HashMap<Player, InputType_Number> input_number = new HashMap<>();
    public static HashMap<Player, InputType_Text> input_text = new HashMap<>();

    public static void InputCatch(Player p, InputType_All type) {
        if (registered == true) {
            input_all.put(p, type);
            input_number.remove(p);
            input_text.remove(p);
            sendPlayerMessage(p, type.getStart());
        } else {
            InputCore.InputCoreLog("&cYou need to register InputCore");
        }
    }

    public static void InputCatch(Player p, InputType_Text type) {
        if (registered == true) {
            input_text.put(p, type);
            input_all.remove(p);
            input_number.remove(p);
            sendPlayerMessage(p, type.getStart());
        } else {
            InputCore.InputCoreLog("&cYou need to register InputCore");
        }
    }

    public static void InputCatch(Player p, InputType_Number type) {
        if (registered == true) {
            input_number.put(p, type);
            input_all.remove(p);
            input_text.remove(p);
            sendPlayerMessage(p, type.getStart());
        } else {
            InputCore.InputCoreLog("&cYou need to register InputCore");
        }
    }
}
