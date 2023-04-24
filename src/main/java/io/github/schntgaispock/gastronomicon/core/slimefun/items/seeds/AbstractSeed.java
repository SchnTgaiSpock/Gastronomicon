package io.github.schntgaispock.gastronomicon.core.slimefun.items.seeds;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.recipes.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;

public abstract class AbstractSeed extends SlimefunItem {

    @ParametersAreNonnullByDefault
    public AbstractSeed(SlimefunItemStack item, ItemStack[] gatherSources) {
        super(GastroGroups.RAW_INGREDIENTS, item, GastroRecipeType.BREAK, gatherSources);
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockBreakHandler(false, true) {

            @Override
            public void onExplode(Block b, List<ItemStack> drops) {
                drops.clear();
                drops.addAll(getHarvestDrops(b.getState(), new ItemStack(Material.AIR), false));
            }

            @Override
            public void onPlayerBreak(BlockBreakEvent e, ItemStack item, List<ItemStack> drops) {
                if (!dropsOnPlayerBreak()) return;
                
                drops.clear();
                drops.addAll(getHarvestDrops(e.getBlock().getState(), item, true));
            }
        });
    }

    public abstract List<ItemStack> getHarvestDrops(BlockState e, ItemStack item, boolean brokenByPlayer);

    protected boolean dropsOnPlayerBreak() {
        return true;
    }

    public abstract boolean isMature(BlockState b);

}
