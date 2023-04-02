package io.github.schntgaispock.gastronomicon.api.trees;

import org.bukkit.Location;
import org.bukkit.Material;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TreeBuilder {

    public static void build(Location l, TreeStructure tree) {
        final int[][][] structure = tree.getStructure();
        final int center[] = tree.getCenter();

        for (int y = 0; y < structure.length; y++) {
            for (int z = 0; z < structure[0].length; z++) {
                for (int x = 0; x < structure[0][0].length; x++) {
                    int id = structure[y][z][x];
                    l.getWorld().getBlockAt(
                        l.getBlockX() + x - center[0], 
                        l.getBlockY() + y - center[1],
                        l.getBlockZ() + z - center[2]
                    ).setType(id > 0 ? Material.ACACIA_FENCE : Material.AIR);
                }
            }
        }
    }
    
}
