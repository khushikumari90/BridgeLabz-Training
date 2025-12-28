//Write a program to demonstrate IllegalArgumentException
package strings;
import java.util.Scanner;
public class MyIllegalArgumentException {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input for string
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Calling method that generates the exception
        System.out.println("\nGenerating IllegalArgumentException:");
        try {
            generateException(text);
        } catch (RuntimeException e) {
            System.out.println("Exception occurred in generateException()");
        }

        // Calling method that handles the exception
        System.out.println("\nHandling IllegalArgumentException:");
        handleException(text);

        sc.close();

	}

    // Method to GENERATE IllegalArgumentException
    public static void generateException(String text) {

        // Setting start index greater than end index
        // This will generate a runtime exception
        System.out.println(text.substring(5, 2));
    }

    // Method to HANDLE IllegalArgumentException
    public static void handleException(String text) {

        try {
            // Setting start index greater than end index
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            // Handling IllegalArgumentException
            System.out.println("IllegalArgumentException caught and handled.");
            System.out.println("Error Message: " + e);
        } catch (RuntimeException e) {
            // Handling generic runtime exception
            System.out.println("Generic RuntimeException caught.");
            System.out.println("Error Message: " + e);
        }
    }

}
