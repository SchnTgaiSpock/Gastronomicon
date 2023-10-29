package io.github.schntgaispock.gastronomicon.core.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.api.loot.LootTable;
import io.github.schntgaispock.gastronomicon.core.Climate;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.schntgaispock.gastronomicon.util.StringUtil;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;

public class WildHarvestListener implements Listener {

    private static final Map<Climate, Map<Material, LootTable<ItemStack>>> dropsByClimateByBlock = new HashMap<>();
    private static final Map<Material, LootTable<ItemStack>> dropsByBlock = new HashMap<>();
    private static final Map<EntityType, LootTable<ItemStack>> dropsByMob = new HashMap<>();

    private static final List<String> worldsDisabledIn = new ArrayList<>();
    private static final Map<Material, Double> blockDropChanceCache = new HashMap<>();
    private static final Map<EntityType, Double> mobDropChanceCache = new HashMap<>();

    public static void registerBlockDrops(Material material, LootTable<ItemStack> table, Climate climate) {
        Map<Material, LootTable<ItemStack>> climateDrops = dropsByClimateByBlock.get(climate);
        if (climateDrops == null) {
            climateDrops = new HashMap<>();
        }
        climateDrops.put(material, table);
        dropsByClimateByBlock.put(climate, climateDrops);
    }

    public static void registerBlockDrops(Material material, LootTable<ItemStack> table) {
        dropsByBlock.put(material, table);
    }

    public static void registerMobDrops(EntityType entityType, LootTable<ItemStack> table) {
        dropsByMob.put(entityType, table);
    }

    private double getDropChance(Material mat) {
        if (blockDropChanceCache.containsKey(mat)) {
            return blockDropChanceCache.get(mat);
        }

        System.out.println("drops.block-break-chances." + StringUtil.kebabCase(mat.name()));
        final double chance = Gastronomicon.getInstance()
            .getConfig()
            .getDouble("drops.block-break-chances." + StringUtil.kebabCase(mat.name()), 0.15);
        System.out.println(chance);
        blockDropChanceCache.put(mat, chance);
        return chance;
    }

    private double getDropChance(EntityType entity) {
        if (mobDropChanceCache.containsKey(entity)) {
            return mobDropChanceCache.get(entity);
        }

        final double chance = Gastronomicon.getInstance()
            .getConfig()
            .getDouble("drops.mob-kill-chances." + StringUtil.kebabCase(entity.name()), 0.35);
        mobDropChanceCache.put(entity, chance);
        return chance;
    }

    @Nullable
    @ParametersAreNonnullByDefault
    public static LootTable<ItemStack> getDrops(Material dropFrom, Climate climate) {
        if (dropsByClimateByBlock.containsKey(climate) && dropsByClimateByBlock.get(climate).containsKey(dropFrom)) {
            return dropsByClimateByBlock.get(climate).get(dropFrom);
        } else {
            return dropsByBlock.getOrDefault(dropFrom, null);
        }
    }

