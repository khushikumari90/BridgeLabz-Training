//Temperature Converter
package BuiltInFunction;
import java.util.Scanner;
public class TemperatureConverter {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter Celsius: ");
            double c = sc.nextDouble();
            System.out.println("Fahrenheit: " + celsiusToFahrenheit(c));
        } else {
            System.out.print("Enter Fahrenheit: ");
            double f = sc.nextDouble();
            System.out.println("Celsius: " + fahrenheitToCelsius(f));
        }
        sc.close();

	}
    static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
}
