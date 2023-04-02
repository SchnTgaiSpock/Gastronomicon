package io.github.schntgaispock.gastronomicon.util.collections;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Pair<T, U> {
    
    private T first;
    private U second;

    public T first() { return first; }
    public void first(T first) { this.first = first; }
    public U second() { return second; }
    public void second(U second) { this.second = second; }

}
