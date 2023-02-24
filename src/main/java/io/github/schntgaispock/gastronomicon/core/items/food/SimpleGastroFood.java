package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.items.UnplaceableItem;
import io.github.schntgaispock.gastronomicon.util.StringUtil;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import lombok.Getter;

@Getter
public class SimpleGastroFood extends UnplaceableItem implements RecipeDisplayItem {
    
    private final ItemStack[] tools;
    
    public SimpleGastroFood(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack... tools) {
        super(itemGroup, item, recipeType, recipe);

        this.tools = tools;
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
        
        for (ItemStack tool : getTools()) {
            recipes.add(tool);
            recipes.add(new ItemStack(Material.AIR));
        }

        return recipes;
    }

}
