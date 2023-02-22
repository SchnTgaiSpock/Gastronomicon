package io.github.schntgaispock.gastronomicon.core.items.workstations;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import io.github.schntgaispock.gastronomicon.core.items.UnplaceableItem;
import io.github.schntgaispock.gastronomicon.util.GastroKeys;
import io.github.schntgaispock.gastronomicon.util.GastroUtil;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import net.kyori.adventure.text.Component;

public class WorkstationTool extends UnplaceableItem {

    public WorkstationTool(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    public static void removeDurability(ItemStack item, int amount) {
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();

        int durability = pdc.get(GastroKeys.TOOL_DURABILITY, PersistentDataType.INTEGER);
        int max_durability = pdc.get(GastroKeys.TOOL_MAX_DURABILITY, PersistentDataType.INTEGER);
        int durability_line = pdc.get(GastroKeys.TOOL_DURABILITY_LINE, PersistentDataType.INTEGER);

        pdc.set(GastroKeys.TOOL_DURABILITY, PersistentDataType.INTEGER, GastroUtil.clamp(0, durability - amount, max_durability));
        meta.lore().set(durability_line, Component.text(GastroUtil.formatColors("&7Durability: " + durability + "/" + max_durability)));
        item.setItemMeta(meta);
    }

    public static void repair(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();

        int max_durability = pdc.get(GastroKeys.TOOL_MAX_DURABILITY, PersistentDataType.INTEGER);
        int durability_line = pdc.get(GastroKeys.TOOL_DURABILITY_LINE, PersistentDataType.INTEGER);

        pdc.set(GastroKeys.TOOL_DURABILITY, PersistentDataType.INTEGER, max_durability);
        meta.lore().set(durability_line, Component.text(GastroUtil.formatColors("&7Durability: " + max_durability + "/" + max_durability)));
        item.setItemMeta(meta);
    }
    
}
