package io.github.schntgaispock.gastronomicon.core.items.seeds;

import java.util.Arrays;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.GastroUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

/**
 * A SimpleGastroSeed only drops itself when harvested.
 */
public class SimpleSeed extends AbstractSeed {

    @ParametersAreNonnullByDefault
    public SimpleSeed(SlimefunItemStack item, ItemStack[] gatherSources) {
        super(item, gatherSources);
    }

    @Override
    public List<ItemStack> onHarvest(BlockBreakEvent e, ItemStack item) {
        if (!isMature(e.getBlock())) {
            return Arrays.asList(getItem());
        }

        int sickleTier = 0;

        final SlimefunItem sfItem = SlimefunItem.getByItem(item);
        if (sfItem != null) {
            sickleTier = switch (sfItem.getId()) {
                case "WOODEN_SICKLE" -> 1;
                case "STEEL_SICKLE" -> 2;
                case "REINFORCED_SICKLE" -> 3;
                default -> 0;
            };
        }

        final ItemStack seed = this.getItem().clone();
        seed.setAmount(GastroUtil.getFortuneAmount(item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS), sickleTier));
        return Arrays.asList(getItem());
    }

    @Override
    public boolean isMature(Block b) {
        final Ageable cropMeta = (Ageable) b.getBlockData();
        return cropMeta.getAge() >= cropMeta.getMaximumAge();
    }

    // @Override
    // public void tick(Block b) {
    //     if (!isMature(b)) {
    //         final Ageable cropMeta = (Ageable) b.getBlockData();
    //         cropMeta.setAge(cropMeta.getAge() + 1);
    //         b.setBlockData(cropMeta);
    //     }
    // }
}
