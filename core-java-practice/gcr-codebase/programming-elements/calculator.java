//Write a program to create a basic calculator for addition, subtraction, multiplication, and division. The program should ask for two numbers (floating point) and perform all the operations
package programmingelements;
import java.util.*;
public class calculator {

	public static void main(String[] args) {
        // Create Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Declare variables for two numbers
        float number1, number2;

        // Take input from user
        System.out.print("Enter first number: ");
        number1 = sc.nextFloat();

        System.out.print("Enter second number: ");
        number2 = sc.nextFloat();

        // Perform arithmetic operations
        float addition = number1 + number2;
        float subtraction = number1 - number2;
        float multiplication = number1 * number2;
        float division = number1 / number2;

        // Print the results
        System.out.println(
            "The addition, subtraction, multiplication, and division value of 2 numbers "
            + number1 + " and " + number2 + " is "
            + addition + ", " + subtraction + ", " + multiplication + ", and " + division
        );

        // Close the scanner
        sc.close();

	}

}
