package io.github.schntgaispock.gastronomicon.core.items.stacks;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import io.github.schntgaispock.gastronomicon.core.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.core.items.stacks.GastroTheme.Theme;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import lombok.Getter;

@Getter
public class FoodItemStack extends SlimefunItemStack {

    private final int hunger;
    private final double saturation;
    private final String texture;
    private final @Nonnull FoodEffect[] effects;
    private final String[] perfectLore;

    @ParametersAreNonnullByDefault
    protected FoodItemStack(String id, String texture, String name, int hunger, double saturation, FoodEffect[] effects, String[] lore, String[] perfectLore) {
        super(id, texture, name, lore);

        this.hunger = hunger;
        this.saturation = saturation;
        this.texture = texture;
        this.effects = effects;
        this.perfectLore = perfectLore;
    }

    @ParametersAreNonnullByDefault
    protected FoodItemStack(String id, String texture, String name, int hunger, double saturation, FoodEffect[] effects, String... lore) {
        this(id, texture, name, hunger, saturation, effects, lore, lore);
    }

    @ParametersAreNonnullByDefault
    public static FoodItemStack of(String id, String texture, String name, int hunger, double saturationRatio, FoodEffect[] effects, String... lore) {
        if (id == null || texture == null) return null;

        List<String> fLore = new LinkedList<String>();

        fLore.add(LoreBuilder.hunger(hunger));
        fLore.add("");
        fLore.add("&7Effects when consumed:");
        for (FoodEffect effect : effects) {
            fLore.add("&8‑ " + effect.getDescription());
        }
        if (lore.length != 0) fLore.add("");
        for (String loreLine : lore) {
            fLore.add(Theme.REGULAR_FOOD.getLoreColor() + loreLine);
        }

        return new FoodItemStack(id, texture, Theme.REGULAR_FOOD.getColor() + name, hunger, NumberUtil.roundToPrecision(hunger * saturationRatio, 1), effects, fLore.toArray(String[]::new));
    }

    @ParametersAreNonnullByDefault
    public static FoodItemStack of(String id, String texture, String name, int hunger, double saturationRatio, FoodEffect effect, String... lore) {
        return of(id, texture, name, hunger, Math.round(hunger*saturationRatio), new FoodEffect[]{ effect }, lore);
    }

    @ParametersAreNonnullByDefault
    public static FoodItemStack of(String id, String texture, String name, int hunger, double saturationRatio, String... lore) {
        return of(id, texture, name, hunger, Math.round(hunger*saturationRatio), new FoodEffect[]{}, lore);
    }    

    @ParametersAreNonnullByDefault
    public FoodItemStack getPerfect() {
        List<String> fLore = new LinkedList<String>();

        fLore.add(LoreBuilder.hunger(hunger));
        fLore.add("");
        fLore.add("&7Effects when consumed:");
        for (FoodEffect effect : effects) {
            fLore.add("&8‑ " + effect.getPerfectDescription());
        }
        if (perfectLore.length != 0) fLore.add("");
        for (String loreLine : perfectLore) {
            fLore.add(Theme.PERFECT_FOOD.getLoreColor() + loreLine);
        }

        return new FoodItemStack("GN_PERFECT" + getItemId().substring(2), getTexture(), Theme.PERFECT_FOOD.getColor() + "Perfect " + ChatUtils.removeColorCodes(getDisplayName()), hunger, saturation, effects, fLore.toArray(String[]::new));
    }

}
