package io.github.schntgaispock.gastronomicon.core.recipes;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.recipes.components.GroupGastroRecipeComponent;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroRecipeRegistry {
    
    private static Map<Integer, Set<AbstractGastroRecipe>> recipes;
    private static Map<ItemStack, Set<GroupGastroRecipeComponent>> groupComponentsByItemStack;

    @Nonnull
    public static Set<GroupGastroRecipeComponent> getGroups(ItemStack item) {
        Set<GroupGastroRecipeComponent> groups = groupComponentsByItemStack.get(item);
        return (groups == null) ? new HashSet<>() : groups;
    }

    public static void registerGroup(GroupGastroRecipeComponent group) {
        for (ItemStack itemStack : group.getComponent()) {
            if (groupComponentsByItemStack.containsKey(itemStack)) {
                groupComponentsByItemStack.get(itemStack).add(group);
            } else {
                Set<GroupGastroRecipeComponent> groups = new HashSet<>();
                groups.add(group);
                groupComponentsByItemStack.put(itemStack, groups);
            }
        }
    }

    /**
     * s
     * @param inputHash The hashCode of the inputs
     * @return
     */
    @Nonnull
    public static Set<AbstractGastroRecipe> getSimilarRecipes(int inputHash) {
        Set<AbstractGastroRecipe> similarRecipes = recipes.get(inputHash);
        return (similarRecipes == null) ? new HashSet<>() : similarRecipes;
    }

    public static void registerRecipe(AbstractGastroRecipe recipe) {
        int inputHash = recipe.inputHash();
        if (recipes.containsKey(inputHash)) {
            recipes.get(inputHash).add(recipe);
        } else {
            Set<AbstractGastroRecipe> similarRecipes = new HashSet<>();
            similarRecipes.add(recipe);
            recipes.put(inputHash, similarRecipes);
        }
    }

}
