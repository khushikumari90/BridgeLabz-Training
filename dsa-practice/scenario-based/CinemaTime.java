package scenario_based;
import java.util.ArrayList;
import java.util.List;

class InvalidTimeFormatException extends Exception {
    InvalidTimeFormatException(String msg) {
        super(msg);
    }
}

public class CinemaTime {

    private List<String> movieTitles = new ArrayList<>();
    private List<String> showTimes = new ArrayList<>();

    void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        showTimes.add(time);
    }

    void searchMovie(String keyword) {
        try {
            boolean found = false;
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).contains(keyword)) {
                    System.out.println(
                        String.format("Found: %s at %s", movieTitles.get(i), showTimes.get(i))
                    );
                    found = true;
                }
            }
            if (!found)
                System.out.println("Movie not found");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Search index error");
        }
    }

    void displayAllMovies() {
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(
                String.format("%d. %s - %s", i + 1, movieTitles.get(i), showTimes.get(i))
            );
        }
    }

    void generateReport() {
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = showTimes.toArray(new String[0]);

        System.out.println("Printable Movie Report:");
        for (int i = 0; i < titlesArray.length; i++) {
            System.out.println(titlesArray[i] + " @ " + timesArray[i]);
        }
    }

    private boolean isValidTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}"))
            return false;

        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));

        return hour >= 0 && hour < 24 && min >= 0 && min < 60;
    }

    public static void main(String[] args) {

        CinemaTime cinema = new CinemaTime();

        try {
            cinema.addMovie("Inception", "18:30");
            cinema.addMovie("Avatar", "21:00");
            cinema.addMovie("Matrix", "25:99");
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        cinema.displayAllMovies();
        cinema.searchMovie("Avatar");
        cinema.generateReport();
    }
}
