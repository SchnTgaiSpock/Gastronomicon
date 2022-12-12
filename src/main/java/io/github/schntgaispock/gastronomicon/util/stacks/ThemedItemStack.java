package io.github.schntgaispock.gastronomicon.util.stacks;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.schntgaispock.gastronomicon.util.GastroTheme.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

@SuppressWarnings("null")
public class ThemedItemStack extends SlimefunItemStack {

    @ParametersAreNonnullByDefault
    protected ThemedItemStack(String id, Material material, String name, String... lore) {
        super(id, material, name, lore);
    }

    @Override
    public @Nonnull Material getType() {
        Material type = super.getType();
        return (type == null) ? Material.BARRIER : type;
    }

    public @Nonnull String getDisplayName() {
        String name = getDisplayName();
        return (name == null) ? "NO NAME GIVEN" : name;
    }

    @ParametersAreNonnullByDefault
    public static ThemedItemStack of(Theme theme, String id, Material material, String name, String... lore) {
        if (id == null || material == null) return null;
        if (lore.length > 0) {
            String[] fLore = new String[lore.length + 1];
            fLore[0] = "";

            for (int i = 0; i < lore.length; i++) {
                fLore[i + 1] = theme.getLoreColor() + lore[i];
            }

            return new ThemedItemStack(id, material, theme.getColor() + name, fLore);
        } else {
            return new ThemedItemStack(id, material, theme.getColor() + name);
        }
    }

    public ThemedItemStack enchant(Enchantment... enchantments) {
        for (Enchantment enchantment : enchantments) {
            enchant(enchantment, 1);
        }
        return this;
    }

    public ThemedItemStack enchant(Enchantment enchantment, int level) {
        addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ThemedItemStack glisten() {
        return enchant(Enchantment.DURABILITY).addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public ThemedItemStack addFlags(ItemFlag... flags) {
        ItemMeta meta = getItemMeta();
        meta.addItemFlags(flags);
        setItemMeta(meta);
        return this;
    }
}
