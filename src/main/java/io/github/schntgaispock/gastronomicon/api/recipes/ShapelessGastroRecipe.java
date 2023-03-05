package io.github.schntgaispock.gastronomicon.api.recipes;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.recipes.components.GroupRecipeComponent;
import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeInput;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.util.recipe.RecipeUtil;
import lombok.Getter;

@Getter
public class ShapelessGastroRecipe extends GastroRecipe {

    public ShapelessGastroRecipe(GastroRecipeType recipeType, RecipeComponent<?>[] inputs,
            RecipeComponent<?> container, Set<ItemStack> tools, ItemStack... outputs) {
        super(recipeType, new RecipeInput(RecipeShape.SHAPELESS, container, inputs), tools, outputs);

        for (RecipeComponent<?> component : inputs) {
            if (component instanceof GroupRecipeComponent) {
                throw new IllegalArgumentException("Shapeless Recipes do not support group tags in recipes yet!");
            }
        }
    }

    public ShapelessGastroRecipe(GastroRecipeType recipeType, ItemStack[] ingredients,
            @Nullable ItemStack container, Set<ItemStack> tools, ItemStack... outputs) {
        super(recipeType, RecipeShape.SHAPELESS, ingredients, null, tools, outputs);
    }

    public ShapelessGastroRecipe(GastroRecipeType recipeType, ItemStack[] ingredients, Set<ItemStack> tools,
            ItemStack... outputs) {
        this(recipeType, ingredients, null, tools, outputs);
    }

    @Override
    public RecipeMatchResult matches(ItemStack[] givenIngredients, List<ItemStack> givenContainers,
            List<ItemStack> givenTools) {

        if (!givenContainers.stream().anyMatch(container -> getInputs().getContainer().matches(container))) {
            return RecipeMatchResult.NO_MATCH;
        }

        if (!givenTools.containsAll(getTools()))
            return RecipeMatchResult.NO_MATCH;

        Arrays.sort(givenIngredients, RecipeUtil::compareItemStacks);
        for (int i = 0; i < givenIngredients.length; i++) {
            if (!componentMatches(getInputs().getIngredients()[i], givenIngredients[i]))
                return RecipeMatchResult.NO_MATCH;
        }

        return RecipeMatchResult.SUCCESS;
    }

}
