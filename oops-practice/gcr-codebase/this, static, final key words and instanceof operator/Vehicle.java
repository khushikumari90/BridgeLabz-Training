//Program 6:Vehicle Registration System
package keyword;
public class Vehicle {

    static double registrationFee = 150.0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    void displayVehicle(Object obj) {
        if (obj instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Honest raj", "Sedan", "ABC123");
        Vehicle v2 = new Vehicle("Price danish", "SUV", "XYZ789");

        v1.displayVehicle(v1);
        v2.displayVehicle(v2);
    }
}

