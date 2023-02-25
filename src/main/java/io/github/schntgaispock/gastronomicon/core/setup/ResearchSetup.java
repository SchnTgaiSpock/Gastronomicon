package io.github.schntgaispock.gastronomicon.core.setup;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResearchSetup {

    public static void setup() {
        final int startKey = "Gastronomicon".hashCode();
        new Research(Gastronomicon.newNamespacedKey("wooden_tools"), startKey, "Basic Tools", 10)
                .addItems(
                        GastroStacks.CUTTING_BOARD,
                        GastroStacks.ROLLING_PIN,
                        GastroStacks.MORTAR_AND_PESTLE)
                .register();
        new Research(Gastronomicon.newNamespacedKey("steel_tools"), startKey + 1, "Advanced Tools", 0)
                .addItems(
                        GastroStacks.MEAT_SCISSORS,
                        GastroStacks.KITCHEN_KNIFE,
                        GastroStacks.BLENDER,
                        GastroStacks.PEELER,
                        GastroStacks.BAKING_TRAY,
                        GastroStacks.FRYING_PAN,
                        GastroStacks.STEEL_POT
                )
                .register();
    }

}
