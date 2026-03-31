//Design a polling booth system.
package scenariobased;
import java.util.Scanner;
public class ElectionBoothManager {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        int vote1 = 0, vote2 = 0, vote3 = 0;

        while (true) {
            System.out.print("\nEnter age (-1 to exit): ");
            int age = sc.nextInt();

            // Exit condition
            if (age == -1) {
                break;
            }

            // Check eligibility
            if (age >= 18) {
                System.out.println("Eligible to vote");
                System.out.println("1. Candidate A");
                System.out.println("2. Candidate B");
                System.out.println("3. Candidate C");
                System.out.print("Enter your vote: ");

                int vote = sc.nextInt();

                if (vote == 1) {
                    vote1++;
                } else if (vote == 2) {
                    vote2++;
                } else if (vote == 3) {
                    vote3++;
                } else {
                    System.out.println("Invalid vote!");
                }
            } else {
                System.out.println("Not eligible to vote");
            }
        }

        // Display result
        System.out.println("\n  Election Results:");
        System.out.println("Candidate A: " + vote1 + " votes");
        System.out.println("Candidate B: " + vote2 + " votes");
        System.out.println("Candidate C: " + vote3 + " votes");

        sc.close();


	}

}
