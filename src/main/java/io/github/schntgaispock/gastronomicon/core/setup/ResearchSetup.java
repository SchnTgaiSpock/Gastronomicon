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
        new Research(Gastronomicon.newNamespacedKey("steel_tools"), startKey + 1, "Advanced Tools", 15)
            .addItems(
                GastroStacks.MEAT_SCISSORS,
                GastroStacks.KITCHEN_KNIFE,
                GastroStacks.BLENDER,
                GastroStacks.PEELER,
                GastroStacks.BAKING_TRAY,
                GastroStacks.FRYING_PAN,
                GastroStacks.STEEL_POT)
            .register();
        new Research(Gastronomicon.newNamespacedKey("culinary_workbench"), startKey + 2, "The First Step", 10)
            .addItems(GastroStacks.CULINARY_WORKBENCH).register();
        new Research(Gastronomicon.newNamespacedKey("multi_stove"), startKey + 2, "Multi-Stove", 15)
            .addItems(GastroStacks.MULTI_STOVE).register();
        new Research(Gastronomicon.newNamespacedKey("grain_mill"), startKey + 2, "Grain Mill", 10)
            .addItems(GastroStacks.MILL).register();
        new Research(Gastronomicon.newNamespacedKey("refridgerator"), startKey + 2, "Refridgerator", 17)
            .addItems(GastroStacks.REFRIDGERATOR).register();
        new Research(Gastronomicon.newNamespacedKey("distillery"), startKey + 2, "Distillery", 30)
            .addItems(GastroStacks.DISTILLERY).register();
        new Research(Gastronomicon.newNamespacedKey("traps"), startKey + 1, "Proficient Hunter", 21)
            .addItems(
                GastroStacks.MEAT_SCISSORS,
                GastroStacks.KITCHEN_KNIFE,
                GastroStacks.BLENDER,
                GastroStacks.PEELER,
                GastroStacks.BAKING_TRAY,
                GastroStacks.FRYING_PAN,
                GastroStacks.STEEL_POT)
            .register();
    }

}
