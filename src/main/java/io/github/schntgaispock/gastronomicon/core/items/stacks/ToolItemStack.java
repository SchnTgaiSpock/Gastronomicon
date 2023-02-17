package io.github.schntgaispock.gastronomicon.core.items.stacks;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import io.github.schntgaispock.gastronomicon.util.GastroKeys;
import io.github.schntgaispock.gastronomicon.util.GastroTheme.Theme;
import lombok.Getter;

@Getter
public class ToolItemStack extends ThemedItemStack {

    @ParametersAreNonnullByDefault
    protected ToolItemStack(String id, Material material, String name, String... lore) {
        super(id, material, name, lore);
    }

    @ParametersAreNonnullByDefault
    public static ToolItemStack of(Theme theme, String id, Material material, int durability, String name, String... lore) {
        if (id == null || material == null) return null;

        String durabilityLine = ChatColor.translateAlternateColorCodes('&', "&7Durability: " + durability + "/" + durability);
        ToolItemStack stack;

        int i = 0;
        if (lore.length > 0) {
            String[] fLore = new String[lore.length + 3];
            fLore[0] = "";

            for (i = 0; i < lore.length; i++) {
                fLore[i + 1] = theme.getLoreColor() + lore[i];
            }

            fLore[i + 1] = durabilityLine;

            stack = new ToolItemStack(id, material, theme.getColor() + name, fLore);
        } else {
            stack = new ToolItemStack(id, material, theme.getColor() + name, "", durabilityLine);
        }

        ItemMeta meta = stack.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.set(GastroKeys.TOOL_DURABILITY, PersistentDataType.INTEGER, durability);
        pdc.set(GastroKeys.TOOL_MAX_DURABILITY, PersistentDataType.INTEGER, durability);
        pdc.set(GastroKeys.TOOL_DURABILITY_LINE, PersistentDataType.INTEGER, i + 1);

        return stack;
    }
}
