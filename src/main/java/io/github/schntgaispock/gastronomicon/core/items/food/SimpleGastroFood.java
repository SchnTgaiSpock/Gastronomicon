package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.items.UnplaceableItem;
import io.github.schntgaispock.gastronomicon.core.items.workstations.MultiStove.Temperature;
import io.github.schntgaispock.gastronomicon.core.recipes.GastroRecipe;
import io.github.schntgaispock.gastronomicon.core.recipes.MultiStoveRecipe;
import io.github.schntgaispock.gastronomicon.core.recipes.RecipeRegistry;
import io.github.schntgaispock.gastronomicon.core.recipes.ShapedGastroRecipe;
import io.github.schntgaispock.gastronomicon.core.recipes.ShapelessGastroRecipe;
import io.github.schntgaispock.gastronomicon.core.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.util.CollectionUtil;
import io.github.schntgaispock.gastronomicon.util.StringUtil;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import lombok.Getter;

@Getter
public class SimpleGastroFood extends UnplaceableItem implements RecipeDisplayItem {

    private final @Nullable ItemStack container;
    private final ItemStack[] tools;

    public SimpleGastroFood(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,
            @Nullable ItemStack container, ItemStack... tools) {
        super(itemGroup, item, recipeType, recipe);

        this.tools = tools;
        this.container = container;
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    private static SimpleGastroFood of(ItemGroup itemGroup, SlimefunItemStack item, GastroRecipeType recipeType,
            RecipeShape shapedness,
            ItemStack[] ingredients, @Nullable ItemStack container, ItemStack[] tools) {
        RecipeRegistry.registerRecipe((GastroRecipe) switch (shapedness) {
            case SHAPELESS ->
                new ShapelessGastroRecipe(recipeType, ingredients, container, Set.of(tools), item);
            default ->
                new ShapedGastroRecipe(recipeType, ingredients, container, Set.of(tools), item);
        });

        return new SimpleGastroFood(itemGroup, item, recipeType, ingredients, container, tools);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public static SimpleGastroFood workbench(ItemGroup itemGroup, SlimefunItemStack item, RecipeShape shapedness,
            ItemStack[] ingredients, @Nullable ItemStack container, ItemStack... tools) {
        return SimpleGastroFood.of(itemGroup, item, GastroRecipeType.CULINARY_WORKBENCH, shapedness, ingredients,
                container, tools);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public static SimpleGastroFood stove(ItemGroup itemGroup, SlimefunItemStack item, ItemStack[] ingredients,
            @Nullable ItemStack container, Temperature temperature, ItemStack... tools) {
        RecipeRegistry.registerRecipe(new MultiStoveRecipe(ingredients, container, Set.of(tools), temperature, item));
        return new SimpleGastroFood(itemGroup, item, GastroRecipeType.MULTI_STOVE, ingredients, container, tools);
    }

    @Override
    @Nonnull
    public String getRecipeSectionLabel(@Nonnull Player p) {
        return StringUtil.formatColors("&7Tools Required:");
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() {
        final List<ItemStack> recipes = new ArrayList<ItemStack>(getTools().length * 2);

        if (CollectionUtil.isEmpty(getTools())) {
            return Arrays.asList(GastroStacks.GUIDE_NO_TOOLS_REQUIRED);
        }

        for (ItemStack tool : getTools()) {
            recipes.add(tool);
            recipes.add(new ItemStack(Material.AIR));
        }

        return recipes;
    }

}
