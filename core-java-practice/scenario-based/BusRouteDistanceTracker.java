package scenariobased;
import java.util.Scanner;
public class BusRouteDistanceTracker {

	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);

	        int totalDistance = 0;   // Tracks total distance travelled
	        boolean wantsToGetOff = false;

	        // Loop runs until passenger decides to get off
	        while (!wantsToGetOff) {

	            System.out.print("Enter distance covered to next stop (in km): ");
	            int distance = sc.nextInt();

	            totalDistance += distance; // Add distance of current stop

	            System.out.println("Total distance covered: " + totalDistance + " km");

	            System.out.print("Do you want to get off at this stop? (yes/no): ");
	            String choice = sc.next();

	            // Exit condition
	            if (choice.equalsIgnoreCase("yes")) {
	                wantsToGetOff = true;
	            }
	        }

	        System.out.println("Passenger got off. Final distance travelled: " + totalDistance + " km");
	        sc.close();

	}

}
