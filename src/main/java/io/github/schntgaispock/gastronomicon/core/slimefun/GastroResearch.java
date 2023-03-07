package io.github.schntgaispock.gastronomicon.core.slimefun;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroResearch {

    private final int startKey = "Gastronomicon".hashCode();

    public static final Research WOODEN_TOOLS = new Research(Gastronomicon.newNamespacedKey("wooden_tools"), startKey, "Basic Tools", 10);
    public static final Research STEEL_TOOLS = new Research(Gastronomicon.newNamespacedKey("steel_tools"), startKey + 1, "Steel Tools", 15);
    public static final Research CULINARY_WORKBENCH = new Research(Gastronomicon.newNamespacedKey("culinary_workbench"), startKey + 2, "The First Step", 10);
    public static final Research MULTI_STOVE = new Research(Gastronomicon.newNamespacedKey("multi_stove"), startKey + 3, "Multi-Stove", 15);
    public static final Research GRAIN_MILL = new Research(Gastronomicon.newNamespacedKey("grain_mill"), startKey + 4, "Grain Mill", 10);
    public static final Research REFRIDGERATOR = new Research(Gastronomicon.newNamespacedKey("refridgerator"), startKey + 5, "Refridgerator", 17);
    public static final Research FERMENTER = new Research(Gastronomicon.newNamespacedKey("fermenter"), startKey + 6, "Fermenter", 25);
    public static final Research TRAPS = new Research(Gastronomicon.newNamespacedKey("traps"), startKey + 7, "Traps", 18);
    public static final Research SICKLES = new Research(Gastronomicon.newNamespacedKey("sickles"), startKey + 8, "Gathering Tools", 18);
    public static final Research RAW_INGREDIENTS = new Research(Gastronomicon.newNamespacedKey("raw_ingredients"), startKey + 9, "Raw Ingredients", 11);
    public static final Research PROCESSED_INGREDIENTS = new Research(Gastronomicon.newNamespacedKey("processed_ingredients"), startKey + 10, "Processed Ingredients", 19);
    public static final Research FOOD = new Research(Gastronomicon.newNamespacedKey("food"), startKey + 11, "Haute Cuisine", 32);
    
}