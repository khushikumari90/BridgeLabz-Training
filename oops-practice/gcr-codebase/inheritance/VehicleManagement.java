//Vechicle Management System with Hybrid Inheritance
package inheritance;
//Superclass
class Vehicle {
 int maxSpeed;
 String model;

 Vehicle(String model, int maxSpeed) {
     this.model = model;
     this.maxSpeed = maxSpeed;
 }
}

//Interface
interface Refuelable {
 void refuel();
}

//Subclass ElectricVehicle
class ElectricVehicle extends Vehicle {

 ElectricVehicle(String model, int maxSpeed) {
     super(model, maxSpeed);
 }

 void charge() {
     System.out.println(model + " is charging.");
 }
}

//Subclass PetrolVehicle
class PetrolVehicle extends Vehicle implements Refuelable {

 PetrolVehicle(String model, int maxSpeed) {
     super(model, maxSpeed);
 }

 @Override
 public void refuel() {
     System.out.println(model + " is refueling petrol.");
 }
}

//Main class
public class VehicleManagement {
 public static void main(String[] args) {
     ElectricVehicle ev = new ElectricVehicle("Tesla", 200);
     PetrolVehicle pv = new PetrolVehicle("Honda City", 180);

     ev.charge();
     pv.refuel();
 }
}
