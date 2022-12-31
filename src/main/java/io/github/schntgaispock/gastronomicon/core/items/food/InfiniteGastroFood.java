package io.github.schntgaispock.gastronomicon.core.items.food;

import javax.annotation.Nonnull;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.util.GastroUtil;
import io.github.schntgaispock.gastronomicon.util.stacks.FoodItemStack;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;

public class InfiniteGastroFood extends AbstractGastroFood {

    public InfiniteGastroFood(ItemGroup itemGroup, FoodItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void onRightClick(@Nonnull PlayerRightClickEvent e) {
        final SlimefunItem sfItem = SlimefunItem.getByItem(e.getItem());
        if (sfItem == null) return;
        if (sfItem instanceof final AbstractGastroFood food) {
            e.cancel();
            Player p = e.getPlayer();
            for (FoodEffect effect : food.getItem().getEffects()) {
                effect.apply(p, ChatUtils.removeColorCodes(sfItem.getItemName()).toLowerCase().startsWith("perfect"));
            }
            p.setFoodLevel(GastroUtil.clampUpper(p.getFoodLevel() + food.getItem().getHunger(), 20));
            p.setSaturation((float) GastroUtil.clampUpper(p.getSaturation() + food.getItem().getSaturation(), p.getFoodLevel()));
        }
    }
}
