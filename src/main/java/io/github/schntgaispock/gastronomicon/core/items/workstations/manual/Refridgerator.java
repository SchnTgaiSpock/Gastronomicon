package io.github.schntgaispock.gastronomicon.core.items.workstations.manual;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.slimefun.recipes.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

@Getter
public class Refridgerator extends GastroWorkstation implements EnergyNetComponent {

    private final int capacity;
    private final int energyPerUse;

    public Refridgerator(ItemGroup group, SlimefunItemStack item, RecipeType type, ItemStack[] recipe, int capacity, int energyPerUse) {
        super(group, item, type, recipe);

        this.capacity = capacity;
        this.energyPerUse = energyPerUse;
    }

    @Override
    protected void setup(BlockMenuPreset preset) {
        super.setup(preset);
        preset.drawBackground(BACKGROUND_ITEM, new int[] { 52 });
    }

    @Override
    public GastroRecipeType getGastroRecipeType() {
        return GastroRecipeType.REFRIDGERATOR;
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }
    
}
