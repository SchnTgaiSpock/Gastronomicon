package io.github.schntgaispock.gastronomicon.core.items.workstations.automatic;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.util.collections.CollectionUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.operations.CraftingOperation;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

@Getter
@SuppressWarnings("deprecation")
public class FishingNet extends AContainer {

    public static final int[] BACKGROUND_SLOTS = new int[] {
        0, 1, 2, 3, 4, 5, 6, 7, 8,
        9, 10, 11, 17,
        18, 20, 26,
        27, 28, 29, 35,
        36, 37, 38, 39, 40, 41, 42, 43, 44
    };
    public static final int[] OUTPUT_SLOTS = new int[] { 12, 21, 30 };
    public static final int STATUS_SLOT = 25;
    public static final ItemStack[] FISH = {
        GastroStacks.RAW_BASS,
        GastroStacks.RAW_CARP,
        GastroStacks.RAW_EEL,
        GastroStacks.RAW_MACKEREL,
        GastroStacks.RAW_PIKE,
        GastroStacks.RAW_SQUID,
        GastroStacks.RAW_TROUT,
        GastroStacks.RAW_TUNA,
        new ItemStack(Material.COD),
        new ItemStack(Material.SALMON),
        new ItemStack(Material.PUFFERFISH),
        new ItemStack(Material.TROPICAL_FISH)
    };

    private final EnergyNetComponentType energyComponentType = EnergyNetComponentType.NONE;
    private final String machineIdentifier = "GN_FISHING_NET";
    private final MachineProcessor<CraftingOperation> machineProcessor = new MachineProcessor<>(this);
    private final ItemStack progressBar = new ItemStack(Material.FISHING_ROD);
    private final int[] inputSlots = new int[0];
    private final int[] outputSlots = new int[] { 13, 14, 15, 16, 22, 23, 24, 25, 31, 32, 33, 34 };

    public FishingNet(SlimefunItemStack item, int speed, ItemStack[] recipe) {
        super(GastroGroups.ELECTRIC_MACHINES, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);

        setCapacity(0);
        setEnergyConsumption(0);
        setProcessingSpeed(speed);
    }

    @Override
    protected void constructMenu(BlockMenuPreset menu) {
        draw(menu, GastroStacks.MENU_BACKGROUND_ITEM, BACKGROUND_SLOTS);
        draw(menu, GastroStacks.MENU_OUTPUT_BORDER, OUTPUT_SLOTS);
        draw(menu, GastroStacks.MENU_NO_WATER_ABOVE, STATUS_SLOT);
    }

    private void draw(BlockMenuPreset preset, ItemStack item, int... slots) {
        for (int slot : slots) {
            preset.addItem(slot, item, ChestMenuUtils.getEmptyClickHandler());
        }
    }
    
    @Override
    protected MachineRecipe findNextRecipe(BlockMenu menu) {
        return new MachineRecipe(40 / getSpeed(), new ItemStack[0], new ItemStack[] { CollectionUtil.choice(FISH) });
    }

    @Override
    protected void tick(Block b) {
        final BlockMenu inv = BlockStorage.getInventory(b);
        CraftingOperation currentOperation = getMachineProcessor().getOperation(b);

        if (currentOperation != null) {
            if (inv.getLocation().add(0, 1, 0).getBlock().getType() != Material.WATER) {

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
            }
        } else {
            final MachineRecipe next = findNextRecipe(inv);

            if (next != null) {
                currentOperation = new CraftingOperation(next);
                getMachineProcessor().startOperation(b, currentOperation);
                getMachineProcessor().updateProgressBar(inv, STATUS_SLOT, currentOperation);
            }
        }
    }

}
