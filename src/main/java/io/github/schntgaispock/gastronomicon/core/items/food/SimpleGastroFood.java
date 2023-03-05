package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.MultiStoveRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.RecipeRegistry;
import io.github.schntgaispock.gastronomicon.api.recipes.ShapedGastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.ShapelessGastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.core.items.UnplaceableItem;
import io.github.schntgaispock.gastronomicon.core.items.workstations.MultiStove.Temperature;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.util.CollectionUtil;
import io.github.schntgaispock.gastronomicon.util.StringUtil;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import lombok.Getter;

@Getter
public class SimpleGastroFood extends UnplaceableItem implements RecipeDisplayItem {

    private final GastroRecipe gastroRecipe;
    protected final ItemStack topRightDisplayItem;

    public SimpleGastroFood(ItemGroup group, SlimefunItemStack item, GastroRecipe recipe, ItemStack topRightDisplayItem,
        boolean registerRecipe) {
        super(group, item, recipe.getRecipeType(),
            Arrays.stream(recipe.getInputs().getIngredients()).map(ingredient -> ingredient.getDisplayItem())
                .toArray(ItemStack[]::new));

        this.gastroRecipe = recipe;
        this.topRightDisplayItem = topRightDisplayItem;

        if (registerRecipe)
            RecipeRegistry.registerRecipe(recipe);
    }

    protected SimpleGastroFood(ItemGroup group, SlimefunItemStack item, GastroRecipeType type, RecipeShape shape,
        RecipeComponent<?>[] ingredients, @Nullable RecipeComponent<?> container, Set<ItemStack> tools,
        ItemStack[] outputs, Temperature temperature,
        boolean registerRecipe) {
        super(group, item, type,
            Arrays.stream(ingredients).map(ingredient -> ingredient.getDisplayItem()).toArray(ItemStack[]::new));

        if (type == GastroRecipeType.MULTI_STOVE) {
            topRightDisplayItem = Temperature.MEDIUM.getItem();
            gastroRecipe = new MultiStoveRecipe(ingredients, container, tools, outputs, Temperature.MEDIUM);
        } else {
            topRightDisplayItem = new ItemStack(Material.AIR);
            if (shape == RecipeShape.SHAPED) {
                gastroRecipe = new ShapedGastroRecipe(type, ingredients, container, tools, outputs);
            } else {
                gastroRecipe = new ShapelessGastroRecipe(type, ingredients, container, tools, outputs);
            }
        }

        if (registerRecipe)
            RecipeRegistry.registerRecipe(gastroRecipe);
    }

    public SimpleGastroFood(ItemGroup group, SlimefunItemStack item, RecipeComponent<?>[] ingredients,
        @Nullable RecipeComponent<?> container, Set<ItemStack> tools, Temperature temperature) {
        this(group, item, GastroRecipeType.MULTI_STOVE, RecipeShape.SHAPELESS, ingredients, container, tools,
            new ItemStack[] { item }, temperature, true);
    }

    public SimpleGastroFood(ItemGroup group, SlimefunItemStack item, GastroRecipeType type, RecipeShape shape,
        RecipeComponent<?>[] ingredients, @Nullable RecipeComponent<?> container, Set<ItemStack> tools) {
        this(group, item, type, shape, ingredients, container, tools, new ItemStack[] { item }, Temperature.MEDIUM, true);
    }

    @Override
    @Nonnull
    public String getRecipeSectionLabel(@Nonnull Player p) {
        return StringUtil.formatColors("&7Tools/Container Required:");
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() {
        final List<ItemStack> display = new ArrayList<ItemStack>();
        display.add(GastroStacks.GUIDE_TOOLS_REQUIRED);
        display.add(GastroStacks.GUIDE_CONTAINER_REQUIRED);

        final ItemStack[] tools = getGastroRecipe().getTools().toArray(ItemStack[]::new);
        final ItemStack container = getGastroRecipe().getInputs().getContainer().getDisplayItem();

        int toolPos = 0;
        if (CollectionUtil.isEmpty(tools)) {
            display.add(GastroStacks.GUIDE_NONE);
        } else {
            display.add(tools[toolPos++]);
        }

        if (container == null || container.getType() == Material.AIR) {
            display.add(GastroStacks.GUIDE_NONE);
        } else {
            display.add(container);
        }

        for (int i = toolPos; i < 7; i++) {
            if (i < tools.length) {
                display.add(tools[i]);
            } else {
                display.add(new ItemStack(Material.AIR));
            }

            display.add(new ItemStack(Material.AIR));

            if (i == 6) {
                display.add(topRightDisplayItem);
                break;
            }
        }

        return display;
    }

}
