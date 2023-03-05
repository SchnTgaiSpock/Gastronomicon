package io.github.schntgaispock.gastronomicon.core.setup;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.api.recipes.MultiStoveRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.RecipeRegistry;
import io.github.schntgaispock.gastronomicon.api.recipes.ShapedGastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.core.items.UnplaceableItem;
import io.github.schntgaispock.gastronomicon.core.items.food.GastroFoodBuilder;
import io.github.schntgaispock.gastronomicon.core.items.food.SimpleGastroFoodBuilder;
import io.github.schntgaispock.gastronomicon.core.items.seeds.CropSeed;
import io.github.schntgaispock.gastronomicon.core.items.seeds.DuplicatingSeed;
import io.github.schntgaispock.gastronomicon.core.items.seeds.FruitingSeed;
import io.github.schntgaispock.gastronomicon.core.items.seeds.RightClickSeed;
import io.github.schntgaispock.gastronomicon.core.items.seeds.SimpleSeed;
import io.github.schntgaispock.gastronomicon.core.items.workstations.CulinaryWorkbench;
import io.github.schntgaispock.gastronomicon.core.items.workstations.Distillery;
import io.github.schntgaispock.gastronomicon.core.items.workstations.GrainMill;
import io.github.schntgaispock.gastronomicon.core.items.workstations.MultiStove;
import io.github.schntgaispock.gastronomicon.core.items.workstations.Refridgerator;
import io.github.schntgaispock.gastronomicon.core.items.workstations.MultiStove.Temperature;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.util.recipe.RecipeUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemSetup {

    public static ItemStack getItem(String id) {
        final SlimefunItem item = SlimefunItem.getById(id);
        if (item == null)
            return null;
        return item.getItem();
    }

    public static void setup() {

        final Gastronomicon gn = Gastronomicon.getInstance();
        final boolean egAvailable = Gastronomicon.isPluginEnabled("ExoticGarden");

        GastroGroups.MAIN.register(gn);

        final ItemStack ORANGE = getItem("ORANGE");
        final ItemStack LETTUCE = getItem("LETTUCE");
        final ItemStack GARLIC = getItem("GARLIC");
        final ItemStack TOMATO = getItem("TOMATO");
        final ItemStack ONION = getItem("ONION");
        final ItemStack BACON = getItem("BACON");
        final ItemStack MAYO = getItem("MAYO");
        final ItemStack CORN = getItem("CORN");
        final ItemStack BBQ_SAUCE = getItem("BBQ_SAUCE");
        final ItemStack CURRY_LEAF = getItem("CURRY_LEAF");
        final ItemStack CILANTRO = getItem("CILANTRO");
        final ItemStack KETCHUP = getItem("KETCHUP");
        final ItemStack BLUEBERRY = getItem("BLUEBERRY");
        final ItemStack CRANBERRY = getItem("CRANBERRY");
        final ItemStack GRAPE = getItem("GRAPE");
        final ItemStack TEA_LEAF = getItem("TEA_LEAF");
        final ItemStack STRAWBERRY = getItem("STRAWBERRY");
        final ItemStack COWBERRY = getItem("COWBERRY");
        final ItemStack COCONUT = getItem("COCONUT");
        final ItemStack CHERRY = getItem("CHERRY");
        final ItemStack RASPBERRY = getItem("RASPBERRY");
        final ItemStack PEACH = getItem("PEACH");
        final ItemStack PINEAPPLE = getItem("PINEAPPLE");
        final ItemStack BANANA = getItem("BANANA");
        final ItemStack LEMON = getItem("LEMON");
        final ItemStack YEAST = getItem("YEAST");
        final ItemStack OAK_PLANKS = new ItemStack(Material.OAK_PLANKS);
        final ItemStack OAK_SLAB = new ItemStack(Material.OAK_SLAB);
        final ItemStack OAK_FENCE = new ItemStack(Material.OAK_FENCE);
        final ItemStack STICK = new ItemStack(Material.STICK);
        final ItemStack SHEARS = new ItemStack(Material.SHEARS);
        final ItemStack IRON_BARS = new ItemStack(Material.IRON_BARS);
        final ItemStack IRON_NUGGET = new ItemStack(Material.IRON_NUGGET);
        final ItemStack IRON_TRAPDOOR = new ItemStack(Material.IRON_TRAPDOOR);
        final ItemStack BUCKET = new ItemStack(Material.BUCKET);
        final ItemStack BOWL = new ItemStack(Material.BOWL);
        final ItemStack IRON_PP = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        final ItemStack IRON_BLOCK = new ItemStack(Material.IRON_BLOCK);
        final ItemStack HOPPER = new ItemStack(Material.HOPPER);
        final ItemStack BARREL = new ItemStack(Material.BARREL);
        final ItemStack CRAFTING_TABLE = new ItemStack(Material.CRAFTING_TABLE);
        final ItemStack DISPENSER = new ItemStack(Material.DISPENSER);
        final ItemStack BLAST_FURNACE = new ItemStack(Material.BLAST_FURNACE);
        final ItemStack DRIED_KELP = new ItemStack(Material.DRIED_KELP);
        final ItemStack POLISHED_GRANITE = new ItemStack(Material.POLISHED_GRANITE);
        final ItemStack ANDESITE_SLAB = new ItemStack(Material.ANDESITE_SLAB);
        final ItemStack BREAD = new ItemStack(Material.BREAD);
        final ItemStack EGG = new ItemStack(Material.EGG);
        final ItemStack WATER_BUCKET = new ItemStack(Material.WATER_BUCKET);
        final ItemStack MILK_BUCKET = new ItemStack(Material.WATER_BUCKET);
        final ItemStack SUGAR = new ItemStack(Material.SUGAR);
        final ItemStack COOKED_PORKCHOP = new ItemStack(Material.COOKED_PORKCHOP);
        final ItemStack COOKED_CHICKEN = new ItemStack(Material.COOKED_CHICKEN);
        final ItemStack COOKED_BEEF = new ItemStack(Material.COOKED_BEEF);
        final ItemStack PORKCHOP = new ItemStack(Material.PORKCHOP);
        final ItemStack CHICKEN = new ItemStack(Material.CHICKEN);
        final ItemStack BEEF = new ItemStack(Material.BEEF);
        final ItemStack MUTTON = new ItemStack(Material.MUTTON);
        final ItemStack APPLE = new ItemStack(Material.APPLE);
        final ItemStack SALMON = new ItemStack(Material.SALMON);
        final ItemStack INK_SAC = new ItemStack(Material.INK_SAC);
        final ItemStack GLOW_INK_SAC = new ItemStack(Material.GLOW_INK_SAC);
        final ItemStack CARROT = new ItemStack(Material.CARROT);
        final ItemStack POTATO = new ItemStack(Material.POTATO);
        final ItemStack COCOA_BEANS = new ItemStack(Material.COCOA_BEANS);
        final ItemStack CHORUS_FRUIT = new ItemStack(Material.CHORUS_FRUIT);
        final ItemStack ICE = new ItemStack(Material.ICE);
        final ItemStack HONEY_BOTTLE = new ItemStack(Material.HONEY_BOTTLE);
        final ItemStack MELON_SLICE = new ItemStack(Material.MELON_SLICE);

        // ---- Tools ----

        // -- Workstation Tools --

        // Culinary Workbench
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.CUTTING_BOARD,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.row(OAK_SLAB, 2))
                .register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.ROLLING_PIN,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.row(STICK, 1))
                .register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.MEAT_SCISSORS,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] { null, SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT, null,
                SlimefunItems.STEEL_INGOT, SHEARS, SlimefunItems.STEEL_INGOT, null })
                    .register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.KITCHEN_KNIFE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] { null, null, null, null, SlimefunItems.STEEL_INGOT, null, null, STICK, null })
                .register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.BLENDER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] { null, SlimefunItems.ELECTRIC_MOTOR, null, null, IRON_BARS, null, null, BUCKET, null })
                .register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.MORTAR_AND_PESTLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] { null, null, null, null, SlimefunItems.STEEL_INGOT, null, null, BOWL, null })
                .register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.PEELER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] { null, IRON_NUGGET, null, null, IRON_NUGGET, null, null, STICK, null })
                .register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.WHISK,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] { null, GastroStacks.STEEL_WIRE, null, null, GastroStacks.STEEL_WIRE, null, null, STICK,
                null })
                    .register(gn);
        // Enhanced Oven
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.BAKING_TRAY,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] { SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_INGOT, null,
                null, null, null, null })
                    .register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.FRYING_PAN,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] { SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE, null,
                null, null, null, null, null }).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_POT,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT,
                SlimefunItems.STEEL_PLATE, null, SlimefunItems.STEEL_PLATE,
                SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE
            }).register(gn);

        // -- Containers --

        new UnplaceableBlock(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_BOWL,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.collection(
                null, null, null,
                SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT,
                null, SlimefunItems.STEEL_INGOT, null)).register(gn);

        // -- Traps --

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_WIRE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.row(SlimefunItems.STEEL_INGOT, 1),
            new SlimefunItemStack(GastroStacks.STEEL_WIRE, 8))
                .register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_SPRING,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.cyclicAlternating(null, GastroStacks.STEEL_WIRE))
                .register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.CRAB_TRAP,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] { STICK, STICK, STICK, STICK, GastroStacks.STEEL_WIRE, STICK, OAK_SLAB, OAK_SLAB,
                OAK_SLAB })
                    .register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.HUNTING_TRAP,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, SlimefunItems.STEEL_INGOT, null,
                SlimefunItems.STEEL_INGOT, IRON_PP, SlimefunItems.STEEL_INGOT,
                GastroStacks.STEEL_SPRING, GastroStacks.STEEL_SPRING, GastroStacks.STEEL_SPRING
            })
                .register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.FISHING_NET,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.block(GastroStacks.STEEL_WIRE))
                .register(gn);

        // -- Other --

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.WOODEN_SICKLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, OAK_PLANKS, OAK_PLANKS,
                null, STICK, null,
                STICK, null, null
            })
                .register(gn);

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_SICKLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE,
                null, STICK, null,
                STICK, null, null
            })
                .register(gn);

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.REINFORCED_SICKLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_PLATE,
                null, STICK, null,
                STICK, null, null
            })
                .register(gn);

        // ---- Basic Machines ----

        new CulinaryWorkbench(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.CULINARY_WORKBENCH,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                POLISHED_GRANITE, POLISHED_GRANITE, POLISHED_GRANITE,
                BARREL, CRAFTING_TABLE, BARREL,
                IRON_BLOCK, DISPENSER, IRON_BLOCK
            })
                .register(gn);

        new MultiStove(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.MULTI_STOVE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                IRON_PP, IRON_PP, IRON_PP,
                SlimefunItems.HEATING_COIL, BLAST_FURNACE, SlimefunItems.HEATING_COIL,
                SlimefunItems.HEATING_COIL, SlimefunItems.ENERGY_CONNECTOR, SlimefunItems.HEATING_COIL
            })
                .register(gn);

        new Refridgerator(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.REFRIDGERATOR,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                SlimefunItems.STEEL_INGOT, SlimefunItems.COOLING_UNIT, SlimefunItems.STEEL_INGOT,
                SlimefunItems.STEEL_INGOT, IRON_TRAPDOOR, SlimefunItems.STEEL_INGOT,
                SlimefunItems.STEEL_INGOT, SlimefunItems.COOLING_UNIT, SlimefunItems.STEEL_INGOT
            })
                .register(gn);

        new GrainMill(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.MILL,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, HOPPER, null,
                IRON_BARS, SlimefunItems.DAMASCUS_STEEL_INGOT, IRON_BARS,
                null, ANDESITE_SLAB, null
            })
                .register(gn);

        new Distillery(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.DISTILLERY,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                OAK_FENCE, OAK_SLAB, OAK_FENCE,
                OAK_FENCE, BARREL, OAK_FENCE,
                OAK_FENCE, BARREL, OAK_FENCE
            })
                .register(gn);

        // ---- Raw Ingredients ----

        new SimpleSeed(
            GastroStacks.RICE,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SimpleSeed(
            GastroStacks.QUINOA,
            Material.WHEAT,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SimpleSeed(
            GastroStacks.OATS,
            Material.WHEAT,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SimpleSeed(
            GastroStacks.SOYBEANS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BARLEY,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.BARLEY_SEEDS))
                .register(gn);

        new CropSeed(
            GastroStacks.BARLEY_SEEDS,
            Material.WHEAT,
            GastroStacks.BARLEY)
                .register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RYE,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.RYE_SEEDS))
                .register(gn);

        new CropSeed(
            GastroStacks.RYE_SEEDS,
            Material.WHEAT,
            GastroStacks.RYE)
                .register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SORGHUM,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.SORGHUM_SEEDS))
                .register(gn);

        new CropSeed(
            GastroStacks.SORGHUM_SEEDS,
            Material.WHEAT,
            GastroStacks.SORGHUM)
                .register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.TURNIP,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.TURNIP_SEEDS))
                .register(gn);

        new CropSeed(
            GastroStacks.TURNIP_SEEDS,
            Material.BEETROOTS,
            GastroStacks.TURNIP)
                .register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SQUASH,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.SQUASH_SEEDS))
                .register(gn);

        new FruitingSeed(
            GastroStacks.SQUASH_SEEDS,
            Material.MELON_STEM,
            GastroStacks.SQUASH,
            "GN_SQUASH")
                .register(gn);

        new DuplicatingSeed(
            GastroStacks.CELERY,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.BOK_CHOY,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.SNOW_PEAS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.BROCCOLI,
            Material.CARROTS,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.WASABI_PLANT,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new DuplicatingSeed(
            GastroStacks.LEMONGRASS,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.CUCUMBER,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.BASIL,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.SPINACH,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.BRUSSLES_SPROUTS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.MINT,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.CHILI_PEPPER,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.PARSLEY,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SimpleSeed(
            GastroStacks.CASSAVA,
            Material.BEETROOTS,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SimpleSeed(
            GastroStacks.LENTILS,
            Material.CARROTS,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SimpleSeed(
            GastroStacks.PEANUTS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SimpleSeed(
            GastroStacks.BEANS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SimpleSeed(
            GastroStacks.PEAS,
            Material.BEETROOTS,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.ASPARAGUS,
            Material.CARROTS,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.GREEN_ONION,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new RightClickSeed(
            GastroStacks.CAULIFLOWER,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.AVOCADO,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.AVOCADO_PIT))
                .register(gn);

        new RightClickSeed(
            GastroStacks.AVOCADO_PIT,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SimpleSeed(
            GastroStacks.TURMERIC,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new SimpleSeed(
            GastroStacks.CUMIN_SEEDS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        // -- Grown from trees

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.LYCHEE,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.LYCHEE_SAPLING))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.LYCHEE_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.PERSIMMON,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.PERSIMMON_SAPLING))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.PERSIMMON_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BANANA,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.BANANA_SAPLING))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BANANA_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.VANILLA_BEANS,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.VANILLA_SAPLING))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.VANILLA_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS))
                .register(gn);

        // -- Harvested --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.FIDDLEHEADS,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.FERN))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.TRUFFLES,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.ENOKI_MUSHROOMS,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.KING_OYSTER_MUSHROOM,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BUTTON_MUSHROOM,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.CLAM,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.SEAGRASS))
                .register(gn);

        // -- Mob Drops --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_CHEVON,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_GOAT))
                .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .group(GastroGroups.RAW_INGREDIENTS)
            .item(GastroStacks.COOKED_CHEVON)
            .ingredients(GastroStacks.RAW_CHEVON)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.FROG_LEG,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_FROG))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.GIANT_SPIDER_LEG,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_SPIDER))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SALMON_ROE,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_SALMON))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.GUARDIAN_FIN,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_GUARDIAN))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_SQUID,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_SQUID))
                .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .group(GastroGroups.RAW_INGREDIENTS)
            .item(GastroStacks.COOKED_SQUID)
            .ingredients(GastroStacks.RAW_SQUID)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        // -- From Fishing --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_MACKEREL,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET))
                .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .group(GastroGroups.RAW_INGREDIENTS)
            .item(GastroStacks.COOKED_MACKEREL)
            .ingredients(GastroStacks.RAW_MACKEREL)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_EEL,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET))
                .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .group(GastroGroups.RAW_INGREDIENTS)
            .item(GastroStacks.COOKED_EEL)
            .ingredients(GastroStacks.RAW_EEL)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_TROUT,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET))
                .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .group(GastroGroups.RAW_INGREDIENTS)
            .item(GastroStacks.COOKED_TROUT)
            .ingredients(GastroStacks.RAW_TROUT)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_BASS,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET))
                .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .group(GastroGroups.RAW_INGREDIENTS)
            .item(GastroStacks.COOKED_BASS)
            .ingredients(GastroStacks.RAW_BASS)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_CARP,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET))
                .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .group(GastroGroups.RAW_INGREDIENTS)
            .item(GastroStacks.COOKED_CARP)
            .ingredients(GastroStacks.RAW_CARP)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_PIKE,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET))
                .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .group(GastroGroups.RAW_INGREDIENTS)
            .item(GastroStacks.COOKED_PIKE)
            .ingredients(GastroStacks.RAW_PIKE)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_TUNA,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET))
                .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .group(GastroGroups.RAW_INGREDIENTS)
            .item(GastroStacks.COOKED_TUNA)
            .ingredients(GastroStacks.RAW_TUNA)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SHRIMP,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET))
                .register(gn);

        // -- From traps --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.CRAB,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.CRAB_TRAP))
                .register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_TURKEY,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.HUNTING_TRAP))
                .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .group(GastroGroups.RAW_INGREDIENTS)
            .item(GastroStacks.COOKED_TURKEY)
            .ingredients(GastroStacks.RAW_TURKEY)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        // ---- Food ----

        // -- Ingredients --

        new SimpleGastroFoodBuilder()
            .item(GastroStacks.COOKED_RICE)
            .type(GastroRecipeType.MULTI_STOVE)
            .ingredients(GastroStacks.RICE)
            .tools(GastroStacks.STEEL_POT)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .item(GastroStacks.BARLEY_FLOUR)
            .type(GastroRecipeType.MILL)
            .ingredients(GastroStacks.BARLEY)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .item(GastroStacks.DOUGH)
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .ingredients(SlimefunItems.WHEAT_FLOUR, GastroStacks.WATER_BOTTLE)
            .temperature(Temperature.LOW)
            .register(gn);
        RecipeRegistry.registerRecipe(new ShapedGastroRecipe(
            GastroRecipeType.CULINARY_WORKBENCH,
            RecipeUtil.collection(GastroStacks.BARLEY_FLOUR, GastroStacks.WATER_BOTTLE),
            new HashSet<>(), // I don't know how to get shapeless recipes to work with groups, so this is the
                             // best I can do
            GastroStacks.DOUGH));

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.TOAST)
            .ingredients(BREAD)
            .temperature(Temperature.LOW)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.NAAN_BREAD)
            .ingredients(GastroStacks.DOUGH)
            .tools(GastroStacks.ROLLING_PIN)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.PEANUT_BUTTER)
            .ingredients(GastroStacks.PEANUTS)
            .temperature(Temperature.LOW)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.FRIED_EGG)
            .ingredients(EGG)
            .temperature(Temperature.LOW)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.HARD_BOILED_EGG)
            .ingredients(EGG, WATER_BUCKET)
            .temperature(Temperature.LOW)
            .tools(GastroStacks.STEEL_POT)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.SCRAMBLED_EGGS)
            .ingredients(EGG)
            .tools(GastroStacks.FRYING_PAN, GastroStacks.WHISK)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CUSTARD)
            .ingredients(EGG, MILK_BUCKET, SUGAR)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CARAMEL)
            .ingredients(SUGAR)
            .temperature(Temperature.LOW)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        if (egAvailable)
            new SimpleGastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.MARMALADE)
                .ingredients(ORANGE)
                .container(GastroStacks.WATER_BOTTLE)
                .temperature(Temperature.LOW)
                .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.PULLED_PORK)
            .ingredients(COOKED_PORKCHOP)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.GROUND_BEEF)
            .ingredients(COOKED_BEEF)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.BAKED_BEANS)
            .ingredients(GastroStacks.BEANS)
            .temperature(Temperature.LOW)
            .tools(GastroStacks.BAKING_TRAY)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.DISTILLERY)
            .item(GastroStacks.MISO)
            .ingredients(GastroStacks.SOYBEANS, SlimefunItems.SALT, GastroStacks.RICE)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.TOFU)
            .ingredients(GastroStacks.SOYBEANS, WATER_BUCKET)
            .tools(GastroStacks.BLENDER)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.DISTILLERY)
            .item(GastroStacks.SOY_SAUCE)
            .ingredients(GastroStacks.SOYBEANS)
            .register(gn);

        new SimpleGastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.TURMERIC_POWDER)
            .ingredients(GastroStacks.TURMERIC)
            .tools(GastroStacks.MORTAR_AND_PESTLE)
            .register(gn);

        // -- Cuisine --

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.PBJ_SANDWICH)
            .shape(RecipeShape.SHAPED)
            .ingredients(
                null, GastroStacks.TOAST, null,
                GastroStacks.PEANUT_BUTTER, APPLE, GastroStacks.PEANUT_BUTTER,
                null, GastroStacks.TOAST, null)
            .register(gn);

        if (egAvailable)
            new GastroFoodBuilder()
                .type(GastroRecipeType.CULINARY_WORKBENCH)
                .item(GastroStacks.MARMALADE_SANDWICH)
                .shape(RecipeShape.SHAPED)
                .ingredients(
                    null, GastroStacks.TOAST, null,
                    GastroStacks.MARMALADE, GastroStacks.MARMALADE, GastroStacks.MARMALADE,
                    null, GastroStacks.TOAST, null)
                .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.BAKED_BEANS_AND_TOAST)
            .shape(RecipeShape.SHAPED)
            .ingredients(
                null, null, null,
                GastroStacks.BAKED_BEANS, GastroStacks.BAKED_BEANS, GastroStacks.BAKED_BEANS,
                null, GastroStacks.TOAST, null)
            .register(gn);

        if (egAvailable)
            new GastroFoodBuilder()
                .type(GastroRecipeType.CULINARY_WORKBENCH)
                .item(GastroStacks.TUNA_SANDWICH)
                .shape(RecipeShape.SHAPED)
                .ingredients(
                    null, GastroStacks.TOAST, null,
                    GastroStacks.COOKED_TUNA, LETTUCE, MAYO,
                    null, GastroStacks.TOAST, null)
                .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.BREAKFAST_SANDWICH)
            .shape(RecipeShape.SHAPED)
            .ingredients(
                null, GastroStacks.TOAST, null,
                GastroStacks.FRIED_EGG, COOKED_PORKCHOP, GastroStacks.FRIED_EGG,
                null, GastroStacks.TOAST, null)
            .register(gn);

        if (egAvailable)
            new GastroFoodBuilder()
                .type(GastroRecipeType.CULINARY_WORKBENCH)
                .item(GastroStacks.HAM_SANDWICH)
                .shape(RecipeShape.SHAPED)
                .ingredients(
                    null, GastroStacks.TOAST, null,
                    LETTUCE, COOKED_PORKCHOP, MAYO,
                    null, GastroStacks.TOAST, null)
                .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.CHICKEN_SANDWICH)
            .shape(RecipeShape.SHAPED)
            .ingredients(
                null, GastroStacks.TOAST, null,
                GastroStacks.FRIED_EGG, COOKED_CHICKEN, GastroStacks.FRIED_EGG,
                null, GastroStacks.TOAST, null)
            .register(gn);

        if (egAvailable)
            new GastroFoodBuilder()
                .type(GastroRecipeType.CULINARY_WORKBENCH)
                .item(GastroStacks.EGG_SALAD_SANDWICH)
                .shape(RecipeShape.SHAPED)
                .ingredients(
                    null, GastroStacks.TOAST, null,
                    LETTUCE, GastroStacks.SCRAMBLED_EGGS, MAYO,
                    null, GastroStacks.TOAST, null)
                .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.ROAST_BEEF_SANDWICH)
            .shape(RecipeShape.SHAPED)
            .ingredients(
                null, GastroStacks.TOAST, null,
                GastroStacks.FRIED_EGG, COOKED_BEEF, GastroStacks.FRIED_EGG,
                null, GastroStacks.TOAST, null)
            .register(gn);

        if (egAvailable) {
            new GastroFoodBuilder()
                .type(GastroRecipeType.CULINARY_WORKBENCH)
                .item(GastroStacks.CLUB_SANDWICH)
                .shape(RecipeShape.SHAPED)
                .ingredients(
                    null, GastroStacks.TOAST, null,
                    LETTUCE, COOKED_PORKCHOP, TOMATO,
                    null, GastroStacks.TOAST, null)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.CULINARY_WORKBENCH)
                .item(GastroStacks.GREEK_SALAD)
                .shape(RecipeShape.SHAPELESS)
                .ingredients(TOMATO, GastroStacks.CUCUMBER, ONION, SlimefunItems.CHEESE)
                .container(BOWL)
                .tools(GastroStacks.KITCHEN_KNIFE)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.CULINARY_WORKBENCH)
                .item(GastroStacks.CAESAR_SALAD)
                .shape(RecipeShape.SHAPELESS)
                .ingredients(LETTUCE, GastroStacks.TOAST, BACON, SlimefunItems.CHEESE)
                .container(BOWL)
                .tools(GastroStacks.KITCHEN_KNIFE)
                .register(gn);
        }

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.PAN_SEARED_SALMON)
            .ingredients(SALMON)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.FRIED_SHRIMP)
            .ingredients(GastroStacks.SHRIMP)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.TEMPURA_SHRIMP)
            .ingredients(GastroStacks.SHRIMP, BREAD)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.TEMPURA_BROCCOLI)
            .ingredients(GastroStacks.BROCCOLI, BREAD)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CHICKEN_PESTO_PASTA)
            .ingredients(GastroStacks.DOUGH, GastroStacks.BASIL, CHICKEN, SlimefunItems.CHEESE, WATER_BUCKET)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.ROLLING_PIN, GastroStacks.MORTAR_AND_PESTLE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.SQUID_INK_PASTA)
            .ingredients(GastroStacks.DOUGH, GastroStacks.BASIL, INK_SAC, SlimefunItems.CHEESE, WATER_BUCKET)
            .container(BOWL)
            .tools(GastroStacks.FRYING_PAN, GastroStacks.ROLLING_PIN)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.GLOWING_SQUID_INK_PASTA)
            .ingredients(GastroStacks.DOUGH, GastroStacks.BASIL, GLOW_INK_SAC, SlimefunItems.CHEESE, WATER_BUCKET)
            .container(BOWL)
            .tools(GastroStacks.FRYING_PAN, GastroStacks.ROLLING_PIN)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.TUNA_CASSEROLE)
            .ingredients(GastroStacks.DOUGH, GastroStacks.RAW_TUNA, GastroStacks.CREAM_OF_MUSHROOM_SOUP,
                GastroStacks.PEAS)
            .tools(GastroStacks.ROLLING_PIN, GastroStacks.BAKING_TRAY)
            .register(gn);

        if (egAvailable) {
            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.CHICKEN_RAVIOLI)
                .ingredients(GastroStacks.DOUGH, GastroStacks.BASIL, CHICKEN, SlimefunItems.CHEESE, TOMATO,
                    WATER_BUCKET)
                .container(BOWL)
                .tools(GastroStacks.FRYING_PAN, GastroStacks.ROLLING_PIN)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.MUSHROOM_RAVIOLI)
                .ingredients(GastroStacks.DOUGH, GastroStacks.BASIL, GastroStacks.BUTTON_MUSHROOM, SlimefunItems.CHEESE,
                    TOMATO, WATER_BUCKET)
                .container(BOWL)
                .tools(GastroStacks.STEEL_POT, GastroStacks.ROLLING_PIN)
                .register(gn);
        }

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.OATMEAL)
            .ingredients(WATER_BUCKET, GastroStacks.OATS)
            .container(BOWL)
            .temperature(Temperature.LOW)
            .tools(GastroStacks.STEEL_POT)
            .register(gn);
        RecipeRegistry.registerRecipe(new MultiStoveRecipe(
            RecipeUtil.collection(MILK_BUCKET, GastroStacks.OATS),
            BOWL,
            Set.of(GastroStacks.STEEL_POT),
            Temperature.LOW,
            GastroStacks.OATMEAL));

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.BARLEY_PORRIDGE)
            .ingredients(WATER_BUCKET, GastroStacks.BARLEY)
            .container(BOWL)
            .temperature(Temperature.LOW)
            .tools(GastroStacks.STEEL_POT)
            .register(gn);
        RecipeRegistry.registerRecipe(new MultiStoveRecipe(
            RecipeUtil.collection(MILK_BUCKET, GastroStacks.BARLEY),
            BOWL,
            Set.of(GastroStacks.STEEL_POT),
            Temperature.LOW,
            GastroStacks.BARLEY_PORRIDGE));

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CONGEE)
            .ingredients(WATER_BUCKET, GastroStacks.RICE)
            .container(BOWL)
            .temperature(Temperature.LOW)
            .tools(GastroStacks.STEEL_POT)
            .register(gn);
        RecipeRegistry.registerRecipe(new MultiStoveRecipe(
            RecipeUtil.collection(MILK_BUCKET, GastroStacks.RICE),
            BOWL,
            Set.of(GastroStacks.STEEL_POT),
            Temperature.LOW,
            GastroStacks.CONGEE));

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CHICKEN_SOUP)
            .ingredients(WATER_BUCKET, CHICKEN, CARROT, GastroStacks.PEAS)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CHICKEN_NOODLE_SOUP)
            .ingredients(WATER_BUCKET, CHICKEN, CARROT, GastroStacks.PEAS, GastroStacks.DOUGH)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
            .register(gn);

        if (egAvailable) {
            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.SPLIT_PEA_SOUP)
                .ingredients(WATER_BUCKET, CARROT, GastroStacks.PEAS, ONION)
                .container(BOWL)
                .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.HAM_AND_SPLIT_PEA_SOUP)
                .ingredients(WATER_BUCKET, CARROT, GastroStacks.PEAS, ONION, PORKCHOP)
                .container(BOWL)
                .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
                .register(gn);
        }

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.LENTIL_SOUP)
            .ingredients(WATER_BUCKET, CARROT, GastroStacks.LENTILS, GastroStacks.CELERY, GastroStacks.BASIL)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.BEEF_AND_LENTIL_SOUP)
            .ingredients(WATER_BUCKET, CARROT, GastroStacks.LENTILS, GastroStacks.CELERY, GastroStacks.BASIL, BEEF)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CARROT_SOUP)
            .ingredients(WATER_BUCKET, CARROT, POTATO, GastroStacks.PEAS, GastroStacks.CELERY)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.MUSHROOM_BARLEY_SOUP)
            .ingredients(WATER_BUCKET, GastroStacks.BARLEY, GastroStacks.BUTTON_MUSHROOM, GastroStacks.PEAS,
                GastroStacks.CELERY)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CHICKEN_BARLEY_SOUP)
            .ingredients(WATER_BUCKET, GastroStacks.BARLEY, CHICKEN, GastroStacks.PEAS, CARROT)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.BEEF_BARLEY_SOUP)
            .ingredients(WATER_BUCKET, GastroStacks.BARLEY, COOKED_BEEF, GastroStacks.BROCCOLI, GastroStacks.CELERY)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CREAM_OF_MUSHROOM_SOUP)
            .ingredients(MILK_BUCKET, SlimefunItems.BUTTER, GastroStacks.BUTTON_MUSHROOM, GastroStacks.CELERY)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CREAM_OF_BROCCOLI_SOUP)
            .ingredients(MILK_BUCKET, SlimefunItems.BUTTER, GastroStacks.BROCCOLI, GastroStacks.CELERY)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CREAM_OF_ASPARAGUS_SOUP)
            .ingredients(MILK_BUCKET, SlimefunItems.BUTTER, GastroStacks.ASPARAGUS, GastroStacks.CELERY)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CREAM_OF_CAULIFLOWER_SOUP)
            .ingredients(MILK_BUCKET, SlimefunItems.BUTTER, GastroStacks.CAULIFLOWER, GastroStacks.CELERY)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.MISO_SOUP)
            .ingredients(WATER_BUCKET, DRIED_KELP, GastroStacks.MISO)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.BROCCOLI_CHOWDER)
            .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, GastroStacks.SHRIMP, GastroStacks.BASIL,
                GastroStacks.BROCCOLI)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.SALMON_CHOWDER)
            .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, GastroStacks.SHRIMP, GastroStacks.BASIL, SALMON)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.POTATO_CHOWDER)
            .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, GastroStacks.SHRIMP, GastroStacks.BASIL, POTATO)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
            .register(gn);

        if (egAvailable)
            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.CORN_CHOWDER)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, GastroStacks.SHRIMP, GastroStacks.BASIL, CORN)
                .container(BOWL)
                .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE)
                .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.BEEF_STEW)
            .ingredients(WATER_BUCKET, POTATO, CARROT, BEEF, GastroStacks.CELERY)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CLAM_STEW)
            .ingredients(WATER_BUCKET, POTATO, CARROT, GastroStacks.CLAM, GastroStacks.CELERY)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CRAB_HOTPOT)
            .ingredients(WATER_BUCKET, GastroStacks.ENOKI_MUSHROOMS, GastroStacks.KING_OYSTER_MUSHROOM, CARROT,
                GastroStacks.CRAB, EGG, GastroStacks.GREEN_ONION)
            .container(BOWL)
            .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
            .register(gn);

        if (egAvailable) {
            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.BBQ_STEAK)
                .ingredients(BBQ_SAUCE, BEEF)
                .temperature(Temperature.HIGH)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.BBQ_PORK)
                .ingredients(BBQ_SAUCE, PORKCHOP)
                .temperature(Temperature.HIGH)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.BBQ_CHICKEN)
                .ingredients(BBQ_SAUCE, CHICKEN)
                .temperature(Temperature.HIGH)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.BBQ_MUTTON)
                .ingredients(BBQ_SAUCE, MUTTON)
                .temperature(Temperature.HIGH)
                .register(gn);
        }

        if (egAvailable) {
            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.BUTTER_CHICKEN)
                .ingredients(CHICKEN, CARROT, GastroStacks.TURMERIC_POWDER, GARLIC, TOMATO, GastroStacks.CUMIN_SEEDS,
                    GastroStacks.CHILI_PEPPER)
                .container(BOWL)
                .tools(GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.CULINARY_WORKBENCH)
                .item(GastroStacks.BUTTER_CHICKEN_WITH_NAAN_BREAD)
                .ingredients(GastroStacks.BUTTER_CHICKEN, CILANTRO, GastroStacks.NAAN_BREAD)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.SHRIMP_FRIED_RICE)
                .ingredients(GastroStacks.SHRIMP, GastroStacks.COOKED_RICE, CARROT, GastroStacks.PEAS, CORN,
                    GastroStacks.GREEN_ONION)
                .container(BOWL)
                .tools(GastroStacks.FRYING_PAN, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.CURRY_RICE)
                .ingredients(POTATO, GastroStacks.COOKED_RICE, CARROT, CURRY_LEAF, COOKED_BEEF)
                .container(BOWL)
                .tools(GastroStacks.FRYING_PAN, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.RICE_OMELETTE)
                .ingredients(GastroStacks.COOKED_RICE, EGG, KETCHUP)
                .container(BOWL)
                .tools(GastroStacks.FRYING_PAN, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER)
                .register(gn);
        }

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.RICE_BALLS)
            .ingredients(GastroStacks.COOKED_RICE, DRIED_KELP)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.BEEF_UDON)
            .ingredients(GastroStacks.DOUGH, BEEF, GastroStacks.SOY_SAUCE, GastroStacks.GREEN_ONION)
            .container(BOWL)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CHICKEN_UDON)
            .ingredients(GastroStacks.DOUGH, CHICKEN, GastroStacks.SOY_SAUCE, GastroStacks.GREEN_ONION)
            .container(BOWL)
            .tools(GastroStacks.FRYING_PAN)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.VEGETABLE_UDON)
            .ingredients(GastroStacks.DOUGH, GastroStacks.BROCCOLI, CARROT, GastroStacks.SOY_SAUCE,
                GastroStacks.GREEN_ONION)
            .container(BOWL)
            .tools(GastroStacks.FRYING_PAN, GastroStacks.PEELER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.STIR_FRY_NOODLES)
            .ingredients(GastroStacks.DOUGH, CHICKEN, GastroStacks.BROCCOLI, CARROT, GastroStacks.BUTTON_MUSHROOM,
                GastroStacks.GREEN_ONION)
            .container(BOWL)
            .tools(GastroStacks.FRYING_PAN, GastroStacks.PEELER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.SHRIMP_DUMPLINGS)
            .ingredients(GastroStacks.COOKED_RICE, GastroStacks.SHRIMP, GastroStacks.GREEN_ONION)
            .tools(GastroStacks.ROLLING_PIN)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CHICKEN_POTSTICKERS)
            .ingredients(CHICKEN, GastroStacks.DOUGH, GastroStacks.SOY_SAUCE, GastroStacks.GREEN_ONION)
            .tools(GastroStacks.ROLLING_PIN)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.BEEF_POTSTICKERS)
            .ingredients(BEEF, GastroStacks.DOUGH, GastroStacks.SOY_SAUCE, GastroStacks.GREEN_ONION)
            .tools(GastroStacks.ROLLING_PIN)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.PIEROGIES)
            .ingredients(POTATO, GastroStacks.DOUGH, SlimefunItems.BUTTER)
            .tools(GastroStacks.ROLLING_PIN, GastroStacks.PEELER)
            .register(gn);

        if (egAvailable)
            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.BACON_PIEROGIES)
                .ingredients(BACON, POTATO, GastroStacks.DOUGH, SlimefunItems.BUTTER)
                .tools(GastroStacks.ROLLING_PIN, GastroStacks.PEELER)
                .register(gn);

        // TODO add output amount
        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.TEMPURA_SHRIMP_ROLL)
            .shape(RecipeShape.SHAPED)
            .ingredients(
                GastroStacks.TEMPURA_SHRIMP, GastroStacks.TEMPURA_SHRIMP, GastroStacks.TEMPURA_SHRIMP,
                GastroStacks.COOKED_RICE, GastroStacks.COOKED_RICE, GastroStacks.COOKED_RICE,
                DRIED_KELP, DRIED_KELP, DRIED_KELP)
            .tools(GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.DYNAMITE_ROLL)
            .shape(RecipeShape.SHAPED)
            .ingredients(
                GastroStacks.TEMPURA_SHRIMP, GastroStacks.AVOCADO, GastroStacks.CUCUMBER,
                GastroStacks.COOKED_RICE, GastroStacks.COOKED_RICE, GastroStacks.COOKED_RICE,
                DRIED_KELP, DRIED_KELP, DRIED_KELP)
            .tools(GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.KAPPA_ROLL)
            .shape(RecipeShape.SHAPED)
            .ingredients(
                GastroStacks.CUCUMBER, GastroStacks.AVOCADO, GastroStacks.CUCUMBER,
                GastroStacks.COOKED_RICE, GastroStacks.COOKED_RICE, GastroStacks.COOKED_RICE,
                DRIED_KELP, DRIED_KELP, DRIED_KELP)
            .tools(GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.CALIFORNIA_ROLL)
            .shape(RecipeShape.SHAPED)
            .ingredients(
                GastroStacks.CRAB, GastroStacks.AVOCADO, GastroStacks.CUCUMBER,
                GastroStacks.COOKED_RICE, GastroStacks.COOKED_RICE, GastroStacks.COOKED_RICE,
                DRIED_KELP, DRIED_KELP, DRIED_KELP)
            .tools(GastroStacks.KITCHEN_KNIFE)
            .register(gn);

        if (egAvailable) {
            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.LASAGNA)
                .ingredients(GastroStacks.DOUGH, GastroStacks.GROUND_BEEF, ONION, GARLIC, SUGAR, GastroStacks.BASIL,
                    TOMATO, SlimefunItems.CHEESE)
                .tools(GastroStacks.ROLLING_PIN, GastroStacks.BAKING_TRAY)
                .register(gn);
        }

        // TODO: output amount (3)
        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CHOCOLATE_CHIP_MUFFIN)
            .ingredients(GastroStacks.DOUGH, MILK_BUCKET, SlimefunItems.BUTTER, EGG, SUGAR, COCOA_BEANS)
            .tools(GastroStacks.BAKING_TRAY, GastroStacks.WHISK)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.DOUBLE_CHOCOLATE_MUFFIN)
            .ingredients(GastroStacks.DOUGH, MILK_BUCKET, SlimefunItems.BUTTER, EGG, SUGAR, COCOA_BEANS, COCOA_BEANS)
            .tools(GastroStacks.BAKING_TRAY, GastroStacks.WHISK)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CARROT_MUFFIN)
            .ingredients(GastroStacks.DOUGH, MILK_BUCKET, SlimefunItems.BUTTER, EGG, SUGAR, CARROT)
            .tools(GastroStacks.BAKING_TRAY, GastroStacks.WHISK)
            .register(gn);

        if (egAvailable) {
            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.BLUEBERRY_MUFFIN)
                .ingredients(GastroStacks.DOUGH, MILK_BUCKET, SlimefunItems.BUTTER, EGG, SUGAR, BLUEBERRY)
                .tools(GastroStacks.BAKING_TRAY, GastroStacks.WHISK)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.CRANBERRY_MUFFIN)
                .ingredients(GastroStacks.DOUGH, MILK_BUCKET, SlimefunItems.BUTTER, EGG, SUGAR, CRANBERRY)
                .tools(GastroStacks.BAKING_TRAY, GastroStacks.WHISK)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.MULTI_STOVE)
                .item(GastroStacks.RAISIN_MUFFIN)
                .ingredients(GastroStacks.DOUGH, MILK_BUCKET, SlimefunItems.BUTTER, EGG, SUGAR, GRAPE)
                .tools(GastroStacks.BAKING_TRAY, GastroStacks.WHISK)
                .register(gn);
        }

        new GastroFoodBuilder()
            .type(GastroRecipeType.REFRIDGERATOR)
            .item(GastroStacks.VANILLA_ICE_CREAM)
            .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, GastroStacks.VANILLA_BEANS)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.REFRIDGERATOR)
            .item(GastroStacks.CHOCOLATE_ICE_CREAM)
            .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, COCOA_BEANS)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.REFRIDGERATOR)
            .item(GastroStacks.MINT_CHOCOLATE_ICE_CREAM)
            .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, GastroStacks.MINT, COCOA_BEANS)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.REFRIDGERATOR)
            .item(GastroStacks.COOKIE_DOUGH_ICE_CREAM)
            .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, GastroStacks.MINT, GastroStacks.DOUGH)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.REFRIDGERATOR)
            .item(GastroStacks.PEANUT_BUTTER_ICE_CREAM)
            .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, GastroStacks.MINT, GastroStacks.PEANUT_BUTTER)
            .register(gn);

        if (egAvailable) {
            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.GREEN_TEA_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, TEA_LEAF)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.STRAWBERRY_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, STRAWBERRY)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.BLUEBERRY_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, BLUEBERRY)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.CRANBERRY_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, CRANBERRY)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.COWBERRY_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, COWBERRY)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.COCONUT_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, COCONUT)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.CHERRY_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, CHERRY)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.RASPBERRY_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, RASPBERRY)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.CARAMEL_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, GastroStacks.CARAMEL)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.ORANGE_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, ORANGE)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.PEACH_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, PEACH)
                .register(gn);

            new GastroFoodBuilder()
                .type(GastroRecipeType.REFRIDGERATOR)
                .item(GastroStacks.PINEAPPLE_ICE_CREAM)
                .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, PINEAPPLE)
                .register(gn);
        }

        new GastroFoodBuilder()
            .type(GastroRecipeType.REFRIDGERATOR)
            .item(GastroStacks.CHORUS_ICE_CREAM)
            .ingredients(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, SUGAR, CHORUS_FRUIT)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.SHAVED_ICE)
            .ingredients(ICE)
            .container(GastroStacks.STEEL_BOWL)
            .tools(GastroStacks.BLENDER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.STRAWBERRY_SHAVED_ICE)
            .ingredients(ICE, STRAWBERRY)
            .container(GastroStacks.STEEL_BOWL)
            .tools(GastroStacks.BLENDER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.BANANA_SHAVED_ICE)
            .ingredients(ICE, BANANA)
            .container(GastroStacks.STEEL_BOWL)
            .tools(GastroStacks.BLENDER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.LEMON_SHAVED_ICE)
            .ingredients(ICE, LEMON)
            .container(GastroStacks.STEEL_BOWL)
            .tools(GastroStacks.BLENDER)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.CANDY_APPLE)
            .shape(RecipeShape.SHAPED)
            .ingredients(
                null, HONEY_BOTTLE, null,
                null, APPLE, null,
                null, STICK, null)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.DONUT)
            .ingredients(GastroStacks.DOUGH, YEAST, MILK_BUCKET, SlimefunItems.BUTTER, SUGAR)
            .tools(GastroStacks.BAKING_TRAY)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.HONEY_DIP_DONUT)
            .ingredients(GastroStacks.DOUGH, YEAST, MILK_BUCKET, SlimefunItems.BUTTER, SUGAR, HONEY_BOTTLE)
            .tools(GastroStacks.BAKING_TRAY)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.GOLDEN_CHOCOLATE_DONUT)
            .ingredients(GastroStacks.DOUGH, YEAST, MILK_BUCKET, SlimefunItems.BUTTER, SUGAR, HONEY_BOTTLE, COCOA_BEANS)
            .tools(GastroStacks.BAKING_TRAY)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.STRAWBERRY_CHEESECAKE)
            .ingredients(GastroStacks.DOUGH, YEAST, MILK_BUCKET, SlimefunItems.BUTTER, SUGAR, SlimefunItems.CHEESE,
                STRAWBERRY)
            .tools(GastroStacks.BAKING_TRAY)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.STRAWBERRY_CUPCAKE)
            .ingredients(GastroStacks.DOUGH, YEAST, MILK_BUCKET, SlimefunItems.BUTTER, SUGAR, STRAWBERRY)
            .tools(GastroStacks.BAKING_TRAY)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.LEMON_TART)
            .ingredients(LEMON, SUGAR, EGG)
            .tools(GastroStacks.BAKING_TRAY)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.MULTI_STOVE)
            .item(GastroStacks.CHORUS_PIE)
            .ingredients(CHORUS_FRUIT, SUGAR, EGG)
            .tools(GastroStacks.BAKING_TRAY)
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.ENCHANTED_GOLDEN_CARROT)
            .shape(RecipeShape.SHAPED)
            .ingredients(RecipeUtil.cyclic(SlimefunItems.GOLD_24K_BLOCK, CARROT))
            .register(gn);

        new GastroFoodBuilder()
            .type(GastroRecipeType.CULINARY_WORKBENCH)
            .item(GastroStacks.ENCHANTED_GLISTERING_MELON_SLICE)
            .shape(RecipeShape.SHAPED)
            .ingredients(RecipeUtil.cyclic(SlimefunItems.GOLD_24K_BLOCK, MELON_SLICE))
            .register(gn);
    }
}
