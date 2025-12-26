//Ravi runs a café. Each customer orders different coffee types with quantities. 
package scenariobased;
import java.util.Scanner;
public class TheCoffeeCounterChronicles {

	public static void main(String[] args) {
		
		//Scanner object to take input from the user
		Scanner scanner = new Scanner(System.in);

        // GST percentage
        final double GST_RATE = 0.05; // 5% GST

        // Loop to serve multiple customers
        while (true) {

            // Ask for coffee type
            System.out.print("\nEnter coffee type (espresso/latte/cappuccino) or type 'exit' to stop: ");
            String coffeeType = scanner.next().toLowerCase();

            // Exit condition
            if (coffeeType.equals("exit")) {
                System.out.println("Coffee counter closed ☕");
                break;
            }

            // Ask for quantity
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            double pricePerCup = 0;

            // Determine price using switch
            switch (coffeeType) {
                case "espresso":
                    pricePerCup = 120;
                    break;
                case "latte":
                    pricePerCup = 150;
                    break;
                case "cappuccino":
                    pricePerCup = 180;
                    break;
                default:
                    System.out.println("Invalid coffee type!");
                    continue; // skip billing for invalid input
            }

            // Calculate total bill
            double totalBill = pricePerCup * quantity;

            // Calculate GST
            double gstAmount = totalBill * GST_RATE;

            // Final amount
            double finalAmount = totalBill + gstAmount;

            // Display bill details
            System.out.println("\n----- BILL DETAILS -----");
            System.out.println("Coffee Type   : " + coffeeType);
            System.out.println("Price per cup : " + pricePerCup+" Rs");
            System.out.println("Quantity      : " + quantity);
            System.out.println("Total Bill    : " + totalBill+" Rs");
            System.out.println("GST (5%)      : " + gstAmount+" Rs");
            System.out.println("Final Amount  : " + finalAmount+" Rs");
            System.out.println("------------------------");
        }

        //Close the scanner;
        scanner.close();

	}

}
