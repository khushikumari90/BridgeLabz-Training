package scenariobased;
import java.util.Scanner;

public class MovieTicketBookingApp {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of customers: ");
	        int customerCount = sc.nextInt();

	        for (int i = 1; i <= customerCount; i++) {

	            System.out.println("\nCustomer " + i);

	            System.out.print("Enter movie type (2D/3D): ");
	            String movieType = sc.next();

	            System.out.print("Enter seat type (gold/silver): ");
	            String seatType = sc.next();

	            System.out.print("Do you want snacks? (yes/no): ");
	            String snacks = sc.next();

	            int ticketPrice = 0;

	            // switch for seat type
	            switch (seatType.toLowerCase()) {
	                case "gold":
	                    ticketPrice = 300;
	                    break;
	                case "silver":
	                    ticketPrice = 200;
	                    break;
	                default:
	                    System.out.println("Invalid seat type!");
	                    continue;
	            }

	            // if for movie type
	            if (movieType.equalsIgnoreCase("3D")) {
	                ticketPrice += 100;
	            }

	            // if for snacks
	            if (snacks.equalsIgnoreCase("yes")) {
	                ticketPrice += 50;
	            }

	            System.out.println("Total ticket price: ₹" + ticketPrice);
	        }

	        sc.close();

	}

}
