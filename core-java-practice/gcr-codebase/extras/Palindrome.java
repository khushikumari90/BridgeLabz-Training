//Write a Java program to check if a given string is a palindrome (a string that reads the same forward and backward).
package extras;
import java.util.Scanner;
public class Palindrome {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Enter string: ");
	        String str = sc.nextLine();

	        String rev = "";
	        for (int i = str.length() - 1; i >= 0; i--) {
	            rev += str.charAt(i);
	        }

	        if (str.equals(rev))
	            System.out.println("Palindrome String");
	        else
	            System.out.println("Not a Palindrome");

	        sc.close();
	    }

}
