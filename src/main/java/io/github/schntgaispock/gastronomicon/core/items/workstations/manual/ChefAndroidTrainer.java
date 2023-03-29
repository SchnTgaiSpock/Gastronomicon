package io.github.schntgaispock.gastronomicon.core.items.workstations.manual;

import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public class ChefAndroidTrainer extends MenuBlock {

    protected static final int[] BACKGROUND_SLOTS = {
        0, 1, 2, 3, 4, 5, 6, 7, 8,
        9, 17,
        18, 19, 20, 21, 23, 24, 25, 26
    };

    protected static final int[] INPUT_BORDER_SLOTS = { 10, 12 };
    protected static final int[] OUTPUT_BORDER_SLOTS = { 14, 16 };
    protected static final int SET_RECIPE_SLOT = 13;
    protected static final int TRAIN_SLOT = 22;

    public ChefAndroidTrainer(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    protected void setup(BlockMenuPreset preset) {
    }

    @Override
    protected int[] getInputSlots() {
        return new int[] { 11 };
    }

    @Override
    protected int[] getOutputSlots() {
        return new int[] { 15 };
    }
    
}
