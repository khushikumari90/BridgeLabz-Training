//Write a Program to check if the given number is a prime number or not.
package controlflows;
import java.util.*;
public class primeNumber {

	public static void main(String[] args) {
		
		    // Create Scanner object to take input
		    Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a number: ");
	        int num = sc.nextInt();

	        boolean isPrime = true;

	        // Prime check only for numbers greater than 1
	        if (num <= 1) {
	            isPrime = false;
	        } else {
	            // Check divisibility from 2 to num-1
	            for (int i = 2; i < num; i++) {
	                if (num % i == 0) {
	                    isPrime = false;
	                    break;
	                }
	            }
	        }

	        // Output result
	        if (isPrime) {
	            System.out.println(num + " is a Prime Number");
	        } else {
	            System.out.println(num + " is Not a Prime Number");
	        }

	        sc.close();

	}

}
