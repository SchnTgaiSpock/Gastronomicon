package io.github.schntgaispock.gastronomicon;

import javax.annotation.Nonnull;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.PluginManager;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.mooy1.infinitylib.core.AddonConfig;
import io.github.schntgaispock.gastronomicon.core.setup.CommandSetup;
import io.github.schntgaispock.gastronomicon.core.setup.ListenerSetup;
import io.github.schntgaispock.gastronomicon.core.setup.RecipeSetup;
import io.github.schntgaispock.gastronomicon.core.setup.GastroItemSetup;
import io.github.schntgaispock.gastronomicon.integration.SlimeHUDSetup;
import lombok.Getter;

@SuppressWarnings("null")
public class Gastronomicon extends AbstractAddon {

    private static @Getter Gastronomicon instance;
    private static final @Getter PluginManager pluginManager = getInstance().getServer().getPluginManager();

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

        RecipeSetup.setup();
        GastroItemSetup.setup();
        ListenerSetup.setup();
        CommandSetup.setup();

        if (getPluginManager().isPluginEnabled("SlimeHUD")) {
            try {
                getLogger().info("SlimeHUD was found on this server!");
                getLogger().info("Setting up Gastronomicon for SlimeHUD...");
                SlimeHUDSetup.setup();
            } catch (NoClassDefFoundError e) {
                getLogger().warning(
                        "This server is using an old version of SlimeHUD that is incompatitable with this version of Gastronomicon.");
                getLogger().warning("Please update SlimeHUD to version 1.2.0 or higher!");
            }
        }

        if (!getPluginManager().isPluginEnabled("ExoticGarden")) {
            getLogger().warning("ExoticGarden was not found on this server!");
            getLogger().info("Recipes that require ExoticGarden items will be hidden.");
        }

        playerData = new AddonConfig("player.yml");
    }

    @Override
    public void disable() {
        instance = null;
        getConfig().save();
    }

    public static NamespacedKey newNamespacedKey(@Nonnull String name) {
        return new NamespacedKey(Gastronomicon.getInstance(), name);
    }

    public static int scheduleSyncDelayedTask(Runnable runnable, long delay) {
        return Bukkit.getScheduler().scheduleSyncDelayedTask(getInstance(), runnable, delay);
    }
}
