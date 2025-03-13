package nl.dionnek.soundLocater.commands;

import nl.dionnek.soundLocater.SoundLocater;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SoundReloadCommand implements CommandExecutor {
    private final SoundLocater plugin;

    public SoundReloadCommand(SoundLocater plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && !sender.hasPermission("customsounds.reload")) {
            sender.sendMessage("You do not have permission to use this command.");
            return true;
        }
        plugin.reloadSounds();
        sender.sendMessage("Sound configuration reloaded!");
        return true;
    }
}
