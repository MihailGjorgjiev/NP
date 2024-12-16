package VtorKolokviumVezbi.StopCorona_10;

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
        int totalContacts=0;
        for(ILocation l1:locations){
            for(ILocation l2:u.locations){
                double x2=Math.pow(l1.getLatitude()-l2.getLatitude(),2);
                double y2=Math.pow(l1.getLongitude()-l2.getLongitude(),2);
                if(x2+y2<=2){
                    totalContacts++;
                }
            }
        }
        return totalContacts;
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
