package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.ArrayList;
import java.util.Collections;
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
    protected final ItemStack topRightDisplayItem;

    protected SimpleGastroFood(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,
        @Nullable ItemStack container, ItemStack topRightDisplayItem, ItemStack... tools) {
        super(itemGroup, item, recipeType, recipe);

        this.tools = tools;
        this.container = container;
        this.topRightDisplayItem = topRightDisplayItem;
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    private static SimpleGastroFood of(ItemGroup itemGroup, SlimefunItemStack item, GastroRecipeType recipeType,
        RecipeShape shapedness,
        ItemStack[] ingredients, @Nullable ItemStack container, ItemStack topRightDisplayItem, ItemStack[] tools) {
        RecipeRegistry.registerRecipe((GastroRecipe) switch (shapedness) {
            case SHAPELESS -> new ShapelessGastroRecipe(recipeType, ingredients, container, Set.of(tools), item);
            default -> new ShapedGastroRecipe(recipeType, ingredients, container, Set.of(tools), item);
        });

        return new SimpleGastroFood(itemGroup, item, recipeType, ingredients, container, topRightDisplayItem, tools);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public static SimpleGastroFood workbench(ItemGroup itemGroup, SlimefunItemStack item, RecipeShape shapedness,
        ItemStack[] ingredients, @Nullable ItemStack container, ItemStack... tools) {
        return SimpleGastroFood.of(itemGroup, item, GastroRecipeType.CULINARY_WORKBENCH, shapedness, ingredients,
            container, new ItemStack(Material.AIR), tools);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    @SuppressWarnings("deprecation")
    public static SimpleGastroFood stove(ItemGroup itemGroup, SlimefunItemStack item, ItemStack[] ingredients,
        @Nullable ItemStack container, Temperature temperature, ItemStack... tools) {
        RecipeRegistry.registerRecipe(new MultiStoveRecipe(ingredients, container, Set.of(tools), temperature, item));
        final ItemStack trdi = temperature.getItem();
        trdi.setLore(Collections.emptyList());
        return new SimpleGastroFood(itemGroup, item, GastroRecipeType.MULTI_STOVE, ingredients, container,
            trdi, tools);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public static SimpleGastroFood fridge(ItemGroup itemGroup, SlimefunItemStack item, ItemStack[] ingredients,
        ItemStack... tools) {
        return SimpleGastroFood.of(itemGroup, item, GastroRecipeType.MILL, RecipeShape.SHAPELESS, ingredients, null,
            new ItemStack(Material.AIR), tools);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public static SimpleGastroFood mill(ItemGroup itemGroup, SlimefunItemStack item, ItemStack[] ingredients,
        ItemStack... tools) {
        return SimpleGastroFood.of(itemGroup, item, GastroRecipeType.MILL, RecipeShape.SHAPELESS, ingredients, null,
            new ItemStack(Material.AIR), tools);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public static SimpleGastroFood distillery(ItemGroup itemGroup, SlimefunItemStack item, ItemStack[] ingredients,
        ItemStack... tools) {
        return SimpleGastroFood.of(itemGroup, item, GastroRecipeType.DISTILLERY, RecipeShape.SHAPELESS, ingredients,
            null, new ItemStack(Material.AIR), tools);
    }

    @Override
    @Nonnull
    public String getRecipeSectionLabel(@Nonnull Player p) {
        return StringUtil.formatColors("&7Tools/Container Required:");
    }

    @Override
    @Nonnull
    @SuppressWarnings("null")
    public List<ItemStack> getDisplayRecipes() {
        final List<ItemStack> display = new ArrayList<ItemStack>();
        display.add(GastroStacks.GUIDE_TOOLS_REQUIRED);
        display.add(GastroStacks.GUIDE_CONTAINER_REQUIRED);

        int toolPos = 0;
        if (CollectionUtil.isEmpty(getTools())) {
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
