//An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in the team of 10 members. For this create a program to find the BMI and display the height, weight, BMI and status of each individual
package methods;
import java.util.Scanner;
public class BodyMassIndex {
    /**
     * Method to calculate BMI for each person
     * Formula: BMI = weight / (height * height)
     * Height is converted from cm to meters
     */
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];        // weight in kg
            double heightCm = data[i][1];      // height in cm
            double heightM = heightCm / 100;   // convert to meters

            double bmi = weight / (heightM * heightM);
            data[i][2] = bmi;                  // store BMI
        }
    }

    /**
     * Method to determine BMI status for each person
     * Returns an array of BMI status strings
     */
    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 2D array: rows = 10 persons, columns = weight, height, BMI
        double[][] data = new double[10][3];

        // Taking user input
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        // Calculate BMI
        calculateBMI(data);

        // Get BMI status
        String[] status = getBMIStatus(data);

        // Display results
        System.out.println("\nPerson\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s%n",
                    (i + 1), data[i][0], data[i][1], data[i][2], status[i]);
        }

        sc.close();
	}

}
