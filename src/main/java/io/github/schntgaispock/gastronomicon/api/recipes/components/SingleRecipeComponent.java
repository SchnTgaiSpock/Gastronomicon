package io.github.schntgaispock.gastronomicon.api.recipes.components;

import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.item.ItemUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;

/**
 * For recipe slots that require a certain item
 * 
 * Examples:
 * - The wool in a bed
 * - The stick in a stone sword
 * 
 * @author SchnTgaiSpock
 */
@Getter
public class SingleRecipeComponent extends RecipeComponent<ItemStack> {

    public SingleRecipeComponent(ItemStack component) {
        super(component);
    }

    // SingleRecipeComponents do not have to deal with group components in recipes
    @Override
    public boolean matches(@Nullable ItemStack item) {
        if (item == null) {
            return component.getType() == Material.AIR;
        } else if (component instanceof final SlimefunItemStack sfStack) {
            return SlimefunItem.getById(sfStack.getItemId()).isItem(item);
        } else {
            return item.isSimilar(component);
        }
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
