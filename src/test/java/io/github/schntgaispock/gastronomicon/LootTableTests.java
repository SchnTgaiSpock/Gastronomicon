package io.github.schntgaispock.gastronomicon;

import io.github.schntgaispock.gastronomicon.api.loot.LootTable;
import io.github.schntgaispock.gastronomicon.util.collections.Counter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LootTableTests {

    public static void main(String[] args) {
        final LootTable<String> table = LootTable.builder(String.class)
            .add(1, "1", "one", "1.0")
            .add(4, "4", "four", "2+2", "2*2")
            .add(6, "6", "six", "3+3")
            .add(10, "5*2", "6+4", "210%200")
            .add(11, "\"1\"+\"1\"", "11", "eleven")
            .add(100, "10^2")
            .build();

        final Counter<String> generated = new Counter<>();
        for (int i = 0; i < 20000000; i++) {
            generated.add(table.generate());
        }
        generated.stream().forEach(pair -> System.out.println(pair.first() + ": " + Math.round(200 * pair.second() / (double) generated.getTotal())));
    }
    
}
