package io.github.schntgaispock.gastronomicon.core.listeners;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.plugin.Plugin;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.items.seeds.DuplicatingSeed;
import io.github.schntgaispock.gastronomicon.core.items.seeds.FruitingSeed;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

public class SeedGrowthListener implements Listener {
    
    @EventHandler
    public void onCropGrow(@Nonnull BlockGrowEvent e) {
        final Block seed = e.getBlock();
        System.out.println(seed);
        if (seed == null) return;

        final String id = BlockStorage.checkID(seed);
        if (id == null) return;

        final SlimefunItem item = SlimefunItem.getById(id);
        if (item == null) return;


        if (item instanceof DuplicatingSeed) {
            BlockStorage.addBlockInfo(e.getNewState().getLocation(), "id", id);
        } else if (item instanceof final FruitingSeed fgs) {
            BlockStorage.addBlockInfo(e.getNewState().getLocation(), "id", fgs.getFruitingBody().getId());
        }
    }
    
    public static void setup() {
        Bukkit.getPluginManager().registerEvents((Listener) new SeedGrowthListener(),
            (Plugin) Gastronomicon.getInstance());
    }
}
