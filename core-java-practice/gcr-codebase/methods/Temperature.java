//Write a program calculate the wind chill temperature given the temperature and wind speed
package methods;
import java.util.Scanner;
public class Temperature {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for temperature and wind speed
        System.out.print("Enter temperature (in Fahrenheit): ");
        double temperature = sc.nextDouble();

        System.out.print("Enter wind speed (in mph): ");
        double windSpeed = sc.nextDouble();

        if (windSpeed < 0) {
            System.out.println("Error: Wind speed cannot be negative.");
        } else {
            // Call the method
            double windChill = calculateWindChill(temperature, windSpeed);

            // Display the result
            System.out.printf("The wind chill temperature is: %.2f°F\n", windChill);
        }

        sc.close();
	}
    // Method to calculate wind chill temperature
    public static double calculateWindChill(double temperature, double windSpeed) {
        // Wind chill formula
        double windChill = 35.74 + 0.6215 * temperature 
                         + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }
}
