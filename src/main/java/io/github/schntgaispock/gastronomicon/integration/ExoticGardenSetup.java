package io.github.schntgaispock.gastronomicon.integration;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExoticGardenSetup {

    public static void setup() {
        final boolean available = Gastronomicon.isPluginEnabled("ExoticGarden");

        if (available);
    }

}
