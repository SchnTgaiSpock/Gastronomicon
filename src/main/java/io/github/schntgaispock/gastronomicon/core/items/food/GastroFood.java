package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.core.items.stacks.FoodItemStack;
import io.github.schntgaispock.gastronomicon.integration.EGIntegration;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import lombok.Getter;

public class GastroFood extends SimpleGastroFood {

    private static final @Getter Set<String> gastroFoodIds = new HashSet<>();
    private static final @Getter Set<String> skills = new HashSet<>();

    private final @Getter FoodItemStack item;
    private final @Getter boolean isPerfect;

    public GastroFood(ItemGroup itemGroup, FoodItemStack item, boolean isPerfect, RecipeType recipeType,
            ItemStack[] recipe, ItemStack... tools) {
        super(itemGroup, item, recipeType, recipe, tools);

        this.item = item;
        this.isPerfect = isPerfect;
    }

    public GastroFood(ItemGroup itemGroup, FoodItemStack item, RecipeType recipeType, ItemStack[] recipe,
            ItemStack... tools) {
        this(itemGroup, item, false, recipeType, recipe, tools);
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onRightClick);
        super.preRegister();
    }

    public void onRightClick(@Nonnull PlayerRightClickEvent e) {
        if (e.getPlayer().getFoodLevel() >= 20) {
            e.cancel();
            return; // Can't eat when full
        }

        final SlimefunItem sfItem = SlimefunItem.getByItem(e.getItem());
        if (sfItem == null)
            return;

        if (sfItem instanceof final GastroFood food) {
            e.cancel();
            Player p = e.getPlayer();
            for (FoodEffect effect : food.getItem().getEffects()) {
                effect.apply(p, ChatUtils.removeColorCodes(sfItem.getItemName()).toLowerCase().startsWith("perfect"));
            }
            p.setFoodLevel(NumberUtil.clampUpper(p.getFoodLevel() + food.getItem().getHunger(), 20));
            p.setSaturation((float) NumberUtil.clampUpper(p.getSaturation() + food.getItem().getSaturation(),
                    p.getFoodLevel()));
        }

        e.getItem().subtract();
    }

    public void registerIfEG(@Nonnull SlimefunAddon addon) {
        if (EGIntegration.isAvailable())
            register(addon);
    }

    /**
     * Will create a hidden perfect version of itself if not already perfect.
     */
    @Override
    public void register(@Nonnull SlimefunAddon addon) {
        super.register(addon);
        if (!isPerfect()) {
            new GastroFood(
                    getItemGroup(),
                    getItem().asPerfect(),
                    true,
                    getRecipeType(),
                    getRecipe(),
                    getTools()).hide().register(addon);
        } else {
            getGastroFoodIds().add(getId());
        }
    }

}
