package io.github.schntgaispock.gastronomicon.core.items.seeds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.block.BlockState;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;

public class VineSeed extends AbstractSeed {

    private final @Getter List<ItemStack> drops;

    public VineSeed(SlimefunItemStack item, ItemStack[] gatherSources, ItemStack... crops) {
        super(item, gatherSources);

        drops = new ArrayList<>();
        drops.addAll(Arrays.asList(crops));
        drops.add(getItem());
    }

    @Override
    public List<ItemStack> getHarvestDrops(BlockState e, ItemStack item, boolean brokenByPlayer) {
        return drops;
    }

    @Override
    protected boolean dropsOnPlayerBreak() {
        return false; // Vines also trigger BlockDestroyEvent
    }

    @Override
    public boolean isMature(BlockState b) {
        return true;
    }
    
}
