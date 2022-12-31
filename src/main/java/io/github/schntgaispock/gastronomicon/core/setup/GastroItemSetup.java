package io.github.schntgaispock.gastronomicon.core.setup;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.items.UnplaceableItem;
import io.github.schntgaispock.gastronomicon.core.items.food.GastroFood;
import io.github.schntgaispock.gastronomicon.core.items.seeds.CropGastroSeed;
import io.github.schntgaispock.gastronomicon.core.items.seeds.FruitingGastroSeed;
import io.github.schntgaispock.gastronomicon.core.items.seeds.SimpleGastroSeed;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipes.GastroRecipeType;
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
        final ItemStack GRASS = new ItemStack(Material.GRASS);

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
            GastroStacks.STEEL_SICKLE,
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

        new SimpleGastroSeed(
            GastroStacks.RICE,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new SimpleGastroSeed(
            GastroStacks.QUINOA,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new SimpleGastroSeed(
            GastroStacks.OATS,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new SimpleGastroSeed(
            GastroStacks.SOYBEANS,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BARLEY,
            GastroRecipeType.HARVEST,
            RecipeShapes.singleCenter(GastroStacks.BARLEY_SEEDS)
        ).register(gn);

        new CropGastroSeed(
            GastroStacks.BARLEY_SEEDS,
            GastroStacks.BARLEY
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RYE,
            GastroRecipeType.HARVEST,
            RecipeShapes.singleCenter(GastroStacks.RYE_SEEDS)
        ).register(gn);

        new CropGastroSeed(
            GastroStacks.RYE_SEEDS,
            GastroStacks.RYE
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SORGHUM,
            GastroRecipeType.HARVEST,
            RecipeShapes.singleCenter(GastroStacks.SORGHUM_SEEDS)
        ).register(gn);

        new CropGastroSeed(
            GastroStacks.SORGHUM_SEEDS,
            GastroStacks.SORGHUM
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.TURNIP,
            GastroRecipeType.HARVEST,
            RecipeShapes.singleCenter(GastroStacks.TURNIP_SEEDS)
        ).register(gn);

        new CropGastroSeed(
            GastroStacks.TURNIP_SEEDS,
            GastroStacks.TURNIP
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SQUASH,
            GastroRecipeType.HARVEST,
            RecipeShapes.singleCenter(GastroStacks.SQUASH_SEEDS)
        ).register(gn);

        new FruitingGastroSeed(
            GastroStacks.SQUASH_SEEDS,
            GastroStacks.SQUASH
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.CELERY,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BOK_CHOY,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SNOW_PEAS,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BROCCOLI,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.WASABI_PLANT,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.LEMONGRASS,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.CUCUMBER,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BASIL,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SPINACH,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BRUSSLES_SPROUTS,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.MINT,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.CHILI_PEPPER,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.PARSLEY,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.CASSAVA,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.LENTILS,
            GastroRecipeType.BREAK,
            RecipeShapes.singleCenter(GRASS)
        ).register(gn);

        // ---- Food ----

        // -- Ingredients --

        new UnplaceableItem(
            GastroGroups.FOOD,
            GastroStacks.COOKED_RICE,
            GastroRecipeType.ENHANCED_OVEN,
            RecipeShapes.singleCenter(GastroStacks.RICE)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.FOOD,
            GastroStacks.COOKED_RICE,
            GastroRecipeType.ENHANCED_OVEN,
            RecipeShapes.singleCenter(GastroStacks.RICE)
        ).register(gn);

        // -- Cuisine --

        new GastroFood(
            GastroGroups.FOOD,
            GastroStacks.ONIGIRI,
            GastroRecipeType.CULINARY_WORKBENCH,
            RecipeShapes.collection(GastroStacks.RICE, DRIED_KELP),
            RecipeShapes.collection(GastroStacks.GUIDE_NO_TOOLS_REQUIRED)
        ).register(gn);
    }
}
