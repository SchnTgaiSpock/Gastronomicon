package io.github.schntgaispock.gastronomicon.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
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

    public static int randomRound(double x) {
        final int f = (int) Math.floor(x);
        final int c = (int) Math.ceil(x);
        if (f == c) return f;

        return (random.nextDouble() < (x - f)) ? f : c;
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

}
