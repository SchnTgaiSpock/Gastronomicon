package io.github.schntgaispock.gastronomicon.core.recipes;

import java.util.List;

import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents a recipe used by any of the Gastronomicon machines
 */
@Getter
@RequiredArgsConstructor
public abstract class GastroRecipe {

    /**
     * RecipeShape
     */
    public enum RecipeShape {
        SHAPED,
        SHAPELESS
    }

    public enum RecipeResult {
        // -- Break states --
        SUCCESS, // The recipe matches and there is enough
        NO_RESEARCH, // Correct recipe but the player didn't have the required research
        // -- Continue states --
        NO_MATCH, // Not enough / wrong items
        OTHER, // Failed for some other reason
    }
    
    protected final ItemStack[] displayRecipe;
    protected final List<ItemStack> displayTools;
    protected final RecipeShape shape;

    public abstract RecipeResult matches(Object[] givenRecipe, List<ItemStack> givenTools);

    /**
     * Like hashCode(), but only for the inputs. Used by
     * the {@link GastroRecipeRegistry}
     * @return
     */
    public abstract int inputHash();

}
