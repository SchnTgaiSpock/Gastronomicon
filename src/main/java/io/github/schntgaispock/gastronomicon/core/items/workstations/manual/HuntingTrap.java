package io.github.schntgaispock.gastronomicon.core.items.workstations.manual;

import java.util.List;
import java.util.Optional;
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
import me.mrCookieSlime.Slimefun.api.BlockStorage;

public abstract class HuntingTrap extends SimpleSlimefunItem<BlockUseHandler> {

    public static final String TRIGGERED_KEY = "gastronomicon.hunting-trap/triggered";

    protected HuntingTrap(SlimefunItemStack item, ItemStack[] recipe) {
        super(GastroGroups.TOOLS, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
    }

    @Override
    public void preRegister() {
        super.preRegister();

        addItemHandler(new BlockPlaceHandler(true) {

            private void startTask(Location l) {
                Gastronomicon.scheduleSyncDelayedTask(() -> {
                    if (!BlockStorage.getLocationInfo(l, TRIGGERED_KEY).equals("true")) {
                        BlockStorage.addBlockInfo(l, TRIGGERED_KEY, "true");
                    }
                }, (long) NumberUtil.clamp(ThreadLocalRandom.current().nextGaussian(120, 30), 90, 180));
            }

            @Override
            public void onBlockPlacerPlace(BlockPlacerPlaceEvent e) {
                BlockStorage.addBlockInfo(e.getBlock(), TRIGGERED_KEY, "false");
                if (canCatch(e.getBlock().getLocation())) startTask(e.getBlock().getLocation());
            }

            @Override
            public void onPlayerPlace(BlockPlaceEvent e) {
                BlockStorage.addBlockInfo(e.getBlock(), TRIGGERED_KEY, "false");
                startTask(e.getBlock().getLocation());
            }

        });

        addItemHandler(new BlockBreakHandler(true, true) {

            @Override
            public void onExplode(Block b, List<ItemStack> drops) {
                BlockStorage.clearBlockInfo(b);
            }

            @Override
            public void onAndroidBreak(AndroidMineEvent e) {
                BlockStorage.clearBlockInfo(e.getBlock());
            }

            @Override
            public void onPlayerBreak(BlockBreakEvent e, ItemStack item, List<ItemStack> drops) {
                BlockStorage.clearBlockInfo(e.getBlock());
            }

        });

        
    }

    @Override
    public BlockUseHandler getItemHandler() {
        return e -> {
            e.cancel();

            final Optional<Block> o = e.getClickedBlock();
            if (o.isEmpty() || !"true"
                .equals(BlockStorage.getLocationInfo(o.get().getLocation(), "gastronomicon:hunting-trap/triggered"))) {
                Gastronomicon.sendMessage(e.getPlayer(), "Doesn't look like anything's been caught yet...");
                return;
            }
            final Location l = o.get().getLocation();

            l.getWorld().dropItemNaturally(l, getCatch(l));
            BlockStorage.addBlockInfo(l, TRIGGERED_KEY, "false");
        };
    }

    protected abstract ItemStack getCatch(Location l);

    protected abstract boolean canCatch(Location l);
}
