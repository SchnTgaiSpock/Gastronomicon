package io.github.schntgaispock.gastronomicon.core.items.seeds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.block.BlockState;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.util.RecipeUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

/**
 * A DuplicatingGastroSeed grows upward.
 * <br>
 * <br>
 * The only <code>ItemStack</code>s allowed are cacti and sugar cane
 */
public class DuplicatingSeed extends AbstractSeed {

    @ParametersAreNonnullByDefault
    public DuplicatingSeed(SlimefunItemStack item, ItemStack[] gatherSources) {
        super(item, gatherSources);

        switch (item.getType()) {
            case CACTUS, SUGAR_CANE -> {}
            default -> Gastronomicon.log(Level.WARNING, "Registering a DuplicatingSeed that isn't a cactus or sugar cane!");
        }
    }

    @ParametersAreNonnullByDefault
    public DuplicatingSeed(SlimefunItemStack item, SlimefunItemStack harvestSource) {
        this(item, RecipeUtil.singleCenter(harvestSource));
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockPlaceHandler(true) {
            @Override
            public void onPlayerPlace(BlockPlaceEvent e) {
                if (e.getBlock().getState().getLightLevel() <= 7) {
                    e.setCancelled(true);
                    BlockStorage.clearBlockInfo(e.getBlock(), true);
                }
            }
        });
    }
    

    @Override
    public boolean isMature(BlockState b) {
        return false;
    }

    @Override
    public List<ItemStack> getHarvestDrops(BlockState e, ItemStack item, boolean brokenByPlayer) {
        return brokenByPlayer ? new ArrayList<>() : Arrays.asList(getItem().clone());
    }

}
