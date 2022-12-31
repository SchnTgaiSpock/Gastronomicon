package io.github.schntgaispock.gastronomicon.core.recipes.components;

import org.bukkit.inventory.ItemStack;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * For recipe slots that require a certain item
 * 
 * Examples:
 * - The wool in a bed
 * - The stick in a stone sword
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class SingleGastroRecipeComponent extends AbstractGastroRecipeComponent<ItemStack> {

    public SingleGastroRecipeComponent(ItemStack component) {
        super(component);
    }

    @Override
    public boolean matches(ItemStack item) {
        return item.isSimilar(component);
    }

    @Override
    public ItemStack getDisplayItem() {
        return component;
    }

}
