//Write a program to input the unit price of an item and the quantity to be bought. Then, calculate the total price.
package programmingelements;
import java.util.*;
public class unitPriceOfAnItem {

	public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Take unit price input
        System.out.print("Enter unit price (INR): ");
        double unitPrice = sc.nextDouble();

        // Take quantity input
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        // Calculate total price
        double totalPrice = unitPrice * quantity;

        // Display the result
        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);

        // Close the scanner
        sc.close();

	}

}
