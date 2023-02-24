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

}
