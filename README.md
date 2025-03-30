# SoundLocater Minecraft Plugin

**SoundLocater** is a Minecraft plugin that allows you to play sounds every 5 or 10 seconds at specific coordinates in your world. It provides simple configuration via a YAML file, allowing you to play various sounds with custom intervals, volume, and pitch.

With **SoundLocater**, you can have sounds played at different locations, and you have the ability to easily reload this configuration without restarting your server.

## Features

- **Play sounds at specific locations**: Define coordinates for sounds in the world.
- **Custom intervals**: Set how often sounds should be played (every 5 or 10 seconds).
- **Volume and pitch**: Configure the volume and pitch settings for each sound.
- **Reload configuration with a command**: You can easily reload sound settings without restarting your server.
- **Use of existing Minecraft sounds**: Use standard sounds supported by Minecraft.

## Configuration

The sound settings are defined in the `config.yml` file. This file contains the coordinates of the sounds, the name of the sound, the volume, pitch, and the interval at which the sounds should be played.

### Example of `config.yml`

```yaml
sounds:
  sound1:
    x: 86.0
    y: 66.0
    z: -187.0
    name: "ENTITY_HORSE_AMBIENT"
    volume: 1.0
    pitch: 1.0
    interval: 10

  sound2:
    x: 150.0
    y: 64.0
    z: 250.0
    name: "ENTITY_COW_AMBIENT"
    volume: 0.5
    pitch: 1.2
    interval: 5
```

## Configuration Parameters

- **x, y, z**: The coordinates in the world where the sound will be played.
- **name**: The name of the sound to be played (e.g., ENTITY_HORSE_AMBIENT).
- **volume**: The volume of the sound (between 0.0 and 1.0).
- **pitch**: The pitch of the sound (default is 1.0 for normal).
- **interval**: The interval (in seconds) at which the sound will be repeated (e.g., 5 or 10 seconds).

## Available Sounds

The names of the sounds must match the sounds supported by Minecraft.

## Commands

### `/reloadsounds`
Reload the sound configuration of the plugin without restarting the server.

**Required Permission**: `customsounds.reload`

## NOTE 
(This plugin was used on a roleplay server where sounds were played every 5/10 seconds. I will later add the ability to use different intervals & worlds.)
