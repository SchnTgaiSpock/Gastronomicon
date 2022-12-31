package io.github.schntgaispock.gastronomicon.core.recipes;

import java.util.List;

import org.bukkit.inventory.ItemStack;

import lombok.Getter;

/**
 * Represents a recipe used by any of the Gastronomicon machines
 */
@Getter
public abstract class AbstractGastroRecipe {

    public enum Result {
        // -- Break states --
        SUCCESS, // The recipe matches and there is enough
        NO_RESEARCH, // The player didn't have the required research
        // -- Continue states --
        NO_MATCH, // Not enough / wrong items
        OTHER, // Failed for some other reason
    }
    
    protected final ItemStack[] displayRecipe;
    protected final List<ItemStack> displayTools;

    public AbstractGastroRecipe(ItemStack[] displayRecipe, List<ItemStack> displayTools) {
        this.displayRecipe = displayRecipe;
        this.displayTools = displayTools;
    }

    public abstract Result matches(ItemStack[] givenRecipe, List<ItemStack> givenTools);

    /**
     * Like hashCode(), but only for the inputs. Used by
     * the {@link GastroRecipeRegistry}
     * @return
     */
    public abstract int inputHash();

}