    @Nullable
    public static LootTable<ItemStack> getDrops(@Nonnull EntityType dropFrom) {
        return dropsByMob.getOrDefault(dropFrom, null);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (worldsDisabledIn.contains(e.getBlock().getWorld().getName())) {
            return;
        }

        final Block b = e.getBlock();
        if (b == null)
            return;

        final LootTable<ItemStack> drops = getDrops(b.getType(), Climate.of(b.getBiome()));
        if (drops == null)
            return;

        if (!Slimefun.getProtectionManager().hasPermission(e.getPlayer(), e.getBlock(), Interaction.BREAK_BLOCK))
            return;

        final ItemStack weapon = e.getPlayer().getInventory().getItemInMainHand();
        final int fortune = weapon == null ? 0
            : weapon.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
        if (NumberUtil.flip(getDropChance(b.getType()) * (1 + fortune * 0.5))) {
            final ItemStack drop = drops.generate();
            if (drop == null) {
                return;
            }
            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), drop.clone());
        }
    }

    @EventHandler
    public void onMobKill(EntityDeathEvent e) {
        if (worldsDisabledIn.contains(e.getEntity().getWorld().getName())) {
            return;
        }

        final LootTable<ItemStack> drops = getDrops(e.getEntityType());
        if (drops == null)
            return;

        final Player killer = e.getEntity().getKiller();
        final int looting = (killer == null || killer.getInventory().getItemInMainHand() == null) ? 0
            : killer.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
        if (NumberUtil.flip(getDropChance(e.getEntityType()) * (1 + looting * 0.5))) {
            final ItemStack drop = drops.generate();
            if (drop == null) {
                return;
            }
            e.getDrops().add(drop.clone());
        }
    }

    public static void setup() {
        Bukkit.getPluginManager().registerEvents(new WildHarvestListener(), Gastronomicon.getInstance());

        worldsDisabledIn.addAll(Gastronomicon.getInstance().getConfig().getStringList("drops.disabled-in"));

        final LootTable<ItemStack> DRY_CLIMATE_GRASS_DROPS = LootTable.builder()
            .addItems(GastroStacks.CASSAVA,
                GastroStacks.LENTILS,
                GastroStacks.CUMIN_SEEDS,
                GastroStacks.HONEYDEW_MELON_SEEDS,
                GastroStacks.SORGHUM_SEEDS)
            .build();
        final LootTable<ItemStack> TEMPERATE_CLIMATE_GRASS_DROPS = LootTable.builder()
            .addItems(6,
                GastroStacks.RICE,
                GastroStacks.OATS,
                GastroStacks.SOYBEANS,
                GastroStacks.BARLEY_SEEDS,
                GastroStacks.RYE_SEEDS,
                GastroStacks.SORGHUM_SEEDS)
            .addItems(4,
                GastroStacks.TURNIP_SEEDS,
                GastroStacks.RED_BEANS,
                GastroStacks.CANTALOUPE_SEEDS,
                GastroStacks.HONEYDEW_MELON_SEEDS,
                GastroStacks.SESAME_SEEDS,
                GastroStacks.PEANUTS,
                GastroStacks.BEANS,
                GastroStacks.PEAS)
            .addItems(3,
                GastroStacks.BOK_CHOY_SEEDS,
                GastroStacks.CUCUMBER_SEEDS,
                GastroStacks.BASIL_SEEDS,
                GastroStacks.SPINACH_SEEDS,
                GastroStacks.MINT_SEEDS,
                GastroStacks.CHILI_PEPPER_SEEDS,
                GastroStacks.PARSLEY_SEEDS,
                GastroStacks.CASSAVA,
                GastroStacks.LENTILS,
                GastroStacks.ASPARAGUS_SEEDS,
                GastroStacks.GREEN_ONION_SEEDS,
                GastroStacks.CAULIFLOWER_SEEDS,
                GastroStacks.AVOCADO_PIT,
                GastroStacks.TURMERIC,
                GastroStacks.CUMIN_SEEDS,
                GastroStacks.VANILLA_PLANT)
            .addItems(2,
                GastroStacks.LYCHEE_SAPLING,
                GastroStacks.BANANA_SAPLING)
            .build();
        final LootTable<ItemStack> COLD_CLIMATE_GRASS_DROPS = LootTable.builder()
            .addItems(6,
                GastroStacks.QUINOA,
                GastroStacks.OATS,
                GastroStacks.RYE_SEEDS)
            .addItems(4,
                GastroStacks.TURNIP_SEEDS,
                GastroStacks.SQUASH_SEEDS,
                GastroStacks.PEAS)
            .addItems(3,
                GastroStacks.CELERY,
                GastroStacks.BROCCOLI_SEEDS,
                GastroStacks.BRUSSLES_SPROUTS)
            .addItems(2,
                GastroStacks.LYCHEE_SAPLING)
            .build();
        final LootTable<ItemStack> SNOWY_CLIMATE_GRASS_DROPS = LootTable.builder()
            .addItems(GastroStacks.RYE_SEEDS)
            .build();
        final LootTable<ItemStack> FERN_DROPS = LootTable.builder()
            .addItems(GastroStacks.FIDDLEHEADS)
            .build();
        final LootTable<ItemStack> DIRT_DROPS = LootTable.builder()
            .addItems(GastroStacks.ENOKI_MUSHROOMS,
                GastroStacks.KING_OYSTER_MUSHROOM,
                GastroStacks.BUTTON_MUSHROOM)
            .build();
        final LootTable<ItemStack> PODZOL_DROPS = LootTable.builder()
            .addItems(4,
                GastroStacks.ENOKI_MUSHROOMS,
                GastroStacks.KING_OYSTER_MUSHROOM,
                GastroStacks.BUTTON_MUSHROOM)
            .addItems(GastroStacks.TRUFFLE)
            .build();
        final LootTable<ItemStack> SEAGRASS_DROPS = LootTable.builder()
            .addItems(GastroStacks.CLAM)
            .build();

        final LootTable<ItemStack> SQUID_DROPS = LootTable.builder()
            .addItems(GastroStacks.RAW_SQUID)
            .build();
        final LootTable<ItemStack> GUARDIAN_DROPS = LootTable.builder()
            .addItems(GastroStacks.GUARDIAN_FIN)
            .build();
        final LootTable<ItemStack> GOAT_DROPS = LootTable.builder()
            .addItems(GastroStacks.RAW_CHEVON)
            .build();
        final LootTable<ItemStack> SALMON_DROPS = LootTable.builder()
            .addItems(GastroStacks.SALMON_ROE)
            .build();

        WildHarvestListener.registerBlockDrops(Material.GRASS, DRY_CLIMATE_GRASS_DROPS, Climate.DRY);
        WildHarvestListener.registerBlockDrops(Material.TALL_GRASS, DRY_CLIMATE_GRASS_DROPS, Climate.DRY);
        WildHarvestListener.registerBlockDrops(Material.GRASS, TEMPERATE_CLIMATE_GRASS_DROPS, Climate.TEMPERATE);
        WildHarvestListener.registerBlockDrops(Material.TALL_GRASS, TEMPERATE_CLIMATE_GRASS_DROPS, Climate.TEMPERATE);
        WildHarvestListener.registerBlockDrops(Material.GRASS, COLD_CLIMATE_GRASS_DROPS, Climate.COLD);
        WildHarvestListener.registerBlockDrops(Material.TALL_GRASS, COLD_CLIMATE_GRASS_DROPS, Climate.COLD);
        WildHarvestListener.registerBlockDrops(Material.GRASS, SNOWY_CLIMATE_GRASS_DROPS, Climate.SNOWY);
        WildHarvestListener.registerBlockDrops(Material.TALL_GRASS, SNOWY_CLIMATE_GRASS_DROPS, Climate.SNOWY);
        WildHarvestListener.registerBlockDrops(Material.FERN, FERN_DROPS);
        WildHarvestListener.registerBlockDrops(Material.LARGE_FERN, FERN_DROPS);
        WildHarvestListener.registerBlockDrops(Material.PODZOL, PODZOL_DROPS);
        WildHarvestListener.registerBlockDrops(Material.DIRT, DIRT_DROPS);
        WildHarvestListener.registerBlockDrops(Material.GRASS_BLOCK, DIRT_DROPS);
        WildHarvestListener.registerBlockDrops(Material.ROOTED_DIRT, DIRT_DROPS);
        WildHarvestListener.registerBlockDrops(Material.MYCELIUM, DIRT_DROPS);
        WildHarvestListener.registerBlockDrops(Material.SEAGRASS, SEAGRASS_DROPS);
        WildHarvestListener.registerMobDrops(EntityType.SQUID, SQUID_DROPS);
        WildHarvestListener.registerMobDrops(EntityType.GUARDIAN, GUARDIAN_DROPS);
        WildHarvestListener.registerMobDrops(EntityType.GOAT, GOAT_DROPS);
        WildHarvestListener.registerMobDrops(EntityType.SALMON, SALMON_DROPS);
    }

}
