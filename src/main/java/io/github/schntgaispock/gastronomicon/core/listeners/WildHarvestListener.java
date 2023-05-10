package io.github.schntgaispock.gastronomicon.core.listeners;

import java.util.HashMap;
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
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;

public class WildHarvestListener implements Listener {

    private static final Map<Climate, Map<Material, LootTable<ItemStack>>> dropsByClimateByBlock = new HashMap<>();
    private static final Map<Material, LootTable<ItemStack>> dropsByBlock = new HashMap<>();
    private static final Map<EntityType, LootTable<ItemStack>> dropsByMob = new HashMap<>();

    private static double BLOCK_BREAK_DROP_CHANCE = 0.15;
    private static double MOB_KILL_DROP_CHANCE = 0.35;

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

    @Nullable
    @ParametersAreNonnullByDefault
    public static LootTable<ItemStack> getDrops(Material dropFrom, Climate climate) {
        if (dropsByClimateByBlock.containsKey(climate) && dropsByClimateByBlock.get(climate).containsKey(dropFrom)) {
            return dropsByClimateByBlock.get(climate).get(dropFrom);
        } else if (dropsByBlock.containsKey(dropFrom)) {
            return dropsByBlock.get(dropFrom);
        } else {
            return null;
        }
    }

    @Nullable
    public static LootTable<ItemStack> getDrops(@Nonnull EntityType dropFrom) {
        return dropsByMob.containsKey(dropFrom) ? dropsByMob.get(dropFrom) : null;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
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
        if (NumberUtil.flip(Math.min(drops.size() * 0.03, BLOCK_BREAK_DROP_CHANCE) * (1 + fortune * 0.5))) {
            // Slightly lower the drop chance in items with few drops
            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), drops.generate());
        }
    }

    @EventHandler
    public void onMobKill(EntityDeathEvent e) {
        final LootTable<ItemStack> drops = getDrops(e.getEntityType());
        if (drops == null)
            return;

        final Player killer = e.getEntity().getKiller();
        final int looting = (killer == null || killer.getInventory().getItemInMainHand() == null) ? 0
            : killer.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
        if (NumberUtil.flip(MOB_KILL_DROP_CHANCE * (1 + looting * 0.5))) {
            e.getDrops().add(drops.generate());
        }
    }

    public static void setup() {
        Bukkit.getPluginManager().registerEvents(new WildHarvestListener(), Gastronomicon.getInstance());
        BLOCK_BREAK_DROP_CHANCE = Gastronomicon.getInstance().getConfig().getDouble("drops.block-break-chance");
        MOB_KILL_DROP_CHANCE = Gastronomicon.getInstance().getConfig().getDouble("drops.mob-kill-chance");
    }

}
