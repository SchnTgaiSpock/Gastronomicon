package io.github.schntgaispock.gastronomicon.core.setup;

import io.github.schntgaispock.gastronomicon.core.listeners.SeedListener;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ListenerSetup {

    public static void setup() {
        SeedListener.setup();
    }

}
