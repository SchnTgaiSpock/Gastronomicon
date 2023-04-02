package io.github.schntgaispock.gastronomicon.core.command;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.mooy1.infinitylib.core.AddonConfig;
import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.items.food.GastroFood;
import io.github.schntgaispock.gastronomicon.util.collections.CollectionUtil;

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
                            Gastronomicon.sendMessage(player, "The help section is a WIP! " +
                                "For now, please see https://github.com/SchnTgaiSpock/Gastronomicon");
                            return true;

                        case "profile":
                            if (!Gastronomicon.checkPermission(
                                player,
                                "gastronomicon.checkprofile",
                                "§#4ee530§lGastronomicon&7> &cYou do not have perission to check your profile!"))
                                return true;
                            Gastronomicon.sendMessage(player, "§#4ee530Proficiencies:");
                            sendProficiencies(player, player);
                            Gastronomicon.sendMessage(player, "§#4ee530Skills:");
                            sendSkills(player, player);
                            return true;
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

                            Gastronomicon.sendMessage(player, "§#4ee530" + toCheck.getName() + "'s Proficiencies:");
                            sendProficiencies(player, toCheck);
                            Gastronomicon.sendMessage(player, "§#4ee530" + toCheck.getName() + "'s Skills:");
                            sendSkills(player, toCheck);

                            return true;
                    }

                case 5:
                    AddonConfig playerData = Gastronomicon.getInstance().getPlayerData();
                    if ((args[0].equals("set") || args[2].equals("modify")) && args[1].equals("proficiency")) {
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

                    }

                    return false;

                default:
                    break;
            }
        }

        return false;

    }

    private void sendProficiencies(Player player, Player toCheck) {
        Gastronomicon.sendMessage(player, Gastronomicon.getInstance().getPlayerData()
            .getObject(player.getUniqueId() + ".proficiencies", HashMap.class).toString());
    }

    private void sendSkills(Player player, Player toCheck) {
        Gastronomicon.sendMessage(player, CollectionUtil.commaJoin(Gastronomicon.getInstance().getPlayerData()
            .getList(player.getUniqueId() + ".skill-profile.learned-skills").toArray()));
    }

    private void sendInfo(Player player) {
        player.sendMessage(
            "",
            "§#c91df4§lGastronomicon §8- §7Version " + Gastronomicon.getInstance().getPluginVersion(),
            "§f------",
            "§#c91df4§lWiki §f- §7https://github.com/SchnTgaiSpock/Gastronomicon/wiki",
            "§#c91df4§lIssues §f- §7https://github.com/SchnTgaiSpock/Gastronomicon/issues",
            "");
    }

}
