package io.github.schntgaispock.gastronomicon.core.recipes;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.recipes.components.GastroRecipeComponent;
import io.github.schntgaispock.gastronomicon.core.recipes.components.GroupGastroRecipeComponent;
import io.github.schntgaispock.gastronomicon.core.recipes.components.SingleGastroRecipeComponent;
import lombok.Getter;

@Getter
public class ShapelessGastroRecipe extends GastroRecipe {

    private final GastroRecipeComponent<?>[] inputs;
    private final ItemStack[] outputs;
    private final Set<ItemStack> tools;

    public ShapelessGastroRecipe(GastroRecipeComponent<?>[] inputs, ItemStack[] outputs, Set<ItemStack> tools,
            RecipeShape shape) {
        super(Arrays.asList(inputs).stream().map((GastroRecipeComponent<?> component) -> {
            return component.getDisplayItem();
        }).toArray(ItemStack[]::new), tools.stream().toList(), shape);

        Arrays.sort(inputs, ShapelessGastroRecipe::compareComponents);
        this.inputs = inputs;
        this.outputs = outputs;
        this.tools = tools;
    }

    @Override
    public RecipeResult matches(Object[] givenRecipe, List<ItemStack> givenTools) {
        if (givenRecipe.length != inputs.length || !givenTools.containsAll(tools))
            return RecipeResult.NO_MATCH;

        Arrays.sort(givenRecipe, ShapelessGastroRecipe::compareItems);

        for (int i = 0; i < givenRecipe.length; i++) {
            if (!inputs[i].matches(givenRecipe[i]))
                return RecipeResult.NO_MATCH;
        }

        return RecipeResult.SUCCESS;
    }

    @Override
    public int inputHash() {
        return Arrays.hashCode(inputs);
    }

    private static int compareComponents(GastroRecipeComponent<?> component1,
            GastroRecipeComponent<?> component2) {
        String compareFrom = "";
        if (component1 instanceof final SingleGastroRecipeComponent singleC1) {
            compareFrom = singleC1.getComponent().getItemMeta().getDisplayName();
        } else if (component1 instanceof final GroupGastroRecipeComponent groupC1) {
            compareFrom = groupC1.getName();
        }

        String compareTo = "";
        if (component2 instanceof final SingleGastroRecipeComponent singleC2) {
            compareTo = singleC2.getComponent().getItemMeta().getDisplayName();
        } else if (component2 instanceof final GroupGastroRecipeComponent groupC2) {
            compareTo = groupC2.getName();
        }

        return compareFrom.compareTo(compareTo);
    }

    /**
     * 
     * @param item1 Should be an {@link ItemStack} or {@link GroupGastroRecipeComponent}
     * @param item2 Should be an {@link ItemStack} or {@link GroupGastroRecipeComponent}
     * @return
     */
    private static int compareItems(Object item1, Object item2) {
        String compareFrom = "";
        if (item1 instanceof final ItemStack singleI1) {
            compareFrom = singleI1.getItemMeta().getDisplayName();
        } else if (item1 instanceof final GroupGastroRecipeComponent groupI1) {
            compareFrom = groupI1.getName();
        }

        String compareTo = "";
        if (item2 instanceof final SingleGastroRecipeComponent singleI2) {
            compareTo = singleI2.getComponent().getItemMeta().getDisplayName();
        } else if (item2 instanceof final GroupGastroRecipeComponent groupI2) {
            compareTo = groupI2.getName();
        }

        return compareFrom.compareTo(compareTo);
    }

}
