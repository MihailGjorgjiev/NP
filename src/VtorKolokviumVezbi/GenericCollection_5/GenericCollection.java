package VtorKolokviumVezbi.GenericCollection_5;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GenericCollection<T extends IHasTimestamp & Comparable<T>> {
    private Map<String, Set<T>> genericItems;
    private Map<String, Set<T>> timestampItems;

    public GenericCollection() {
        genericItems = new TreeMap<>();
        timestampItems = new TreeMap<>();
    }

    public void addGenericItem(String category, T element) {
        genericItems.putIfAbsent(category, new TreeSet<>(Comparable::compareTo));
        genericItems.get(category).add(element);

        String key=String.format("%02d-%02d",element.getTimestamp().getMonthValue(),element.getTimestamp().getDayOfMonth());
        timestampItems.putIfAbsent(key,new TreeSet<>(Comparator.reverseOrder()));
        timestampItems.get(key).add(element);
    }

    public Collection<T> findAllBetween(LocalDateTime from, LocalDateTime to) {
        return genericItems.values().stream()
                .flatMap(Collection::stream)
                .filter(item -> {
                    return item.getTimestamp().isAfter(from) &&
                            item.getTimestamp().isBefore(to);
                })
                .collect(Collectors.toCollection(() -> new TreeSet<>((o1, o2) -> o2.compareTo(o1))));
    }

    public Collection<T> itemsFromCategories(List<String> categories) {
        TreeSet<T> result=new TreeSet<>(Comparator.reverseOrder());
        genericItems.entrySet().stream()
                .filter(gi->categories.contains(gi.getKey()))
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .forEach(result::add);

        return result;
//        return categories.stream()
//                .map(category -> genericItems.getOrDefault(category, Collections.emptySet()))
//                .flatMap(Collection::stream)
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Map<String, Set<T>> byMonthAndDay() {
        return timestampItems;
//        Map<String, Set<T>> result=new TreeMap<>(Comparator.comparing(String::valueOf));

//        genericItems.values().stream()
//                .flatMap(Collection::stream)
//                .forEach(item->{
//                    int month=item.getTimestamp().getMonth().getValue();
//                    int day=item.getTimestamp().getDayOfMonth();
//                    String key=String.format("%02d-%02d",month,day);
//                    result.putIfAbsent(key,new TreeSet<>(Comparator.reverseOrder()));
//                    result.get(key).add(item);
//                });

//        return result;
//        return genericItems.values().stream().flatMap(Collection::stream)
//                .collect(Collectors.groupingBy(
//                        t -> {
//                            int month=t.getTimestamp().getMonth().getValue();
//                            int day=t.getTimestamp().getDayOfMonth();
//                            return String.format("%02d-%02d",month,day);
//                        },
//                        Collectors.mapping(
//                                t -> t,
//                                Collectors.toCollection(() -> new TreeSet<>())
//                        )
//
//                ));
    }

    public Map<Integer, Long> countByYear() {
        return genericItems.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        t -> t.getTimestamp().getYear(),
                        TreeMap::new,
                        Collectors.counting()
                ));


    }
}
