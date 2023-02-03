package io.github.schntgaispock.gastronomicon.core.items.seeds;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.GastroUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public class SimpleGastroSeed extends AbstractGastroSeed {

    @ParametersAreNonnullByDefault
    public SimpleGastroSeed(SlimefunItemStack item, ItemStack[] harvestSources) {
        super(item, harvestSources);
    }


    @Override
    public void onHarvest(BlockBreakEvent e, ItemStack item) {
        final Location location = e.getBlock().getLocation();
        final World world = location.getWorld();

        if (!isMature(e.getBlock())) {
            world.dropItemNaturally(location, getItem());
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

        final double _fortune_factor = Math.sqrt(item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 1);

        final ItemStack seed = this.getItem().clone();
        seed.setAmount(GastroUtil.randomRound((sickleTier + 1) * (_fortune_factor + 1) / 2));
        world.dropItemNaturally(location, seed);
    }

    @Override
    public boolean isMature(Block b) {
        final Ageable cropMeta = (Ageable) b.getBlockData();
        return cropMeta.getAge() >= cropMeta.getMaximumAge();
    }

    @Override
    public void tick(Block b) {
        if (!isMature(b)) {
            final Ageable cropMeta = (Ageable) b.getBlockData();
            cropMeta.setAge(cropMeta.getAge() + 1);
            b.setBlockData(cropMeta);
        }
    }
}
