package SmartVehicleDashboard;
class ElectricCar implements VehicleDashboard {

    @Override
    public void displaySpeed() {
        System.out.println("Speed: 90 km/h");
    }

    @Override
    public void displayBatteryPercentage() {
        System.out.println("Battery: 65%");
    }
}
