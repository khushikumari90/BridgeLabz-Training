package multi_vehicle_rental_system;

class Bikes implements Vehicle {
	@Override
    public void rent() {
    	System.out.println("Bike has been rented.");
    }
    @Override
    public void returnVehicle() {
    	System.out.println("Bike has been returned.");
    }

}
