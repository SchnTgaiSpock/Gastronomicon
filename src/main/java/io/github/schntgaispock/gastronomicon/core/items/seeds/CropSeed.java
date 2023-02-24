package io.github.schntgaispock.gastronomicon.core.items.seeds;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.CollectionUtil;
import io.github.schntgaispock.gastronomicon.util.ItemUtil;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.schntgaispock.gastronomicon.util.recipe.RecipeShapes;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;

/**
 * A CropGastroSeed drops additional crops when harvested
 */
public class CropSeed extends SimpleSeed {

    private final @Getter Map<ItemStack, Double> grownCrops;


    @ParametersAreNonnullByDefault
    public CropSeed(SlimefunItemStack item, Material displayBlock, ItemStack[] gatherSources,
            Map<ItemStack, Double> grownCrops) {
        super(item, displayBlock, gatherSources);

        this.grownCrops = grownCrops;
    }

    @ParametersAreNonnullByDefault
    public CropSeed(SlimefunItemStack item, Material displayBlock, ItemStack[] gatherSources,
            ItemStack grownCrop) {
        this(item, displayBlock, gatherSources, CollectionUtil.toMap(grownCrop, 1.0));
    }

    @ParametersAreNonnullByDefault
    public CropSeed(SlimefunItemStack item, Material displayBlock, SlimefunItemStack harvestSource) {
        this(item, displayBlock, RecipeShapes.singleCenter(harvestSource), harvestSource);
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
        drops.add(seed);

        for (Map.Entry<ItemStack, Double> grownCropsEntry : getGrownCrops().entrySet()) {
            final ItemStack drop = grownCropsEntry.getKey().clone();
            drop.setAmount(NumberUtil.getFortuneAmount(fortuneLevel, grownCropsEntry.getValue()));
            drops.add(drop);
        }

        return drops;
    }
}
