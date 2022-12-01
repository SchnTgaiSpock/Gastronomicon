package io.github.schntgaispock.gastronomicon.core.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.schntgaispock.gastronomicon.Gastronomicon;

/**
 * Functionality for the '/sastronomicon' command
 */
public class GastroCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                sendInfo(player);
                return true;
            }
        }

        return false;
    }

    private void sendInfo(Player player) {
        player.sendMessage(
            "",
            "§#4ee530§lGastronomicon §8- §7Version " + Gastronomicon.getInstance().getPluginVersion(),
            "§f------",
            "§#4ee530§lWiki §f- §7https://github.com/SchnTgaiSpock/Gastronomicon/wiki",
            "§#4ee530§lIssues §f- §7https://github.com/SchnTgaiSpock/Gastronomicon/issues",
            ""
        );
    }
    
}
