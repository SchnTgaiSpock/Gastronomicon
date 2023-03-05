package io.github.schntgaispock.gastronomicon.api.items;

import org.bukkit.Material;

import io.github.schntgaispock.gastronomicon.api.food.FoodEffect;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;

public class FoodItemStackBuilder {

    private String id;
    private String texture;
    private Material material;
    private String name;
    private String[] lore = new String[0];
    private String[] perfectLore = new String[0];
    private int hunger = 0;
    private double saturationRatio = 1;
    private FoodEffect[] effects = new FoodEffect[0];

    public FoodItemStackBuilder id(String id) {
        this.id = id;
        return this;
    }

    public FoodItemStackBuilder texture(String texture) {
        Validate.isTrue(material == null, "Cannot set a texture because this item already has a material!");
        this.texture = texture;
        return this;
    }

    public FoodItemStackBuilder material(Material material) {
        Validate.isTrue(texture == null, "Cannot set a material because this item already has a texture");
        this.material = material;
        return this;
    }

    public FoodItemStackBuilder name(String name) {
        this.name = name;
        return this;
    }

    public FoodItemStackBuilder lore(String... lore) {
        this.lore = lore;
        this.perfectLore = lore;
        return this;
    }

    public FoodItemStackBuilder perfectLore(String... lore) {
        this.perfectLore = lore;
        return this;
    }

    public FoodItemStackBuilder hunger(int hunger, double saturationRatio) {
        this.hunger = hunger;
        this.saturationRatio = saturationRatio;
        return this;
    }

    public FoodItemStackBuilder hunger(int hunger) {
        this.hunger = hunger;
        return this;
    }

    public FoodItemStackBuilder effects(FoodEffect... effects) {
        this.effects = effects;
        return this;
    }

    public FoodItemStack build() {
        Validate.notNull(id, "Must set an id!");
        Validate.notNull(name, "Must set a name!");
        Validate.isTrue(material != null || texture != null, "Must set a material or texture!");
        return texture == null ? FoodItemStack.of(id, material, name, hunger, saturationRatio, effects, lore, perfectLore)
            : FoodItemStack.of(id, texture, name, hunger, saturationRatio, effects, lore, perfectLore);
    }

}
