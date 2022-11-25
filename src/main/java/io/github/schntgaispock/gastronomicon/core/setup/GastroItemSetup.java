package io.github.schntgaispock.gastronomicon.core.setup;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroItemSetup {

    public static void setup() {

        Gastronomicon gn = Gastronomicon.getInstance();
        if (gn == null) return;

        GastroGroups.MAIN.register(gn);

        final ItemStack OAK_PLANKS = new ItemStack(Material.OAK_PLANKS);

        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.CUTTING_BOARD,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, null, null, null, null, null, OAK_PLANKS, OAK_PLANKS, OAK_PLANKS}
        );

    }

}
