package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.core.items.stacks.FoodItemStack;
import io.github.schntgaispock.gastronomicon.core.recipes.GastroRecipe;
import io.github.schntgaispock.gastronomicon.core.recipes.RecipeRegistry;
import io.github.schntgaispock.gastronomicon.core.recipes.ShapedGastroRecipe;
import io.github.schntgaispock.gastronomicon.core.recipes.ShapelessGastroRecipe;
import io.github.schntgaispock.gastronomicon.core.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.integration.EGIntegration;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import lombok.Getter;

@Getter
public class GastroFood extends SimpleGastroFood {

    private static final @Getter Set<String> gastroFoodIds = new HashSet<>();
    private static final @Getter Set<String> skills = new HashSet<>();

    private final FoodItemStack item;
    private final GastroRecipe gastroRecipe;
    private final boolean isPerfect;

    private GastroFood(ItemGroup itemGroup, FoodItemStack item, boolean isPerfect, GastroRecipe recipe) {
        super(itemGroup, item, recipe.getRecipeType(), recipe.getInputs().getDisplayIngredients(),
                recipe.getTools().toArray(ItemStack[]::new));

        this.item = item;
        this.gastroRecipe = recipe;
        this.isPerfect = isPerfect;
    }

    public GastroFood(ItemGroup itemGroup, FoodItemStack item, GastroRecipe recipe) {
        this(itemGroup, item, false, recipe);
    }

    public GastroFood(ItemGroup itemGroup, FoodItemStack item, GastroRecipeType recipeType, RecipeShape shapedness,
            ItemStack[] ingredients, @Nullable ItemStack container, ItemStack[] tools) {
        this(itemGroup, item, (GastroRecipe) switch (shapedness) {
            case SHAPELESS -> new ShapelessGastroRecipe(recipeType, ingredients, container, Set.of(tools), item, item.getPerfect());
            default -> new ShapedGastroRecipe(recipeType, ingredients, container, Set.of(tools), item, item.getPerfect());
        });
    }

    public GastroFood(ItemGroup itemGroup, FoodItemStack item, GastroRecipeType recipeType, RecipeShape shapedness,
            ItemStack[] ingredients, ItemStack... tools) {
        this(itemGroup, item, recipeType, shapedness, ingredients, null, tools);
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
            final Player p = e.getPlayer();
            for (FoodEffect effect : food.getItem().getEffects()) {
                effect.apply(p, ChatUtils.removeColorCodes(sfItem.getItemName()).toLowerCase().startsWith("perfect"));
            }
            p.setFoodLevel(NumberUtil.clampUpper(p.getFoodLevel() + food.getItem().getHunger(), 20));
            p.setSaturation((float) NumberUtil.clampUpper(p.getSaturation() + food.getItem().getSaturation(),
                    p.getFoodLevel()));
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 1, 1);
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
                    getItem().getPerfect(),
                    true,
                    getGastroRecipe()).hide().register(addon);
        } else {
            getGastroFoodIds().add(getId());
            RecipeRegistry.registerRecipe(getGastroRecipe());
        }
    }

}
