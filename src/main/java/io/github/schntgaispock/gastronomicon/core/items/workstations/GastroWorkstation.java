package io.github.schntgaispock.gastronomicon.core.items.workstations;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.api.events.PlayerGastroFoodCraftEvent;
import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.RecipeRegistry;
import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe.RecipeMatchResult;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.schntgaispock.gastronomicon.util.item.ItemUtil;
import io.github.schntgaispock.gastronomicon.util.recipe.RecipeUtil;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatColor;

@SuppressWarnings("deprecation")
public abstract class GastroWorkstation extends MenuBlock {

    public static final ItemStack BACKGROUND_ITEM = new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "");
    public static final ItemStack INGREDIENT_BORDER = new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE,
        "&9Ingredients");
    public static final ItemStack CONTAINER_BORDER = new CustomItemStack(Material.PURPLE_STAINED_GLASS_PANE,
        "&5Container");
    public static final ItemStack TOOL_BORDER = new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE,
        ChatColor.of("#999999") + "Tools");
    public static final ItemStack OUTPUT_BORDER = new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, "&6Output");
    public static final ItemStack CRAFT_BUTTON = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
        "&aClick to craft");
    public static final ItemStack PROGRESS_BAR = new ItemStack(Material.FLINT_AND_STEEL);

    protected static final int[] BACKGROUND_SLOTS = {
        0, 1, 2, 3, 4, 5, 6, 7, 8,
        13, 17,
        22, 23, 24, 25, 26,
        31, 35,
        36, 37, 38, 39, 40, 41, 42, 43, 44
    };
    protected static final int[] INGREDIENT_BORDER_SLOTS = { 9, 18, 27 };
    protected static final int[] CONTAINER_BORDER_SLOTS = { 14 };
    protected static final int[] OUTPUT_BORDER_SLOTS = { 32 };
    protected static final int[] TOOL_BORDER_SLOTS = { 45 };
    protected static final int CRAFT_BUTTON_SLOT = 53;

    private final int[] hashedInputs = new int[] { 0, 0, 0, 0 };
    private GastroRecipe lastCrafted = null;

    public GastroWorkstation(ItemGroup group, SlimefunItemStack item, RecipeType type, ItemStack[] recipe) {
        super(group, item, type, recipe);
    }

    @Override
    protected int[] getInputSlots() {
        return new int[] { 10, 11, 12, 19, 20, 21, 28, 29, 30 };
    }

    @Override
    protected int[] getOutputSlots() {
        return new int[] { 33, 34 };
    }

    protected int[] getToolSlots() {
        return new int[] { 46, 47, 48, 49, 50, 51 };
    }

    protected int[] getContainerSlots() {
        return new int[] { 15, 16 };
    }

    public abstract GastroRecipeType getGastroRecipeType();

    @Override
    protected void setup(BlockMenuPreset preset) {
        preset.drawBackground(BACKGROUND_ITEM, BACKGROUND_SLOTS);
        preset.drawBackground(INGREDIENT_BORDER, INGREDIENT_BORDER_SLOTS);
        preset.drawBackground(CONTAINER_BORDER, CONTAINER_BORDER_SLOTS);
        preset.drawBackground(OUTPUT_BORDER, OUTPUT_BORDER_SLOTS);
        preset.drawBackground(TOOL_BORDER, TOOL_BORDER_SLOTS);
        preset.drawBackground(CRAFT_BUTTON, new int[] { CRAFT_BUTTON_SLOT });
    }

    @Override
    protected void onBreak(BlockBreakEvent e, BlockMenu menu) {
        super.onBreak(e, menu);
        final Location l = menu.getLocation();
        menu.dropItems(l, getToolSlots());
        menu.dropItems(l, getContainerSlots());
    }

    @Override
    protected void onNewInstance(BlockMenu menu, Block b) {
        super.onNewInstance(menu, b);

        menu.addMenuClickHandler(CRAFT_BUTTON_SLOT, (player, slot, item, action) -> {
            // Check if there is a free slot to craft
            Integer freeSlot = null;
            for (int s : getOutputSlots()) {
                final ItemStack stack = menu.getItemInSlot(s);
                if (stack == null || stack.getType() == Material.AIR) {
                    freeSlot = s;
                    break;
                }
            }

            if (freeSlot == null) {
                return false;
            }

            // Get the items in the menu
            final ItemStack[] ingredients = Arrays.stream(getInputSlots()).mapToObj(s -> {
                final ItemStack i = menu.getItemInSlot(s);
                return i == null ? null : i.asOne();
            }).toArray(ItemStack[]::new);
            final List<ItemStack> containers = Arrays.stream(getContainerSlots()).mapToObj(s -> {
                final ItemStack i = menu.getItemInSlot(s);
                return i == null ? null : i.asOne();
            }).toList();
            final List<ItemStack> tools = Arrays.stream(getToolSlots()).mapToObj(s -> {
                final ItemStack i = menu.getItemInSlot(s);
                return i == null ? null : i.asOne();
            }).toList();

            // Get the hashes, and check against last crafted recipe
            final int ingredientHash = Arrays.hashCode(ingredients);
            final int containerHash = containers.hashCode();
            final int toolsHash = tools.hashCode();
            final int otherHash = getOtherHash(player, menu);

            final GastroRecipe recipe;
            if (lastCrafted != null && hashedInputs[0] == ingredientHash && hashedInputs[1] == containerHash
                && hashedInputs[2] == toolsHash && hashedInputs[3] == otherHash) {
                // Can skip searching if hashes are the same
                recipe = lastCrafted;
            } else {
                // Otherwise start search
                recipe = findRecipe(ingredients, containers, tools, player, menu);
                if (recipe == null) {
                    return false;
                } else {
                    lastCrafted = recipe;
                    hashedInputs[0] = ingredientHash;
                    hashedInputs[1] = containerHash;
                    hashedInputs[2] = toolsHash;
                    hashedInputs[3] = otherHash;
                    // TODO: save hashes in RecipeRegistry
                }
            }
            final ItemStack[] recipeOutputs = recipe.getOutputs();

            // Call the event
            final PlayerGastroFoodCraftEvent craftEvent = new PlayerGastroFoodCraftEvent(player, recipe);
            if (!craftEvent.callEvent()) {
                if (craftEvent.getMessage() != null) player.sendMessage(Component.text(craftEvent.getMessage()));
                return false;
            }

            // Calculate the crafting result
            final ItemStack output;
            final ItemStack[] toReturn;
            if (recipeOutputs.length > 1 && recipeOutputs[0] instanceof final SlimefunItemStack sfItem) {
                final double proficiency = Gastronomicon.getInstance().getPlayerData()
                    .getInt(player.getUniqueId() + ".proficiencies." + sfItem.getItemId(), 0);
                final double perfectProbabilityMultipliers = 1;
                final double perfectProbability = NumberUtil.clamp(
                    NumberUtil.clamp(0, proficiency / 864, 0.25) * perfectProbabilityMultipliers,
                    0, 1);

                output = recipeOutputs[NumberUtil.randomRound(perfectProbability)];
                toReturn = Arrays.copyOfRange(recipeOutputs, 2, recipeOutputs.length);
            } else {
                output = recipeOutputs[0];
                toReturn = Arrays.copyOfRange(recipeOutputs, 1, recipeOutputs.length);
            }

            // Place the result in the inventory
            final Inventory inv = player.getOpenInventory().getTopInventory();

            for (final int outputSlot : getOutputSlots()) {
                final ItemStack currentlyInOutput = inv.getItem(outputSlot);

                if (currentlyInOutput == null || currentlyInOutput.getType() == Material.AIR) {
                    inv.setItem(outputSlot, output.clone());
                    break;
                } else if (RecipeUtil.recipeHash(output) == RecipeUtil.recipeHash(currentlyInOutput)) {
                    if (currentlyInOutput.getMaxStackSize() == currentlyInOutput.getAmount()) {
                        continue;
                    } else {
                        currentlyInOutput.add();
                        break;
                    }
                }
            }

            // Subtract inputs
            Arrays.stream(getInputSlots()).forEach(s -> {
                final ItemStack i = menu.getItemInSlot(s);
                if (i != null)
                    i.subtract();
            });
            for (final int containerSlot : getContainerSlots()) {
                final ItemStack i = menu.getItemInSlot(containerSlot);
                if (i != null && lastCrafted.getInputs().getContainer().matches(i)) {
                    i.subtract();
                    break;
                }
            }
            ItemUtil.giveItems(player, toReturn);
            return false;
        });

    }

    @Nullable
    @ParametersAreNonnullByDefault
    protected GastroRecipe findRecipe(ItemStack[] ingredients, List<ItemStack> containers, List<ItemStack> tools,
        Player player, BlockMenu menu) {
        final Set<GastroRecipe> recipes = RecipeRegistry.getRecipes(getGastroRecipeType());

        for (final GastroRecipe recipe : recipes) {
            final RecipeMatchResult result = recipe.matches(ingredients.clone(), containers, tools);
            if (!result.isMatch()) {
                continue;
            } else if (!result.isCraftable()) {
                break;
            } else {
                return recipe;
            }
        }

        return null;
    }

    protected int getOtherHash(Player player, BlockMenu menu) { return 0; }

}