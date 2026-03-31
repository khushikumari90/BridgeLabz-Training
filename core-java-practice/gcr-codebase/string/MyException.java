//Write a program to demonstrate NullPointerException. 
package strings;

public class MyException {

	public static void main(String[] args) {
		
        // Step 1: Generate the exception
        System.out.println("Generating NullPointerException:");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception occurred in generateException()");
        }

        // Step 2: Handle the exception properly
        System.out.println("\nHandling NullPointerException:");
        handleException();
		 
	}
	   // Method to GENERATE NullPointerException
    public static void generateException() {

        // text is initialized to null
        String text = null;

        // Calling String method on null reference
        // This will generate NullPointerException
        System.out.println(text.length());
    }

    // Method to HANDLE NullPointerException
    public static void handleException() {

        // text is initialized to null
        String text = null;

        try {
            // Trying to access String method
            System.out.println(text.length());
        } catch (NullPointerException e) {
            // Handling the exception
            System.out.println("NullPointerException caught!");
            System.out.println("Reason: Attempted to access method on null object.");
        }
    }


}

