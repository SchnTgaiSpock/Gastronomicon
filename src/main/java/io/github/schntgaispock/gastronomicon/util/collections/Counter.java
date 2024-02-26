package io.github.schntgaispock.gastronomicon.util.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import lombok.Getter;

public class Counter<T> {

    private Map<Integer, Pair<T, Integer>> map = new HashMap<>();
    private final @Nullable Function<T, Integer> hashFunction;
    private Integer max;
    private Integer min;
    private @Getter int total = 0;

    public Counter(Function<T, Integer> hashFunction) {
        this.hashFunction = hashFunction;
    }

    public Counter() {
        this(null);
    }

    private int hash(T item) {
        if (item == null)
            return 0;
        if (hashFunction == null)
            return item.hashCode();
        return hashFunction.apply(item);
    }

    public void add(T item, int amount) {
        Validate.isTrue(amount > 0, "amount must be greater than zero");
        final int hash = hash(item);
        if (map.containsKey(hash)) {
            set(hash, get(hash) + amount);
        } else {
            map.put(hash, new Pair<>(item, amount));
        }

        if (min == null || min == hash) {
            Pair<Integer, Integer> maxMin = findMaxMin();
            max = maxMin.first();
            min = maxMin.second();
        } else if (get(hash) >= max().second()) {
            max = hash;
        }

        total += amount;
    }

    public void add(T item) {
        add(item, 1);
    }

    private void sub(int hash, int amount) {
        Validate.isTrue(amount > 0, "amount must be greater than zero");
        if (!map.containsKey(hash)) {
            return;
        }

        if (get(hash) <= amount) {
            remove(hash);
        } else {
            set(hash, get(hash) - amount);

            if (max == hash || max == null) {
                Pair<Integer, Integer> maxMin = findMaxMin();
                max = maxMin.first();
                min = maxMin.second();
            } else if (get(hash) <= min().second()) {
                min = hash;
            } 
            
            total -= amount;
        }
    }

    public void sub(T item, int amount) {
        sub(hash(item), amount);
    }

    public void sub(T item) {
        sub(hash(item), 1);
    }

    private int get(Integer hash) {
        return map.containsKey(hash) ? map.get(hash).second() : 0;
    }

    public int get(T item) {
        return get(hash(item));
    }

    private void set(int hash, int amount) {
        Validate.isTrue(amount > 0, "amount must be greater than zero");
        map.get(hash).second(amount);
    }

    private void remove(int hash) {
        total -= get(hash);
        map.remove(hash);

        if (min == hash || max == hash) {
            Pair<Integer, Integer> maxMin = findMaxMin();
            max = maxMin.first();
            min = maxMin.second();
        }
    }

    public void remove(T item) {
        remove(hash(item));
    }

    public void clear() {
        map.clear();
        total = 0;
        max = null;
        min = null;
    }

    private Pair<Integer, Integer> findMaxMin() {
        int maxHash = 0;
        int maxAmount = 0;
        int minHash = 0;
        int minAmount = Integer.MAX_VALUE;

        if (map.size() == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        for (Map.Entry<Integer, Pair<T, Integer>> entry : map.entrySet()) {
            if (entry.getValue().second() >= maxAmount) {
                maxHash = entry.getKey();
                maxAmount = entry.getValue().second();
            }
            
            if (entry.getValue().second() <= minAmount) {
                minHash = entry.getKey();
                minAmount = entry.getValue().second();
            }
        }

        return new Pair<>(maxHash, minHash);
    }

    public Pair<T, Integer> max() {
        return map.containsKey(max) ? map.get(max) : new Pair<>(null, 0);
    }

    public Pair<T, Integer> min() {
        return map.containsKey(min) ? map.get(min) : new Pair<>(null, Integer.MAX_VALUE);
    }

    public Collection<Pair<T, Integer>> entries() {
        return map.values();
    }

    @Override
    public String toString() {
        final StringBuilder string = new StringBuilder("{");
        for (Map.Entry<Integer, Pair<T, Integer>> key : map.entrySet()) {
            string.append(key.getValue().first() + ": " + key.getValue().second() + ", ");
        }
        string.delete(string.length() - 2, string.length()).append("}");
        return string.toString();
    }

    /**
     * Useful for debugging
     */
    public String details() {
        final StringBuilder string = new StringBuilder(toString());
        string.deleteCharAt(string.length() - 1)
            .append(" | max: ")
            .append(max().toString())
            .append(", min: ")
            .append(min().toString())
            .append(", total: ")
            .append(total)
            .append("}");
        return string.toString();
    }

    public Stream<Pair<T, Integer>> stream() {
        return map.values().stream();
    }

}
