package Kolokviumi2023.PrvKolokvium.StreamingPlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SeriesItem implements Item{
    private String name;
    private String genre;
    private double rating;
    private int episodes;

    public SeriesItem(String seriesData) {
        List<String> dataParts= Arrays.stream(seriesData.split(";")).collect(Collectors.toList());
        this.name = dataParts.get(0);
        this.genre = dataParts.get(1);
        this.episodes= dataParts.size()-2;
        this.rating = calculateRating(dataParts.subList(2, dataParts.size()));
    }

    private static double calculateRating(List<String> ratingDataList) {
        List<Double> seriesRating=new ArrayList<>();
        for(String ratingData:ratingDataList){
            List<Integer> episodeRating=Arrays.stream(ratingData.split(" ")).filter(el->!el.startsWith("S")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            seriesRating.add(episodeRating.stream().mapToDouble(Integer::doubleValue).sum()/episodeRating.size()* Math.min(episodeRating.size()/20.0,1.0));
        }
        seriesRating.sort(Comparator.reverseOrder());

        return seriesRating.subList(0,3).stream().mapToDouble(Double::doubleValue).average().orElse(0);
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

    public int getEpisodes() {
        return episodes;
    }

    @Override
    public String toString() {
        return "TV Show " + name + " " + String.format("%.4f",rating) + " (" + episodes + " episodes)";
    }
}
