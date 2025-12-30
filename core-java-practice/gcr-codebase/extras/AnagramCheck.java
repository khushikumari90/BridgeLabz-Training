package extras;
import java.util.Scanner;
public class AnagramCheck {

	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);

	        System.out.print("Enter first string: ");
	        String s1 = sc.nextLine();

	        System.out.print("Enter second string: ");
	        String s2 = sc.nextLine();

	        if (s1.length() != s2.length()) {
	            System.out.println("Not Anagrams");
	        }

	        int[] freq = new int[256];
	        for (char c : s1.toCharArray()) freq[c]++;
	        for (char c : s2.toCharArray()) freq[c]--;

	        boolean isAnagram = true;
	        for (int i : freq) {
	            if (i != 0) {
	                isAnagram = false;
	                break;
	            }
	        }

	        System.out.println(isAnagram ? "Anagrams" : "Not Anagrams");
	        sc.close();

	}

}
