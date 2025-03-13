package nl.dionnek.soundLocater.config;

import nl.dionnek.soundLocater.SoundLocater;
import nl.dionnek.soundLocater.sound.SoundSource;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class SoundLocaterConfig {
    private final SoundLocater plugin;
    private List<SoundSource> soundSources;


    public SoundLocaterConfig(SoundLocater plugin) {
        this.plugin = plugin;
        load();
    }




    /**
     * Loads the sound configuration into memory.
     */
    public void load() {
        soundSources = new ArrayList<>();
        FileConfiguration config = plugin.getConfig();

        if (config.contains("sounds")) {
            for (String key : config.getConfigurationSection("sounds").getKeys(false)) {
                double x = config.getDouble("sounds." + key + ".x");
                double y = config.getDouble("sounds." + key + ".y");
                double z = config.getDouble("sounds." + key + ".z");
                String sound = config.getString("sounds." + key + ".name");
                float volume = (float) config.getDouble("sounds." + key + ".volume");
                float pitch = (float) config.getDouble("sounds." + key + ".pitch");
                int interval = config.getInt("sounds." + key + ".interval");

                soundSources.add(new SoundSource(x, y, z, sound, volume, pitch, interval));
            }
        }
    }



    /**
     * Reloads the sound configuration.
     */
    public void reload() {
        plugin.reloadConfig();
        load();
    }




    public List<SoundSource> getSoundSources() {
        return soundSources != null ? soundSources : new ArrayList<>();
    }
}

