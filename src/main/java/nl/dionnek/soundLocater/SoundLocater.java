package nl.dionnek.soundLocater;

import nl.dionnek.soundLocater.commands.SoundReloadCommand;
import nl.dionnek.soundLocater.config.SoundLocaterConfig;
import nl.dionnek.soundLocater.sound.SoundScheduler;
import org.bukkit.plugin.java.JavaPlugin;

public final class SoundLocater extends JavaPlugin {

    private SoundLocaterConfig configLoader;
    private SoundScheduler soundScheduler;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        configLoader = new SoundLocaterConfig(this);
        soundScheduler = new SoundScheduler(this, configLoader);

        getCommand("reloadsounds").setExecutor(new SoundReloadCommand(this));
        soundScheduler.startSchedulers();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        soundScheduler.stopSchedulers();
    }


    public void reloadSounds() {
        reloadConfig();
        configLoader.reload();
        soundScheduler.restartSchedulers();
    }
}
