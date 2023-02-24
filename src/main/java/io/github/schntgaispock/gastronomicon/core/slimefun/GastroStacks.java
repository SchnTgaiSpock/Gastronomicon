package io.github.schntgaispock.gastronomicon.core.slimefun;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import io.github.schntgaispock.gastronomicon.core.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.core.items.stacks.FoodItemStack;
import io.github.schntgaispock.gastronomicon.core.items.stacks.ThemedItemStack;
import io.github.schntgaispock.gastronomicon.core.items.stacks.GastroTheme.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroStacks {

    // ---- Guide Only Items ----

    public static final ItemStack GUIDE_ITEM_TOOLS = new CustomItemStack(
        Material.IRON_HOE,
        Theme.TOOL.getColor() + "Tools"
    );

    public static final ItemStack GUIDE_ITEM_MANUAL_WORKSTATIONS = new CustomItemStack(
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

    public static final ItemStack GUIDE_RECIPE_MULTI_STOVE = new CustomItemStack(
        Material.BLAST_FURNACE,
        "&bMulti-Stove",
        "Craft this item as shown in a",
        "Multi-Stove with the tool(s)",
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
        "GN_STEEL_SICKLE",
        Material.IRON_HOE,
        "STEEL Sickle"
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

    public static final SlimefunItemStack MULTI_STOVE = ThemedItemStack.of(
        Theme.MECHANICAL,
        "GN_MULTI_STOVE",
        Material.BLAST_FURNACE,
        "Multi-Stove",
        LoreBuilder.powerBuffer(600),
        LoreBuilder.power(150, "/Craft")
    );

    public static final SlimefunItemStack REFRIDGERATOR = ThemedItemStack.of(
        Theme.MECHANICAL,
        "GN_REFRIDGERATOR",
        Material.IRON_BLOCK,
        "Refridgerator",
        LoreBuilder.powerBuffer(600),
        LoreBuilder.power(150, "/Craft")
    );

    public static final SlimefunItemStack MILL = ThemedItemStack.of(
        Theme.MECHANICAL,
        "GN_MILL",
        Material.CAULDRON,
        "Grain Mill"
    );

    public static final SlimefunItemStack DISTILLERY = ThemedItemStack.of(
        Theme.MECHANICAL,
        "GN_DISTILLERY",
        Material.BARREL,
        "Distillery"
    );

    // ---- Raw Ingredients ----

    // -- Crops --

    public static final SlimefunItemStack RICE = ThemedItemStack.ingredient(
        "GN_RICE",
        Material.PUMPKIN_SEEDS,
        "Rice"
    );

    public static final SlimefunItemStack QUINOA = ThemedItemStack.ingredient(
        "GN_QUINOA",
        Material.PUMPKIN_SEEDS,
        "Quinoa"
    );

    public static final SlimefunItemStack OATS = ThemedItemStack.ingredient(
        "GN_OATS",
        Material.BEETROOT_SEEDS,
        "Oats"
    );

    public static final SlimefunItemStack SOYBEANS = ThemedItemStack.ingredient(
        "GN_SOYBEANS",
        Material.BEETROOT_SEEDS,
        "Soybeans"
    );

    public static final SlimefunItemStack BARLEY = ThemedItemStack.ingredient(
        "GN_BARLEY",
        Material.WHEAT,
        "Barley"
    );

    public static final SlimefunItemStack BARLEY_SEEDS = ThemedItemStack.ingredient(
        "GN_BARLEY_SEEDS",
        Material.WHEAT_SEEDS,
        "Barley Seeds"
    );

    public static final SlimefunItemStack RYE = ThemedItemStack.ingredient(
        "GN_RYE",
        Material.WHEAT,
        "Rye"
    );

    public static final SlimefunItemStack RYE_SEEDS = ThemedItemStack.ingredient(
        "GN_RYE_SEEDS",
        Material.PUMPKIN_SEEDS,
        "Rye Seeds"
    );

    public static final SlimefunItemStack SORGHUM = ThemedItemStack.ingredient(
        "GN_SORGHUM",
        Material.WHEAT,
        "Sorghum"
    );

    public static final SlimefunItemStack SORGHUM_SEEDS = ThemedItemStack.ingredient(
        "GN_SORGHUM_SEEDS",
        Material.BEETROOT_SEEDS,
        "Sorghum Seeds"
    );

    public static final SlimefunItemStack TURNIP = ThemedItemStack.ingredient(
        "GN_TURNIP",
        Material.BEETROOT,
        "Turnip"
    );

    public static final SlimefunItemStack TURNIP_SEEDS = ThemedItemStack.ingredient(
        "GN_TURNIP_SEEDS",
        Material.MELON_SEEDS,
        "Turnip Seeds"
    );

    public static final SlimefunItemStack SQUASH = ThemedItemStack.ingredient(
        "GN_SQUASH",
        Material.MELON,
        "Squash"
    );

    public static final SlimefunItemStack SQUASH_SEEDS = ThemedItemStack.ingredient(
        "GN_SQUASH_SEEDS",
        Material.PUMPKIN_SEEDS,
        "Squash Seeds"
    );

    public static final SlimefunItemStack CELERY = ThemedItemStack.ingredient(
        "GN_CELERY",
        Material.SUGAR_CANE,
        "Celery"
    );

    public static final SlimefunItemStack BOK_CHOY = ThemedItemStack.ingredient(
        "GN_BOK_CHOY",
        Material.MANGROVE_PROPAGULE,
        "Bok Choy"
    );

    public static final SlimefunItemStack SNOW_PEAS = ThemedItemStack.ingredient(
        "GN_SNOW_PEAS",
        Material.GREEN_DYE,
        "Snow Peas"
    );

    public static final SlimefunItemStack BROCCOLI = ThemedItemStack.ingredient(
        "GN_BROCCOLI",
        Material.OAK_SAPLING,
        "Broccoli"
    );

    public static final SlimefunItemStack WASABI_PLANT = ThemedItemStack.ingredient(
        "GN_WASABI_PLANT",
        Material.SMALL_DRIPLEAF,
        "Wasabi Plant"
    );

    public static final SlimefunItemStack LEMONGRASS = ThemedItemStack.ingredient(
        "GN_LEMONGRASS",
        Material.SUGAR_CANE,
        "Lemongrass"
    );

    public static final SlimefunItemStack CUCUMBER = ThemedItemStack.ingredient(
        "GN_CUCUMBER",
        Material.SEA_PICKLE,
        "Cucumber"
    );
    public static final SlimefunItemStack BASIL = ThemedItemStack.ingredient(
        "GN_BASIL",
        Material.KELP,
        "Basil"
    );

    public static final SlimefunItemStack SPINACH = ThemedItemStack.ingredient(
        "GN_SPINACH",
        Material.BIG_DRIPLEAF,
        "Spinach"
    );

    public static final SlimefunItemStack BRUSSLES_SPROUTS = ThemedItemStack.ingredient(
        "GN_BRUSSLES_SPROUTS",
        Material.SMALL_DRIPLEAF,
        "Brussles Sprouts"
    );

    public static final SlimefunItemStack MINT = ThemedItemStack.ingredient(
        "GN_MINT",
        Material.FERN,
        "Mint"
    );

    public static final SlimefunItemStack CHILI_PEPPER = ThemedItemStack.ingredient(
        "GN_CHILI_PEPPER",
        Material.RED_CANDLE,
        "Chili Pepper"
    );

    public static final SlimefunItemStack PARSLEY = ThemedItemStack.ingredient(
        "GN_PARSLEY",
        Material.SMALL_DRIPLEAF,
        "Parsley"
    );

    public static final SlimefunItemStack CASSAVA = ThemedItemStack.ingredient(
        "GN_CASSAVA",
        Material.CARROT,
        "Cassava"
    );

    public static final SlimefunItemStack LENTILS = ThemedItemStack.ingredient(
        "GN_LENTILS",
        Material.PUMPKIN_SEEDS,
        "Lentils"
    );

    // -- Grown from trees --

    public static final SlimefunItemStack LYCHEE = ThemedItemStack.ingredient(
        "GN_LYCHEE",
        Material.BEETROOT,
        "Lychee"
    );
    public static final SlimefunItemStack LYCHEE_SAPLING = ThemedItemStack.ingredient(
        "GN_LYCHEE_SAPLING",
        Material.OAK_SAPLING,
        "Lychee Sapling"
    );
    public static final SlimefunItemStack PERSIMMON = ThemedItemStack.ingredient(
        "GN_PERSIMMON",
        Material.ORANGE_DYE,
        "Persimmon"
    );
    public static final SlimefunItemStack PERSIMMON_SAPLING = ThemedItemStack.ingredient(
        "GN_PERSIMMON_SAPLING",
        Material.OAK_SAPLING,
        "Persimmon Sapling"
    );
    public static final SlimefunItemStack BANANA = ThemedItemStack.ingredient(
        "GN_BANANA",
        Material.YELLOW_DYE,
        "Banana"
    );
    public static final SlimefunItemStack BANANA_SAPLING = ThemedItemStack.ingredient(
        "GN_BANANA_SAPLING",
        Material.OAK_SAPLING,
        "Banana Sapling"
    );
    public static final SlimefunItemStack VANILLA_BEANS = ThemedItemStack.ingredient(
        "GN_VANILLA_BEANS",
        Material.COCOA_BEANS,
        "Vanilla Beans"
    );
    public static final SlimefunItemStack VANILLA_SAPLING = ThemedItemStack.ingredient(
        "GN_VANILLA_SAPLING",
        Material.OAK_SAPLING,
        "Vanilla Sapling"
    );

    // -- Harvested --

    public static final SlimefunItemStack FIDDLEHEADS = ThemedItemStack.ingredient(
        "GN_FIDDLEHEADS",
        Material.FERN,
        "Fiddleheads"
    );

    public static final SlimefunItemStack TRUFFLES = ThemedItemStack.ingredient(
        "GN_TRUFFLES",
        Material.BROWN_MUSHROOM,
        "Truffles"
    );

    public static final SlimefunItemStack ENOKI_MUSHROOMS = ThemedItemStack.ingredient(
        "GN_ENOKI_MUSHROOMS",
        Material.BROWN_MUSHROOM,
        "Enoki Mushrooms"
    );

    public static final SlimefunItemStack KING_OYSTER_MUSHROOM = ThemedItemStack.ingredient(
        "GN_KING_OYSTER_MUSHROOM",
        Material.BROWN_MUSHROOM,
        "King Oyster Mushroom"
    );

    public static final SlimefunItemStack BUTTON_MUSHROOM = ThemedItemStack.ingredient(
        "GN_BUTTON_MUSHROOM",
        Material.BROWN_MUSHROOM,
        "Button Mushroom"
    );

    // -- Dropped from mobs --

    public static final SlimefunItemStack RAW_CHEVON = ThemedItemStack.ingredient(
        "GN_RAW_CHEVON",
        Material.MUTTON,
        "Raw Chevon"
    );

    public static final SlimefunItemStack COOKED_CHEVON = ThemedItemStack.ingredient(
        "GN_COOKED_CHEVON",
        Material.COOKED_MUTTON,
        "Cooked Chevon"
    );

    public static final SlimefunItemStack FROG_LEG = ThemedItemStack.ingredient(
        "GN_FROG_LEG",
        Material.STICK,
        "Frog Leg"
    );

    public static final SlimefunItemStack GIANT_SPIDER_LEG = ThemedItemStack.ingredient(
        "GN_GIANT_SPIDER_LEG",
        Material.STICK,
        "Giant Spider Leg"
    );

    public static final SlimefunItemStack SALMON_ROE = ThemedItemStack.ingredient(
        "GN_SALMON_ROE",
        Material.BEETROOT_SEEDS,
        "Salmon Roe"
    );

    public static final SlimefunItemStack GUARDIAN_FIN = ThemedItemStack.ingredient(
        "GN_GUARDIAN_FIN",
        Material.PRISMARINE,
        "Guardian Fin"
    );

    public static final SlimefunItemStack RAW_SQUID = ThemedItemStack.ingredient(
        "GN_RAW_SQUID",
        Material.PORKCHOP,
        "Raw Squid"
    );

    public static final SlimefunItemStack COOKED_SQUID = ThemedItemStack.ingredient(
        "GN_COOKED_SQUID",
        Material.COOKED_PORKCHOP,
        "Cooked Squid"
    );

    // -- From fishing --

    public static final SlimefunItemStack RAW_MACKEREL = ThemedItemStack.ingredient(
        "GN_RAW_MACKEREL",
        Material.COD,
        "Raw Mackerel"
    );
    public static final SlimefunItemStack COOKED_MACKEREL = ThemedItemStack.ingredient(
        "GN_COOKED_MACKEREL",
        Material.COOKED_COD,
        "Cooked Mackerel"
    );

    public static final SlimefunItemStack RAW_EEL = ThemedItemStack.ingredient(
        "GN_RAW_EEL",
        Material.COD,
        "Raw Eel"
    );
    public static final SlimefunItemStack COOKED_EEL = ThemedItemStack.ingredient(
        "GN_COOKED_EEL",
        Material.COOKED_COD,
        "Cooked Eel"
    );  

    public static final SlimefunItemStack RAW_TROUT = ThemedItemStack.ingredient(
        "GN_RAW_TROUT",
        Material.COD,
        "Raw Trout"
    );
    public static final SlimefunItemStack COOKED_TROUT = ThemedItemStack.ingredient(
        "GN_COOKED_TROUT",
        Material.COOKED_COD,
        "Cooked Trout"
    );
    
    public static final SlimefunItemStack RAW_BASS = ThemedItemStack.ingredient(
        "GN_RAW_BASS",
        Material.COD,
        "Raw Bass"
    );
    public static final SlimefunItemStack COOKED_BASS = ThemedItemStack.ingredient(
        "GN_COOKED_BASS",
        Material.COOKED_COD,
        "Cooked Bass"
    );

    public static final SlimefunItemStack RAW_CARP = ThemedItemStack.ingredient(
        "GN_RAW_CARP",
        Material.COD,
        "Raw Carp"
    );
    public static final SlimefunItemStack COOKED_CARP = ThemedItemStack.ingredient(
        "GN_COOKED_CARP",
        Material.COOKED_COD,
        "Cooked Carp"
    );
    
    public static final SlimefunItemStack RAW_PIKE = ThemedItemStack.ingredient(
        "GN_RAW_PIKE",
        Material.COD,
        "Raw Pike"
    );
    public static final SlimefunItemStack COOKED_PIKE = ThemedItemStack.ingredient(
        "GN_COOKED_PIKE",
        Material.COOKED_COD,
        "Cooked Pike"
    );

    // -- From traps --

    public static final SlimefunItemStack CRAB = ThemedItemStack.ingredient(
        "GN_CRAB",
        Material.RED_DYE,
        "Crab"
    );
    
    public static final SlimefunItemStack RAW_TURKEY = ThemedItemStack.ingredient(
        "GN_RAW_TURKEY",
        Material.CHICKEN,
        "Raw Turkey"
    );
    public static final SlimefunItemStack COOKED_TURKEY = ThemedItemStack.ingredient(
        "GN_COOKED_TURKEY",
        Material.CHICKEN,
        "Cooked Turkey"
    );


    // ---- Food ----

    // -- Ingredients --

    public static final SlimefunItemStack COOKED_RICE = ThemedItemStack.ingredient(
        "GN_COOKED_RICE",
        Material.SUGAR,
        "Cooked Rice"
    );

    public static final SlimefunItemStack BARLEY_FLOUR = ThemedItemStack.ingredient(
        "GN_BARLEY_FLOUR",
        Material.SUGAR,
        "Cooked Rice"
    );

    public static final SlimefunItemStack TOAST = ThemedItemStack.ingredient(
        "GN_TOAST",
        Material.BREAD,
        "Toast"
    );

    public static final SlimefunItemStack ENGLISH_MUFFIN = ThemedItemStack.ingredient(
        "GN_ENGLISH_MUFFIN",
        Material.BREAD,
        "Toast"
    );

    public static final SlimefunItemStack FRIED_EGG = ThemedItemStack.ingredient(
        "GN_ENGLISH_MUFFIN",
        Material.EGG,
        "Fried Egg"
    );

    public static final SlimefunItemStack HARD_BOILED_EGG = ThemedItemStack.ingredient(
        "GN_HARD_BOILED_EGG",
        Material.EGG,
        "Hard-boiled Egg"
    );

    public static final SlimefunItemStack SCRAMBLED_EGGS = ThemedItemStack.ingredient(
        "GN_SCRAMBLED_EGGS",
        Material.YELLOW_DYE,
        "Scrambled Eggs"
    );

    public static final SlimefunItemStack CUSTARD = ThemedItemStack.ingredient(
        "GN_CUSTARD",
        Material.YELLOW_DYE,
        "Custard"
    );

    public static final SlimefunItemStack MARMALADE = ThemedItemStack.ingredient(
        "GN_MARMALADE",
        Material.HONEY_BOTTLE,
        "Marmalade"
    );

    public static final SlimefunItemStack PULLED_PORK = ThemedItemStack.ingredient(
        "GN_PULLED_PORK",
        Material.BROWN_DYE,
        "Pulled Pork"
    );

    public static final SlimefunItemStack GROUND_BEEF = ThemedItemStack.ingredient(
        "GN_GROUND_BEEF",
        Material.BROWN_DYE,
        "Ground Beef"
    );

    // -- Cuisine --

    // Sandwiches

    public static final FoodItemStack PBJ_SANDWICH = FoodItemStack.of(
        "GN_PBJ_SANDWICH",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "PB&J Sandwich",
        8,
        1d,
        FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 90), 50)
    );

    public static final FoodItemStack MARMALADE_SANDWICH = FoodItemStack.of(
        "GN_MARMALADE_SANDWICH",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Marmalade Sandwich",
        8,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30)
    );

    public static final FoodItemStack BAKED_BEAN_SANDWICH = FoodItemStack.of(
        "GN_BAKED_BEAN_SANDWICH",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Baked Bean Sandwich",
        8,
        1d,
        new FoodEffect[] {
            FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 90), 50),
            FoodEffect.chanceOf(FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 5), 5)
        }
    );

    public static final FoodItemStack TUNA_SANDWICH = FoodItemStack.of(
        "GN_TUNA_SANDWICH",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Tuna Sandwich",
        8,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30)
    );

    public static final FoodItemStack BREAKFAST_SANDWICH = FoodItemStack.of(
        "GN_BREAKFAST_SANDWICH",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Breakfast Sandwich",
        8,
        1d,
        FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.REGENERATION, 90), 50)
    );

    public static final FoodItemStack HAM_SANDWICH = FoodItemStack.of(
        "GN_HAM_SANDWICH",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Ham Sandwich",
        8,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.REGENERATION, 30)
    );

    public static final FoodItemStack CHICKEN_SALAD_SANDWICH = FoodItemStack.of(
        "GN_CHICKEN_SALAD_SANDWICH",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Chicken Salad Sandwich",
        8,
        1d,
        FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.SPEED, 90), 50)
    );

    public static final FoodItemStack EGG_SALAD_SANDWICH = FoodItemStack.of(
        "GN_EGG_SALAD_SANDWICH",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Egg Salad Sandwich",
        8,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.SPEED, 30)
    );

    public static final FoodItemStack CLUB_SANDWICH = FoodItemStack.of(
        "GN_CLUB_SANDWICH",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Club Sandwich",
        8,
        1d,
        FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 90), 50)
    );

    public static final FoodItemStack ROAST_BEEF_SANDWICH = FoodItemStack.of(
        "GN_ROAST_BEEF_SANDWICH",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Roast Beef Sandwich",
        8,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
    );

    // Salads

    public static final FoodItemStack GREEK_SALAD = FoodItemStack.of(
        "GN_GREEK_SALAD",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Greek Salad",
        5,
        1d,
        new FoodEffect[] {
            FoodEffect.heal(2),
            FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
        }
    );

    public static final FoodItemStack CAESAR_SALAD = FoodItemStack.of(
        "GN_CAESAR_SALAD",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Caesar Salad",
        5,
        1d,
        new FoodEffect[] {
            FoodEffect.heal(2),
            FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
        }
    );

    // Fried

    public static final FoodItemStack PAN_SEARED_SALMON = FoodItemStack.of(
        "GN_PAN_SEARED_SALMON",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Pan-seared Salmon",
        7,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
    );

    public static final FoodItemStack FRIED_SHRIMP = FoodItemStack.of(
        "GN_PAN_SEARED_SALMON",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Fried Shrimp",
        3,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
    );

    public static final FoodItemStack TEMPURA_SHRIMP = FoodItemStack.of(
        "GN_PAN_SEARED_SALMON",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Tempura Shrimp",
        4,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
    );

    public static final FoodItemStack TEMPURA_BROCCOLI = FoodItemStack.of(
        "GN_PAN_SEARED_SALMON",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Tempura Broccoli",
        3,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
    );

    // Pastas

    public static final FoodItemStack CHICKEN_PESTO_PASTA = FoodItemStack.of(
        "GN_CHICKEN_PESTO_PASTA",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Chicken Pesto Pasta",
        8,
        1d,
        FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS)
    );

    public static final FoodItemStack SQUID_INK_PASTA = FoodItemStack.of(
        "GN_SQUID_INK_PASTA",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Squid Ink Pasta",
        6,
        1d
    );

    public static final FoodItemStack CHICKEN_RAVIOLI = FoodItemStack.of(
        "GN_CHICKEN_RAVIOLI",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Chicken Ravioli",
        10,
        1d,
        FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS)
    );

    public static final FoodItemStack MUSHROOM_RAVIOLI = FoodItemStack.of(
        "GN_MUSHROOM_RAVIOLI",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Mushroom Ravioli",
        8,
        1d,
        FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS)
    );

    // Soups and Stews

    public static final FoodItemStack PORRIDGE = FoodItemStack.of(
        "GN_PORRIDGE",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Porridge",
        6,
        1.75,
        new FoodEffect[] {
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.WITHER),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER)
        }
    );

    public static final FoodItemStack CHICKEN_SOUP = FoodItemStack.of(
        "GN_CHICKEN_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Chicken Soup",
        6,
        1.75,
        new FoodEffect[] {
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER)
        }
    );

    public static final FoodItemStack CHICKEN_NOODLE_SOUP = FoodItemStack.of(
        "GN_CHICKEN_NOODLE_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Chicken Noodle Soup",
        8,
        1.75,
        new FoodEffect[] {
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.WITHER),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER)
        }
    );

    public static final FoodItemStack SPLIT_PEA_SOUP = FoodItemStack.of(
        "GN_SPLIT_PEA_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Split Pea Soup",
        6,
        1.75,
        FoodEffect.removePotionEffect(PotionEffectType.CONFUSION)
    );

    public static final FoodItemStack HAM_AND_SPLIT_PEA_SOUP = FoodItemStack.of(
        "GN_HAM_AND_SPLIT_PEA_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Ham and Split Pea Soup",
        8,
        1.75,
        FoodEffect.removePotionEffect(PotionEffectType.CONFUSION)
    );

    public static final FoodItemStack LENTIL_SOUP = FoodItemStack.of(
        "GN_LENTIL_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Lentil Soup",
        8,
        1.75,
        FoodEffect.positivePotionEffect(PotionEffectType.SATURATION, 5)
    );

    public static final FoodItemStack BEEF_AND_LENTIL_SOUP = FoodItemStack.of(
        "GN_BEEF_AND_LENTIL_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Beef and Lentil Soup",
        10,
        1.75,
        FoodEffect.positivePotionEffect(PotionEffectType.SATURATION, 10, 1)
    );

    public static final FoodItemStack CARROT_SOUP = FoodItemStack.of(
        "GN_CARROT_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Carrot Soup",
        8,
        1.75,
        FoodEffect.removePotionEffect(PotionEffectType.BLINDNESS)
    );

    public static final FoodItemStack MUSHROOM_BARLEY_SOUP = FoodItemStack.of(
        "GN_MUSHROOM_BARLEY_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Mushroom Barley Soup",
        8,
        2d,
        FoodEffect.warm(70)
    );

    public static final FoodItemStack CHICKEN_BARLEY_SOUP = FoodItemStack.of(
        "GN_CHICKEN_BARLEY_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Chicken Barley Soup",
        10,
        2d,
        FoodEffect.warm(70)
    );

    public static final FoodItemStack BEEF_BARLEY_SOUP = FoodItemStack.of(
        "GN_BEEF_BARLEY_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Beef Barley Soup",
        12,
        2d,
        FoodEffect.warm(70)
    );

    public static final FoodItemStack CREAM_OF_MUSHROOM_SOUP = FoodItemStack.of(
        "GN_CREAM_OF_MUSHROOM_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Cream of Mushroom Soup",
        7,
        1.75,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack CREAM_OF_CELERY_SOUP = FoodItemStack.of(
        "GN_CREAM_OF_CELERY_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Cream of Celery Soup",
        8,
        1.75,
        FoodEffect.heal(3)
    );

    public static final FoodItemStack CREAM_OF_ASPARAGUS_SOUP = FoodItemStack.of(
        "GN_CREAM_OF_ASPARAGUS_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Cream of Asparagus Soup",
        8,
        1.75,
        FoodEffect.heal(3)
    );

    public static final FoodItemStack CREAM_OF_CAULIFLOWER_SOUP = FoodItemStack.of(
        "GN_CREAM_OF_CAULIFLOWER_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Cream of Cauliflower Soup",
        8,
        1.75,
        FoodEffect.heal(3)
    );

    public static final FoodItemStack MISO_SOUP = FoodItemStack.of(
        "GN_MISO_SOUP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Miso Soup",
        4,
        1.75,
        FoodEffect.warm(50)
    );

    public static final FoodItemStack BROCCOLI_CHOWDER = FoodItemStack.of(
        "GN_BROCCOLI_CHOWDER",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Broccoli Chowder",
        8,
        1.75
    );

    public static final FoodItemStack SALMON_CHOWDER = FoodItemStack.of(
        "GN_SALMON_CHOWDER",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Salmon Chowder",
        10,
        1.75
    );

    public static final FoodItemStack POTATO_CHOWDER = FoodItemStack.of(
        "GN_POTATO_CHOWDER",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Potato Chowder",
        8,
        1.75
    );

    public static final FoodItemStack CORN_CHOWDER = FoodItemStack.of(
        "GN_CORN_CHOWDER",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Corn Chowder",
        8,
        1.75
    );

    public static final FoodItemStack BEEF_STEW = FoodItemStack.of(
        "GN_BEEF_STEW",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Beef Stew",
        10,
        1.75,
        FoodEffect.warm(140)
    );

    public static final FoodItemStack CLAM_STEW = FoodItemStack.of(
        "GN_CLAM_STEW",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Clam Stew",
        6,
        1.75,
        FoodEffect.warm(50)
    );

    public static final FoodItemStack BEET_BORSCHT = FoodItemStack.of(
        "GN_BEET_BORSCHT",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Beet Borscht",
        6,
        1.75
    );

    public static final FoodItemStack CRAB_HOTPOT = FoodItemStack.of(
        "GN_CRAB_HOTPOT",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Crab Hotpot",
        12,
        1.75,
        FoodEffect.warm(140)
    );

    public static final FoodItemStack BBQ_STEAK = FoodItemStack.of(
        "GN_BBQ_STEAK",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "BBQ Steak",
        12,
        1.5
    );

    public static final FoodItemStack BBQ_PORK = FoodItemStack.of(
        "GN_BBQ_PORK",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "BBQ Pork",
        12,
        1.5
    );

    public static final FoodItemStack BBQ_CHICKEN = FoodItemStack.of(
        "GN_BBQ_CHICKEN",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "BBQ Chicken",
        9,
        1.5
    );

    public static final FoodItemStack BBQ_MUTTON = FoodItemStack.of(
        "GN_BBQ_MUTTON",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "BBQ Mutton",
        9,
        1.5
    );

    public static final FoodItemStack BUTTER_CHICKEN = FoodItemStack.of(
        "GN_BUTTER_CHICKEN",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Butter Chicken",
        7,
        1.5,
        FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30)
    );

    public static final FoodItemStack SHRIMP_FRIED_RICE = FoodItemStack.of(
        "GN_SHRIMP_FRIED_RICE",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Shrimp Fried Rice",
        6,
        1d
    );

    public static final FoodItemStack CURRY_RICE = FoodItemStack.of(
        "GN_CURRY_RICE",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Curry Rice",
        4,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30)
    );

    public static final FoodItemStack RICE_OMELETTE = FoodItemStack.of(
        "GN_RICE_OMELETTE",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Rice Omelette",
        4,
        1d,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack RICE_BALLS = FoodItemStack.of(
        "GN_RICE_BALLS",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Rice Balls",
        3,
        1d,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack BEEF_UDON = FoodItemStack.of(
        "GN_BEEF_UDON",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Beef Udon",
        10,
        1d,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack CHICKEN_UDON = FoodItemStack.of(
        "GN_CHICKEN_UDON",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Chicken Udon",
        10,
        1d,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack VEGETABLE_UDON = FoodItemStack.of(
        "GN_VEGETABLE_UDON",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Vegetable Udon",
        10,
        1d,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack STIR_FRY_NOODLES = FoodItemStack.of(
        "GN_STIR_FRY_NOODLES",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljMmRkZjJiZDc0YTQ2NTVlOGYwMTUzYTc0NTNlNjdkYjJhMjFkYmZhYzY3NTY3ODk0ODFhZGJlYzQ4M2EifX19",
        "Stir-fry Noodles",
        8,
        1d
    );
}
