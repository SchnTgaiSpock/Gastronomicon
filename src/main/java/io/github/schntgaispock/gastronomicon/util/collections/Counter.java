package io.github.schntgaispock.gastronomicon.util.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.annotation.Nullable;

import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;

public class Counter<T> {

    private Map<Integer, Pair<T, Integer>> map = new HashMap<>();
    private final @Nullable Function<T, Integer> hashFunction;
    private int max;
    private int min;
    private int total;

    public Counter(Function<T, Integer> hashFunction) {
        this.hashFunction = hashFunction;
    }

    public Counter() {
        this(null);
    }

    @SuppressWarnings("null")
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
            map.put(hash, new Pair<>(item, 0));
        }

        if (get(hash) >= get(max)) {
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
            total -= get(hash);
            map.remove(hash);
        } else {
            set(hash, get(hash) - amount);

            if (get(hash) <= get(min)) {
                max = hash;
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

    private int get(int hash) {
        return map.containsKey(hash) ? map.get(hash).second() : 0;
    }

    public int get(T item) {
        return get(hash(item));
    }

    private void set(int hash, int amount) {
        Validate.isTrue(amount > 0, "amount must be greater than zero");
        total += amount - get(hash);
        map.get(hash).second(amount);
    }

    public void set(T item, int amount) {
        set(hash(item), amount);
    }

    private void remove(int hash) {
        total -= get(hash);
        map.remove(hash);

        Pair<Integer, Integer> maxMin = findMaxMin();
        max = maxMin.first();
        min = maxMin.second();
    }

    public void remove(T item) {
        remove(hash(item));
    }

    public void clear() {
        map.clear();
        total = 0;
    }

    private Pair<Integer, Integer> findMaxMin() {
        int maxHash = 0;
        int maxAmount = 0;
        int minHash = 0;
        int minAmount = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Pair<T, Integer>> entry : map.entrySet()) {
            if (entry.getValue().second() >= maxAmount) {
                maxHash = entry.getKey();
            } else if (entry.getValue().second() <= minAmount) {
                minHash = entry.getKey();
            }
        }

        return new Pair<>(maxHash, minHash);
    }

    public T max() {
        return map.get(max).first();
    }

    public T min() {
        return map.get(min).first();
    }

    public Collection<Pair<T, Integer>> entries() {
        return map.values();
    }

}
