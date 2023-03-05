package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.Set;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.items.FoodItemStack;
import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.api.recipes.components.SingleRecipeComponent;
import io.github.schntgaispock.gastronomicon.core.items.workstations.MultiStove.Temperature;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import lombok.ToString;

@ToString
public class GastroFoodBuilder extends SimpleGastroFoodBuilder {

    protected FoodItemStack itemStack;

    public GastroFoodBuilder item(@Nonnull FoodItemStack itemStack) {
        this.itemStack = itemStack;
        return this;
    }

    public GastroFoodBuilder type(@Nonnull GastroRecipeType type) {
        this.recipeType = type;
        return this;
    }

    public GastroFoodBuilder shape(@Nonnull RecipeShape shape) {
        this.shape = shape;
        return this;
    }

    public GastroFoodBuilder temperature(@Nonnull Temperature temperature) {
        this.temperature = temperature;
        return this;
    }

    public GastroFoodBuilder ingredients(@Nonnull Object... ingredients) {
        for (int i = 0; i < Math.min(ingredients.length, 9); i++) {
            if (ingredients[i] instanceof final ItemStack stack) {
                this.ingredients[i] = new SingleRecipeComponent(stack);
            } else if (ingredients[i] instanceof final RecipeComponent<?> comp) {
                this.ingredients[i] = comp;
            } else if (ingredients[i] instanceof final String str) {
                final SlimefunItem item = SlimefunItem.getById(str);
                this.ingredients[i] = item == null ? RecipeComponent.EMPTY : new SingleRecipeComponent(item.getItem());
            } else {
                this.ingredients[i] = RecipeComponent.EMPTY;
            }
        }

        return this;
    }

    public GastroFoodBuilder ingredients(@Nonnull ItemStack... ingredients) {
        for (int i = 0; i < Math.min(ingredients.length, 9); i++) {
            this.ingredients[i] = ingredients[i] == null || ingredients[i].getType() == Material.AIR
                ? RecipeComponent.EMPTY
                : new SingleRecipeComponent(ingredients[i]);
        }

        return this;
    }

    public GastroFoodBuilder ingredients(@Nonnull RecipeComponent<?>... ingredients) {
        for (int i = 0; i < Math.min(ingredients.length, 9); i++) {
            this.ingredients[i] = ingredients[i];
        }

        return this;
    }

    public GastroFoodBuilder container(@Nonnull ItemStack stack) {
        this.container = new SingleRecipeComponent(stack);
        return this;
    }

    public GastroFoodBuilder container(@Nonnull RecipeComponent<?> comp) {
        this.container = comp;
        return this;
    }

    public GastroFoodBuilder tools(@Nonnull ItemStack... tools) {
        this.tools = Set.of(tools);
        return this;
    }

    public GastroFood build() {
        Validate.notNull(itemStack, "Must set an ItemStack!");
        Validate.notNull(recipeType, "Must set a recipe type!");
        
        if (recipeType == GastroRecipeType.MULTI_STOVE) {
            return new GastroFood(itemStack, ingredients, container, tools, temperature);
        } else {
            return new GastroFood(itemStack, recipeType, shape, ingredients, container, tools);
        }
    }

}
