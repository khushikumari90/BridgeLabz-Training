//Sam’s mark in Maths is 94, Physics is 95 and Chemistry is 96 out of 100. Find the average percent mark in PCM.
package programmingelements;

public class samMarks {

	public static void main(String[] args) {
		// Declare and initialize marks
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        // Calculate total marks
        int total = maths + physics + chemistry;

        // Calculate average percentage
        double average = total / 3.0;

        // Display the result
        System.out.println("Sam’s average mark in PCM is " + average);
	}

}
