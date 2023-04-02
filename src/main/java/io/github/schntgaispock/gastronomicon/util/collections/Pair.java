package io.github.schntgaispock.gastronomicon.util.collections;

import javax.annotation.Nonnull;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Pair<T, U> {
    
    private @Nonnull T first;
    private @Nonnull U second;

    public T first() { return first; }
    public void first(T first) { this.first = first; }
    public U second() { return second; }
    public void second(U second) { this.second = second; }

}
