package VtorKolokviumVezbi.GenericMap_32;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapOps {
    public static <K extends Comparable<K>, V extends Comparable<V>> Map<K, V> merge(Map<K, V> map1, Map<K, V> map2, MergeStrategy<V> mergeStrategy) {
        Map<K, V> result = new TreeMap<>();
        map2.keySet().stream()
                .filter(map1::containsKey)
                .forEach(key -> result.put(key, mergeStrategy.execute(map1.get(key),map2.get(key))));

        map1.keySet().stream()
                .filter(key1 -> !map2.containsKey(key1))
                .forEach(key1 -> {
                    result.put(key1, map1.get(key1));
                });

        map2.keySet().stream()
                .filter(key2 -> !map1.containsKey(key2))
                .forEach(key2 -> {
                    result.put(key2, map2.get(key2));
                });


        return result;
    }
}