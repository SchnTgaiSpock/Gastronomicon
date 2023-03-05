package io.github.schntgaispock.gastronomicon.core.items.food;

import javax.annotation.Nonnull;

import io.github.schntgaispock.gastronomicon.api.items.FoodItemStack;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import lombok.ToString;

@ToString
public class GastroFoodBuilder extends SimpleGastroFoodBuilder {

    protected FoodItemStack itemStack;

    public GastroFoodBuilder item(@Nonnull FoodItemStack itemStack) {
        this.itemStack = itemStack;
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
