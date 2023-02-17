package io.github.schntgaispock.gastronomicon.core.items.seeds;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.RecipeShapes;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;

/**
 * A FruitingGastroSeed grows a separate block next to the plant to harvest
 * <br>
 * The only allowed <code>ItemStack</code>s are pumpkin and melon seeds
 */
public class FruitingSeed extends SimpleSeed {

    private final @Getter SlimefunItem fruitingBody;

    @ParametersAreNonnullByDefault
    @SuppressWarnings("null")
    public FruitingSeed(SlimefunItemStack item, ItemStack[] gatherSources, String fruitingBodyId) {
        super(item, gatherSources);

        this.fruitingBody = SlimefunItem.getById(fruitingBodyId);
    }

    @ParametersAreNonnullByDefault
    public FruitingSeed(SlimefunItemStack item, SlimefunItemStack harvestSource, String fruitingBodyId) {
        this(item, RecipeShapes.singleCenter(harvestSource), fruitingBodyId);
    }

    // @Override
    // public void tick(Block b) {
    //     if (!isMature(b)) {
    //         final Ageable cropMeta = (Ageable) b.getBlockData();
    //         cropMeta.setAge(cropMeta.getAge() + 1);
    //         b.setBlockData(cropMeta);
    //     } else {
    //         // TODO: make random
    //         for (Vector d : growthDirections) {
    //             Location growthLocation = d.add(b.getLocation().toVector()).toLocation(b.getWorld());
    //             switch (growthLocation.subtract(0, 1, 0).getBlock().getType()) {
    //                 case DIRT, GRASS_BLOCK, PODZOL, MYCELIUM, COARSE_DIRT, ROOTED_DIRT, MOSS_BLOCK, MUD:
    //                     growthLocation.getBlock().setType(getFruitingBody().getItem().getType());
    //                     BlockStorage.addBlockInfo(growthLocation, "id", getFruitingBody().getId());
    //                     return;

    //                 default:
    //                     continue;
    //             }
    //         }
    //     }
    // }

}
