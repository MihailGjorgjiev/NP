package Kolokviumi2023.VtorKolokvium.StreamingPlatform;


public class Rating {
    private String userId;
    private String movieId;
    private int rating;

    public Rating(String userId, String movieId, int rating) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public String getMovieId() {
        return movieId;
    }

    public int getRating() {
        return rating;
    }
}
