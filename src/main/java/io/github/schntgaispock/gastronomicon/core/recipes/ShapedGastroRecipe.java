package io.github.schntgaispock.gastronomicon.core.recipes;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.recipes.components.AbstractGastroRecipeComponent;
import lombok.Getter;

@Getter
public abstract class ShapedGastroRecipe extends AbstractGastroRecipe {

    private final AbstractGastroRecipeComponent<?>[] inputs;
    private final ItemStack[] outputs;
    private final Set<ItemStack> tools;

    public ShapedGastroRecipe(AbstractGastroRecipeComponent<?>[] inputs, ItemStack[] outputs, Set<ItemStack> tools) {
        super(Arrays.asList(inputs).stream().map((AbstractGastroRecipeComponent<?> component) -> {
            return component.getDisplayItem();
        }).toArray(ItemStack[]::new), tools.stream().toList());

        this.inputs = inputs;
        this.outputs = outputs;
        this.tools = tools;
    }

    @Override
    public Result matches(ItemStack[] givenRecipe, List<ItemStack> givenTools) {
        if (givenRecipe.length != inputs.length || !givenTools.containsAll(tools)) return Result.NO_MATCH;

        for (int i = 0; i < givenRecipe.length; i++) {
           if (!inputs[i].matches(givenRecipe[i])) return Result.NO_MATCH;
        }

        return Result.NO_MATCH;
    }

    @Override
    public int inputHash() {
        return Arrays.hashCode(inputs);
    }

}
