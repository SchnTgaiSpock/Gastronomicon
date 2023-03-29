package io.github.schntgaispock.gastronomicon.api.recipes;

import java.util.Set;

import javax.annotation.Nullable;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.core.items.workstations.manual.MultiStove.Temperature;
import io.github.schntgaispock.gastronomicon.core.slimefun.recipes.GastroRecipeType;
import lombok.Getter;

public class MultiStoveRecipe extends ShapelessGastroRecipe {

    private final @Getter Temperature temperature;

    public MultiStoveRecipe(RecipeComponent<?>[] inputs, RecipeComponent<?> container, Set<ItemStack> tools,
        ItemStack[] outputs, Temperature temperature) {
        super(GastroRecipeType.MULTI_STOVE, inputs, container, tools, outputs);

        this.temperature = temperature;
    }

    public MultiStoveRecipe(ItemStack[] ingredients, @Nullable ItemStack container, Set<ItemStack> tools,
        Temperature temperature, ItemStack... outputs) {
        super(GastroRecipeType.MULTI_STOVE, ingredients, container, tools, outputs);

        this.temperature = temperature;
    }

    public MultiStoveRecipe(ItemStack[] ingredients, Set<ItemStack> tools, Temperature temperature,
        ItemStack... outputs) {
        this(ingredients, null, tools, temperature, outputs);
    }

    public MultiStoveRecipe(ItemStack[] ingredients, Set<ItemStack> tools, ItemStack... outputs) {
        this(ingredients, null, tools, Temperature.MEDIUM, outputs);
    }

}
