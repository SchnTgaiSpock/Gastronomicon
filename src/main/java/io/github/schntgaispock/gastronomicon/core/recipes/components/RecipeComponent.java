package io.github.schntgaispock.gastronomicon.core.recipes.components;

import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a component of a recipe. Can be a single item or a group
 * 
 * @author SchnTgaiSpock
 */
@Getter
@AllArgsConstructor
@ToString
public abstract class RecipeComponent<T> {

    protected final T component;

    /**
     * Whether or not this component matches an item
     * @param item The item to check
     * @return If the item matched
     */
    public abstract boolean matches(@Nullable ItemStack item);

    /**
     * @return The item to display in the Slimefun guide
     */
    public abstract ItemStack getDisplayItem();

    @Override
    public abstract int hashCode();

    public static final RecipeComponent<Void> EMPTY = new RecipeComponent<>(null) {

        private final ItemStack displayItem = new ItemStack(Material.AIR);

        @Override
        public boolean matches(@Nullable ItemStack item) {
            return (item == null) || (item.getType() == Material.AIR);
        }

        @Override
        public ItemStack getDisplayItem() {
            return displayItem.clone();
        }

        @Override
        public int hashCode() {
            return displayItem.hashCode();
        }

    };
}
