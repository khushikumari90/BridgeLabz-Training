package top_five_trending_movies;
import java.util.*;
import java.util.stream.*;

public class MovieApp {
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.5, 2024),
            new Movie("Movie B", 9.0, 2023),
            new Movie("Movie C", 7.8, 2022),
            new Movie("Movie D", 8.9, 2024),
            new Movie("Movie E", 9.2, 2023),
            new Movie("Movie F", 8.7, 2021),
            new Movie("Movie G", 9.1, 2024)
        );

        List<Movie> top5Trending = movies.stream()

            // filter recent movies (example: after 2021)
            .filter(m -> m.releaseYear >= 2022)

            // sort by rating desc, then release year desc
            .sorted(
                Comparator.comparingDouble((Movie m) -> m.rating).reversed()
                          .thenComparing(m -> m.releaseYear, Comparator.reverseOrder())
            )

            // limit to top 5
            .limit(5)

            .collect(Collectors.toList());

        top5Trending.forEach(System.out::println);
    }
}
