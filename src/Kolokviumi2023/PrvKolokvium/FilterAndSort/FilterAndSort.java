package Kolokviumi2023.PrvKolokvium.FilterAndSort;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterAndSort {
    public static  <T extends Comparable<T>> List<T> execute(List<T> objects, Predicate<T> rule) throws EmptyResultException {
        List<T> results= objects.stream().filter(o->rule.test(o)).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if(results.size()==0){
            throw new EmptyResultException("No element met the criteria");
        }
        return results;
    }
}