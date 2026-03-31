//Problem 4: Date Comparison
package BuiltInFunction;
import java.time.LocalDate;
import java.util.Scanner;
public class DateComparison {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first date (yyyy-mm-dd): ");
        LocalDate date1 = LocalDate.parse(sc.next());

        System.out.print("Enter second date (yyyy-mm-dd): ");
        LocalDate date2 = LocalDate.parse(sc.next());

        if (date1.isBefore(date2)) {
            System.out.println("First date is BEFORE second date");
        } 
        else if (date1.isAfter(date2)) {
            System.out.println("First date is AFTER second date");
        } 
        else if (date1.isEqual(date2)) {
            System.out.println("Both dates are EQUAL");
        }
        sc.close();
	}

}
