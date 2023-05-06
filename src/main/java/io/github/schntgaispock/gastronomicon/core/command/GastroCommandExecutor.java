package io.github.schntgaispock.gastronomicon.core.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.mooy1.infinitylib.core.AddonConfig;
import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.api.items.GastroTheme;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.food.GastroFood;
import org.mini2Dx.gettext.GetText;

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
                            Gastronomicon.sendMessage(player, GetText.tr("&cUnknown player!"));
                            return true;
                        }
                        return commandProfile(player, toCheck);

                    default:
                        return false;
                }

            case 4:
                if (args[0].equals("proficiency") && args[1].equals("get")) {
                    final Player target = Bukkit.getServer().getPlayerExact(args[3]);
                    if (target == null) {
                        Gastronomicon.sendMessage(player, GetText.tr("&cUnknown player!"));
                        return false;
                    }
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
                            GastroTheme.PERFECT_FOOD.getColor()
                                + GetText.tr("§lGastronomicon&7> &cYou do not have permission to modify profiles!")))
                            return true;

                        final int amount;
                        try {
                            amount = Integer.parseInt(args[3]);
                        } catch (NumberFormatException e) {
                            Gastronomicon.sendMessage(player, GetText.tr("&cAmount must be a number!"));
                            return true;
                        }
                        if (amount < 0) {
                            Gastronomicon.sendMessage(player, GetText.tr("&cAmount must be positive!"));
                            return true;
                        }

                        final Player target = Bukkit.getServer().getPlayerExact(args[4]);
                        if (target == null) {
                            Gastronomicon.sendMessage(player, GetText.tr("&cUnknown player!"));
                            return true;
                        }

                        final String foodId = args[2];
                        if (!GastroFood.getGastroFoodIds().stream().filter(str -> !str.startsWith("GN_PERFECT"))
                            .anyMatch(str -> str.equals(foodId))) {
                            Gastronomicon.sendMessage(player, GetText.tr("&cUnknown food!"));
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
            .get(player.getUniqueId() + ".proficiencies", "Something went wrong!").toString());
    }

    private void sendInfo(Player player) {
        player.sendMessage(
            "",
            GastroTheme.PERFECT_FOOD.getColor() + GetText.tr("§lGastronomicon §8- §7Version ")
                + Gastronomicon.getInstance().getPluginVersion(),
            "§f------",
            GastroTheme.PERFECT_FOOD.getColor()
                + GetText.tr("§lWiki §f- §7https://github.com/SchnTgaiSpock/Gastronomicon/wiki"),
            GastroTheme.PERFECT_FOOD.getColor()
                + GetText.tr("§lIssues §f- §7https://github.com/SchnTgaiSpock/Gastronomicon/issues"),
            "");
    }

    private void sendHelp(Player player) {
        Gastronomicon.sendMessage(player, GetText.tr("The help section is a WIP! ") +
            GetText.tr("For now, please see https://github.com/SchnTgaiSpock/Gastronomicon"));
    }

    private void sendCredits(Player player) {
        player.sendMessage(
            GastroTheme.PERFECT_FOOD.getColor() + GetText.tr("§lGastronomicon §8- §7Credits:"),
            "§f------",
            GetText.tr("§7Some head textures were taken and/or modified from https://minecraft-heads.com/ and https://headdb.org/"));
    }

    private boolean commandProfile(Player player) {
        if (!Gastronomicon.checkPermission(
            player,
            "gastronomicon.checkprofile",
            GastroTheme.PERFECT_FOOD.getColor()
                + GetText.tr("§lGastronomicon&7> &cYou do not have permission to check your profile!")))
            return true;
        Gastronomicon.sendMessage(player, GetText.tr("Proficiencies:"));
        sendProficiencies(player, player);
        return true;
    }

    private boolean commandProfile(Player player, Player other) {
        if (!Gastronomicon.checkPermission(
            player,
            "gastronomicon.checkotherprofile",
            GastroTheme.PERFECT_FOOD.getColor()
                + GetText.tr("§lGastronomicon&7> &cYou do not have permission to check another player's profile!")))
            return true;

        Gastronomicon.sendMessage(player, other.getName() + GetText.tr("'s Proficiencies:"));
        sendProficiencies(player, other);
        return true;
    }

    private boolean commandProficiencyGet(Player player, String foodId) {
        if (!Gastronomicon.checkPermission(
            player,
            "gastronomicon.checkprofile",
            GastroTheme.PERFECT_FOOD.getColor()
                + GetText.tr("§lGastronomicon&7> &cYou do not have permission to check your profile!")))
            return true;

        if (!GastroFood.getGastroFoodIds().stream().filter(str -> !str.startsWith("GN_PERFECT"))
            .anyMatch(str -> str.equals(foodId))) {
            Gastronomicon.sendMessage(player, GetText.tr("&cUnknown food!"));
            return true;
        }
        final AddonConfig playerData = Gastronomicon.getInstance().getPlayerData();
        final int prof = playerData.getInt(player.getUniqueId().toString() + ".proficiencies." + foodId, 0);
        Gastronomicon.sendMessage(player, foodId + ": " + prof);
        return true;
    }

    private boolean commandProficiencyGet(Player player, Player other, String foodId) {
        if (!Gastronomicon.checkPermission(
            player,
            "gastronomicon.checkotherprofile",
            GastroTheme.PERFECT_FOOD.getColor()
                + GetText.tr("§lGastronomicon&7> &cYou do not have permission to check another player's profile!")))
            return true;

        if (!GastroFood.getGastroFoodIds().stream().filter(str -> !str.startsWith("GN_PERFECT"))
            .anyMatch(str -> str.equals(foodId))) {
            Gastronomicon.sendMessage(player, GetText.tr("&cUnknown food!"));
            return true;
        }
        final AddonConfig playerData = Gastronomicon.getInstance().getPlayerData();
        final int prof = playerData.getInt(other.getUniqueId().toString() + ".proficiencies." + foodId, 0);
        Gastronomicon.sendMessage(player, foodId + ": " + prof);
        return true;
    }

    private boolean commandProficiencyModify(Player player, Player other, String mode, String foodId, int amount) {
        final AddonConfig playerData = Gastronomicon.getInstance().getPlayerData();
        final String proficiencyPath = player.getUniqueId() + ".proficiencies." + foodId;
        switch (mode) {
            case "set":
                playerData.set(proficiencyPath, amount);
                Gastronomicon.sendMessage(player,
                    GetText.tr("Successefully set {0} proficiency to {1} for {2}", foodId, amount, other.getName()));
                break;
            case "add":
                playerData.set(proficiencyPath, playerData.getInt(proficiencyPath, 0) + amount);
                Gastronomicon.sendMessage(player,
                    GetText.tr("Successefully added {0} {1} proficiency for {2}", amount, foodId, other.getName()));
                break;
            case "sub":
                playerData.set(proficiencyPath,
                    Math.min(playerData.getInt(proficiencyPath, 0) - amount, 0));
                Gastronomicon.sendMessage(player,
                    GetText.tr("Successefully removed {0} {1} proficiency for {2}", amount, foodId, other.getName()));
                break;

            default:
                Gastronomicon.sendMessage(player, GetText.tr("Unknown mode!"));
                return false;
        }
        playerData.save();
        return true;
    }

}
