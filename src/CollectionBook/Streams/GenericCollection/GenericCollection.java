package CollectionBook.Streams.GenericCollection;

import VtorKolokviumVezbi.DeliveryApp_36.Location;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GenericCollection<T extends Comparable<T> & IHasTimestamp> {
    private Map<String, Set<T>> mapByCategory;

    public GenericCollection() {
        this.mapByCategory=new HashMap<>();
    }

    public void addGenericItem(String category,T element){
        mapByCategory.putIfAbsent(category,new TreeSet<>());
        mapByCategory.get(category).add(element);
//        mapByCategory.computeIfPresent(category,(k,v)->{
//            v.add(element);
//            return v;
//        });
    }

    public Collection<T> findAllBetween(LocalDateTime from,LocalDateTime to){
        return mapByCategory.values().stream()
                .flatMap(Collection::stream)
                .filter(t->t.getTimestamp().isAfter(from) &&
                        t.getTimestamp().isBefore(to))
                .collect(Collectors.toCollection(()->new TreeSet<T>(
                        Comparator.reverseOrder()
                )));
    }

    public Collection<T> itemsFromCategories(List<String> categories){
        return mapByCategory.keySet().stream()
                .filter(categories::contains)
                .flatMap(key->mapByCategory.get(key).stream())
                .collect(Collectors.toCollection(()->new TreeSet<T>(
                        Comparator.reverseOrder()
                )));
    }

    public Map<String,Set<T>> byMonthAndDay(){
        return mapByCategory.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        this::getDayAndMonthKey,
                        TreeMap::new,
                        Collectors.toCollection(()->new TreeSet<T>(
                                Comparator.reverseOrder()
                        ))
                ));
    }

    public Map<Integer,Long> countByYear(){
        return mapByCategory.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        element->element.getTimestamp().getYear(),
                        TreeMap::new,
                        Collectors.counting()
                ));
    }

    private String getDayAndMonthKey(T element){
        return String.format(
                "%02d-%02d",
                element.getTimestamp().getMonthValue(),
                element.getTimestamp().getDayOfMonth());
    }


}
