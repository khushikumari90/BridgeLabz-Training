//Create a program to take input marks of students in 3 subjects: physics, chemistry, and maths. Compute the total, average, and the percentage score 
package methods;
import java.util.Scanner;
public class Grade {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] marks = generateMarks(students);
        double[][] result = calculateResults(marks);

        displayScoreCard(marks, result);

        sc.close();
	}
	// Method to generate random 2-digit PCM marks for students
    // Returns 2D array: [student][0]=Physics, [1]=Chemistry, [2]=Maths
    public static int[][] generateMarks(int students) {
        int[][] marks = new int[students][3];

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = (int) (Math.random() * 90) + 10; // 10 to 99
            }
        }
        return marks;
    }

    // Method to calculate total, average, percentage
    // Returns 2D array: [student][0]=Total, [1]=Average, [2]=Percentage
    public static double[][] calculateResults(int[][] marks) {
        double[][] result = new double[marks.length][3];

        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    // Method to display scorecard
    public static void displayScoreCard(int[][] marks, double[][] result) {

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Stu\tPhysics\tChem\tMath\tTotal\tAverage\tPercentage");
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            System.out.println((i + 1) + "\t" +
                    marks[i][0] + "\t" +
                    marks[i][1] + "\t" +
                    marks[i][2] + "\t" +
                    result[i][0] + "\t" +
                    result[i][1] + "\t" +
                    result[i][2]);
        }

        System.out.println("---------------------------------------------------------------------");
    }


}
