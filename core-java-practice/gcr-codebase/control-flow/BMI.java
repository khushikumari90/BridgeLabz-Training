//Create a program to find the BMI of a person
package controlflows;
import java.util.*;;
public class BMI {

	public static void main(String[] args) {
		
		 // Create Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Take weight input in kilograms
        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();

        // Take height input in centimeters
        System.out.print("Enter height in cm: ");
        double heightCm = sc.nextDouble();

        // Convert height from centimeters to meters
        double heightMeter = heightCm / 100;

        // Calculate BMI using formula BMI = weight / (height * height)
        double bmi = weight / (heightMeter * heightMeter);

        // Display BMI value
        System.out.println("Your BMI is: " + bmi);

        // Determine weight status using BMI table
        if (bmi <= 18.4) {
            System.out.println("Status: Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Status: Normal");
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            System.out.println("Status: Overweight");
        } else {
            System.out.println("Status: Obese");
        }

        // Close the scanner
        sc.close();

	}

}
