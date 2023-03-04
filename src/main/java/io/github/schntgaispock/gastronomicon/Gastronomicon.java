package io.github.schntgaispock.gastronomicon;

import java.util.logging.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.mooy1.infinitylib.core.AddonConfig;
import io.github.schntgaispock.gastronomicon.core.setup.CommandSetup;
import io.github.schntgaispock.gastronomicon.core.setup.ListenerSetup;
import io.github.schntgaispock.gastronomicon.core.setup.ResearchSetup;
import io.github.schntgaispock.gastronomicon.core.setup.ItemSetup;
import io.github.schntgaispock.gastronomicon.integration.SlimeHUDSetup;
import lombok.Getter;

public class Gastronomicon extends AbstractAddon {

    private static @Getter Gastronomicon instance;
    private @Getter AddonConfig playerData;

    public Gastronomicon() {
        super("SchnTgaiSpock", "Gastronomicon", "master", "options.auto-update");
    }

    @Override
    @SuppressWarnings("unused")
    public void enable() {
        instance = this;

        getLogger().info("#======================================#");
        getLogger().info("#    Gastronomicon by SchnTgaiSpock    #");
        getLogger().info("#======================================#");

        Metrics metrics = new Metrics(this, 16941);

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
                log(Level.WARNING, "This server is using an old version of SlimeHUD that is incompatitable with this version of Gastronomicon.");
                log(Level.WARNING, "Please update SlimeHUD to version 1.2.0 or higher!");
            }
        }

        if (!isPluginEnabled("ExoticGarden")) {
            log(Level.WARNING, "ExoticGarden was not found on this server!");
            log(Level.WARNING, "Recipes that require ExoticGarden items will be hidden.");
        }

        playerData = new AddonConfig("player.yml");
    }

    @Override
    public void disable() {
        instance = null;
        getPlayerData().save();
    }

    public static NamespacedKey newNamespacedKey(@Nonnull String name) {
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
            player.sendMessage(message);
        return false;
    
    }
}
