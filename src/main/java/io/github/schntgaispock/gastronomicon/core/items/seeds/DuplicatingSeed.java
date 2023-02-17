package io.github.schntgaispock.gastronomicon.core.items.seeds;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.RecipeShapes;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

/**
 * A DuplicatingGastroSeed grows upward.
 * <br>
 * The only <code>ItemStack</code>s allowed are cacti and sugar cane
 */
public class DuplicatingSeed extends SimpleSeed {

    @ParametersAreNonnullByDefault
    public DuplicatingSeed(SlimefunItemStack item, ItemStack[] gatherSources, String fruitingBodyId) {
        super(item, gatherSources);
    }

    @ParametersAreNonnullByDefault
    public DuplicatingSeed(SlimefunItemStack item, SlimefunItemStack harvestSource, String fruitingBodyId) {
        this(item, RecipeShapes.singleCenter(harvestSource), fruitingBodyId);
    }

    @Override
    public boolean isMature(Block b) {
        return false;
    }

    // @Override
    // public void tick(Block b) {
    //     if (!isMature(b)) {
    //         final Ageable cropMeta = (Ageable) b.getBlockData();
    //         cropMeta.setAge(cropMeta.getAge() + 1);
    //         b.setBlockData(cropMeta);
    //     } else {
    //         final Location growthLocation = b.getLocation().add(0, 1, 0);
    //         switch (growthLocation.getBlock().getType()) {
    //             case AIR, CAVE_AIR, VOID_AIR:
    //                 growthLocation.getBlock().setType(getItem().getType());
    //                 BlockStorage.addBlockInfo(growthLocation, "id", getId());
            
    //             default:
    //                 return;
    //         }
    //     }
    // }

}
