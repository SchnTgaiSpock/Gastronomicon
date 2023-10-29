package io.github.schntgaispock.gastronomicon.api.loot;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.loot.LootTable.LootTableBuilder;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

public class ItemLootTableBuilder extends LootTableBuilder<ItemStack> {

    
    @SafeVarargs
    public final ItemLootTableBuilder addItems(int weight, ItemStack... drops) {
        for (final ItemStack drop : drops) {
            final SlimefunItem sfItem = SlimefunItem.getByItem(drop);
            if (sfItem != null && sfItem.isDisabled()) {
                continue;
            }
            
            weightedDrops.put(drop, weight);
            totalWeight += weight;
        }
        return this;
    }

    @SafeVarargs
    public final ItemLootTableBuilder addItems(ItemStack... drops) {
        return addItems(1, drops);
    }

}