package io.github.schntgaispock.gastronomicon.core.recipes;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.core.recipes.components.RecipeInput;
import io.github.schntgaispock.gastronomicon.core.recipes.components.SingleRecipeComponent;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Represents a recipe used by any of the Gastronomicon machines
 */
@Getter
@ToString
public abstract class GastroRecipe {

    public enum RecipeShape {
        SHAPED,
        SHAPELESS
    }

    /**
     * Contains results of a recipe matching
     * <br>
     * <br>
     * SUCCESS: The recipe matches and there is enough
     * <br>
     * <br>
     * NO_RESEARCH: Correct recipe but the player didn't have the required research
     * <br>
     * <br>
     * Under these two states, a recipe search should be terminated as a valid
     * recipe has been found.
     * <br>
     * <br>
     * NO_MATCH: Not enough / wrong items
     * <br>
     * <br>
     * OTHER: Failed for some other reason
     * Under these two states, a recipe search should continue to look for a valid
     * recipe.
     */
    @Getter
    @RequiredArgsConstructor
    public enum RecipeMatchResult {
        SUCCESS(true, true),
        NO_RESEARCH(true, false),
        NO_MATCH(false, false),
        OTHER(false, false);

        private final @Getter boolean match;
        private final @Getter boolean craftable;
    }

    private final GastroRecipeType recipeType;
    private final RecipeInput inputs;
    private final Set<ItemStack> tools;
    private final ItemStack[] outputs;

    /**
     * Creates a new GastroRecipe with the specified inputs, outputs, tools, and
     * shapedness
     * 
     * @param recipeType The type (Culinary Workbench, Multi-stove, etc.) of this
     *                   recipe. See {@link GastroRecipeType}
     * @param inputs     The inputs that the recipe requires
     * @param tools      The tools that the recipe requires
     * @param outputs    The outputs that the recipe produces. For Gastronomicon's
     *                   core recipes, this will be the regular food and its perfect
     *                   version, followed by all the necessary items to return
     *                   (empty bottles, bowls, etc.).
     */
    public GastroRecipe(GastroRecipeType recipeType, RecipeInput inputs, Set<ItemStack> tools,
            ItemStack... outputs) {
        this.recipeType = recipeType;
        this.inputs = inputs;
        this.tools = tools;
        this.outputs = outputs;
    }

    public GastroRecipe(GastroRecipeType recipeType, RecipeShape recipeShape, ItemStack[] ingredients,
            @Nullable ItemStack container, Set<ItemStack> tools, ItemStack... outputs) {
        this(recipeType,
                new RecipeInput(recipeShape,
                        container == null ? RecipeComponent.EMPTY : new SingleRecipeComponent(container),
                        Arrays.stream(ingredients).map(ingredient -> ingredient == null ? RecipeComponent.EMPTY : new SingleRecipeComponent(ingredient))
                                .toArray(RecipeComponent[]::new)),
                tools, outputs);
    }

    public GastroRecipe(GastroRecipeType recipeType, RecipeShape recipeShape, ItemStack[] ingredients,
           Set<ItemStack> tools, ItemStack... outputs) {
        this(recipeType, recipeShape, ingredients, null, tools, outputs);
    }

    /**
     * Whether or not this recipe matches a recipe with given inputs and tools
     * 
     * @param givenIngredients A 9 item array containing items in the 3x3 recipe
     *                         grid.
     * @param givenContainers  The items in the 2 container slots.
     * @param givenTools       The list of tools present in the GUI. It is
     *                         guaranteed
     *                         that they will have durability remaining. Durability
     *                         calculations are not necessary
     * @return The result of the matching. See {@link RecipeMatchResult}
     */
    public abstract RecipeMatchResult matches(ItemStack[] givenIngredients, List<ItemStack> givenContainers,
            List<ItemStack> givenTools);

    public boolean componentMatches(RecipeComponent<?> component, ItemStack item) {
        return component == null ? item.getType() == Material.AIR : component.matches(item);
    }

}
