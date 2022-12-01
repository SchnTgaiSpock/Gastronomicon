package io.github.schntgaispock.gastronomicon.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroUtil {
    
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

}
