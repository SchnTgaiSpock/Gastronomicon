package io.github.schntgaispock.gastronomicon.integration;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EGIntegration {

    @Getter
    private static boolean available = Gastronomicon.getInstance().getServer().getPluginManager().isPluginEnabled("ExoticGarden");
    
}
