package io.github.schntgaispock.gastronomicon.core.recipes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.core.recipes.components.GroupGastroRecipeComponent;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroRecipeRegistry {
    
    private static Map<Integer, Set<GastroRecipe>> shapedRecipes = new HashMap<>();
    private static Map<Integer, Set<GastroRecipe>> shapelessRecipes = new HashMap<>();
    private static Map<ItemStack, Set<GroupGastroRecipeComponent>> groupsByItemStack = new HashMap<>();
    private static Map<String, GroupGastroRecipeComponent> groupsByName = new HashMap<>();


    @Nonnull
    public static Set<GroupGastroRecipeComponent> getGroups(ItemStack item) {
        Set<GroupGastroRecipeComponent> groups = groupsByItemStack.get(item);
        return (groups == null) ? new HashSet<>() : groups;
    }

    public static GroupGastroRecipeComponent getGroupByName(String name) {
        return groupsByName.get(name);
    }

    private static void registerGroup(GroupGastroRecipeComponent group) {
        for (ItemStack itemStack : group.getComponent()) {
            if (groupsByItemStack.containsKey(itemStack)) {
                groupsByItemStack.get(itemStack).add(group);
            } else {
                Set<GroupGastroRecipeComponent> groups = new HashSet<>();
                groups.add(group);
                groupsByItemStack.put(itemStack, groups);
            }
        }
    }

    public static void registerGroups(GroupGastroRecipeComponent... groups) {
        for (GroupGastroRecipeComponent group : groups) {
            registerGroup(group);
        }
    }
    
    @Nonnull
    @SuppressWarnings("null")
    public static Set<GastroRecipe> getSimilarRecipes(int inputHash, RecipeShape shape) {
        Set<GastroRecipe> similarRecipes = (switch (shape) {
            case SHAPED -> shapedRecipes;
            case SHAPELESS -> shapelessRecipes;
        }).get(inputHash);
        return (similarRecipes == null) ? new HashSet<>() : similarRecipes;
    }

    private static void registerRecipe(GastroRecipe recipe, Map<Integer, Set<GastroRecipe>> registry) {
        int inputHash = recipe.inputHash();
        if (registry.containsKey(inputHash)) {
            registry.get(inputHash).add(recipe);
        } else {
            Set<GastroRecipe> similarRecipes = new HashSet<>();
            similarRecipes.add(recipe);
            registry.put(inputHash, similarRecipes);
        }
    }

    public static void registerRecipe(GastroRecipe recipe, RecipeShape shape) {
        registerRecipe(recipe, switch (shape) {
            case SHAPED -> shapedRecipes;
            case SHAPELESS -> shapelessRecipes;
        });
    }

    public static void registerShapedRecipes(GastroRecipe... recipes) {
        for (GastroRecipe recipe : recipes) {
            registerRecipe(recipe, shapedRecipes);
        }
    }

    public static void registerShapelessRecipes(GastroRecipe... recipes) {
        for (GastroRecipe recipe : recipes) {
            registerRecipe(recipe, shapelessRecipes);
        }
    }

}
