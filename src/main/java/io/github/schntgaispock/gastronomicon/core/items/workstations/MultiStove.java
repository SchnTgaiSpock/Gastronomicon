package io.github.schntgaispock.gastronomicon.core.items.workstations;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

@SuppressWarnings("deprecation")
public class MultiStove extends GastroWorkstation {

    @RequiredArgsConstructor
    private enum Temperature {
        LOW(TEMPERATURE_BUTTON_LOW),
        MEDIUM(TEMPERATURE_BUTTON_MEDIUM),
        HIGH(TEMPERATURE_BUTTON_HIGH);

        private final @Getter ItemStack item;
        // TODO prev and next
    }

    public static final ItemStack TEMPERATURE_BUTTON_LOW = new CustomItemStack(
            Material.YELLOW_STAINED_GLASS_PANE,
            "&7Temperature: &eLOW",
            "",
            "&bLeft-click &7to increase");
    public static final ItemStack TEMPERATURE_BUTTON_MEDIUM = new CustomItemStack(
            Material.YELLOW_STAINED_GLASS_PANE,
            "&7Temperature: &6MEDIUM",
            "",
            "&bLeft-click &7to increase",
            "&bRight-click &7to decrease");
    public static final ItemStack TEMPERATURE_BUTTON_HIGH = new CustomItemStack(
            Material.YELLOW_STAINED_GLASS_PANE,
            "&7Temperature: &cHIGH",
            "",
            "&bRight-click &7to decrease");
    public static final int TEMPERATURE_BUTTON_SLOT = 53;
    public static final String TEMPERATURE_KEY = "gastronomicon:multi_stove/temperature";

    public MultiStove(ItemGroup group, SlimefunItemStack item, RecipeType type, ItemStack[] recipe) {
        super(group, item, type, recipe);
    }

    @Override
    protected void setup(BlockMenuPreset preset) {
        super.setup(preset);

        preset.drawBackground(TEMPERATURE_BUTTON_LOW, new int[] { TEMPERATURE_BUTTON_SLOT });
    }

    @Override
    protected void onNewInstance(BlockMenu menu, Block b) {
        super.onNewInstance(menu, b);

        menu.addMenuOpeningHandler(player -> {
            final String temp = BlockStorage.getLocationInfo(menu.getLocation(), TEMPERATURE_KEY);
            menu.replaceExistingItem(TEMPERATURE_BUTTON_SLOT,
                    temp == null ? TEMPERATURE_BUTTON_LOW : Temperature.valueOf(temp).getItem(), false);
        });

        menu.addMenuClickHandler(TEMPERATURE_BUTTON_SLOT, (player, slot, item, action) -> {
            return false;
        });
    }

    public static void changeTemperature(Block b, Temperature t) {
        BlockStorage.addBlockInfo(b, TEMPERATURE_KEY, t.name());
    }

    @Override
    public GastroRecipeType getRecipeType() {
        return GastroRecipeType.MULTI_STOVE;
    }

}
