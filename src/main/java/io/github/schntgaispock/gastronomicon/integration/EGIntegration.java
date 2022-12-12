package io.github.schntgaispock.gastronomicon.integration;

import org.bukkit.Bukkit;

import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EGIntegration {

    @Getter
    private static boolean available = Bukkit.getPluginManager().isPluginEnabled("ExoticGarden");
    
}
