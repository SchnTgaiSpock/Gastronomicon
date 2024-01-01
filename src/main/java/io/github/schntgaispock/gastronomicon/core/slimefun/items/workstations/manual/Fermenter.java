package io.github.schntgaispock.gastronomicon.core.slimefun.items.workstations.manual;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.slimefun.recipes.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.util.ChunkPDC;
import io.github.schntgaispock.gastronomicon.util.item.GastroKeys;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

@Getter
public class Fermenter extends GastroWorkstation {

    private final int capacity;
    private final int mbPerCraft;

    public Fermenter(SlimefunItemStack item, ItemStack[] recipe, int capacity, int mbPerCraft) {
        super(item, recipe);

        this.capacity = capacity;
        this.mbPerCraft = mbPerCraft;
    }

    @Override
    protected void onBreak(BlockBreakEvent e, BlockMenu menu) {
        super.onBreak(e, menu);
        ChunkPDC.remove(e.getBlock(), GastroKeys.FERMENTER_WATER);
    }

    @Override
    protected void onPlace(BlockPlaceEvent e, Block b) {
        super.onPlace(e, b);
        ChunkPDC.set(b, GastroKeys.FERMENTER_WATER, 0);
    }

    @Override
    protected void setup(BlockMenuPreset preset) {
        super.setup(preset);
        preset.drawBackground(BACKGROUND_ITEM, new int[] { 52 });
    }

    @Override
    public GastroRecipeType getGastroRecipeType() {
        return GastroRecipeType.FERMENTER;
    }

    @Override
    protected boolean canCraft(BlockMenu menu, Block b, Player p, boolean sendMessage) {
        final int water = ChunkPDC.getOrCreateDefault(b, GastroKeys.FERMENTER_WATER, 0);
        if (water < getMbPerCraft()) {
            Gastronomicon.sendMessage(p, "&eNot enough water!");
            return false;
        }

        return true;
    }

    @Override
    protected void onSuccessfulCraft(Block b) {
        final int water = ChunkPDC.getOrCreateDefault(b, GastroKeys.FERMENTER_WATER, 0);
        ChunkPDC.set(b, GastroKeys.FERMENTER_WATER, water - getMbPerCraft());
    }

}
