package io.github.schntgaispock.gastronomicon.core.slimefun.items.workstations.automatic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.components.RecipeComponent;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.core.slimefun.items.food.SimpleGastroFood;
import io.github.schntgaispock.gastronomicon.util.collections.Counter;
import io.github.schntgaispock.gastronomicon.util.collections.Pair;
import io.github.schntgaispock.gastronomicon.util.item.GastroKeys;
import io.github.schntgaispock.gastronomicon.util.item.ItemUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.operations.CraftingOperation;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import lombok.Getter;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.AdvancedMenuClickHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;

@Getter
@SuppressWarnings("deprecation")
public class ElectricKitchen extends AContainer {

    protected static final int[] BACKGROUND_SLOTS = {
        0, 1, 2, 3, 4, 5, 6, 7, 8,
        13, 16, 17,
        22, 23, 24, 25, 26,
        31, 32, 33, 34, 35,
        40, 44,
        45, 46, 47, 48, 49, 50, 51, 52
    };

    protected static final int[] INPUT_BORDER = { 9, 18, 27, 36 };
    protected static final int ANDROID_BORDER = 14;
    protected static final int OUTPUT_BORDER = 41;
    protected static final int ANDROID_SLOT = 15;
    protected static final int STATUS_SLOT = 53;
    private static Map<Location, Pair<Integer, Counter<Integer>>> lastInputHashAndRecipe = new HashMap<>();

    private final EnergyNetComponentType energyComponentType = EnergyNetComponentType.CONSUMER;
    private final String machineIdentifier = "GN_ELECTRIC_KITCHEN";
    private final MachineProcessor<CraftingOperation> machineProcessor = new MachineProcessor<>(this);
    private final ItemStack progressBar = new ItemStack(Material.FLINT_AND_STEEL);

    public ElectricKitchen(SlimefunItemStack item, int capacity, int energyConsumption, int speed, ItemStack[] recipe) {
        super(GastroGroups.ELECTRIC_MACHINES, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);

        setCapacity(capacity);
        setEnergyConsumption(energyConsumption);
        setProcessingSpeed(speed);
        machineProcessor.setProgressBar(progressBar);
    }

