package review;
import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.nextLine(); 
        String[] words = str.split(" "); 

        reverseString(words);
        sc.close();
    }

    public static void reverseString(String[] words) {
        for (String word : words) {   
            String mystring = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                mystring += word.charAt(i);  
            }
            System.out.print(mystring + " "); 
        }
    }
}