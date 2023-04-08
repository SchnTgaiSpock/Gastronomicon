package io.github.schntgaispock.gastronomicon.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.api.trees.TreeStructure;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

public class TreeGrowthListener implements Listener {

    @EventHandler
    public void onTreeGrow(StructureGrowEvent e) {
        final String sapling = BlockStorage.checkID(e.getLocation());
        if (sapling == null) return;

        final TreeStructure tree = TreeStructure.getLoadedTrees().get(sapling);
        if (tree == null) return;

        e.setCancelled(true);
        BlockStorage.clearBlockInfo(e.getLocation(), true);
        try {
            tree.build(e.getLocation(), sapling);
        } catch (NullPointerException | IllegalArgumentException err) {
            err.printStackTrace();
        }
    }
    
    public static void setup() {
        Bukkit.getPluginManager().registerEvents(new TreeGrowthListener(), Gastronomicon.getInstance());
    }
}
