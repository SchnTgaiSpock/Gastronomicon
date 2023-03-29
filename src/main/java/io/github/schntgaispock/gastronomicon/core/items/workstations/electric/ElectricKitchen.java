package io.github.schntgaispock.gastronomicon.core.items.workstations.electric;

import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;

public abstract class ElectricKitchen extends MenuBlock {

    public ElectricKitchen(SlimefunItemStack item, ItemStack[] recipe) {
        super(GastroGroups.MACHINES, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
    }
    
}
