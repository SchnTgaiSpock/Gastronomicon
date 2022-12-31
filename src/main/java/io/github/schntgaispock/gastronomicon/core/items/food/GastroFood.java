package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.integration.EGIntegration;
import io.github.schntgaispock.gastronomicon.util.stacks.FoodItemStack;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import lombok.Getter;

public class GastroFood extends InfiniteGastroFood implements RecipeDisplayItem {

    private final @Getter ItemStack[] tools;
    
    public GastroFood(ItemGroup itemGroup, FoodItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack[] tools) {
        super(itemGroup, item, recipeType, recipe);

        this.tools = tools;
    }

    @Override
    public void onRightClick(@Nonnull PlayerRightClickEvent e) {
        if (e.getPlayer().getFoodLevel() >= 20) {
            e.cancel();
            return; // Can't eat when full
        }
        super.onRightClick(e);
        e.getItem().setAmount(e.getItem().getAmount() - 1);
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() {
        final List<ItemStack> recipes = new LinkedList<ItemStack>();
        recipes.add(GastroStacks.GUIDE_TOOLS_REQUIRED);
        
        for (ItemStack tool : getTools()) {
            recipes.add(new ItemStack(Material.AIR));
            recipes.add(tool);
        }

        return recipes;
    }

    private void register(@Nonnull SlimefunAddon addon, boolean isPerfect, boolean requiresEG) {
        if (!isPerfect) new GastroFood(getItemGroup(), getItem().asPerfect(), getRecipeType(), getRecipe(), getTools()).register(addon, false, requiresEG);
        if (requiresEG && EGIntegration.isAvailable()) 
        super.register(addon);
    }

    public void register(@Nonnull SlimefunAddon addon, boolean requiresEG) {
        this.register(addon, false, requiresEG);
    }

    @Override
    public void register(@Nonnull SlimefunAddon addon) {
        this.register(addon, false, false);
    }

}
