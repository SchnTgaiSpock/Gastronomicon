package io.github.schntgaispock.gastronomicon.core.setup;

import io.github.schntgaispock.gastronomicon.core.slimefun.GastroResearch;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResearchSetup {

    public static void setup() {
        GastroResearch.WOODEN_TOOLS
            .addItems(
                GastroStacks.CUTTING_BOARD,
                GastroStacks.ROLLING_PIN,
                GastroStacks.MORTAR_AND_PESTLE)
            .register();
        GastroResearch.STEEL_TOOLS
            .addItems(
                GastroStacks.MEAT_SCISSORS,
                GastroStacks.KITCHEN_KNIFE,
                GastroStacks.BLENDER,
                GastroStacks.PEELER,
                GastroStacks.BAKING_TRAY,
                GastroStacks.FRYING_PAN,
                GastroStacks.STEEL_POT,
                GastroStacks.STEEL_BOWL,
                GastroStacks.WHISK)
            .register();
        GastroResearch.CULINARY_WORKBENCH.addItems(GastroStacks.CULINARY_WORKBENCH).register();
        GastroResearch.MULTI_STOVE.addItems(GastroStacks.MULTI_STOVE).register();
        GastroResearch.GRAIN_MILL.addItems(GastroStacks.MILL).register();
        GastroResearch.REFRIDGERATOR.addItems(GastroStacks.REFRIDGERATOR).register();
        GastroResearch.FERMENTER.addItems(GastroStacks.FERMENTER, GastroStacks.LARGE_FERMENTER).register();
        GastroResearch.TRAPS
            .addItems(
                GastroStacks.STEEL_WIRE,
                GastroStacks.STEEL_SPRING,
                GastroStacks.CRAB_TRAP,
                GastroStacks.HUNTING_TRAP,
                GastroStacks.FISHING_NET)
            .register();
        GastroResearch.SICKLES
            .addItems(
                GastroStacks.WOODEN_SICKLE,
                GastroStacks.STEEL_SICKLE,
                GastroStacks.REINFORCED_SICKLE)
            .register();

    }

}
