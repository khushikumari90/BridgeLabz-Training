//Write a program to demonstrate ArrayIndexOutOfBoundsException
package strings;
import java.util.Scanner;
public class MyArrayIndexOutOfBoundsException {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

        // Take user input for array size
        System.out.print("Enter number of names: ");
        int size = sc.nextInt();

        // Create array of names
        String[] names = new String[size];

        // Take user input for names
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        // Calling method that generates the exception
        System.out.println("\nGenerating ArrayIndexOutOfBoundsException:");
        try {
            generateException(names);
        } catch (RuntimeException e) {
            System.out.println("Exception occurred in generateException()");
        }

        // Calling method that handles the exception
        System.out.println("\nHandling ArrayIndexOutOfBoundsException:");
        handleException(names);

        sc.close();

	}
	

    // Method to GENERATE ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {

        // Accessing index greater than array length
        // This will generate ArrayIndexOutOfBoundsException
        System.out.println(names[names.length]);
    }

    // Method to HANDLE ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {

        try {
            // Accessing index greater than array length
            System.out.println(names[names.length]);

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handling ArrayIndexOutOfBoundsException
            System.out.println("ArrayIndexOutOfBoundsException caught and handled.");
            System.out.println("Error Message: " + e);

        } catch (RuntimeException e) {
            // Handling generic runtime exception
            System.out.println("Generic RuntimeException caught.");
            System.out.println("Error Message: " + e);
        }
    }

}
