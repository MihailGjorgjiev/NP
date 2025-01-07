package Kolokviumi2023.VtorKolokvium.StreamingPlatform;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private String id;
    private String username;
    private List<Rating> ratings;

    public User(String id, String username) {
        this.id = id;
        this.username = username;

        this.ratings = new ArrayList<>();
    }

    public List<String> favouriteMoviesIds() {
        Map<String, Double> avgRatings = ratings.stream().collect(Collectors.groupingBy(
                Rating::getMovieId,
                Collectors.averagingInt(Rating::getRating)
        ));
        Double maxRating = avgRatings.values().stream().max(Double::compare).orElse(0.0);

        return avgRatings.entrySet().stream()
                .filter(m -> m.getValue().equals(maxRating))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    @Override
    public String toString() {
        return "User ID: " + id + " Name: " + username;
    }
}
