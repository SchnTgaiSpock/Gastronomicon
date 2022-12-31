package io.github.schntgaispock.gastronomicon.core.recipes.components;

import java.util.Set;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * For recipe slots that have multiple acceptable items
 * 
 * Examples:
 * - The wood in a bed
 * - The cobblestone in a stone sword
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class GroupGastroRecipeComponent extends AbstractGastroRecipeComponent<Set<ItemStack>> {

    public GroupGastroRecipeComponent(Set<ItemStack> component) {
        super(component);
    }

    @Override
    public boolean matches(ItemStack item) {
        for (ItemStack groupItem : component) {
            if (item.isSimilar(groupItem)) return true;
        }

        return false;
    }

    @Override
    public ItemStack getDisplayItem() {
        for (ItemStack itemStack : component) {
            return itemStack;
        }

        return new ItemStack(Material.AIR);
    }

}
