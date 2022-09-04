package nguyenkhoi.InputCore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class InputCore {

    protected static boolean papistatus = false;
    protected static boolean registered = false;
    private static JavaPlugin instance;

    public static JavaPlugin getInstance() {
        return instance;
    }

    public static String getInputCoreVersion() {
        return "v0.2";
    }

    public static void RegisterInputCore(JavaPlugin core) {
        papistatus = Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
        instance = core;
        registered = true;
        Bukkit.getPluginManager().registerEvents(new InputListener(), core);
    }
}
