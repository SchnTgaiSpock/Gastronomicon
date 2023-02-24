package io.github.schntgaispock.gastronomicon.core.items.stacks;


import lombok.Getter;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;

@UtilityClass
public final class GastroTheme {
    public static enum Theme {
        MECHANICAL("#23caef"),
        WTOOL("#aaaaaa"),
        TRAP("#efaf23"),
        TOOL("#cccccc"),
        RECIPE("#eeeeee"),
        INGREDIENT("#ffffff"),
        REGULAR_FOOD("#2364ef"),
        PERFECT_FOOD("#af23ef");

        private @Getter ChatColor color;
        private @Getter ChatColor loreColor;

        Theme(String color, String loreColor) {
            this.color = ChatColor.of(color);
            this.loreColor = ChatColor.of(loreColor);
        }

        Theme(String color) {
            this(color, "#777777");
        }
    }
}
