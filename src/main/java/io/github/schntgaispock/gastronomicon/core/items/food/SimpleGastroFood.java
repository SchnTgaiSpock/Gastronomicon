package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import io.github.schntgaispock.gastronomicon.core.items.workstations.manual.MultiStove.Temperature;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.core.slimefun.recipes.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.util.CollectionUtil;
import io.github.schntgaispock.gastronomicon.util.StringUtil;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import lombok.Getter;

@Getter
@SuppressWarnings("deprecation")
public class SimpleGastroFood extends UnplaceableItem implements RecipeDisplayItem {

    private final GastroRecipe gastroRecipe;
    protected final ItemStack topRightDisplayItem;

    public SimpleGastroFood(Research research, ItemGroup group, SlimefunItemStack item, GastroRecipe recipe,
        ItemStack topRightDisplayItem,
        boolean registerRecipe) {
        super(group, item, recipe.getRecipeType(),
            Arrays.stream(recipe.getInputs().getIngredients())
                .map(ingredient -> ingredient == null ? null : ingredient.getDisplayItem())
                .toArray(ItemStack[]::new));

        this.gastroRecipe = recipe;
        this.topRightDisplayItem = topRightDisplayItem;
        setResearch(research);

        if (registerRecipe)
            RecipeRegistry.registerRecipe(recipe);
    }

    protected SimpleGastroFood(Research research, ItemGroup group, SlimefunItemStack item, GastroRecipeType type,
        RecipeShape shape,
        RecipeComponent<?>[] ingredients, @Nullable RecipeComponent<?> container, Set<ItemStack> tools,
        ItemStack[] outputs, Temperature temperature,
        boolean registerRecipe) {
        super(group, item, type,
            Arrays.stream(ingredients).map(ingredient -> ingredient == null ? null : ingredient.getDisplayItem())
                .toArray(ItemStack[]::new));

        if (type == GastroRecipeType.MULTI_STOVE) {
            topRightDisplayItem = Temperature.MEDIUM.getItem();
            topRightDisplayItem.setLore(Collections.emptyList());
            gastroRecipe = new MultiStoveRecipe(ingredients, container, tools, outputs, Temperature.MEDIUM);
        } else {
            topRightDisplayItem = new ItemStack(Material.AIR);
            if (shape == RecipeShape.SHAPED) {
                gastroRecipe = new ShapedGastroRecipe(type, ingredients, container, tools, outputs);
            } else {
                gastroRecipe = new ShapelessGastroRecipe(type, ingredients, container, tools, outputs);
            }
        }
        setResearch(research);

        if (registerRecipe)
            RecipeRegistry.registerRecipe(gastroRecipe);
    }

    public SimpleGastroFood(Research research, ItemGroup group, SlimefunItemStack item,
        RecipeComponent<?>[] ingredients,
        @Nullable RecipeComponent<?> container, Set<ItemStack> tools, Temperature temperature, int outputAmount) {
        this(research, group, item, GastroRecipeType.MULTI_STOVE, RecipeShape.SHAPELESS, ingredients, container, tools,
            new ItemStack[] { item.asQuantity(outputAmount) }, temperature, true);
    }

    public SimpleGastroFood(Research research, ItemGroup group, SlimefunItemStack item, GastroRecipeType type,
        RecipeShape shape,
        RecipeComponent<?>[] ingredients, @Nullable RecipeComponent<?> container, Set<ItemStack> tools,
        int outputAmount) {
        this(research, group, item, type, shape, ingredients, container, tools,
            new ItemStack[] { item.asQuantity(outputAmount) }, Temperature.MEDIUM, true);
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

        for (int i = toolPos; i < 6; i++) {
            if (i < tools.length) {
                display.add(tools[i]);
            } else {
                display.add(new ItemStack(Material.AIR));
            }

            display.add(new ItemStack(Material.AIR));

        }

        display.add(topRightDisplayItem);
        display.add(getGastroRecipe().getInputs().getShapedness().getGuideItem());

        return display;
    }

}
