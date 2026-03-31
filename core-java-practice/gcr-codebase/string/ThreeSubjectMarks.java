//Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. Compute the percentage and then calculate the grade
package strings;
import java.util.*;
public class ThreeSubjectMarks {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of students: ");
	        int students = sc.nextInt();

	        int[][] scores = generatePCMScores(students);
	        double[][] results = calculateResults(scores);
	        char[] grades = calculateGrades(results);

	        displayScorecard(scores, results, grades);
	        sc.close();

	}
	
    // a) Generate random PCM scores
    public static int[][] generatePCMScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(90) + 10; // 2-digit random number
            }
        }
        return scores;
    }

    // b) Calculate total, average and percentage
    public static double[][] calculateResults(int[][] scores) {
        int students = scores.length;
        double[][] results = new double[students][3]; // total, average, percentage

        for (int i = 0; i < students; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += scores[i][j];
            }

            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // round to 2 decimal places
            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    // c) Calculate grade based on percentage
    public static char[] calculateGrades(double[][] results) {
        int students = results.length;
        char[] grades = new char[students];

        for (int i = 0; i < students; i++) {
            double percentage = results[i][2];

            if (percentage >= 80)
                grades[i] = 'A';
            else if (percentage >= 70)
                grades[i] = 'B';
            else if (percentage >= 60)
                grades[i] = 'C';
            else if (percentage >= 50)
                grades[i] = 'D';
            else if (percentage >= 40)
                grades[i] = 'E';
            else
                grades[i] = 'R';
        }
        return grades;
    }

    // d) Display scorecard
    public static void displayScorecard(int[][] scores, double[][] results, char[] grades) {
        System.out.println("\n================ STUDENT SCORECARD ================");
        System.out.println("ID\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");

        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                (i + 1) + "\t" +
                scores[i][0] + "\t" +
                scores[i][1] + "\t" +
                scores[i][2] + "\t" +
                results[i][0] + "\t" +
                results[i][1] + "\t" +
                results[i][2] + "\t" +
                grades[i]
            );
        }
    }
}
