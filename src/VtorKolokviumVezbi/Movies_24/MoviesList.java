package VtorKolokviumVezbi.Movies_24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MoviesList {
    private List<Movie> movies;

    public MoviesList() {
        movies=new ArrayList<>();
    }

    public void addMovie(String title, int[] ratings){
        movies.add(new Movie(title,ratings));
    }

    public List<Movie> top10ByAvgRating(){
        return movies.stream()
                .sorted(Comparator.comparing(Movie::averageRating,Comparator.reverseOrder())
                        .thenComparing(Movie::getTitle))
                .limit(10)
                .collect(Collectors.toList());
    }

    public List<Movie> top10ByRatingCoef(){
        int max_ratings=movies.stream().mapToInt(Movie::totalRatings).max().orElse(1);

        Comparator<Movie> comparator=Comparator.comparing(
                (Movie m)->(m.averageRating()*m.totalRatings())/max_ratings,Comparator.reverseOrder())
                .thenComparing(Movie::getTitle);

        return movies.stream()
                .sorted(comparator)
                .limit(10)
                .collect(Collectors.toList());


    }


}
