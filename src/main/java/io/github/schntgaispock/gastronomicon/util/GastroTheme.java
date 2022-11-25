package io.github.schntgaispock.gastronomicon.util;


import lombok.Getter;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;

@UtilityClass
public final class GastroTheme {
    public static enum Theme {
        MECHANICAL("#999999"),
        WTOOL("#666666"),
        TRAP("#e5c730"),
        TOOL("&7"),
        RECIPE("#eeeeee"),
        INGREDIENT("#4ee530"),
        REGULAR_FOOD("#304ee5"),
        PERFECT_FOOD("#c730e5", "#c3a3cc");

        private @Getter ChatColor color;
        private @Getter ChatColor loreColor;

        Theme(String color, String loreColor) {
            this.color = ChatColor.of(color);
            this.loreColor = ChatColor.of(loreColor);
        }

        Theme(String color) {
            this(color, "#aaaaaa");
        }
    }
}
