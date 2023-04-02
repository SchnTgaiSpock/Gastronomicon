package io.github.schntgaispock.gastronomicon.core.slimefun;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import io.github.schntgaispock.gastronomicon.api.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.api.items.FoodItemStack;
import io.github.schntgaispock.gastronomicon.api.items.FoodItemStackBuilder;
import io.github.schntgaispock.gastronomicon.api.items.GastroTheme;
import io.github.schntgaispock.gastronomicon.api.items.ThemedItemStack;
import io.github.schntgaispock.gastronomicon.core.listeners.WildHarvestListener;
import io.github.schntgaispock.gastronomicon.util.StringUtil;
import io.github.schntgaispock.gastronomicon.util.item.HeadTextures;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;

@UtilityClass
@SuppressWarnings("deprecation")
public class GastroStacks {

    // ---- Utility ----

    public static final ItemStack WATER_BOTTLE = new ItemStack(Material.POTION);
    static {
        final PotionMeta meta = (PotionMeta) WATER_BOTTLE.getItemMeta();
        final PotionData data = new PotionData(PotionType.WATER);
        meta.setBasePotionData(data);
        WATER_BOTTLE.setItemMeta(meta);
    }

    // ---- Guide Only Items ----

    public static final ItemStack GUIDE_ITEM_TOOLS = new CustomItemStack(
        Material.IRON_HOE,
        GastroTheme.TOOL.getColor() + "Tools");

    public static final ItemStack GUIDE_ITEM_BASIC_MACHINES = new CustomItemStack(
        Material.CRAFTING_TABLE,
        GastroTheme.MECHANICAL.getColor() + "Basic Machines");

    public static final ItemStack GUIDE_ITEM_ELECTRIC_MACHINES = new CustomItemStack(
        Material.CRAFTING_TABLE,
        GastroTheme.MECHANICAL.getColor() + "Electric Machines");

    public static final ItemStack GUIDE_ITEM_RAW_INGREDIENTS = new CustomItemStack(
        Material.SUGAR,
        GastroTheme.INGREDIENT.getColor() + "Raw Ingredients");

    public static final ItemStack GUIDE_ITEM_FOOD = new CustomItemStack(
        Material.COOKED_BEEF,
        GastroTheme.REGULAR_FOOD.getColor() + "Food");

    public static final ItemStack GUIDE_ITEM_MAIN = new CustomItemStack(
        Material.COOKED_BEEF,
        GastroTheme.PERFECT_FOOD.getColor() + "Gastronomicon");

    public static final ItemStack GUIDE_RECIPE_BREAK = new CustomItemStack(
        Material.BARREL,
        "&bBreaking Blocks",
        "&7This item is obtained by",
        "&7breaking the displayed",
        "&7blocks.");

    public static final ItemStack GUIDE_RECIPE_HARVEST = new CustomItemStack(
        Material.BARREL,
        "&bHarvesting Crops",
        "&7This item is obtained by",
        "&7harvesting the displayed",
        "&7crops.");

    public static final ItemStack GUIDE_RECIPE_KILL = new CustomItemStack(
        Material.BARREL,
        "&bKilling Mobs",
        "&7This item is obtained by",
        "&7killing the displayed",
        "&7mobs.");

    public static final ItemStack GUIDE_RECIPE_TRAP = new CustomItemStack(
        Material.BARREL,
        "&bTrapping",
        "&7This item is obtained by",
        "&7catching it in the displayed",
        "&7trap.");

    public static final ItemStack GUIDE_RECIPE_CULINARY_WORKBENCH = new CustomItemStack(
        Material.CRAFTING_TABLE,
        "&bCulinary Workbench",
        "&7Craft this item as shown in a",
        "&7Culinary Workbench with the tool(s)",
        "&7listed below.");

    public static final ItemStack GUIDE_RECIPE_MULTI_STOVE = new CustomItemStack(
        Material.BLAST_FURNACE,
        "&bMulti-Stove",
        "&7Craft this item as shown in a",
        "&7Multi-Stove with the tool(s)",
        "&7listed below.");

    public static final ItemStack GUIDE_RECIPE_REFRIDGERATOR = new CustomItemStack(
        Material.IRON_BLOCK,
        "&bRefridgerator",
        "&7Craft this item as shown in a",
        "&7Refridgerator with the tool(s)",
        "&7listed below.");

    public static final ItemStack GUIDE_RECIPE_MILL = new CustomItemStack(
        Material.CAULDRON,
        "&bMill",
        "&7Craft this item as shown in a",
        "&7Grain Mill with the tool(s)",
        "&7listed below.");

    public static final ItemStack GUIDE_RECIPE_FERMENTER = new CustomItemStack(
        Material.BARREL,
        "&bFermenter",
        "&7Craft this item as shown in a",
        "&7Fermenter with the tool(s)",
        "&7listed below.");

    public static final ItemStack GUIDE_TOOLS_REQUIRED = new CustomItemStack(
        Material.BLACK_STAINED_GLASS_PANE,
        ChatColor.of("#999999") + "Tools Required");

    public static final ItemStack GUIDE_CONTAINER_REQUIRED = new CustomItemStack(
        Material.PURPLE_STAINED_GLASS_PANE,
        "&5Container Required");

    public static final ItemStack GUIDE_NONE = new CustomItemStack(
        Material.BARRIER,
        "&cNone");

    public static final ItemStack GUIDE_KILL_GOAT = new CustomItemStack(
        Material.GOAT_SPAWN_EGG,
        "&fGoat");

    public static final ItemStack GUIDE_KILL_SALMON = new CustomItemStack(
        Material.SALMON_SPAWN_EGG,
        "&fSalmon");

    public static final ItemStack GUIDE_KILL_GUARDIAN = new CustomItemStack(
        Material.GUARDIAN_SPAWN_EGG,
        "&fGuardian");

    public static final ItemStack GUIDE_KILL_SQUID = new CustomItemStack(
        Material.SQUID_SPAWN_EGG,
        "&fSquid");

    // ---- Menu Only ----

