package multi_vehicle_rental_system;

public class RentalApp {
    public static void main(String args[]) {
    	Vehicle cars=new Cars();
    	Vehicle bikes=new Bikes();
    	Vehicle buses=new Buses();
    	cars.rent();
    	cars.returnVehicle();
    	bikes.rent();
    	bikes.returnVehicle();
    	buses.rent();
    	buses.returnVehicle();
    }
}
