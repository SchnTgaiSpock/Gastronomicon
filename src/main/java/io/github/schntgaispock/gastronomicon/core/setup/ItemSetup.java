package io.github.schntgaispock.gastronomicon.core.setup;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.items.UnplaceableItem;
import io.github.schntgaispock.gastronomicon.core.items.food.GastroFood;
import io.github.schntgaispock.gastronomicon.core.items.food.SimpleGastroFood;
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
import io.github.schntgaispock.gastronomicon.core.recipes.MultiStoveRecipe;
import io.github.schntgaispock.gastronomicon.core.recipes.RecipeRegistry;
import io.github.schntgaispock.gastronomicon.core.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.util.recipe.RecipeUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemSetup {

    public static ItemStack getItem(String id) {
        final SlimefunItem item = SlimefunItem.getById(id);
        if (item == null) return null;
        return item.getItem();
    }

    public static void setup() {

        final Gastronomicon gn = Gastronomicon.getInstance();
        final boolean egAvailable = Gastronomicon.isPluginEnabled("ExoticGarden");

        GastroGroups.MAIN.register(gn);

        final ItemStack ORANGE = getItem("ORANGE");
        final ItemStack LETTUCE = getItem("LETTUCE");
        final ItemStack TOMATO = getItem("TOMATO");
        final ItemStack ONION = getItem("ONION");
        final ItemStack BACON = getItem("BACON");
        final ItemStack MAYO = getItem("MAYO");
        final ItemStack CORN = getItem("CORN");
        final ItemStack BBQ_SAUCE = getItem("BBQ_SAUCE");
        final ItemStack CURRY_LEAF = getItem("CURRY_LEAF");
        final ItemStack KETCHUP = getItem("KETCHUP");
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
        final ItemStack STRING = new ItemStack(Material.STRING);
        final ItemStack COBWEB = new ItemStack(Material.COBWEB);
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


        // ---- Tools ----

        // -- Workstation Tools --

        // Culinary Workbench
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.CUTTING_BOARD,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.row(OAK_SLAB, 2)
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.ROLLING_PIN,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.row(STICK, 1)
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.MEAT_SCISSORS,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT, SHEARS, SlimefunItems.STEEL_INGOT, null}
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.KITCHEN_KNIFE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, null, null, null, SlimefunItems.STEEL_INGOT, null, null, STICK, null}
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.BLENDER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, SlimefunItems.ELECTRIC_MOTOR, null, null, IRON_BARS, null, null, BUCKET, null}
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.MORTAR_AND_PESTLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, null, null, null, SlimefunItems.STEEL_INGOT, null, null, BOWL, null}
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.PEELER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, IRON_NUGGET, null, null, IRON_NUGGET, null, null, STICK, null}
        ).register(gn);
        // Enhanced Oven
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.BAKING_TRAY,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_INGOT, null, null, null, null, null}
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.FRYING_PAN,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE, null, null, null, null, null, null}
        ).register(gn);
        new UnplaceableItem(
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
            RecipeUtil.row(SlimefunItems.STEEL_INGOT, 1)
        ).register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_SPRING,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.cyclicAlternating(null, GastroStacks.STEEL_WIRE)
        ).register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.CRAB_TRAP,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {STICK, STICK, STICK, STICK, null, STICK, OAK_SLAB, OAK_SLAB, OAK_SLAB}
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
            RecipeUtil.cyclicAlternating(STRING, COBWEB, COBWEB)
        ).register(gn);

        // -- Other --

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.WOODEN_SICKLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, OAK_PLANKS, OAK_PLANKS,
                null, STICK, null,
                STICK, null, null
            }
        ).register(gn);

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_SICKLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE,
                null, STICK, null,
                STICK, null, null
            }
        ).register(gn);

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.REINFORCED_SICKLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_PLATE,
                null, STICK, null,
                STICK, null, null
            }
        ).register(gn);
        
        // ---- Basic Machines ----

        new CulinaryWorkbench(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.CULINARY_WORKBENCH,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                POLISHED_GRANITE, POLISHED_GRANITE, POLISHED_GRANITE, 
                BARREL, CRAFTING_TABLE, BARREL, 
                IRON_BLOCK, DISPENSER, IRON_BLOCK
            }
        ).register(gn);

        new MultiStove(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.MULTI_STOVE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                IRON_PP, IRON_PP, IRON_PP,
                SlimefunItems.HEATING_COIL, BLAST_FURNACE, SlimefunItems.HEATING_COIL,
                SlimefunItems.HEATING_COIL, SlimefunItems.ENERGY_CONNECTOR, SlimefunItems.HEATING_COIL
            }
        ).register(gn);
        
        new Refridgerator(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.REFRIDGERATOR,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                SlimefunItems.STEEL_INGOT, SlimefunItems.COOLING_UNIT, SlimefunItems.STEEL_INGOT,
                SlimefunItems.STEEL_INGOT, IRON_TRAPDOOR, SlimefunItems.STEEL_INGOT,
                SlimefunItems.STEEL_INGOT, SlimefunItems.COOLING_UNIT, SlimefunItems.STEEL_INGOT
            }
        ).register(gn);
        
        new GrainMill(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.MILL,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, HOPPER, null,
                IRON_BARS, SlimefunItems.DAMASCUS_STEEL_INGOT, IRON_BARS,
                null, ANDESITE_SLAB, null
            }
        ).register(gn);
        
        new Distillery(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.DISTILLERY,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                OAK_FENCE, OAK_SLAB, OAK_FENCE,
                OAK_FENCE, BARREL, OAK_FENCE,
                OAK_FENCE, BARREL, OAK_FENCE
            }
        ).register(gn);

        // ---- Raw Ingredients ----

        new SimpleSeed(
            GastroStacks.RICE,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.QUINOA,
            Material.WHEAT,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.OATS,
            Material.WHEAT,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.SOYBEANS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BARLEY,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.BARLEY_SEEDS)
        ).register(gn);

        new CropSeed(
            GastroStacks.BARLEY_SEEDS,
            Material.WHEAT,
            GastroStacks.BARLEY
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RYE,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.RYE_SEEDS)
        ).register(gn);

        new CropSeed(
            GastroStacks.RYE_SEEDS,
            Material.WHEAT,
            GastroStacks.RYE
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SORGHUM,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.SORGHUM_SEEDS)
        ).register(gn);

        new CropSeed(
            GastroStacks.SORGHUM_SEEDS,
            Material.WHEAT,
            GastroStacks.SORGHUM
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.TURNIP,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.TURNIP_SEEDS)
        ).register(gn);

        new CropSeed(
            GastroStacks.TURNIP_SEEDS,
            Material.BEETROOTS,
            GastroStacks.TURNIP
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SQUASH,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.SQUASH_SEEDS)
        ).register(gn);

        new FruitingSeed(
            GastroStacks.SQUASH_SEEDS,
            Material.MELON_STEM,
            GastroStacks.SQUASH,
            "GN_SQUASH"
        ).register(gn);

        new DuplicatingSeed(
            GastroStacks.CELERY,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.BOK_CHOY,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.SNOW_PEAS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.BROCCOLI,
            Material.CARROTS,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.WASABI_PLANT,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new DuplicatingSeed(
            GastroStacks.LEMONGRASS,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.CUCUMBER,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.BASIL,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.SPINACH,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.BRUSSLES_SPROUTS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.MINT,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.CHILI_PEPPER,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.PARSLEY,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.CASSAVA,
            Material.BEETROOTS,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.LENTILS,
            Material.CARROTS,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.PEANUTS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.BEANS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.PEAS,
            Material.BEETROOTS,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.ASPARAGUS,
            Material.CARROTS,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.CAULIFLOWER,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        // -- Grown from trees

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.LYCHEE,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.LYCHEE_SAPLING)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.LYCHEE_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.PERSIMMON,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.PERSIMMON_SAPLING)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.PERSIMMON_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BANANA,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.BANANA_SAPLING)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BANANA_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.VANILLA_BEANS,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.VANILLA_SAPLING)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.VANILLA_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        // -- Harvested --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.FIDDLEHEADS,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.FERN)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.TRUFFLES,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.ENOKI_MUSHROOMS,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.KING_OYSTER_MUSHROOM,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BUTTON_MUSHROOM,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.CLAM,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.SEAGRASS)
        ).register(gn);

        // -- Mob Drops --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_CHEVON,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_GOAT)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_CHEVON,
            RecipeUtil.singleCenter(GastroStacks.RAW_CHEVON),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.FROG_LEG,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_FROG)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.GIANT_SPIDER_LEG,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_SPIDER)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SALMON_ROE,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_SALMON)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.GUARDIAN_FIN,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_GUARDIAN)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_SQUID,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_SQUID)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_SQUID,
            RecipeUtil.singleCenter(GastroStacks.RAW_SQUID),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        // -- From Fishing --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_MACKEREL,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_MACKEREL,
            RecipeUtil.singleCenter(GastroStacks.RAW_MACKEREL),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_EEL,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_EEL,
            RecipeUtil.singleCenter(GastroStacks.RAW_EEL),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_TROUT,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_TROUT,
            RecipeUtil.singleCenter(GastroStacks.RAW_TROUT),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_BASS,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_BASS,
            RecipeUtil.singleCenter(GastroStacks.RAW_BASS),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_CARP,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_CARP,
            RecipeUtil.singleCenter(GastroStacks.RAW_CARP),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_PIKE,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_PIKE,
            RecipeUtil.singleCenter(GastroStacks.RAW_PIKE),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_TUNA,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_TUNA,
            RecipeUtil.singleCenter(GastroStacks.RAW_PIKE),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SHRIMP,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        // -- From traps --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.CRAB,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.CRAB_TRAP)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_TURKEY,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.HUNTING_TRAP)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_TURKEY,
            RecipeUtil.singleCenter(GastroStacks.RAW_TURKEY),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        // ---- Food ----

        // -- Ingredients --

        SimpleGastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.COOKED_RICE,
            RecipeUtil.single(GastroStacks.RICE),
            null,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT
        ).register(gn);

        SimpleGastroFood.mill(
            GastroGroups.FOOD,
            GastroStacks.BARLEY_FLOUR,
            RecipeUtil.single(GastroStacks.BARLEY)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.TOAST,
            RecipeUtil.single(BREAD),
            null,
            Temperature.LOW
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.DOUGH,
            RecipeUtil.collection(SlimefunItems.WHEAT_FLOUR, GastroStacks.WATER_BOTTLE),
            null,
            Temperature.LOW
        ).register(gn);
        RecipeRegistry.registerRecipe(new MultiStoveRecipe(
            RecipeUtil.collection(GastroStacks.BARLEY_FLOUR, GastroStacks.WATER_BOTTLE),
            new HashSet<>(), // I don't know how to get shapeless recipes to work with groups, so this is the best I can do
            GastroStacks.DOUGH
        ));

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.PEANUT_BUTTER,
            RecipeUtil.single(GastroStacks.PEANUTS),
            null,
            Temperature.LOW
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.FRIED_EGG,
            RecipeUtil.single(EGG),
            null,
            Temperature.LOW,
            GastroStacks.FRYING_PAN
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.HARD_BOILED_EGG,
            RecipeUtil.collection(EGG, WATER_BUCKET),
            null,
            Temperature.LOW,
            GastroStacks.STEEL_POT
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.SCRAMBLED_EGGS,
            RecipeUtil.single(EGG),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CUSTARD,
            RecipeUtil.collection(EGG, MILK_BUCKET, SUGAR),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        if (egAvailable)
            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.MARMALADE,
                RecipeUtil.collection(ORANGE),
                GastroStacks.WATER_BOTTLE,
                Temperature.LOW
            ).register(gn);

        SimpleGastroFood.workbench(
            GastroGroups.FOOD,
            GastroStacks.PULLED_PORK,
            RecipeShape.SHAPELESS,
            RecipeUtil.collection(COOKED_PORKCHOP),
            null
        ).register(gn);

        SimpleGastroFood.workbench(
            GastroGroups.FOOD,
            GastroStacks.GROUND_BEEF,
            RecipeShape.SHAPELESS,
            RecipeUtil.collection(COOKED_BEEF),
            null
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.BAKED_BEANS,
            RecipeUtil.collection(GastroStacks.BEANS),
            null,
            Temperature.LOW,
            GastroStacks.BAKING_TRAY
        ).register(gn);

        SimpleGastroFood.distillery(
            GastroGroups.FOOD,
            GastroStacks.SOY_SAUCE,
            RecipeUtil.collection(GastroStacks.SOYBEANS)
        ).register(gn);

        // -- Cuisine --

        GastroFood.workbench(
            GastroGroups.FOOD,
            GastroStacks.PBJ_SANDWICH,
            RecipeShape.SHAPED,
            RecipeUtil.collection(
                null, GastroStacks.TOAST, null,
                GastroStacks.PEANUT_BUTTER, APPLE, GastroStacks.PEANUT_BUTTER,
                null, GastroStacks.TOAST, null
                ),
            null
        ).register(gn);

        if (egAvailable)
            GastroFood.workbench(
                GastroGroups.FOOD,
                GastroStacks.MARMALADE_SANDWICH,
                RecipeShape.SHAPED,
                RecipeUtil.collection(
                    null, GastroStacks.TOAST, null,
                    GastroStacks.MARMALADE, GastroStacks.MARMALADE, GastroStacks.MARMALADE,
                    null, GastroStacks.TOAST, null
                    ),
                null
            ).register(gn);

        GastroFood.workbench(
            GastroGroups.FOOD,
            GastroStacks.BAKED_BEANS_AND_TOAST,
            RecipeShape.SHAPED,
            RecipeUtil.collection(
                null, null, null,
                GastroStacks.BAKED_BEANS, GastroStacks.BAKED_BEANS, GastroStacks.BAKED_BEANS,
                null, GastroStacks.TOAST, null
                ),
            null
        ).register(gn);

        if (egAvailable)
            GastroFood.workbench(
                GastroGroups.FOOD,
                GastroStacks.TUNA_SANDWICH,
                RecipeShape.SHAPED,
                RecipeUtil.collection(
                    null, GastroStacks.TOAST, null,
                    GastroStacks.COOKED_TUNA, LETTUCE, MAYO,
                    null, GastroStacks.TOAST, null
                    ),
                null
            ).register(gn);

        GastroFood.workbench(
            GastroGroups.FOOD,
            GastroStacks.BREAKFAST_SANDWICH,
            RecipeShape.SHAPED,
            RecipeUtil.collection(
                null, GastroStacks.TOAST, null,
                GastroStacks.FRIED_EGG, COOKED_PORKCHOP, GastroStacks.FRIED_EGG,
                null, GastroStacks.TOAST, null
                ),
            null
        ).register(gn);

        if (egAvailable)
            GastroFood.workbench(
                GastroGroups.FOOD,
                GastroStacks.HAM_SANDWICH,
                RecipeShape.SHAPED,
                RecipeUtil.collection(
                    null, GastroStacks.TOAST, null,
                    LETTUCE, COOKED_PORKCHOP, MAYO,
                    null, GastroStacks.TOAST, null
                    ),
                null
            ).register(gn);

        GastroFood.workbench(
            GastroGroups.FOOD,
            GastroStacks.CHICKEN_SANDWICH,
            RecipeShape.SHAPED,
            RecipeUtil.collection(
                null, GastroStacks.TOAST, null,
                GastroStacks.FRIED_EGG, COOKED_CHICKEN, GastroStacks.FRIED_EGG,
                null, GastroStacks.TOAST, null
                ),
            null
        ).register(gn);

        if (egAvailable)
            GastroFood.workbench(
                GastroGroups.FOOD,
                GastroStacks.EGG_SALAD_SANDWICH,
                RecipeShape.SHAPED,
                RecipeUtil.collection(
                    null, GastroStacks.TOAST, null,
                    LETTUCE, GastroStacks.SCRAMBLED_EGGS, MAYO,
                    null, GastroStacks.TOAST, null
                    ),
                null
            ).register(gn);

        GastroFood.workbench(
            GastroGroups.FOOD,
            GastroStacks.ROAST_BEEF_SANDWICH,
            RecipeShape.SHAPED,
            RecipeUtil.collection(
                null, GastroStacks.TOAST, null,
                GastroStacks.FRIED_EGG, COOKED_BEEF, GastroStacks.FRIED_EGG,
                null, GastroStacks.TOAST, null
                ),
            null
        ).register(gn);

        if (egAvailable) {
            GastroFood.workbench(
                GastroGroups.FOOD,
                GastroStacks.CLUB_SANDWICH,
                RecipeShape.SHAPED,
                RecipeUtil.collection(
                    null, GastroStacks.TOAST, null,
                    LETTUCE, COOKED_PORKCHOP, TOMATO,
                    null, GastroStacks.TOAST, null
                    ),
                null
            ).register(gn);
            
            GastroFood.workbench(
                GastroGroups.FOOD,
                GastroStacks.GREEK_SALAD,
                RecipeShape.SHAPELESS,
                RecipeUtil.collection(TOMATO, GastroStacks.CUCUMBER, ONION, SlimefunItems.CHEESE),
                BOWL, 
                GastroStacks.KITCHEN_KNIFE
            ).register(gn);

            GastroFood.workbench(
                GastroGroups.FOOD,
                GastroStacks.CAESAR_SALAD,
                RecipeShape.SHAPELESS,
                RecipeUtil.collection(LETTUCE, GastroStacks.TOAST, BACON, SlimefunItems.CHEESE),
                BOWL,
                GastroStacks.KITCHEN_KNIFE
            ).register(gn);
        }

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.PAN_SEARED_SALMON,
            RecipeUtil.single(SALMON),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.FRIED_SHRIMP,
            RecipeUtil.single(GastroStacks.SHRIMP),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.TEMPURA_SHRIMP,
            RecipeUtil.collection(GastroStacks.SHRIMP, BREAD),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.TEMPURA_BROCCOLI,
            RecipeUtil.collection(GastroStacks.BROCCOLI, BREAD),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CHICKEN_PESTO_PASTA,
            RecipeUtil.collection(GastroStacks.DOUGH, GastroStacks.BASIL, CHICKEN, SlimefunItems.CHEESE, WATER_BUCKET),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.ROLLING_PIN, GastroStacks.MORTAR_AND_PESTLE
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.SQUID_INK_PASTA,
            RecipeUtil.collection(GastroStacks.DOUGH, GastroStacks.BASIL, INK_SAC, SlimefunItems.CHEESE, WATER_BUCKET),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN, GastroStacks.ROLLING_PIN
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.GLOWING_SQUID_INK_PASTA,
            RecipeUtil.collection(GastroStacks.DOUGH, GastroStacks.BASIL, GLOW_INK_SAC, SlimefunItems.CHEESE, WATER_BUCKET),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN, GastroStacks.ROLLING_PIN
        ).register(gn);

        if (egAvailable) {
            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.CHICKEN_RAVIOLI,
                RecipeUtil.collection(GastroStacks.DOUGH, GastroStacks.BASIL, CHICKEN, SlimefunItems.CHEESE, TOMATO, WATER_BUCKET),
                BOWL,
                Temperature.MEDIUM,
                GastroStacks.FRYING_PAN, GastroStacks.ROLLING_PIN
            ).register(gn);

            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.MUSHROOM_RAVIOLI,
                RecipeUtil.collection(GastroStacks.DOUGH, GastroStacks.BASIL, GastroStacks.BUTTON_MUSHROOM, SlimefunItems.CHEESE, TOMATO, WATER_BUCKET),
                BOWL,
                Temperature.MEDIUM,
                GastroStacks.STEEL_POT, GastroStacks.ROLLING_PIN
            ).register(gn);
        }

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.OATMEAL,
            RecipeUtil.collection(WATER_BUCKET, GastroStacks.OATS),
            BOWL,
            Temperature.LOW,
            GastroStacks.STEEL_POT
        ).register(gn);
        RecipeRegistry.registerRecipe(new MultiStoveRecipe(
            RecipeUtil.collection(MILK_BUCKET, GastroStacks.OATS),
            BOWL,
            Set.of(GastroStacks.STEEL_POT),
            Temperature.LOW,
            GastroStacks.OATMEAL
        ));

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.BARLEY_PORRIDGE,
            RecipeUtil.collection(WATER_BUCKET, GastroStacks.BARLEY),
            BOWL,
            Temperature.LOW,
            GastroStacks.STEEL_POT
        ).register(gn);
        RecipeRegistry.registerRecipe(new MultiStoveRecipe(
            RecipeUtil.collection(MILK_BUCKET, GastroStacks.BARLEY),
            BOWL,
            Set.of(GastroStacks.STEEL_POT),
            Temperature.LOW,
            GastroStacks.BARLEY_PORRIDGE
        ));

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CONGEE,
            RecipeUtil.collection(WATER_BUCKET, GastroStacks.RICE),
            BOWL,
            Temperature.LOW,
            GastroStacks.STEEL_POT
        ).register(gn);
        RecipeRegistry.registerRecipe(new MultiStoveRecipe(
            RecipeUtil.collection(MILK_BUCKET, GastroStacks.RICE),
            BOWL,
            Set.of(GastroStacks.STEEL_POT),
            Temperature.LOW,
            GastroStacks.CONGEE
        ));

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CHICKEN_SOUP,
            RecipeUtil.collection(WATER_BUCKET, CHICKEN, CARROT, GastroStacks.PEAS),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CHICKEN_NOODLE_SOUP,
            RecipeUtil.collection(WATER_BUCKET, CHICKEN, CARROT, GastroStacks.PEAS, GastroStacks.DOUGH),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
        ).register(gn);

        if (egAvailable) {
            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.SPLIT_PEA_SOUP,
                RecipeUtil.collection(WATER_BUCKET, CARROT, GastroStacks.PEAS, ONION),
                BOWL,
                Temperature.MEDIUM,
                GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
            ).register(gn);
    
            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.HAM_AND_SPLIT_PEA_SOUP,
                RecipeUtil.collection(WATER_BUCKET, CARROT, GastroStacks.PEAS, ONION, PORKCHOP),
                BOWL,
                Temperature.MEDIUM,
                GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
            ).register(gn);
        }

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.LENTIL_SOUP,
            RecipeUtil.collection(WATER_BUCKET, CARROT, GastroStacks.LENTILS, GastroStacks.CELERY, GastroStacks.BASIL),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.BEEF_AND_LENTIL_SOUP,
            RecipeUtil.collection(WATER_BUCKET, CARROT, GastroStacks.LENTILS, GastroStacks.CELERY, GastroStacks.BASIL, BEEF),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CARROT_SOUP,
            RecipeUtil.collection(WATER_BUCKET, CARROT, POTATO, GastroStacks.PEAS, GastroStacks.CELERY),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.MUSHROOM_BARLEY_SOUP,
            RecipeUtil.collection(WATER_BUCKET, GastroStacks.BARLEY, GastroStacks.BUTTON_MUSHROOM, GastroStacks.PEAS, GastroStacks.CELERY),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CHICKEN_BARLEY_SOUP,
            RecipeUtil.collection(WATER_BUCKET, GastroStacks.BARLEY, CHICKEN, GastroStacks.PEAS, CARROT),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.BEEF_BARLEY_SOUP,
            RecipeUtil.collection(WATER_BUCKET, GastroStacks.BARLEY, COOKED_BEEF, GastroStacks.BROCCOLI, GastroStacks.CELERY),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CREAM_OF_MUSHROOM_SOUP,
            RecipeUtil.collection(MILK_BUCKET, SlimefunItems.BUTTER, GastroStacks.BUTTON_MUSHROOM, GastroStacks.CELERY),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CREAM_OF_BROCCOLI_SOUP,
            RecipeUtil.collection(MILK_BUCKET, SlimefunItems.BUTTER, GastroStacks.BROCCOLI, GastroStacks.CELERY),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CREAM_OF_ASPARAGUS_SOUP,
            RecipeUtil.collection(MILK_BUCKET, SlimefunItems.BUTTER, GastroStacks.ASPARAGUS, GastroStacks.CELERY),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CREAM_OF_CAULIFLOWER_SOUP,
            RecipeUtil.collection(MILK_BUCKET, SlimefunItems.BUTTER, GastroStacks.CAULIFLOWER, GastroStacks.CELERY),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.MISO_SOUP, // TODO: Miso stuff
            RecipeUtil.collection(WATER_BUCKET, DRIED_KELP),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.BROCCOLI_CHOWDER,
            RecipeUtil.collection(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, GastroStacks.SHRIMP, GastroStacks.BASIL, GastroStacks.BROCCOLI),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.SALMON_CHOWDER,
            RecipeUtil.collection(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, GastroStacks.SHRIMP, GastroStacks.BASIL, SALMON),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.POTATO_CHOWDER,
            RecipeUtil.collection(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, GastroStacks.SHRIMP, GastroStacks.BASIL, POTATO),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
        ).register(gn);

        if (egAvailable)
            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.CORN_CHOWDER,
                RecipeUtil.collection(MILK_BUCKET, SlimefunItems.HEAVY_CREAM, GastroStacks.SHRIMP, GastroStacks.BASIL, CORN),
                BOWL,
                Temperature.MEDIUM,
                GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE
            ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.BEEF_STEW,
            RecipeUtil.collection(WATER_BUCKET, POTATO, CARROT, BEEF, GastroStacks.CELERY),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CLAM_STEW,
            RecipeUtil.collection(WATER_BUCKET, POTATO, CARROT, GastroStacks.CLAM, GastroStacks.CELERY),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CRAB_HOTPOT,
            RecipeUtil.collection(WATER_BUCKET, GastroStacks.ENOKI_MUSHROOMS, GastroStacks.KING_OYSTER_MUSHROOM, CARROT, GastroStacks.CRAB, EGG),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
        ).register(gn);

        if (egAvailable) {
            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.BBQ_STEAK,
                RecipeUtil.collection(BBQ_SAUCE, BEEF),
                null,
                Temperature.HIGH
            ).register(gn);

            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.BBQ_PORK,
                RecipeUtil.collection(BBQ_SAUCE, PORKCHOP),
                null,
                Temperature.HIGH
            ).register(gn);

            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.BBQ_CHICKEN,
                RecipeUtil.collection(BBQ_SAUCE, CHICKEN),
                null,
                Temperature.HIGH
            ).register(gn);

            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.BBQ_MUTTON,
                RecipeUtil.collection(BBQ_SAUCE, MUTTON),
                null,
                Temperature.HIGH
            ).register(gn);
        }

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.BUTTER_CHICKEN, // TODO: Butter chicken stuff
            RecipeUtil.collection(CHICKEN, CARROT),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.STEEL_POT, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
        ).register(gn);

        if (egAvailable) {
            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.SHRIMP_FRIED_RICE,
                RecipeUtil.collection(GastroStacks.SHRIMP, GastroStacks.COOKED_RICE, CARROT, GastroStacks.PEAS, CORN),
                BOWL,
                Temperature.MEDIUM,
                GastroStacks.FRYING_PAN, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
            ).register(gn);

            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.CURRY_RICE,
                RecipeUtil.collection(POTATO, GastroStacks.COOKED_RICE, CARROT, CURRY_LEAF, COOKED_BEEF),
                BOWL,
                Temperature.MEDIUM,
                GastroStacks.FRYING_PAN, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
            ).register(gn);

            GastroFood.stove(
                GastroGroups.FOOD,
                GastroStacks.RICE_OMELETTE,
                RecipeUtil.collection(GastroStacks.COOKED_RICE, EGG, KETCHUP),
                BOWL,
                Temperature.MEDIUM,
                GastroStacks.FRYING_PAN, GastroStacks.KITCHEN_KNIFE, GastroStacks.PEELER
            ).register(gn);
        }

        GastroFood.workbench(
            GastroGroups.FOOD,
            GastroStacks.RICE_BALLS,
            RecipeShape.SHAPELESS,
            RecipeUtil.collection(GastroStacks.COOKED_RICE, DRIED_KELP),
            null
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.BEEF_UDON,
            RecipeUtil.collection(GastroStacks.DOUGH, BEEF, GastroStacks.SOY_SAUCE),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.CHICKEN_UDON,
            RecipeUtil.collection(GastroStacks.DOUGH, CHICKEN, GastroStacks.SOY_SAUCE),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.VEGETABLE_UDON,
            RecipeUtil.collection(GastroStacks.DOUGH, GastroStacks.BROCCOLI, CARROT, GastroStacks.SOY_SAUCE),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN, GastroStacks.PEELER
        ).register(gn);

        GastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.STIR_FRY_NOODLES,
            RecipeUtil.collection(GastroStacks.DOUGH, CHICKEN, GastroStacks.BROCCOLI, CARROT, GastroStacks.BUTTON_MUSHROOM),
            BOWL,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN, GastroStacks.PEELER
        ).register(gn);
    }
}
