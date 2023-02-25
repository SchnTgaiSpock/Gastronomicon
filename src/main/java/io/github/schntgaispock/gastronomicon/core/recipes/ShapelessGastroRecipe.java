package io.github.schntgaispock.gastronomicon.core.recipes;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.core.recipes.components.RecipeInput;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.core.recipes.components.GroupRecipeComponent;
import io.github.schntgaispock.gastronomicon.util.recipe.RecipeUtil;
import lombok.Getter;

@Getter
public class ShapelessGastroRecipe extends GastroRecipe {

    public ShapelessGastroRecipe(GastroRecipeType recipeType, RecipeComponent<?>[] inputs,
            RecipeComponent<?> container, ItemStack[] outputs, Set<ItemStack> tools) {
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
        System.out.println("himathing");

        if (!givenContainers.stream().anyMatch(container -> getInputs().getContainer().matches(container))) {
            return RecipeMatchResult.NO_MATCH;
        }

        System.out.println("yescontiner");
        if (!givenTools.containsAll(getTools()))
            return RecipeMatchResult.NO_MATCH;

        System.out.println("yestols");
        Arrays.sort(givenIngredients, RecipeUtil::compareItemStacks);
        System.out.println("CHECING INGREDIENTS");
        System.out.println("getInputs.getiNahdsadh");
        System.out.println(Arrays.toString(getInputs().getIngredients()));
        System.out.println("giveningredsfsd");
        System.out.println(Arrays.toString(givenIngredients));
        for (int i = 0; i < givenIngredients.length; i++) {
            System.out.println(i);
            System.out.println(getInputs().getIngredients()[i]);
            System.out.println(givenIngredients[i]);

            if (!componentMatches(getInputs().getIngredients()[i], givenIngredients[i]))
                return RecipeMatchResult.NO_MATCH;
        }

        System.out.println("yesingt");
        return RecipeMatchResult.SUCCESS;
    }

}
