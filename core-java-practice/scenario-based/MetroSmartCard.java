//Metro Smart Card Fare Deduction
package scenariobased;
import java.util.Scanner;
public class MetroSmartCard {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);

	        double balance = 100;   // Initial smart card balance
	        int distance;
	        double fare;

	        while (balance > 0) {

	            System.out.println("\nCurrent Balance: ₹" + balance);
	            System.out.print("Enter distance travelled (-1 to exit): ");
	            distance = sc.nextInt();

	            // Exit condition
	            if (distance == -1) {
	                break;
	            }

	            // Calculate fare using ternary operator
	            fare = (distance <= 5) ? 10 :
	                   (distance <= 15) ? 20 : 30;

	            // Check balance and deduct fare
	            if (balance >= fare) {
	                balance -= fare;
	                System.out.println("Fare: ₹" + fare);
	                System.out.println("Remaining Balance: ₹" + balance);
	            } else {
	                System.out.println("Insufficient balance! Please recharge.");
	                break;
	            }
	        }

	        System.out.println("\nThank you for using Delhi Metro ");
	        sc.close();

	}

}
