package io.github.schntgaispock.gastronomicon.api.food;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.items.FoodItemStack;
import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.MultiStoveRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.ShapedGastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.ShapelessGastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.api.recipes.components.SingleRecipeComponent;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroResearch;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.food.GastroFood;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.workstations.manual.MultiStove.Temperature;
import io.github.schntgaispock.gastronomicon.core.slimefun.recipes.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import lombok.ToString;

@ToString
public class GastroFoodBuilder extends SimpleGastroFoodBuilder {

    protected Research research = GastroResearch.FOOD;
    protected ItemGroup group = GastroGroups.FOOD;
    protected FoodItemStack itemStack;

    public GastroFoodBuilder research(Research research) {
        this.research = research;
        return this;
    }

    public GastroFoodBuilder group(@Nonnull ItemGroup group) {
        this.group = group;
        return this;
    }

    public GastroFoodBuilder item(@Nonnull FoodItemStack itemStack) {
        this.itemStack = itemStack;
        return this;
    }

    public GastroFoodBuilder amount(int amount) {
        this.amount = amount;
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
        this.ingredients = new RecipeComponent<?>[9];
        for (int i = 0; i < Math.min(ingredients.length, 9); i++) {
            if (ingredients[i] instanceof final ItemStack stack) {
                this.ingredients[i] = new SingleRecipeComponent(stack);
            } else if (ingredients[i] instanceof final RecipeComponent<?> comp) {
                this.ingredients[i] = comp;
            } else if (ingredients[i] instanceof final Material mat) {
                this.ingredients[i] = new SingleRecipeComponent(new ItemStack(mat));
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
        this.ingredients = new RecipeComponent<?>[9];
        for (int i = 0; i < Math.min(ingredients.length, 9); i++) {
            this.ingredients[i] = (ingredients[i] == null || ingredients[i].getType() == Material.AIR)
                ? RecipeComponent.EMPTY
                : new SingleRecipeComponent(ingredients[i]);
        }

        return this;
    }

    public GastroFoodBuilder ingredients(@Nonnull RecipeComponent<?>... ingredients) {
        this.ingredients = Arrays.copyOf(ingredients, 9);
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

    @SuppressWarnings("deprecation")
    public GastroFood build() {
        Validate.notNull(itemStack, "Must set an ItemStack!");
        Validate.notNull(recipeType, "Must set a recipe type!");
        
        final ItemStack[] outputs = new ItemStack[] { itemStack.asQuantity(amount), itemStack.asPerfect().asQuantity(amount) };

        final ItemStack topRightDisplayItem;
        final GastroRecipe recipe;
        if (recipeType == GastroRecipeType.MULTI_STOVE) {
            topRightDisplayItem = temperature.getItem().clone();
            topRightDisplayItem.setLore(Collections.emptyList());
            recipe = new MultiStoveRecipe(ingredients, container, tools, outputs, temperature);
        } else {
            topRightDisplayItem = new ItemStack(Material.AIR);
            if (shape == RecipeShape.SHAPED) {
                recipe = new ShapedGastroRecipe(recipeType, ingredients, container, tools, outputs);
            } else {
                recipe = new ShapelessGastroRecipe(recipeType, ingredients, container, tools, outputs);
            }
        }

        return new GastroFood(research, group, itemStack, recipe, topRightDisplayItem, outputs[0], false);
    }

}
