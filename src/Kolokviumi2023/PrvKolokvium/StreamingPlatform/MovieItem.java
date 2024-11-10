package Kolokviumi2023.PrvKolokvium.StreamingPlatform;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovieItem implements Item{
    private String name;
    private String genre;
    private double rating;

    public MovieItem(String movieData) {
        List<String> dataParts= Arrays.stream(movieData.split(";")).collect(Collectors.toList());
        this.name = dataParts.get(0);
        this.genre = dataParts.get(1);
        this.rating = calculateRating(dataParts.get(2));
    }
    private  static double calculateRating(String ratingData){
        List<Integer> rating= Arrays.stream(ratingData.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return (double) (rating.stream().mapToDouble(Integer::doubleValue).sum() / rating.size())* Math.min(rating.size()/20.0,1.0);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie " + name + " " + String.format("%.4f",rating);
    }
}
