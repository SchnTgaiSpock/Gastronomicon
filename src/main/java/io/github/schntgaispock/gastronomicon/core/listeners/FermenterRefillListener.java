package io.github.schntgaispock.gastronomicon.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.workstations.manual.Fermenter;
import io.github.schntgaispock.gastronomicon.util.ChunkPDC;
import io.github.schntgaispock.gastronomicon.util.item.GastroKeys;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

public class FermenterRefillListener implements Listener {

    // because for some bs reason Fermenter won't let me add a BlockUseHandler
    @EventHandler
    public void onRefill(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK || !e.getPlayer().isSneaking())
            return;

        if (e.getItem() == null) {
            return;
        }

        final Block b = e.getClickedBlock();
        if (b == null)
            return;

        if (!Slimefun.getProtectionManager().hasPermission(e.getPlayer(), b, Interaction.INTERACT_BLOCK))
            return;

        final SlimefunItem sfItem = BlockStorage.check(b);
        if (sfItem == null || !(sfItem instanceof final Fermenter fermenter))
            return;

        final Integer water = ChunkPDC.getInt(b, GastroKeys.FERMENTER_WATER);
        if (water == null)
            return;

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
        }
        if (refill == 0)
            return;

        e.setCancelled(true);
        if (water == fermenter.getCapacity()) {
            return;
        }

        ChunkPDC.set(b, GastroKeys.FERMENTER_WATER, Math.min(water + refill, fermenter.getCapacity()));
        b.getWorld().playSound(b.getLocation(), Sound.ITEM_BUCKET_FILL, SoundCategory.PLAYERS, 1f, 1f);

        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.getItem().setType(ret);
        }
    }

    public static void setup() {
        Bukkit.getPluginManager().registerEvents(new FermenterRefillListener(), Gastronomicon.getInstance());
    }

}
