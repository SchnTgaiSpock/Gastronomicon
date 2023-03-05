package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.events.PlayerGastroFoodConsumeEvent;
import io.github.schntgaispock.gastronomicon.api.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.api.items.FoodItemStack;
import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.core.items.workstations.MultiStove.Temperature;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import lombok.Getter;

@Getter
public class GastroFood extends SimpleGastroFood {

    private static final @Getter Set<String> gastroFoodIds = new HashSet<>();
    private static final @Getter Set<String> skills = new HashSet<>();

    private final FoodItemStack item;
    private final boolean perfect;

    protected GastroFood(FoodItemStack item, GastroRecipe recipe, ItemStack topRightDisplayItem, boolean perfect) {
        super(GastroGroups.FOOD, item, recipe, topRightDisplayItem, !perfect);

        this.item = item;
        this.perfect = perfect;
    }

    protected GastroFood(FoodItemStack item, GastroRecipeType type, RecipeShape shape, RecipeComponent<?>[] ingredients,
        @Nullable RecipeComponent<?> container, Set<ItemStack> tools, Temperature temperature, boolean perfect) {
        super(GastroGroups.FOOD, item, type, shape, ingredients, container, tools, new ItemStack[] { item, item.asPerfect() }, temperature,
            !perfect);

        this.item = item;
        this.perfect = perfect;
    }

    public GastroFood(FoodItemStack item, RecipeComponent<?>[] ingredients,
        @Nullable RecipeComponent<?> container, Set<ItemStack> tools, Temperature temperature) {
        this(item, GastroRecipeType.MULTI_STOVE, RecipeShape.SHAPELESS, ingredients, container, tools, temperature,
            false);
    }

    public GastroFood(FoodItemStack item, GastroRecipeType type, RecipeShape shape, RecipeComponent<?>[] ingredients,
        @Nullable RecipeComponent<?> container, Set<ItemStack> tools) {
        this(item, type, shape, ingredients, container, tools, Temperature.MEDIUM, false);
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

            final PlayerGastroFoodConsumeEvent event = new PlayerGastroFoodConsumeEvent(e.getPlayer(), food,
                e.getItem(), e.getHand());
            event.callEvent();
            if (event.isCancelled()) {
                return;
            }

            final Player p = e.getPlayer();
            for (FoodEffect effect : food.getItem().getEffects()) {
                effect.apply(p, food.isPerfect());
            }
            p.setFoodLevel(Math.min(p.getFoodLevel() + food.getItem().getHunger(), 20));
            p.setSaturation((float) Math.min(p.getSaturation() + food.getItem().getSaturation(),
                p.getFoodLevel()));
            if (getGastroRecipe().getInputs().getContainer().getComponent() instanceof final ItemStack stack) {
                p.getInventory().addItem(stack); // It should always be an itemstack anyways
            }
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 1, 1);
        }

        e.getItem().subtract();
    }

    /**
     * Will create a hidden perfect version of itself if not already perfect.
     */
    @Override
    public void register(@Nonnull SlimefunAddon addon) {
        super.register(addon);
        if (!isPerfect()) {
            new GastroFood(item, getGastroRecipe(), topRightDisplayItem, true).hide().register(addon);
        } else {
            getGastroFoodIds().add(getId());
        }
    }

}
