package m1_questions;
import java.util.*;

abstract class Festival {
    String name, location, date;

    Festival(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    abstract List<String> display();
}

class MusicFestival extends Festival {
    String headliner, genre;
    int price;

    MusicFestival(String name, String location, String date, String headliner, String genre, int price) {
        super(name, location, date);
        this.headliner = headliner;
        this.genre = genre;
        this.price = price;
    }

    List<String> display() {
        List<String> res = new ArrayList<>();
        res.add("Festival Name: " + name);
        res.add("Location: " + location);
        res.add("Date: " + date);
        res.add("Headliner: " + headliner);
        res.add("Music Genre: " + genre);
        res.add("Ticket Price: " + price);
        return res;
    }
}

class FoodFestival extends Festival {
    String cuisine;
    int stalls, fee;

    FoodFestival(String name, String location, String date, String cuisine, int stalls, int fee) {
        super(name, location, date);
        this.cuisine = cuisine;
        this.stalls = stalls;
        this.fee = fee;
    }

    List<String> display() {
        List<String> res = new ArrayList<>();
        res.add("Festival Name: " + name);
        res.add("Location: " + location);
        res.add("Date: " + date);
        res.add("Cuisine: " + cuisine);
        res.add("Number of Stalls: " + stalls);
        res.add("Entry Fee: " + fee);
        return res;
    }
}

class ArtFestival extends Festival {
    String artType;
    int artists, fee;

    ArtFestival(String name, String location, String date, String artType, int artists, int fee) {
        super(name, location, date);
        this.artType = artType;
        this.artists = artists;
        this.fee = fee;
    }

    List<String> display() {
        List<String> res = new ArrayList<>();
        res.add("Festival Name: " + name);
        res.add("Location: " + location);
        res.add("Date: " + date);
        res.add("Art Type: " + artType);
        res.add("Number of Artists: " + artists);
        res.add("Exhibition Fee: " + fee);
        return res;
    }
}

public class EventPlannerFestivalSystem {

    static Map<String, Festival> map = new HashMap<>();
    static List<String> finalOutput = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.equals("EXIT")) break;

            process(line);
        }

        for (String s : finalOutput) {
            System.out.println(s);
        }

        sc.close();
    }

    public static void process(String input) {
        String[] p = input.split(" ");

        if (p[0].equals("ADD_FESTIVAL")) {
            String type = p[1];

            if (type.equals("MUSIC")) {
                map.put(p[2], new MusicFestival(p[2], p[3], p[4], p[5], p[6], Integer.parseInt(p[7])));
            } else if (type.equals("FOOD")) {
                map.put(p[2], new FoodFestival(p[2], p[3], p[4], p[5], Integer.parseInt(p[6]), Integer.parseInt(p[7])));
            } else if (type.equals("ART")) {
                map.put(p[2], new ArtFestival(p[2], p[3], p[4], p[5], Integer.parseInt(p[6]), Integer.parseInt(p[7])));
            }

        } else if (p[0].equals("DISPLAY_DETAILS")) {
            String name = p[1];
            if (map.containsKey(name)) {
                finalOutput.addAll(map.get(name).display());
            }
        }
    }
}