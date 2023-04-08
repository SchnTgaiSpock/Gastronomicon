package io.github.schntgaispock.gastronomicon.core.items.workstations.manual;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import io.github.schntgaispock.gastronomicon.core.slimefun.recipes.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.util.ChunkPDC;
import io.github.schntgaispock.gastronomicon.util.item.GastroKeys;
import io.github.thebusybiscuit.slimefun4.api.events.BlockPlacerPlaceEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
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
    public void preRegister() {
        super.preRegister();

        addItemHandler(new BlockPlaceHandler(true) {
            private void onPlace(Block b) {
                ChunkPDC.set(b, GastroKeys.FERMENTER_WATER, 0);
            }

            @Override
            public void onBlockPlacerPlace(BlockPlacerPlaceEvent e) {
                onPlace(e.getBlock());
            }

            @Override
            public void onPlayerPlace(BlockPlaceEvent e) {
                onPlace(e.getBlock());
            }
        });

        addItemHandler((BlockUseHandler) e -> {
            if (e.getClickedBlock().isEmpty()) return;
            if (SlimefunItem.getByItem(e.getItem()) != null) return;

            final int refill;
            final Material ret; 
            switch (e.getItem().getType()) {
                case WATER_BUCKET:
                    refill = 1000;
                    ret = Material.BUCKET;
                    break;
                case POTION:
                    if (((PotionMeta) e.getItem().getItemMeta()).getBasePotionData().getType() == PotionType.WATER) {
                        refill = 333;
                        ret = Material.GLASS_BOTTLE;
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            };
            if (refill == 0) return;

            final Block b = e.getClickedBlock().get();
            final int water = ChunkPDC.getOrCreateDefault(b, GastroKeys.FERMENTER_WATER, 0);
            if (water == getCapacity()) {
                e.cancel();
                return;
            }

            ChunkPDC.set(b, GastroKeys.FERMENTER_WATER, Math.min(water + refill, getCapacity()));
            b.getWorld().playSound(b.getLocation(), Sound.ITEM_BUCKET_FILL, SoundCategory.PLAYERS, 1f, 1f);
            e.getItem().setType(ret);
        });

        addItemHandler(new SimpleBlockBreakHandler() {
            @Override
            public void onBlockBreak(Block b) {
                ChunkPDC.remove(b, GastroKeys.FERMENTER_WATER);
            }
        });
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
    protected boolean canCraft(BlockMenu menu, Block b, Player p) {
        final int water = ChunkPDC.getOrCreateDefault(b, GastroKeys.FERMENTER_WATER, 0);
        if (water < getMbPerCraft()) return false;

        ChunkPDC.set(b, GastroKeys.FERMENTER_WATER, water - getMbPerCraft());
        return true;
    }

}
