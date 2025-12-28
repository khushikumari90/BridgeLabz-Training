//Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.
package strings;
public class AgeOfStudent {

	public static void main(String[] args) {

	        // Number of students (fixed as 10)
	        int n = 10;

	        // Generate random ages
	        int[] ages = generateStudentAges(n);

	        // Check voting eligibility
	        String[][] result = checkVotingEligibility(ages);

	        // Display result
	        displayResult(result);

	}

    // Method to generate random 2-digit ages for n students
    public static int[] generateStudentAges(int n) {

        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            // Generate random 2-digit age (10 to 99)
            ages[i] = (int) (Math.random() * 90) + 10;
        }

        return ages;
    }

    // Method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {

        int n = ages.length;
        String[][] result = new String[n][2];

        for (int i = 0; i < n; i++) {

            result[i][0] = String.valueOf(ages[i]);

            // Validate age
            if (ages[i] < 0) {
                result[i][1] = "false";
            } 
            // Check voting condition
            else if (ages[i] >= 18) {
                result[i][1] = "true";
            } 
            else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayResult(String[][] data) {

        System.out.println("\nAge\tCan Vote");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

}
