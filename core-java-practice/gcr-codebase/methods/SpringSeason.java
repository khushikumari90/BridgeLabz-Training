//Write a program SpringSeason that takes two int values month and day from the command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”. 
package methods;
public class SpringSeason {

	public static void main(String[] args) {
		if (args.length < 2) {
            System.out.println("Please provide month and day as command line arguments.");
            return;
        }

        // Parse month and day from command line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check if the date is in Spring season
        boolean spring = isSpringSeason(month, day);

        // Print result
        if (spring) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }

	}
	// Method to check whether the given date is in Spring season
    public static boolean isSpringSeason(int month, int day) {
        // Spring Season: March 20 (3/20) to June 20 (6/20)
        if (month < 3 || month > 6) {
            return false; // Not in March to June
        } else if (month == 3) {
            return day >= 20; // March 20 or later
        } else if (month == 6) {
            return day <= 20; // June 20 or earlier
        } else {
            return true; // April and May are fully in Spring
        }
    }
}
