//Write a program to demonstrate StringIndexOutOfBoundsException
package strings;
import java.util.Scanner;
public class MyOutOfBoundException {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input for string
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Calling method that generates the exception
        System.out.println("\nGenerating StringIndexOutOfBoundsException:");
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception occurred in generateException()");
        }

        // Calling method that handles the exception
        System.out.println("\nHandling StringIndexOutOfBoundsException:");
        handleException(text);

        sc.close();

	}
	
	 // Method to GENERATE StringIndexOutOfBoundsException
    public static void generateException(String text) {

        // Accessing index beyond the string length
        // This will generate StringIndexOutOfBoundsException
        System.out.println(text.charAt(text.length()));
    }

    // Method to HANDLE StringIndexOutOfBoundsException
    public static void handleException(String text) {

        try {
            // Accessing index beyond the string length
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            // Handling the runtime exception
            System.out.println("StringIndexOutOfBoundsException caught and handled.");
            System.out.println("Error Message: " + e);
        }
    }

}
