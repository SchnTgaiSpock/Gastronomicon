package io.github.schntgaispock.gastronomicon.core.slimefun;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.util.ThemedItemStack;
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
        ""
    );

    public static final SlimefunItemStack MEAT_SCISSORS = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_MEAT_SCISSORS",
        Material.SHEARS,
        ""
    );

    public static final SlimefunItemStack KITCHEN_KNIFE = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_KITCHEN_KNIFE",
        Material.IRON_SWORD,
        ""
    );

    public static final SlimefunItemStack ROLLING_PIN = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_ROLLING_PIN",
        Material.STICK,
        ""
    );

    public static final SlimefunItemStack BLENDER = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_BLENDER",
        Material.BUCKET,
        ""
    );

    public static final SlimefunItemStack MORTAR_AND_PESTLE = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_MORTAR_AND_PESTLE",
        Material.BUCKET,
        ""
    );

    public static final SlimefunItemStack PEELER = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_PEELER",
        Material.IRON_HOE,
        ""
    );

    // Enhanced Oven

    public static final SlimefunItemStack BAKING_TRAY = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_PEELER",
        Material.LIGHT_WEIGHTED_PRESSURE_PLATE,
        ""
    );

    public static final SlimefunItemStack FRYING_PAN = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_FRYING_PAN",
        Material.GRAY_CARPET,
        ""
    );

    public static final SlimefunItemStack STEEL_POT = ThemedItemStack.of(
        Theme.WTOOL,
        "GN_STEEL_POT",
        Material.CAULDRON,
        ""
    );

    // -- Traps --

    public static final SlimefunItemStack CRAP_TRAP = ThemedItemStack.of(
        Theme.TRAP,
        "GN_CRAB_TRAP",
        Material.OAK_TRAPDOOR,
        ""
    );

    public static final SlimefunItemStack LOBSTER_TRAP = ThemedItemStack.of(
        Theme.TRAP,
        "GN_LOBSTER_TRAP",
        Material.MANGROVE_TRAPDOOR,
        ""
    );

    public static final SlimefunItemStack HUNTING_TRAP = ThemedItemStack.of(
        Theme.TRAP,
        "GN_HUNTING_TRAP",
        Material.IRON_TRAPDOOR,
        ""
    );

    public static final SlimefunItemStack FISHING_NET = ThemedItemStack.of(
        Theme.TRAP,
        "GN_FISHING_NET",
        Material.COBWEB,
        ""
    );

    // -- Other --

    public static final SlimefunItemStack GRAIN_SICKLE = ThemedItemStack.of(
        Theme.TOOL,
        "GN_GRAIN_SICKLE",
        Material.IRON_HOE,
        ""
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
    
    // ---- Food ----

}
