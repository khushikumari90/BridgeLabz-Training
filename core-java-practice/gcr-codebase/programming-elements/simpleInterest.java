//Write a program to calculate simple interest
package programmingelements;
import java.util.*;
public class simpleInterest {

	public static void main(String[] args) {
		
		 // Create Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter the Principal amount
        System.out.print("Enter Principal amount: ");
        double principal = sc.nextDouble();

        // Ask the user to enter the Rate of Interest
        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();

        // Ask the user to enter the Time (in years)
        System.out.print("Enter Time (in years): ");
        double time = sc.nextDouble();

        // Calculate Simple Interest using the formula
        // Simple Interest = (Principal * Rate * Time) / 100
        double simpleInterest = (principal * rate * time) / 100;

        // Display the calculated Simple Interest
        System.out.println("Simple Interest is: " + simpleInterest);

        // Close the Scanner
        sc.close();

	}

}
