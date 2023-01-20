package io.github.schntgaispock.gastronomicon.core.setup;

import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RecipeSetup {

    private static @Getter boolean setupComplete = false;

    public static void setup() {

        setupComplete = true;
    }
    
}
