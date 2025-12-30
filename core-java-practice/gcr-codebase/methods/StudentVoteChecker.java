//Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.
package methods;
import java.util.Scanner;
public class StudentVoteChecker {
	 /**
     * Checks if a student can vote
     * @param age student's age
     * @return true if eligible, false otherwise
     */
    public boolean canStudentVote(int age) {

        // Validate negative age
        if (age < 0) {
            return false;
        }

        // Check voting eligibility
        if (age >= 18) {
            return true;
        } else {
        	return false;
        }
    }

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        StudentVoteChecker checker = new StudentVoteChecker();

	        // Array to store ages of 10 students
	        int[] ages = new int[10];

	        // Loop to take input and check voting eligibility
	        for (int i = 0; i < ages.length; i++) {

	            System.out.print("Enter age of student " + (i + 1) + ": ");
	            ages[i] = sc.nextInt();

	            boolean canVote = checker.canStudentVote(ages[i]);

	            if (canVote) {
	                System.out.println("Student " + (i + 1) + " is eligible to vote.");
	            } else {
	                System.out.println("Student " + (i + 1) + " is NOT eligible to vote.");
	            }

	            System.out.println(); // blank line for readability
	        }

	        sc.close();

	}

}