    public static final ItemStack MENU_BACKGROUND_ITEM = new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "");
    public static final ItemStack MENU_INGREDIENT_BORDER = new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE,
        "&9Ingredients");
    public static final ItemStack MENU_CONTAINER_BORDER = new CustomItemStack(Material.PURPLE_STAINED_GLASS_PANE,
        "&5Container");
    public static final ItemStack MENU_TOOL_BORDER = new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE,
        ChatColor.of("#999999") + "Tools");
    public static final ItemStack MENU_OUTPUT_BORDER = new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE,
        "&6Output");
    public static final ItemStack MENU_CRAFT_BUTTON = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
        "&aClick to craft");
    public static final ItemStack MENU_PROGRESS_BAR = new ItemStack(Material.FLINT_AND_STEEL);
    public static final ItemStack MENU_FOOD_BORDER = new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE,
        "&fFood Slot", "", "&7Place food in the slot below");
    public static final ItemStack MENU_TRAIN_BUTTON = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
        "&aClick to train");
    public static final ItemStack MENU_INPUT_BORDER = new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE,
        "&9Input");
    public static final ItemStack MENU_ANDROID_BORDER = new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE,
        "&3Android");
    public static final ItemStack MENU_NOT_ENOUGH_ENERGY = new CustomItemStack(Material.RED_STAINED_GLASS_PANE,
        "&cNot enough energy");
    public static final ItemStack MENU_NO_ANDROID = new CustomItemStack(Material.RED_STAINED_GLASS_PANE,
        "&3No android detected");
    public static final ItemStack MENU_INCORRECT_RECIPE = new CustomItemStack(Material.RED_STAINED_GLASS_PANE,
        "&3Not enough ingredients");
    public static final ItemStack MENU_NO_WATER_ABOVE = new CustomItemStack(Material.RED_STAINED_GLASS_PANE,
        "&3No water above");

    // ---- Dummy ----

    public static final ItemStack DUMMY_FISHING_NET = new CustomItemStack(Material.IRON_BARS, GastroTheme.ELECTRIC.getColor() + "Fishing Net");

    // ---- Tools ----

    // -- Workstation Tools --

    // Culinary Workbench

    public static final SlimefunItemStack CUTTING_BOARD = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_CUTTING_BOARD",
        Material.OAK_PRESSURE_PLATE,
        "Cutting Board");

    public static final SlimefunItemStack MEAT_SCISSORS = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_MEAT_SCISSORS",
        Material.SHEARS,
        "Meat Scissors");

    public static final SlimefunItemStack KITCHEN_KNIFE = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_KITCHEN_KNIFE",
        Material.IRON_SWORD,
        "Kitchen Knife").addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack ROLLING_PIN = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_ROLLING_PIN",
        Material.STICK,
        "Rolling Pin");

    public static final SlimefunItemStack BLENDER = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_BLENDER",
        Material.BUCKET,
        "Blender");

    public static final SlimefunItemStack MORTAR_AND_PESTLE = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_MORTAR_AND_PESTLE",
        Material.BOWL,
        "Mortar and Pestle");

    public static final SlimefunItemStack PEELER = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_PEELER",
        Material.IRON_HOE,
        "Peeler").addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack WHISK = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_WHISK",
        Material.IRON_SHOVEL,
        "Whisk").addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack DISTILLATION_CHAMBER = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_DISTILLATION_CHAMBER",
        Material.CAULDRON,
        "Distillation Chamber");

    // Enhanced Oven

    public static final SlimefunItemStack BAKING_TRAY = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_BAKING_TRAY",
        Material.LIGHT_GRAY_CARPET,
        "Baking Tray");

    public static final SlimefunItemStack FRYING_PAN = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_FRYING_PAN",
        Material.GRAY_CARPET,
        "Frying Pan");

    public static final SlimefunItemStack STEEL_POT = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_STEEL_POT",
        Material.CAULDRON,
        "Steel Pot");

    // -- Containers --

    public static final SlimefunItemStack STEEL_BOWL = ThemedItemStack.of(
        GastroTheme.WTOOL,
        "GN_STEEL_BOWL",
        Material.BUCKET,
        "Steel Bowl");

    // -- Traps --

    public static final SlimefunItemStack STEEL_WIRE = ThemedItemStack.of(
        GastroTheme.TRAP,
        "GN_STEEL_WIRE",
        Material.STRING,
        "Steel Wire");

    public static final SlimefunItemStack STEEL_SPRING = ThemedItemStack.of(
        GastroTheme.TRAP,
        "GN_STEEL_SPRING",
        Material.STRING,
        "Steel Spring");

    public static final SlimefunItemStack CRAB_TRAP = ThemedItemStack.of(
        GastroTheme.TRAP,
        "GN_CRAB_TRAP",
        Material.OAK_TRAPDOOR,
        "Crab Trap");

    public static final SlimefunItemStack HUNTING_TRAP = ThemedItemStack.of(
        GastroTheme.TRAP,
        "GN_HUNTING_TRAP",
        Material.IRON_TRAPDOOR,
        "Hunting Trap");

    // -- Other --

    public static final SlimefunItemStack WOODEN_SICKLE = ThemedItemStack.of(
        GastroTheme.TOOL,
        "GN_WOODEN_SICKLE",
        Material.WOODEN_HOE,
        "Wooden Sickle");

    public static final SlimefunItemStack STEEL_SICKLE = ThemedItemStack.of(
        GastroTheme.TOOL,
        "GN_STEEL_SICKLE",
        Material.IRON_HOE,
        "Steel Sickle");

    public static final SlimefunItemStack REINFORCED_SICKLE = ThemedItemStack.of(
        GastroTheme.TOOL,
        "GN_REINFORCED_SICKLE",
        Material.NETHERITE_HOE,
        "Reinforced Sickle");

    // ---- Basic Machines ----

    public static final SlimefunItemStack CULINARY_WORKBENCH = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_CULINARY_WORKBENCH",
        Material.CRAFTING_TABLE,
        "Culinary Workbench");

    public static final SlimefunItemStack MULTI_STOVE = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_MULTI_STOVE",
        Material.BLAST_FURNACE,
        "Multi-Stove",
        LoreBuilder.powerBuffer(1024),
        LoreBuilder.power(64, "/Craft"));

    public static final SlimefunItemStack REFRIDGERATOR = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_REFRIDGERATOR",
        Material.IRON_BLOCK,
        "Refridgerator",
        LoreBuilder.powerBuffer(1024),
        LoreBuilder.power(64, "/Craft"));

    public static final SlimefunItemStack MILL = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_MILL",
        Material.CAULDRON,
        "Grain Mill");

    public static final SlimefunItemStack FERMENTER = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_FERMENTER",
        Material.BARREL,
        "Fermenter",
        StringUtil.waterUsed(2000, " Buffer"),
        StringUtil.waterUsed(125, "/Craft"));

    public static final SlimefunItemStack LARGE_FERMENTER = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_LARGE_FERMENTER",
        Material.BARREL,
        "Large Fermenter",
        StringUtil.waterUsed(16000, " Buffer"),
        StringUtil.waterUsed(125, "/Craft"));

    public static final SlimefunItemStack CHEF_ANDROID = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_CHEF_ANDROID",
        HeadTexture.PROGRAMMABLE_ANDROID_BUTCHER.getTexture(),
        "Chef Android");

    public static final SlimefunItemStack CHEF_ANDROID_TRAINER = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_CHEF_ANDROID_TRAINER",
        Material.SMITHING_TABLE,
        "Chef Android Trainer");

    public static final SlimefunItemStack FISHING_NET_I = ThemedItemStack.of(
        GastroTheme.ELECTRIC,
        "GN_FISHING_NET_I",
        Material.IRON_BARS,
        "Fishing Net",
        LoreBuilder.speed(1));

    public static final SlimefunItemStack FISHING_NET_II = ThemedItemStack.of(
        GastroTheme.ELECTRIC,
        "GN_FISHING_NET_II",
        Material.IRON_BARS,
        "Fishing Net",
        LoreBuilder.speed(2));

    public static final SlimefunItemStack FISHING_NET_III = ThemedItemStack.of(
        GastroTheme.ELECTRIC,
        "GN_FISHING_NET_III",
        Material.IRON_BARS,
        "Fishing Net",
        LoreBuilder.speed(4));

    public static final SlimefunItemStack ELECTRIC_KITCHEN_I = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_ELECTRIC_KITCHEN_I",
        Material.FURNACE,
        "Electric Kitchen",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(16),
        LoreBuilder.speed(1));

    public static final SlimefunItemStack ELECTRIC_KITCHEN_II = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_ELECTRIC_KITCHEN_II",
        Material.FURNACE,
        "Electric Kitchen &7- &eII  ",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.powerBuffer(1024),
        LoreBuilder.powerPerSecond(64),
        LoreBuilder.speed(3));

    public static final SlimefunItemStack ELECTRIC_KITCHEN_III = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_ELECTRIC_KITCHEN_III",
        Material.FURNACE,
        "Electric Kitchen &7- &eIII",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.powerBuffer(4096),
        LoreBuilder.powerPerSecond(256),
        LoreBuilder.speed(10));

    // ---- Raw Ingredients ----

    // -- Crops --

    public static final SlimefunItemStack RICE = ThemedItemStack.ingredient(
        "GN_RICE",
        Material.PUMPKIN_SEEDS,
        "Rice");

    public static final SlimefunItemStack QUINOA = ThemedItemStack.ingredient(
        "GN_QUINOA",
        Material.PUMPKIN_SEEDS,
        "Quinoa");

    public static final SlimefunItemStack OATS = ThemedItemStack.ingredient(
        "GN_OATS",
        Material.BEETROOT_SEEDS,
        "Oats");

    public static final SlimefunItemStack SOYBEANS = ThemedItemStack.ingredient(
        "GN_SOYBEANS",
        Material.BEETROOT_SEEDS,
        "Soybeans");

    public static final SlimefunItemStack BARLEY = ThemedItemStack.ingredient(
        "GN_BARLEY",
        Material.WHEAT,
        "Barley");

    public static final SlimefunItemStack BARLEY_SEEDS = ThemedItemStack.ingredient(
        "GN_BARLEY_SEEDS",
        Material.WHEAT_SEEDS,
        "Barley Seeds");

    public static final SlimefunItemStack RYE = ThemedItemStack.ingredient(
        "GN_RYE",
        Material.WHEAT,
        "Rye");

    public static final SlimefunItemStack RYE_SEEDS = ThemedItemStack.ingredient(
        "GN_RYE_SEEDS",
        Material.PUMPKIN_SEEDS,
        "Rye Seeds");

    public static final SlimefunItemStack SORGHUM = ThemedItemStack.ingredient(
        "GN_SORGHUM",
        Material.WHEAT,
        "Sorghum");

    public static final SlimefunItemStack SORGHUM_SEEDS = ThemedItemStack.ingredient(
        "GN_SORGHUM_SEEDS",
        Material.BEETROOT_SEEDS,
        "Sorghum Seeds");

    public static final SlimefunItemStack TURNIP = ThemedItemStack.ingredient(
        "GN_TURNIP",
        Material.BEETROOT,
        "Turnip");

    public static final SlimefunItemStack TURNIP_SEEDS = ThemedItemStack.ingredient(
        "GN_TURNIP_SEEDS",
        Material.MELON_SEEDS,
        "Turnip Seeds");

    public static final SlimefunItemStack SQUASH = ThemedItemStack.ingredient(
        "GN_SQUASH",
        Material.MELON,
        "Squash");

    public static final SlimefunItemStack SQUASH_SEEDS = ThemedItemStack.ingredient(
        "GN_SQUASH_SEEDS",
        Material.PUMPKIN_SEEDS,
        "Squash Seeds");

    public static final SlimefunItemStack CELERY = ThemedItemStack.ingredient(
        "GN_CELERY",
        Material.SUGAR_CANE,
        "Celery");

    public static final SlimefunItemStack BOK_CHOY = ThemedItemStack.ingredient(
        "GN_BOK_CHOY",
        Material.MANGROVE_PROPAGULE,
        "Bok Choy");

    public static final SlimefunItemStack BROCCOLI = ThemedItemStack.ingredient(
        "GN_BROCCOLI",
        Material.OAK_SAPLING,
        "Broccoli");

    public static final SlimefunItemStack CUCUMBER = ThemedItemStack.ingredient(
        "GN_CUCUMBER",
        Material.SEA_PICKLE,
        "Cucumber");
    public static final SlimefunItemStack BASIL = ThemedItemStack.ingredient(
        "GN_BASIL",
        Material.KELP,
        "Basil");

    public static final SlimefunItemStack SPINACH = ThemedItemStack.ingredient(
        "GN_SPINACH",
        Material.BIG_DRIPLEAF,
        "Spinach");

    public static final SlimefunItemStack BRUSSLES_SPROUTS = ThemedItemStack.ingredient(
        "GN_BRUSSLES_SPROUTS",
        Material.SMALL_DRIPLEAF,
        "Brussles Sprouts");

    public static final SlimefunItemStack MINT = ThemedItemStack.ingredient(
        "GN_MINT",
        Material.FERN,
        "Mint");

    public static final SlimefunItemStack CHILI_PEPPER = ThemedItemStack.ingredient(
        "GN_CHILI_PEPPER",
        Material.RED_CANDLE,
        "Chili Pepper");

    public static final SlimefunItemStack PARSLEY = ThemedItemStack.ingredient(
        "GN_PARSLEY",
        Material.SMALL_DRIPLEAF,
        "Parsley");

    public static final SlimefunItemStack CASSAVA = ThemedItemStack.ingredient(
        "GN_CASSAVA",
        Material.CARROT,
        "Cassava");

    public static final SlimefunItemStack LENTILS = ThemedItemStack.ingredient(
        "GN_LENTILS",
        Material.PUMPKIN_SEEDS,
        "Lentils");

    public static final SlimefunItemStack PEANUTS = ThemedItemStack.ingredient(
        "GN_PEANUTS",
        Material.PUMPKIN_SEEDS,
        "Peanuts");

    public static final SlimefunItemStack BEANS = ThemedItemStack.ingredient(
        "GN_BEANS",
        Material.BEETROOT_SEEDS,
        "Beans");

    public static final SlimefunItemStack PEAS = ThemedItemStack.ingredient(
        "GN_PEAS",
        Material.WHEAT_SEEDS,
        "Peas");

    public static final SlimefunItemStack ASPARAGUS = ThemedItemStack.ingredient(
        "GN_ASPARAGUS",
        Material.BAMBOO,
        "Asparagus");

    public static final SlimefunItemStack GREEN_ONION = ThemedItemStack.ingredient(
        "GN_GREEN_ONION",
        Material.MANGROVE_PROPAGULE,
        "Green Onion");

    public static final SlimefunItemStack CAULIFLOWER = ThemedItemStack.ingredient(
        "GN_CAULIFLOWER",
        Material.BIRCH_SAPLING,
        "Cauliflower");

    public static final SlimefunItemStack AVOCADO = ThemedItemStack.ingredient(
        "GN_AVOCADO",
        Material.LIME_DYE,
        "Avocado");

    public static final SlimefunItemStack AVOCADO_PIT = ThemedItemStack.ingredient(
        "GN_AVOCADO_PIT",
        Material.DARK_OAK_BUTTON,
        "Avocado Pit");

    public static final SlimefunItemStack TURMERIC = ThemedItemStack.ingredient(
        "GN_TURMERIC",
        Material.POTATO,
        "Turmeric");

    public static final SlimefunItemStack CUMIN_SEEDS = ThemedItemStack.ingredient(
        "GN_CUMIN_SEEDS",
        Material.PUMPKIN_SEEDS,
        "Cumin Seeds");

    public static final SlimefunItemStack RED_BEANS = ThemedItemStack.ingredient(
        "GN_RED_BEANS",
        Material.COCOA_BEANS,
        "Red Beans");

    public static final SlimefunItemStack CANTALOUPE = ThemedItemStack.ingredient(
        "GN_CANTALOUPE",
        Material.MELON,
        "Cantaloupe");

    public static final SlimefunItemStack CANTALOUPE_SEEDS = ThemedItemStack.ingredient(
        "GN_CANTALOUPE_SEEDS",
        Material.PUMPKIN_SEEDS,
        "Cantaloupe Seeds");

    public static final SlimefunItemStack HONEYDEW_MELON = ThemedItemStack.ingredient(
        "GN_HONEYDEW_MELON",
        Material.MELON,
        "Honeydew Melon");

    public static final SlimefunItemStack HONEYDEW_MELON_SEEDS = ThemedItemStack.ingredient(
        "GN_HONEYDEW_MELON_SEEDS",
        Material.PUMPKIN_SEEDS,
        "Honeydew Melon Seeds");

    public static final SlimefunItemStack SESAME_SEEDS = ThemedItemStack.ingredient(
        "GN_SESAME_SEEDS",
        Material.PUMPKIN_SEEDS,
        "Sesame Seeds");

    // -- Grown from trees --

    public static final SlimefunItemStack LYCHEE = ThemedItemStack.ingredient(
        "GN_LYCHEE",
        Material.BEETROOT,
        "Lychee");
    public static final SlimefunItemStack LYCHEE_SAPLING = ThemedItemStack.ingredient(
        "GN_LYCHEE_SAPLING",
        Material.OAK_SAPLING,
        "Lychee Sapling");
    public static final SlimefunItemStack BANANA = ThemedItemStack.ingredient(
        "GN_BANANA",
        Material.YELLOW_DYE,
        "Banana");
    public static final SlimefunItemStack BANANA_SAPLING = ThemedItemStack.ingredient(
        "GN_BANANA_SAPLING",
        Material.OAK_SAPLING,
        "Banana Sapling");
    public static final SlimefunItemStack VANILLA_BEANS = ThemedItemStack.ingredient(
        "GN_VANILLA_BEANS",
        Material.COCOA_BEANS,
        "Vanilla Beans");
    public static final SlimefunItemStack VANILLA_SAPLING = ThemedItemStack.ingredient(
        "GN_VANILLA_SAPLING",
        Material.OAK_SAPLING,
        "Vanilla Sapling");

    // -- Harvested --

    public static final SlimefunItemStack FIDDLEHEADS = ThemedItemStack.ingredient(
        "GN_FIDDLEHEADS",
        Material.FERN,
        "Fiddleheads");

    public static final SlimefunItemStack TRUFFLE = ThemedItemStack.ingredient(
        "GN_TRUFFLE",
        Material.BROWN_MUSHROOM,
        "Truffle");

    public static final SlimefunItemStack ENOKI_MUSHROOMS = ThemedItemStack.ingredient(
        "GN_ENOKI_MUSHROOMS",
        Material.BROWN_MUSHROOM,
        "Enoki Mushrooms");

    public static final SlimefunItemStack KING_OYSTER_MUSHROOM = ThemedItemStack.ingredient(
        "GN_KING_OYSTER_MUSHROOM",
        Material.BROWN_MUSHROOM,
        "King Oyster Mushroom");

    public static final SlimefunItemStack BUTTON_MUSHROOM = ThemedItemStack.ingredient(
        "GN_BUTTON_MUSHROOM",
        Material.BROWN_MUSHROOM,
        "Button Mushroom");

    public static final SlimefunItemStack CLAM = ThemedItemStack.ingredient(
        "GN_CLAM",
        Material.NAUTILUS_SHELL,
        "Clam");

    // -- Dropped from mobs --

    public static final SlimefunItemStack RAW_CHEVON = ThemedItemStack.ingredient(
        "GN_RAW_CHEVON",
        Material.MUTTON,
        "Raw Chevon");

    public static final SlimefunItemStack COOKED_CHEVON = ThemedItemStack.ingredient(
        "GN_COOKED_CHEVON",
        Material.COOKED_MUTTON,
        "Cooked Chevon");

    public static final SlimefunItemStack SALMON_ROE = ThemedItemStack.ingredient(
        "GN_SALMON_ROE",
        Material.PUMPKIN_SEEDS,
        "Salmon Roe");

    public static final SlimefunItemStack GUARDIAN_FIN = ThemedItemStack.ingredient(
        "GN_GUARDIAN_FIN",
        Material.PRISMARINE_SHARD,
        "Guardian Fin");

    public static final SlimefunItemStack RAW_SQUID = ThemedItemStack.ingredient(
        "GN_RAW_SQUID",
        Material.PORKCHOP,
        "Raw Squid");

    public static final SlimefunItemStack COOKED_SQUID = ThemedItemStack.ingredient(
        "GN_COOKED_SQUID",
        Material.COOKED_PORKCHOP,
        "Cooked Squid");

    // -- From fishing --

    public static final SlimefunItemStack RAW_MACKEREL = ThemedItemStack.ingredient(
        "GN_RAW_MACKEREL",
        Material.COD,
        "Raw Mackerel");
    public static final SlimefunItemStack COOKED_MACKEREL = ThemedItemStack.ingredient(
        "GN_COOKED_MACKEREL",
        Material.COOKED_COD,
        "Cooked Mackerel");

    public static final SlimefunItemStack RAW_EEL = ThemedItemStack.ingredient(
        "GN_RAW_EEL",
        Material.SALMON,
        "Raw Eel");
    public static final SlimefunItemStack COOKED_EEL = ThemedItemStack.ingredient(
        "GN_COOKED_EEL",
        Material.COOKED_SALMON,
        "Cooked Eel");

    public static final SlimefunItemStack RAW_TROUT = ThemedItemStack.ingredient(
        "GN_RAW_TROUT",
        Material.COD,
        "Raw Trout");
    public static final SlimefunItemStack COOKED_TROUT = ThemedItemStack.ingredient(
        "GN_COOKED_TROUT",
        Material.COOKED_COD,
        "Cooked Trout");

    public static final SlimefunItemStack RAW_BASS = ThemedItemStack.ingredient(
        "GN_RAW_BASS",
        Material.COD,
        "Raw Bass");
    public static final SlimefunItemStack COOKED_BASS = ThemedItemStack.ingredient(
        "GN_COOKED_BASS",
        Material.COOKED_COD,
        "Cooked Bass");

    public static final SlimefunItemStack RAW_CARP = ThemedItemStack.ingredient(
        "GN_RAW_CARP",
        Material.COD,
        "Raw Carp");
    public static final SlimefunItemStack COOKED_CARP = ThemedItemStack.ingredient(
        "GN_COOKED_CARP",
        Material.COOKED_COD,
        "Cooked Carp");

    public static final SlimefunItemStack RAW_PIKE = ThemedItemStack.ingredient(
        "GN_RAW_PIKE",
        Material.COD,
        "Raw Pike");
    public static final SlimefunItemStack COOKED_PIKE = ThemedItemStack.ingredient(
        "GN_COOKED_PIKE",
        Material.COOKED_COD,
        "Cooked Pike");

    public static final SlimefunItemStack RAW_TUNA = ThemedItemStack.ingredient(
        "GN_RAW_TUNA",
        Material.COD,
        "Raw Pike");

    public static final SlimefunItemStack COOKED_TUNA = ThemedItemStack.ingredient(
        "GN_COOKED_TUNA",
        Material.COOKED_COD,
        "Cooked Tuna");

    public static final SlimefunItemStack SHRIMP = ThemedItemStack.ingredient(
        "GN_SHRIMP",
        Material.COD,
        "Shrimp");

    static {
        WildHarvestListener.registerDrops(
            Material.GRASS,
            RICE, QUINOA, OATS, SOYBEANS, BARLEY_SEEDS, RYE_SEEDS, SORGHUM_SEEDS, TURNIP_SEEDS, SQUASH_SEEDS,
            CELERY, BOK_CHOY, BROCCOLI, CUCUMBER, BASIL, SPINACH,
            BRUSSLES_SPROUTS, MINT, CHILI_PEPPER, PARSLEY, CASSAVA, LENTILS, PEANUTS, BEANS, PEAS, ASPARAGUS,
            GREEN_ONION, CAULIFLOWER, AVOCADO_PIT, TURMERIC, CUMIN_SEEDS, LYCHEE_SAPLING,
            BANANA_SAPLING, VANILLA_SAPLING, RED_BEANS, CANTALOUPE_SEEDS, HONEYDEW_MELON_SEEDS, SESAME_SEEDS);

        WildHarvestListener.registerDrops(
            Material.FERN,
            FIDDLEHEADS, CELERY, BOK_CHOY, BROCCOLI, CUCUMBER, BASIL, SPINACH,
            BRUSSLES_SPROUTS, MINT, PARSLEY, LENTILS, PEAS, ASPARAGUS, GREEN_ONION, CAULIFLOWER);

        WildHarvestListener.registerDrops(
            Material.PODZOL,
            TRUFFLE, ENOKI_MUSHROOMS, KING_OYSTER_MUSHROOM, BUTTON_MUSHROOM);

        WildHarvestListener.registerDrops(
            Material.MYCELIUM,
            TRUFFLE, ENOKI_MUSHROOMS, KING_OYSTER_MUSHROOM, BUTTON_MUSHROOM);

        WildHarvestListener.registerDrops(
            Material.SEAGRASS, CLAM);

        WildHarvestListener.registerDrops(EntityType.GOAT, RAW_CHEVON);
        WildHarvestListener.registerDrops(EntityType.SALMON, SALMON_ROE);
        WildHarvestListener.registerDrops(EntityType.GUARDIAN, GUARDIAN_FIN);
        WildHarvestListener.registerDrops(EntityType.ELDER_GUARDIAN, GUARDIAN_FIN);
        WildHarvestListener.registerDrops(EntityType.SQUID, RAW_SQUID);
        WildHarvestListener.registerDrops(EntityType.GLOW_SQUID, RAW_SQUID);

        // WildHarvestListener.registerFishingDrops(Material.COD, RAW_MACKEREL, RAW_EEL,
        // RAW_TROUT, SHRIMP);
        // WildHarvestListener.registerFishingDrops(Material.SALMON, RAW_BASS, RAW_CARP,
        // RAW_PIKE, RAW_TUNA);
    }

    // -- From traps --

    public static final SlimefunItemStack CRAB = ThemedItemStack.ingredient(
        "GN_CRAB",
        Material.RED_DYE,
        "Crab");

    public static final SlimefunItemStack RAW_TURKEY = ThemedItemStack.ingredient(
        "GN_RAW_TURKEY",
        Material.CHICKEN,
        "Raw Turkey");
    public static final SlimefunItemStack COOKED_TURKEY = ThemedItemStack.ingredient(
        "GN_COOKED_TURKEY",
        Material.COOKED_CHICKEN,
        "Cooked Turkey");

    // ---- Food ----

    // -- Ingredients --

    public static final SlimefunItemStack COOKED_RICE = ThemedItemStack.ingredient(
        "GN_COOKED_RICE",
        Material.SUGAR,
        "Cooked Rice");

    public static final SlimefunItemStack BARLEY_FLOUR = ThemedItemStack.ingredient(
        "GN_BARLEY_FLOUR",
        Material.SUGAR,
        "Barley Flour");

    public static final SlimefunItemStack SORGHUM_FLOUR = ThemedItemStack.ingredient(
        "GN_BARLEY_FLOUR",
        Material.SUGAR,
        "Barley Flour");

    public static final SlimefunItemStack RYE_FLOUR = ThemedItemStack.ingredient(
        "GN_BARLEY_FLOUR",
        Material.SUGAR,
        "Barley Flour");

    public static final SlimefunItemStack DOUGH = ThemedItemStack.ingredient(
        "GN_DOUGH",
        Material.POTATO,
        "Dough");

    public static final SlimefunItemStack TOAST = ThemedItemStack.ingredient(
        "GN_TOAST",
        Material.BREAD,
        "Toast");

    public static final SlimefunItemStack NAAN_BREAD = ThemedItemStack.ingredient(
        "GN_NAAN_BREAD",
        Material.BREAD,
        "Naan Bread");

    public static final SlimefunItemStack PEANUT_BUTTER = ThemedItemStack.ingredient(
        "GN_PEANUT_BUTTER",
        Material.POTION,
        "Peanut Butter");
    static {
        final PotionMeta meta = (PotionMeta) PEANUT_BUTTER.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.THICK));
        meta.setColor(Color.fromRGB(0xbf7715));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS);
        PEANUT_BUTTER.setItemMeta(meta);
    }

    public static final SlimefunItemStack FRIED_EGG = ThemedItemStack.ingredient(
        "GN_FRIED_EGG",
        Material.EGG,
        "Fried Egg");

    public static final SlimefunItemStack HARD_BOILED_EGG = ThemedItemStack.ingredient(
        "GN_HARD_BOILED_EGG",
        Material.EGG,
        "Hard-boiled Egg");

    public static final SlimefunItemStack SCRAMBLED_EGGS = ThemedItemStack.ingredient(
        "GN_SCRAMBLED_EGGS",
        Material.YELLOW_DYE,
        "Scrambled Eggs");

    public static final SlimefunItemStack CUSTARD = ThemedItemStack.ingredient(
        "GN_CUSTARD",
        Material.YELLOW_DYE,
        "Custard");

    public static final SlimefunItemStack CARAMEL = ThemedItemStack.ingredient(
        "GN_CARAMEL",
        Material.BROWN_DYE,
        "Caramel");

    public static final SlimefunItemStack MARMALADE = ThemedItemStack.ingredient(
        "GN_MARMALADE",
        Material.HONEY_BOTTLE,
        "Marmalade");

    public static final SlimefunItemStack PULLED_PORK = ThemedItemStack.ingredient(
        "GN_PULLED_PORK",
        Material.BROWN_DYE,
        "Pulled Pork");

    public static final SlimefunItemStack GROUND_BEEF = ThemedItemStack.ingredient(
        "GN_GROUND_BEEF",
        Material.BROWN_DYE,
        "Ground Beef");

    public static final SlimefunItemStack BAKED_BEANS = ThemedItemStack.ingredient(
        "GN_BAKED_BEANS",
        Material.BEETROOT_SEEDS,
        "Baked Beans");

    public static final SlimefunItemStack MISO = ThemedItemStack.ingredient(
        "GN_MISO",
        Material.GLOWSTONE_DUST,
        "Miso");

    public static final SlimefunItemStack TOFU = ThemedItemStack.ingredient(
        "GN_TOFU",
        Material.BIRCH_BUTTON,
        "Tofu");

    public static final SlimefunItemStack SOY_SAUCE = ThemedItemStack.ingredient(
        "GN_SOY_SAUCE",
        Material.POTION,
        "Soy Sauce");
    static {
        final PotionMeta meta = (PotionMeta) SOY_SAUCE.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.MUNDANE));
        meta.setColor(Color.fromRGB(0x1d0a03));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS);
        SOY_SAUCE.setItemMeta(meta);
    }

    public static final SlimefunItemStack TURMERIC_POWDER = ThemedItemStack.ingredient(
        "GN_TURMERIC_POWDER",
        Material.GLOWSTONE_DUST,
        "Turmeric Powder");

    public static final SlimefunItemStack RED_BEAN_PASTE = ThemedItemStack.ingredient(
        "GN_RED_BEAN_PASTE",
        Material.RED_DYE,
        "Red Bean Paste");

    public static final SlimefunItemStack TAPIOCA_STARCH = ThemedItemStack.ingredient(
        "GN_TAPIOCA_STARCH",
        Material.SUGAR,
        "Tapioca Starch");

    public static final SlimefunItemStack TAPIOCA_PEARLS = ThemedItemStack.ingredient(
        "GN_TAPIOCA_PEARLS",
        Material.PRISMARINE_CRYSTALS,
        "Tapioca Pearls");

    // -- Cuisine --

    // Sandwiches

    public static final FoodItemStack PBJ_SANDWICH = new FoodItemStackBuilder()
        .id("GN_PBJ_SANDWICH")
        .texture(HeadTextures.SANDWICH_RED_OCHRE)
        .name("PB&J Sandwich")
        .hunger(8)
        .effects(FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 90), 0.5))
        .build();

    public static final FoodItemStack MARMALADE_SANDWICH = new FoodItemStackBuilder()
        .id("GN_MARMALADE_SANDWICH")
        .texture(HeadTextures.SANDWICH_ORANGE)
        .name("Marmalade Sandwich")
        .hunger(8)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30))
        .build();

    public static final FoodItemStack BAKED_BEANS_AND_TOAST = new FoodItemStackBuilder()
        .id("GN_BAKED_BEANS_AND_TOAST")
        .texture(HeadTextures.TOAST_ORANGE)
        .name("Baked Beans and Toast")
        .hunger(8)
        .effects(FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 90), 0.5))
        .build();

    public static final FoodItemStack AVOCADO_TOAST = new FoodItemStackBuilder()
        .id("GN_AVOCADO_TOAST")
        .texture(HeadTextures.TOAST_ORANGE) // TODO: Green
        .name("Avocado Toast")
        .hunger(8)
        .effects(FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 90), 0.5))
        .build();

    public static final FoodItemStack TUNA_SANDWICH = new FoodItemStackBuilder()
        .id("GN_TUNA_SANDWICH")
        .texture(HeadTextures.SANDWICH_RED_GREEN)
        .name("Tuna Sandwich")
        .hunger(8)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30))
        .build();

    public static final FoodItemStack BREAKFAST_SANDWICH = new FoodItemStackBuilder()
        .id("GN_BREAKFAST_SANDWICH")
        .texture(HeadTextures.SANDWICH_ORANGE)
        .name("Breakfast Sandwich")
        .hunger(8)
        .effects(FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.REGENERATION, 90), 0.5))
        .build();

    public static final FoodItemStack HAM_SANDWICH = new FoodItemStackBuilder()
        .id("GN_HAM_SANDWICH")
        .texture(HeadTextures.SANDWICH_ORANGE)
        .name("Ham Sandwich")
        .hunger(8)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.REGENERATION, 30))
        .build();

    public static final FoodItemStack CHICKEN_SANDWICH = new FoodItemStackBuilder()
        .id("GN_CHICKEN_SANDWICH")
        .texture(HeadTextures.SANDWICH_RED_GREEN)
        .name("Chicken Salad Sandwich")
        .hunger(8)
        .effects(FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.SPEED, 90), 0.5))
        .build();

    public static final FoodItemStack EGG_SALAD_SANDWICH = new FoodItemStackBuilder()
        .id("GN_EGG_SALAD_SANDWICH")
        .texture(HeadTextures.SANDWICH_WHITE_GREEN)
        .name("Egg Salad Sandwich")
        .hunger(8)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.SPEED, 30))
        .build();

    public static final FoodItemStack ROAST_BEEF_SANDWICH = new FoodItemStackBuilder()
        .id("GN_ROAST_BEEF_SANDWICH")
        .texture(HeadTextures.SANDWICH_RED_GREEN)
        .name("Roast Beef Sandwich")
        .hunger(8)
        .effects(FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 90), 0.5))
        .build();

    public static final FoodItemStack CLUB_SANDWICH = new FoodItemStackBuilder()
        .id("GN_CLUB_SANDWICH")
        .texture(HeadTextures.SANDWICH_RED_GREEN)
        .name("Club Sandwich")
        .hunger(8)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    // Salads

    public static final FoodItemStack GREEK_SALAD = new FoodItemStackBuilder()
        .id("GN_GREEK_SALAD")
        .texture(HeadTextures.SALAD)
        .name("Greek Salad")
        .hunger(5)
        .effects(
            FoodEffect.heal(2),
            FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    public static final FoodItemStack CAESAR_SALAD = new FoodItemStackBuilder()
        .id("GN_CAESAR_SALAD")
        .texture(HeadTextures.SALAD)
        .name("Caesar Salad")
        .hunger(5)
        .effects(
            FoodEffect.heal(2),
            FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    public static final FoodItemStack FIDDLEHEAD_SALAD = new FoodItemStackBuilder()
        .id("GN_FIDDLEHEAD_SALAD")
        .texture(HeadTextures.SALAD)
        .name("Fiddlehead Salad")
        .hunger(5)
        .effects(
            FoodEffect.heal(2),
            FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    // Fried

    public static final FoodItemStack PAN_SEARED_SALMON = new FoodItemStackBuilder()
        .id("GN_PAN_SEARED_SALMON")
        .material(Material.COOKED_SALMON)
        .name("Pan-seared Salmon")
        .hunger(7)
        .build();

    public static final FoodItemStack FRIED_SHRIMP = new FoodItemStackBuilder()
        .id("GN_FRIED_SHRIMP")
        .material(Material.NAUTILUS_SHELL)
        .name("Fried Shrimp")
        .hunger(3)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    public static final FoodItemStack TEMPURA_SHRIMP = new FoodItemStackBuilder()
        .id("GN_TEMPURA_SHRIMP")
        .material(Material.NAUTILUS_SHELL)
        .name("Tempura Shrimp")
        .hunger(4)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    public static final FoodItemStack TEMPURA_BROCCOLI = new FoodItemStackBuilder()
        .id("GN_TEMPURA_BROCCOLI")
        .material(Material.BAKED_POTATO)
        .name("Tempura Broccoli")
        .hunger(3)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    public static final FoodItemStack FRIED_CALAMARI = new FoodItemStackBuilder()
        .id("GN_FRIED_CALAMARI")
        .material(Material.COOKED_CHICKEN)
        .name("Fried Calamari")
        .hunger(5)
        .build();

    // Pastas

    public static final FoodItemStack CHICKEN_PESTO_PASTA = new FoodItemStackBuilder()
        .id("GN_CHICKEN_PESTO_PASTA")
        .texture(HeadTextures.PASTA_GREEN)
        .name("Chicken Pesto Pasta")
        .hunger(8)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS))
        .build();

    public static final FoodItemStack SQUID_INK_PASTA = new FoodItemStackBuilder()
        .id("GN_SQUID_INK_PASTA")
        .texture(HeadTextures.PASTA_BLACK)
        .name("Squid Ink Pasta")
        .hunger(6)
        .build();

    public static final FoodItemStack GLOWING_SQUID_INK_PASTA = new FoodItemStackBuilder()
        .id("GN_GLOWING_SQUID_INK_PASTA")
        .texture(HeadTextures.PASTA_BLACK)
        .name("Glowing Squid Ink Pasta")
        .hunger(6)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.GLOWING, 120, 0))
        .build();

    public static final FoodItemStack TUNA_CASSEROLE = new FoodItemStackBuilder()
        .id("GN_TUNA_CASSEROLE")
        .texture(HeadTextures.PASTA_GREEN)
        .name("Tuna Casserole")
        .hunger(14, 1)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 1))
        .build();

    public static final FoodItemStack CHICKEN_RAVIOLI = new FoodItemStackBuilder()
        .id("GN_CHICKEN_RAVIOLI")
        .texture(HeadTextures.PASTA_RED)
        .name("Chicken Ravioli")
        .hunger(10)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS))
        .build();

    public static final FoodItemStack MUSHROOM_RAVIOLI = new FoodItemStackBuilder()
        .id("GN_MUSHROOM_RAVIOLI")
        .texture(HeadTextures.PASTA_RED)
        .name("Mushroom Ravioli")
        .hunger(8)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS))
        .build();

    // Soups and Stews

    public static final FoodItemStack OATMEAL = new FoodItemStackBuilder()
        .id("GN_OATMEAL")
        .texture(HeadTextures.PORRIDGE)
        .name("Porridge")
        .hunger(6, 1.25)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack BARLEY_PORRIDGE = new FoodItemStackBuilder()
        .id("GN_BARLEY_PORRIDGE")
        .texture(HeadTextures.PORRIDGE)
        .name("Porridge")
        .hunger(6, 1.25)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack CONGEE = new FoodItemStackBuilder()
        .id("GN_CONGEE")
        .texture(HeadTextures.PORRIDGE)
        .name("Porridge")
        .hunger(6, 1.25)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack CHICKEN_SOUP = new FoodItemStackBuilder()
        .id("GN_CHICKEN_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Chicken Soup")
        .hunger(7, 1.25)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack CHICKEN_AND_QUINOA_SOUP = new FoodItemStackBuilder()
        .id("GN_CHICKEN_AND_QUINOA_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Chicken And Quinoa Soup")
        .hunger(8, 1.25)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack CHICKEN_NOODLE_SOUP = new FoodItemStackBuilder()
        .id("GN_CHICKEN_NOODLE_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Chicken Noodle Soup")
        .hunger(9, 1.75)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.WITHER),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack CHICKEN_NOODLE_SOUP_WITH_BOK_HOY = new FoodItemStackBuilder()
        .id("GN_CHICKEN_NOODLE_SOUP_WITH_BOK_CHOY")
        .texture(HeadTextures.SOUP)
        .name("Chicken Noodle Soup w/ Bok Choy")
        .hunger(12, 1.75)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.WITHER),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack SPLIT_PEA_SOUP = new FoodItemStackBuilder()
        .id("GN_SPLIT_PEA_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Split Pea Soup")
        .hunger(6, 1.75)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.CONFUSION))
        .build();

    public static final FoodItemStack HAM_AND_SPLIT_PEA_SOUP = new FoodItemStackBuilder()
        .id("GN_HAM_AND_SPLIT_PEA_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Ham and Split Pea Soup")
        .hunger(14, 1.75)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.CONFUSION))
        .build();

    public static final FoodItemStack LENTIL_SOUP = new FoodItemStackBuilder()
        .id("GN_LENTIL_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Lentil Soup")
        .hunger(8, 1.75)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.SATURATION, 5))
        .build();

    public static final FoodItemStack BEEF_AND_LENTIL_SOUP = new FoodItemStackBuilder()
        .id("GN_BEEF_AND_LENTIL_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Beef and Lentil Soup")
        .hunger(16, 1.75)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.SATURATION, 10, 1))
        .build();

    public static final FoodItemStack CARROT_SOUP = new FoodItemStackBuilder()
        .id("GN_CARROT_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Carrot Soup")
        .hunger(8, 1.75)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.BLINDNESS))
        .build();

    public static final FoodItemStack MUSHROOM_BARLEY_SOUP = new FoodItemStackBuilder()
        .id("GN_MUSHROOM_BARLEY_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Mushroom Barley Soup")
        .hunger(8, 2)
        .effects(FoodEffect.warm(70))
        .build();

    public static final FoodItemStack CHICKEN_BARLEY_SOUP = new FoodItemStackBuilder()
        .id("GN_CHICKEN_BARLEY_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Chicken Barley Soup")
        .hunger(10, 2)
        .effects(FoodEffect.warm(70))
        .build();

    public static final FoodItemStack BEEF_BARLEY_SOUP = new FoodItemStackBuilder()
        .id("GN_BEEF_BARLEY_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Beef Barley Soup")
        .hunger(12, 2)
        .effects(FoodEffect.warm(70))
        .build();

    public static final FoodItemStack CREAM_OF_MUSHROOM_SOUP = new FoodItemStackBuilder()
        .id("GN_CREAM_OF_MUSHROOM_SOUP")
        .texture(HeadTextures.CREAM_SOUP)
        .name("Cream of Mushroom Soup")
        .hunger(7, 1.75)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack CREAM_OF_BROCCOLI_SOUP = new FoodItemStackBuilder()
        .id("GN_CREAM_OF_BROCCOLI_SOUP")
        .texture(HeadTextures.CREAM_SOUP)
        .name("Cream of Celery Soup")
        .hunger(8, 1.75)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack CREAM_OF_ASPARAGUS_SOUP = new FoodItemStackBuilder()
        .id("GN_CREAM_OF_ASPARAGUS_SOUP")
        .texture(HeadTextures.CREAM_SOUP)
        .name("Cream of Asparagus Soup")
        .hunger(8, 1.75)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack CREAM_OF_CAULIFLOWER_SOUP = new FoodItemStackBuilder()
        .id("GN_CREAM_OF_CAULIFLOWER_SOUP")
        .texture(HeadTextures.CREAM_SOUP)
        .name("Cream of Cauliflower Soup")
        .hunger(8, 1.75)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack MISO_SOUP = new FoodItemStackBuilder()
        .id("GN_MISO_SOUP")
        .texture(HeadTextures.MISO_SOUP)
        .name("Miso Soup")
        .hunger(4, 1.75)
        .effects(FoodEffect.warm(50))
        .build();

    public static final FoodItemStack GUARDIAN_FIN_SOUP = new FoodItemStackBuilder()
        .id("GN_GUARDIAN_FIN_SOUP")
        .texture(HeadTextures.SOUP)
        .name("Guardian Fin Soup")
        .hunger(4, 1.75)
        .effects(FoodEffect.warm(50))
        .build();

    public static final FoodItemStack BROCCOLI_CHOWDER = new FoodItemStackBuilder()
        .id("GN_BROCCOLI_CHOWDER")
        .texture(HeadTextures.CHOWDER)
        .name("Broccoli Chowder")
        .hunger(8, 1.75)
        .build();

    public static final FoodItemStack SALMON_CHOWDER = new FoodItemStackBuilder()
        .id("GN_SALMON_CHOWDER")
        .texture(HeadTextures.CHOWDER)
        .name("Salmon Chowder")
        .hunger(10, 1.75)
        .build();

    public static final FoodItemStack POTATO_CHOWDER = new FoodItemStackBuilder()
        .id("GN_POTATO_CHOWDER")
        .texture(HeadTextures.CHOWDER)
        .name("Potato Chowder")
        .hunger(8, 1.75)
        .build();

    public static final FoodItemStack CORN_CHOWDER = new FoodItemStackBuilder()
        .id("GN_CORN_CHOWDER")
        .texture(HeadTextures.CHOWDER)
        .name("Corn Chowder")
        .hunger(8, 1.75)
        .build();

    public static final FoodItemStack BEEF_STEW = new FoodItemStackBuilder()
        .id("GN_BEEF_STEW")
        .texture(HeadTextures.STEW)
        .name("Beef Stew")
        .hunger(10, 1.75)
        .effects(FoodEffect.warm(140))
        .build();

    public static final FoodItemStack CLAM_STEW = new FoodItemStackBuilder()
        .id("GN_CLAM_STEW")
        .texture(HeadTextures.STEW)
        .name("Clam Stew")
        .hunger(6, 1.75)
        .effects(FoodEffect.warm(50))
        .build();

    public static final FoodItemStack CRAB_HOTPOT = new FoodItemStackBuilder()
        .id("GN_CRAB_HOTPOT")
        .texture(HeadTextures.STEW)
        .name("Crab Hotpot")
        .hunger(12, 1.75)
        .effects(FoodEffect.warm(140))
        .build();

    // Meats

    public static final FoodItemStack BBQ_STEAK = new FoodItemStackBuilder()
        .id("GN_BBQ_STEAK")
        .material(Material.COOKED_BEEF)
        .name("BBQ Steak")
        .hunger(9, 1.5)
        .build();

    public static final FoodItemStack BBQ_PORK = new FoodItemStackBuilder()
        .id("GN_BBQ_PORK")
        .material(Material.COOKED_PORKCHOP)
        .name("BBQ Pork")
        .hunger(9, 1.5)
        .build();

    public static final FoodItemStack BBQ_CHICKEN = new FoodItemStackBuilder()
        .id("GN_BBQ_CHICKEN")
        .material(Material.COOKED_CHICKEN)
        .name("BBQ Chicken")
        .hunger(9, 1.5)
        .build();

    public static final FoodItemStack BBQ_MUTTON = new FoodItemStackBuilder()
        .id("GN_BBQ_MUTTON")
        .material(Material.COOKED_MUTTON)
        .name("BBQ Mutton")
        .hunger(9, 1.5)
        .build();

    public static final FoodItemStack BUTTER_CHICKEN = new FoodItemStackBuilder()
        .id("GN_BUTTER_CHICKEN")
        .texture(HeadTextures.STEW)
        .name("Butter Chicken")
        .hunger(7)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30))
        .build();

    // Rice

    public static final FoodItemStack BUTTER_CHICKEN_WITH_NAAN_BREAD = new FoodItemStackBuilder()
        .id("GN_BUTTER_CHICKEN_WITH_NAAN_BREAD")
        .texture(HeadTextures.STEW)
        .name("Butter Chicken With Naan Bread")
        .hunger(10)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30, 1))
        .build();

    public static final FoodItemStack SHRIMP_FRIED_RICE = new FoodItemStackBuilder()
        .id("GN_SHRIMP_FRIED_RICE")
        .texture(HeadTextures.RICE_PINK)
        .name("Shrimp Fried Rice")
        .hunger(6)
        .build();

    public static final FoodItemStack CURRY_RICE = new FoodItemStackBuilder()
        .id("GN_CURRY_RICE")
        .texture(HeadTextures.RICE_BROWN)
        .name("Curry Rice")
        .hunger(4)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30))
        .build();

    public static final FoodItemStack RICE_OMELETTE = new FoodItemStackBuilder()
        .id("GN_RICE_OMELETTE")
        .texture(HeadTextures.RICE_YELLOW)
        .name("Rice Omelette")
        .hunger(4)
        .effects(FoodEffect.heal(1))
        .build();

    public static final FoodItemStack RICE_BALLS = new FoodItemStackBuilder()
        .id("GN_RICE_BALLS")
        .texture(HeadTextures.RICE_BALLS)
        .name("Rice Balls")
        .hunger(3)
        .build();

    // Noodles

    public static final FoodItemStack BEEF_UDON = new FoodItemStackBuilder()
        .id("GN_BEEF_UDON")
        .texture(HeadTextures.UDON)
        .name("Beef Udon")
        .hunger(10)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack CHICKEN_UDON = new FoodItemStackBuilder()
        .id("GN_CHICKEN_UDON")
        .texture(HeadTextures.UDON)
        .name("Chicken Udon")
        .hunger(10)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack VEGETABLE_UDON = new FoodItemStackBuilder()
        .id("GN_VEGETABLE_UDON")
        .texture(HeadTextures.UDON)
        .name("Vegetable Udon")
        .hunger(10)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack STIR_FRY_NOODLES = new FoodItemStackBuilder()
        .id("GN_STIR_FRY_NOODLES")
        .texture(HeadTextures.NOODLES)
        .name("Stir-fry Noodles")
        .hunger(8)
        .build();

    public static final FoodItemStack SHRIMP_DUMPLINGS = new FoodItemStackBuilder()
        .id("GN_SHRIMP_DUMPLINGS")
        .texture(HeadTextures.NONE)
        .name("Shrimp Dumplings")
        .hunger(5)
        .build();

    public static final FoodItemStack CHICKEN_POTSTICKERS = new FoodItemStackBuilder()
        .id("GN_CHICKEN_POTSTICKERS")
        .texture(HeadTextures.NONE)
        .name("Chicken Potstickers")
        .hunger(7)
        .build();

    public static final FoodItemStack BEEF_POTSTICKERS = new FoodItemStackBuilder()
        .id("GN_BEEF_POTSTICKERS")
        .texture(HeadTextures.NONE)
        .name("Beef Potstickers")
        .hunger(9)
        .build();

    public static final FoodItemStack PIEROGIES = new FoodItemStackBuilder()
        .id("GN_PIEROGIES")
        .texture(HeadTextures.NONE)
        .name("Pierogies")
        .hunger(7)
        .build();

    public static final FoodItemStack BACON_PIEROGIES = new FoodItemStackBuilder()
        .id("GN_BACON_PIEROGIES")
        .texture(HeadTextures.NONE)
        .name("Bacon Pierogies")
        .hunger(8)
        .build();

    public static final FoodItemStack CUSTARD_BUNS = new FoodItemStackBuilder()
        .id("GN_CUSTARD_BUNS")
        .texture(HeadTextures.NONE)
        .name("Custard Buns")
        .hunger(6)
        .build();

    public static final FoodItemStack RED_BEAN_BUNS = new FoodItemStackBuilder()
        .id("GN_RED_BEAN_BUNS")
        .texture(HeadTextures.NONE)
        .name("Red Bean Buns")
        .hunger(6)
        .build();

    public static final FoodItemStack TAIYAKI = new FoodItemStackBuilder()
        .id("GN_TAIYAKI")
        .material(Material.COD)
        .name("Taiyaki")
        .hunger(6)
        .build();

    // Sushi

    public static final FoodItemStack TEMPURA_SHRIMP_ROLL = new FoodItemStackBuilder()
        .id("GN_TEMPURA_SHRIMP_ROLL")
        .texture(HeadTextures.SUSHI_ROLL)
        .name("Tempura Shrimp Roll")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack DYNAMITE_ROLL = new FoodItemStackBuilder()
        .id("GN_DYNAMITE_ROLL")
        .texture(HeadTextures.SUSHI_ROLL)
        .name("Dynamite Roll")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack KAPPA_ROLL = new FoodItemStackBuilder()
        .id("GN_KAPPA_ROLL")
        .texture(HeadTextures.SUSHI_ROLL)
        .name("Kappa Roll")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack CALIFORNIA_ROLL = new FoodItemStackBuilder()
        .id("GN_CALIFORNIA_ROLL")
        .texture(HeadTextures.SUSHI_ROLL)
        .name("California Roll")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack SALMON_ROE_SUSHI_ROLL = new FoodItemStackBuilder()
        .id("GN_SALMON_ROE_SUSHI_ROLL")
        .texture(HeadTextures.NONE)
        .name("Salmon Roe Sushi Roll")
        .hunger(6, 0.75)
        .build();

    public static final FoodItemStack RED_BEAN_GLUTINOUS_RICE_BALLS = new FoodItemStackBuilder()
        .id("GN_RED_BEAN_GLUTINOUS_RICE_BALLS")
        .texture(HeadTextures.NONE)
        .name("Red Bean Glutinous Rice Balls")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack PEANUT_GLUTINOUS_RICE_BALLS = new FoodItemStackBuilder()
        .id("GN_PEANUT_GLUTINOUS_RICE_BALLS")
        .texture(HeadTextures.NONE)
        .name("Peanut Glutinous Rice Balls")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack SESAME_GLUTINOUS_RICE_BALLS = new FoodItemStackBuilder()
        .id("GN_SESAME_GLUTINOUS_RICE_BALLS")
        .texture(HeadTextures.NONE)
        .name("Sesame Glutinous Rice Balls")
        .hunger(7, 0.75)
        .build();

    // Random stuff

    public static final FoodItemStack LASAGNA = new FoodItemStackBuilder()
        .id("GN_LASAGNA")
        .texture(HeadTextures.NONE)
        .name("Lasagna")
        .hunger(12, 1)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();

    public static final FoodItemStack MASHED_POTATOES = new FoodItemStackBuilder()
        .id("GN_MASHED_POTATOES")
        .material(Material.BAKED_POTATO)
        .name("Mashed Potatoes")
        .hunger(5, 1)
        .build();

    public static final FoodItemStack MASHED_TURNIPS = new FoodItemStackBuilder()
        .id("GN_MASHED_TURNIPS")
        .material(Material.FERMENTED_SPIDER_EYE)
        .name("Mashed Turnips")
        .hunger(5, 1)
        .build();

    public static final FoodItemStack FISH_AND_CHIPS = new FoodItemStackBuilder()
        .id("GN_FISH_AND_CHIPS")
        .material(Material.COOKED_COD)
        .name("Fish and Chips")
        .hunger(10, 0.75)
        .build();

    public static final FoodItemStack TURKEY_ROAST = new FoodItemStackBuilder()
        .id("GN_TURKEY_ROAST")
        .material(Material.COOKED_CHICKEN)
        .name("Turkey Roast")
        .hunger(12, 0.75)
        .build();

    public static final FoodItemStack CHOCOLATE_TRUFFLE = new FoodItemStackBuilder()
        .id("GN_CHOCOLATE_TRUFFLE")
        .material(Material.BROWN_MUSHROOM)
        .name("Chocolate Truffle")
        .hunger(4, 0.75)
        .build();

    // Baked

    public static final FoodItemStack CHOCOLATE_CHIP_MUFFIN = new FoodItemStackBuilder()
        .id("GN_CHOCOLATE_CHIP_MUFFIN")
        .texture(HeadTextures.NONE)
        .name("Chocolate Chip Muffin")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack DOUBLE_CHOCOLATE_MUFFIN = new FoodItemStackBuilder()
        .id("GN_DOUBLE_CHOCOLATE_MUFFIN")
        .texture(HeadTextures.NONE)
        .name("Double Chocolate Muffin")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CARROT_MUFFIN = new FoodItemStackBuilder()
        .id("GN_CARROT_MUFFIN")
        .texture(HeadTextures.NONE)
        .name("Carrot Muffin")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack BLUEBERRY_MUFFIN = new FoodItemStackBuilder()
        .id("GN_BLUEBERRY_MUFFIN")
        .texture(HeadTextures.NONE)
        .name("Blueberry Muffin")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CRANBERRY_MUFFIN = new FoodItemStackBuilder()
        .id("GN_CRANBERRY_MUFFIN")
        .texture(HeadTextures.NONE)
        .name("Cranberry Muffin")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack RAISIN_MUFFIN = new FoodItemStackBuilder()
        .id("GN_RAISIN_MUFFIN")
        .texture(HeadTextures.NONE)
        .name("Raisin Muffin")
        .hunger(3, 0.75)
        .build();

    // Cold desserts

    public static final FoodItemStack VANILLA_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_VANILLA_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Vanilla Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CHOCOLATE_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_CHOCOLATE_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Chocolate Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack MINT_CHOCOLATE_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_MINT_CHOCOLATE_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name(" Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack COOKIE_DOUGH_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_COOKIE_DOUGH_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Cookie Dough Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack PEANUT_BUTTER_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_PEANUT_BUTTER_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Peanut Butter Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack RED_BEAN_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_RED_BEAN_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Red Bean Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack GREEN_TEA_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_GREEN_TEA_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name(" Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack STRAWBERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_STRAWBERRY_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Strawberry Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack BLUEBERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_BLUEBERRY_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Blueberry Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CRANBERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_CRANBERRY_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Cranberry Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack COWBERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_COWBERRY_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Cowberry Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack COCONUT_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_COCONUT_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Coconut Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CHERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_CHERRY_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Cherry Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack RASPBERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_RASPBERRY_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Raspberry Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CARAMEL_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_CARAMEL_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Caramel Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack ORANGE_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_ORANGE_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Orange Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack PEACH_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_PEACH_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Peach Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack PINEAPPLE_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_PINEAPPLE_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Pineapple Ice Cream")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CHORUS_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_CHORUS_ICE_CREAM")
        .texture(HeadTextures.NONE)
        .name("Chorus Ice Cream")
        .hunger(3, 0.75)
        .effects(FoodEffect.teleport(5))
        .build();

    public static final FoodItemStack SHAVED_ICE = new FoodItemStackBuilder()
        .id("GN_SHAVED_ICE")
        .texture(HeadTextures.SHAVED_ICE)
        .name("Shaved Ice")
        .hunger(2, 0.75)
        .build();

    public static final FoodItemStack STRAWBERRY_SHAVED_ICE = new FoodItemStackBuilder()
        .id("GN_STRAWBERRY_SHAVED_ICE")
        .texture(HeadTextures.STRAWBERRY_SHAVED_ICE)
        .name("Strawberry Shaved Ice")
        .hunger(2, 0.75)
        .build();

    public static final FoodItemStack BANANA_SHAVED_ICE = new FoodItemStackBuilder()
        .id("GN_BANANA_SHAVED_ICE")
        .texture(HeadTextures.LEMON_SHAVED_ICE)
        .name("Banana Shaved Ice")
        .hunger(2, 0.75)
        .build();

    public static final FoodItemStack LEMON_SHAVED_ICE = new FoodItemStackBuilder()
        .id("GN_LEMON_SHAVED_ICE")
        .texture(HeadTextures.LEMON_SHAVED_ICE)
        .name("Lemon Shaved Ice")
        .hunger(2, 0.75)
        .build();

    // Sweets / Snacks

    public static final FoodItemStack CANDY_APPLE = new FoodItemStackBuilder()
        .id("GN_CANDY_APPLE")
        .texture(HeadTextures.NONE)
        .name("Candy Apple")
        .hunger(5, 0.75)
        .build();

    public static final FoodItemStack DONUT = new FoodItemStackBuilder()
        .id("GN_DONUT")
        .texture(HeadTextures.NONE)
        .name("Donut")
        .hunger(5, 0.75)
        .build();

    public static final FoodItemStack HONEY_DIP_DONUT = new FoodItemStackBuilder()
        .id("GN_HONEY_DIP_DONUT")
        .texture(HeadTextures.NONE)
        .name("Honey Dip Donut")
        .hunger(5, 0.75)
        .build();

    public static final FoodItemStack GOLDEN_CHOCOLATE_DONUT = new FoodItemStackBuilder()
        .id("GN_GOLDEN_CHOCOLATE_DONUT")
        .texture(HeadTextures.NONE)
        .name("Golden Chocolate Donut")
        .hunger(5, 0.75)
        .build();

    public static final FoodItemStack STRAWBERRY_CHEESECAKE = new FoodItemStackBuilder()
        .id("GN_STRAWBERRY_CHEESECAKE")
        .texture(HeadTextures.NONE)
        .name("Strawberry Cheesecake")
        .hunger(8, 0.75)
        .build();

    public static final FoodItemStack STRAWBERRY_CUPCAKE = new FoodItemStackBuilder()
        .id("GN_STRAWBERRY_CUPCAKE")
        .texture(HeadTextures.NONE)
        .name("Strawberry Cupcake")
        .hunger(6, 0.75)
        .build();

    public static final FoodItemStack LEMON_TART = new FoodItemStackBuilder()
        .id("GN_LEMON_TART")
        .material(Material.PUMPKIN_PIE)
        .name("Lemon Tart")
        .hunger(8, 0.5)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.SPEED, 120))
        .build();

    public static final FoodItemStack CHORUS_PIE = new FoodItemStackBuilder()
        .id("GN_CHORUS_PIE")
        .material(Material.PUMPKIN_PIE)
        .name("Chorus Pie")
        .hunger(8, 0.5)
        .effects(FoodEffect.teleport(5))
        .build();

    public static final FoodItemStack POPPED_SORGHUM = new FoodItemStackBuilder()
        .id("GN_POPPED_SORGHUM")
        .material(Material.PUMPKIN_PIE)
        .name("Popped Sorghum")
        .hunger(1, 0.5)
        .build();

    public static final FoodItemStack ENCHANTED_GOLDEN_CARROT = new FoodItemStackBuilder()
        .id("GN_ENCHANTED_GOLDEN_CARROT")
        .material(Material.GOLDEN_CARROT)
        .name("Enchanted Golden Carrot")
        .hunger(8, 0.5)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.DARKNESS),
            FoodEffect.removePotionEffect(PotionEffectType.BLINDNESS),
            FoodEffect.positivePotionEffect(PotionEffectType.NIGHT_VISION, 900))
        .build();
    static {
        ENCHANTED_GOLDEN_CARROT.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ENCHANTED_GOLDEN_CARROT.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final FoodItemStack ENCHANTED_GLISTERING_MELON_SLICE = new FoodItemStackBuilder()
        .id("GN_ENCHANTED_GLISTERING_MELON_SLICE")
        .material(Material.GLISTERING_MELON_SLICE)
        .name("Enchanted Glistering Melon Slice")
        .hunger(4, 0.5)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.WITHER),
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.positivePotionEffect(PotionEffectType.REGENERATION, 120))
        .build();
    static {
        ENCHANTED_GLISTERING_MELON_SLICE.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ENCHANTED_GLISTERING_MELON_SLICE.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    }

    // Drinks

    public static final FoodItemStack V7 = new FoodItemStackBuilder()
        .id("GN_V7")
        .texture(HeadTexture.TIN_CAN.toString())
        .name("V7")
        .hunger(6, 0.75)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.REGENERATION, 20, 2))
        .build();

    public static final FoodItemStack BOBA_MILK_TEA = new FoodItemStackBuilder()
        .id("GN_BOBA_MILK_TEA")
        .texture(HeadTextures.NONE)
        .name("Boba Milk Tea")
        .hunger(4, 0.75)
        .build();

    // Sin

    public static final FoodItemStack RED_WINE = new FoodItemStackBuilder()
        .id("GN_RED_WINE")
        .material(Material.POTION)
        .name("Red Wine")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 60, 2),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) RED_WINE.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.setColor(Color.MAROON);
        RED_WINE.setItemMeta(meta);
    }

    public static final FoodItemStack BEER = new FoodItemStackBuilder()
        .id("GN_BEER")
        .material(Material.POTION)
        .name("Beer")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 60, 2),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) BEER.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.setColor(Color.ORANGE);
        BEER.setItemMeta(meta);
    }

    public static final FoodItemStack RICE_WINE = new FoodItemStackBuilder()
        .id("GN_RICE_WINE")
        .material(Material.POTION)
        .name("Rice Wine")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 60, 2),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) RICE_WINE.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.setColor(Color.WHITE);
        RICE_WINE.setItemMeta(meta);
    }

    public static final FoodItemStack VODKA = new FoodItemStackBuilder()
        .id("GN_VODKA")
        .material(Material.POTION)
        .name("Vodka")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 120, 4),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) VODKA.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.setColor(Color.WHITE);
        VODKA.setItemMeta(meta);
    }

    public static final FoodItemStack RUM = new FoodItemStackBuilder()
        .id("GN_RUM")
        .material(Material.POTION)
        .name("Rum")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 120, 4),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) VODKA.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.setColor(Color.RED);
        RUM.setItemMeta(meta);
    }

    public static final FoodItemStack WHISKEY = new FoodItemStackBuilder()
        .id("GN_WHISKEY")
        .material(Material.POTION)
        .name("Whiskey")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 120, 4),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) VODKA.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.setColor(Color.ORANGE);
        WHISKEY.setItemMeta(meta);
    }

}
