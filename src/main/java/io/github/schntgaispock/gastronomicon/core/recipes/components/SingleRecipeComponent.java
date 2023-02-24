package io.github.schntgaispock.gastronomicon.core.recipes.components;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.ItemUtil;
import lombok.Getter;

/**
 * For recipe slots that require a certain item
 * 
 * Examples:
 * - The wool in a bed
 * - The stick in a stone sword
 */
@Getter
public class SingleRecipeComponent extends RecipeComponent<ItemStack> {

    public SingleRecipeComponent(ItemStack component) {
        super(component);
    }

    // SingleRecipeComponents do not have to deal with group components in recipes
    @Override
    public boolean matches(ItemStack item) {
        return (item == null) ? (component.getType() == Material.AIR) : item.isSimilar(component);
    }

    @Override
    public ItemStack getDisplayItem() {
        return component.clone();
    }

    @Override
    public int hashCode() {
        return ItemUtil.hashIgnoreAmount(component);
    }

}
