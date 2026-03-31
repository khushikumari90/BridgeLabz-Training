//Create a program to find the maximum number of handshakes among students.
package methods;
import java.util.Scanner;
public class Handshakes {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Calling method
        int totalHandshakes = calculateHandshakes(numberOfStudents);

        // Display result
        System.out.println("The maximum number of handshakes among "
                + numberOfStudents + " students is: " + totalHandshakes);

        scanner.close();

	}
	 // Method to calculate maximum handshakes using combination formula
    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }
}
