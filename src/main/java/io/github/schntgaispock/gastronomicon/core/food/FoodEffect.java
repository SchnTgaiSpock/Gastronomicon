package io.github.schntgaispock.gastronomicon.core.food;

import java.util.function.BiConsumer;
import java.util.logging.Level;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.util.GastroUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FoodEffect {

    private static final double PERFECT_MULTIPLIER_HEALTH = 1.25;
    private static final double PERFECT_MULTIPLIER_DURATION = 1.25;
    private static final double PERFECT_MULTIPLIER_XP = 1.25;
    private static final double PERFECT_MULTIPLIER_ITEM_AMOUNT = 1.5;
    private static final double PERFECT_MULTIPLIER_AIR = 1.5;
    private static final double PERFECT_MULTIPLIER_TELEPORT = 1.25;
    private static final int PERFECT_BONUS_POTION_LEVEL = 1;

    private final String description;
    private final String perfectDescription;
    private final BiConsumer<Player, Boolean> application;

    /**
     * Returns a {@code FoodEffect} that heals the player.
     * 
     * @param health The amount of health that the food restores.
     *               If it is lower than 1, it will be set to 1
     * @return A {@code FoodEffect} that heals the player for {@code health} health.
     */
    @ParametersAreNonnullByDefault
    public static FoodEffect heal(double health) {
        final double h = GastroUtil.clampLower(health, 1);
        final double ph = Math.round(h * PERFECT_MULTIPLIER_HEALTH);
        return new FoodEffect("&aHealth +" + Math.round(h), "&aHealth +" + ph, (Player player, Boolean isPerfect) -> {
            player.setHealth(GastroUtil.clampUpper(player.getHealth() + (isPerfect ? ph : h),
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        });
    }

    @ParametersAreNonnullByDefault
    private static FoodEffect potionEffect(String color, PotionEffectType effectType, int durationSeconds,
            int amplifier,
            boolean ambience, boolean particles, boolean icon) {
        final int d = GastroUtil.clampLower(durationSeconds, 1);
        final int pd = (int) Math.round(d * PERFECT_MULTIPLIER_DURATION);
        final int a = GastroUtil.clampLower(amplifier, 0);
        final int pa = amplifier + PERFECT_BONUS_POTION_LEVEL;
        return new FoodEffect(
                color + effectType.getName() + " " + GastroUtil.asRomanNumeral(a - 1) + " (" + d + "s)",
                color + effectType.getName() + " " + GastroUtil.asRomanNumeral(pa - 1) + " (" + pd + "s)",
                (Player player, Boolean isPerfect) -> {
                    player.addPotionEffect(new PotionEffect(effectType, (isPerfect ? pd : d), (isPerfect ? pa : a),
                            ambience, particles, icon));
                });
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect positivePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
            boolean ambience, boolean particles, boolean icon) {
        return potionEffect("&3", effectType, durationSeconds, amplifier, ambience, particles, icon);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect positivePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
            boolean ambience, boolean particles) {
        return positivePotionEffect(effectType, durationSeconds, amplifier, ambience, particles, particles);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect positivePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
            boolean ambience) {
        return positivePotionEffect(effectType, durationSeconds, amplifier, ambience, true);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect positivePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier) {
        return positivePotionEffect(effectType, durationSeconds, amplifier, true);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect positivePotionEffect(PotionEffectType effectType, int durationSeconds) {
        return positivePotionEffect(effectType, durationSeconds, 0);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect negativePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
            boolean ambience, boolean particles, boolean icon) {
        return potionEffect("&c", effectType, durationSeconds, amplifier, ambience, particles, icon);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect negativePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
            boolean ambience, boolean particles) {
        return negativePotionEffect(effectType, durationSeconds, amplifier, ambience, particles, particles);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect negativePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
            boolean ambience) {
        return negativePotionEffect(effectType, durationSeconds, amplifier, ambience, true);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect negativePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier) {
        return negativePotionEffect(effectType, durationSeconds, amplifier, true);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect negativePotionEffect(PotionEffectType effectType, int durationSeconds) {
        return negativePotionEffect(effectType, durationSeconds, 0);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect xp(int xp) {
        final int x = GastroUtil.clampLower(xp, 1);
        final int px = (int) Math.round(x * PERFECT_MULTIPLIER_XP);
        return new FoodEffect("&eXP +" + Math.round(x), "&eXP +" + px, (Player player, Boolean isPerfect) -> {
            player.giveExp(isPerfect ? px : x);
        });
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect giveItem(Material material, int amount) {
        final int a = GastroUtil.clampLower(amount, 1);
        final int pa = (int) Math.round(a * PERFECT_MULTIPLIER_ITEM_AMOUNT);
        final String name = material.name();
        return new FoodEffect(
                "&7Gives " + a + "x " + name,
                "&7Gives " + pa + "x " + name,
                (Player player, Boolean isPerfect) -> {
                    player.getInventory().addItem(new ItemStack(material, amount));
                });
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect giveItem(Material material) {
        return giveItem(material, 1);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect giveItem(ItemStack item) {
        return giveItem(item.getType(), item.getAmount());
    }

    public static FoodEffect giveSlimefunItem(@Nonnull String id, int amount) {
        final SlimefunItem sfItem = SlimefunItem.getById(id);
        if (sfItem == null) {
            Gastronomicon.log(Level.WARNING, "Cannot produce a FoodEffect that gives Slimefun item \"" + id +
                    "\" because it doesn't exist. Make sure to keep your installed addons up to date!");
            return giveItem(Material.AIR, 1);
        }
        final ItemStack item = sfItem.getItem().clone();
        item.setAmount(amount);
        return giveItem(item);
    }

    public static FoodEffect giveSlimefunItem(@Nonnull String id) {
        final SlimefunItem sfItem = SlimefunItem.getById(id);
        if (sfItem == null) {
            Gastronomicon.log(Level.WARNING, "Cannot produce a FoodEffect that gives Slimefun item \"" + id +
                    "\" because it doesn't exist. Make sure to keep your installed addons up to date!");
            return giveItem(Material.AIR, 1);
        }
        return giveItem(sfItem.getItem().clone());
    }

    public static FoodEffect air(int amount) {
        final int a = GastroUtil.clampLower(amount, 1);
        final int pa = (int) Math.round(a * PERFECT_MULTIPLIER_AIR);
        return new FoodEffect("&aAir +" + a, "&aAir +" + pa, (Player player, Boolean isPerfect) -> {
            player.setRemainingAir(GastroUtil.clampUpper(player.getRemainingAir() + (isPerfect ? pa : a), 20));
        });
    }

    public static FoodEffect teleport(int radius) {
        final int r = GastroUtil.clamp(radius, 1, 10);
        final int pr = (int) Math.round(r * PERFECT_MULTIPLIER_TELEPORT);
        return new FoodEffect("&7Teleports you " + r + " blocks away", "&7Teleports you " + pr + " blocks away",
                (Player player, Boolean isPerfect) -> {
                    Location playerLocation = player.getLocation();
                    int playerX = (int) playerLocation.getX();
                    int playerY = (int) playerLocation.getY();
                    int playerZ = (int) playerLocation.getZ();
                    int teleportRadius = isPerfect ? pr : r;
                    // Performs radius^3 tries, if it can't find a safe spot to teleport to, it
                    // stops
                    for (int i = 0; i < Math.pow(r, 3); i++) {
                        int newX = playerX + Gastronomicon.getRandom().nextInt(teleportRadius);
                        int newY = playerY + Gastronomicon.getRandom().nextInt(teleportRadius);
                        int newZ = playerZ + Gastronomicon.getRandom().nextInt(teleportRadius);

                        if (player.getWorld().getBlockAt(newX, newY - 1, newZ).getType().isSolid() &&
                                player.getWorld().getBlockAt(newX, newY, newZ).isEmpty() &&
                                player.getWorld().getBlockAt(newX, newY + 1, newZ).isEmpty()) {
                            player.teleport(new Location(player.getWorld(), newX, newY, newZ));
                            // TODO: Play teleport sound
                            return;
                        }
                    }
                    // TODO: Play no teleport sound
                });
    }

}
