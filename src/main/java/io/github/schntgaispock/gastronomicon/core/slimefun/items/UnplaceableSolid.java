package io.github.schntgaispock.gastronomicon.core.slimefun.items;

import javax.annotation.Nonnull;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

public class UnplaceableSolid extends SlimefunItem {

    public UnplaceableSolid(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    public UnplaceableSolid(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack recipeDisplayOutput) {
        super(itemGroup, item, recipeType, recipe, recipeDisplayOutput);
    }
    
    @Override
    public void preRegister() {
        addItemHandler(new BlockPlaceHandler(false) {
            @Override
            public void onPlayerPlace(@Nonnull BlockPlaceEvent e) {
                e.setCancelled(true);
                BlockStorage.clearBlockInfo(e.getBlock(), false);
            }
        });
    }

    public UnplaceableSolid hide() {
        setHidden(true);
        return this;
    }
}
