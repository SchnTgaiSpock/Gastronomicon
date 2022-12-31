package io.github.schntgaispock.gastronomicon.core.recipes.components;

import org.bukkit.inventory.ItemStack;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "component")
public abstract class AbstractGastroRecipeComponent<T> {
    protected final T component;
    public abstract boolean matches(ItemStack item);
    public abstract ItemStack getDisplayItem();
}
