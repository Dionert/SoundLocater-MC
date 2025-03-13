package nl.dionnek.soundLocater.sound;

public class SoundSource {
    private final double x, y, z;
    private final String soundName;
    private final float volume;
    private final float pitch;
    private final int interval;

    public SoundSource(double x, double y, double z, String soundName, float volume, float pitch, int interval) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.soundName = soundName;
        this.volume = volume;
        this.pitch = pitch;
        this.interval = interval;
    }


    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }


    public double getZ() {
        return z;
    }


    public String getSoundName() {
        return soundName;
    }


    public float getVolume() {
        return volume;
    }


    public float getPitch() {
        return pitch;
    }


    public int getInterval() {
        return interval;
    }
}
