package io.github.schntgaispock.gastronomicon.core.setup;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipes.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.food.GastroFood;
import io.github.schntgaispock.gastronomicon.util.RecipeShapes;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroItemSetup {

    public static void setup() {

        Gastronomicon gn = Gastronomicon.getInstance();
        if (gn == null) return;

        GastroGroups.MAIN.register(gn);

        final ItemStack OAK_SLAB = new ItemStack(Material.OAK_SLAB);
        final ItemStack STICK = new ItemStack(Material.STICK);
        final ItemStack SHEARS = new ItemStack(Material.SHEARS);
        final ItemStack IRON_BARS = new ItemStack(Material.IRON_BARS);
        final ItemStack IRON_NUGGET = new ItemStack(Material.IRON_NUGGET);
        final ItemStack BUCKET = new ItemStack(Material.BUCKET);
        final ItemStack BOWL = new ItemStack(Material.BOWL);
        final ItemStack IRON_PP = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        final ItemStack BARREL = new ItemStack(Material.BARREL);
        final ItemStack IRON_BLOCK = new ItemStack(Material.IRON_BLOCK);
        final ItemStack CRAFTING_TABLE = new ItemStack(Material.CRAFTING_TABLE);
        final ItemStack BLAST_FURNACE = new ItemStack(Material.BLAST_FURNACE);
        final ItemStack DRIED_KELP = new ItemStack(Material.DRIED_KELP);
        final ItemStack STRING = new ItemStack(Material.STRING);
        final ItemStack COBWEB = new ItemStack(Material.COBWEB);

        // ---- Tools ----

        // -- Workstation Tools --

        // Culinary Workbench
        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.CUTTING_BOARD,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeShapes.row(OAK_SLAB, 2)
        ).register(gn);
        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.MEAT_SCISSORS,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT, SHEARS, SlimefunItems.STEEL_INGOT, null}
        ).register(gn);
        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.KITCHEN_KNIFE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, null, null, null, SlimefunItems.STEEL_INGOT, null, null, STICK, null}
        ).register(gn);
        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.ROLLING_PIN,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeShapes.row(STICK, 1)
        ).register(gn);
        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.BLENDER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, SlimefunItems.ELECTRIC_MOTOR, null, null, IRON_BARS, null, null, BUCKET, null}
        ).register(gn);
        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.MORTAR_AND_PESTLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, null, null, null, SlimefunItems.STEEL_INGOT, null, null, BOWL, null}
        ).register(gn);
        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.PEELER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, IRON_NUGGET, null, null, IRON_NUGGET, null, null, STICK, null}
        ).register(gn);
        // Enhanced Oven
        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.BAKING_TRAY,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_INGOT, null, null, null, null, null}
        ).register(gn);
        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.FRYING_PAN,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE, null, null, null, null, null, null}
        ).register(gn);
        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_POT,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT,
                SlimefunItems.STEEL_PLATE, null, SlimefunItems.STEEL_PLATE,
                SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE
            }
        ).register(gn);

        // -- Traps --

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_WIRE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeShapes.row(SlimefunItems.STEEL_INGOT, 1)
        ).register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_SPRING,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeShapes.cyclicAlternating(null, GastroStacks.STEEL_WIRE)
        ).register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.CRAB_TRAP,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {STICK, STICK, STICK, STICK, null, STICK, OAK_SLAB, OAK_SLAB, OAK_SLAB}
        ).register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.LOBSTER_TRAP,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {IRON_BARS, IRON_BARS, IRON_BARS, IRON_BARS, null, IRON_BARS, OAK_SLAB, OAK_SLAB, OAK_SLAB}
        ).register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.HUNTING_TRAP,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, SlimefunItems.STEEL_INGOT, null,
                SlimefunItems.STEEL_INGOT, IRON_PP, SlimefunItems.STEEL_INGOT,
                GastroStacks.STEEL_SPRING, GastroStacks.STEEL_SPRING, GastroStacks.STEEL_SPRING
            }
        ).register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.FISHING_NET,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeShapes.cyclicAlternating(STRING, COBWEB, COBWEB)
        ).register(gn);

        // -- Other --

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.GRAIN_SICKLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_INGOT,
                null, SlimefunItems.STEEL_INGOT, null,
                STICK, null, null
            }
        ).register(gn);
        
        // ---- Basic Machines ----

        new SlimefunItem(
            GastroGroups.BASIC_MACHINES,
            GastroStacks.CULINARY_WORKBENCH,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, IRON_PP, null, IRON_BLOCK, CRAFTING_TABLE, IRON_BLOCK, null, BARREL, null}
        ).register(gn);
        new SlimefunItem(
            GastroGroups.BASIC_MACHINES,
            GastroStacks.ENHANCED_OVEN,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, IRON_PP, null,
                SlimefunItems.HEATING_COIL, BLAST_FURNACE, SlimefunItems.HEATING_COIL,
                SlimefunItems.COPPER_WIRE, SlimefunItems.ENERGY_CONNECTOR, SlimefunItems.COPPER_WIRE
            }
        ).register(gn);

        // ---- Raw Ingredients ----

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RICE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeShapes.singleCenter(GastroStacks.RYE_SEEDS)
        ).register(gn);

        // ---- Food ----

        new GastroFood(
            GastroGroups.FOOD,
            GastroStacks.ONIGIRI,
            GastroRecipeType.CULINARY_WORKBENCH,
            RecipeShapes.collection(GastroStacks.RICE, DRIED_KELP),
            RecipeShapes.collection(GastroStacks.GUIDE_NO_TOOLS_REQUIRED)
        ).register(gn);
        new GastroFood(
            GastroGroups.FOOD,
            GastroStacks.ONIGIRI.asPerfect("temporary2"),
            GastroRecipeType.CULINARY_WORKBENCH,
            RecipeShapes.collection(GastroStacks.RICE, DRIED_KELP),
            RecipeShapes.collection(GastroStacks.GUIDE_NO_TOOLS_REQUIRED)
        ).register(gn);
    }
}
