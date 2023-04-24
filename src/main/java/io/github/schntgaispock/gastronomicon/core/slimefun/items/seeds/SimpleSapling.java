package io.github.schntgaispock.gastronomicon.core.slimefun.items.seeds;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;

public class SimpleSapling extends SlimefunItem {

    public SimpleSapling(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        Gastronomicon.getInstance().saveResource("schematics/" + item.getItemId().replace("SAPLING", "TREE") + ".json", true);
    }
    
}
