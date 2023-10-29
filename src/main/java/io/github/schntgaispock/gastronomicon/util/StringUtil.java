package io.github.schntgaispock.gastronomicon.util;

import javax.annotation.Nonnull;

import org.bukkit.ChatColor;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtil {

    @Nonnull
    public static String formatColors(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static String waterUsed(int mB, String suffix) {
        return "&8⇨ &9🪣 &7" + mB + " mB" + suffix;
    }

    public static String kebabCase(String str) {
        return str.replace("_", "-").replace(" ", "-").toLowerCase();
    }

}
