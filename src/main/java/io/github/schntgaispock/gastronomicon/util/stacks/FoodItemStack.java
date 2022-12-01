package io.github.schntgaispock.gastronomicon.util.stacks;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;

import io.github.schntgaispock.gastronomicon.util.GastroTheme.Theme;
import lombok.Getter;

@SuppressWarnings("null")
public class FoodItemStack extends ThemedItemStack {

    @Nonnull @Getter String[] effects;

    @ParametersAreNonnullByDefault
    protected FoodItemStack(String id, Material material, String name, String[] effects, String... lore) {
        super(id, material, name, lore);
    }

    @ParametersAreNonnullByDefault
    public static FoodItemStack of(String id, Material material, String name, String[] effects, String... lore) {
        if (id == null || material == null) return null;

        String[] fLore = new String[lore.length + 1];
        fLore[0] = "";

        for (int i = 0; i < lore.length; i++) {
            fLore[i + 1] = Theme.REGULAR_FOOD.getLoreColor() + lore[i];
        }

        return new FoodItemStack(id, material, Theme.REGULAR_FOOD.getColor() + name, effects, fLore);
    }

    @ParametersAreNonnullByDefault
    public FoodItemStack asPerfect(String... lore) {
        String[] fLore = new String[lore.length + 1];
        fLore[0] = "";

        for (int i = 0; i < lore.length; i++) {
            fLore[i + 1] = Theme.PERFECT_FOOD.getLoreColor() + lore[i];
        }

        return new FoodItemStack(getItemId(), getType(), Theme.PERFECT_FOOD.getColor() + getDisplayName(), getEffects(), fLore);
    }

}
