package io.github.schntgaispock.gastronomicon.core.items.seeds;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

/**
 * Like {@link SimpleSeed}, but for non-seed {@link Material}s
 */
public class RightClickSeed extends SimpleSeed {

    @ParametersAreNonnullByDefault
    public RightClickSeed(SlimefunItemStack item, @Nullable Material displayBlock, ItemStack[] gatherSources) {
        super(item, displayBlock, gatherSources);
    }

    @ParametersAreNonnullByDefault
    public RightClickSeed(SlimefunItemStack item, ItemStack[] gatherSources) {
        super(item, gatherSources);
    }

    @Override
    public void preRegister() {
        super.preRegister();

        addItemHandler(new BlockPlaceHandler(false) {
            @Override
            public void onPlayerPlace(@Nonnull BlockPlaceEvent e) {
                e.setCancelled(true);
                BlockStorage.clearBlockInfo(e.getBlock(), false);
            }
        });

        addItemHandler((ItemUseHandler) event -> {
            if (event.getClickedFace() != BlockFace.UP || !canUse(event.getPlayer(), true) || event.getClickedBlock().isEmpty()) {
                return;
            }

            final Block b = event.getClickedBlock().get();
            if (b.getType() != Material.FARMLAND || b.getY() >= b.getWorld().getMaxHeight()) {
                return;
            }

            final Block above = b.getLocation().add(0, 1, 0).getBlock();
            if (!above.isEmpty() || !Slimefun.getProtectionManager().hasPermission(event.getPlayer(), above, Interaction.PLACE_BLOCK)) {
                return;
            }
            
            above.setType(getDisplayBlock());
            BlockStorage.addBlockInfo(above, "id", getId());

        });
    }
    
}
