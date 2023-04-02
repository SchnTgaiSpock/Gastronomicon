package io.github.schntgaispock.gastronomicon.api.trees;

import java.util.Map;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class TreeStructure {
    private final int[][][] structure;
    private final int[] center; // [x, y, z]
    private final Map<Integer, String> palette;
}
