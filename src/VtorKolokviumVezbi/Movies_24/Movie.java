package VtorKolokviumVezbi.Movies_24;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private List<Integer> ratings;

    public Movie(){
        title="";
        ratings=new ArrayList<>();
    }
    public Movie(String title, int[] ratings) {
        this();
        this.title = title;
        for(int r:ratings){
            this.ratings.add(r);
        }
    }

    public String getTitle() {
        return title;
    }

    public List<Integer> getRatings() {
        return ratings;
    }
    public int totalRatings(){
        return ratings.size();
    }
    public double averageRating(){
        return ratings.stream().mapToInt(i->i).average().orElse(0);
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f) of %d ratings",title,averageRating(),totalRatings());
    }
}
