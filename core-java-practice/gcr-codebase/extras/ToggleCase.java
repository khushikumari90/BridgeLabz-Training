//Write a Java program to toggle the case of each character in a given string. Convert uppercase letters to lowercase and vice versa.
package extras;
import java.util.Scanner;
public class ToggleCase {

	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
	        System.out.print("Enter string: ");
	        String str = sc.nextLine();

	        String result = "";
	        for (char ch : str.toCharArray()) {
	            if (Character.isUpperCase(ch))
	                result += Character.toLowerCase(ch);
	            else if (Character.isLowerCase(ch))
	                result += Character.toUpperCase(ch);
	            else
	                result += ch;
	        }

	        System.out.println("Toggled String: " + result);
	        sc.close();  

	}

}
