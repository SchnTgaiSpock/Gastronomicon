package io.github.schntgaispock.gastronomicon.core.listeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;

public class WildHarvestListener implements Listener {

    // TODO: Fortune, Looting, LoTS

    private static final Map<Material, List<ItemStack>> dropsByBlock = new HashMap<>();
    private static final Map<EntityType, List<ItemStack>> dropsByMob = new HashMap<>();
    private static final Map<Material, List<ItemStack>> dropsByFish = new HashMap<>();

    private static double BLOCK_BREAK_DROP_CHANCE;
    private static double MOB_KILL_DROP_CHANCE;

    @ParametersAreNonnullByDefault
    public static void registerDrops(Material dropFrom, ItemStack... drops) {
        for (ItemStack drop : drops) {
            if (dropsByBlock.containsKey(dropFrom)) {
                dropsByBlock.get(dropFrom).add(drop);
            } else {
                final List<ItemStack> newSet = new ArrayList<>();
                newSet.add(drop);
                dropsByBlock.put(dropFrom, newSet);
            }
        }
    }

    @ParametersAreNonnullByDefault
    public static void registerDrops(EntityType dropFrom, ItemStack... drops) {
        for (ItemStack drop : drops) {
            if (dropsByMob.containsKey(dropFrom)) {
                dropsByMob.get(dropFrom).add(drop);
            } else {
                final List<ItemStack> newSet = new ArrayList<>();
                newSet.add(drop);
                dropsByMob.put(dropFrom, newSet);
            }
        }
    }

    @Nullable
    public static List<ItemStack> getDrops(@Nonnull Material dropFrom) {
        return Collections.unmodifiableList(dropsByBlock.get(dropFrom));
    }

    @Nullable
    public static List<ItemStack> getDrops(@Nonnull EntityType dropFrom) {
        return Collections.unmodifiableList(dropsByMob.get(dropFrom));
    }

    @Nullable
    public static List<ItemStack> getFishingDrops(@Nonnull Material dropFrom) {
        return Collections.unmodifiableList(dropsByFish.get(dropFrom));
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        final Block b = e.getBlock();
        if (b == null) return;

        final List<ItemStack> drops = getDrops(b.getType());
        if (drops == null) return;

        if (NumberUtil.flip(BLOCK_BREAK_DROP_CHANCE)) {
            final ItemStack drop = drops.get(NumberUtil.getRandom().nextInt(drops.size()));
            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), drop);
        }
    }

    @EventHandler
    public void onMobKill(EntityDeathEvent e) {
        final List<ItemStack> drops = getDrops(e.getEntityType());
        if (drops == null) return;

        if (NumberUtil.flip(MOB_KILL_DROP_CHANCE)) {
            final ItemStack drop = drops.get(NumberUtil.getRandom().nextInt(drops.size()));
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), drop);
        }
    }

    @EventHandler
    public void onFish(PlayerFishEvent e) {
        if (!(e.getCaught() instanceof final Item item)) return;

        final List<ItemStack> drops = getFishingDrops(item.getItemStack().getType());
        if (drops == null) return;

        if (NumberUtil.flip(0.25)) {
            final ItemStack drop = drops.get(NumberUtil.getRandom().nextInt(drops.size()));
            item.setItemStack(drop);
        }
    }

    public static void setup() {
        Bukkit.getPluginManager().registerEvents((Listener) new WildHarvestListener(), Gastronomicon.getInstance());
        BLOCK_BREAK_DROP_CHANCE = Gastronomicon.getInstance().getConfig().getDouble("drops.block-break-chance");
        MOB_KILL_DROP_CHANCE = Gastronomicon.getInstance().getConfig().getDouble("drops.mob-kill-chance");
    }

}
