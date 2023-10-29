package io.github.schntgaispock.gastronomicon.api.loot;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import io.github.schntgaispock.gastronomicon.util.collections.Pair;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * This class implements a stabilized Vose's Alias Method taken from
 * https://www.keithschwarz.com/darts-dice-coins/ and first published by M.D.
 * Vose in "A linear algorithm for generating random numbers with a
 * given distribution," in IEEE Transactions on Software Engineering
 */
@ToString(of = "drops")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class LootTable<T> {

    private final List<T> drops;
    private final int totalWeight;
    private final int[] prob;
    private final int[] alias;

    @RequiredArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LootTableBuilder<T> {

        protected int totalWeight = 0;
        protected final LinkedHashMap<T, Integer> weightedDrops = new LinkedHashMap<>();

        @SafeVarargs
        public final LootTableBuilder<T> add(int weight, T... drops) {
            for (final T drop : drops) {
                weightedDrops.put(drop, weight);
                totalWeight += weight;
            }
            return this;
        }

        @SafeVarargs
        public final LootTableBuilder<T> add(T... drops) {
            return add(1, drops);
        }

        public LootTable<T> build() {
            final int length = weightedDrops.size();

            final Deque<Pair<Integer, Integer>> small = new ArrayDeque<>();
            final Deque<Pair<Integer, Integer>> large = new ArrayDeque<>();
            final int[] prob = new int[length];
            final int[] alias = new int[length];

            int i = 0;
            for (int chance : weightedDrops.values()) {
                chance *= length;
                if (chance < totalWeight) {
                    small.push(Pair.of(chance, i));
                } else {
                    large.push(Pair.of(chance, i));
                }
                i++;
            }
            while (!small.isEmpty() && !large.isEmpty()) {
                final Pair<Integer, Integer> l = small.pop();
                final Pair<Integer, Integer> g = large.pop();
                prob[l.second()] = l.first();
                alias[l.second()] = g.second();
                g.first(g.first() + l.first() - totalWeight);
                if (g.first() < totalWeight) {
                    small.push(g);
                } else {
                    large.push(g);
                }
            }
            while (!large.isEmpty()) {
                prob[large.pop().second()] = totalWeight;
            }
            while (!small.isEmpty()) {
                prob[small.pop().second()] = totalWeight;
            }

            return new LootTable<T>(weightedDrops.keySet().stream().toList(), totalWeight, prob, alias);
        }

    }

    public static <T, U> LootTableBuilder<T> builder(Class<T> type) {
        return new LootTableBuilder<T>();
    }

    public static <T, U> ItemLootTableBuilder builder() {
        return new ItemLootTableBuilder();
    }

    public T generate() {
        if (drops.size() == 0) {
            return null;
        }
        
        final int roll = ThreadLocalRandom.current().nextInt(drops.size());
        if (ThreadLocalRandom.current().nextDouble() * totalWeight < prob[roll]) {
            return drops.get(roll);
        } else {
            return drops.get(alias[roll]);
        }
    }

    public int size() {
        return drops.size();
    }

    public boolean isEmpty() {
        return drops.isEmpty();
    }

}
