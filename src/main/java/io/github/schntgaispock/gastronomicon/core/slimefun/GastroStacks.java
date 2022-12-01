package io.github.schntgaispock.gastronomicon.core.slimefun;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.stacks.ThemedItemStack;
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
        Material.CRAFTING_TABLE,
        Theme.INGREDIENT.getColor() + "Raw Ingredients"
    );

    public static final ItemStack GUIDE_ITEM_FOOD = new CustomItemStack(
        Material.CRAFTING_TABLE,
        Theme.REGULAR_FOOD.getColor() + "Food"
    );

    public static final ItemStack GUIDE_ITEM_MAIN = new CustomItemStack(
        Material.CRAFTING_TABLE,
        Theme.PERFECT_FOOD.getColor() + "Gastronomicon"
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
    );

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
        Material.BUCKET,
        "Mortar and Pestle"
    );

    public static final SlimefunItemStack PEELER = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_PEELER",
        Material.IRON_HOE,
        "Peeler"
    );

    // Enhanced Oven

    public static final SlimefunItemStack BAKING_TRAY = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_BAKING_TRAY",
        Material.LIGHT_WEIGHTED_PRESSURE_PLATE,
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

    public static final SlimefunItemStack CRAP_TRAP = ThemedItemStack.of(
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

    public static final SlimefunItemStack GRAIN_SICKLE = ThemedItemStack.of(
        Theme.TOOL,
        "GN_GRAIN_SICKLE",
        Material.IRON_HOE,
        "Grain Sickle"
    );


    // ---- Basic Machines ----

    public static final SlimefunItemStack CULINARY_WORKBENCH = ThemedItemStack.of(
        Theme.MECHANICAL,
        "GN_CULINARY_WORKBENCH",
        Material.CRAFTING_TABLE,
        "Culinary Workbench",
        "A clean, culinary-grade workbench"
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

    public static final SlimefunItemStack RICE = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_RICE",
        Material.PUMPKIN_SEEDS,
        "Rice"
    );

    public static final SlimefunItemStack BROWN_RICE = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_BROWN_RICE",
        Material.MELON_SEEDS,
        "Brown Rice"
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

    public static final SlimefunItemStack SOYBEANS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_SOYBEANS",
        Material.BEETROOT_SEEDS,
        "Soybeans"
    );

    public static final SlimefunItemStack SNOW_PEAS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_SNOW_PEAS",
        Material.GREEN_DYE,
        "Snow Peas"
    );

    public static final SlimefunItemStack QUINOA = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_QUINOA",
        Material.PUMPKIN_SEEDS,
        "Quinoa"
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

    public static final SlimefunItemStack LEMONGRASS = ThemedItemStack.of(
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

    public static final SlimefunItemStack SQUASH = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_SQUASH",
        Material.MELON,
        "Squash"
    );

    public static final SlimefunItemStack OATS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_OATS",
        Material.BEETROOT_SEEDS,
        "Oats"
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

    public static final SlimefunItemStack BRUSSLE_SPROUTS = ThemedItemStack.of(
        Theme.INGREDIENT,
        "GN_BRUSSLE_SPROUTS",
        Material.SMALL_DRIPLEAF,
        "Brussle Sprouts"
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
        Material.POTATO,
        "Cassava"
    );
    
    // ---- Food ----

}
