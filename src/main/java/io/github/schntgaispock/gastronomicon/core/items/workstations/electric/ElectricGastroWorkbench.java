package io.github.schntgaispock.gastronomicon.core.items.workstations.electric;

import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;

public abstract class ElectricGastroWorkbench extends MenuBlock {

    public ElectricGastroWorkbench(ItemGroup category, SlimefunItemStack item, RecipeType recipeType,
        ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }
    
}
