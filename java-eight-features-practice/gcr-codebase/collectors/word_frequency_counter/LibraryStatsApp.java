package word_frequency_counter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

public class LibraryStatsApp {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
            new Book("Book A", "Fiction", 320),
            new Book("Book B", "Fiction", 280),
            new Book("Book C", "Science", 450),
            new Book("Book D", "Science", 390),
            new Book("Book E", "History", 500)
        );

        // Statistics per genre
        Map<String, IntSummaryStatistics> statsByGenre =
                books.stream()
                     .collect(Collectors.groupingBy(
                         b -> b.genre,
                         Collectors.summarizingInt(b -> b.pages)
                     ));

        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("  Total Pages: " + stats.getSum());
            System.out.println("  Average Pages: " + stats.getAverage());
            System.out.println("  Max Pages: " + stats.getMax());
        });
    }
}

