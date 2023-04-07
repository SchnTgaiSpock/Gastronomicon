package io.github.schntgaispock.gastronomicon.core.setup;

import io.github.schntgaispock.gastronomicon.core.slimefun.GastroResearch;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResearchSetup {

    public static void setup() {
        GastroResearch.WOODEN_TOOLS
            .addItems(
                GastroStacks.ROLLING_PIN,
                GastroStacks.MORTAR_AND_PESTLE)
            .register();
        GastroResearch.STEEL_TOOLS
            .addItems(
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
        GastroResearch.CHEFS_HAT.addItems(GastroStacks.CHEFS_HAT).register();
        GastroResearch.TRAPS
            .addItems(
                GastroStacks.STEEL_WIRE,
                GastroStacks.STEEL_SPRING,
                GastroStacks.CRAB_TRAP,
                GastroStacks.HUNTING_TRAP)
            .register();
        GastroResearch.FISHING_NETS
            .addItems(
                GastroStacks.FISHING_NET_I,
                GastroStacks.FISHING_NET_II,
                GastroStacks.FISHING_NET_III)
            .register();
        GastroResearch.CHEF_ANDROID
            .addItems(
                GastroStacks.CHEF_ANDROID,
                GastroStacks.CHEF_ANDROID_TRAINER)
            .register();
        GastroResearch.ELECTRIC_KITCHEN
            .addItems(
                GastroStacks.ELECTRIC_KITCHEN_I,
                GastroStacks.ELECTRIC_KITCHEN_II,
                GastroStacks.ELECTRIC_KITCHEN_III)
            .register();
        GastroResearch.SICKLES
            .addItems(
                GastroStacks.WOODEN_SICKLE,
                GastroStacks.STEEL_SICKLE,
                GastroStacks.REINFORCED_SICKLE)
            .register();
        GastroResearch.RAW_INGREDIENTS.register();
        GastroResearch.FOOD.register();
    }

}
