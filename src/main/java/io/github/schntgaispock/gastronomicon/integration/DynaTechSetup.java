package io.github.schntgaispock.gastronomicon.integration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.Getter;

@Getter
public class DynaTechSetup {

    private static SlimefunItem gc;
    private static SlimefunItem gc2;

    private static void register(int seconds, ItemStack... outputs) {
        try {
            final Method register = gc.getClass().getMethod(
                "registerRecipe", int.class, ItemStack[].class, ItemStack[].class);

            register.invoke(gc, seconds, new ItemStack[] { outputs[0].asOne() }, outputs);
            register.invoke(gc2, seconds,
            new ItemStack[] { outputs[0].asOne() },
            Arrays.stream(outputs).map(itemStack -> itemStack.asQuantity(itemStack.getAmount() * 3))
                .toArray(ItemStack[]::new));
            
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return;
        }
    }

    public static void setup() {
        // Assume DynaTech is installed, and the config option is enabled
        gc = SlimefunItem.getById("GROWTH_CHAMBER");
        gc2 = SlimefunItem.getById("GROWTH_CHAMBER_MK2");

        register(60, GastroStacks.RICE.asQuantity(3));
        register(60, GastroStacks.QUINOA.asQuantity(3));
        register(60, GastroStacks.OATS.asQuantity(3));
        register(60, GastroStacks.SOYBEANS.asQuantity(3));
        register(60, GastroStacks.BARLEY_SEEDS.asQuantity(2), GastroStacks.BARLEY.asQuantity(2));
        register(60, GastroStacks.RYE_SEEDS.asQuantity(2), GastroStacks.RYE.asQuantity(2));
        register(60, GastroStacks.SORGHUM_SEEDS.asQuantity(2), GastroStacks.SORGHUM.asQuantity(2));
        register(60, GastroStacks.TURNIP_SEEDS.asQuantity(2), GastroStacks.TURNIP.asQuantity(2));
        register(60, GastroStacks.SQUASH_SEEDS.asQuantity(2), GastroStacks.SQUASH.asQuantity(1));
        register(60, GastroStacks.CELERY.asQuantity(3));
        register(60, GastroStacks.BOK_CHOY_SEEDS.asQuantity(2), GastroStacks.BOK_CHOY.asQuantity(2));
        register(60, GastroStacks.BROCCOLI_SEEDS.asQuantity(2), GastroStacks.BROCCOLI.asQuantity(2));
        register(60, GastroStacks.CUCUMBER_SEEDS.asQuantity(2), GastroStacks.CUCUMBER.asQuantity(2));
        register(60, GastroStacks.BASIL_SEEDS.asQuantity(2), GastroStacks.BASIL.asQuantity(2));
        register(60, GastroStacks.SPINACH_SEEDS.asQuantity(2), GastroStacks.SPINACH.asQuantity(2));
        register(60, GastroStacks.BRUSSLES_SPROUTS.asQuantity(3));
        register(60, GastroStacks.MINT_SEEDS.asQuantity(2), GastroStacks.MINT.asQuantity(2));
        register(60, GastroStacks.CHILI_PEPPER_SEEDS.asQuantity(2), GastroStacks.CHILI_PEPPER.asQuantity(2));
        register(60, GastroStacks.PARSLEY_SEEDS.asQuantity(2), GastroStacks.PARSLEY.asQuantity(2));
        register(60, GastroStacks.CASSAVA.asQuantity(3));
        register(60, GastroStacks.LENTILS.asQuantity(3));
        register(60, GastroStacks.PEANUTS.asQuantity(3));
        register(60, GastroStacks.BEANS.asQuantity(3));
        register(60, GastroStacks.PEAS.asQuantity(3));
        register(60, GastroStacks.ASPARAGUS_SEEDS.asQuantity(2), GastroStacks.ASPARAGUS.asQuantity(2));
        register(60, GastroStacks.GREEN_ONION_SEEDS.asQuantity(2), GastroStacks.GREEN_ONION.asQuantity(2));
        register(60, GastroStacks.CAULIFLOWER_SEEDS.asQuantity(2), GastroStacks.CAULIFLOWER.asQuantity(2));
        register(60, GastroStacks.AVOCADO_PIT.asQuantity(2), GastroStacks.AVOCADO.asQuantity(2));
        register(60, GastroStacks.TURMERIC.asQuantity(3));
        register(60, GastroStacks.CUMIN_SEEDS.asQuantity(3));
        register(60, GastroStacks.RED_BEANS.asQuantity(3));
        register(60, GastroStacks.HONEYDEW_MELON_SEEDS.asQuantity(2), GastroStacks.CAULIFLOWER.asQuantity(1));
        register(60, GastroStacks.CANTALOUPE_SEEDS.asQuantity(2), GastroStacks.CAULIFLOWER.asQuantity(1));
        register(60, GastroStacks.SESAME_SEEDS.asQuantity(3));
        register(60, GastroStacks.VANILLA_PLANT.asQuantity(2), GastroStacks.VANILLA_BEANS.asQuantity(2));
        register(90,
            GastroStacks.LYCHEE_SAPLING.asQuantity(4),
            GastroStacks.LYCHEE.asQuantity(4),
            new ItemStack(Material.OAK_LOG, 4),
            new ItemStack(Material.AZALEA_LEAVES, 6));
        register(90,
            GastroStacks.BANANA_SAPLING.asQuantity(4),
            GastroStacks.BANANA.asQuantity(4),
            new ItemStack(Material.JUNGLE_LOG, 4),
            new ItemStack(Material.JUNGLE_LEAVES, 6));
        register(60, GastroStacks.FIDDLEHEADS.asQuantity(2));
        register(60, GastroStacks.TRUFFLE.asQuantity(2));
        register(60, GastroStacks.ENOKI_MUSHROOMS.asQuantity(2));
        register(60, GastroStacks.KING_OYSTER_MUSHROOM.asQuantity(2));
        register(60, GastroStacks.BUTTON_MUSHROOM.asQuantity(2));
    }

}
