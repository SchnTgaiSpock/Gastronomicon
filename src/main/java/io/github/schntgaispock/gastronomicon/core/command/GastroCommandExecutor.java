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

/**
 * Functionality for the '/gastronomicon' command
 */
public class GastroCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof final Player player))
            return false;

        switch (args.length) {
            case 0:
                sendInfo(player);
                return true;

            case 1:
                switch (args[0]) {
                    case "help":
                        sendHelp(player);
                        return true;

                    case "profile":
                        return commandProfile(player);

                    case "credits":
                        sendCredits(player);
                        return true;

                    default:
                        return false;
                }

            case 2:
                switch (args[0]) {
                    case "profile":
                        final Player toCheck = Bukkit.getServer().getPlayer(args[1]);
                        if (toCheck == null) {
                            Gastronomicon.sendMessage(player, "&cUnknown player!");
                            return true;
                        }
                        return commandProfile(player, toCheck);

                    default:
                        return false;
                }

            case 4:
                if (args[0].equals("proficiency") && args[1].equals("get")) {
                    final Player target = Bukkit.getServer().getPlayerExact(args[3]);
                    if (target == null)
                        return false;
                    if (target.getUniqueId() == player.getUniqueId()) {
                        return commandProficiencyGet(player, args[2]);
                    } else {
                        return commandProficiencyGet(player, target, args[2]);
                    }

                }
                return false;

            case 5:
                switch (args[0]) {
                    case "proficiency":
                        if (!Gastronomicon.checkPermission(
                            player,
                            "gastronomicon.modifyprofile",
                            "§#4ee530§lGastronomicon&7> &cYou do not have permission to modify profiles!"))
                            return true;
                            
                        final int amount;
                        try {
                            amount = Integer.parseInt(args[3]);
                        } catch (NumberFormatException e) {
                            return false;
                        }
                        if (amount < 0)
                            return false;

                        final Player target = Bukkit.getServer().getPlayerExact(args[4]);
                        if (target == null)
                            return false;

                        final String foodId = args[2];
                        if (!GastroFood.getGastroFoodIds().stream().filter(str -> !str.startsWith("GN_PERFECT"))
                            .anyMatch(str -> str.equals(foodId))) {
                            return true;
                        }
                        return commandProficiencyModify(player, target, args[1], foodId, amount);

                    default:
                        return false;
                }

            default:
                return false;
        }
    }

    private void sendProficiencies(Player player, Player toCheck) {
        Gastronomicon.sendMessage(player, Gastronomicon.getInstance().getPlayerData()
            .getObject(player.getUniqueId() + ".proficiencies", HashMap.class).toString());
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

    private void sendHelp(Player player) {
        Gastronomicon.sendMessage(player, "The help section is a WIP! " +
            "For now, please see https://github.com/SchnTgaiSpock/Gastronomicon");
    }

    private void sendCredits(Player player) {
        player.sendMessage(
            "§#c91df4§lGastronomicon §8- §7Credits:",
            "§f------",
            "§7Some head textures were taken and/or modified from https://minecraft-heads.com/ and https://headdb.org/");
    }

    private boolean commandProfile(Player player) {
        if (!Gastronomicon.checkPermission(
            player,
            "gastronomicon.checkprofile",
            "§#4ee530§lGastronomicon&7> &cYou do not have perission to check your profile!"))
            return true;
        Gastronomicon.sendMessage(player, "§#4ee530Proficiencies:");
        sendProficiencies(player, player);
        return true;
    }

    private boolean commandProfile(Player player, Player other) {
        if (!Gastronomicon.checkPermission(
            player,
            "gastronomicon.checkotherprofile",
            "§#4ee530§lGastronomicon&7> &cYou do not have perission to check another player's profile!"))
            return true;

        Gastronomicon.sendMessage(player, "§#4ee530" + other.getName() + "'s Proficiencies:");
        sendProficiencies(player, other);
        return true;
    }

    private boolean commandProficiencyGet(Player player, String foodId) {
        if (!Gastronomicon.checkPermission(
            player,
            "gastronomicon.checkprofile",
            "§#4ee530§lGastronomicon&7> &cYou do not have perission to check your profile!"))
            return true;

        if (!GastroFood.getGastroFoodIds().stream().filter(str -> !str.startsWith("GN_PERFECT"))
            .anyMatch(str -> str.equals(foodId))) {
            Gastronomicon.sendMessage(player, "&cUnknown food!");
            return true;
        }
        final AddonConfig playerData = Gastronomicon.getInstance().getPlayerData();
        final int prof = playerData.getInt(player.getUniqueId().toString() + "proficiencies" + foodId, 0);
        Gastronomicon.sendMessage(player, foodId + ": " + prof);
        return true;
    }

    private boolean commandProficiencyGet(Player player, Player other, String foodId) {
        if (!Gastronomicon.checkPermission(
            player,
            "gastronomicon.checkotherprofile",
            "§#4ee530§lGastronomicon&7> &cYou do not have perission to check another player's profile!"))
            return true;

        if (!GastroFood.getGastroFoodIds().stream().filter(str -> !str.startsWith("GN_PERFECT"))
            .anyMatch(str -> str.equals(foodId))) {
            Gastronomicon.sendMessage(player, "&cUnknown food!");
            return true;
        }
        final AddonConfig playerData = Gastronomicon.getInstance().getPlayerData();
        final int prof = playerData.getInt(player.getUniqueId().toString() + "proficiencies" + foodId, 0);
        Gastronomicon.sendMessage(player, foodId + ": " + prof);
        return true;
    }

    private boolean commandProficiencyModify(Player player, Player other, String mode, String foodId, int amount) {
        final AddonConfig playerData = Gastronomicon.getInstance().getPlayerData();
        final String proficiencyPath = player.getUniqueId() + ".proficiencies." + foodId;
        switch (mode) {
            case "set":
                playerData.set(proficiencyPath, amount);
                break;
            case "add":
                playerData.set(proficiencyPath, playerData.getInt(proficiencyPath) + amount);
                break;
            case "sub":
                playerData.set(proficiencyPath,
                    Math.min(playerData.getInt(proficiencyPath) - amount, 0));
                break;

            default:
                return false;
        }
        playerData.save();
        return true;
    }

}
