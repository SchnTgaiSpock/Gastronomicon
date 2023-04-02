package io.github.schntgaispock.gastronomicon.integration;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.Getter;
import me.profelements.dynatech.items.electric.growthchambers.GrowthChamber;
import me.profelements.dynatech.items.electric.growthchambers.GrowthChamberMK2;

@Getter
public class DynaTechSetup {

    private static GrowthChamber gc;
    private static GrowthChamberMK2 gc2;

    private static void register(int seconds, ItemStack... outputs) {
        gc.registerRecipe(seconds, new ItemStack[] { outputs[0].asOne() }, outputs);
        gc2.registerRecipe(
            seconds,
            new ItemStack[] { outputs[0].asOne() },
            Arrays.stream(outputs).map(itemStack -> itemStack.asQuantity(itemStack.getAmount() * 3))
                .toArray(ItemStack[]::new));
    }

    public static void setup() {
        // Assume DynaTech is installed, and the config option is enabled
        final SlimefunItem _gc = SlimefunItem.getById("GROWTH_CHAMBER");
        final SlimefunItem _gc2 = SlimefunItem.getById("GROWTH_CHAMBER_MK2");

        if (!(_gc instanceof GrowthChamber) || !(_gc2 instanceof GrowthChamberMK2)) {
            Gastronomicon.warn("Couldn't find DynaTech growth chambers");
            System.out.println(_gc);
            System.out.println(_gc2);
            return;
        }

        gc = (GrowthChamber) _gc;
        gc2 = (GrowthChamberMK2) _gc2;

        register(30, GastroStacks.RICE.asQuantity(3));
        register(30, GastroStacks.QUINOA.asQuantity(3));
        register(30, GastroStacks.OATS.asQuantity(3));
        register(30, GastroStacks.SOYBEANS.asQuantity(3));
        register(30, GastroStacks.BARLEY_SEEDS.asQuantity(2), GastroStacks.BARLEY.asQuantity(2));
        register(30, GastroStacks.RYE_SEEDS.asQuantity(2), GastroStacks.RYE.asQuantity(2));
        register(30, GastroStacks.SORGHUM_SEEDS.asQuantity(2), GastroStacks.SORGHUM.asQuantity(2));
        register(30, GastroStacks.TURNIP_SEEDS.asQuantity(2), GastroStacks.TURNIP.asQuantity(2));
        register(30, GastroStacks.SQUASH_SEEDS.asQuantity(2), GastroStacks.SQUASH.clone());
        register(30, GastroStacks.CELERY.asQuantity(3));
        register(30, GastroStacks.BOK_CHOY.asQuantity(3));
        register(30, GastroStacks.BROCCOLI.asQuantity(3));
        register(30, GastroStacks.CUCUMBER.asQuantity(3));
        register(30, GastroStacks.BASIL.asQuantity(3));
        register(30, GastroStacks.SPINACH.asQuantity(3));
        register(30, GastroStacks.BRUSSLES_SPROUTS.asQuantity(3));
        register(30, GastroStacks.MINT.asQuantity(3));
        register(30, GastroStacks.CHILI_PEPPER.asQuantity(3));
        register(30, GastroStacks.PARSLEY.asQuantity(3));
        register(30, GastroStacks.CASSAVA.asQuantity(3));
        register(30, GastroStacks.LENTILS.asQuantity(3));
        register(30, GastroStacks.PEANUTS.asQuantity(3));
        register(30, GastroStacks.BEANS.asQuantity(3));
        register(30, GastroStacks.PEAS.asQuantity(3));
        register(30, GastroStacks.ASPARAGUS.asQuantity(3));
        register(30, GastroStacks.GREEN_ONION.asQuantity(3));
        register(30, GastroStacks.CAULIFLOWER.asQuantity(3));
        register(30, GastroStacks.AVOCADO_PIT.asQuantity(2), GastroStacks.AVOCADO.asQuantity(2));
        register(30, GastroStacks.TURMERIC.asQuantity(3));
        register(30, GastroStacks.CUMIN_SEEDS.asQuantity(3));
        register(30, GastroStacks.RED_BEANS.asQuantity(3));
        register(60,
            GastroStacks.LYCHEE_SAPLING.asQuantity(4),
            GastroStacks.LYCHEE.asQuantity(4),
            new ItemStack(Material.OAK_LOG, 4),
            new ItemStack(Material.AZALEA_LEAVES, 6));
        register(60,
            GastroStacks.BANANA_SAPLING.asQuantity(4),
            GastroStacks.BANANA.asQuantity(4),
            new ItemStack(Material.JUNGLE_LOG, 4),
            new ItemStack(Material.MANGROVE_LEAVES, 6));
        register(60,
            GastroStacks.VANILLA_SAPLING.asQuantity(4),
            GastroStacks.VANILLA_BEANS.asQuantity(4),
            new ItemStack(Material.SPRUCE_LOG, 4),
            new ItemStack(Material.ACACIA_LEAVES, 6));
        register(45, GastroStacks.FIDDLEHEADS.asQuantity(3));
        register(45, GastroStacks.TRUFFLE.asQuantity(3));
        register(45, GastroStacks.ENOKI_MUSHROOMS.asQuantity(3));
        register(45, GastroStacks.KING_OYSTER_MUSHROOM.asQuantity(3));
        register(45, GastroStacks.BUTTON_MUSHROOM.asQuantity(3));
    }

}