    @Override
    public void createPreset(SlimefunItem item, String title, Consumer<BlockMenuPreset> setup) {
        new BlockMenuPreset(item.getId(), title) { // Modified from InventoryBlock

            @Override
            public void init() {
                setup.accept(this);
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                if (flow == ItemTransportFlow.INSERT) {
                    return getInputSlots();
                } else {
                    return getOutputSlots();
                }
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(DirtyChestMenu menu, ItemTransportFlow flow, ItemStack item) {
                if (flow == ItemTransportFlow.INSERT) {
                    final int[] slots = Arrays.stream(getInputSlots())
                        .mapToObj(slot -> new Pair<>(slot, menu.getItemInSlot(slot))) // get pairs of (slot, item in slot)
                        .filter(pair -> pair.second() != null && pair.second().getType() == item.getType()) // get all the slots/items which are the same type as the requested item
                        .mapToInt(pair -> pair.first()) // return only those slots
                        .toArray();

                    return slots.length == 0 ? getInputSlots() : slots; // length of 0 means the item isn't in the current input slots
                } else {
                    return getOutputSlots();
                }
            }

            @Override
            public boolean canOpen(Block b, Player p) {
                if (p.hasPermission("slimefun.inventory.bypass")) {
                    return true;
                } else {
                    return item.canUse(p, false) && Slimefun.getProtectionManager().hasPermission(p, b.getLocation(), Interaction.INTERACT_BLOCK);
                }
            }
        };
    }

    @Override
    public int[] getInputSlots() {
        return new int[] { 10, 11, 12, 19, 20, 21, 28, 29, 30, 37, 38, 39 };
    }

    @Override
    public int[] getOutputSlots() {
        return new int[] { 42, 43 };
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
                    inv.dropItems(b.getLocation(), ANDROID_SLOT);
                }

                getMachineProcessor().endOperation(b);
                lastInputHashAndRecipe.remove(b.getLocation());
            }

        };
    }

    @Override
    protected void constructMenu(BlockMenuPreset preset) {
        draw(preset, GastroStacks.MENU_BACKGROUND_ITEM, BACKGROUND_SLOTS);
        draw(preset, GastroStacks.MENU_INPUT_BORDER, INPUT_BORDER);
        draw(preset, GastroStacks.MENU_ANDROID_BORDER, ANDROID_BORDER);
        draw(preset, GastroStacks.MENU_OUTPUT_BORDER, OUTPUT_BORDER);
        draw(preset, GastroStacks.MENU_NO_ANDROID, STATUS_SLOT);

        for (int i : getOutputSlots()) { // From AContainer
            preset.addMenuClickHandler(i, new AdvancedMenuClickHandler() {
                @Override
                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction action) {
                    return false;
                }

                @Override
                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor,
                    ClickAction action) {
                    return cursor == null || cursor.getType() == null || cursor.getType() == Material.AIR;
                }
            });
        }
    }

    private void draw(BlockMenuPreset preset, ItemStack item, int... slots) {
        for (int slot : slots) {
            preset.addItem(slot, item, ChestMenuUtils.getEmptyClickHandler());
        }
    }

    @Override
    protected MachineRecipe findNextRecipe(BlockMenu menu) {
        final ItemStack android = menu.getItemInSlot(ANDROID_SLOT);
        if (android == null) {
            menu.replaceExistingItem(STATUS_SLOT, GastroStacks.MENU_NO_ANDROID);
            return null;
        }

        final String foodId = android.getItemMeta().getPersistentDataContainer().get(GastroKeys.CHEF_ANDROID_FOOD,
            PersistentDataType.STRING);
        if (foodId == null) {
            menu.replaceExistingItem(STATUS_SLOT, GastroStacks.MENU_NO_ANDROID);
            return null;
        }
        final SlimefunItem food = SlimefunItem.getById(foodId);
        if (food == null || !(food instanceof final SimpleGastroFood gastroFood)) {
            menu.replaceExistingItem(STATUS_SLOT, GastroStacks.MENU_NO_ANDROID);
            return null;
        }

        final GastroRecipe recipe = gastroFood.getGastroRecipe();

        int hash = 1;
        for (int slot : getInputSlots()) {
            hash = hash * 31 + ItemUtil.hashIgnoreAmount(menu.getItemInSlot(slot));
        }

        final Pair<Integer, Counter<Integer>> hashRecipePair;
        if (lastInputHashAndRecipe.containsKey(menu.getLocation())) {
            hashRecipePair = lastInputHashAndRecipe.get(menu.getLocation());
        } else {
            hashRecipePair = new Pair<Integer, Counter<Integer>>(0, null);
            lastInputHashAndRecipe.put(menu.getLocation(), hashRecipePair);
        }

        final Counter<Integer> found;
        if (hashRecipePair.first() == hash) {
            found = hashRecipePair.second();
        } else {
            found = new Counter<>();
            for (RecipeComponent<?> component : recipe.getInputs().getAll()) {
                if (component == RecipeComponent.EMPTY) continue;

                boolean matched = false;
                for (int slot : getInputSlots()) {
                    final ItemStack input = menu.getItemInSlot(slot);
                    if (component.matches(input) && input.getAmount() > found.get(slot)) {
                        matched = true;
                        found.add(slot);
                        break;
                    }
                }
                if (!matched) {
                    menu.replaceExistingItem(STATUS_SLOT, GastroStacks.MENU_INCORRECT_RECIPE);
                    return null;
                }
            }

            hashRecipePair.first(hash);
            hashRecipePair.second(found);
        }

        final MachineRecipe newRecipe = new MachineRecipe(60 / getSpeed(), found.entries().stream().filter(pair -> {
            return pair.first() != null;
        }).map(pair -> {
            final ItemStack input = menu.getItemInSlot(pair.first());
            final ItemStack clone = input.asQuantity(pair.second());
            input.subtract(pair.second());
            return clone;
        }).toArray(ItemStack[]::new), new ItemStack[] { recipe.getOutputs()[0] });

        return newRecipe;
    }

    /**
     * Modified from AContainer#tick
     */
    @Override
    protected void tick(Block b) {
        final BlockMenu inv = BlockStorage.getInventory(b);
        CraftingOperation currentOperation = getMachineProcessor().getOperation(b);

        if (currentOperation != null) {
            if (takeCharge(b.getLocation())) {
                if (!currentOperation.isFinished()) {
                    getMachineProcessor().updateProgressBar(inv, STATUS_SLOT, currentOperation);
                    currentOperation.addProgress(1);
                } else {
                    inv.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "));

                    for (ItemStack output : currentOperation.getResults()) {
                        inv.pushItem(output.clone(), getOutputSlots());
                    }

                    getMachineProcessor().endOperation(b);
                }
            } else {
                inv.replaceExistingItem(STATUS_SLOT, GastroStacks.MENU_NOT_ENOUGH_ENERGY);
            }
        } else {
            final MachineRecipe next = findNextRecipe(inv);

            if (next != null && next.getInput() != null) {
                currentOperation = new CraftingOperation(next);
                getMachineProcessor().startOperation(b, currentOperation);
                getMachineProcessor().updateProgressBar(inv, STATUS_SLOT, currentOperation);
            }
        }
    }
}
