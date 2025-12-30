//Number Guessing Game
package BuiltInFunction;
import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {

	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);

	        int low = 1, high = 100;
	        String feedback;

	        System.out.println("Think of a number between 1 and 100.");

	        while (true) {
	            int guess = generateGuess(low, high);
	            System.out.println("Computer guesses: " + guess);

	            feedback = getUserFeedback(sc);

	            if (feedback.equals("low")) {
	                low = guess + 1;
	            } else if (feedback.equals("high")) {
	                high = guess - 1;
	            } else if (feedback.equals("correct")) {
	                System.out.println("Computer guessed correctly!");
	                break;
	            }
	        }

	}

    static int generateGuess(int low, int high) {
        return new Random().nextInt(high - low + 1) + low;
    }

    static String getUserFeedback(Scanner sc) {
        System.out.print("Is the guess high, low, or correct? ");
        return sc.next().toLowerCase();
    }

}
