package extras;
import java.util.Scanner;
public class MostFrequentCharacter {

	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
	        System.out.print("Enter string: ");
	        String str = sc.nextLine();

	        int[] freq = new int[256];
	        for (char ch : str.toCharArray())
	            freq[ch]++;

	        char maxChar = str.charAt(0);
	        for (char ch : str.toCharArray()) {
	            if (freq[ch] > freq[maxChar])
	                maxChar = ch;
	        }

	        System.out.println("Most Frequent Character: " + maxChar);
	        sc.close();

	}

}
