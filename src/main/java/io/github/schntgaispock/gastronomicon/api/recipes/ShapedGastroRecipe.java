package io.github.schntgaispock.gastronomicon.api.recipes;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeInput;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import lombok.Getter;

@Getter
public class ShapedGastroRecipe extends GastroRecipe {

    public ShapedGastroRecipe(GastroRecipeType recipeType, RecipeComponent<?>[] ingredients,
        RecipeComponent<?> container, Set<ItemStack> tools, ItemStack... outputs) {
        super(recipeType, new RecipeInput(RecipeShape.SHAPED, container, ingredients), tools, outputs);
    }

    public ShapedGastroRecipe(GastroRecipeType recipeType, ItemStack[] ingredients,
        @Nullable ItemStack container, Set<ItemStack> tools, ItemStack... outputs) {
        super(recipeType, RecipeShape.SHAPED, ingredients, null, tools, outputs);
    }

    public ShapedGastroRecipe(GastroRecipeType recipeType, ItemStack[] ingredients, Set<ItemStack> tools,
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

        for (int i = 0; i < givenIngredients.length; i++) {
            if (!componentMatches(getInputs().getIngredients()[i], givenIngredients[i])) {
                return RecipeMatchResult.NO_MATCH;
            }
        }

        return RecipeMatchResult.SUCCESS;
    }

}
