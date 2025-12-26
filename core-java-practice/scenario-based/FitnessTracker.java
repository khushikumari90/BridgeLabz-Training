//Maya, a fitness coach, wants to record the BMI of her clients.
package scenariobased;
import java.util.Scanner;
public class FitnessTracker {

	public static void main(String[] args) {
		
        // Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user for height in meters
        System.out.print("Enter height in meters: ");
        double heightInMeters = scanner.nextDouble();

        // Ask the user for weight in kilograms
        System.out.print("Enter weight in kilograms: ");
        double weightInKg = scanner.nextDouble();

        // Calculate BMI using the formula
        // BMI = weight / (height * height)
        double bmi = weightInKg / (heightInMeters * heightInMeters);

        // Display the BMI value
        System.out.println("Your BMI is: " + bmi);

        // Determine BMI category using if-else
        if (bmi < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("Category: Normal");
        }else if(bmi >= 25 && bmi < 40){
        	System.out.println("Category: Overweight");
        } else {
            System.out.println("Category: Obese");
        }

        // Close the scanner
        scanner.close();


	}

}
