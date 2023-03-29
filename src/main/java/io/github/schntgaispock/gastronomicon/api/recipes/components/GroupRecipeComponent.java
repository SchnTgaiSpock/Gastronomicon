package io.github.schntgaispock.gastronomicon.api.recipes.components;

import java.util.Arrays;
import java.util.Set;

import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;

/**
 * For recipe slots that have multiple acceptable items.
 * <hr>
 * Examples:
 * <ul>
 * <li>The wood in a bed
 * <li>The cobblestone in a stone sword
 * </ul>
 * 
 * @author SchnTgaiSpock
 */
@Getter
public class GroupRecipeComponent extends RecipeComponent<Set<ItemStack>> {

    private final @Getter NamespacedKey id;

    public GroupRecipeComponent(NamespacedKey id, Set<ItemStack> component) {
        super(component);

        this.id = id;
    }

    public GroupRecipeComponent(NamespacedKey id, ItemStack... component) {
        this(id, Set.of(component));
    }

    public GroupRecipeComponent(NamespacedKey id, Material... component) {
        this(id, Set.of(Arrays.stream(component).map(material -> new ItemStack(material)).toArray(ItemStack[]::new)));
    }

    @Override
    @SuppressWarnings("null")
    public boolean matches(@Nullable ItemStack item) {
        if (item == null) {
            return false;
        } else {
            for (final ItemStack groupItem : component) {
                if (groupItem instanceof final SlimefunItemStack sfStack) {
                    return SlimefunItem.getById(sfStack.getItemId()).isItem(item);
                } else {
                    return item.isSimilar(groupItem);
                }
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
