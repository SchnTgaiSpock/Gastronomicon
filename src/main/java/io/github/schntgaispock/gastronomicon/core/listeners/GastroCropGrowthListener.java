package io.github.schntgaispock.gastronomicon.core.listeners;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.plugin.Plugin;

import io.github.schntgaispock.gastronomicon.Gastronomicon;

public class GastroCropGrowthListener implements Listener {
    
    @EventHandler
    public void onCropGrow(@Nonnull BlockGrowEvent e) {
        Material cropType = e.getBlock().getType();

        switch (cropType) {
            // case WHEAT_SEEDS, CARROTS, POTATOES, BEETROOTS, PUMPKIN_STEM, MELON_STEM:
            //     // I might want to do something here later
            //     break;
            case PUMPKIN, MELON:
        
            default:
                break;
        }
    }
    
    public static void setup() {
        Bukkit.getPluginManager().registerEvents((Listener) new GastroCropGrowthListener(),
            (Plugin) Gastronomicon.getInstance());
    }
}
