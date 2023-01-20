package io.github.schntgaispock.gastronomicon.core.recipes.components;

import java.util.LinkedHashSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.GastroUtil;
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
public class GroupGastroRecipeComponent extends GastroRecipeComponent<Set<ItemStack>> {

    private final @Getter String name;

    public GroupGastroRecipeComponent(LinkedHashSet<ItemStack> component, String name) {
        super(component);

        this.name = name;
    }

    public static void add(ItemStack... items) {
        
    }

    @Override
    public boolean matches(Object item) {
        if (item == null) {
            return false; // Groups cannot be empty
        } else if (item instanceof final GroupGastroRecipeComponent group) {
            return group.getName().equals(name);
        } else if (item instanceof final ItemStack single) {
            for (ItemStack groupItem : component) {
                if (single.isSimilar(groupItem))
                    return true;
            }
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

    @Override
    public int hashCode() {

        int hash = 1;

        for (ItemStack itemStack : component) {
            hash = hash * 31 + GastroUtil.hashIgnoreAmount(itemStack);
        }

        return hash;
    }

}
