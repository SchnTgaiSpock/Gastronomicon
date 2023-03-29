package io.github.schntgaispock.gastronomicon.core.items.workstations.manual;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.slimefun.recipes.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

@Getter
public class Fermenter extends GastroWorkstation {

    private final int capacity;
    private final int mbPerCraft;

    public Fermenter(ItemGroup group, SlimefunItemStack item, RecipeType type, ItemStack[] recipe, int capacity, int mbPerCraft) {
        super(group, item, type, recipe);

        this.capacity = capacity;
        this.mbPerCraft = mbPerCraft;
    }

    @Override
    public void preRegister() {
        super.preRegister();

        addItemHandler((BlockUseHandler) event -> {
            
        });
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
