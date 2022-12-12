package io.github.schntgaispock.gastronomicon.core.slimefun.items.food;

import javax.annotation.Nonnull;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.util.stacks.FoodItemStack;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import lombok.Getter;

@Getter
public abstract class AbstractGastroFood extends SlimefunItem {
    
    private final int hunger;
    private final int saturation;
    private final FoodEffect[] foodEffects;
    
    public AbstractGastroFood(ItemGroup itemGroup, FoodItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        hunger = item.getHunger();
        saturation = item.getSaturation();
        foodEffects = item.getEffects();
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onRightClick);
    }

    public abstract void onRightClick(@Nonnull PlayerRightClickEvent e);

}
