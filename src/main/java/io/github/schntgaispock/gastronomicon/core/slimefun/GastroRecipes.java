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
        public static final RecipeType CULINARY_WORKBENCH = new GastroRecipeType("culinary_workbench", new ItemStack(Material.CRAFTING_TABLE));
        public static final RecipeType ENHANCED_OVEN = new GastroRecipeType("enhanced_oven", new ItemStack(Material.BLAST_FURNACE));
        public static final RecipeType REFRIDGERATOR = new GastroRecipeType("refridgerator", new ItemStack(Material.IRON_BLOCK));

        public GastroRecipeType(@Nonnull String key, ItemStack item) {
            super(Gastronomicon.newNamespacedKey(key), item);
        }
    
    }

    public static ItemStack[] single(ItemStack item) {
        ItemStack[] recipe = new ItemStack[9];
        recipe[4] = item;
        return recipe;
    }
    
    public static ItemStack[] collection(ItemStack... items) {
        return GastroRecipes.collection(items, 9);
    }
    
    private static ItemStack[] collection(ItemStack[] items, int maxLength) {
        ItemStack[] recipe = new ItemStack[9];

        int l = Math.min(items.length, maxLength);
        for (int i = 0; i < l; i++) {
            recipe[i] = items[i];
        }
        return recipe;
    }

    public static ItemStack[] cyclic(ItemStack outer, ItemStack inner) {
        return new ItemStack[] {outer, outer, outer, outer, inner, outer, outer, outer, outer};
    }

    public static ItemStack[] cyclic(ItemStack outer) {
        return GastroRecipes.cyclic(outer, null);
    }

    public static ItemStack[] cyclicAlternating(ItemStack corner, ItemStack middle, ItemStack inner) {
        return new ItemStack[] {corner, middle, corner, middle, inner, middle, corner, middle, corner};
    }

    public static ItemStack[] cyclicAlternating(ItemStack corner, ItemStack middle) {
        return GastroRecipes.cyclicAlternating(corner, middle, null);
    }

    public static MachineRecipe machineSingle(int seconds, ItemStack input, ItemStack output) {
        return new MachineRecipe(seconds, new ItemStack[] { input }, new ItemStack[] { output });
    }
    
}
