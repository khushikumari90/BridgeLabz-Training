package stream_buzz;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Program {

    // Register creator
    public void registerCreator(CreatorStats record) {
        CreatorStats.EngagementBoard.add(record);
    }

    // Get top post counts
    public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {

        Map<String, Integer> result = new HashMap<>();

        for (CreatorStats creator : records) {
            int count = 0;
            for (double likes : creator.getWeeklyLikes()) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(creator.getCreatorName(), count);
            }
        }
        return result;
    }

    // Calculate average likes
    public double calculateAverageLikes() {

        double totalLikes = 0;
        int totalWeeks = 0;

        for (CreatorStats creator : CreatorStats.EngagementBoard) {
            for (double likes : creator.getWeeklyLikes()) {
                totalLikes += likes;
                totalWeeks++;
            }
        }

        if (totalWeeks == 0) {
            return 0;
        }

        return totalLikes / totalWeeks;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Program program = new Program();
        boolean running = true;

        while (running) {

            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("\nEnter your choice:");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    CreatorStats creator = new CreatorStats();

                    System.out.println("Enter Creator Name:");
                    creator.setCreatorName(sc.nextLine());

                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        likes[i] = Double.parseDouble(sc.nextLine());
                    }
                    creator.setWeeklyLikes(likes);

                    program.registerCreator(creator);
                    System.out.println("Creator registered successfully\n");
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double threshold = Double.parseDouble(sc.nextLine());

                    Map<String, Integer> result =
                            program.getTopPostCounts(CreatorStats.EngagementBoard, threshold);

                    if (result.isEmpty()) {
                        System.out.println("No top-performing posts this week\n");
                    } else {
                        for (Map.Entry<String, Integer> entry : result.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    double avg = program.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + avg + "\n");
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    running = false;
                    break;
            }
        }
        sc.close();
    }
}
