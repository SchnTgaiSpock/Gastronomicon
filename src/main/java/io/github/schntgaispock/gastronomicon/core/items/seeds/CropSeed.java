package io.github.schntgaispock.gastronomicon.core.items.seeds;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.GastroUtil;
import io.github.schntgaispock.gastronomicon.util.RecipeShapes;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;

/**
 * The CropGastroSeed drops additional crops when harvested
 */
public class CropSeed extends SimpleSeed {

    private final @Getter Map<ItemStack, Double> grownCrops;

    @ParametersAreNonnullByDefault
    public CropSeed(SlimefunItemStack item, ItemStack[] gatherSources,
            Map<ItemStack, Double> grownCrops) {
        super(item, gatherSources);

        this.grownCrops = grownCrops;
    }

    @ParametersAreNonnullByDefault
    public CropSeed(SlimefunItemStack item, ItemStack[] gatherSources,
            ItemStack grownCrop) {
        this(item, gatherSources, GastroUtil.toMap(grownCrop, 1.0));
    }

    @ParametersAreNonnullByDefault
    public CropSeed(SlimefunItemStack item, SlimefunItemStack harvestSource) {
        this(item, RecipeShapes.singleCenter(harvestSource), harvestSource);
    }

    @Override
    public List<ItemStack> onHarvest(BlockBreakEvent e, ItemStack item) {
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

        List<ItemStack> drops = new ArrayList<>();

        final int fortuneAmount = item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);

        final ItemStack seed = this.getItem().clone();
        seed.setAmount(GastroUtil.getFortuneAmount(fortuneAmount, sickleTier));
        drops.add(seed);

        for (Map.Entry<ItemStack, Double> grownCropsEntry : getGrownCrops().entrySet()) {
            final ItemStack drop = grownCropsEntry.getKey().clone();
            drop.setAmount(GastroUtil.getFortuneAmount(fortuneAmount, grownCropsEntry.getValue()));
            drops.add(drop);
        }

        return drops;
    }
}
