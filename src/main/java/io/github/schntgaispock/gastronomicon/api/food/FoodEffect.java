package io.github.schntgaispock.gastronomicon.api.food;

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
import io.github.schntgaispock.gastronomicon.core.slimefun.items.food.GastroFood;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.schntgaispock.gastronomicon.util.item.ItemUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Represents an effect that activates when a player eats a {@link GastroFood}
 * 
 * @author SchnTgaiSpock
 */
@RequiredArgsConstructor
@SuppressWarnings("deprecation")
@ToString(of = "description")
@EqualsAndHashCode(of = "description")
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

    private final @Nonnull @Getter String description;
    private final @Nonnull @Getter String perfectDescription;
    private final @Nonnull BiConsumer<Player, Boolean> application;

    public FoodEffect(String description, BiConsumer<Player, Boolean> application) {
        this(description, description, application);
    }

    /**
     * Returns a FoodEffect that has a chance of activating
     * 
     * @param effect
     *            The effect to activate
     * @param chance
     *            The chance to activate, [0 ... 1]
     * @return A FoodEffect that has a chance of activating
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect chanceOf(FoodEffect effect, double chance) {
        final double pc = chance * PERFECT_MULTIPLIER_CHANCE;
        return new FoodEffect(effect.getDescription() + " &8(" + NumberUtil.roundToPercent(chance, 4) + "%)",
            effect.getPerfectDescription() + " &8(" + NumberUtil.roundToPercent(pc, 4) + "%)",
            (Player player, Boolean isPerfect) -> {
                if (NumberUtil.flip(isPerfect ? pc : chance)) {
                    effect.apply(player, isPerfect);
                }
            });
    }

    /**
     * Returns a FoodEffect that heals the player.
     * 
     * @param health
     *            The amount of health that the food restores.
     *            If it is lower than 1, it will be set to 1
     * @return A FoodEffect that heals the player for {@code health} health.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect heal(int health) {
        final int h = Math.max(health, 1);
        final int ph = (int) Math.ceil(h * PERFECT_MULTIPLIER_HEALTH);
        return new FoodEffect("&aHealth +" + h, "&aHealth +" + ph, (Player player, Boolean isPerfect) -> {
            player.setHealth(Math.min(player.getHealth() + (isPerfect ? ph : h),
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        });
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    private static FoodEffect potionEffect(String color, PotionEffectType effectType, int durationSeconds,
        int amplifier,
        boolean ambience, boolean particles, boolean icon) {
        final int d = Math.max(durationSeconds, 1);
        final int pd = (int) Math.ceil(d * PERFECT_MULTIPLIER_DURATION);
        final int a = Math.max(amplifier, 0);
        final int pa = amplifier + PERFECT_BONUS_POTION_LEVEL;
        return new FoodEffect(
            color + ItemUtil.getPotionName(effectType) + " " + NumberUtil.asRomanNumeral(a + 1) + " (" + d + "s)",
            color + ItemUtil.getPotionName(effectType) + " " + NumberUtil.asRomanNumeral(pa + 1) + " (" + pd + "s)",
            (Player player, Boolean isPerfect) -> {
                player.addPotionEffect(new PotionEffect(effectType, 20 * (isPerfect ? pd : d), (isPerfect ? pa : a),
                    ambience, particles, icon));
            });
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a blue text
     * 
     * @param effectType
     *            The effect to apply
     * @param durationSeconds
     *            The duration in <b>seconds</b>
     * @param amplifier
     *            The strength of the effect (0 -> I, 1 -> II, etc.)
     * @param ambience
     *            See {@link PotionEffect#isAmbient}
     * @param particles
     *            See {@link PotionEffect#hasParticles}
     * @param icon
     *            See {@link PotionEffect#hasIcon}
     * @return A FoodEffect that applies a potion effect to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect positivePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
        boolean ambience, boolean particles, boolean icon) {
        return potionEffect("&9", effectType, durationSeconds, amplifier, ambience, particles, icon);
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a blue text
     * 
     * @param effectType
     *            The effect to apply
     * @param durationSeconds
     *            The duration in <b>seconds</b>
     * @param amplifier
     *            The strength of the effect (0 -> I, 1 -> II, etc.)
     * @param ambience
     *            See {@link PotionEffect#isAmbient}
     * @param particles
     *            See {@link PotionEffect#hasParticles}
     * @return A FoodEffect that applies a potion effect to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect positivePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
        boolean ambience, boolean particles) {
        return positivePotionEffect(effectType, durationSeconds, amplifier, ambience, particles, particles);
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a blue text
     * 
     * @param effectType
     *            The effect to apply
     * @param durationSeconds
     *            The duration in <b>seconds</b>
     * @param amplifier
     *            The strength of the effect (0 -> I, 1 -> II, etc.)
     * @param ambience
     *            See {@link PotionEffect#isAmbient}
     * @return A FoodEffect that applies a potion effect to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect positivePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
        boolean ambience) {
        return positivePotionEffect(effectType, durationSeconds, amplifier, ambience, true);
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a blue text
     * 
     * @param effectType
     *            The effect to apply
     * @param durationSeconds
     *            The duration in <b>seconds</b>
     * @param amplifier
     *            The strength of the effect (0 -> I, 1 -> II, etc.)
     * @return A FoodEffect that applies a potion effect to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect positivePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier) {
        return positivePotionEffect(effectType, durationSeconds, amplifier, true);
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a blue text
     * 
     * @param effectType
     *            The effect to apply
     * @param durationSeconds
     *            The duration in <b>seconds</b>
     * @return A FoodEffect that applies a potion effect to the player. Has an
     *         amplifier of 0 (I)
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect positivePotionEffect(PotionEffectType effectType, int durationSeconds) {
        return positivePotionEffect(effectType, durationSeconds, 0);
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a blue text
     * 
     * @param effect
     *            The effect to apply
     * @return A FoodEffect that applies a potion effect to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect positivePotionEffect(PotionEffect effect) {
        return positivePotionEffect(effect.getType(), effect.getDuration(), effect.getAmplifier(), effect.isAmbient(),
            effect.hasParticles(), effect.hasIcon());
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a red text
     * 
     * @param effectType
     *            The effect to apply
     * @param durationSeconds
     *            The duration in <b>seconds</b>
     * @param amplifier
     *            The strength of the effect (0 -> I, 1 -> II, etc.)
     * @param ambience
     *            See {@link PotionEffect#isAmbient}
     * @param particles
     *            See {@link PotionEffect#hasParticles}
     * @param icon
     *            See {@link PotionEffect#hasIcon}
     * @return A FoodEffect that applies a potion effect to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect negativePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
        boolean ambience, boolean particles, boolean icon) {
        return potionEffect("&c", effectType, durationSeconds, amplifier, ambience, particles, icon);
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a red text
     * 
     * @param effectType
     *            The effect to apply
     * @param durationSeconds
     *            The duration in <b>seconds</b>
     * @param amplifier
     *            The strength of the effect (0 -> I, 1 -> II, etc.)
     * @param ambience
     *            See {@link PotionEffect#isAmbient}
     * @param particles
     *            See {@link PotionEffect#hasParticles}
     * @return A FoodEffect that applies a potion effect to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect negativePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
        boolean ambience, boolean particles) {
        return negativePotionEffect(effectType, durationSeconds, amplifier, ambience, particles, particles);
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a red text
     * 
     * @param effectType
     *            The effect to apply
     * @param durationSeconds
     *            The duration in <b>seconds</b>
     * @param amplifier
     *            The strength of the effect (0 -> I, 1 -> II, etc.)
     * @param ambience
     *            See {@link PotionEffect#isAmbient}
     * @return A FoodEffect that applies a potion effect to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect negativePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier,
        boolean ambience) {
        return negativePotionEffect(effectType, durationSeconds, amplifier, ambience, true);
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a red text
     * 
     * @param effectType
     *            The effect to apply
     * @param durationSeconds
     *            The duration in <b>seconds</b>
     * @param amplifier
     *            The strength of the effect (0 -> I, 1 -> II, etc.)
     * @return A FoodEffect that applies a potion effect to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect negativePotionEffect(PotionEffectType effectType, int durationSeconds, int amplifier) {
        return negativePotionEffect(effectType, durationSeconds, amplifier, true);
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a red text
     * 
     * @param effectType
     *            The effect to apply
     * @param durationSeconds
     *            The duration in <b>seconds</b>
     * @return A FoodEffect that applies a potion effect to the player. Has an
     *         amplifier of 0 (I)
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect negativePotionEffect(PotionEffectType effectType, int durationSeconds) {
        return negativePotionEffect(effectType, durationSeconds, 0);
    }

    /**
     * Returns a FoodEffect that applies a potion effect to the player. Formatted in
     * a red text
     * 
     * @param effect
     *            The effect to apply
     * @return A FoodEffect that applies a potion effect to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect negativePotionEffect(PotionEffect effect) {
        return negativePotionEffect(effect.getType(), effect.getDuration(), effect.getAmplifier(), effect.isAmbient(),
            effect.hasParticles(), effect.hasIcon());
    }

    /**
     * Returns a FoodEffect that removes the specified potion effect from the
     * player.
     * 
     * @param type
     *            The effect type to remove
     * @return A FoodEffect that removes the specified potion effect from the
     *         player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect removePotionEffect(PotionEffectType type) {
        final String desc = "&bClears " + ItemUtil.getPotionName(type) + " effects";
        return new FoodEffect(desc, desc, (Player player, Boolean isPerfect) -> {
            player.removePotionEffect(type);
        });
    }

    /**
     * Returns a FoodEffect that gives the specified amount of xp to the player.
     * 
     * @param xp
     *            The amount of xp to give
     * @return A FoodEffect that gives the specified amount of xp to the player.
     */
    @Nonnull
    public static FoodEffect xp(int xp) {
        final int x = Math.max(xp, 1);
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

    /**
     * Returns a FoodEffect that gives the specified item to the player.
     * 
     * @param item
     *            The item to give
     * @param amount
     *            The amount to give
     * @return A FoodEffect that gives the specified item to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect giveItem(ItemStack item, int amount) {
        final ItemStack clone = item.clone();
        clone.setAmount(amount);
        return _giveItem(item);
    }

    /**
     * Returns a FoodEffect that gives the specified item to the player.
     * 
     * @param item
     *            The item to give
     * @return A FoodEffect that gives the specified item to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect giveItem(ItemStack item) {
        return _giveItem(item.clone());
    }

    /**
     * Returns a FoodEffect that gives the specified item to the player.
     * 
     * @param material
     *            The type of item to give
     * @param amount
     *            The amount to give
     * @return A FoodEffect that gives the specified item to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect giveItem(Material material, int amount) {
        return _giveItem(new ItemStack(material, amount));
    }

    /**
     * Returns a FoodEffect that gives the specified item to the player.
     * 
     * @param material
     *            The type of item to give
     * @return A FoodEffect that gives the specified item to the player.
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static FoodEffect giveItem(Material material) {
        return _giveItem(new ItemStack(material));
    }

    /**
     * Returns a FoodEffect that gives the specified Slimefun item to the player.
     * 
     * @param id
     *            The id of the item to give
     * @param amount
     *            The amount to give
     * @return A FoodEffect that gives the specified Slimefun item to the player.
     */
    public static FoodEffect giveSlimefunItem(@Nonnull String id, int amount) {
        final SlimefunItem sfItem = SlimefunItem.getById(id);
        if (sfItem == null) {
            Gastronomicon.log(Level.WARNING, "Cannot produce a FoodEffect that gives Slimefun item \"" + id +
                "\" because it doesn't exist. Make sure to keep Slimefun and addons up to date!");
            return giveItem(Material.AIR, 1);
        }
        return giveItem(sfItem.getItem());
    }

    /**
     * Returns a FoodEffect that gives the specified Slimefun item to the player.
     * 
     * @param id
     *            The id of the item to give
     * @return A FoodEffect that gives the specified Slimefun item to the player.
     */
    public static FoodEffect giveSlimefunItem(@Nonnull String id) {
        final SlimefunItem sfItem = SlimefunItem.getById(id);
        if (sfItem == null) {
            Gastronomicon.log(Level.WARNING, "Cannot produce a FoodEffect that gives Slimefun item \"" + id +
                "\" because it doesn't exist. Make sure to keep Slimefun and addons up to date!");
            return giveItem(Material.AIR, 1);
        }
        return giveItem(sfItem.getItem().clone());
    }

    /**
     * Returns a FoodEffect that gives the player air.
     * 
     * @param amount
     *            The amount of air to refill
     * @return A FoodEffect that gives the player air.
     */
    public static FoodEffect air(int amount) {
        final int a = Math.max(amount, 1);
        final int pa = (int) Math.ceil(a * PERFECT_MULTIPLIER_AIR);
        return new FoodEffect("&fAir +" + a, "&fAir +" + pa, (Player player, Boolean isPerfect) -> {
            player.setRemainingAir(Math.min(player.getRemainingAir() + (isPerfect ? pa : a), 20));
        });
    }

    /**
     * Returns a FoodEffect that warms the player.
     * 
     * @param amount
     *            The amount of freeze ticks to reduce
     * @return A FoodEffect that warms the player.
     */
    public static FoodEffect warm(int amount) {
        final int a = Math.max(amount, 1);
        final int pa = (int) Math.ceil(a * PERFECT_MULTIPLIER_WARM);
        return new FoodEffect("&6Warmth +" + a, "&6Warmth +" + pa, (Player player, Boolean isPerfect) -> {
            player.setFreezeTicks(Math.max(player.getFreezeTicks() - (isPerfect ? pa : a), 0));
        });
    }

    /**
     * Returns a FoodEffect that teleports the player within a certain radius
     * 
     * @param radius
     *            The teleport radius
     * @return A FoodEffect that teleports the player within a certain radius
     */
    public static FoodEffect teleport(int radius) {
        final int r = NumberUtil.clamp(radius, 1, 10);
        final int pr = (int) Math.ceil(r * PERFECT_MULTIPLIER_TELEPORT);
        return new FoodEffect("&7Teleports you somewhere within " + r + " blocks away",
            "&7Teleports you somewhere within " + pr + " blocks away",
            (Player player, Boolean isPerfect) -> {
                final Location playerLocation = player.getLocation();
                final int playerX = playerLocation.getBlockX();
                final int playerY = playerLocation.getBlockY();
                final int playerZ = playerLocation.getBlockZ();
                final int teleportRadius = isPerfect ? pr : r;
                // Performs 10 + radius^3 tries, if it can't find a safe spot to teleport to, it
                // stops.
                for (int i = 0; i < 10 + Math.pow(r, 3); i++) {
                    final int newX = playerX + NumberUtil.getRandom().nextInt(teleportRadius);
                    final int newY = playerY + NumberUtil.getRandom().nextInt(teleportRadius);
                    final int newZ = playerZ + NumberUtil.getRandom().nextInt(teleportRadius);

                    if (player.getWorld().getBlockAt(newX, newY - 1, newZ).getType().isSolid() &&
                        player.getWorld().getBlockAt(newX, newY, newZ).isEmpty() &&
                        player.getWorld().getBlockAt(newX, newY + 1, newZ).isEmpty()) {
                        
                        final Vector facing = player.getLocation().getDirection();
                        player.teleport(new Location(player.getWorld(), newX, newY, newZ));
                        player.getLocation().setDirection(facing);

                        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,
                            SoundCategory.PLAYERS, 1.0f, 1.0f);
                        return;
                    }
                }
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMITE_AMBIENT, SoundCategory.PLAYERS, 1.0f,
                    1.0f);
            });
    }

    /**
     * Returns a FoodEffect that launches the player in a certain direction
     * 
     * @param velocity
     *            The change in the players velocity
     * @param description
     *            The description of the FoodEffect.
     * @return A FoodEffect that launces the player in a certain direction
     */
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

    /**
     * @return A FoodEffect that extinguishes the player
     */
    public static FoodEffect extinguish() {
        return extinguish;
    }

    private static final FoodEffect clearPotionEffects = new FoodEffect("&fClear all effects",
        (Player player, Boolean isPerfect) -> {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),
                "/effect " + player.getName() + " clear");
        });

    /**
     * @return A FoodEffect that clears all potion effects on the player.
     */
    public static FoodEffect clearPotionEffects() {
        return clearPotionEffects;
    }

    /**
     * Applies this FoodEffects effects on the player.
     * 
     * @param player
     *            The player that ate this food
     * @param isPerfect
     *            Whether or not the food was perfect
     */
    public void apply(Player player, boolean isPerfect) {
        application.accept(player, isPerfect);
    }

}
