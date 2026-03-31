package scenariobased;
import java.util.Scanner;
public class FestivalLuckyDraw {

	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of visitors: ");
	        int visitors = sc.nextInt();

	        // Loop for each visitor
	        for (int i = 1; i <= visitors; i++) {

	            System.out.print("Visitor " + i + " - Enter your lucky number: ");
	            int number = sc.nextInt();

	            // Invalid input check
	            if (number <= 0) {
	                System.out.println("Invalid number! Try next visitor.");
	                continue; // Skip to next iteration
	            }

	            // Check divisibility by 3 and 5
	            if (number % 3 == 0 && number % 5 == 0) {
	                System.out.println("🎉 Congratulations! You won a gift!");
	            } else {
	                System.out.println("Sorry, better luck next time.");
	            }
	        }

	        sc.close();
	}

}
