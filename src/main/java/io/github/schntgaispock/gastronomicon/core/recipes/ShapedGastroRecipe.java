package io.github.schntgaispock.gastronomicon.core.recipes;

import java.util.List;
import java.util.Set;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.core.recipes.components.RecipeInput;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipes.GastroRecipeType;
import lombok.Getter;

@Getter
public class ShapedGastroRecipe extends GastroRecipe {

    public ShapedGastroRecipe(GastroRecipeType recipeType, RecipeComponent<?>[] inputs,
            RecipeComponent<?> container, ItemStack[] outputs, Set<ItemStack> tools) {
        super(recipeType, new RecipeInput(RecipeShape.SHAPED, container, inputs), tools, outputs);
    }

    @Override
    public RecipeMatchResult matches(ItemStack[] givenIngredients, List<ItemStack> givenContainers,
            List<ItemStack> givenTools) {

        if (!givenContainers.stream().anyMatch(container -> getInputs().getContainer().matches(container))) {
            return RecipeMatchResult.NO_MATCH;
        }

        if (!givenTools.containsAll(getTools()))
            return RecipeMatchResult.NO_MATCH;

        for (int i = 0; i < givenIngredients.length; i++) {
            if (!componentMatches(getInputs().getIngredients()[i], givenIngredients[i]))
                return RecipeMatchResult.NO_MATCH;
        }

        return RecipeMatchResult.SUCCESS;
    }

}
