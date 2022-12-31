package io.github.schntgaispock.gastronomicon.core.slimefun;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;

@UtilityClass
public class GastroRecipes {

    public static class GastroRecipeType extends RecipeType {

        public static final RecipeType DUMMY = new GastroRecipeType("dummy", new ItemStack(Material.BARRIER));
        public static final RecipeType BREAK = new GastroRecipeType("break", GastroStacks.GUIDE_RECIPE_BREAK);
        public static final RecipeType HARVEST = new GastroRecipeType("break", GastroStacks.GUIDE_RECIPE_HARVEST);
        public static final RecipeType CULINARY_WORKBENCH = new GastroRecipeType("culinary_workbench", GastroStacks.GUIDE_RECIPE_CULINARY_WORKBENCH);
        public static final RecipeType ENHANCED_OVEN = new GastroRecipeType("enhanced_oven", GastroStacks.GUIDE_RECIPE_ENHANCED_OVEN);
        public static final RecipeType REFRIDGERATOR = new GastroRecipeType("refridgerator", GastroStacks.GUIDE_RECIPE_REFRIDGERATOR);
        public static final RecipeType MILL = new GastroRecipeType("mill", GastroStacks.GUIDE_RECIPE_MILL);
        public static final RecipeType DISTILLERY = new GastroRecipeType("distillery", GastroStacks.GUIDE_RECIPE_DISTILLERY);

        public GastroRecipeType(@Nonnull String key, ItemStack item) {
            super(Gastronomicon.newNamespacedKey(key), item);
        }
    
    }
    
    public static MachineRecipe machineSingle(int seconds, ItemStack input, ItemStack output) {
        return new MachineRecipe(seconds, new ItemStack[] { input }, new ItemStack[] { output });
    }
    
}
