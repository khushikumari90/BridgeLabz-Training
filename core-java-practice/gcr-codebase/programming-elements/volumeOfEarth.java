//Write a Program to compute the volume of Earth in km^3 and miles^3
package programmingelements;

public class volumeOfEarth {

	public static void main(String[] args) {
		 // Radius of Earth in kilometers
        double radiusKm = 6378;

        // Value of Pi
        double pi = Math.PI;

        // Formula to calculate volume of a sphere: (4/3) * pi * r^3
        double volumeKm = (4.0 / 3.0) * pi * radiusKm * radiusKm * radiusKm;

        // Conversion factor: 1 km = 0.621371 miles
        // So, 1 km^3 = (0.621371)^3 miles^3
        double conversionFactor = Math.pow(0.621371, 3);

        // Convert volume from km^3 to miles^3
        double volumeMiles = volumeKm * conversionFactor;

        // Print the result
        System.out.println("The volume of earth in cubic kilometers is "  + volumeKm + " and cubic miles is " + volumeMiles);

	}

}
