//Write a Java program to count the number of vowels and consonants in a given string.
package extras;
import java.util.Scanner;
public class VowelsAndConsonants {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String str = sc.nextLine().toLowerCase();

	        int vowels = 0, consonants = 0;

	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            if (ch >= 'a' && ch <= 'z') {
	                if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
	                    vowels++;
	                else
	                    consonants++;
	            }
	        }

	        System.out.println("Vowels: " + vowels);
	        System.out.println("Consonants: " + consonants);
	        sc.close();

	}

}
