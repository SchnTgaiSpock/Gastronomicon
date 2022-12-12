package io.github.schntgaispock.gastronomicon.util.stacks;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import io.github.schntgaispock.gastronomicon.core.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.util.GastroTheme.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import lombok.Getter;

@SuppressWarnings("null")
@Getter
public class FoodItemStack extends SlimefunItemStack {

    private final int hunger;
    private final int saturation;
    private final String texture;
    private final @Nonnull FoodEffect[] effects;

    @ParametersAreNonnullByDefault
    protected FoodItemStack(String id, String texture, String name, int hunger, int saturation, FoodEffect[] effects, String... lore) {
        super(id, texture, name, lore);

        this.hunger = hunger;
        this.saturation = saturation;
        this.texture = texture;
        this.effects = effects;
    }

    @ParametersAreNonnullByDefault
    public static FoodItemStack of(String id, String texture, String name, int hunger, int saturation, FoodEffect[] effects, String... lore) {
        if (id == null || texture == null) return null;

        List<String> fLore = new LinkedList<String>();

        fLore.add(LoreBuilder.hunger(hunger));
        fLore.add("");
        fLore.add("&7Effects when consumed:");
        for (FoodEffect effect : effects) {
            fLore.add("&8‑ " + effect.getDescription());
        }
        fLore.add("");
        for (String loreLine : lore) {
            fLore.add(Theme.REGULAR_FOOD.getLoreColor() + loreLine);
        }

        return new FoodItemStack(id, texture, Theme.REGULAR_FOOD.getColor() + name, hunger, saturation, effects, fLore.toArray(String[]::new));
    }

    @ParametersAreNonnullByDefault
    public FoodItemStack asPerfect(String... lore) {
        List<String> fLore = new LinkedList<String>();

        fLore.add(LoreBuilder.hunger(hunger));
        fLore.add("");
        fLore.add("&7Effects when consumed:");
        for (FoodEffect effect : effects) {
            fLore.add("&8‑ " + effect.getPerfectDescription());
        }
        fLore.add("");
        for (String loreLine : lore) {
            fLore.add(Theme.PERFECT_FOOD.getLoreColor() + loreLine);
        }

        return new FoodItemStack("GN_PERFECT" + getItemId().substring(2), getTexture(), Theme.PERFECT_FOOD.getColor() + "Perfect " + ChatUtils.removeColorCodes(getDisplayName()), hunger, saturation, effects, fLore.toArray(String[]::new));
    }

}
