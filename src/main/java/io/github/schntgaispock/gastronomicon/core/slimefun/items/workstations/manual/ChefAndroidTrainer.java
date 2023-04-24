package io.github.schntgaispock.gastronomicon.core.slimefun.items.workstations.manual;

import java.util.Arrays;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import io.github.mooy1.infinitylib.core.AddonConfig;
import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.food.GastroFood;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.food.SimpleGastroFood;
import io.github.schntgaispock.gastronomicon.util.item.GastroKeys;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

@Getter
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

    private final int[] inputSlots = new int[] { 11 };
    private final int[] outputSlots = new int[] { 15 };

    public ChefAndroidTrainer(SlimefunItemStack item, ItemStack[] recipe) {
        super(GastroGroups.BASIC_MACHINES, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
    }

    @Nonnull
    protected BlockBreakHandler onBlockBreak() {
        return new SimpleBlockBreakHandler() {

            @Override
            public void onBlockBreak(Block b) {
                BlockMenu inv = BlockStorage.getInventory(b);

                if (inv != null) {
                    inv.dropItems(b.getLocation(), getInputSlots());
                    inv.dropItems(b.getLocation(), getOutputSlots());
                    inv.dropItems(b.getLocation(), FOOD_SLOT);
                }
            }

        };
    }

    @Override
    protected void setup(BlockMenuPreset preset) {
        preset.drawBackground(BACKGROUND_ITEM, BACKGROUND_SLOTS);
        preset.drawBackground(GastroStacks.MENU_ANDROID_BORDER, INPUT_BORDER_SLOTS);
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
            if (input == null || input.getAmount() <= 0 || input.getType() == Material.AIR)
                return false;

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
                final String name;
                final String id;
                if (food instanceof final GastroFood gFood) {
                    if (gFood.isPerfect()) {
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
                    final AddonConfig playerData = Gastronomicon.getInstance().getPlayerData();
                    final String proficiencyPath = player.getUniqueId() + ".proficiencies." + id;
                    final int proficiency = playerData.getInt(proficiencyPath, 0);
                    final int threshold = Gastronomicon.config().getInt("proficiency-threshold");

                    if (proficiency < threshold) {
                        Gastronomicon.sendMessage(player, "&eYou are not proficient enough in this recipe! Required: " + proficiency + "/" + threshold);
                        return false;
                    }
                } else {
                    name = food.getItemName();
                    id = food.getId();
                }
                final ItemStack modified = input.asOne();
                input.subtract(1);
                modified.setLore(Arrays.asList("§7" + ChatUtils.removeColorCodes(name)));
                final ItemMeta meta = modified.getItemMeta();
                final PersistentDataContainer pdc = meta.getPersistentDataContainer();
                pdc.set(GastroKeys.CHEF_ANDROID_FOOD, PersistentDataType.STRING, id);
                modified.setItemMeta(meta);
                menu.pushItem(modified, getOutputSlots());
            }

            return false;
        });
    }

}
