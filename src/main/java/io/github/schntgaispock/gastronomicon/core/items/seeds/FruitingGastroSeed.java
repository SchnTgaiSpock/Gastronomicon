package io.github.schntgaispock.gastronomicon.core.items.seeds;

import java.util.Arrays;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import io.github.schntgaispock.gastronomicon.util.RecipeShapes;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

/**
 * For crops that generate a separate block to harvest (e.g. pumpkins, melons)
 */
public class FruitingGastroSeed extends SimpleGastroSeed {

    private final @Getter SlimefunItem fruitingBody;
    private final List<Vector> growthDirections = Arrays.asList(
        new Vector(-1, 0, 0),
        new Vector(1, 0, 0),
        new Vector(0, 0, -1),
        new Vector(0, 0, 1)
    );

    @ParametersAreNonnullByDefault
    @SuppressWarnings("null")
    public FruitingGastroSeed(SlimefunItemStack item, ItemStack[] harvestSources, String fruitingBodyId) {
        super(item, harvestSources);

        this.fruitingBody = SlimefunItem.getById(fruitingBodyId);
    }

    @ParametersAreNonnullByDefault
    public FruitingGastroSeed(SlimefunItemStack item, SlimefunItemStack harvestSource, String fruitingBodyId) {
        this(item, RecipeShapes.singleCenter(harvestSource), fruitingBodyId);
    }

    @Override
    public void tick(Block b) {
        if (!isMature(b)) {
            final Ageable cropMeta = (Ageable) b.getBlockData();
            cropMeta.setAge(cropMeta.getAge() + 1);
            b.setBlockData(cropMeta);
        } else {
            // TODO: make random
            for (Vector d : growthDirections) {
                Location growthLocation = d.add(b.getLocation().toVector()).toLocation(b.getWorld());
                switch (growthLocation.subtract(0, 1, 0).getBlock().getType()) {
                    case DIRT, GRASS_BLOCK, PODZOL, MYCELIUM, COARSE_DIRT, ROOTED_DIRT, MOSS_BLOCK, MUD:
                        growthLocation.getBlock().setType(getFruitingBody().getItem().getType());
                        BlockStorage.addBlockInfo(growthLocation, "id", getFruitingBody().getId());
                        return;
                
                    default:
                        continue;
                } 
            }
        }
    }

}
