package io.github.schntgaispock.gastronomicon.core.events;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import io.github.schntgaispock.gastronomicon.core.items.food.GastroFood;
import lombok.Getter;

public class PlayerGastroFoodConsumeEvent extends PlayerItemConsumeEvent {

    private final @Getter GastroFood food;

    public PlayerGastroFoodConsumeEvent(@NotNull Player player, GastroFood food, @NotNull ItemStack item, @NotNull EquipmentSlot hand) {
        super(player, item, hand);

        this.food = food;
    }
    
}
