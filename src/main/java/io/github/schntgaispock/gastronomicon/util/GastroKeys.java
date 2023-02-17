package io.github.schntgaispock.gastronomicon.util;

import org.bukkit.NamespacedKey;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroKeys {
    
    public static final NamespacedKey TOOL_DURABILITY = Gastronomicon.newNamespacedKey("durability");
    public static final NamespacedKey TOOL_MAX_DURABILITY = Gastronomicon.newNamespacedKey("max_durability");
    public static final NamespacedKey TOOL_DURABILITY_LINE = Gastronomicon.newNamespacedKey("durability_line");

}
