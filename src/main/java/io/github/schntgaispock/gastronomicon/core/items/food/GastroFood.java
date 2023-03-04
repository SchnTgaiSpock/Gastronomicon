package io.github.schntgaispock.gastronomicon.core.items.food;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.events.PlayerGastroFoodConsumeEvent;
import io.github.schntgaispock.gastronomicon.api.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.api.items.FoodItemStack;
import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.MultiStoveRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.RecipeRegistry;
import io.github.schntgaispock.gastronomicon.api.recipes.ShapedGastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.ShapelessGastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.core.items.workstations.MultiStove.Temperature;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import lombok.Getter;

@Getter
public class GastroFood extends SimpleGastroFood {

    private static final @Getter Set<String> gastroFoodIds = new HashSet<>();
    private static final @Getter Set<String> skills = new HashSet<>();

    private final FoodItemStack item;
    private final GastroRecipe gastroRecipe;
    private final boolean isPerfect;

    protected GastroFood(ItemGroup itemGroup, FoodItemStack item, boolean isPerfect, ItemStack topRightDisplayItem, GastroRecipe recipe) {
        super(itemGroup, item, recipe.getRecipeType(), recipe.getInputs().getDisplayIngredients(),
                recipe.getInputs().getContainer().getDisplayItem(), topRightDisplayItem,
                recipe.getTools().toArray(ItemStack[]::new));

        this.item = item;
        this.gastroRecipe = recipe;
        this.isPerfect = isPerfect;
    }

    protected GastroFood(ItemGroup itemGroup, FoodItemStack item, ItemStack topRightDisplayItem, GastroRecipe recipe) {
        this(itemGroup, item, false, topRightDisplayItem, recipe);
    }

    private GastroFood(ItemGroup itemGroup, FoodItemStack item, GastroRecipeType recipeType, RecipeShape shapedness,
        ItemStack[] ingredients, @Nullable ItemStack container, ItemStack topRightDisplayItem, ItemStack[] tools) {
        this(itemGroup, item, topRightDisplayItem, (GastroRecipe) switch (shapedness) {
            case SHAPELESS -> new ShapelessGastroRecipe(recipeType, ingredients, container, Set.of(tools), item,
                item.getPerfect());
            default -> new ShapedGastroRecipe(recipeType, ingredients, container, Set.of(tools), item,
                item.getPerfect());
        });
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public static GastroFood workbench(ItemGroup itemGroup, FoodItemStack item, RecipeShape shapedness,
        ItemStack[] ingredients, @Nullable ItemStack container, ItemStack... tools) {
        return new GastroFood(itemGroup, item, GastroRecipeType.CULINARY_WORKBENCH, shapedness, ingredients, container,
            new ItemStack(Material.AIR), tools);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    @SuppressWarnings("deprecation")
    public static GastroFood stove(ItemGroup itemGroup, FoodItemStack item, ItemStack[] ingredients,
        @Nullable ItemStack container, Temperature temperature, ItemStack... tools) {
        final MultiStoveRecipe recipe = new MultiStoveRecipe(ingredients, container, Set.of(tools), temperature, item);
        RecipeRegistry.registerRecipe(recipe);
        final ItemStack trdi = temperature.getItem();
        trdi.setLore(Collections.emptyList());
        return new GastroFood(itemGroup, item, trdi, recipe);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public static GastroFood fridge(ItemGroup itemGroup, FoodItemStack item, RecipeShape shapedness,
        ItemStack[] ingredients, @Nullable ItemStack container, ItemStack... tools) {
        return new GastroFood(itemGroup, item, GastroRecipeType.REFRIDGERATOR, shapedness, ingredients, container,
            new ItemStack(Material.AIR), tools);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public static GastroFood mill(ItemGroup itemGroup, FoodItemStack item, RecipeShape shapedness,
        ItemStack[] ingredients, @Nullable ItemStack container, ItemStack... tools) {
        return new GastroFood(itemGroup, item, GastroRecipeType.MILL, shapedness, ingredients, container,
            new ItemStack(Material.AIR), tools);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public static GastroFood distillery(ItemGroup itemGroup, FoodItemStack item, RecipeShape shapedness,
        ItemStack[] ingredients, @Nullable ItemStack container, ItemStack... tools) {
        return new GastroFood(itemGroup, item, GastroRecipeType.DISTILLERY, shapedness, ingredients, container,
            new ItemStack(Material.AIR), tools);
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
            p.setFoodLevel(NumberUtil.clampUpper(p.getFoodLevel() + food.getItem().getHunger(), 20));
            p.setSaturation((float) NumberUtil.clampUpper(p.getSaturation() + food.getItem().getSaturation(),
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
            new GastroFood(
                getItemGroup(),
                getItem().getPerfect(),
                true, topRightDisplayItem,
                getGastroRecipe()).hide().register(addon);
        } else {
            getGastroFoodIds().add(getId());
            RecipeRegistry.registerRecipe(getGastroRecipe());
        }
    }

}
