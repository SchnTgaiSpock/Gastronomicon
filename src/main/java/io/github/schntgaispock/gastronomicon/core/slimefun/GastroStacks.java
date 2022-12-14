package io.github.schntgaispock.gastronomicon.core.slimefun;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.stacks.FoodItemStack;
import io.github.schntgaispock.gastronomicon.util.stacks.ThemedItemStack;
import io.github.schntgaispock.gastronomicon.core.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.util.GastroTheme.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroStacks {

    // ---- Guide Only Items ----

    public static final ItemStack GUIDE_ITEM_TOOLS = new CustomItemStack(
        Material.IRON_HOE,
        Theme.TOOL.getColor() + "Tools"
    );

    public static final ItemStack GUIDE_ITEM_BASIC_MACHINES = new CustomItemStack(
        Material.CRAFTING_TABLE,
        Theme.MECHANICAL.getColor() + "Basic Machines"
    );

    public static final ItemStack GUIDE_ITEM_RAW_INGREDIENTS = new CustomItemStack(
        Material.SUGAR,
        Theme.INGREDIENT.getColor() + "Raw Ingredients"
    );

    public static final ItemStack GUIDE_ITEM_FOOD = new CustomItemStack(
        Material.COOKED_BEEF,
        Theme.REGULAR_FOOD.getColor() + "Food"
    );

    public static final ItemStack GUIDE_ITEM_MAIN = new CustomItemStack(
        Material.COOKED_BEEF,
        Theme.PERFECT_FOOD.getColor() + "Gastronomicon"
    );

    public static final ItemStack GUIDE_RECIPE_BREAK = new CustomItemStack(
        Material.BARREL,
        "&bBreaking Blocks",
        "This item is obtained by",
        "breaking the displayed",
        "blocks."
    );

    public static final ItemStack GUIDE_RECIPE_HARVEST = new CustomItemStack(
        Material.BARREL,
        "&bHarvesting Crops",
        "This item is obtained by",
        "harvesting the displayed",
        "crops."
    );

    public static final ItemStack GUIDE_RECIPE_CULINARY_WORKBENCH = new CustomItemStack(
        Material.CRAFTING_TABLE,
        "&bCulinary Workbench",
        "Craft this item as shown in a",
        "Culinary Workbench with the tool(s)",
        "listed below."
    );

    public static final ItemStack GUIDE_RECIPE_ENHANCED_OVEN = new CustomItemStack(
        Material.BLAST_FURNACE,
        "&bEnhanced Oven",
        "Craft this item as shown in an",
        "Enhanced Oven with the tool(s)",
        "listed below."
    );

    public static final ItemStack GUIDE_RECIPE_REFRIDGERATOR = new CustomItemStack(
        Material.IRON_BLOCK,
        "&bRefridgerator",
        "Craft this item as shown in a",
        "Refridgerator with the tool(s)",
        "listed below."
    );

    public static final ItemStack GUIDE_RECIPE_MILL = new CustomItemStack(
        Material.STONE_BRICK_SLAB,
        "&bMill",
        "Craft this item as shown in a",
        "Mill with the tool(s) listed",
        "below."
    );

    public static final ItemStack GUIDE_RECIPE_DISTILLERY = new CustomItemStack(
        Material.BARREL,
        "&bDistillery",
        "Craft this item as shown in a",
        "Distillery with the tool(s)",
        "listed below."
    );

    public static final ItemStack GUIDE_TOOLS_REQUIRED = new CustomItemStack(
        Material.LIGHT_BLUE_STAINED_GLASS_PANE,
        Theme.MECHANICAL.getColor() + "Tools Required:"
    );

    public static final ItemStack GUIDE_NO_TOOLS_REQUIRED = new CustomItemStack(
        Material.BARRIER,
        "&cNone"
    );


    // ---- Tools ----

    // -- Workstation Tools --

    // Culinary Workbench

    public static final SlimefunItemStack CUTTING_BOARD = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_CUTTING_BOARD",
        Material.OAK_PRESSURE_PLATE,
        "Cutting Board"
    );

    public static final SlimefunItemStack MEAT_SCISSORS = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_MEAT_SCISSORS",
        Material.SHEARS,
        "Meat Scissors"
    );

    public static final SlimefunItemStack KITCHEN_KNIFE = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_KITCHEN_KNIFE",
        Material.IRON_SWORD,
        "Kitchen Knife"
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack ROLLING_PIN = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_ROLLING_PIN",
        Material.STICK,
        "Rolling Pin"
    );

    public static final SlimefunItemStack BLENDER = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_BLENDER",
        Material.BUCKET,
        "Blender"
    );

    public static final SlimefunItemStack MORTAR_AND_PESTLE = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_MORTAR_AND_PESTLE",
        Material.BOWL,
        "Mortar and Pestle"
    );

    public static final SlimefunItemStack PEELER = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_PEELER",
        Material.IRON_HOE,
        "Peeler"
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES);

    // Enhanced Oven

    public static final SlimefunItemStack BAKING_TRAY = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_BAKING_TRAY",
        Material.LIGHT_GRAY_CARPET,
        "Baking Tray"
    );

    public static final SlimefunItemStack FRYING_PAN = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_FRYING_PAN",
        Material.GRAY_CARPET,
        "Frying Pan"
    );

    public static final SlimefunItemStack STEEL_POT = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_STEEL_POT",
        Material.CAULDRON,
        "Steel Pot"
    );

    // -- Traps --

    public static final SlimefunItemStack STEEL_WIRE = ThemedItemStack.of(
        Theme.TRAP,
        "GN_STEEL_WIRE",
        Material.STRING,
        "Steel Wire"
    );

    public static final SlimefunItemStack STEEL_SPRING = ThemedItemStack.of(
        Theme.TRAP,
        "GN_STEEL_SPRING",
        Material.STRING,
        "Steel Spring"
    );

    public static final SlimefunItemStack CRAB_TRAP = ThemedItemStack.of(
        Theme.TRAP,
        "GN_CRAB_TRAP",
        Material.OAK_TRAPDOOR,
        "Crab Trap"
    );

    public static final SlimefunItemStack LOBSTER_TRAP = ThemedItemStack.of(
        Theme.TRAP,
        "GN_LOBSTER_TRAP",
        Material.MANGROVE_TRAPDOOR,
        "Lobster Trap"
    );

    public static final SlimefunItemStack HUNTING_TRAP = ThemedItemStack.of(
        Theme.TRAP,
        "GN_HUNTING_TRAP",
        Material.IRON_TRAPDOOR,
        "Hunting Trap"
    );

    public static final SlimefunItemStack FISHING_NET = ThemedItemStack.of(
        Theme.TRAP,
        "GN_FISHING_NET",
        Material.COBWEB,
        "Fishing Net"
    );

    // -- Other --

    public static final SlimefunItemStack WOODEN_SICKLE = ThemedItemStack.of(
        Theme.TOOL,
        "GN_WOODEN_SICKLE",
        Material.WOODEN_HOE,
        "Wooden Sickle"
    );

    public static final SlimefunItemStack STEEL_SICKLE = ThemedItemStack.of(
        Theme.TOOL,
        "GN_IRON_SICKLE",
        Material.IRON_HOE,
        "Iron Sickle"
    );

    public static final SlimefunItemStack REINFORCED_SICKLE = ThemedItemStack.of(
        Theme.TOOL,
        "GN_REINFORCED_SICKLE",
        Material.NETHERITE_HOE,
        "Reinforced Sickle"
    );
 

    // ---- Basic Machines ----

    public static final SlimefunItemStack CULINARY_WORKBENCH = ThemedItemStack.of(
        Theme.MECHANICAL,
        "GN_CULINARY_WORKBENCH",
        Material.CRAFTING_TABLE,
        "Culinary Workbench",
        "A clean, culinary-grade crafting table"
    );

    public static final SlimefunItemStack ENHANCED_OVEN = ThemedItemStack.of(
        Theme.MECHANICAL,
        "GN_ENHANCED_OVEN",
        Material.BLAST_FURNACE,
        "Enhanced Oven",
        "It can bake, steam, fry, and ",
        "broil anything!"
    );

    public static final SlimefunItemStack REFRIDGERATOR = ThemedItemStack.of(
        Theme.MECHANICAL,
        "GN_REFRIDGERATOR",
        Material.IRON_BLOCK,
        "Refridgerator",
        "temp"
    );

    public static final SlimefunItemStack MILL = ThemedItemStack.of(
        Theme.MECHANICAL,
        "GN_MILL",
        Material.CAULDRON,
        "Mill",
        "temp"
    );

    public static final SlimefunItemStack DISTILLERY = ThemedItemStack.of(
        Theme.MECHANICAL,
        "GN_DISTILLERY",
        Material.BARREL,
        "Distillery",
        "temp"
    );

    // ---- Raw Ingredients ----

    // -- Crops --

    public static final SlimefunItemStack RICE = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_RICE",
        Material.PUMPKIN_SEEDS,
        "Rice"
    );

    public static final SlimefunItemStack QUINOA = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_QUINOA",
        Material.PUMPKIN_SEEDS,
        "Quinoa"
    );

    public static final SlimefunItemStack OATS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_OATS",
        Material.BEETROOT_SEEDS,
        "Oats"
    );

    public static final SlimefunItemStack SOYBEANS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_SOYBEANS",
        Material.BEETROOT_SEEDS,
        "Soybeans"
    );

    public static final SlimefunItemStack BARLEY = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_BARLEY",
        Material.WHEAT,
        "Barley"
    );

    public static final SlimefunItemStack BARLEY_SEEDS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_BARLEY_SEEDS",
        Material.WHEAT_SEEDS,
        "Barley Seeds"
    );

    public static final SlimefunItemStack RYE = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_RYE",
        Material.WHEAT,
        "Rye"
    );

    public static final SlimefunItemStack RYE_SEEDS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_RYE_SEEDS",
        Material.PUMPKIN_SEEDS,
        "Rye Seeds"
    );

    public static final SlimefunItemStack SORGHUM = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_SORGHUM",
        Material.WHEAT,
        "Sorghum"
    );

    public static final SlimefunItemStack SORGHUM_SEEDS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_SORGHUM_SEEDS",
        Material.BEETROOT_SEEDS,
        "Sorghum Seeds"
    );

    public static final SlimefunItemStack TURNIP = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_TURNIP",
        Material.BEETROOT,
        "Turnip"
    );

    public static final SlimefunItemStack TURNIP_SEEDS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_TURNIP_SEEDS",
        Material.MELON_SEEDS,
        "Turnip Seeds"
    );

    public static final SlimefunItemStack SQUASH = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_SQUASH",
        Material.MELON,
        "Squash"
    );

    public static final SlimefunItemStack SQUASH_SEEDS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_SQUASH_SEEDS",
        Material.PUMPKIN_SEEDS,
        "Squash Seeds"
    );

    public static final SlimefunItemStack CELERY = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_CELERY",
        Material.SUGAR_CANE,
        "Celery"
    );

    public static final SlimefunItemStack BOK_CHOY = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_BOK_CHOY",
        Material.MANGROVE_PROPAGULE,
        "Bok Choy"
    );

    public static final SlimefunItemStack SNOW_PEAS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_SNOW_PEAS",
        Material.GREEN_DYE,
        "Snow Peas"
    );

    public static final SlimefunItemStack BROCCOLI = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_BROCCOLI",
        Material.OAK_SAPLING,
        "Broccoli"
    );

    public static final SlimefunItemStack WASABI_PLANT = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_WASABI_PLANT",
        Material.SMALL_DRIPLEAF,
        "Wasabi Plant"
    );

    public static final SlimefunItemStack LEMONGRASS = ThemedItemStack.of( // TODO: Sugar Cane
        Theme.INGREDIENT,
        "GN_LEMONGRASS",
        Material.SUGAR_CANE,
        "Lemongrass"
    );

    public static final SlimefunItemStack CUCUMBER = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_CUCUMBER",
        Material.GREEN_CANDLE,
        "Cucumber"
    );
    public static final SlimefunItemStack BASIL = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_BASIL",
        Material.KELP,
        "Basil"
    );

    public static final SlimefunItemStack SPINACH = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_SPINACH",
        Material.BIG_DRIPLEAF,
        "Spinach"
    );

    public static final SlimefunItemStack BRUSSLES_SPROUTS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_BRUSSLES_SPROUTS",
        Material.SMALL_DRIPLEAF,
        "Brussles Sprouts"
    );

    public static final SlimefunItemStack MINT = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_MINT",
        Material.FERN,
        "Mint"
    );

    public static final SlimefunItemStack CHILI_PEPPER = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_CHILI_PEPPER",
        Material.RED_CANDLE,
        "Chili Pepper"
    );

    public static final SlimefunItemStack PARSLEY = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_MINT",
        Material.SMALL_DRIPLEAF,
        "Parsley"
    );

    public static final SlimefunItemStack CASSAVA = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_CASSAVA",
        Material.CARROT,
        "Cassava"
    );

    public static final SlimefunItemStack LENTILS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_LENTILS",
        Material.PUMPKIN_SEEDS,
        "Lentils"
    );

    // TODO: Grown from trees
    // -- Grown from trees --

    public static final SlimefunItemStack LYCHEE = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_LYCHEE",
        Material.BEETROOT,
        "Lychee"
    );
    public static final SlimefunItemStack PERSIMMON = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_PERSIMMON",
        Material.ORANGE_DYE,
        "Persimmon"
    );
    public static final SlimefunItemStack BANANA = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_BANANA",
        Material.YELLOW_DYE,
        "Banana"
    );
    public static final SlimefunItemStack VANILLA_BEANS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_VANILLA_BEANS",
        Material.COCOA_BEANS,
        "Vanilla Beans"
    );

    // TODO: Harvested
    // -- Harvested --
    public static final SlimefunItemStack FIDDLEHEADS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_FIDDLEHEADS",
        Material.FERN,
        "Fiddleheads"
    );

    public static final SlimefunItemStack TRUFFLES = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_TRUFFLES",
        Material.BROWN_MUSHROOM,
        "Truffles"
    );

    public static final SlimefunItemStack ENOKI_MUSHROOMS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_ENOKI_MUSHROOMS",
        Material.BROWN_MUSHROOM,
        "Enoki Mushrooms"
    );

    public static final SlimefunItemStack KING_OYSTER_MUSHROOM = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_KING_OYSTER_MUSHROOM",
        Material.BROWN_MUSHROOM,
        "King Oyster Mushroom"
    );

    public static final SlimefunItemStack BUTTON_MUSHROOM = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_BUTTON_MUSHROOM",
        Material.BROWN_MUSHROOM,
        "Button Mushroom"
    );
    // TODO: Mob Drops
    // -- Dropped from mobs --

    // TODO: Fishing Drops
    // -- From fishing --

    // TODO: Trap Drops
    // -- From traps --
    
    // ---- Food ----

    // -- Ingredients --

    public static final SlimefunItemStack COOKED_RICE = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_COOKED_RICE",
        Material.SUGAR,
        "Cooked Rice"
    );

    public static final SlimefunItemStack BARLEY_FLOUR = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_BARLEY_FLOUR",
        Material.SUGAR,
        "Cooked Rice"
    );

    public static final SlimefunItemStack TOAST = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_TOAST",
        Material.BREAD,
        "Toast"
    );

    public static final SlimefunItemStack ENGLISH_MUFFIN = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_ENGLISH_MUFFIN",
        Material.BREAD,
        "Toast"
    );

    public static final SlimefunItemStack FRIED_EGG = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_ENGLISH_MUFFIN",
        Material.EGG,
        "Fried Egg"
    );

    public static final SlimefunItemStack HARD_BOILED_EGG = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_HARD_BOILED_EGG",
        Material.EGG,
        "Hard-boiled Egg"
    );

    public static final SlimefunItemStack SCRAMBLED_EGGS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_SCRAMBLED_EGGS",
        Material.YELLOW_DYE,
        "Scrambled Eggs"
    );

    public static final SlimefunItemStack CUSTARD = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_CUSTARD",
        Material.YELLOW_DYE,
        "Custard"
    );

    public static final SlimefunItemStack MARMALADE = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_MARMALADE",
        Material.HONEY_BOTTLE,
        "Marmalade"
    );

    public static final SlimefunItemStack PULLED_PORK = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_PULLED_PORK",
        Material.BROWN_DYE,
        "Pulled Pork"
    );

    public static final SlimefunItemStack GROUND_BEEF = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_GROUND_BEEF",
        Material.BROWN_DYE,
        "Ground Beef"
    );

    // -- Cuisine --

    public static final FoodItemStack ONIGIRI = FoodItemStack.of(
        "GN_ONIGIRI",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Onigiri",
        3,
        3,
        new FoodEffect[] {
            FoodEffect.heal(1)
        },
        "temporary"
    );
}
