package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.Collections;
import java.util.Set;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.api.recipes.components.SingleRecipeComponent;
import io.github.schntgaispock.gastronomicon.core.items.workstations.manual.MultiStove.Temperature;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroResearch;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import lombok.ToString;

@ToString
public class SimpleGastroFoodBuilder {

    // Defaults
    protected Research research = GastroResearch.PROCESSED_INGREDIENTS;
    protected ItemGroup group = GastroGroups.FOOD;
    protected SlimefunItemStack itemStack;
    protected int amount = 1;
    protected GastroRecipeType recipeType;
    protected RecipeShape shape = RecipeShape.SHAPELESS;
    protected Temperature temperature = Temperature.MEDIUM;
    protected RecipeComponent<?>[] ingredients;
    protected RecipeComponent<?> container = RecipeComponent.EMPTY;
    protected Set<ItemStack> tools = Collections.emptySet();

    public SimpleGastroFoodBuilder research(Research reserach) {
        this.research = reserach;
        return this;
    }

    public SimpleGastroFoodBuilder group(@Nonnull ItemGroup group) {
        this.group = group;
        return this;
    }

    public SimpleGastroFoodBuilder item(@Nonnull SlimefunItemStack itemStack) {
        this.itemStack = itemStack;
        return this;
    }

    public SimpleGastroFoodBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    public SimpleGastroFoodBuilder type(@Nonnull GastroRecipeType type) {
        this.recipeType = type;
        return this;
    }

    public SimpleGastroFoodBuilder shape(@Nonnull RecipeShape shape) {
        this.shape = shape;
        return this;
    }

    public SimpleGastroFoodBuilder temperature(@Nonnull Temperature temperature) {
        this.temperature = temperature;
        return this;
    }

    public SimpleGastroFoodBuilder ingredients(@Nonnull Object... ingredients) {
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

    public SimpleGastroFoodBuilder ingredients(@Nonnull ItemStack... ingredients) {
        for (int i = 0; i < Math.min(ingredients.length, 9); i++) {
            this.ingredients[i] = ingredients[i] == null || ingredients[i].getType() == Material.AIR
                ? RecipeComponent.EMPTY
                : new SingleRecipeComponent(ingredients[i]);
        }

        return this;
    }

    public SimpleGastroFoodBuilder ingredients(@Nonnull RecipeComponent<?>... ingredients) {
        for (int i = 0; i < Math.min(ingredients.length, 9); i++) {
            this.ingredients[i] = ingredients[i];
        }

        return this;
    }

    public SimpleGastroFoodBuilder container(@Nonnull ItemStack container) {
        this.container = new SingleRecipeComponent(container);
        return this;
    }

    public SimpleGastroFoodBuilder container(@Nonnull RecipeComponent<?> container) {
        this.container = container;
        return this;
    }

    public SimpleGastroFoodBuilder tools(@Nonnull ItemStack... tools) {
        this.tools = Set.of(tools);
        return this;
    }

    public SimpleGastroFood build() {
        Validate.notNull(itemStack, "Must set an ItemStack!");
        Validate.notNull(recipeType, "Must set a recipe type!");

        if (recipeType == GastroRecipeType.MULTI_STOVE) {
            return new SimpleGastroFood(research, group, itemStack, ingredients, container, tools, temperature, amount);
        } else {
            return new SimpleGastroFood(research, group, itemStack, recipeType, shape, ingredients, container, tools, amount);
        }
    }

    public void register(SlimefunAddon addon) {
        build().register(addon);
    }

}
