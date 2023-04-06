package io.github.schntgaispock.gastronomicon.api.items;

import lombok.Getter;
import net.md_5.bungee.api.ChatColor;

public enum GastroTheme {
    WORKSTATION_TOOL("#ffffff"),
    TOOL("#55ffff"),
    INGREDIENT("#ffff55"),
    MECHANICAL("#00aaaa"),
    ELECTRIC("#aaaaff"),
    TRAP("#f4a51d"),
    REGULAR_FOOD("#1d90f4"),
    PERFECT_FOOD("#c91df4");

    private @Getter ChatColor color;
    private @Getter ChatColor loreColor;

    GastroTheme(String color, String loreColor) {
        this.color = ChatColor.of(color);
        this.loreColor = ChatColor.of(loreColor);
    }

    GastroTheme(String color) {
        this(color, "#aaaaaa");
    }
}