package io.github.schntgaispock.gastronomicon.core.slimefun.items.workstations.manual;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.slimefun.recipes.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

@Getter
public class Refrigerator extends GastroWorkstation implements EnergyNetComponent {

    private final int capacity;
    private final int energyPerUse;

    public Refrigerator(SlimefunItemStack item, ItemStack[] recipe, int capacity, int energyPerUse) {
        super(item, recipe);

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
        return GastroRecipeType.REFRIGERATOR;
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    protected boolean canCraft(BlockMenu menu, Block b, Player p, boolean sendMessage) {
        final int charge = getCharge(b.getLocation());
        if (charge < getEnergyPerUse()) {
            Gastronomicon.sendMessage(p, "&eNot enough energy!");
            return false;
        }

        return true;
    }

    @Override
    protected void onSuccessfulCraft(Block b) {
        final int charge = getCharge(b.getLocation());
        setCharge(b.getLocation(), charge - getEnergyPerUse());
    }
    
}
