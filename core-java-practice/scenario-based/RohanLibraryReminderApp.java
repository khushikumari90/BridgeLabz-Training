package scenariobased;
import java.util.Scanner;
public class RohanLibraryReminderApp {

	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);

	        int finePerDay = 5;

	        // Loop for 5 books
	        for (int i = 1; i <= 5; i++) {

	            System.out.println("\nBook " + i);

	            System.out.print("Enter due date (day number): ");
	            int dueDate = sc.nextInt();

	            System.out.print("Enter return date (day number): ");
	            int returnDate = sc.nextInt();

	            if (returnDate > dueDate) {
	                int lateDays = returnDate - dueDate;
	                int fine = lateDays * finePerDay;
	                System.out.println("Late by " + lateDays + " days. Fine: ₹" + fine);
	            } else {
	                System.out.println("Book returned on time. No fine.");
	            }
	        }

	        sc.close();
	}

}
