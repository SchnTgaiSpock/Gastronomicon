package io.github.schntgaispock.gastronomicon.core.slimefun;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.groups.MultiGroup;
import io.github.mooy1.infinitylib.groups.SubGroup;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroGroups {

    public static final SubGroup DUMMY = new SubGroup("dummy", new ItemStack(Material.BARRIER));
    public static final SubGroup TOOLS = new SubGroup("tools", GastroStacks.GUIDE_ITEM_TOOLS);
    public static final SubGroup BASIC_MACHINES = new SubGroup("basic_machines", GastroStacks.GUIDE_ITEM_BASIC_MACHINES);
    public static final SubGroup ELECTRIC_MACHINES = new SubGroup("electric_machines", GastroStacks.GUIDE_ITEM_ELECTRIC_MACHINES);
    public static final SubGroup RAW_INGREDIENTS = new SubGroup("raw_ingredients", GastroStacks.GUIDE_ITEM_RAW_INGREDIENTS);
    public static final SubGroup FOOD = new SubGroup("food", GastroStacks.GUIDE_ITEM_FOOD);
    public static final MultiGroup MAIN = new MultiGroup("main", GastroStacks.GUIDE_ITEM_MAIN, TOOLS, BASIC_MACHINES, ELECTRIC_MACHINES, RAW_INGREDIENTS, FOOD);

    static {
        TOOLS.setCrossAddonItemGroup(true);
        BASIC_MACHINES.setCrossAddonItemGroup(true);
        ELECTRIC_MACHINES.setCrossAddonItemGroup(true);
        RAW_INGREDIENTS.setCrossAddonItemGroup(true);
        FOOD.setCrossAddonItemGroup(true);
    }

}
