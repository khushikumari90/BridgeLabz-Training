//Rewrite the above program using multi-dimensional array to store height, weight, and BMI in 2D array for all the persons
package arrays;
import java.util.Scanner;
public class BMImultidimensionalarray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        // Input number of persons
        System.out.print("Enter the number of persons: ");
        int number = sc.nextInt();

        // 2D array: [weight, height, BMI]
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Input weight and height
        for (int i = 0; i < number; i++) {
            do {
                System.out.print("Person " + (i + 1) + " weight (kg): ");
                personData[i][0] = sc.nextDouble();
            } while (personData[i][0] <= 0);

            do {
                System.out.print("Person " + (i + 1) + " height (m): ");
                personData[i][1] = sc.nextDouble();
            } while (personData[i][1] <= 0);
        }

        // Calculate BMI and status
        for (int i = 0; i < number; i++) {
            double weight = personData[i][0];
            double height = personData[i][1];
            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            if (bmi <= 18.4) weightStatus[i] = "Underweight";
            else if (bmi <= 24.9) weightStatus[i] = "Normal";
            else if (bmi <= 39.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        // Display results
        System.out.println("\nPerson\tWeight(kg)\tHeight(m)\tBMI\t\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.println((i + 1) + "\t" +
                    personData[i][0] + "\t\t" +
                    personData[i][1] + "\t\t" +
                    personData[i][2] + "\t" +
                    weightStatus[i]);
        }

        sc.close();

	}

}
