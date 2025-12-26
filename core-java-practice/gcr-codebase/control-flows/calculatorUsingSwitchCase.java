//Write a program to create a calculator using switch...case.
package controlflows;
import java.util.*;
public class calculatorUsingSwitchCase {

	public static void main(String[] args) {

		    // Create Scanner object to take input
		    Scanner sc = new Scanner(System.in);

		    System.out.println("Enter first number : ");
	        // Input value
	        double first = sc.nextDouble();
	        System.out.println("Enter Second number : ");
	        // Input value
	        double second = sc.nextDouble();
	        System.out.println("Enter Operator from (+,-,*,/) : ");
	        // Input value
	        String op = sc.next();

	        // Switch case for calculator
	        switch (op) {
	            case "+":
	                System.out.println(first + second);
	                break;

	            case "-":
	                System.out.println(first - second);
	                break;

	            case "*":
	                System.out.println(first * second);
	                break;

	            case "/":
	                if (second != 0) {
	                    System.out.println(first / second);
	                } else {
	                    System.out.println("Division by zero not allowed");
	                }
	                break;

	            default:
	                System.out.println("Invalid Operator");
	        }
	        //Close the scanner
	        sc.close();

	}

}
