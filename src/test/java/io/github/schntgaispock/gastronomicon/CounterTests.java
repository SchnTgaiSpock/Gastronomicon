package io.github.schntgaispock.gastronomicon;

import io.github.schntgaispock.gastronomicon.util.collections.Counter;

public class CounterTests {
    public static void main(String[] args) {
        final Counter<Integer> counter = new Counter<>();

        counter.add(1, 15);
        counter.add(2, 10);
        System.out.println(counter.details());
        counter.sub(1, 10);
        counter.sub(2, 15);
        System.out.println(counter.details());
        counter.add(3, 20);
        System.out.println(counter.details());
        counter.add(1, 20);
        System.out.println(counter.details());
        counter.sub(1, 20);
        System.out.println(counter.details());
    }
}
