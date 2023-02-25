package io.github.schntgaispock.gastronomicon.core.items.seeds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Ageable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.schntgaispock.gastronomicon.util.item.ItemUtil;
import io.github.thebusybiscuit.slimefun4.api.events.BlockPlacerPlaceEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import lombok.Getter;

/**
 * A SimpleGastroSeed only drops itself when harvested.
 */
public class SimpleSeed extends AbstractSeed {

    private final @Nonnull @Getter Material displayBlock;

    @ParametersAreNonnullByDefault
    public SimpleSeed(SlimefunItemStack item, @Nullable Material displayBlock, ItemStack[] gatherSources) {
        super(item, gatherSources);

        if (displayBlock == null) {
            displayBlock = ItemUtil.getPlacedBlock(item.getType());
        }

        this.displayBlock = displayBlock;
    }

    @ParametersAreNonnullByDefault
    public SimpleSeed(SlimefunItemStack item, ItemStack[] gatherSources) {
        this(item, null, gatherSources);
    }
    
    @Override
    public void preRegister() {
        super.preRegister();

        addItemHandler(new BlockPlaceHandler(true) {
            @Override
            public void onBlockPlacerPlace(BlockPlacerPlaceEvent e) {
                e.getBlock().setType(displayBlock);
            }

            @Override
            public void onPlayerPlace(BlockPlaceEvent e) {
                if (!e.canBuild()) {
                    e.setCancelled(true);
                }

                e.getBlock().setType(displayBlock);
            }
        });
    }

    @Override
    public List<ItemStack> getHarvestDrops(BlockState b, ItemStack item, boolean brokenByPlayer) {
        final List<ItemStack> drops = new ArrayList<>();
        if (!brokenByPlayer) {
            drops.add(getItem().clone());
        }

        if (!isMature(b)) {
            return drops;
        }

        final int sickleTier = ItemUtil.getSickleTier(item);
        final int fortuneLevel = item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);

        final ItemStack seed = getItem().clone();
        seed.setAmount(NumberUtil.getFortuneAmount(fortuneLevel, sickleTier));
        return Arrays.asList(seed);
    }

    @Override
    public boolean isMature(BlockState b) {
        if (b.getBlockData() instanceof final Ageable cropMeta) {
            return cropMeta.getAge() >= cropMeta.getMaximumAge();
        } else {
            return false;
        }
    }

}
