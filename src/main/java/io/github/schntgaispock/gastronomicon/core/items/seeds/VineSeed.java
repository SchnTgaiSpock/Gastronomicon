package io.github.schntgaispock.gastronomicon.core.items.seeds;

import java.util.Arrays;
import java.util.List;

import org.bukkit.block.BlockState;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public class VineSeed extends AbstractSeed {

    public VineSeed(SlimefunItemStack item, ItemStack[] gatherSources) {
        super(item, gatherSources);
    }

    @Override
    public List<ItemStack> getHarvestDrops(BlockState e, ItemStack item, boolean brokenByPlayer) {
        return Arrays.asList(this.getItem());
    }

    @Override
    public boolean isMature(BlockState b) {
        return true;
    }
    
}
