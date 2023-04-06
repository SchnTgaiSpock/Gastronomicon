package io.github.schntgaispock.gastronomicon.api.trees;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

@UtilityClass
public class TreeBuilder {

    public static void build(Location l, String sapling, TreeStructure tree) {
        final int[][][] structure = tree.getStructure();
        final int center[] = tree.getCenter();

        for (int y = 0; y < structure.length; y++) {
            for (int z = 0; z < structure[0].length; z++) {
                for (int x = 0; x < structure[0][0].length; x++) {
                    int id = structure[y][z][x];
                    int newX = l.getBlockX() + x - center[0];
                    int newY = l.getBlockY() + y - center[1];
                    int newZ = l.getBlockZ() + z - center[2];
                    switch (id) {
                        case 0:
                            continue;
                        case 1:
                            BlockStorage.store(l.getWorld().getBlockAt(newX, newY, newZ), tree.getFruit());
                            break;
                        default:
                            Block b = l.getWorld().getBlockAt(newX, newY, newZ);
                            if (NumberUtil.flip(0.1))
                                BlockStorage.store(b, sapling);
                            b.setType(Material.valueOf(tree.getPalette()[id - 2]));
                    }
                }
            }
        }
    }

}
