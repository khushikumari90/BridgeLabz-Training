package multi_vehicle_rental_system;

class Cars implements Vehicle {
    @Override
    public void rent() {
    	System.out.println("Car has been rented.");
    }
    @Override
    public void returnVehicle() {
    	System.out.println("Car has been returned.");
    }
}
