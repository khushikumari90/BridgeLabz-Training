//An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in a team of 10 members. For this create a program to find the BMI and display the height, weight, BMI, and status of each individual
package strings;
import java.util.Scanner;
public class BMIOfPersons {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 2D array to store weight and height
        // Column 0 → Weight, Column 1 → Height
        double[][] data = new double[10][2];

        // Taking input for 10 persons
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Enter Weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        // Process BMI
        String[][] result = processBMI(data);

        // Display final output
        displayResult(result);

        sc.close();


	}

	// Method to calculate BMI and Status for each person
    // Takes height (cm) and weight (kg) and returns BMI + Status
    public static String[] calculateBMI(double weight, double heightCm) {

        // Convert height from cm to meters
        double heightMeter = heightCm / 100;

        // BMI Formula
        double bmi = weight / (heightMeter * heightMeter);

        // Decide BMI Status
        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        // Return BMI and Status as String array
        return new String[] {
                String.format("%.2f", bmi),
                status
        };
    }

    // Method that takes 2D array of weight & height
    // and returns 2D String array of height, weight, BMI, status
    public static String[][] processBMI(double[][] data) {

        String[][] result = new String[10][4];

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double height = data[i][1];

            // Call BMI calculation method
            String[] bmiResult = calculateBMI(weight, height);

            // Store values in String 2D array
            result[i][0] = String.valueOf(height);     // Height
            result[i][1] = String.valueOf(weight);     // Weight
            result[i][2] = bmiResult[0];               // BMI
            result[i][3] = bmiResult[1];               // Status
        }

        return result;
    }

 // Method to display result in tabular format
    public static void displayResult(String[][] result) {

        System.out.println("\n-----------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-15s%n",
                "Height", "Weight", "BMI", "Status");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-10s %-10s %-10s %-15s%n",
                    result[i][0],
                    result[i][1],
                    result[i][2],
                    result[i][3]);
        }
        System.out.println("-----------------------------------------------");
    }



}
