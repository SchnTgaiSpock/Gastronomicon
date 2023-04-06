package io.github.schntgaispock.gastronomicon.api.trees;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class TreeStructure {

    public static TreeStructure VANILLA_TREE;
    public static TreeStructure BANANA_TREE;
    public static TreeStructure LYCHEE_TREE;

    private final int[][][] structure;
    private final int[] center; // [x, y, z]
    private final String[] palette;
    private final String fruit;

}
