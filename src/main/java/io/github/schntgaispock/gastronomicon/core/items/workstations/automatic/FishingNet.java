package io.github.schntgaispock.gastronomicon.core.items.workstations.automatic;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.util.collections.CollectionUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineProcessHolder;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.implementation.operations.CraftingOperation;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import lombok.Getter;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

@Getter
@SuppressWarnings("deprecation")
public class FishingNet extends SlimefunItem implements InventoryBlock, MachineProcessHolder<CraftingOperation> {

    public static final int[] BACKGROUND_SLOTS = new int[] {
        0, 1, 2,
        9, 11,
        18, 19, 20
    };
    public static final int[] OUTPUT_BORDER = new int[] { 3, 12, 21 };
    public static final int STATUS_SLOT = 10;
    public static final ItemStack[] FISH = {
        GastroStacks.RAW_BASS,
        GastroStacks.RAW_CARP,
        GastroStacks.RAW_EEL,
        GastroStacks.RAW_MACKEREL,
        GastroStacks.RAW_PIKE,
        GastroStacks.RAW_SQUID,
        GastroStacks.RAW_TROUT,
        GastroStacks.RAW_TUNA,
        GastroStacks.SHRIMP,
        new ItemStack(Material.COD),
        new ItemStack(Material.SALMON),
        new ItemStack(Material.PUFFERFISH),
        new ItemStack(Material.TROPICAL_FISH)
    };

    private final String machineIdentifier = "GN_FISHING_NET";
    private final MachineProcessor<CraftingOperation> machineProcessor = new MachineProcessor<>(this);
    private final ItemStack progressBar = new ItemStack(Material.FISHING_ROD);
    private final int[] inputSlots = new int[0];
    private final int[] outputSlots = new int[] {
        4, 5, 6, 7, 8,
        13, 14, 15, 16, 17,
        22, 23, 24, 25, 26
    };
    private final int speed;

    public FishingNet(SlimefunItemStack item, int speed, ItemStack[] recipe) {
        super(GastroGroups.ELECTRIC_MACHINES, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);

        this.speed = speed;
        machineProcessor.setProgressBar(progressBar);
        createPreset(this, this::constructMenu);
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {

            @Override
            public void tick(Block b, SlimefunItem sf, Config data) {
                FishingNet.this.tick(b);
            }

            @Override
            public boolean isSynchronized() {
                return false;
            }
        });
    }

    protected void constructMenu(BlockMenuPreset menu) {
        draw(menu, GastroStacks.MENU_BACKGROUND_ITEM, BACKGROUND_SLOTS);
        draw(menu, GastroStacks.MENU_OUTPUT_BORDER, OUTPUT_BORDER);
        draw(menu, GastroStacks.MENU_NOT_WATERLOGGED, STATUS_SLOT);
    }

    private void draw(BlockMenuPreset preset, ItemStack item, int... slots) {
        for (int slot : slots) {
            preset.addItem(slot, item, ChestMenuUtils.getEmptyClickHandler());
        }
    }
    
    protected MachineRecipe findNextRecipe(BlockMenu menu) {
        return new MachineRecipe(240 / getSpeed(), new ItemStack[] { new ItemStack(Material.AIR) }, new ItemStack[] { CollectionUtil.choice(FISH) });
    }

    protected void tick(Block b) {
        final BlockMenu inv = BlockStorage.getInventory(b);
        CraftingOperation currentOperation = getMachineProcessor().getOperation(b);

        if (currentOperation != null) {
            if (inv.getBlock().getBlockData() instanceof final Waterlogged waterlogged && waterlogged.isWaterlogged()) {

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
        } else if (b.getBlockData() instanceof final Waterlogged bar && bar.isWaterlogged()) {
            final MachineRecipe next = findNextRecipe(inv);

            if (next != null) {
                currentOperation = new CraftingOperation(next);
                getMachineProcessor().startOperation(b, currentOperation);
                getMachineProcessor().updateProgressBar(inv, STATUS_SLOT, currentOperation);
            }
        }
    }

    // TODO: fix on break
}
