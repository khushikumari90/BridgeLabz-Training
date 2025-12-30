//Write a Java program to remove all duplicate characters from a given string and return the modified string.
package extras;
import java.util.Scanner;
public class RemoveDuplicates {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Enter string: ");
	        String str = sc.nextLine();

	        String result = "";
	        for (int i = 0; i < str.length(); i++) {
	            if (result.indexOf(str.charAt(i)) == -1) {
	                result += str.charAt(i);
	            }
	        }

	        System.out.println("After removing duplicates: " + result);
	        sc.close();

	}

}
