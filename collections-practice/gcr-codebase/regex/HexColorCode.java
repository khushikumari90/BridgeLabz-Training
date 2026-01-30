package regex;
import java.util.regex.*;
import java.util.Scanner;
public class  HexColorCode {
    public static void main(String args[]) {
    	System.out.println("Enter Hex Color Code : ");
    	Scanner sc=new Scanner(System.in);
    	String input=sc.nextLine();
    	Pattern pattern=Pattern.compile("^#[0-9A-Fa-f]{6}$");
    	Matcher matcher=pattern.matcher(input);
    	if(matcher.matches()) {
    		System.out.println("valid");
    	}
    	else {
    		System.out.println("invalid");
    	}
    	sc.close();
    }
}
