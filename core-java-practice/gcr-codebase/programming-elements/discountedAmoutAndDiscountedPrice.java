//The University is charging the student a fee of INR 125000 for the course. The University is willing to offer a discount of 10%. Write a program to find the discounted amount and discounted price the student will pay for the course.
package programmingelements;

public class discountedAmoutAndDiscountedPrice {

	public static void main(String[] args) {
		// Original course fee
        int fee = 125000;

        // Discount percentage
        int discountPercent = 10;

        // Calculate discount amount
        int discount = (fee * discountPercent) / 100;

        // Calculate final fee after discount
        int finalFee = fee - discount;

        // Print the result
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);

	}

}
