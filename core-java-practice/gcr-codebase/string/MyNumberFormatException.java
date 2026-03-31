//Write a program to demonstrate NumberFormatException
package strings;
import java.util.Scanner;
public class MyNumberFormatException {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

        // Take user input as String
        System.out.print("Enter a value: ");
        String text = sc.next();

        // Calling method that generates the exception
        System.out.println("\nGenerating NumberFormatException:");
        try {
            generateException(text);
        } catch (RuntimeException e) {
            System.out.println("Exception occurred in generateException()");
        }

        // Calling method that handles the exception
        System.out.println("\nHandling NumberFormatException:");
        handleException(text);

        sc.close();

	}
	
	 // Method to GENERATE NumberFormatException
    public static void generateException(String text) {

        // Trying to convert non-numeric text to integer
        // This will generate NumberFormatException
        int number = Integer.parseInt(text);

        System.out.println("Converted number: " + number);
    }

    // Method to HANDLE NumberFormatException
    public static void handleException(String text) {

        try {
            // This may generate NumberFormatException
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);

        } catch (NumberFormatException e) {
            // Handling NumberFormatException
            System.out.println("NumberFormatException caught and handled.");
            System.out.println("Error Message: " + e);

        } catch (RuntimeException e) {
            // Handling generic runtime exception
            System.out.println("Generic RuntimeException caught.");
            System.out.println("Error Message: " + e);
        }
    }

}
