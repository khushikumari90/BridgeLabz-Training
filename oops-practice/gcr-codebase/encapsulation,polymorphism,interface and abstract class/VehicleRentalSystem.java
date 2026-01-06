//Design a system to manage vehicle rentals
package Encapsulation;
import java.util.ArrayList;

//Interface
interface Insurable {
 double calculateInsurance();
 String getInsuranceDetails();
}

//Abstract class
abstract class Vehicle {
 private String vehicleNumber;
 private String type;
 private double rentalRate;

 // Sensitive data (encapsulation)
 private String insurancePolicyNumber;

 public Vehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
     this.vehicleNumber = vehicleNumber;
     this.type = type;
     this.rentalRate = rentalRate;
     this.insurancePolicyNumber = policyNumber;
 }

 // Getters (no direct access to sensitive data)
 public String getVehicleNumber() {
     return vehicleNumber;
 }

 public String getType() {
     return type;
 }

 public double getRentalRate() {
     return rentalRate;
 }

 // Abstract method
 public abstract double calculateRentalCost(int days);
}

//Car class
class Car extends Vehicle implements Insurable {

 public Car(String number, double rate, String policy) {
     super(number, "Car", rate, policy);
 }

 public double calculateRentalCost(int days) {
     return getRentalRate() * days;
 }

 public double calculateInsurance() {
     return 500; // fixed insurance
 }

 public String getInsuranceDetails() {
     return "Car Insurance: ₹500";
 }
}

//Bike class
class Bike extends Vehicle implements Insurable {

 public Bike(String number, double rate, String policy) {
     super(number, "Bike", rate, policy);
 }

 public double calculateRentalCost(int days) {
     return getRentalRate() * days;
 }

 public double calculateInsurance() {
     return 200;
 }

 public String getInsuranceDetails() {
     return "Bike Insurance: ₹200";
 }
}

//Truck class
class Truck extends Vehicle implements Insurable {

 public Truck(String number, double rate, String policy) {
     super(number, "Truck", rate, policy);
 }

 public double calculateRentalCost(int days) {
     return (getRentalRate() * days) + 1000; // extra loading charge
 }

 public double calculateInsurance() {
     return 1000;
 }

 public String getInsuranceDetails() {
     return "Truck Insurance: ₹1000";
 }
}

//Main class
public class VehicleRentalSystem {
 public static void main(String[] args) {

     ArrayList<Vehicle> vehicles = new ArrayList<>();

     vehicles.add(new Car("CAR101", 1500, "CAR-INS-1"));
     vehicles.add(new Bike("BIKE202", 500, "BIKE-INS-2"));
     vehicles.add(new Truck("TRUCK303", 3000, "TRUCK-INS-3"));

     int days = 3;

     // Polymorphism
     for (Vehicle v : vehicles) {
         double rentalCost = v.calculateRentalCost(days);
         double insuranceCost = ((Insurable) v).calculateInsurance();

         System.out.println("Vehicle Type: " + v.getType());
         System.out.println("Rental Cost: " + rentalCost);
         System.out.println("Insurance Cost: " + insuranceCost);
         System.out.println("------------------------");
     }
 }
}

