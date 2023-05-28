package cx.rain.mc.takecursesoff;

import cx.rain.mc.takecursesoff.listener.EventTakeOff;
import cx.rain.mc.takecursesoff.managers.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TakeTheCursesOff extends JavaPlugin {
    private static TakeTheCursesOff INSTANCE;

    private final ConfigManager configManager;

    public TakeTheCursesOff() {
        INSTANCE = this;

        configManager = new ConfigManager(this);
    }

    public static TakeTheCursesOff getInstance() {
        return INSTANCE;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventTakeOff(this), this);
    }

    @Override
    public void onDisable() {

    }
}
