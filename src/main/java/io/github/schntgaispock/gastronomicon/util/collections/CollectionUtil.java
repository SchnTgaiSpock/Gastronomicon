package io.github.schntgaispock.gastronomicon.util.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CollectionUtil {
    
    public static String commaJoin(Object[] list) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < list.length - 1; i++) {
            text.append(list[i]).append(", ");
        }
        text.append(list[list.length - 1]);
        return text.toString();
    }

    public static <K, V> Map<K, V> toMap(K key, V value) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(key, value);
        return map;
    }

    public static boolean isEmpty(Object[] array) {
        for (final Object object : array) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }

    @SafeVarargs
    public static <T> T choice(T... a) {
        return a[ThreadLocalRandom.current().nextInt(a.length)];
    }

    public static <T> T choice(List<T> a) {
        return a.get(ThreadLocalRandom.current().nextInt(a.size()));
    }
    
}
