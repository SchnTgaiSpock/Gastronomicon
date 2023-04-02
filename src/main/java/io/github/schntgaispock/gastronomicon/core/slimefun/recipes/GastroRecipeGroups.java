package io.github.schntgaispock.gastronomicon.core.slimefun.recipes;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.api.recipes.components.GroupRecipeComponent;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroRecipeGroups {
    
    public static final GroupRecipeComponent FLOUR = new GroupRecipeComponent(
        Gastronomicon.key("flour"),
        SlimefunItems.WHEAT_FLOUR,
        GastroStacks.BARLEY_FLOUR );

}
