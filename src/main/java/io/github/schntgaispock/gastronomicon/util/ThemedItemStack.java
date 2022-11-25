package io.github.schntgaispock.gastronomicon.util;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.schntgaispock.gastronomicon.util.GastroTheme.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public class ThemedItemStack extends SlimefunItemStack {

    private ThemedItemStack(@Nonnull String id, @Nonnull Material material, @Nonnull String name, String... lore) {
        super(id, material, name, lore);
    }

    @Override
    public @Nonnull Material getType() {
        Material type = getType();
        return (type == null) ? Material.BARRIER : type;
    }

    public @Nonnull String getDisplayName() {
        String name = getDisplayName();
        return (name == null) ? "NO NAME GIVEN" : name;
    }


    public static ThemedItemStack of(Theme theme, String id, Material material, String name, String... lore) {
        if (id == null || material == null) return null;
        if (lore.length > 0) {
            String[] flore = new String[lore.length + 1];
            flore[0] = "";

            for (int i = 0; i < lore.length; i++) {
                flore[i + 1] = theme.getLoreColor() + lore[i];
            }

            return new ThemedItemStack(id, material, theme.getColor() + name, flore);
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

    public ThemedItemStack asPerfect(String... lore) {
        return new ThemedItemStack("GN_PERFECT" + getItemId().substring(2), getType(), Theme.PERFECT_FOOD + getDisplayName().substring(7), lore).glisten();
    }
    
}
