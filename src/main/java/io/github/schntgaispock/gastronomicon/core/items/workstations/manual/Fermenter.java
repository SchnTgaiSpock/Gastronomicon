package io.github.schntgaispock.gastronomicon.core.items.workstations.manual;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.slimefun.recipes.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

@Getter
public class Fermenter extends GastroWorkstation {

    public static String WATER_KEY = "gastronomicon:fermenter/water";

    private final int capacity;
    private final int mbPerCraft;

    public Fermenter(SlimefunItemStack item, ItemStack[] recipe, int capacity, int mbPerCraft) {
        super(item, recipe);

        this.capacity = capacity;
        this.mbPerCraft = mbPerCraft;
    }

    @Override
    public void preRegister() {
        super.preRegister();
    }

    @Override
    protected void setup(BlockMenuPreset preset) {
        super.setup(preset); // TODO: Finish Fermenter
        preset.drawBackground(BACKGROUND_ITEM, new int[] { 52 });
    }

    @Override
    public GastroRecipeType getGastroRecipeType() {
        return GastroRecipeType.MILL;
    }

}
