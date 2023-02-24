package io.github.schntgaispock.gastronomicon.util.recipe;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.recipes.components.GroupRecipeComponent;
import io.github.schntgaispock.gastronomicon.core.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.core.recipes.components.SingleRecipeComponent;
import lombok.experimental.UtilityClass;

@UtilityClass
@SuppressWarnings("deprecation")
public class RecipeUtil {

    public static int compareComponents(RecipeComponent<?> component1,
            RecipeComponent<?> component2) {
        final String compareFrom;
        if (component1 == null || component1.getDisplayItem().getType() == Material.AIR) {
            compareFrom = "";
        } else if (component1 instanceof final SingleRecipeComponent singleC1) {
            compareFrom = singleC1.getComponent().getItemMeta().getDisplayName();
        } else if (component1 instanceof final GroupRecipeComponent groupC1) {
            compareFrom = groupC1.getId().toString();
        } else {
            compareFrom = "";
        }

        final String compareTo;
        if (component2 == null || component2.getDisplayItem().getType() == Material.AIR) {
            compareTo = "";
        } else if (component2 instanceof final SingleRecipeComponent singleC2) {
            compareTo = singleC2.getComponent().getItemMeta().getDisplayName();
        } else if (component2 instanceof final GroupRecipeComponent groupC2) {
            compareTo = groupC2.getId().toString();
        } else {
            compareTo = "";
        }

        return compareFrom.compareTo(compareTo);
    }

    public static int compareItemStacks(ItemStack item1, ItemStack item2) {
        if (item1 == null || item2 == null)
            return -1;
        return item1.getItemMeta().getDisplayName().compareTo(item2.getItemMeta().getDisplayName());
    }

}
