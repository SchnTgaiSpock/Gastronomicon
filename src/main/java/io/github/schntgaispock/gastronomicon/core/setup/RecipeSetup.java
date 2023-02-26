package io.github.schntgaispock.gastronomicon.core.setup;

import java.util.Collections;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.recipes.RecipeRegistry;
import io.github.schntgaispock.gastronomicon.core.recipes.ShapelessGastroRecipe;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.util.recipe.RecipeUtil;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RecipeSetup {

    public static void setup() {
        RecipeRegistry.registerRecipes(
            // Wheat -> Wheat Flour
            new ShapelessGastroRecipe(GastroRecipeType.MILL, RecipeUtil.collection(new ItemStack(Material.WHEAT)),
                Collections.emptySet(), SlimefunItems.WHEAT_FLOUR));
    }

}
