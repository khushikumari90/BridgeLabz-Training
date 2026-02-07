package SmartVehicleDashboard;
public class DashboardApp {
    public static void main(String[] args) {

        VehicleDashboard car1 = new PetrolCar();
        VehicleDashboard car2 = new ElectricCar();

        car1.displaySpeed();
        car1.displayBatteryPercentage(); // default message

        car2.displaySpeed();
        car2.displayBatteryPercentage(); // overridden
    }
}

