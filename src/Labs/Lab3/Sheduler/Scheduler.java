package Labs.Lab3.Sheduler;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scheduler<T>{
    private List<Timestamp<T>> timestamps;

    public Scheduler() {
        this.timestamps = new ArrayList<>();
    }

    public void add(Timestamp<T> t){
        timestamps.add(t);
    }

    public boolean remove(Timestamp<T> t){
        return timestamps.remove(t);
    }
    public Timestamp<T> next(){
        List<Timestamp<T>> query=timestamps.stream().filter(t->t.getTime().compareTo(LocalDateTime.now())>0).sorted(Timestamp::compareTo).collect(Collectors.toList());

        return query.get(0);
    }

    public Timestamp<T> last(){
        List<Timestamp<T>> query=timestamps.stream().filter(t->t.getTime().compareTo(LocalDateTime.now())<0).sorted(Timestamp::compareTo).collect(Collectors.toList());

        return query.get(query.size()-1);
    }

    public  List<Timestamp<T>> getAll(LocalDateTime begin, LocalDateTime end){
        return timestamps.stream().filter(t->t.getTime().compareTo(begin)>0 && t.getTime().compareTo(end)<0).collect(Collectors.toList());
    }
}
