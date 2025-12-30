//Extend or Create a UnitConvertor utility class similar to the one shown in the notes to do the following.  Please define static methods for all the UnitConvertor class methods
package methods;

public class UnitConvertor {

	public static void main(String[] args) {
		  System.out.println("10 km in miles: " + UnitConvertor.convertKmToMiles(10));
	        System.out.println("5 miles in km: " + UnitConvertor.convertMilesToKm(5));
	        System.out.println("3 meters in feet: " + UnitConvertor.convertMetersToFeet(3));
	        System.out.println("10 feet in meters: " + UnitConvertor.convertFeetToMeters(10));

	}
	    // Convert kilometers to miles
	    public static double convertKmToMiles(double km) {
	        double km2miles = 0.621371;
	        return km * km2miles;
	    }

	    // Convert miles to kilometers
	    public static double convertMilesToKm(double miles) {
	        double miles2km = 1.60934;
	        return miles * miles2km;
	    }

	    // Convert meters to feet
	    public static double convertMetersToFeet(double meters) {
	        double meters2feet = 3.28084;
	        return meters * meters2feet;
	    }

	    // Convert feet to meters
	    public static double convertFeetToMeters(double feet) {
	        double feet2meters = 0.3048;
	        return feet * feet2meters;
	    }

}
