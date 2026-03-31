//An organization took up an exercise to find the Body Mass Index (BMI) of all the persons in the team. For this create a program to find the BMI and display the height, weight, BMI and status of each individual
package arrays;
import java.util.Scanner;
public class Organization {

	public static void main(String[] args) {
		
        // Scanner class is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take input for number of persons
        System.out.print("Enter the number of persons: ");
        int n = sc.nextInt();

        double[] height = new double[n];
        double[] weight = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        // Input weight and height
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("Enter weight (kg): ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter height (m): ");
            height[i] = sc.nextDouble();
        }

        // Calculate BMI and status
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Display table header
        
        System.out.println("Person    Height(m)    Weight(kg)    BMI        Status");
        

        // Display table rows
        for (int i = 0; i < n; i++) {
            String row = (i + 1) + "         " +
                         String.format("%.2f", height[i]) + "        " +
                         String.format("%.2f", weight[i]) + "        " +
                         String.format("%.2f", bmi[i]) + "    " +
                         status[i];
            System.out.println(row);
        }

        //Close the scanner;
        sc.close();

	}

}
