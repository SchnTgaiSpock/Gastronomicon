package io.github.schntgaispock.gastronomicon.core.slimefun;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import io.github.schntgaispock.gastronomicon.core.items.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.core.items.stacks.FoodItemStack;
import io.github.schntgaispock.gastronomicon.core.items.stacks.ThemedItemStack;
import io.github.schntgaispock.gastronomicon.core.items.stacks.GastroTheme.Theme;
import io.github.schntgaispock.gastronomicon.util.item.HeadTextures;
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
        "&7This item is obtained by",
        "&7breaking the displayed",
        "&7blocks."
    );

    public static final ItemStack GUIDE_RECIPE_HARVEST = new CustomItemStack(
        Material.BARREL,
        "&bHarvesting Crops",
        "&7This item is obtained by",
        "&7harvesting the displayed",
        "&7crops."
    );

    public static final ItemStack GUIDE_RECIPE_KILL = new CustomItemStack(
        Material.BARREL,
        "&bKilling Mobs",
        "&7This item is obtained by",
        "&7killing the displayed",
        "&7mobs."
    );

    public static final ItemStack GUIDE_RECIPE_TRAP = new CustomItemStack(
        Material.BARREL,
        "&bTrapping",
        "&7This item is obtained by",
        "&7catching it in the displayed",
        "&7trap."
    );

    public static final ItemStack GUIDE_RECIPE_CULINARY_WORKBENCH = new CustomItemStack(
        Material.CRAFTING_TABLE,
        "&bCulinary Workbench",
        "&7Craft this item as shown in a",
        "&7Culinary Workbench with the tool(s)",
        "&7listed below."
    );

    public static final ItemStack GUIDE_RECIPE_MULTI_STOVE = new CustomItemStack(
        Material.BLAST_FURNACE,
        "&bMulti-Stove",
        "&7Craft this item as shown in a",
        "&7Multi-Stove with the tool(s)",
        "&7listed below."
    );

    public static final ItemStack GUIDE_RECIPE_REFRIDGERATOR = new CustomItemStack(
        Material.IRON_BLOCK,
        "&bRefridgerator",
        "&7Craft this item as shown in a",
        "&7Refridgerator with the tool(s)",
        "&7listed below."
    );

    public static final ItemStack GUIDE_RECIPE_MILL = new CustomItemStack(
        Material.STONE_BRICK_SLAB,
        "&bMill",
        "&7Craft this item as shown in a",
        "&7Grain Mill with the tool(s)",
        "&7listed below."
    );

    public static final ItemStack GUIDE_RECIPE_DISTILLERY = new CustomItemStack(
        Material.BARREL,
        "&bDistillery",
        "&7Craft this item as shown in a",
        "&7Distillery with the tool(s)",
        "&7listed below."
    );

    public static final ItemStack GUIDE_NO_TOOLS_REQUIRED = new CustomItemStack(
        Material.BARRIER,
        "&cNone"
    );

    public static final ItemStack GUIDE_KILL_GOAT = new CustomItemStack(
        Material.GOAT_SPAWN_EGG,
        "&fGoat"
    );

    public static final ItemStack GUIDE_KILL_FROG = new CustomItemStack(
        Material.GOAT_SPAWN_EGG,
        "&fFrog"
    );

    public static final ItemStack GUIDE_KILL_SPIDER = new CustomItemStack(
        Material.GOAT_SPAWN_EGG,
        "&fSpider"
    );

    public static final ItemStack GUIDE_KILL_SALMON = new CustomItemStack(
        Material.SALMON_SPAWN_EGG,
        "&fSalmon"
    );

    public static final ItemStack GUIDE_KILL_GUARDIAN = new CustomItemStack(
        Material.GUARDIAN_SPAWN_EGG,
        "&fGuardian"
    );

    public static final ItemStack GUIDE_KILL_SQUID = new CustomItemStack(
        Material.SQUID_SPAWN_EGG,
        "&fSquid"
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
        Material.PRISMARINE_SHARD,
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
        Material.SALMON,
        "Raw Eel"
    );
    public static final SlimefunItemStack COOKED_EEL = ThemedItemStack.ingredient(
        "GN_COOKED_EEL",
        Material.COOKED_SALMON,
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
        HeadTextures.NONE,
        "PB&J Sandwich",
        8,
        1d,
        FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 90), 50)
    );

    public static final FoodItemStack MARMALADE_SANDWICH = FoodItemStack.of(
        "GN_MARMALADE_SANDWICH",
        HeadTextures.NONE,
        "Marmalade Sandwich",
        8,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30)
    );

    public static final FoodItemStack BAKED_BEAN_SANDWICH = FoodItemStack.of(
        "GN_BAKED_BEAN_SANDWICH",
        HeadTextures.NONE,
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
        HeadTextures.NONE,
        "Tuna Sandwich",
        8,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30)
    );

    public static final FoodItemStack BREAKFAST_SANDWICH = FoodItemStack.of(
        "GN_BREAKFAST_SANDWICH",
        HeadTextures.NONE,
        "Breakfast Sandwich",
        8,
        1d,
        FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.REGENERATION, 90), 50)
    );

    public static final FoodItemStack HAM_SANDWICH = FoodItemStack.of(
        "GN_HAM_SANDWICH",
        HeadTextures.NONE,
        "Ham Sandwich",
        8,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.REGENERATION, 30)
    );

    public static final FoodItemStack CHICKEN_SALAD_SANDWICH = FoodItemStack.of(
        "GN_CHICKEN_SALAD_SANDWICH",
        HeadTextures.NONE,
        "Chicken Salad Sandwich",
        8,
        1d,
        FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.SPEED, 90), 50)
    );

    public static final FoodItemStack EGG_SALAD_SANDWICH = FoodItemStack.of(
        "GN_EGG_SALAD_SANDWICH",
        HeadTextures.NONE,
        "Egg Salad Sandwich",
        8,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.SPEED, 30)
    );

    public static final FoodItemStack CLUB_SANDWICH = FoodItemStack.of(
        "GN_CLUB_SANDWICH",
        HeadTextures.NONE,
        "Club Sandwich",
        8,
        1d,
        FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 90), 50)
    );

    public static final FoodItemStack ROAST_BEEF_SANDWICH = FoodItemStack.of(
        "GN_ROAST_BEEF_SANDWICH",
        HeadTextures.NONE,
        "Roast Beef Sandwich",
        8,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
    );

    // Salads

    public static final FoodItemStack GREEK_SALAD = FoodItemStack.of(
        "GN_GREEK_SALAD",
        HeadTextures.NONE,
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
        HeadTextures.NONE,
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
        HeadTextures.NONE,
        "Pan-seared Salmon",
        7,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
    );

    public static final FoodItemStack FRIED_SHRIMP = FoodItemStack.of(
        "GN_PAN_SEARED_SALMON",
        HeadTextures.NONE,
        "Fried Shrimp",
        3,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
    );

    public static final FoodItemStack TEMPURA_SHRIMP = FoodItemStack.of(
        "GN_PAN_SEARED_SALMON",
        HeadTextures.NONE,
        "Tempura Shrimp",
        4,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
    );

    public static final FoodItemStack TEMPURA_BROCCOLI = FoodItemStack.of(
        "GN_PAN_SEARED_SALMON",
        HeadTextures.NONE,
        "Tempura Broccoli",
        3,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30)
    );

    // Pastas

    public static final FoodItemStack CHICKEN_PESTO_PASTA = FoodItemStack.of(
        "GN_CHICKEN_PESTO_PASTA",
        HeadTextures.NONE,
        "Chicken Pesto Pasta",
        8,
        1d,
        FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS)
    );

    public static final FoodItemStack SQUID_INK_PASTA = FoodItemStack.of(
        "GN_SQUID_INK_PASTA",
        HeadTextures.NONE,
        "Squid Ink Pasta",
        6,
        1d
    );

    public static final FoodItemStack CHICKEN_RAVIOLI = FoodItemStack.of(
        "GN_CHICKEN_RAVIOLI",
        HeadTextures.NONE,
        "Chicken Ravioli",
        10,
        1d,
        FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS)
    );

    public static final FoodItemStack MUSHROOM_RAVIOLI = FoodItemStack.of(
        "GN_MUSHROOM_RAVIOLI",
        HeadTextures.NONE,
        "Mushroom Ravioli",
        8,
        1d,
        FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS)
    );

    // Soups and Stews

    public static final FoodItemStack PORRIDGE = FoodItemStack.of(
        "GN_PORRIDGE",
        HeadTextures.NONE,
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
        HeadTextures.NONE,
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
        HeadTextures.NONE,
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
        HeadTextures.NONE,
        "Split Pea Soup",
        6,
        1.75,
        FoodEffect.removePotionEffect(PotionEffectType.CONFUSION)
    );

    public static final FoodItemStack HAM_AND_SPLIT_PEA_SOUP = FoodItemStack.of(
        "GN_HAM_AND_SPLIT_PEA_SOUP",
        HeadTextures.NONE,
        "Ham and Split Pea Soup",
        8,
        1.75,
        FoodEffect.removePotionEffect(PotionEffectType.CONFUSION)
    );

    public static final FoodItemStack LENTIL_SOUP = FoodItemStack.of(
        "GN_LENTIL_SOUP",
        HeadTextures.NONE,
        "Lentil Soup",
        8,
        1.75,
        FoodEffect.positivePotionEffect(PotionEffectType.SATURATION, 5)
    );

    public static final FoodItemStack BEEF_AND_LENTIL_SOUP = FoodItemStack.of(
        "GN_BEEF_AND_LENTIL_SOUP",
        HeadTextures.NONE,
        "Beef and Lentil Soup",
        10,
        1.75,
        FoodEffect.positivePotionEffect(PotionEffectType.SATURATION, 10, 1)
    );

    public static final FoodItemStack CARROT_SOUP = FoodItemStack.of(
        "GN_CARROT_SOUP",
        HeadTextures.NONE,
        "Carrot Soup",
        8,
        1.75,
        FoodEffect.removePotionEffect(PotionEffectType.BLINDNESS)
    );

    public static final FoodItemStack MUSHROOM_BARLEY_SOUP = FoodItemStack.of(
        "GN_MUSHROOM_BARLEY_SOUP",
        HeadTextures.NONE,
        "Mushroom Barley Soup",
        8,
        2d,
        FoodEffect.warm(70)
    );

    public static final FoodItemStack CHICKEN_BARLEY_SOUP = FoodItemStack.of(
        "GN_CHICKEN_BARLEY_SOUP",
        HeadTextures.NONE,
        "Chicken Barley Soup",
        10,
        2d,
        FoodEffect.warm(70)
    );

    public static final FoodItemStack BEEF_BARLEY_SOUP = FoodItemStack.of(
        "GN_BEEF_BARLEY_SOUP",
        HeadTextures.NONE,
        "Beef Barley Soup",
        12,
        2d,
        FoodEffect.warm(70)
    );

    public static final FoodItemStack CREAM_OF_MUSHROOM_SOUP = FoodItemStack.of(
        "GN_CREAM_OF_MUSHROOM_SOUP",
        HeadTextures.NONE,
        "Cream of Mushroom Soup",
        7,
        1.75,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack CREAM_OF_CELERY_SOUP = FoodItemStack.of(
        "GN_CREAM_OF_CELERY_SOUP",
        HeadTextures.NONE,
        "Cream of Celery Soup",
        8,
        1.75,
        FoodEffect.heal(3)
    );

    public static final FoodItemStack CREAM_OF_ASPARAGUS_SOUP = FoodItemStack.of(
        "GN_CREAM_OF_ASPARAGUS_SOUP",
        HeadTextures.NONE,
        "Cream of Asparagus Soup",
        8,
        1.75,
        FoodEffect.heal(3)
    );

    public static final FoodItemStack CREAM_OF_CAULIFLOWER_SOUP = FoodItemStack.of(
        "GN_CREAM_OF_CAULIFLOWER_SOUP",
        HeadTextures.NONE,
        "Cream of Cauliflower Soup",
        8,
        1.75,
        FoodEffect.heal(3)
    );

    public static final FoodItemStack MISO_SOUP = FoodItemStack.of(
        "GN_MISO_SOUP",
        HeadTextures.NONE,
        "Miso Soup",
        4,
        1.75,
        FoodEffect.warm(50)
    );

    public static final FoodItemStack BROCCOLI_CHOWDER = FoodItemStack.of(
        "GN_BROCCOLI_CHOWDER",
        HeadTextures.NONE,
        "Broccoli Chowder",
        8,
        1.75
    );

    public static final FoodItemStack SALMON_CHOWDER = FoodItemStack.of(
        "GN_SALMON_CHOWDER",
        HeadTextures.NONE,
        "Salmon Chowder",
        10,
        1.75
    );

    public static final FoodItemStack POTATO_CHOWDER = FoodItemStack.of(
        "GN_POTATO_CHOWDER",
        HeadTextures.NONE,
        "Potato Chowder",
        8,
        1.75
    );

    public static final FoodItemStack CORN_CHOWDER = FoodItemStack.of(
        "GN_CORN_CHOWDER",
        HeadTextures.NONE,
        "Corn Chowder",
        8,
        1.75
    );

    public static final FoodItemStack BEEF_STEW = FoodItemStack.of(
        "GN_BEEF_STEW",
        HeadTextures.NONE,
        "Beef Stew",
        10,
        1.75,
        FoodEffect.warm(140)
    );

    public static final FoodItemStack CLAM_STEW = FoodItemStack.of(
        "GN_CLAM_STEW",
        HeadTextures.NONE,
        "Clam Stew",
        6,
        1.75,
        FoodEffect.warm(50)
    );

    public static final FoodItemStack BEET_BORSCHT = FoodItemStack.of(
        "GN_BEET_BORSCHT",
        HeadTextures.NONE,
        "Beet Borscht",
        6,
        1.75
    );

    public static final FoodItemStack CRAB_HOTPOT = FoodItemStack.of(
        "GN_CRAB_HOTPOT",
        HeadTextures.NONE,
        "Crab Hotpot",
        12,
        1.75,
        FoodEffect.warm(140)
    );

    public static final FoodItemStack BBQ_STEAK = FoodItemStack.of(
        "GN_BBQ_STEAK",
        HeadTextures.NONE,
        "BBQ Steak",
        12,
        1.5
    );

    public static final FoodItemStack BBQ_PORK = FoodItemStack.of(
        "GN_BBQ_PORK",
        HeadTextures.NONE,
        "BBQ Pork",
        12,
        1.5
    );

    public static final FoodItemStack BBQ_CHICKEN = FoodItemStack.of(
        "GN_BBQ_CHICKEN",
        HeadTextures.NONE,
        "BBQ Chicken",
        9,
        1.5
    );

    public static final FoodItemStack BBQ_MUTTON = FoodItemStack.of(
        "GN_BBQ_MUTTON",
        HeadTextures.NONE,
        "BBQ Mutton",
        9,
        1.5
    );

    public static final FoodItemStack BUTTER_CHICKEN = FoodItemStack.of(
        "GN_BUTTER_CHICKEN",
        HeadTextures.NONE,
        "Butter Chicken",
        7,
        1.5,
        FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30)
    );

    public static final FoodItemStack SHRIMP_FRIED_RICE = FoodItemStack.of(
        "GN_SHRIMP_FRIED_RICE",
        HeadTextures.NONE,
        "Shrimp Fried Rice",
        6,
        1d
    );

    public static final FoodItemStack CURRY_RICE = FoodItemStack.of(
        "GN_CURRY_RICE",
        HeadTextures.NONE,
        "Curry Rice",
        4,
        1d,
        FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30)
    );

    public static final FoodItemStack RICE_OMELETTE = FoodItemStack.of(
        "GN_RICE_OMELETTE",
        HeadTextures.NONE,
        "Rice Omelette",
        4,
        1d,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack RICE_BALLS = FoodItemStack.of(
        "GN_RICE_BALLS",
        HeadTextures.RICE_BALLS,
        "Rice Balls",
        3,
        1d,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack BEEF_UDON = FoodItemStack.of(
        "GN_BEEF_UDON",
        HeadTextures.NONE,
        "Beef Udon",
        10,
        1d,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack CHICKEN_UDON = FoodItemStack.of(
        "GN_CHICKEN_UDON",
        HeadTextures.NONE,
        "Chicken Udon",
        10,
        1d,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack VEGETABLE_UDON = FoodItemStack.of(
        "GN_VEGETABLE_UDON",
        HeadTextures.NONE,
        "Vegetable Udon",
        10,
        1d,
        FoodEffect.heal(2)
    );

    public static final FoodItemStack STIR_FRY_NOODLES = FoodItemStack.of(
        "GN_STIR_FRY_NOODLES",
        HeadTextures.NONE,
        "Stir-fry Noodles",
        8,
        1d
    );
}
