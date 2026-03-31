//Scenario: Develop a program to manage student test scores.
package oopsscenariobased;
import java.util.Scanner;

public class StudentScoreManager {

    private double[] scores;
    private int n;

    // Constructor
    public StudentScoreManager(int n) {
        this.n = n;
        scores = new double[n];
    }

    // Input scores with validation
    public void inputScores() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Enter score of student " + (i + 1) + ": ");
                    double score = sc.nextDouble();

                    if (score < 0) {
                        System.out.println("Score cannot be negative!");
                        continue;
                    }

                    scores[i] = score;
                    break;

                } catch (Exception e) {
                    System.out.println("Invalid input! Enter numeric value.");
                    sc.next();
                }
            }
        }
        sc.close();
    }

    public double calculateAverage() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / n;
    }

    public double findHighest() {
        double max = scores[0];
        for (double score : scores) {
            if (score > max)
                max = score;
        }
        return max;
    }

    public double findLowest() {
        double min = scores[0];
        for (double score : scores) {
            if (score < min)
                min = score;
        }
        return min;
    }

    public void displayAboveAverage() {
        double avg = calculateAverage();
        System.out.println("\nScores above average:");
        for (double score : scores) {
            if (score > avg) {
                System.out.println(score);
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        StudentScoreManager manager = new StudentScoreManager(n);
        manager.inputScores();

        System.out.println("\nAverage Score: " + manager.calculateAverage());
        System.out.println("Highest Score: " + manager.findHighest());
        System.out.println("Lowest Score: " + manager.findLowest());

        manager.displayAboveAverage();
        sc.close();
    }
}
