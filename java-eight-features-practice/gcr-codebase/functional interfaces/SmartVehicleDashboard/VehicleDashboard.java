package SmartVehicleDashboard;
interface VehicleDashboard {

    void displaySpeed();

    // New feature added later (optional for vehicles)
    default void displayBatteryPercentage() {
        System.out.println("Battery information not available for this vehicle");
    }
}
