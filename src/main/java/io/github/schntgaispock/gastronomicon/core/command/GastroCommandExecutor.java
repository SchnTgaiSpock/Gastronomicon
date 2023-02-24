package io.github.schntgaispock.gastronomicon.core.command;

import java.util.HashMap;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.mooy1.infinitylib.core.AddonConfig;
import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.items.food.GastroFood;
import io.github.schntgaispock.gastronomicon.util.CollectionUtil;

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
                    switch (args[0]) {
                        case "help":
                            player.sendMessage("The help section is a WIP! " +
                                    "For now, please see https://github.com/SchnTgaiSpock/Gastronomicon");
                            return true;

                        case "profile":
                            if (!Gastronomicon.checkPermission(
                                    player,
                                    "gastronomicon.checkprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check your profile!"))
                                return true;
                            player.sendMessage("§#4ee530Proficiencies:");
                            sendProficiencies(player, player);
                            player.sendMessage("§#4ee530Skills:");
                            sendSkills(player, player);
                            return true;
                        case "skills":
                            if (!Gastronomicon.checkPermission(
                                    player,
                                    "gastronomicon.checkprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check your skills!"))
                                return true;
                            sendSkills(player, player);
                            return true;

                        case "proficiencies":
                            if (!Gastronomicon.checkPermission(
                                    player,
                                    "gastronomicon.checkprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check your proficiencies!"))
                                return true;
                            sendProficiencies(player, player);
                            return true;

                        default:
                            return false;
                    }

                case 2:
                    switch (args[0]) {
                        case "profile":
                            if (!Gastronomicon.checkPermission(
                                    player,
                                    "gastronomicon.checkotherprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check another player's profile!"))
                                return true;

                            Player toCheck = Bukkit.getServer().getPlayer(args[1]);
                            if (toCheck == null)
                                return false;

                            player.sendMessage("§#4ee530" + toCheck.getName() + "'s Proficiencies:");
                            sendProficiencies(player, toCheck);
                            player.sendMessage("§#4ee530" + toCheck.getName() + "'s Skills:");
                            sendSkills(player, toCheck);

                            return true;

                        case "skills":
                            if (!Gastronomicon.checkPermission(
                                    player,
                                    "gastronomicon.checkotherprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check another player's skills!"))
                                return true;

                            toCheck = Bukkit.getServer().getPlayer(args[1]);
                            if (toCheck == null)
                                return false;

                            sendSkills(player, toCheck);

                            return true;

                        case "proficiencies":
                            if (!Gastronomicon.checkPermission(
                                    player,
                                    "gastronomicon.checkotherprofile",
                                    "§#4ee530§lGastronomicon&7> &cYou do not have perission to check another player's proficiencies!"))
                                return true;

                            toCheck = Bukkit.getServer().getPlayer(args[1]);
                            if (toCheck == null)
                                return false;

                            sendProficiencies(player, toCheck);

                            return true;

                        default:
                            return false;
                    }

                case 5:
                    AddonConfig playerData = Gastronomicon.getInstance().getPlayerData();
                    switch (args[0]) {
                        case "set", "modify":
                            if (args[1].equals("proficiency")) {
                                final String foodId = args[2];
                                final String amount = args[3];
                                final String playerName = args[4];

                                if (!GastroFood.getGastroFoodIds().contains(foodId))
                                    return false;

                                try {
                                    Integer.parseInt(amount);
                                } catch (NumberFormatException e) {
                                    return false;
                                }

                                final Player toModify = Bukkit.getServer().getPlayer(playerName);
                                if (toModify == null)
                                    return false;

                                if (!Gastronomicon.checkPermission(
                                        player,
                                        "gastronomicon.checkotherprofile",
                                        "§#4ee530§lGastronomicon&7> &cYou do not have perission to modify another player's proficiencies!"))
                                    return true;

                                final String proficiencyPath = player.getUniqueId() + ".proficiencies." + foodId;
                                if (args[0].equals("set")) {
                                    playerData.set(proficiencyPath, amount);
                                } else if (args[0].equals("modify")) {
                                    playerData.set(proficiencyPath, playerData.getInt(proficiencyPath) + amount);
                                }

                                playerData.save();

                                return true;

                            } else if (args[1].equals("skill")) {
                                final String skillName = args[2];
                                final String action = args[3];
                                final String playerName = args[4];

                                if (!GastroFood.getSkills().contains(skillName))
                                    return false;

                                final Player toModify = Bukkit.getServer().getPlayer(playerName);
                                if (toModify == null)
                                    return false;

                                if (!Gastronomicon.checkPermission(
                                        player,
                                        "gastronomicon.checkotherprofile",
                                        "§#4ee530§lGastronomicon&7> &cYou do not have perission to modify another player's skills!"))
                                    return true;

                                final String skillsPath = player.getUniqueId() + ".skill-profile.learned-skills";
                                final Set<String> skillsList = Set
                                        .of((playerData.getList(skillsPath)).toArray(String[]::new));
                                if (action.equals("on")) {
                                    skillsList.add(skillName);
                                } else if (action.equals("off")) {
                                    skillsList.remove(skillName);
                                } else {
                                    return false;
                                }

                                return true;
                            }

                        default:
                            return false;
                    }
                default:
                    break;
            }
        }

        return false;

    }

    private void sendProficiencies(Player player, Player toCheck) {
        player.sendMessage(Gastronomicon.getInstance().getPlayerData()
                .getObject(player.getUniqueId() + ".proficiencies", HashMap.class).toString());
    }

    private void sendSkills(Player player, Player toCheck) {
        player.sendMessage(CollectionUtil.commaJoin(Gastronomicon.getInstance().getPlayerData()
                .getList(player.getUniqueId() + ".skill-profile.learned-skills").toArray()));
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
