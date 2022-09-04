package nguyenkhoi.InputCore;

import org.bukkit.entity.Player;

import java.util.HashMap;

import static nguyenkhoi.InputCore.InputCore.registered;
import static nguyenkhoi.InputCore.Util.sendPlayerMessage;

public class Main {
    protected static HashMap<Player, InputType_All> input_all = new HashMap<>();
    protected static HashMap<Player, InputType_Number> input_number = new HashMap<>();
    protected static HashMap<Player, InputType_Text> input_text = new HashMap<>();

    public static void InputCatch(Player p, InputType_All type) {
        if (registered) {
            input_all.put(p, type);
            input_number.remove(p);
            input_text.remove(p);
            sendPlayerMessage(p, type.getStart());
        }
    }

    public static void InputCatch(Player p, InputType_Text type) {
        if (registered) {
            input_text.put(p, type);
            input_all.remove(p);
            input_number.remove(p);
            sendPlayerMessage(p, type.getStart());
        }
    }

    public static void InputCatch(Player p, InputType_Number type) {
        if (registered) {
            input_number.put(p, type);
            input_all.remove(p);
            input_text.remove(p);
            sendPlayerMessage(p, type.getStart());
        }
    }
}
