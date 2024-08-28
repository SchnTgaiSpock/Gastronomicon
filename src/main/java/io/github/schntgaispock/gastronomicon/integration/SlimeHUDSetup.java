package io.github.schntgaispock.gastronomicon.integration;

import java.util.List;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.slimefun.items.workstations.automatic.ElectricKitchen;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.workstations.automatic.FishingNet;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.workstations.manual.Fermenter;
import io.github.schntgaispock.gastronomicon.util.ChunkPDC;
import io.github.schntgaispock.gastronomicon.util.item.GastroKeys;
import io.github.schntgaispock.slimehud.SlimeHUD;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;

@UtilityClass
public class SlimeHUDSetup {

    @SuppressWarnings("deprecation")
    public static void setup() {
        // Electric Kitchen
        SlimeHUD.getHudController().registerCustomHandler(ElectricKitchen.class, request -> {
            final BlockMenu menu = BlockStorage.getInventory(request.getLocation());
            if (menu == null) return "";
            final ItemStack item = menu.getItemInSlot(15);
            if (item == null) return "&7No android";
            final SlimefunItem sfItem = SlimefunItem.getByItem(item);
            if (sfItem == null || !sfItem.getId().equals("GN_CHEF_ANDROID")) return "&7No android";
            final List<String> lore = item.getLore();
            if (lore == null || lore.size() < 1) return "";
            return "&7" + lore.get(0);
        });

        // Fishing Net
        SlimeHUD.getHudController().registerCustomHandler(FishingNet.class, request -> {
            return ((FishingNet) request.getSlimefunItem()).getMachineProcessor().getOperation(request.getLocation()) == null ? "&7Not in water" : "";
        });

        // Fermenter
        SlimeHUD.getHudController().registerCustomHandler(Fermenter.class, request -> {
            final Fermenter fermenter = (Fermenter) request.getSlimefunItem();
            return "&7&9🪣 &7" + ChunkPDC.getOrCreateDefault(request.getLocation().getBlock(), GastroKeys.FERMENTER_WATER, 0) + "/" + fermenter.getCapacity() + " mB";
        });
    }

}
