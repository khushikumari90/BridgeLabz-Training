//Problem 3: Vehicle Registration
package constructor;
public class Vehicle {

    // Instance variables (unique for each vehicle)
    String ownerName;
    String vehicleType;

    // Class variable (common for all vehicles)
    static double registrationFee = 1500.0;

    // Parameterized constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    void displayVehicleDetails() {
        System.out.println("Owner Name        : " + ownerName);
        System.out.println("Vehicle Type      : " + vehicleType);
        System.out.println("Registration Fee  : ₹" + registrationFee);
        System.out.println("----------------------------------");
    }

    // Class (static) method to update registration fee
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Main method to test the class
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Amit", "Car");
        Vehicle v2 = new Vehicle("Neha", "Bike");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        // Update registration fee for all vehicles
        Vehicle.updateRegistrationFee(2000.0);

        System.out.println("\nAfter Updating Registration Fee:\n");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
