package nguyenkhoi.InputCore;

import nguyenkhoi.InputCore.InputCatcher.InputListener;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import static nguyenkhoi.InputCore.Util.colorize;

public class InputCore {
    public static boolean papistatus = false;
    public static boolean registered = false;
    private static JavaPlugin instance;

    public static JavaPlugin getInstance() {
        return instance;
    }

    public static String getInputCoreVersion() {
        return "v0.1";
    }

    public static void InputCoreLog(String... message) {
        for (String messages : message) {
            ConsoleCommandSender css = Bukkit.getConsoleSender();
            for (String s : message) {
                css.sendMessage(colorize(s));
            }
        }
    }

    public static void RegisterInputCore(JavaPlugin core) {
        InputCoreLog("&3" + core.getDescription().getName() + " is using InputCore " + getInputCoreVersion());
        papistatus = Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
        instance = core;
        registered = true;
        Bukkit.getPluginManager().registerEvents(new InputListener(), core);
    }
}
