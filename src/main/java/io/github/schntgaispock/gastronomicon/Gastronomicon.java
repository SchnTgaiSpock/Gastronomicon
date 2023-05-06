package io.github.schntgaispock.gastronomicon;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.logging.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.SimplePie;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

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
import org.mini2Dx.gettext.GetText;
import org.mini2Dx.gettext.PoFile;

@Getter
public class Gastronomicon extends AbstractAddon {

    private static @Getter Gastronomicon instance;

    private AddonConfig playerData;
    private AddonConfig customFood;

    public Gastronomicon() {
        super("SlimeTraditionalTranslation", "Gastronomicon", "master", "options.auto-update");
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

        GetText.setLocale(Locale.TRADITIONAL_CHINESE);
        InputStream inputStream = getClass().getResourceAsStream("/translations/zh_tw.po");
        if (inputStream == null) {
            getLogger().severe("錯誤！無法找到翻譯檔案，請回報給翻譯者。");
            getServer().getPluginManager().disablePlugin(this);
            return;
        } else {
            getLogger().info("載入繁體翻譯檔案...");
            try {
                PoFile poFile = new PoFile(Locale.TRADITIONAL_CHINESE, inputStream);
                GetText.add(poFile);
            } catch (ParseCancellationException | IOException e) {
                getLogger().severe("錯誤！讀取翻譯時發生錯誤，請回報給翻譯者：" + e.getMessage());
                getServer().getPluginManager().disablePlugin(this);
                return;
            }
        }

        ItemSetup.setup();
        ResearchSetup.setup();
        ListenerSetup.setup();
        CommandSetup.setup();

        if (isPluginEnabled("SlimeHUD")) {
            try {
                log(Level.INFO, GetText.tr("SlimeHUD was found on this server!"));
                log(Level.INFO, GetText.tr("Setting up Gastronomicon for SlimeHUD..."));
                SlimeHUDSetup.setup();
            } catch (NoClassDefFoundError e) {
                log(Level.WARNING, GetText.tr("This server is using an incompatitable version of SlimeHUD"));
                log(Level.WARNING, GetText.tr("Please update SlimeHUD to version 1.2.0 or higher!"));
            }
        }
        
        // If disable-exotic-garden-recipes is true "!" will change it to false and the rest of the code won't run.
        // If disable-exotic-garden-recipes is false "!" will change it to true and the rest of the code will run checking for ExoticGarden.
        
        if (!getConfig().getBoolean("disable-exotic-garden-recipes") && !isPluginEnabled("ExoticGarden")) {
            log(Level.WARNING, GetText.tr("ExoticGarden was not found on this server!"));
            log(Level.WARNING, GetText.tr("Recipes that require ExoticGarden items will be hidden."));
        }

        if (isPluginEnabled("DynaTech") && !getConfig().getBoolean("disable-dynatech-integration")) {
            try {
                log(Level.INFO, GetText.tr("DynaTech was found on this server!"));
                log(Level.INFO, GetText.tr("Registering Gastronomicon crops with DynaTech..."));
                DynaTechSetup.setup();
            } catch (NoClassDefFoundError e) {
                log(Level.WARNING, GetText.tr("This server is using an incompatitable version of DynaTech"));
                log(Level.WARNING, GetText.tr("Please keep Gastronomicon and DynaTech up to date!"));
            }
        }

        playerData = new AddonConfig("player.yml");
        customFood = new AddonConfig("custom-food.yml");

        TreeStructure.loadTrees();
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

    public static BukkitTask scheduleSyncRepeatingTask(Runnable runnable, long delay, long interval) {
        return Bukkit.getScheduler().runTaskTimer(getInstance(), runnable, delay, interval);
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
        player.sendMessage(/* ChatColor.of("#c91df4") + "§lGastronomicon§7§l> §7" + */ StringUtil.formatColors(message));
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
