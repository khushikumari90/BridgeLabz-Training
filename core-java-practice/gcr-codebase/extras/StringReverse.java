//Write a Java program to reverse a given string without using any built-in reverse functions.
package extras;
import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
	        System.out.print("Enter string: ");
	        String str = sc.nextLine();

	        String rev = "";
	        for (int i = str.length() - 1; i >= 0; i--) {
	            rev += str.charAt(i);
	        }

	        System.out.println("Reversed String: " + rev);
	        sc.close();
	}
}
