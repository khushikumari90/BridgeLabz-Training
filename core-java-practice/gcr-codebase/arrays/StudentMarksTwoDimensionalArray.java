//Rewrite the above program to store the marks of the students in physics, chemistry, and maths in a 2D array and then compute the percentage and grade
package arrays;
import java.util.Scanner;
public class StudentMarksTwoDimensionalArray {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of students: ");
	        int n = sc.nextInt();

	        int[][] marks = new int[n][3]; // 0: Physics, 1: Chemistry, 2: Maths
	        double[] percentage = new double[n];
	        char[] grade = new char[n];

	        // Input marks for each student
	        for (int i = 0; i < n; i++) {
	            System.out.println("\nStudent " + (i + 1) + ":");
	            
	            for (int j = 0; j < 3; j++) {
	                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
	                do {
	                    System.out.print("Enter marks for " + subject + ": ");
	                    marks[i][j] = sc.nextInt();
	                    if (marks[i][j] < 0) {
	                        System.out.println("Invalid marks! Enter again.");
	                    }
	                } while (marks[i][j] < 0);
	            }
	        }

	        // Calculate percentage and grade
	        for (int i = 0; i < n; i++) {
	            int total = 0;
	            for (int j = 0; j < 3; j++) {
	                total += marks[i][j];
	            }
	            percentage[i] = total / 3.0;

	            if (percentage[i] >= 80) grade[i] = 'A';
	            else if (percentage[i] >= 70) grade[i] = 'B';
	            else if (percentage[i] >= 60) grade[i] = 'C';
	            else if (percentage[i] >= 50) grade[i] = 'D';
	            else if (percentage[i] >= 40) grade[i] = 'E';
	            else grade[i] = 'R';
	        }

	        // Display results
	        System.out.println("\nResults:");
	        for (int i = 0; i < n; i++) {
	            System.out.println("Student " + (i + 1));
	            System.out.println("Physics: " + marks[i][0]);
	            System.out.println("Chemistry: " + marks[i][1]);
	            System.out.println("Maths: " + marks[i][2]);
	            System.out.println("Percentage: " + percentage[i]);
	            System.out.println("Grade: " + grade[i]);
	            
	        }

	        sc.close();

	}

}
