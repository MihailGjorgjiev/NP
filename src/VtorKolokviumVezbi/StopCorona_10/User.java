package VtorKolokviumVezbi.StopCorona_10;

import CollectionBook.Streams.CoronavirusApp.LocationUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String id;
    private String name;
    private LocalDateTime timeInfected;
    boolean isInfected;
    private List<ILocation> locations;
    public User(String id, String name) {
        this.id = id;
        this.name = name;

        this.locations=new ArrayList<>();

        this.timeInfected=LocalDateTime.MAX;
        this.isInfected=false;
    }

    public void infect(LocalDateTime timestamp){
        timeInfected=timestamp;
        isInfected=true;
    }
    public  void addLocations(List<ILocation> loc){
        locations.addAll(loc);
//        for (ILocation l:loc){
//            locations.add(l);
//        }
    }

    public int totalDirectContacts(User u){
        return locations.stream()
                .flatMapToInt(l1 -> u.locations.stream()
                        .mapToInt(l2 ->
                                StopCoronaTest.isDanger(l1, l2) ? 1 : 0))
                .sum();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTimeInfected() {
        return timeInfected;
    }

    public boolean isInfected() {
        return isInfected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s",name,id,timeInfected);
    }
}
