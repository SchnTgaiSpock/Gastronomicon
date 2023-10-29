package io.github.schntgaispock.gastronomicon.api.loot;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EmptyItemLootTable extends LootTable<ItemStack> {

    protected EmptyItemLootTable() {
        super(List.of(), 0, new int[0], new int[0]);
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ItemStack generate() {
        return new ItemStack(Material.AIR);
    }
    
}
