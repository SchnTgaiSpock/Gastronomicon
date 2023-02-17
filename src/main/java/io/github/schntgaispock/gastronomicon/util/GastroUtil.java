package io.github.schntgaispock.gastronomicon.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
@SuppressWarnings("null")
public class GastroUtil {
    
    private static @Getter ThreadLocalRandom random = ThreadLocalRandom.current();
    
    public static int clamp(int x, int lowerBound, int upperBound) {
        if (x < lowerBound) return lowerBound;
        else if (x > upperBound) return upperBound;
        else return x;
    }

    public static int clampLower(int x, int lowerBound) {
        return x < lowerBound ? lowerBound : x;
    }

    public static int clampUpper(int x, int upperBound) {
        return x > upperBound ? upperBound : x;
    }
    
    public static double clamp(double x, double lowerBound, double upperBound) {
        if (x < lowerBound) return lowerBound;
        else if (x > upperBound) return upperBound;
        else return x;
    }

    public static double clampLower(double x, double lowerBound) {
        return x < lowerBound ? lowerBound : x;
    }

    public static double clampUpper(double x, double upperBound) {
        return x > upperBound ? upperBound : x;
    }

    public static String asRomanNumeral(int x) {
        if (x >= 4000) return Integer.toString(x);
        String[] thousands = {"", "M", "MM", "MMM"};  
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};  
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};  
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};  
        return thousands[x / 1000] + hundreds[(x / 100) % 10] + tens[(x / 10) % 10] + ones[x % 10];
    }

    @Nonnull
    public static String formatColors(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static boolean flip(double chance) {
        return random.nextDouble(1) < chance;
    }

    public static int randomRound(double x) {
        final int f = (int) Math.floor(x);
        final int c = (int) Math.ceil(x);
        if (f == c) return f;

        return flip(x - f) ? f : c;
    }

    public static double roundToPrecision(double x, int precision) {
        final double magn = Math.pow(10, precision);
        return Math.round(x * magn) / magn;
    }

    public static double roundToPercent(double x, int precision) {
        return roundToPrecision(x*100, precision);
    }

    public static <K, V> Map<K, V> toMap(K key, V value) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(key, value);
        return map;
    }

    public static int hashIgnoreAmount(ItemStack stack) {
        int hash = 1;

        hash = hash * 31 + stack.getType().hashCode();
        hash = hash * 31 + (stack.hasItemMeta() ? stack.getItemMeta().hashCode() : 0);

        return hash;
    }

    public static int getFortuneAmount(int fortuneLevel, int sickleTier) {
        return getFortuneAmount(fortuneLevel, sickleTier + 1);
    }

    public static int getFortuneAmount(int fortuneLevel, double multiplier) {
        return randomRound(multiplier * (Math.sqrt(fortuneLevel + 1) + 1) / 2);
    }

    public static boolean checkPermission(Player player, @Nonnull String permissionNode, @Nullable String message) {
        if (player.hasPermission(permissionNode)) {
            return true;
        }

        if (message != null) player.sendMessage(message);
        return false;

    }

}
