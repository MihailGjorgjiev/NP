package Kolokviumi2023.VtorKolokvium.StreamingPlatform;

import java.util.*;
import java.util.stream.Collectors;

public class StreamingPlatform {
    private Map<String, User> userMap;
    private Map<String, Movie> movieMap;
    private Map<String, Rating> ratingMap; // key = username-movie

    public StreamingPlatform() {
        this.userMap = new HashMap<>();
        this.movieMap = new HashMap<>();
        this.ratingMap = new HashMap<>();
    }

    public void addMovie(String id, String name) {
        movieMap.putIfAbsent(id, new Movie(id, name));
    }

    public void addUser(String id, String username) {
        userMap.putIfAbsent(id, new User(id, username));
    }

    public void addRating(String userId, String movieId, int rating) {
        String key = userId + "-" + movieId;
        Rating r = new Rating(userId, movieId, rating);
        ratingMap.putIfAbsent(key, r);

        userMap.computeIfPresent(userId, (k, v) -> {
            v.addRating(r);
            return v;
        });

        movieMap.computeIfPresent(movieId, (k, v) -> {
            v.addRating(r);
            return v;
        });
    }


    public void topNMovies(int n) {

        movieMap.values().stream()
                .sorted(Comparator.comparing(Movie::getRating, Comparator.reverseOrder()))
                .limit(n)
                .forEach(System.out::println);
    }

    public void favouriteMoviesForUsers(List<String> userIds) {
        userIds.stream()
                .forEach(uid -> {
                    System.out.println(userMap.get(uid));
                    userMap.get(uid).favouriteMoviesIds().stream()
                            .sorted(Comparator.comparing(m->movieMap.get(m).getRating(),Comparator.reverseOrder()))
                            .forEach(m-> {
                                System.out.println(movieMap.get(m));
                            });
                    System.out.println();
                });
    }

    private Map<String, Integer> cosineMap(String userId) {
        return movieMap.keySet()
                .stream()
                .collect(Collectors.toMap(
                        s -> s,
                        s-> ratingMap.getOrDefault(userId+"-"+s,new Rating("0","0",0)).getRating()
                ));
    }

    public void similarUsers(String userId) {
        Map<String, Integer> user = cosineMap(userId);
        userMap.keySet().stream()
                .filter(u->!userId.equals(u))
                .sorted(Comparator.comparing(u->CosineSimilarityCalculator.cosineSimilarity(user,cosineMap(u)),Comparator.reverseOrder()))
                .forEach(u-> System.out.println(userMap.get(u)+" "+CosineSimilarityCalculator.cosineSimilarity(user,cosineMap(u))));

    }

}
