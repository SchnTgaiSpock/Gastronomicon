package io.github.schntgaispock.gastronomicon.util;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeComponent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RecipeUtil {

    public static ItemStack[] empty() {
        return new ItemStack[9];
    }

    public static ItemStack[] single(ItemStack item) {
        final ItemStack[] recipe = new ItemStack[9];
        recipe[0] = item;
        return recipe;
    }

    public static ItemStack[] singleCenter(Material item) {
        final ItemStack[] recipe = new ItemStack[9];
        recipe[4] = new ItemStack(item);
        return recipe;
    }

    public static ItemStack[] singleCenter(ItemStack item) {
        final ItemStack[] recipe = new ItemStack[9];
        recipe[4] = item;
        return recipe;
    }

    public static ItemStack[] collection(ItemStack... items) {
        return RecipeUtil.collection(items, 9);
    }

    private static ItemStack[] collection(ItemStack[] items, int maxLength) {
        final ItemStack[] recipe = new ItemStack[9];

        int l = Math.min(items.length, maxLength);
        for (int i = 0; i < l; i++) {
            recipe[i] = items[i];
        }
        return recipe;
    }

    public static ItemStack[] cyclic(ItemStack outer, ItemStack inner) {
        return new ItemStack[] { outer, outer, outer, outer, inner, outer, outer, outer, outer };
    }

    public static ItemStack[] cyclic(ItemStack outer) {
        return RecipeUtil.cyclic(outer, null);
    }

    public static ItemStack[] cyclicAlternating(ItemStack corner, ItemStack middle, ItemStack inner) {
        return new ItemStack[] { corner, middle, corner, middle, inner, middle, corner, middle, corner };
    }

    public static ItemStack[] cyclicAlternating(ItemStack corner, ItemStack middle) {
        return RecipeUtil.cyclicAlternating(corner, middle, null);
    }

    public static ItemStack[] row(ItemStack item, int rowNumber) {
        final int rowStart = NumberUtil.clamp(rowNumber, 0, 2) * 3;
        final ItemStack[] recipe = new ItemStack[9];
        recipe[rowStart] = recipe[rowStart + 1] = recipe[rowStart + 2] = item;

        return recipe;
    }

    public static ItemStack[] column(ItemStack item, int colNumber) {
        final int colStart = NumberUtil.clamp(colNumber, 0, 2);
        final ItemStack[] recipe = new ItemStack[9];
        recipe[colStart] = recipe[colStart + 3] = recipe[colStart + 6] = item;

        return recipe;
    }

    public static ItemStack[] diagonal(ItemStack item, int slope) {
        final ItemStack[] recipe = new ItemStack[9];
        if (slope == 1)
            recipe[2] = recipe[4] = recipe[6] = item;
        else if (slope == -1)
            recipe[0] = recipe[4] = recipe[8] = item;

        return recipe;
    }

    public static ItemStack[] block(ItemStack item) {
        final ItemStack[] recipe = new ItemStack[9];
        Arrays.fill(recipe, item);
        return recipe;
    }

    public static int compareComponents(RecipeComponent<?> component1, RecipeComponent<?> component2) {
        return Integer.compare(recipeHash(component1 == null ? null : component1.getComponent()),
            recipeHash(component2 == null ? null : component2.getComponent()));
    }

    public static int compareItemStacks(ItemStack item1, ItemStack item2) {
        return Integer.compare(recipeHash(item1 == null ? null : item1), recipeHash(item2 == null ? null : item2));
    }

    public static int recipeHash(Object object) {
        if (object == null)
            return Integer.MAX_VALUE;
        if (object instanceof final SlimefunItemStack sfStack)
            return sfStack.getItemId().hashCode();
        if (object instanceof final ItemStack stack) {
            final SlimefunItem sfItem = SlimefunItem.getByItem(stack);
            if (sfItem != null) {
                return sfItem.getId().hashCode();
            }
            return stack.getType().hashCode();
        }

        return object.hashCode();
    }

}
