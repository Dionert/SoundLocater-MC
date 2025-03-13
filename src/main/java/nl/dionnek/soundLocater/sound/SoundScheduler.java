package nl.dionnek.soundLocater.sound;

import nl.dionnek.soundLocater.SoundLocater;
import nl.dionnek.soundLocater.config.SoundLocaterConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;

public class SoundScheduler {
    private final SoundLocater plugin;
    private final SoundLocaterConfig configLoader;
    private BukkitTask task5s;
    private BukkitTask task10s;

    public SoundScheduler(SoundLocater plugin, SoundLocaterConfig configLoader) {
        this.plugin = plugin;
        this.configLoader = configLoader;
    }



    /**
     * Starts scheduled tasks to play sounds.
     */
    public void startSchedulers() {
        task5s = Bukkit.getScheduler().runTaskTimer(plugin, () -> playSounds(5), 0L, 100L);
        task10s = Bukkit.getScheduler().runTaskTimer(plugin, () -> playSounds(10), 0L, 200L);
    }



    /**
     * Stops all running sound schedulers.
     */
    public void stopSchedulers() {
        if (task5s != null) task5s.cancel();
        if (task10s != null) task10s.cancel();
    }



    /**
     * Restarts the schedulers by stopping and starting them again.
     */
    public void restartSchedulers() {
        stopSchedulers();
        startSchedulers();
    }



    /**
     * Plays sounds at their respective locations based on their interval.
     *
     * @param interval The interval (5s or 10s) at which to play sounds.
     */
    private void playSounds(int interval) {
        List<SoundSource> sources = configLoader.getSoundSources();
        for (SoundSource source : sources) {
            if (source.getInterval() == interval) {
                World world = Bukkit.getWorlds().get(0);
                Location loc = new Location(world, source.getX(), source.getY(), source.getZ());
                world.playSound(loc, Sound.valueOf(source.getSoundName()), source.getVolume(), source.getPitch());
            }
        }
    }
}
