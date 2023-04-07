package io.github.schntgaispock.gastronomicon.api.trees;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

@Getter
@ToString
@RequiredArgsConstructor
public final class TreeStructure {

    private static final ObjectMapper JSONObjectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private static final String TREE_SCHEMATIC_PATH = "plugins/Gastronomicon/schematics/";

    private static final @Getter Map<String, TreeStructure> loadedTrees = new HashMap<>();

    public static void loadTrees() {
        final File treePath = new File(TREE_SCHEMATIC_PATH);
        for (File treeFile : treePath.listFiles()) {
            try {
                final TreeStructure tree = JSONObjectMapper.readValue(treeFile, TreeStructure.class);
                loadedTrees.put(tree.getSapling(), tree);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final int[][][] blocks;
    private final String sapling;
    private final String fruit;
    private final String[] palette;
    private final int[] root; // [x, y, z]

    public void build(Location l, String sapling) {
        final int[][][] structure = getBlocks();
        final int center[] = getRoot();
    
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
                            BlockStorage.store(l.getWorld().getBlockAt(newX, newY, newZ), getFruit());
                            break;
                        default:
                            Block b = l.getWorld().getBlockAt(newX, newY, newZ);
                            if (NumberUtil.flip(0.1))
                                BlockStorage.store(b, sapling);
                            b.setType(Material.valueOf(getPalette()[id - 2]));
                    }
                }
            }
        }
    }
}
