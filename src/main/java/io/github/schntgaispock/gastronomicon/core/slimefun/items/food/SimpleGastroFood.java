package io.github.schntgaispock.gastronomicon.core.slimefun.items.food;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.RecipeRegistry;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.UnplaceableSolid;
import io.github.schntgaispock.gastronomicon.util.StringUtil;
import io.github.schntgaispock.gastronomicon.util.collections.CollectionUtil;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import lombok.Getter;
import org.mini2Dx.gettext.GetText;

@Getter
public class SimpleGastroFood extends UnplaceableSolid implements RecipeDisplayItem {

    private final GastroRecipe gastroRecipe;
    protected final ItemStack topRightDisplayItem;

    public SimpleGastroFood(Research research, ItemGroup group, SlimefunItemStack item, GastroRecipe recipe,
        ItemStack topRightDisplayItem, ItemStack recipeDisplayOutput, boolean registerRecipe) {
        super(group, item, recipe.getRecipeType(),
            Arrays.stream(recipe.getInputs().getIngredients())
                .map(ingredient -> ingredient == null ? null : ingredient.getDisplayItem())
                .toArray(ItemStack[]::new), recipeDisplayOutput);

        this.gastroRecipe = recipe;
        this.topRightDisplayItem = topRightDisplayItem;
        setResearch(research);

        if (registerRecipe)
            RecipeRegistry.registerRecipe(recipe);
    }

    @Override
    @Nonnull
    public String getRecipeSectionLabel(@Nonnull Player p) {
        return StringUtil.formatColors(GetText.tr("&7Tools/Container Required:"));
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() {
        final ItemStack[] display = new ItemStack[18];
        display[0] = GastroStacks.GUIDE_TOOLS_REQUIRED;
        display[1] = GastroStacks.GUIDE_CONTAINER_REQUIRED;

        final ItemStack[] tools = getGastroRecipe().getTools().toArray(ItemStack[]::new);
        final ItemStack container = getGastroRecipe().getInputs().getContainer().getDisplayItem();

        if (CollectionUtil.isEmpty(tools)) {
            display[2] = GastroStacks.GUIDE_NONE;
        } else {
            display[2] = tools[0];
        }

        if (container == null || container.getType() == Material.AIR) {
            display[3] = GastroStacks.GUIDE_NONE;
        } else {
            display[3] = container;
        }

        for (int i = 1; i < tools.length; i++) {
            display[2 + 2*i] = tools[i];
            display[3 + 2*i] = new ItemStack(Material.AIR);
        }

        display[16] = topRightDisplayItem;
        display[17] = getGastroRecipe().getInputs().getShapedness().getGuideItem();

        return Arrays.asList(display);
    }

}
