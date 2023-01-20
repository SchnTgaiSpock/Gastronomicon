package io.github.schntgaispock.gastronomicon.core.food;

import java.util.function.BiConsumer;
import java.util.logging.Level;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.util.GastroUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class FoodEffect {

    private static final double PERFECT_MULTIPLIER_HEALTH = 1.25;
    private static final double PERFECT_MULTIPLIER_DURATION = 1.25;
    private static final double PERFECT_MULTIPLIER_XP = 1.25;
    private static final double PERFECT_MULTIPLIER_ITEM_AMOUNT = 1.5;
    private static final double PERFECT_MULTIPLIER_AIR = 1.5;
    private static final double PERFECT_MULTIPLIER_WARM = 1.5;
    private static final double PERFECT_MULTIPLIER_TELEPORT = 1.25;
    private static final double PERFECT_MULTIPLIER_CHANCE = 1.5;
    private static final double PERFECT_MULTIPLIER_VELOCITY = 1.25;
    private static final int PERFECT_BONUS_POTION_LEVEL = 1;

    private final @Getter String description;
    private final @Getter String perfectDescription;
    private final BiConsumer<Player, Boolean> application;

    public FoodEffect(String description, BiConsumer<Player, Boolean> application) {
        this(description, description, application);
    }

    public static FoodEffect chanceOf(FoodEffect effect, double chance) {
        final double pc = chance * PERFECT_MULTIPLIER_CHANCE;
        return new FoodEffect(effect.getDescription() + " &f(" + GastroUtil.roundToPercent(chance, 4) + "%)",
                effect.getPerfectDescription() + " &f(" + GastroUtil.roundToPercent(pc, 4) + "%)",
                (Player player, Boolean isPerfect) -> {
                    if (GastroUtil.flip(isPerfect ? pc : chance)) {
                        effect.apply(player, isPerfect);
                    }
                });
    }

    /**
     * Returns a {@code FoodEffect} that heals the player.
     * 
     * @param health The amount of health that the food restores.
     *               If it is lower than 1, it will be set to 1
     * @return A {@code FoodEffect} that heals the player for {@code health} health.
     */
    @ParametersAreNonnullByDefault
    public static FoodEffect heal(int health) {
        final int h = GastroUtil.clampLower(health, 1);
        final int ph = (int) Math.ceil(h * PERFECT_MULTIPLIER_HEALTH);
        return new FoodEffect("&aHealth +" + h, "&aHealth +" + ph, (Player player, Boolean isPerfect) -> {
            player.setHealth(GastroUtil.clampUpper(player.getHealth() + (isPerfect ? ph : h),
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        });
    }

    @ParametersAreNonnullByDefault
    private static FoodEffect potionEffect(String color, PotionEffectType effectType, int durationSeconds,
            int amplifier,
            boolean ambience, boolean particles, boolean icon) {
        final int d = GastroUtil.clampLower(durationSeconds, 1);
        final int pd = (int) Math.ceil(d * PERFECT_MULTIPLIER_DURATION);
        final int a = GastroUtil.clampLower(amplifier, 0);
        final int pa = amplifier + PERFECT_BONUS_POTION_LEVEL;
        return new FoodEffect(
                color + effectType.getName() + " " + GastroUtil.asRomanNumeral(a - 1) + " (" + d + "s)",
                color + effectType.getName() + " " + GastroUtil.asRomanNumeral(pa - 1) + " (" + pd + "s)",
                (Player player, Boolean isPerfect) -> {
                    player.addPotionEffect(new PotionEffect(effectType, 20 * (isPerfect ? pd : d), (isPerfect ? pa : a),
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
    public static FoodEffect positivePotionEffect(PotionEffect effect) {
        return positivePotionEffect(effect.getType(), effect.getDuration(), effect.getAmplifier(), effect.isAmbient(),
                effect.hasParticles(), effect.hasIcon());
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
    public static FoodEffect negativePotionEffect(PotionEffect effect) {
        return negativePotionEffect(effect.getType(), effect.getDuration(), effect.getAmplifier(), effect.isAmbient(),
                effect.hasParticles(), effect.hasIcon());
    }

    public static FoodEffect removePotionEffect(PotionEffectType type) {
        final String desc = "&fClears " + type.getName() + " effects";
        return new FoodEffect(desc, desc, (Player player, Boolean isPerfect) -> {
            player.removePotionEffect(type);
        });
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect xp(int xp) {
        final int x = GastroUtil.clampLower(xp, 1);
        final int px = (int) Math.ceil(x * PERFECT_MULTIPLIER_XP);
        return new FoodEffect("&eXP +" + Math.round(x), "&eXP +" + px, (Player player, Boolean isPerfect) -> {
            player.giveExp(isPerfect ? px : x);
        });
    }

    private static FoodEffect _giveItem(ItemStack item) {
        final int a = item.getAmount();
        final int pa = (int) Math.ceil(a * PERFECT_MULTIPLIER_ITEM_AMOUNT);
        final String name = item.hasItemMeta() ? item.getItemMeta().getDisplayName() : item.getType().name();
        return new FoodEffect(
                "&7Gives " + a + "x " + name,
                "&7Gives " + pa + "x " + name,
                (Player player, Boolean isPerfect) -> {
                    player.getInventory().addItem(item);
                });
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect giveItem(ItemStack item, int amount) {
        final ItemStack clone = item.clone();
        clone.setAmount(amount);
        return _giveItem(item);
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect giveItem(ItemStack item) {
        return _giveItem(item.clone());
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect giveItem(Material material, int amount) {
        return _giveItem(new ItemStack(material, amount));
    }

    @ParametersAreNonnullByDefault
    public static FoodEffect giveItem(Material material) {
        return _giveItem(new ItemStack(material));
    }

    public static FoodEffect giveSlimefunItem(@Nonnull String id, int amount) {
        final SlimefunItem sfItem = SlimefunItem.getById(id);
        if (sfItem == null) {
            Gastronomicon.log(Level.WARNING, "Cannot produce a FoodEffect that gives Slimefun item \"" + id +
                    "\" because it doesn't exist. Make sure to keep Slimefun and addons up to date!");
            return giveItem(Material.AIR, 1);
        }
        return giveItem(sfItem.getItem());
    }

    public static FoodEffect giveSlimefunItem(@Nonnull String id) {
        final SlimefunItem sfItem = SlimefunItem.getById(id);
        if (sfItem == null) {
            Gastronomicon.log(Level.WARNING, "Cannot produce a FoodEffect that gives Slimefun item \"" + id +
                    "\" because it doesn't exist. Make sure to keep Slimefun and addons up to date!");
            return giveItem(Material.AIR, 1);
        }
        return giveItem(sfItem.getItem().clone());
    }

    public static FoodEffect air(int amount) {
        final int a = GastroUtil.clampLower(amount, 1);
        final int pa = (int) Math.ceil(a * PERFECT_MULTIPLIER_AIR);
        return new FoodEffect("&aAir +" + a, "&aAir +" + pa, (Player player, Boolean isPerfect) -> {
            player.setRemainingAir(GastroUtil.clampUpper(player.getRemainingAir() + (isPerfect ? pa : a), 20));
        });
    }

    public static FoodEffect warm(int amount) {
        final int a = GastroUtil.clampLower(amount, 1);
        final int pa = (int) Math.ceil(a * PERFECT_MULTIPLIER_WARM);
        return new FoodEffect("&aWarmth +" + a, "&aWarmth +" + pa, (Player player, Boolean isPerfect) -> {
            player.setFreezeTicks(GastroUtil.clampLower(player.getFreezeTicks() - (isPerfect ? pa : a), 0));
        });
    }

    public static FoodEffect teleport(int radius) {
        final int r = GastroUtil.clamp(radius, 1, 10);
        final int pr = (int) Math.ceil(r * PERFECT_MULTIPLIER_TELEPORT);
        return new FoodEffect("&7Teleports you " + r + " blocks away", "&7Teleports you " + pr + " blocks away",
                (Player player, Boolean isPerfect) -> {
                    Location playerLocation = player.getLocation();
                    int playerX = (int) playerLocation.getX();
                    int playerY = (int) playerLocation.getY();
                    int playerZ = (int) playerLocation.getZ();
                    int teleportRadius = isPerfect ? pr : r;
                    // Performs 10 + radius^3 tries, if it can't find a safe spot to teleport to, it
                    // stops
                    for (int i = 0; i < 10 + Math.pow(r, 3); i++) {
                        int newX = playerX + GastroUtil.getRandom().nextInt(teleportRadius);
                        int newY = playerY + GastroUtil.getRandom().nextInt(teleportRadius);
                        int newZ = playerZ + GastroUtil.getRandom().nextInt(teleportRadius);

                        if (player.getWorld().getBlockAt(newX, newY - 1, newZ).getType().isSolid() &&
                                player.getWorld().getBlockAt(newX, newY, newZ).isEmpty() &&
                                player.getWorld().getBlockAt(newX, newY + 1, newZ).isEmpty()) {
                            player.teleport(new Location(player.getWorld(), newX, newY, newZ));
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,
                                    SoundCategory.PLAYERS, 1.0f, 1.0f);
                            return;
                        }
                    }
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMITE_AMBIENT, SoundCategory.PLAYERS, 1.0f,
                            1.0f);
                });
    }

    // public static FoodEffect teleportTo(double dx, double dy, double dz) {
    // final int r = GastroUtil.clamp(radius, 1, 10);
    // final int pr = (int) Math.ceil(r * PERFECT_MULTIPLIER_TELEPORT);
    // return new FoodEffect("&7Teleports you " + r + " blocks away", "&7Teleports
    // you " + pr + " blocks away",
    // (Player player, Boolean isPerfect) -> {
    // Location playerLocation = player.getLocation();
    // int playerX = (int) playerLocation.getX();
    // int playerY = (int) playerLocation.getY();
    // int playerZ = (int) playerLocation.getZ();
    // int teleportRadius = isPerfect ? pr : r;
    // // Performs 10 + radius^3 tries, if it can't find a safe spot to teleport to,
    // it
    // // stops
    // for (int i = 0; i < 10 + Math.pow(r, 3); i++) {
    // int newX = playerX + GastroUtil.getRandom().nextInt(teleportRadius);
    // int newY = playerY + GastroUtil.getRandom().nextInt(teleportRadius);
    // int newZ = playerZ + GastroUtil.getRandom().nextInt(teleportRadius);

    // if (player.getWorld().getBlockAt(newX, newY - 1, newZ).getType().isSolid() &&
    // player.getWorld().getBlockAt(newX, newY, newZ).isEmpty() &&
    // player.getWorld().getBlockAt(newX, newY + 1, newZ).isEmpty()) {
    // player.teleport(new Location(player.getWorld(), newX, newY, newZ));
    // player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,
    // SoundCategory.PLAYERS, 1.0f, 1.0f);
    // return;
    // }
    // }
    // player.playSound(player.getLocation(), Sound.ENTITY_ENDERMITE_AMBIENT,
    // SoundCategory.PLAYERS, 1.0f,
    // 1.0f);
    // });
    // }

    public static FoodEffect move(Vector velocity, String description) {
        final Vector pv = velocity.multiply(PERFECT_MULTIPLIER_VELOCITY);
        return new FoodEffect(description, description, (Player player, Boolean isPerfect) -> {
            player.setVelocity(player.getVelocity().add(isPerfect ? pv : velocity));
        });
    };

    private static final FoodEffect extinguish = new FoodEffect("&fExtinguish yourself",
            (Player player, Boolean isPerfect) -> {
                player.setFireTicks(0);
            });

    public static FoodEffect extinguish() {
        return extinguish;
    }

    private static final FoodEffect clearPotionEffects = new FoodEffect("&fClear all effects",
            (Player player, Boolean isPerfect) -> {
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),
                        "/effect " + player.getName() + " clear");
            });

    public static FoodEffect clearPotionEffects() {
        return clearPotionEffects;
    }

    public void apply(Player player, boolean isPerfect) {
        application.accept(player, isPerfect);
    }

}
