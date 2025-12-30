//Extend or Create a UnitConvertor utility class similar to the one shown in the notes to do the following.  Please define static methods for all the UnitConvertor class methods.
package methods;

public class UnitConvertor3 {

	public static void main(String[] args) {
		System.out.println("98.6°F = " + UnitConvertor3.convertFarhenheitToCelsius(98.6) + " °C");
        System.out.println("37°C = " + UnitConvertor3.convertCelsiusToFarhenheit(37) + " °F");

        System.out.println("150 pounds = " + UnitConvertor3.convertPoundsToKilograms(150) + " kg");
        System.out.println("70 kg = " + UnitConvertor3.convertKilogramsToPounds(70) + " pounds");

        System.out.println("5 gallons = " + UnitConvertor3.convertGallonsToLiters(5) + " liters");
        System.out.println("10 liters = " + UnitConvertor3.convertLitersToGallons(10) + " gallons");
	}

	/**
     * Converts Fahrenheit to Celsius
     */
    public static double convertFarhenheitToCelsius(double farhenheit) {
        double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
        return farhenheit2celsius;
    }

    /**
     * Converts Celsius to Fahrenheit
     */
    public static double convertCelsiusToFarhenheit(double celsius) {
        double celsius2farhenheit = (celsius * 9 / 5) + 32;
        return celsius2farhenheit;
    }

    /**
     * Converts Pounds to Kilograms
     */
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    /**
     * Converts Kilograms to Pounds
     */
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    /**
     * Converts Gallons to Liters
     */
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    /**
     * Converts Liters to Gallons
     */
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

}
