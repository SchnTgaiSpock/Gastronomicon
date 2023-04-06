package io.github.schntgaispock.gastronomicon.core.setup;

import io.github.schntgaispock.gastronomicon.core.listeners.SeedListener;
import io.github.schntgaispock.gastronomicon.core.listeners.TreeGrowthListener;
import io.github.schntgaispock.gastronomicon.core.listeners.WildHarvestListener;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ListenerSetup {

    public static void setup() {
        SeedListener.setup();
        WildHarvestListener.setup();
        TreeGrowthListener.setup();
    }

}
