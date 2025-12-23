//Write an IntOperation program by taking a, b, and c as input values and print the following integer operations a + b *c, a * b + c, c + a / b, and a % b + c. Please also understand the precedence of the operators. 
package programmingelements;
import java.util.*;
public class intOperation {

	public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Take input values
        System.out.print("Enter value of a: ");
        int a = sc.nextInt();

        System.out.print("Enter value of b: ");
        int b = sc.nextInt();

        System.out.print("Enter value of c: ");
        int c = sc.nextInt();

        // Perform integer operations
        int result1 = a + b * c;   // Multiplication has higher precedence
        int result2 = a * b + c;   // Multiplication first, then addition
        int result3 = c + a / b;   // Division first, then addition
        int result4 = a % b + c;   // Modulus first, then addition

        // Print results
        System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", " + result3 + ", "  + result4);

        // Close scanner
        sc.close();

	}

}
