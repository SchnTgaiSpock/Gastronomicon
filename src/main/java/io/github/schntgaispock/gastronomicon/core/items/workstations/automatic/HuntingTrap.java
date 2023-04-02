package io.github.schntgaispock.gastronomicon.core.items.workstations.automatic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.thebusybiscuit.slimefun4.api.events.AndroidMineEvent;
import io.github.thebusybiscuit.slimefun4.api.events.BlockPlacerPlaceEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;

public abstract class HuntingTrap extends SimpleSlimefunItem<BlockUseHandler> {

    private static final Map<Location, Boolean> triggeredTraps = new HashMap<>();

    protected HuntingTrap(SlimefunItemStack item, ItemStack[] recipe) {
        super(GastroGroups.TOOLS, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
    }

    @Override
    public void preRegister() {
        super.preRegister();

        addItemHandler(new BlockPlaceHandler(true) {

            private void startTask(Location l) {
                Gastronomicon.scheduleSyncDelayedTask(() -> {
                    if (!triggeredTraps.get(l)) {
                        triggeredTraps.put(l, true);
                    }
                }, (long) NumberUtil.clamp(ThreadLocalRandom.current().nextGaussian(120, 30), 90, 180));
            }

            @Override
            public void onBlockPlacerPlace(BlockPlacerPlaceEvent e) {
                triggeredTraps.put(e.getBlock().getLocation(), false);
                startTask(e.getBlock().getLocation());
            }

            @Override
            public void onPlayerPlace(BlockPlaceEvent e) {
                triggeredTraps.put(e.getBlock().getLocation(), false);
                startTask(e.getBlock().getLocation());
            }

        });

        addItemHandler(new BlockBreakHandler(true, true) {

            @Override
            public void onExplode(Block b, List<ItemStack> drops) {
                triggeredTraps.remove(b.getLocation());
            }

            @Override
            public void onAndroidBreak(AndroidMineEvent e) {
                triggeredTraps.remove(e.getBlock().getLocation());
            }

            @Override
            public void onPlayerBreak(BlockBreakEvent e, ItemStack item, List<ItemStack> drops) {
                triggeredTraps.remove(e.getBlock().getLocation());
            }
            
        });
    }

    @Override
    public BlockUseHandler getItemHandler() {
        return e -> {
            e.cancel();
            Gastronomicon.sendMessage(e.getPlayer(), "Doesn't look like anything's been caught yet...");
        };
    }

    protected abstract ItemStack getCatch(Location l);
    protected abstract boolean canCatch(Location l);
}
