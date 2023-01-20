package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.items.stacks.FoodItemStack;
import io.github.schntgaispock.gastronomicon.integration.EGIntegration;
import io.github.schntgaispock.gastronomicon.util.GastroUtil;
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
        final List<ItemStack> recipes = new ArrayList<ItemStack>(getTools().length * 2);
        
        for (ItemStack tool : getTools()) {
            recipes.add(new ItemStack(Material.AIR));
            recipes.add(tool);
        }

        return recipes;
    }

    @Override
    @Nonnull
    public String getRecipeSectionLabel(@Nonnull Player p) {
        return GastroUtil.formatColors("&7Tools Required:");
    }

    public void registerIfEG(@Nonnull SlimefunAddon addon) {
        if (EGIntegration.isAvailable()) register(addon);
    }

    @Override
    public void register(@Nonnull SlimefunAddon addon) {
        super.register(addon);
        new GastroFood(getItemGroup(), getItem().asPerfect(), getRecipeType(), getRecipe(), getTools()).hide().register(addon);
    }

}
