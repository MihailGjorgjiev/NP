package CollectionBook.Generics.Introduction.Classes.GenericTable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericTable<R extends Comparable<R>, V extends Number> {
    Map<R, List<V>> map;

    public GenericTable() {
        map = new HashMap<>();
    }

    public void addRow(R key, List<V> values) {
        map.put(key, values);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (R key : map.keySet()) {
            StringBuilder rb = new StringBuilder();
            for (V val : map.get(key)) {
                rb.append(String.format("%4.2f", val.doubleValue()));
            }
            sb.append(String.format("%s: %s\n", key, rb.toString()));
        }
        return sb.toString();
    }

    public double max(R key){
        return map.get(key).stream().max(Comparator.comparingDouble(Number::doubleValue)).get().doubleValue();
    }
}
