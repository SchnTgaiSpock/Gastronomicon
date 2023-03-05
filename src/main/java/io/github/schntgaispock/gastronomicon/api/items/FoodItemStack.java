package io.github.schntgaispock.gastronomicon.api.items;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;

import io.github.schntgaispock.gastronomicon.api.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.schntgaispock.gastronomicon.util.item.HeadTextures;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import lombok.Getter;
import lombok.ToString;

/**
 * A FoodItemStack stores the effects of a GastroFood.
 * 
 * @author SchnTgaiSpock
 */
@Getter
@ToString(exclude = "perfectLore")
public class FoodItemStack extends SlimefunItemStack {

    private final int hunger;
    private final double saturation;
    private final String texture;
    private final @Nonnull FoodEffect[] effects;
    private final String[] perfectLore;
    private final boolean perfect;

    @ParametersAreNonnullByDefault
    protected FoodItemStack(String id, String texture, String name, int hunger, double saturation, FoodEffect[] effects,
        String[] lore, String[] perfectLore, boolean perfect) {
        super(id, texture, name, lore);

        this.hunger = hunger;
        this.saturation = saturation;
        this.texture = texture;
        this.effects = effects;
        this.perfectLore = perfectLore;
        this.perfect = perfect;

    }

    @ParametersAreNonnullByDefault
    protected FoodItemStack(String id, Material material, String name, int hunger, double saturation,
        FoodEffect[] effects, String[] lore, String[] perfectLore, boolean perfect) {
        super(id, material, name, lore);

        this.hunger = hunger;
        this.saturation = saturation;
        this.texture = HeadTextures.NONE;
        this.effects = effects;
        this.perfectLore = perfectLore;
        this.perfect = perfect;
    }

    @ParametersAreNonnullByDefault
    protected FoodItemStack(String id, String texture, String name, int hunger, double saturation, FoodEffect[] effects,
        String[] lore, boolean perfect) {
        this(id, texture, name, hunger, saturation, effects, lore, lore, perfect);
    }

    @ParametersAreNonnullByDefault
    protected FoodItemStack(String id, Material material, String name, int hunger, double saturation,
        FoodEffect[] effects, String[] lore, boolean perfect) {
        this(id, material, name, hunger, saturation, effects, lore, lore, perfect);
    }

    private static String[] getFormattedLore(boolean isPerfect, int hunger, FoodEffect[] effects, String[] lore) {
        final List<String> fLore = new LinkedList<String>();

        fLore.add(LoreBuilder.hunger(hunger));

        if (effects != null && effects.length > 0) {
            fLore.add("");
            fLore.add("&7When consumed:");
            for (FoodEffect effect : effects) {
                fLore.add("&8‑ " + (isPerfect ? effect.getPerfectDescription() : effect.getDescription()));
            }
        }

        if (lore.length != 0) {
            fLore.add("");
            for (String loreLine : lore) {
                fLore.add((isPerfect ? GastroTheme.PERFECT_FOOD : GastroTheme.REGULAR_FOOD).getLoreColor() + loreLine);
            }
        }

        return fLore.toArray(String[]::new);
    }

    @ParametersAreNonnullByDefault
    public static FoodItemStack of(String id, Material material, String name, int hunger, double saturationRatio,
        FoodEffect[] effects, String[] lore, String[] perfectLore) {
            return new FoodItemStack(id, material, GastroTheme.REGULAR_FOOD.getColor() + name, hunger,
            NumberUtil.roundToPrecision(hunger * saturationRatio, 1), effects,
            getFormattedLore(false, hunger, effects, lore), getFormattedLore(true, hunger, effects, perfectLore), false);
    }

    @ParametersAreNonnullByDefault
    public static FoodItemStack of(String id, String texture, String name, int hunger, double saturationRatio,
        FoodEffect[] effects, String[] lore, String[] perfectLore) {
            return new FoodItemStack(id, texture, GastroTheme.REGULAR_FOOD.getColor() + name, hunger,
            NumberUtil.roundToPrecision(hunger * saturationRatio, 1), effects,
            getFormattedLore(false, hunger, effects, lore), getFormattedLore(true, hunger, effects, perfectLore), false);
    }

    public FoodItemStack asPerfect() {
        if (isPerfect()) {
            return this;
        }
        return new FoodItemStack("GN_PERFECT" + getItemId().substring(2), getTexture(),
            GastroTheme.PERFECT_FOOD.getColor() + ChatUtils.removeColorCodes(getDisplayName()), hunger, saturation,
            effects, perfectLore, perfectLore, true);
    }
}
