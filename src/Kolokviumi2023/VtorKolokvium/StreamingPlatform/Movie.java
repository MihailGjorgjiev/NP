package Kolokviumi2023.VtorKolokvium.StreamingPlatform;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String id;
    private String name;
    private List<Rating> ratings;

    public Movie(String id, String name) {
        this.id = id;
        this.name = name;
        this.ratings=new ArrayList<>();
    }

    public void addRating(Rating rating){
        ratings.add(rating);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRating(){
        return ratings.stream().mapToInt(Rating::getRating).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return String.format("Movie ID: %s Title: %s Rating: %.2f",id,name,getRating());
    }
}
