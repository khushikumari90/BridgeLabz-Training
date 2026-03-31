//Extend or Create a UnitConvertor utility class similar to the one shown in the notes to do the following.  Please define static methods for all the UnitConvertor class methods.
package methods;

public class UnitConvertor2 {

	public static void main(String[] args) {

        System.out.println("5 yards = " + UnitConvertor.convertYardsToFeet(5) + " feet");
        System.out.println("12 feet = " + UnitConvertor.convertFeetToYards(12) + " yards");
        System.out.println("2 meters = " + UnitConvertor.convertMetersToInches(2) + " inches");
        System.out.println("10 inches = " + UnitConvertor.convertInchesToMeters(10) + " meters");
        System.out.println("8 inches = " + UnitConvertor.convertInchesToCentimeters(8) + " cm");
	}
	/**
	 * UnitConvertor utility class
	 * Contains static methods to convert between different units
	 */
	public class UnitConvertor {

	    /**
	     * Converts yards to feet
	     * 1 yard = 3 feet
	     */
	    public static double convertYardsToFeet(double yards) {
	        double yards2feet = 3;
	        return yards * yards2feet;
	    }

	    /**
	     * Converts feet to yards
	     * 1 foot = 0.333333 yards
	     */
	    public static double convertFeetToYards(double feet) {
	        double feet2yards = 0.333333;
	        return feet * feet2yards;
	    }

	    /**
	     * Converts meters to inches
	     * 1 meter = 39.3701 inches
	     */
	    public static double convertMetersToInches(double meters) {
	        double meters2inches = 39.3701;
	        return meters * meters2inches;
	    }

	    /**
	     * Converts inches to meters
	     * 1 inch = 0.0254 meters
	     */
	    public static double convertInchesToMeters(double inches) {
	        double inches2meters = 0.0254;
	        return inches * inches2meters;
	    }

	    /**
	     * Converts inches to centimeters
	     * 1 inch = 2.54 centimeters
	     */
	    public static double convertInchesToCentimeters(double inches) {
	        double inches2cm = 2.54;
	        return inches * inches2cm;
	    }
	}
    
}
