package VtorKolokviumVezbi.GenericMap_32;

public interface MergeStrategy<V> {
    V execute(V v1,V v2);
}