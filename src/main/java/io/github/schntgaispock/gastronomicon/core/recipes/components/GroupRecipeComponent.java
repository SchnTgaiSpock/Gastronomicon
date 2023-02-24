package io.github.schntgaispock.gastronomicon.core.recipes.components;

import java.util.Set;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;

/**
 * For recipe slots that have multiple acceptable items.
 * <hr>
 * Examples:
 * <ul>
 * <li>The wood in a bed
 * <li>The cobblestone in a stone sword
 * </ul>
 */
@Getter
public class GroupRecipeComponent extends RecipeComponent<Set<ItemStack>> {

    private final @Getter NamespacedKey id;

    public GroupRecipeComponent(Set<ItemStack> component, NamespacedKey id) {
        super(component);

        this.id = id;
    }

    @Override
    public boolean matches(ItemStack item) {
        if (item == null) {
            return false;
        } else {
            for (final ItemStack groupItem : component) {
                if (item.isSimilar(groupItem))
                    return true;
            }
        }

        return false;
    }

    @Override
    public ItemStack getDisplayItem() {
        for (final ItemStack itemStack : component) {
            return itemStack.clone();
        }

        return new ItemStack(Material.AIR);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
