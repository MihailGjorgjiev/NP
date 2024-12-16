package VtorKolokviumVezbi.GenericCollection_5;

import com.sun.source.tree.Tree;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GenericCollection<T extends IHasTimestamp & Comparable<T>>{
    private Map<String, Set<T>> genericItems;

    public GenericCollection() {
        genericItems=new HashMap<>();
    }

    public void addGenericItem (String category, T element){
        genericItems.putIfAbsent(category,new HashSet<>());
        genericItems.get(category).add(element);
    }

    public Collection<T> findAllBetween (LocalDateTime from, LocalDateTime to){
        return genericItems.values().stream()
                .flatMap(lst->lst.stream())
                .filter(item->{
                    return item.getTimestamp().isAfter(from) &&
                            item.getTimestamp().isBefore(to);
                }).sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Collection<T> itemsFromCategories (List<String> categories){
        return categories.stream()
                .map(category->genericItems.getOrDefault(category,Collections.emptySet()))
                .flatMap(lst->lst.stream())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Map<String, Set<T>> byMonthAndDay(){
        Map<String, Set<T>> result=new TreeMap<>(Comparator.comparing(String::valueOf));

        genericItems.values().stream()
                .flatMap(lst->lst.stream())
                .forEach(item->{
                    int month=item.getTimestamp().getMonth().getValue();
                    int day=item.getTimestamp().getDayOfMonth();
                    String key=String.format("%02d-%02d",month,day);
                    result.putIfAbsent(key,new TreeSet<>(Comparator.reverseOrder()));
                    result.get(key).add(item);
                });
        return result;
    }

    public Map<Integer, Long> countByYear(){
        Map<Integer, Long> result=new TreeMap<>(Comparator.comparing(Integer::intValue));
        genericItems.values().stream()
                .flatMap(lst->lst.stream())
                .forEach(item->{
                  int year=item.getTimestamp().getYear();
                  result.putIfAbsent(year,0L);
                  result.put(year,result.get(year)+1);
                });
        return result;
    }
}
