package cx.rain.mc.takecursesoff;

import cx.rain.mc.takecursesoff.listener.EventTakeOff;
import org.bukkit.plugin.java.JavaPlugin;

public class TakeTheCursesOff extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventTakeOff(), this);
    }

    @Override
    public void onDisable() {

    }
}
