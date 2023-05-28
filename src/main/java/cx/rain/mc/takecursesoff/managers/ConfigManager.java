package cx.rain.mc.takecursesoff.managers;

import cx.rain.mc.takecursesoff.Constants;
import cx.rain.mc.takecursesoff.TakeTheCursesOff;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private final FileConfiguration config;

    public ConfigManager(TakeTheCursesOff plugin) {
        config = plugin.getConfig();
    }

    public void load() {
    }

    public void save() {
    }

    public String getTranslated(String key, Object... params) {
        var translate = config.getString(Constants.MESSAGE_ROOT + "." + key);
        if (translate == null) {
            translate = "";
        }
        return String.format(translate, params);
    }
}
