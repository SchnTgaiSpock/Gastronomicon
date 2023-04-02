package io.github.schntgaispock.gastronomicon.core.slimefun.recipes;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;

public class GastroRecipeType extends RecipeType {

    public static final GastroRecipeType DUMMY = new GastroRecipeType("dummy", new ItemStack(Material.BARRIER));
    public static final GastroRecipeType BREAK = new GastroRecipeType("break", GastroStacks.GUIDE_RECIPE_BREAK);
    public static final GastroRecipeType HARVEST = new GastroRecipeType("harvest", GastroStacks.GUIDE_RECIPE_HARVEST);
    public static final GastroRecipeType KILL = new GastroRecipeType("kill", GastroStacks.GUIDE_RECIPE_KILL);
    public static final GastroRecipeType TRAP = new GastroRecipeType("trap", GastroStacks.GUIDE_RECIPE_TRAP);
    public static final GastroRecipeType CULINARY_WORKBENCH = new GastroRecipeType("culinary_workbench", GastroStacks.GUIDE_RECIPE_CULINARY_WORKBENCH);
    public static final GastroRecipeType MULTI_STOVE = new GastroRecipeType("multi_stove", GastroStacks.GUIDE_RECIPE_MULTI_STOVE);
    public static final GastroRecipeType REFRIDGERATOR = new GastroRecipeType("refridgerator", GastroStacks.GUIDE_RECIPE_REFRIDGERATOR);
    public static final GastroRecipeType MILL = new GastroRecipeType("mill", GastroStacks.GUIDE_RECIPE_MILL);
    public static final GastroRecipeType FERMENTER = new GastroRecipeType("fermenter", GastroStacks.GUIDE_RECIPE_FERMENTER);

    public GastroRecipeType(@Nonnull String key, ItemStack item) {
        super(Gastronomicon.key(key), item);
    }

}