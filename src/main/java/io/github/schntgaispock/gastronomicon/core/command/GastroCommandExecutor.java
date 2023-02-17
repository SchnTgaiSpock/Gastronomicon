package io.github.schntgaispock.gastronomicon.core.command;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.util.GastroUtil;

/**
 * Functionality for the '/gastronomicon' command
 */
public class GastroCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof final Player player) {
            switch (args.length) {
                case 0:
                    sendInfo(player);
                    return true;

                case 1:
                    final UUID uuid = player.getUniqueId();
                    switch (args[0]) {
                        case "profile":
                            if (!GastroUtil.checkPermission(
                                    player,
                                    "gastronomicon.checkprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check another player's profile"))
                                return true;
                            player.sendMessage("§#4ee530Proficiencies:");
                            sendProficiencies(uuid);
                            player.sendMessage("§#4ee530Skills:");
                            sendSkills(uuid);
                            return true;
                        case "skills":
                            if (!GastroUtil.checkPermission(
                                    player,
                                    "gastronomicon.checkprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check another player's profile"))
                                return true;
                            sendSkills(uuid);
                            return true;

                        case "proficiencies":
                            if (!GastroUtil.checkPermission(
                                    player,
                                    "gastronomicon.checkprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check another player's profile"))
                                return true;
                            sendProficiencies(uuid);
                            return true;

                        default:
                            return false;
                    }

                case 2:
                    switch (args[0]) {
                        case "profile":
                            if (!GastroUtil.checkPermission(
                                    player,
                                    "gastronomicon.checkotherprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check your profile"))
                                return true;

                            // TODO: Check another players profile
                        case "skills":
                            if (!GastroUtil.checkPermission(
                                    player,
                                    "gastronomicon.checkotherprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check your skills"))
                                return true;

                            // TODO: Check another players skills
                        case "proficiencies":
                            if (!GastroUtil.checkPermission(
                                    player,
                                    "gastronomicon.checkotherprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check your proficiencies"))
                                return true;

                            // TODO: Check another players prof

                        default:
                            return false;
                    }

                case 5:
                    if (args[0].equals("set")) {

                        if (args[1].equals("proficiency")) {
                            final String food = args[2];
                            final String amount = args[3];
                            final String playerName = args[4];

                            // TODO: Check if food is a gastronomicon food

                            try {
                                Integer.parseInt(amount);
                            } catch (NumberFormatException e) {
                                return false;
                            }

                            final Player toModify = Bukkit.getServer().getPlayer(playerName);
                            if (toModify == null)
                                return false;

                            // TODO: Set proficiency

                            return true;
                        } else if (args[1].equals("skill")) {
                            final String skillName = args[2];
                            final String onOff = args[3];
                            final String playerName = args[4];

                            // TODO: Check if skill is valid

                            final Player toModify = Bukkit.getServer().getPlayer(playerName);
                            if (toModify == null)
                                return false;

                            if (onOff.equals("on")) {
                                // TODO: on
                            } else if (onOff.equals("off")) {
                                // TODO: off
                            }

                            return true;
                        } else
                            return false;
                    } else if (args[0].equals("modify")) {
                        return true;
                    } else
                        return false;

                default:
                    break;
            }
        }

        return false;

    }

    private void sendProficiencies(UUID player) {
        
    }

    private void sendSkills(UUID player) {

    }

    private void sendInfo(Player player) {
        player.sendMessage(
                "",
                "§#4ee530§lGastronomicon §8- §7Version " + Gastronomicon.getInstance().getPluginVersion(),
                "§f------",
                "§#4ee530§lWiki §f- §7https://github.com/SchnTgaiSpock/Gastronomicon/wiki",
                "§#4ee530§lIssues §f- §7https://github.com/SchnTgaiSpock/Gastronomicon/issues",
                "");
    }

}
