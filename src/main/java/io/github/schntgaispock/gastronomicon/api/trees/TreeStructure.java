package io.github.schntgaispock.gastronomicon.api.trees;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.util.NumberUtil;
import io.github.schntgaispock.gastronomicon.util.item.HeadTextures;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import lombok.Getter;
import lombok.ToString;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

@Getter
@ToString
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

        Gastronomicon.info("Loaded all trees");
    }

    private final int[][][] blocks;
    private final String sapling;
    private final String fruit;
    private final String[] palette;
    private final int[] root; // [x, z]
    private final String fruitTexture;

    public TreeStructure(
        @JsonProperty("blocks") int[][][] blocks,
        @JsonProperty("sapling") String sapling,
        @JsonProperty("fruit") String fruit,
        @JsonProperty("palette") String[] palette,
        @JsonProperty("root") int[] root
    ) {
        this.blocks = blocks;
        this.sapling = sapling;
        this.fruit = fruit;
        this.palette = palette;
        this.root = root;

        this.fruitTexture = switch (fruit) { // how tf do you get texture from an item
            case "GN_BANANA" -> HeadTextures.BANANA;
            case "GN_LYCHEE" -> HeadTextures.LYCHEE;
            case "GN_VANILLA_BEANS" -> HeadTextures.VANILLA;
            default -> null;
        };
    }

    public void build(Location l, String sapling) {
        final int[][][] structure = getBlocks();
        final int root[] = getRoot();
    
        for (int y = 0; y < structure.length; y++) {
            for (int z = 0; z < structure[0].length; z++) {
                for (int x = 0; x < structure[0][0].length; x++) {
                    int id = structure[y][z][x];
                    int newX = l.getBlockX() + x - root[0];
                    int newY = l.getBlockY() + y;
                    int newZ = l.getBlockZ() + z - root[1];
                    switch (id) {
                        case 0:
                            continue;
                        case 1:
                            Block b = l.getWorld().getBlockAt(newX, newY, newZ);
                            b.setType(Material.PLAYER_HEAD);
                            if (fruitTexture != null) PlayerHead.setSkin(b, PlayerSkin.fromBase64(fruitTexture), false);
                            BlockStorage.store(b, getFruit());
                            break;
                        default:
                            final String palette = getPalette()[id - 2];
                            Block b2 = l.getWorld().getBlockAt(newX, newY, newZ);
                            if (palette.endsWith("LEAVES") && NumberUtil.flip(0.1))
                                BlockStorage.store(b2, sapling);
                            b2.setType(Material.valueOf(palette));
                    }
                }
            }
        }
    }
}
