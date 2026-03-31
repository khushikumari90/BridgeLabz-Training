package regex;
import java.util.regex.*;
import java.util.Scanner;
public class LicensePlateNumber {
    public static void main(String args[]) {
    	System.out.println("Enter License Plate Number : ");
    	Scanner sc=new Scanner(System.in);
    	String input=sc.nextLine();
    	Pattern pattern=Pattern.compile("^[A-Z]{2}[0-9]{4}$");
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
