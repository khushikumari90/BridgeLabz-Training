package Encapsulation;
//Interface
interface GPS {
 void updateLocation(String location);
 String getCurrentLocation();
}

//Abstract class
abstract class Vehicle {
 protected int vehicleId;
 protected String driverName;
 protected double ratePerKm;
 private String location; // encapsulation

 public Vehicle(int id, String driver, double rate) {
     vehicleId = id;
     driverName = driver;
     ratePerKm = rate;
 }

 abstract double calculateFare(double distance);

 public void getVehicleDetails() {
     System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName);
 }

 protected void setLocation(String loc) {
     location = loc;
 }

 protected String getLocation() {
     return location;
 }
}

class Car extends Vehicle implements GPS {
 public Car(int id, String driver) {
     super(id, driver, 15);
 }

 public double calculateFare(double distance) {
     return distance * ratePerKm;
 }

 public void updateLocation(String location) {
     setLocation(location);
 }

 public String getCurrentLocation() {
     return getLocation();
 }
}

class Bike extends Vehicle {
 public Bike(int id, String driver) {
     super(id, driver, 8);
 }

 public double calculateFare(double distance) {
     return distance * ratePerKm;
 }
}

//Test
public class RideTest {
 public static void main(String[] args) {
     Vehicle v = new Car(201, "Amit");
     v.getVehicleDetails();
     System.out.println("Fare: ₹" + v.calculateFare(10));
 }
}
