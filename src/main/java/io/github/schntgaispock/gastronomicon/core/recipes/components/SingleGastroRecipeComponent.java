package io.github.schntgaispock.gastronomicon.core.recipes.components;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.GastroUtil;
import lombok.Getter;

/**
 * For recipe slots that require a certain item
 * 
 * Examples:
 * - The wool in a bed
 * - The stick in a stone sword
 */
@Getter
public class SingleGastroRecipeComponent extends GastroRecipeComponent<ItemStack> {

    public SingleGastroRecipeComponent(ItemStack component) {
        super(component);
    }

    // SingleGastroRecipeComponents do not have to deal with group components in recipes
    @Override
    public boolean matches(Object item) {
        return (item == null) ? (component.getType() == Material.AIR) : (item instanceof final ItemStack single) && single.isSimilar(component);
    }

    @Override
    public ItemStack getDisplayItem() {
        return component;
    }

    @Override
    public int hashCode() {
        return GastroUtil.hashIgnoreAmount(component);
    }

}
