package io.github.schntgaispock.gastronomicon.core.items.stacks;


import lombok.Getter;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;

@UtilityClass
public final class GastroTheme {
    public static enum Theme {
        WTOOL("#ffffff"),
        TOOL("#55ffff"),
        INGREDIENT("#ffff55"),
        MECHANICAL("#23ef23"),
        TRAP("#efaf23"),
        REGULAR_FOOD("#2364ef"),
        PERFECT_FOOD("#af23ef");

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
