package io.github.schntgaispock.gastronomicon.core.recipes;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.recipes.components.GastroRecipeComponent;
import lombok.Getter;

@Getter
public class ShapedGastroRecipe extends GastroRecipe {

    private final GastroRecipeComponent<?>[] inputs;
    private final ItemStack[] outputs;
    private final Set<ItemStack> tools;

    public ShapedGastroRecipe(GastroRecipeComponent<?>[] inputs, ItemStack[] outputs, Set<ItemStack> tools, RecipeShape shape) {
        super(Arrays.asList(inputs).stream().map((GastroRecipeComponent<?> component) -> {
            return component.getDisplayItem();
        }).toArray(ItemStack[]::new), tools.stream().toList(), shape);

        this.inputs = inputs;
        this.outputs = outputs;
        this.tools = tools;
    }

    @Override
    public RecipeResult matches(Object[] givenRecipe, List<ItemStack> givenTools) {
        if (givenRecipe.length != inputs.length || !givenTools.containsAll(tools)) return RecipeResult.NO_MATCH;

        for (int i = 0; i < givenRecipe.length; i++) {
           if (!inputs[i].matches(givenRecipe[i])) return RecipeResult.NO_MATCH;
        }

        return RecipeResult.SUCCESS;
    }

    @Override
    public int inputHash() {
        return Arrays.hashCode(inputs);
    }

}
