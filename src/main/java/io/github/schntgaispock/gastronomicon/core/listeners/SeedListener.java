package io.github.schntgaispock.gastronomicon.core.listeners;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.inventory.ItemStack;

import com.destroystokyo.paper.event.block.BlockDestroyEvent;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.seeds.AbstractSeed;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.seeds.DuplicatingSeed;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.seeds.FruitingSeed;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.seeds.VineSeed;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

public class SeedListener implements Listener {

    @EventHandler
    public void onCropGrow(@Nonnull BlockGrowEvent e) {
        switch (e.getNewState().getType()) {
            case SUGAR_CANE, CACTUS:
                assignGastroSeed(BlockStorage.check(e.getBlock().getRelative(BlockFace.DOWN)),
                    e.getNewState().getLocation());
                break;

            case PUMPKIN, MELON:
                // Have to schedule it later because there is no way to tell where the stem that
                // grew the plant is before its grown.
                Bukkit.getScheduler().runTaskLater(Gastronomicon.getInstance(), () -> {
                    for (BlockFace face : new BlockFace[] { BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH,
                        BlockFace.WEST }) {
                        final Block checking = e.getBlock().getRelative(face);
                        if (checking.getType() != Material.ATTACHED_MELON_STEM
                            && checking.getType() != Material.ATTACHED_PUMPKIN_STEM) {
                            continue;
                        }

                        final Directional stemData = (Directional) checking.getBlockData();

                        if (stemData.getFacing().getOppositeFace().equals(face)) {
                            assignGastroSeed(BlockStorage.check(checking), e.getNewState().getLocation());
                            break;
                        }
                    }
                }, 1);
                break;

            default:
                break;
        }
    }

    @EventHandler
    public void onVineGrow(BlockSpreadEvent e) {
        switch (e.getNewState().getType()) {
            case VINE:
                assignGastroSeed(BlockStorage.check(e.getSource()),
                    e.getNewState().getLocation());
                break;

            default:
                break;
        }
    }

    @EventHandler
    public void onCropDestroy(BlockDestroyEvent e) {
        final AbstractSeed seed = getGastroSeed(e.getBlock());

        if (seed != null) {
            e.setWillDrop(false);
            seed.getHarvestDrops(e.getBlock().getState(), new ItemStack(Material.AIR), false).forEach(
                drop -> e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), drop));
            BlockStorage.clearBlockInfo(e.getBlock(), true);
        }
    }

    @EventHandler
    public void onLiquidCropDestroy(BlockFromToEvent e) {
        final Block b = e.getToBlock();
        final AbstractSeed seed = getGastroSeed(b);

        if (seed != null) {
            e.setCancelled(true); // too bad there is no way to cancel drops!
            b.getWorld().playSound(b.getLocation(), Sound.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1, 1);
            seed.getHarvestDrops(e.getBlock().getState(), new ItemStack(Material.AIR), false).forEach(
                drop -> e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), drop));
            b.setType(Material.AIR);
            BlockStorage.clearBlockInfo(b, true);
        }
    }

    @EventHandler
    public void onVillagerCropDestroy(EntityChangeBlockEvent e) {
        if (getGastroSeed(e.getBlock()) != null) {
            e.setCancelled(true);
        }
    }

    private void assignGastroSeed(SlimefunItem item, @Nonnull Location l) {
        if (item == null)
            return;

        if (item instanceof DuplicatingSeed || item instanceof VineSeed) {
            BlockStorage.addBlockInfo(l, "id", item.getId());
        } else if (item instanceof final FruitingSeed fgs) {
            BlockStorage.addBlockInfo(l, "id", fgs.getFruitingBody().getId());
        }
    }

    private AbstractSeed getGastroSeed(Block cropBlock) {
        if (cropBlock == null)
            return null;
        switch (cropBlock.getType()) {
            case WHEAT, POTATOES, CARROTS, BEETROOTS, PUMPKIN_STEM, ATTACHED_PUMPKIN_STEM, MELON_STEM, ATTACHED_MELON_STEM, SUGAR_CANE, CACTUS, VINE:
                break;
            default:
                return null;
        }

        final SlimefunItem item = BlockStorage.check(cropBlock);
        if (item == null) {
            return null;
        }

        if (item instanceof final AbstractSeed seed) {
            return seed;
        }

        return null;

    }

    public static void setup() {
        Bukkit.getPluginManager().registerEvents(new SeedListener(), Gastronomicon.getInstance());
    }
}
