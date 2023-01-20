package io.github.schntgaispock.gastronomicon.core.recipes.components;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class GastroRecipeComponent<T> {
    protected final T component;
    public abstract boolean matches(Object item);
    public abstract ItemStack getDisplayItem();

    public static GastroRecipeComponent<Void> EMPTY = new GastroRecipeComponent<Void>(null) {

        private final ItemStack displayItem = new ItemStack(Material.AIR);

        @Override
        public boolean matches(Object item) {
            return (item == null) || (item instanceof final ItemStack stack) && (stack.getType() == Material.AIR);
        }

        @Override
        public ItemStack getDisplayItem() {
            return displayItem;
        }

    };
}
