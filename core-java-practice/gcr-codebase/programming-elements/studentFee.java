//Write a new program similar to the program # 6 but take user input for Student Fee and University Discount
package programmingelements;
import java.util.*;
public class studentFee {

	public static void main(String[] args) {
        // Create Scanner object to take input from keyboard
        Scanner input = new Scanner(System.in);

        // Take course fee input from user
        System.out.print("Enter the course fee: ");
        double fee = input.nextDouble();

        // Take discount percentage input from user
        System.out.print("Enter the discount percentage: ");
        double discountPercent = input.nextDouble();

        // Calculate discount amount
        double discount = (fee * discountPercent) / 100;

        // Calculate final fee after discount
        double finalFee = fee - discount;

        // Print the result
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);

        // Close scanner
        input.close();

	}

}
