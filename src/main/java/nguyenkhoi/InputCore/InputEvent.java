package nguyenkhoi.InputCore;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class InputEvent {
    private final Player p;
    private final String i;
    private static final HandlerList handlers = new HandlerList();

    public InputEvent(Player player, String raw_input) {
        this.p = player;
        this.i = raw_input;
    }

    public Player getPlayer() {
        return p;
    }

    public String getRawInput() {
        return i;
    }

    public byte getByteInput() {
        return Byte.parseByte(i);
    }

    public short getShortInput() {
        return Short.parseShort(i);
    }

    public int getIntegerInput() {
        return Integer.parseInt(i);
    }

    public long getLongInput() {
        return Long.parseLong(i);
    }

    public float getFloatInput() {
        return Float.parseFloat(i);
    }

    public double getDoubleInput() {
        return Double.parseDouble(i);
    }
}
