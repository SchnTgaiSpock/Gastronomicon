package io.github.schntgaispock.gastronomicon.core.items.seeds;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.RecipeShapes;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

/**
 * For crops that generate a separate block to harvest (e.g. pumpkins, melons)
 */
public class DuplicatingGastroSeed extends SimpleGastroSeed {

    @ParametersAreNonnullByDefault
    public DuplicatingGastroSeed(SlimefunItemStack item, ItemStack[] harvestSources, String fruitingBodyId) {
        super(item, harvestSources);
    }

    @ParametersAreNonnullByDefault
    public DuplicatingGastroSeed(SlimefunItemStack item, SlimefunItemStack harvestSource, String fruitingBodyId) {
        this(item, RecipeShapes.singleCenter(harvestSource), fruitingBodyId);
    }

    @Override
    public void tick(Block b) {
        if (!isMature(b)) {
            final Ageable cropMeta = (Ageable) b.getBlockData();
            cropMeta.setAge(cropMeta.getAge() + 1);
            b.setBlockData(cropMeta);
        } else {
            final Location growthLocation = b.getLocation().add(0, 1, 0);
            switch (growthLocation.getBlock().getType()) {
                case AIR, CAVE_AIR, VOID_AIR:
                    growthLocation.getBlock().setType(getItem().getType());
                    BlockStorage.addBlockInfo(growthLocation, "id", getId());
            
                default:
                    return;
            }
        }
    }

}
