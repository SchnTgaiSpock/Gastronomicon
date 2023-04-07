package io.github.schntgaispock.gastronomicon;

import java.util.logging.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bstats.bukkit.Metrics;
import org.bstats.charts.SimplePie;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.mooy1.infinitylib.core.AddonConfig;
import io.github.schntgaispock.gastronomicon.api.trees.TreeStructure;
import io.github.schntgaispock.gastronomicon.core.setup.CommandSetup;
import io.github.schntgaispock.gastronomicon.core.setup.ListenerSetup;
import io.github.schntgaispock.gastronomicon.core.setup.ResearchSetup;
import io.github.schntgaispock.gastronomicon.core.setup.ItemSetup;
import io.github.schntgaispock.gastronomicon.integration.DynaTechSetup;
import io.github.schntgaispock.gastronomicon.integration.SlimeHUDSetup;
import io.github.schntgaispock.gastronomicon.util.StringUtil;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.md_5.bungee.api.ChatColor;

@Getter
public class Gastronomicon extends AbstractAddon {

    private static @Getter Gastronomicon instance;

    private AddonConfig playerData;
    private AddonConfig customFood;

    public Gastronomicon() {
        super("SchnTgaiSpock", "Gastronomicon", "master", "options.auto-update");
    }

    @Override
    public void enable() {
        instance = this;

        getLogger().info("#======================================#");
        getLogger().info("#    Gastronomicon by SchnTgaiSpock    #");
        getLogger().info("#======================================#");

        final Metrics metrics = new Metrics(this, 16941);

        metrics.addCustomChart(
            new SimplePie("exoticgardenInstalled", () -> Boolean.toString(isPluginEnabled("ExoticGarden"))));

        ItemSetup.setup();
        ResearchSetup.setup();
        ListenerSetup.setup();
        CommandSetup.setup();

        if (isPluginEnabled("SlimeHUD")) {
            try {
                log(Level.INFO, "SlimeHUD was found on this server!");
                log(Level.INFO, "Setting up Gastronomicon for SlimeHUD...");
                SlimeHUDSetup.setup();
            } catch (NoClassDefFoundError e) {
                log(Level.WARNING, "This server is using an incompatitable version of SlimeHUD");
                log(Level.WARNING, "Please update SlimeHUD to version 1.2.0 or higher!");
            }
        }

        if (!isPluginEnabled("ExoticGarden")) {
            log(Level.WARNING, "ExoticGarden was not found on this server!");
            log(Level.WARNING, "Recipes that require ExoticGarden items will be hidden.");
        }

        if (isPluginEnabled("DynaTech") && !getConfig().getBoolean("disable-dynatech-integration")) {
            try {
                log(Level.INFO, "DynaTech was found on this server!");
                log(Level.INFO, "Registering Gastronomicon crops with DynaTech...");
                DynaTechSetup.setup();
            } catch (NoClassDefFoundError e) {
                log(Level.WARNING, "This server is using an incompatitable version of DynaTech");
                log(Level.WARNING, "Please keep Gastronomicon and DynaTech up to date!");
            }
        }

        TreeStructure.loadTrees();

        playerData = new AddonConfig("player.yml");
        customFood = new AddonConfig("custom-food.yml");
    }

    @Override
    public void disable() {
        instance = null;
        getPlayerData().save();
    }

    public static NamespacedKey key(@Nonnull String name) {
        return new NamespacedKey(Gastronomicon.getInstance(), name);
    }

    public static boolean isPluginEnabled(String name) {
        return getInstance().getServer().getPluginManager().isPluginEnabled(name);
    }

    public static int scheduleSyncDelayedTask(Runnable runnable, long delay) {
        return Bukkit.getScheduler().scheduleSyncDelayedTask(getInstance(), runnable, delay);
    }

    public static boolean checkPermission(Player player, @Nonnull String permissionNode, @Nullable String message) {
        if (player.hasPermission(permissionNode)) {
            return true;
        }

        if (message != null)
            Gastronomicon.sendMessage(player, message);
        return false;

    }

    public static void info(String message) {
        getInstance().getLogger().info(message);
    }

    public static void warn(String message) {
        getInstance().getLogger().warning(message);
    }

    public static void error(String message) {
        getInstance().getLogger().severe(message);
    }

    public static void sendMessage(Player player, String message) {
        player.sendMessage(ChatColor.of("#c91df4") + "§lGastronomicon§7§l> §7" + StringUtil.formatColors(message));
    }

    public static void sendMessage(Player player, Component message) {
        final Component text = Component.text()
            .content("Gastronomicon")
            .color(TextColor.color(0xc9, 0x1d, 0xf4))
            .decorate(TextDecoration.BOLD)
            .append(Component.text()
                .content(">")
                .color(TextColor.color(0xaa, 0xaa, 0xaa))
                .decorate(TextDecoration.BOLD)
                .appendSpace()
                .asComponent())
            .asComponent();
        player.sendMessage(text);
    }
}
