package io.github.schntgaispock.gastronomicon.core.items.seeds;

import java.util.logging.Level;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.util.ItemUtil;
import io.github.schntgaispock.gastronomicon.util.recipe.RecipeShapes;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;

/**
 * A FruitingGastroSeed grows a separate block next to the plant to harvest
 * <br>
 * <br>
 * The only allowed <code>displayBlock</code>s are pumpkin and melon stems
 */
public class FruitingSeed extends SimpleSeed {

    private final @Getter SlimefunItem fruitingBody;

    @ParametersAreNonnullByDefault
    public FruitingSeed(SlimefunItemStack item, @Nullable Material displayBlock, ItemStack[] gatherSources, String fruitingBodyId) {
        super(item, displayBlock, gatherSources);

        if (displayBlock == null) {
            displayBlock = ItemUtil.getPlacedBlock(item.getType());
        }

        switch (displayBlock) {
            case PUMPKIN_STEM, MELON_STEM -> {}
            default -> Gastronomicon.log(Level.WARNING, "Registering a FruitingSeed that isn't a pumpkin or melon seed!");
        }

        this.fruitingBody = SlimefunItem.getById(fruitingBodyId);
    }

    @ParametersAreNonnullByDefault
    public FruitingSeed(SlimefunItemStack item, @Nullable Material displayBlock, SlimefunItemStack harvestSource, String fruitingBodyId) {
        this(item, displayBlock, RecipeShapes.singleCenter(harvestSource), fruitingBodyId);
    }

    @ParametersAreNonnullByDefault
    public FruitingSeed(SlimefunItemStack item, SlimefunItemStack harvestSource, String fruitingBodyId) {
        this(item, null, RecipeShapes.singleCenter(harvestSource), fruitingBodyId);
    }

    @Override
    public boolean isMature(BlockState b) {
        return false;
    }

}
