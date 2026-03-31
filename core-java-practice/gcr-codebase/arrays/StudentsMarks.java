//Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. 
package arrays;
import java.util.Scanner;
public class StudentsMarks {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of students: ");
	        int n = sc.nextInt();

	        int[][] marks = new int[n][3]; // Physics, Chemistry, Maths
	        double[] percentage = new double[n];
	        char[] grade = new char[n];

	        // Input marks
	        for (int i = 0; i < n; i++) {
	            System.out.println("\nStudent " + (i + 1) + ":");

	            do {
	                System.out.print("Enter Physics marks: ");
	                marks[i][0] = sc.nextInt();
	            } while (marks[i][0] < 0);

	            do {
	                System.out.print("Enter Chemistry marks: ");
	                marks[i][1] = sc.nextInt();
	            } while (marks[i][1] < 0);

	            do {
	                System.out.print("Enter Maths marks: ");
	                marks[i][2] = sc.nextInt();
	            } while (marks[i][2] < 0);
	        }

	        // Calculate percentage and grade
	        for (int i = 0; i < n; i++) {
	            int total = marks[i][0] + marks[i][1] + marks[i][2];
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
