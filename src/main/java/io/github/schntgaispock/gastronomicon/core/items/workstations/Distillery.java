package io.github.schntgaispock.gastronomicon.core.items.workstations;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public class Distillery extends GastroWorkstation {

    // TODO: Water level

    public Distillery(ItemGroup group, SlimefunItemStack item, RecipeType type, ItemStack[] recipe) {
        super(group, item, type, recipe);
    }

    @Override
    protected void setup(BlockMenuPreset preset) {
        super.setup(preset);
        preset.drawBackground(BACKGROUND_ITEM, new int[] { 52 });
    }

    @Override
    public GastroRecipeType getGastroRecipeType() {
        return GastroRecipeType.MILL;
    }
    
}
