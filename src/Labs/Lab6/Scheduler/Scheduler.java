package Labs.Lab6.Scheduler;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Scheduler<T> {
    private Map<Date,T> items;
    public Scheduler() {
        items=new HashMap<>();
    }
    public void add(Date d,T t){
        items.put(d,t);
    }
    public boolean remove(Date d){
        if(!items.containsKey(d)){
            return false;
        }
        items.remove(d);
        return true;
    }
    public T next(){

        Date today=new Date();

        Date first = items.keySet().stream()
                .sorted(Comparator.comparingLong(date -> Math.abs(date.getTime() - today.getTime())))
                .filter(date -> date.after(today)).findFirst().orElse(today);

        return items.getOrDefault(first,null);

    }
    public T last(){

        Date today=new Date();

        Date last = items.keySet().stream()
                .sorted(Comparator.comparingLong(date -> Math.abs(date.getTime() - today.getTime())))
                .filter(date -> date.before(today)).findFirst().orElse(today);

        return items.getOrDefault(last,null);

    }
    public ArrayList<T> getAll(Date begin,Date end){
        return items.keySet().stream()
                .filter(date-> date.after(begin))
                .filter(date->date.before(end))
                .map(date->items.get(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public T getFirst(){
        Date date = items.keySet().stream().sorted().findFirst().orElse(new Date());
        return items.getOrDefault(date,null);
    }
    public T getLast(){
        Date date = items.keySet().stream().sorted(Comparator.reverseOrder()).findFirst().orElse(new Date());
        return items.getOrDefault(date,null);
    }

}
