package io.github.schntgaispock.gastronomicon.core.items.workstations.manual;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.items.food.GastroFood;
import io.github.schntgaispock.gastronomicon.core.items.food.SimpleGastroFood;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.util.item.GastroKeys;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public class ChefAndroidTrainer extends MenuBlock {

    protected static final int[] BACKGROUND_SLOTS = {
        0, 1, 2, 3, 4, 5, 6, 7, 8,
        9, 17,
        18, 19, 20, 21, 23, 24, 25, 26
    };

    protected static final int[] INPUT_BORDER_SLOTS = { 10, 12 };
    protected static final int[] OUTPUT_BORDER_SLOTS = { 14, 16 };
    protected static final int[] FOOD_BORDER_SLOTS = { 4 };
    protected static final int FOOD_SLOT = 13;
    protected static final int TRAIN_SLOT = 22;

    public ChefAndroidTrainer(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    protected int[] getInputSlots() {
        return new int[] { 11 };
    }

    @Override
    protected int[] getOutputSlots() {
        return new int[] { 15 };
    }

    @Override
    protected void setup(BlockMenuPreset preset) {
        preset.drawBackground(BACKGROUND_ITEM, BACKGROUND_SLOTS);
        preset.drawBackground(GastroStacks.MENU_INGREDIENT_BORDER, INPUT_BORDER_SLOTS);
        preset.drawBackground(OUTPUT_BORDER, OUTPUT_BORDER_SLOTS);
        preset.drawBackground(GastroStacks.MENU_FOOD_BORDER, FOOD_BORDER_SLOTS);
        preset.drawBackground(GastroStacks.MENU_TRAIN_BUTTON, new int[] { TRAIN_SLOT });
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void onNewInstance(BlockMenu menu, Block b) {
        super.onNewInstance(menu, b);

        menu.addMenuClickHandler(TRAIN_SLOT, (player, slot, item, action) -> {
            final ItemStack input = menu.getItemInSlot(getInputSlots()[0]);
            if (input == null || input.getAmount() <= 0 || input.getType() == Material.AIR) return false;

            final ItemStack foodItem = menu.getItemInSlot(FOOD_SLOT);
            if (foodItem == null) {
                Gastronomicon.sendMessage(player, "&ePlease place a valid food item in the middle slot");
                return false;
            }

            if (menu.getItemInSlot(getOutputSlots()[0]) != null) {
                Gastronomicon.sendMessage(player, "The output slot is full!");
                return false;
            }

            final SlimefunItem sfItem = SlimefunItem.getByItem(foodItem);
            if (sfItem == null) {
                Gastronomicon.sendMessage(player, "&ePlease place a valid food item in the middle slot");
                return false;
            } else if (sfItem instanceof final SimpleGastroFood food) {
                input.subtract(1);
                final ItemStack modified = input.asOne();
                final String name;
                final String id;
                if (food instanceof final GastroFood gFood && gFood.isPerfect()) {
                    id = food.getId().replace("GN_PERFECT_", "GN_");
                    final SlimefunItem regularItem = SlimefunItem.getById(id);
                    if (regularItem == null) {
                        Gastronomicon.sendMessage(player, "&ePlease place a valid food item in the middle slot");
                        return false;
                    }
                    name = regularItem.getItemName();
                } else {
                    name = food.getItemName();
                    id = food.getId();
                }
                modified.setLore(Arrays.asList("&7" + ChatUtils.removeColorCodes(name)));
                final ItemMeta meta = modified.getItemMeta();
                final PersistentDataContainer pdc = meta.getPersistentDataContainer();
                pdc.set(GastroKeys.CHEF_ANDROID_FOOD, PersistentDataType.STRING, id);
                modified.setItemMeta(meta);
                menu.addItem(getOutputSlots()[0], modified);
            }
            
            return false;
        });
    }
    
}
